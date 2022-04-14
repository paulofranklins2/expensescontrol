package com.expensescontrol.response;

import com.expensescontrol.model.Despesa;
import com.expensescontrol.repository.DespesaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DespesaResponse {
    private String descricao;
    private BigDecimal valor;
    private LocalDate data;

    public DespesaResponse(Despesa despesa) {
        this.descricao = despesa.getDecricao();
        this.valor = despesa.getValor();
        this.data = despesa.getData();
    }

    public static List<DespesaResponse> converterDespesaParaDespesaLista(List<Despesa> despesas) {
        return despesas.stream().map(DespesaResponse::new).collect(Collectors.toList());
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}

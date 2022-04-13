package com.expensescontrol.response;

import com.expensescontrol.model.Receita;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ReceitaResponse {
    private String descricao;
    private BigDecimal valor;
    private LocalDate data;

    public ReceitaResponse(Receita receitas) {
        this.descricao = receitas.getDescricao();
        this.valor = receitas.getValor();
        this.data = receitas.getData();
    }

    public static List<ReceitaResponse> converteReceitaParaReceitaLista(List<Receita> receitas) {
        return receitas.stream().map(ReceitaResponse::new).collect(Collectors.toList());
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}

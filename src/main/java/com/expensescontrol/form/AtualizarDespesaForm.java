package com.expensescontrol.form;

import com.expensescontrol.model.Despesa;
import com.expensescontrol.repository.DespesaRepository;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AtualizarDespesaForm {

    @NotEmpty
    private String descricao;
    @NotNull
    @Negative
    private BigDecimal valor;
    private LocalDate data;

    public Despesa atualizar(Long id, DespesaRepository despesaRepository) {
        Despesa despesa = despesaRepository.getById(id);
        this.descricao = despesa.getDecricao();
        this.valor = despesa.getValor();
        this.data = despesa.getData();
        return despesa;
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

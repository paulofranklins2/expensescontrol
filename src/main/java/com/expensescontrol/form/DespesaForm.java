package com.expensescontrol.form;

import com.expensescontrol.model.Despesa;
import com.expensescontrol.repository.DespesaRepository;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public class DespesaForm {

    @NotEmpty
    private String descricao;
    @NotNull
    @Negative
    private BigDecimal valor;
    private LocalDate data;

    public Despesa converter(DespesaRepository despesaRepository) {
        if (data == null) {
            this.data = LocalDate.now();
        }
        return new Despesa(descricao, valor, data);
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

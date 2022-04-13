package com.expensescontrol.response;

import com.expensescontrol.model.Receita;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ReceitaResponse {
    private String descricao;
    private BigDecimal valor;
    private LocalDate data;

    public ReceitaResponse(Receita receitas) {
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

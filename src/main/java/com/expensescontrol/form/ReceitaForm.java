package com.expensescontrol.form;

import com.expensescontrol.model.Receita;
import com.expensescontrol.repository.ReceitaRepository;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ReceitaForm {
    @NotEmpty
    private String descricao;
    @NotNull
    @Positive
    private BigDecimal valor;
    private LocalDate data;

    public Receita converter(ReceitaRepository receitaRepository) {
        if (data == null) {
            data = LocalDate.now();
        }
        return new Receita(descricao, valor, data);
    }

    public LocalDate getData() {
        return data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

}

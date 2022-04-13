package com.expensescontrol.form;

import com.expensescontrol.model.Receita;
import com.expensescontrol.repository.ReceitaRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AtualizarReceitaForm {

    @NotEmpty
    private String descricao;
    @NotNull
    @Positive
    private BigDecimal valor;
    private LocalDate data;

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

    public Receita atualizar(Long id, ReceitaRepository receitaRepository) {
        Receita receita = receitaRepository.getOne(id);
        receita.setDescricao(this.descricao);
        receita.setValor(this.getValor());
        receita.setData(this.data);
        return receita;
    }
}

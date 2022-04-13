package com.expensescontrol.form;

import com.expensescontrol.model.Receita;
import com.expensescontrol.repository.ReceitaRepository;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ReceitaForm {
    @NotEmpty
    private String descricao;
    @NotEmpty
    private BigDecimal valor;
    @NotEmpty
    private LocalDate data;


    public Receita converter(ReceitaRepository receitaRepository) {
        return new Receita(descricao,valor,data);
    }
}

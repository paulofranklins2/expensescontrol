package com.expensescontrol.form;

import com.expensescontrol.model.Despesa;
import com.expensescontrol.repository.DespesaRepository;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;

public class DespesaForm {

    @NotEmpty
    private String descricao;
    @NotEmpty
    private BigDecimal valor;
//    @NotEmpty
    private LocalDate data;

    public Despesa converter(DespesaRepository despesaRepository){
        return new Despesa(descricao,valor,data);
    }
}

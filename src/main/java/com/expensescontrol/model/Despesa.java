package com.expensescontrol.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String decricao;
    private BigDecimal valor;
    private LocalDate data;

    public Despesa() {
    }

    public Despesa(String descricao, BigDecimal valor, LocalDate data) {
        this.decricao = descricao;
        this.valor = valor;
        this.data = data;
    }

}

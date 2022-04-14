package com.expensescontrol.repository;

import com.expensescontrol.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {


}

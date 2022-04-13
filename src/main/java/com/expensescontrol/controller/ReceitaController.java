package com.expensescontrol.controller;

import com.expensescontrol.form.ReceitaForm;
import com.expensescontrol.model.Receita;
import com.expensescontrol.repository.ReceitaRepository;
import com.expensescontrol.response.ReceitaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

    @Autowired
    private ReceitaRepository receitaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<ReceitaResponse> adicionar(@RequestBody @Valid ReceitaForm receitaForm){
        Receita receitas = receitaForm.converter(receitaRepository);
        receitas = receitaRepository.save(receitas);

        return ResponseEntity.ok(new ReceitaResponse(receitas));
    }

}

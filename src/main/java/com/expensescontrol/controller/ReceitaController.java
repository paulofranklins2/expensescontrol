package com.expensescontrol.controller;

import com.expensescontrol.form.AtualizarReceitaForm;
import com.expensescontrol.form.ReceitaForm;
import com.expensescontrol.model.Receita;
import com.expensescontrol.repository.ReceitaRepository;
import com.expensescontrol.response.ReceitaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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
    public ResponseEntity<ReceitaResponse> adicionar(@RequestBody @Valid ReceitaForm receitaForm, UriComponentsBuilder uriBuilder) {
        Receita receitas = receitaForm.converter(receitaRepository);
        receitas = receitaRepository.save(receitas);


//        URI uri = uriBuilder.path("/receita/{id}").buildAndExpand(receitas.getId()).toUri();
//        return ResponseEntity.created(uri).body(new ReceitaResponse(receitas));
        return ResponseEntity.ok(new ReceitaResponse(receitas));
    }

    @GetMapping("/{id}")
    public ReceitaResponse receitaDetalhada(@PathVariable Long id) {
        Receita receitas = receitaRepository.getOne(id);
        return new ReceitaResponse(receitas);
    }

    @GetMapping
    public List<ReceitaResponse> buscarTodos() {
        List<Receita> receitas = receitaRepository.findAll();
        return ReceitaResponse.converteReceitaParaReceitaLista(receitas);

    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<ReceitaResponse> excluir(@PathVariable Long id) {
        receitaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ReceitaResponse> atualizar(@PathVariable @Valid Long id, AtualizarReceitaForm form) {
        Receita receita = form.atualizar(id, receitaRepository);
        return ResponseEntity.ok(new ReceitaResponse(receita));
    }


}

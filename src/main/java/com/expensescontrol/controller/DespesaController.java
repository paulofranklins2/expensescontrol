package com.expensescontrol.controller;

import com.expensescontrol.form.AtualizarDespesaForm;
import com.expensescontrol.form.DespesaForm;
import com.expensescontrol.model.Despesa;
import com.expensescontrol.repository.DespesaRepository;
import com.expensescontrol.response.DespesaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/despesa")
public class DespesaController {

    @Autowired
    private DespesaRepository despesaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DespesaResponse> adicionar(@RequestBody @Valid DespesaForm despesaForm, UriComponentsBuilder uriBuilder) {
        Despesa despesas = despesaForm.converter(despesaRepository);
        despesas = despesaRepository.save(despesas);

        return ResponseEntity.ok(new DespesaResponse(despesas));
    }

    @GetMapping("/{id}")
    public DespesaResponse DespesaDetalhada(@PathVariable Long id) {
        Despesa despesas = despesaRepository.getById(id);
        return new DespesaResponse(despesas);

    }

    @GetMapping
    public List<DespesaResponse> buscarTodos() {
        List<Despesa> despesas = despesaRepository.findAll();
        return DespesaResponse.converterDespesaParaDespesaLista(despesas);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DespesaResponse> deletar(@PathVariable Long id) {
        despesaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DespesaResponse> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarDespesaForm atualizarDespesaForm) {
        Despesa despesa = atualizarDespesaForm.atualizar(id, despesaRepository);
        return ResponseEntity.ok(new DespesaResponse(despesa));

    }

}

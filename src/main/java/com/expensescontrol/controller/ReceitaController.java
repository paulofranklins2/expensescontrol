package com.expensescontrol.controller;

import com.expensescontrol.form.AtualizarReceitaForm;
import com.expensescontrol.form.ReceitaForm;
import com.expensescontrol.model.Receita;
import com.expensescontrol.repository.ReceitaRepository;
import com.expensescontrol.response.ReceitaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
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
    public void adicionar(@RequestBody @Valid ReceitaForm receitaForm) {
        Receita receitas = receitaForm.converter(receitaRepository);
        receitas = receitaRepository.save(receitas);
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
    public void excluir(@PathVariable Long id) {
        if (receitaRepository.getById(id) != null) {
            receitaRepository.deleteById(id);
        }
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public void handleEmptyResultDataAccessException(EmptyResultDataAccessException ex) {
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ReceitaResponse> atualizar(@PathVariable Long id, @Valid AtualizarReceitaForm atualizarReceitaForm) {
        Receita receita = atualizarReceitaForm.atualizar(id, receitaRepository);
        return ResponseEntity.ok(new ReceitaResponse(receita));
    }

//    @PutMapping("/{id}")
//    @Transactional
//    public void atualizar(@PathVariable Long id, @Valid AtualizarReceitaForm atualizarReceitaForm) {
//        if (receitaRepository.getById(id) != null) {
//            Receita receita = atualizarReceitaForm.atualizar(id, receitaRepository);
//        }
//    }


}

package com.weg.estrutura.pedagogica.Controller;

import com.weg.estrutura.pedagogica.Dto.Requisicao.ProdutoRequisicaoDto;
import com.weg.estrutura.pedagogica.Dto.Resposta.ProdutoRespostaDto;
import com.weg.estrutura.pedagogica.Service.ProdutoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoRespostaDto>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<ProdutoRespostaDto>> listarPorCategoria(@PathVariable Long id) {
        return ResponseEntity.ok(service.listarPorCategoria(id));
    }

    @GetMapping("/nome")
    public ResponseEntity<List<ProdutoRespostaDto>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(service.buscarPorNome(nome));
    }

    @GetMapping("/busca")
    public ResponseEntity<Optional<ProdutoRespostaDto>> buscarPorIdENome(
            @RequestParam Long id,
            @RequestParam String nome) {
        return ResponseEntity.ok(service.buscarPorIdENome(id, nome));
    }

    @GetMapping("/categoria/nome")
    public ResponseEntity<List<ProdutoRespostaDto>> buscarPorNomeCategoria(
            @RequestParam String nome) {
        return ResponseEntity.ok(service.buscarPorNomeCategoria(nome));
    }
}
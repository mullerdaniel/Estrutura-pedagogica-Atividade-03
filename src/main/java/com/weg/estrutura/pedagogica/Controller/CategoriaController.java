package com.weg.estrutura.pedagogica.Controller;

import com.weg.estrutura.pedagogica.Dto.Requisicao.CategoriaRequisicaoDto;
import com.weg.estrutura.pedagogica.Dto.Resposta.CategoriaRespostaDto;
import com.weg.estrutura.pedagogica.Service.CategoriaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CategoriaRespostaDto> cadastrar(@RequestBody CategoriaRequisicaoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.cadastrar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaRespostaDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarDtoPorId(id));
    }
}
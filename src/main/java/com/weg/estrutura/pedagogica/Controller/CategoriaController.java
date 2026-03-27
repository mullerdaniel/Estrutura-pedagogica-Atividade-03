package com.weg.estrutura.pedagogica.Controller;

import com.weg.estrutura.pedagogica.Dto.Requisicao.CategoriaRequisicaoDto;
import com.weg.estrutura.pedagogica.Dto.Resposta.CategoriaRespostaDto;
import com.weg.estrutura.pedagogica.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @PostMapping
    public CategoriaRespostaDto cadastrar(@RequestBody CategoriaRequisicaoDto dto) {
        return service.cadastrar(dto);
    }

    @GetMapping("/{id}")
    public CategoriaRespostaDto buscarPorId(@PathVariable Long id) {
        return service.buscarDtoPorId(id);
    }
}
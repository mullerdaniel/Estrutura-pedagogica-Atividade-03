package com.weg.estrutura.pedagogica.Dto.Resposta;

import com.weg.estrutura.pedagogica.Model.Categoria;

public class CategoriaRespostaDto {

    private Long id;
    private String nome;

    public CategoriaRespostaDto(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
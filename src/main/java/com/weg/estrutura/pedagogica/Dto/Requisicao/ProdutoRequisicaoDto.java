package com.weg.estrutura.pedagogica.Dto.Requisicao;

public class ProdutoRequisicaoDto {

    private String nome;
    private Double preco;
    private Long categoriaId;

    public ProdutoRequisicaoDto() {
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}
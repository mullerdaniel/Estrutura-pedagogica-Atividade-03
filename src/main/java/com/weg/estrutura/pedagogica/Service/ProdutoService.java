package com.weg.estrutura.pedagogica.Service;


import com.weg.estrutura.pedagogica.Model.Produto;

public class ProdutoService {

    private Long id;
    private String nome;
    private Double preco;
    private String nomeCategoria;

    public ProdutoService(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.nomeCategoria = produto.getCategoria().getNome();
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public Double getPreco() { return preco; }
    public String getNomeCategoria() { return nomeCategoria; }
}
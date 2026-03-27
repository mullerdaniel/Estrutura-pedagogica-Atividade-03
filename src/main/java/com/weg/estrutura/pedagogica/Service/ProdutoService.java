package com.weg.estrutura.pedagogica.Service;

import com.weg.estrutura.pedagogica.Dto.Requisicao.ProdutoRequisicaoDto;
import com.weg.estrutura.pedagogica.Dto.Resposta.ProdutoRespostaDto;
import com.weg.estrutura.pedagogica.Model.Categoria;
import com.weg.estrutura.pedagogica.Model.Produto;
import com.weg.estrutura.pedagogica.Repository.CategoriaRepository;
import com.weg.estrutura.pedagogica.Repository.ProdutoRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository,
                          CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<ProdutoRespostaDto> listarTodos() {
        return produtoRepository.findAll()
                .stream()
                .map(ProdutoRespostaDto::new)
                .toList();
    }

    public List<ProdutoRespostaDto> listarPorCategoria(Long categoriaId) {
        return produtoRepository.findByCategoriaId(categoriaId)
                .stream()
                .map(ProdutoRespostaDto::new)
                .toList();
    }

    public List<ProdutoRespostaDto> buscarPorNome(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(ProdutoRespostaDto::new)
                .toList();
    }

    public Optional<ProdutoRespostaDto> buscarPorIdENome(Long id, String nome) {
        return produtoRepository.findByIdAndNome(id, nome)
                .map(ProdutoRespostaDto::new);
    }

    public List<ProdutoRespostaDto> buscarPorNomeCategoria(String nomeCategoria) {
        return produtoRepository.findByCategoriaNomeContainingIgnoreCase(nomeCategoria)
                .stream()
                .map(ProdutoRespostaDto::new)
                .toList();
    }
}
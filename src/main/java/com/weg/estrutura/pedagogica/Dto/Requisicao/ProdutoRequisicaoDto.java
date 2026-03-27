package com.weg.estrutura.pedagogica.Dto.Requisicao;

import com.weg.estrutura.pedagogica.Dto.Resposta.ProdutoRespostaDto;
import com.weg.estrutura.pedagogica.Model.Categoria;
import com.weg.estrutura.pedagogica.Model.Produto;
import com.weg.estrutura.pedagogica.Repository.CategoriaRepository;
import com.weg.estrutura.pedagogica.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public ProdutoRespostaDto cadastrar(ProdutoRequisicaoDto dto) {

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setCategoria(categoria);

        return new ProdutoRespostaDto(produtoRepository.save(produto));
    }

    public List<ProdutoRespostaDto> listarTodos() {
        return produtoRepository.findAll()
                .stream()
                .map(ProdutoRespostaDto::new)
                .collect(Collectors.toList());
    }

    public List<ProdutoRespostaDto> listarPorCategoria(Long categoriaId) {
        return produtoRepository.findByCategoriaId(categoriaId)
                .stream()
                .map(ProdutoRespostaDto::new)
                .collect(Collectors.toList());
    }

    public List<ProdutoRespostaDto> buscarPorNome(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(ProdutoRespostaDto::new)
                .collect(Collectors.toList());
    }

    public Optional<ProdutoRespostaDto> buscarPorIdENome(Long id, String nome) {
        return produtoRepository.findByIdAndNome(id, nome)
                .map(ProdutoRespostaDto::new);
    }

    public List<ProdutoRespostaDto> buscarPorNomeCategoria(String nomeCategoria) {
        return produtoRepository.findByCategoriaNomeContainingIgnoreCase(nomeCategoria)
                .stream()
                .map(ProdutoRespostaDto::new)
                .collect(Collectors.toList());
    }
}
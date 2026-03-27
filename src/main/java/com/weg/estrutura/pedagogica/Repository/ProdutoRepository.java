package com.weg.estrutura.pedagogica.Repository;

import com.weg.estrutura.pedagogica.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByCategoriaId(Long categoriaId);

    List<Produto> findByNomeContainingIgnoreCase(String nome);

    Optional<Produto> findByIdAndNome(Long id, String nome);

    List<Produto> findByCategoriaNomeContainingIgnoreCase(String nomeCategoria);
}
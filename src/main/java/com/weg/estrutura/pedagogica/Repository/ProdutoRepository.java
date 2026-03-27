package com.weg.estrutura.pedagogica.Repository;

import com.weg.estrutura.pedagogica.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

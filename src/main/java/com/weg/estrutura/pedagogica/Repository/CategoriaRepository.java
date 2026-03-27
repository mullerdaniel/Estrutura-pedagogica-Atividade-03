package com.weg.estrutura.pedagogica.Repository;

import com.weg.estrutura.pedagogica.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}

package br.com.olindo.estoquelivraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.olindo.estoquelivraria.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}

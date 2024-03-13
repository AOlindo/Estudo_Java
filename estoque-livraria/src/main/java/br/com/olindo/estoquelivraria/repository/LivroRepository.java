package br.com.olindo.estoquelivraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.olindo.estoquelivraria.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}

package br.com.olindo.estoquelivraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.olindo.estoquelivraria.model.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long>{

	@Query("select e from Estoque e where e.livro.id= :idLivro")
	Estoque buscarEstoquePeloIdLivro(Long idLivro);
}

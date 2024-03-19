package br.com.olindo.estoquelivraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.olindo.estoquelivraria.model.Categoria;
import br.com.olindo.estoquelivraria.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{

}

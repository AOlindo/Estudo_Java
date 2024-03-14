package br.com.olindo.estoquelivraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.olindo.estoquelivraria.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{

}

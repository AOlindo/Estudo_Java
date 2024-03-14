package br.com.olindo.estoquelivraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.olindo.estoquelivraria.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}

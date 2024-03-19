package br.com.olindo.estoquelivraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.olindo.estoquelivraria.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}

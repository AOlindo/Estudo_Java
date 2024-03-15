package br.com.olindo.estoquelivraria.model;

import br.com.olindo.estoquelivraria.dto.CadastroEnderecoDto;
import br.com.olindo.estoquelivraria.dto.ClienteDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente extends DadosPessoais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
	public Cliente() {
		
	}
	public Cliente(String nome, String telefone, String email, CadastroEnderecoDto endereco) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = new Endereco(endereco);
	}

	public Cliente(ClienteDto dto) {
		super();
		this.nome = dto.getNome();
		this.telefone = dto.getTelefone();
		this.email = dto.getEmail();
		this.endereco = new Endereco(dto.getEndereco());

	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}

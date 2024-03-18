package br.com.olindo.estoquelivraria.model;

import br.com.olindo.estoquelivraria.dto.CadastroEnderecoDto;
import br.com.olindo.estoquelivraria.dto.FornecedorDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fornecedor")
public class Fornecedor extends DadosPessoais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	public Fornecedor() {
		
	}
	
	public Fornecedor(String nome, String telefone, String email, CadastroEnderecoDto endereco) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = new Endereco(endereco);
	}

	public Fornecedor(FornecedorDto dto) {
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

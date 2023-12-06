package screenmatch;

import screenmatch.exceptions.ErroDeConversaoDeAnoException;

public class Titulo implements Comparable<Titulo> {

	private String nome;
	private int anoDeLancamento;
	private boolean incluidoNoPlano;
	private double somaDasAvaliacoes;
	private int totalDeAvaliacoes;
	private int duracaoEmMinutos;

	public Titulo() {

	}

	public Titulo(String nome, int anoDeLancamento) {
		this.nome = nome;
		this.anoDeLancamento = anoDeLancamento;
	}
	
	public Titulo(TituloOmdb meuTituloOmdb) {
		this.nome = meuTituloOmdb.title();
		if(meuTituloOmdb.year().length() > 4) {
			throw new ErroDeConversaoDeAnoException("Não consegui converter o ano porque tem mais de 04 caracteres");
		}
		this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
		this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 2));
	}
//  A maneira que eu fiz:
	
//	public Titulo(TituloOmdb meuTituloOmdb) {
//		this.nome = meuTituloOmdb.title();
//		try {
//			if (anoDeLancamento > 4) {
//				
//			}
//			this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 3));
//		} catch (NumberFormatException e) {
//			System.out.println("Erro no ano de lançamento: " + e.getMessage());;
//		}
		
	

	public void exibeFichaTecnica() {
		System.out.println("Nome: " + getNome());
		System.out.println("Ano de lançamento: " + getAnoDeLancamento());
		System.out.println("Tempo de duração: " + getDuracaoEmMinutos());
	}

	public void avalia(double nota) {
		somaDasAvaliacoes += nota;
		totalDeAvaliacoes++;

	}

	public double mediaDasAvaliacoes() {
		var media = somaDasAvaliacoes / totalDeAvaliacoes;
		return media;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public void setAnoDeLancamento(int anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}

	public boolean isIncluidoNoPlano() {
		return incluidoNoPlano;
	}

	public void setIncluidoNoPlano(boolean incluidoNoPlano) {
		this.incluidoNoPlano = incluidoNoPlano;
	}

	public double getSomaDasAvaliacoes() {
		return somaDasAvaliacoes;
	}

	public int getTotalDeAvaliacoes() {
		return totalDeAvaliacoes;
	}

	public int getDuracaoEmMinutos() {
		return duracaoEmMinutos;
	}

	public void setDuracaoEmMinutos(int duracaoEmMinutos) {
		this.duracaoEmMinutos = duracaoEmMinutos;
	}

	@Override
	public String toString() {
		return "Filme = " + nome + ", Ano de lançamento = " + anoDeLancamento + ", Duracao em minutos = "
				+ duracaoEmMinutos + "]";
	}

	@Override
	public int compareTo(Titulo outroTitulo) {
		return this.getNome().compareTo(outroTitulo.getNome());
	}

}

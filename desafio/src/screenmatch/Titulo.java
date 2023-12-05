package screenmatch;

import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{

	@SerializedName("Title")
	private String nome;
	@SerializedName("Year")
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
		this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
		this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 2));
	}

	public void exibeFichaTecnica() {
		System.out.println("Nome: " + getNome());
		System.out.println("Ano de lançamento: " + getAnoDeLancamento());
		System.out.println("Tempo de duração: "  + getDuracaoEmMinutos());
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
		return "Titulo [Nome = " + nome + ", Ano de lançamento = " + anoDeLancamento + ", Duracao em minutos = "
				+ duracaoEmMinutos + "]";
	}

	@Override
	public int compareTo(Titulo outroTitulo) {
		return this.getNome().compareTo(outroTitulo.getNome());
	}
	
	

}

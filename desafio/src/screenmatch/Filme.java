package screenmatch;

public class Filme extends Titulo implements Classificavel{

	private String diretor;
	
	public Filme(String nome, int anoDeLancamento) {
		super(nome, anoDeLancamento);

	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Filme = ");
		builder.append(this.getNome());
		builder.append(", ( ");
		builder.append(this.getAnoDeLancamento());
		builder.append(" )");
		return builder.toString();
	}

	@Override
	public int getClassificacao() {
		return (int) mediaDasAvaliacoes() / 2;
	}

	
	
	
	

	
	
	
	
	
}

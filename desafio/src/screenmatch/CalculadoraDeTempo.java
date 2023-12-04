package screenmatch;

public class CalculadoraDeTempo {

	private int tempoTotal;

	public int getTempoTotal() {
		return tempoTotal;
	}
	
	public void inclui(Titulo titulo) {
		System.out.println("Adicionando duração em minutos de " + titulo);
		tempoTotal +=  titulo.getDuracaoEmMinutos();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(tempoTotal);
		return builder.toString();
	}
	
	
}

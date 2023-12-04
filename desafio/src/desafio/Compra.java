package desafio;

public class Compra implements Comparable<Compra> {
	
	private String descricao;
    private double valor;
    
    public Compra(String descricao, double valor) {
            this.descricao = descricao;
            this.valor = valor;
    }

	public String getDescricao() {
		return descricao;
	}

	public double getValor() {
		return valor;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Compra [descricao = ");
		builder.append(descricao);
		builder.append(", valor = ");
		builder.append(valor);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Compra outraCompra) {
	 return Double.valueOf(this.valor).compareTo(Double.valueOf(outraCompra.valor));
	}
	
    

}

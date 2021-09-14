package entities;

public class PessoaFisica extends Pessoa {

	private Double gastosSaude;
	
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double renda, Double gastosSaude) {
		super(nome, renda);
		this.gastosSaude = gastosSaude;
	}

	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}
	
	@Override
	public double imposto() {
		if (getRenda() < 20000.00) {
			return getRenda() * 0.15 - gastosSaude * 0.5;
		}
		else {
			return getRenda() * 0.25 - gastosSaude * 0.5;
		}
	}
}

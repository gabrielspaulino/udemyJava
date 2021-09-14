package entities;

public class PessoaJuridica extends Pessoa {

	private Integer funcionarios;
	
	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, Double renda, Integer funcionarios) {
		super(nome, renda);
		this.funcionarios = funcionarios;
	}

	public Integer getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Integer funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public double imposto() {
		if (funcionarios > 10) {
			return getRenda() * 0.14;
		}
		
		else {
			return getRenda() * 0.16;
		}
	}
	
}

package cadastro;

public class Cadastro {

	private int conta;
	private String nome;
	private double saldo;

	public Cadastro(int conta, String nome, double depositoInicial) {
		this.conta = conta;
		this.nome = nome;
		depositar(depositoInicial);
	}

	public Cadastro(int conta, String nome) {
		this.conta = conta;
		this.nome = nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public int getConta() {
		return conta;
	}

	public String getSaldo() {
		return String.format("%.2f", saldo);
	}

	public void depositar(double deposito) {
		saldo += deposito;
	}

	public void sacar(double saque) {
		saldo -= (saque + 5);
	}

	public String toString() {
		return "Account " + getConta() + ", Holder: " + getNome() + ", Balance: $ " + getSaldo();
	}
}
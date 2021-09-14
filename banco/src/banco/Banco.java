package banco;

import cadastro.Cadastro;
import java.util.Locale;
import java.util.Scanner;

public class Banco {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Cadastro cadastro;

		System.out.print("Enter account number: ");
		int conta = sc.nextInt();
		System.out.print("Enter accout holder: ");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.print("Is there a initial deposit (y/n)? ");
		char inicial = sc.next().charAt(0);
		if (inicial == 'y') {
			System.out.print("Enter initial deposit value: ");
			double deposito = sc.nextDouble();
			cadastro = new Cadastro(conta, nome, deposito);
		} else {
			cadastro = new Cadastro(conta, nome);
		}
		System.out.println("\nAccount data:");
		System.out.println(cadastro);
		System.out.print("\nEnter a deposit value: ");
		double deposito = sc.nextDouble();
		cadastro.depositar(deposito);
		System.out.println("Updated account data:");
		System.out.println(cadastro);
		System.out.print("\nEnter a withdraw value: ");
		double saque = sc.nextDouble();
		cadastro.sacar(saque);
		System.out.println("Updated account data:");
		System.out.println(cadastro);
		sc.close();
	}

}
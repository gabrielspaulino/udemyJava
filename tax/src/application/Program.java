package application;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Pessoa> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		for(int x = 1; x <= n; x++) {
			System.out.println("Tax payer #" + x + " data:");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Anual income: ");
			Double renda = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				double gastosSaude = sc.nextDouble();
				list.add(new PessoaFisica(nome, renda, gastosSaude));
			}
			else if (ch == 'c') {
				System.out.print("Number of employees: ");
				int funcionarios = sc.nextInt();
				list.add(new PessoaJuridica(nome, renda, funcionarios));
			}
			else {
				System.out.println("Invalid type of payer");
			}
		}
		
		double total = 0;
		System.out.println("\nTAXES PAID:");
		for(Pessoa pessoa : list) {
			System.out.println(pessoa.getNome() + ": $ " + String.format("%.2f", pessoa.imposto()));
			total += pessoa.imposto();
		}
		
		System.out.println("\nTOTAL TAXES: $ " + String.format("%.2f", total));
	}
}

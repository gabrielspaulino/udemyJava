package funcionarios;

import java.util.Scanner;
import entities.Registros;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;

public class Funcionarios {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Integer> ids = new ArrayList<Integer>();

		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		Registros registro[] = new Registros[n];

		for (int i = 0; i < n; i++) {
			System.out.println("\nEmployee #" + (i + 1) + ":");
			int id;
			int teste;
			do {
				System.out.print("Id: ");
				id = sc.nextInt();
				teste = ids.indexOf(id);
			} while (teste != -1); //teste id repetido
			ids.add(id);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			registro[i] = new Registros(id, name, salary);
		}

		// aumento no salário
		System.out.print("\nEnter the employee id that will have the salary increase: ");
		int increaseId = sc.nextInt();
		int position = ids.indexOf(increaseId);
		if (position == -1) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextInt();
			registro[position].raise(percentage);
		}

		System.out.println("\nList of employees: ");
		for (int i = 0; i < n; i++) {
			System.out.println(registro[i]);
		}
		sc.close();
	}

}

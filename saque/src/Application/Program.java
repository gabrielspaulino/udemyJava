package Application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();
		Account account = new Account(number, holder, balance, withdrawLimit);

		try {
			System.out.print("\nEnter amount for withdraw: ");
			double amount = sc.nextDouble();
			account.withdraw(amount);
			System.out.print("New balance: " + account.getBalance());
		} catch (DomainException e) {
			System.out.print(e.getMessage());
		} catch (Exception e) {
			System.out.print("Unexpected error");
		}

		sc.close();
	}

}

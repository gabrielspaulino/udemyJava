package pedido;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

public class Pedido {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String birthDate = sc.next();
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.next();
		Date moment = new Date();
		Order order = new Order(moment, OrderStatus.valueOf(status), new Client(name, email, birthDate));
		System.out.print("How many items to this order? ");
		int quantity = sc.nextInt();
		for(int i = 0; i < quantity; i++) {
			System.out.println("Enter #" + (i + 1) + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			Product product = new Product(productName, price);
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			OrderItem item = new OrderItem(productQuantity, price, new Product(productName, price));
			order.addItem(item);
		}
		
		System.out.println(order);
		
		sc.close();
	}
}

package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> employees = new ArrayList<Employee>();
		
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				String email = fields[1];
				double salary = Double.parseDouble(fields[2]);
				employees.add(new Employee(name, email, salary));
				
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Erro: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		Comparator<String> comp = (e1, e2) -> e1.toUpperCase().compareTo(e2.toUpperCase());
		
		System.out.print("Enter salary: ");
		double salary = sc.nextDouble();
		List<String> list = employees.stream()
				.filter(s -> s.getSalary() >= salary)
				.map(p -> p.getEmail())
				.sorted(comp)
				.collect(Collectors.toList());
		System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary) + ":");
		for(String s : list) {
			System.out.println(s);
		}
		
		double sum = employees.stream()
				.filter(n -> n.getName().charAt(0) == 'M')
				.map(s -> s.getSalary())
				.reduce(0.0, (x,y) -> x + y);
		System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sum));
	}

}

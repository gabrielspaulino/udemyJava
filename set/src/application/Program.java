package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.Student;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<Student> students = new HashSet<Student>();
		
		System.out.print("How many students for course A? ");
		int total = sc.nextInt();
		int code;
		for(int i = 0; i<total; i++) {
			code = sc.nextInt();
			students.add(new Student(code));
		}
		
		System.out.print("How many students for course B? ");
		total = sc.nextInt();
		for(int i = 0; i<total; i++) {
			code = sc.nextInt();
			students.add(new Student(code));
		}
		
		System.out.print("How many students for course C? ");
		total = sc.nextInt();
		for(int i = 0; i<total; i++) {
			code = sc.nextInt();
			students.add(new Student(code));
		}
		
		System.out.println("Total students: " + students.size());
	}

}

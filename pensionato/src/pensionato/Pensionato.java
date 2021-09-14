package pensionato;

import java.util.Scanner;
import entities.Aluguel;

public class Pensionato {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        Aluguel aluguel[] = new Aluguel[10];
        
        do {
            System.out.print("How many rooms will be rented? ");
            n = sc.nextInt();
        } while (n < 1 || n > 10);
        
        for (int i = 0; i < n; i++) {
            System.out.println("\nRent #" + (i + 1) + ":");
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Room: ");
            int room = sc.nextInt();
            if (room >= 0 && room < 10) {
                aluguel[room] = new Aluguel(name, email, room);
            } else {
                System.out.println("Invalid room");
                i--;
            }
        }

        System.out.println("\nBusy rooms:");
        for (int i = 0; i < 10; i++) {
            if (aluguel[i] != null) {
                System.out.println(aluguel[i]);
            }
        }
    }

}
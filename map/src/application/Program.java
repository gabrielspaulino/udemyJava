package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> votes = new LinkedHashMap<>();
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(",");
				String candidate = fields[0];
				int votesNumber = Integer.parseInt(fields[1]);
				if(votes.containsKey(candidate))
				{
					int total = votes.get(candidate);
					votes.put(candidate, (total + votesNumber));
				}
				else
				{
					votes.put(candidate, votesNumber);
				}
				
				line = br.readLine();
			}
			
			for(String key : votes.keySet()) {
				System.out.println(key + ": " + votes.get(key));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

}

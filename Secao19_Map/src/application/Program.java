package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> votes = new TreeMap<>();	
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();

			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				int votesQuantity = Integer.parseInt(fields[1]);
				
				if (votes.containsKey(name)) {
					int aux = votes.get(name) + votesQuantity;
					votes.put(name, aux);
				} else {					
					votes.put(name, votesQuantity);
				}						

				line = br.readLine();
			}
			
		} catch (IOException e) {
			System.out.println("Error on buffered reader: " + e.getMessage());
		}	
		
		for(String c: votes.keySet()) {
			System.out.println(c + ":" + votes.get(c));
		}
		
		sc.close();
	}

}

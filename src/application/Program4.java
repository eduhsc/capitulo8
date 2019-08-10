package application;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.Company;
import model.Individual;
import model.TaxPayer;

public class Program4 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("Tax payer #"+ i +" data: ");
			System.out.print("Individual or Company (i/c)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Annual Income: ");
			double annualIncome = sc.nextDouble();
			
			if (type == 'i') {
				System.out.print("Health Expenditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, annualIncome, healthExpenditures));
			}else if (type == 'c') {
				System.out.print("Number of Employees: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new Company(name, annualIncome, numberOfEmployees));
			}	
		}
		DecimalFormat df = new DecimalFormat("#.00");
		double sum = 0;
		System.out.println();
		System.out.println("TAXES PAID:");
		for (TaxPayer c: list) {
			System.out.println(c.getName()+ ": $ "+ df.format(c.tax()));
			sum += c.tax();
		}
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + df.format(sum));
		sc.close();
	}

}

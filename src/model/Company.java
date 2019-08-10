package model;

public class Company extends TaxPayer{

	private int numberOfEmployees;

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	public Company() {

	}

	public Company(String name, double annualIncome, int numberOfEmployees) {
		super(name, annualIncome);
		this.numberOfEmployees = numberOfEmployees; 
	}
	
	public double tax() {
		double tax;
		if (this.numberOfEmployees > 10) {
			tax = (this.getAnnualIncome() * 14)/100;
		} else {
			tax = (this.getAnnualIncome() * 16)/100;
		}
		
		return tax;
	
	}
	
}

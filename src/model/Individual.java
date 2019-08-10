package model;

public class Individual extends TaxPayer {

	private double healthExpenditures;

	public Individual() {
		
	}
	
	public Individual(String name, double annualIncome, double healthExpenditures) {
		super(name, annualIncome);
		this.healthExpenditures = healthExpenditures;
	}
	
	public double tax() {
		double tax;
		if (this.getAnnualIncome() < 2000.00) {
			tax = (this.getAnnualIncome() * 15)/100;
		} else {
			tax = (this.getAnnualIncome() * 25)/100;
		}
		if (this.healthExpenditures > 0) {
			tax -= (healthExpenditures / 2);
		}
		
		return tax;
	}

	public double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}
	
	
}

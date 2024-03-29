package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {

	private Date manufactureDate;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public UsedProduct() {
		
	}
	
	public UsedProduct(String name, double price, Date date) {
		super(name, price);
		this.manufactureDate = date;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	@Override
	public String priceTag() {
		return getName() 
			    + " (used) $ "
			    + String.format("%.2f", this.getPrice())
				+ " (Manufacture date: " 
			    + sdf.format(this.getManufactureDate())+")";
	}
}

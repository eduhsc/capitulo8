package application;

import java.text.DecimalFormat;
import java.util.Locale;

public class Program2 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		DecimalFormat df = new DecimalFormat("0.00");
		
		String n = df.format(1000.57);
		System.out.println(n);
		
	}

}

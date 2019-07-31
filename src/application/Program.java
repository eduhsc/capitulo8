package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.next();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date: ");
		Date date = sdf.parse(sc.next());
		Client client = new Client(name, email, date);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.next();
		Order order = new Order(OrderStatus.valueOf(status), client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			OrderItem orderItem = new OrderItem();
			Product product = new Product();
			
			System.out.println("Enter #"+ i +" item data:");
			System.out.print("Product name: ");
			product.setName(sc.next());
			System.out.print("Product price: ");
			product.setPrice(sc.nextDouble());
			System.out.print("Quantity: ");
			orderItem.setQuantity(sc.nextInt());
			
			orderItem.setProduct(product);
			order.addOrderItems(orderItem);
		}
		
		System.out.println();
		System.out.println(order);
		
	}

}

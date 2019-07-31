package entities;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date moment;
	private OrderStatus status;

	private Client client;
	private List<OrderItem> orderItems = new ArrayList<>();
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void removeOrderItems(OrderItem orderItem) {
		this.orderItems.remove(orderItem);
	}

	public void addOrderItems(OrderItem orderItem) {
		this.orderItems.add(orderItem);
	}

	public Order() {
		
	}
	
	public Order(OrderStatus status, Client client) {
		this.moment = new Date();
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date date) {
		this.moment = date;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public double total() {
		double sum = 0;
		for (OrderItem c: orderItems) {
			sum += c.subTotal();
		}
		
		return sum;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: \n");
		sb.append("Order Moment: ");
		sb.append(sdf.format(this.moment) + "\n");
		sb.append("Order Status: ");
		sb.append(this.status + "\n");
		sb.append("Client: ");
		sb.append(this.client.getName());
		sb.append("("+ sdf.format(this.client.getBirthDate()) + ")");
		sb.append(" - "+ this.client.getEmail());
		sb.append("\n");
		sb.append("Order items: \n");
		
		for (OrderItem i: orderItems) {
			sb.append(i.getProduct().getName()+ ", ");
			sb.append("$"+ df.format(i.getPrice())+ ", ");
			sb.append("Quantity: "+ i.getQuantity()+ ", ");
			sb.append("Subtotal: $"+ df.format(i.subTotal()));
			sb.append("\n");
		}
		sb.append("Total price: $"+ df.format(this.total()));
		return sb.toString();
	}
	
	
	
}

package entities;

import java.util.Date;

import entities.enums.OrderStatus;

public class Order {

	private int id;
	private Date date;
	private OrderStatus status;

	public Order(int id, Date date, OrderStatus status) {
		this.id = id;
		this.date = date;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + ", status=" + status + "]";
	}
	
	
	
}

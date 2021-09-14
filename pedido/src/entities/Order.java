package entities;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import enums.OrderStatus;

public class Order {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date moment;
	private OrderStatus order;
	private Client client;

	private List<OrderItem> items = new ArrayList<>();

	public Order() {
	}

	public Order(Date moment, OrderStatus order, Client client) {
		this.moment = moment;
		this.order = order;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getOrder() {
		return order;
	}

	public void setOrder(OrderStatus order) {
		this.order = order;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem item) {
		this.items.add(item);
	}

	public void removeItem(OrderItem item) {
		this.items.remove(item);
	}
	
	public Double total() {
		Double total = 0.0;
		for (OrderItem x : items) {
			total += x.subTotal();
		}
		return total;
	}

	@Override
	public String toString() {
		int total = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("\nORDER SUMMARY:\nOrder moment: " + sdf.format(moment));
		sb.append(" \nOrder status: " + order + "\n");
		sb.append(client);
		sb.append("\nOrder items:\n");
		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $" + String.format("%.2f", total()));
		return sb.toString();
	}
}

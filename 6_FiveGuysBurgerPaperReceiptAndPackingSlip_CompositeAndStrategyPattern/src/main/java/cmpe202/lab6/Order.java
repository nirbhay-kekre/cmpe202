package cmpe202.lab6;

import java.util.ArrayList;
import java.util.List;

public class Order implements IOrder, IComponent {
	IPrintRecieptStratagey customerPrintStratagey = new CustomerRecieptStrategy();
	IPrintRecieptStratagey staffPrintStratagey = new StaffRecieptStrategy();
	List<IComponent> components = new ArrayList<>();
	IPrintRecieptStratagey currentStratagey;
	float amount = 0;

	public Order() {
		currentStratagey = customerPrintStratagey;
	}

	/**
	 * sets current print strategy
	 */
	public void setPrintStratagy(String strategy) {
		strategy = strategy.toUpperCase();
		if ("CUSTOMER".equals(strategy)) {
			currentStratagey = customerPrintStratagey;
		} else if ("STAFF".equals(strategy)) {
			currentStratagey = staffPrintStratagey;
		}
	}

	/**
	 * prints receipt
	 */
	public void printReceipt() {
		for (IComponent component : components) {
			System.out.println(currentStratagey.getFormattedReciept(component.display()));
			System.out.println(currentStratagey.printPrice(component.price()) + "\n");
			
		}
	}

	@Override
	public void addSubComponent(IComponent component) {
		this.components.add(component);

	}

	@Override
	public void removeComponent(IComponent component) {
		this.components.remove(component);
	}

	@Override
	public String display() {
		StringBuilder value = new StringBuilder();
		for (IComponent c : components) {
			value.append(c.display() + "\n");
		}
		return value.toString();
	}

	@Override
	public float price() {
		float subTotal = amount;
		for (IComponent component : components) {
			subTotal += component.price();
		}
		return subTotal;
	}

}

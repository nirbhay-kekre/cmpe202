package cmpe202.lab6;

import java.util.ArrayList;
import java.util.List;

public class Burger implements IComponent {
	List<IComponent> components = new ArrayList<IComponent>();
	float amount = 5.59f;
	String display = "LBB";

	public void addSubComponent(IComponent component) {
		components.add(component);
	}

	public String display() {
		StringBuilder value = new StringBuilder();
		value.append(display + "\n");
		for (IComponent c : components) {
			value.append("  " + c.display() + "\n");
		}
		return value.toString();
	}

	public void removeComponent(IComponent component) {
		components.remove(component);
	}

	public float price() {
		float subTotal = amount;
		for (IComponent component : components) {
			subTotal += component.price();
		}
		return subTotal;
	}
}

package cmpe202.lab6;

public class Jalapeno implements IComponent {
	private String display= "->|JALA Grilled";

	public void addSubComponent(IComponent component) {
		//its a leaf doing nothing
	}

	public void removeComponent(IComponent component) {
		//its a leaf doing nothing
	}

	public String display() {
		return display;
	}

	@Override
	public float price() {
		return 0;
	}

}

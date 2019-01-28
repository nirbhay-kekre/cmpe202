package cmpe202.lab6;

public class Bacon implements IComponent {
	private String display= "{{{{ BACON }}}}";

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

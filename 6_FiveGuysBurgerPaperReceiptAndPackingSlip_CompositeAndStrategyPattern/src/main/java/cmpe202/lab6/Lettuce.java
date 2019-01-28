package cmpe202.lab6;

public class Lettuce implements IComponent{
	
	String display = "LETTUCE";

	public void addSubComponent(IComponent component) {
		//its a leaf doing nothing
	}

	public String display() {
		return display;
	}

	public void removeComponent(IComponent component) {
		//its a leaf doing nothing
	}

	@Override
	public float price() {
		return 0;
	}
	
	
}

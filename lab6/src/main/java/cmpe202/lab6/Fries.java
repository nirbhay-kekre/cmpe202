package cmpe202.lab6;

public class Fries implements IComponent {

	String display = "LTL CAJ";
	@Override
	public void addSubComponent(IComponent component) {
		//its a leaf
	}

	@Override
	public void removeComponent(IComponent component) {
		//its a leaf
	}

	@Override
	public String display() {
		return display;
	}

	@Override
	public float price() {
		// TODO Auto-generated method stub
		return 2.79f;
	}

}

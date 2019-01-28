package cmpe202.lab6;

public interface IComponent {

	public void addSubComponent(IComponent component);
	
	public void removeComponent(IComponent component);
	
	public String display();

	public float price();
}


public abstract class Decorator implements IComponent{

	IComponent componentToBeDecorated;
	
	public Decorator(IComponent componentToBeDecorated) {
		this.componentToBeDecorated = componentToBeDecorated;
	}
}

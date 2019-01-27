
public class CVVDecorator extends Decorator implements ICreditCardState {

	private ICreditCardStateMachine machine;
	public CVVDecorator(IComponent componentToBeDecorated, ICreditCardStateMachine machine) {
		super(componentToBeDecorated);
		this.machine = machine;
	}

	public void key(char key) {
		if ((key == 88 || key == 120) && this.length() == 0) {
			this.machine.setExpirationState();
			this.machine.key(key);
			return;
		}
		this.componentToBeDecorated.key(key);
	}

	public String display() {
		return "["+this.componentToBeDecorated.display()+"]" ;
	}
	public int length() {
		return this.componentToBeDecorated.length();
	}
}

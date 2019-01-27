
public class ExpirationDecorator extends Decorator implements ICreditCardState {

	private ICreditCardStateMachine machine;

	public ExpirationDecorator(IComponent componentToBeDecorated, ICreditCardStateMachine machine) {
		super(componentToBeDecorated);
		this.machine = machine;
	}

	public void key(char key) {
		if ((key == 88 || key == 120) && this.length() == 0) {
			this.machine.setCreditCardNumState();
			this.machine.key(key);
			return;
		}
		this.componentToBeDecorated.key(key);
		if (this.length() == 4) {
			this.machine.setCVVState();
		}
	}

	public String display() {
		String number = this.componentToBeDecorated.display();
		StringBuilder display = new StringBuilder("[");
		int i = 0;
		for (char c : number.toCharArray()) {
			i++;
			if (i != 1 && i % 2 == 1) {
				display.append("/");
			}
			display.append(c);
		}
		display.append("] ");
		return display.toString();
	}

	public int length() {
		return this.componentToBeDecorated.length();
	}
}

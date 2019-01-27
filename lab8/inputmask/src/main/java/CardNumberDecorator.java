
public class CardNumberDecorator extends Decorator implements ICreditCardState {

	private ICreditCardStateMachine machine;
	public CardNumberDecorator(IComponent componentToBeDecorated, ICreditCardStateMachine machine) {
		super(componentToBeDecorated);
		this.machine = machine;
	}

	public void key(char key) {
		if ((key == 88 || key == 120) && this.length() == 0) {
			return;
		}
		this.componentToBeDecorated.key(key);
		if(this.length() == 16) {
			this.machine.setExpirationState();
		}
	}

	public String display() {
		StringBuilder display = new StringBuilder("[");
		String number = this.componentToBeDecorated.display();
		int i=0;
		for (char c : number.toCharArray()) {
			i++;
			if(i!=1 && i%4==1) {
				display.append(" ");
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

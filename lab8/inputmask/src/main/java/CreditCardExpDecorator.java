
public class CreditCardExpDecorator implements ICreditCardFieldDecorator {

	private ICreditCardField creditCardExp;

	public CreditCardExpDecorator(ICreditCardField exp) {
		this.creditCardExp = exp;
	}

	@Override
	public void addSubComponent(IDisplayComponent c) {
		this.creditCardExp.addSubComponent(c);
	}

	@Override
	public void key(String ch, int cnt) {
		this.creditCardExp.key(ch, cnt);
	}

	@Override
	public void setNext(IKeyEventHandler next) {
		this.creditCardExp.setNext(next);
	}

	@Override
	public String display() {
		StringBuilder display = new StringBuilder("[");
		String number = this.creditCardExp.display();
		int i=0;
		for (char c : number.toCharArray()) {
			i++;
			if(i!=1 && i%2==1) {
				display.append("/");
			}
			display.append(c);
		}
		display.append("] ");
		return display.toString();
	}

}

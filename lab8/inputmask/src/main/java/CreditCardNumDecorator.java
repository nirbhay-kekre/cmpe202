
public class CreditCardNumDecorator implements ICreditCardFieldDecorator {

	private ICreditCardField creditCardNum ;
	
	public  CreditCardNumDecorator(ICreditCardField creditCardNum) {
		this.creditCardNum = creditCardNum;
	}
	
	@Override
	public void addSubComponent(IDisplayComponent c) {
		this.creditCardNum.addSubComponent(c);
	}

	@Override
	public void key(String ch, int cnt) {
		this.creditCardNum.key(ch, cnt);
	}

	@Override
	public void setNext(IKeyEventHandler next) {
		this.creditCardNum.setNext(next);
	}

	@Override
	public String display() {
		StringBuilder display = new StringBuilder("[");
		String number = this.creditCardNum.display();
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

}

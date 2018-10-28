
public class CVCDecorator implements ICreditCardFieldDecorator {

	private ICreditCardField creditCardCVC;

	public CVCDecorator(ICreditCardField creditCardNum) {
		this.creditCardCVC = creditCardNum;
	}

	@Override
	public void addSubComponent(IDisplayComponent c) {
		this.creditCardCVC.addSubComponent(c);
	}

	@Override
	public void key(String ch, int cnt) {
		this.creditCardCVC.key(ch, cnt);
	}

	@Override
	public void setNext(IKeyEventHandler next) {
		this.creditCardCVC.setNext(next);
	}

	@Override
	public String display() {
		String number = this.creditCardCVC.display();
		return "["+number+"] ";
	}

}

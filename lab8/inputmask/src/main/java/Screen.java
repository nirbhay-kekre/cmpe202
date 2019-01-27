
import java.util.ArrayList;
import java.util.List;

public class Screen implements IComponent , ICreditCardStateMachine{

	private List<IComponent> components = new ArrayList<IComponent>();
	private ICreditCardState cardNumState;
	private ICreditCardState cvvState;
	private ICreditCardState expState;
	private ICreditCardState currentState;
	private String lastState = "NONE";
	public Screen(){
		cardNumState = new CardNumberDecorator(new CardNumber(), this);
		cvvState = new CVVDecorator(new CVV(), this);
		expState = new ExpirationDecorator(new Expiration(), this);
		
		currentState = cardNumState;
		components.add((IComponent) cardNumState);
		components.add((IComponent) expState);
		components.add((IComponent) cvvState);
		
	}
	public void key(char key) {
		currentState.key(key);
	}

	public String display() {
		String value = "" ;
        for (IComponent c : components )
        {
            value = value + c.display() ;
        }
        value += "\n\n========================================\n STATE: "+(currentState.getClass().getName());
        value += " COUNT: "+this.length()+"/23";
        value += " PREV: "+ lastState;
        return value ; 
	}

	public int length() {
		int value = 0 ;
        for (IComponent c : components )
        {
            value = value + c.length() ;
        }
        return value ; 
	}
	
	public void setCreditCardNumState() {
		lastState= currentState.getClass().getName();
		currentState = cardNumState;
	}
	public void setCVVState() {
		lastState= currentState.getClass().getName();
		currentState = cvvState;		
	}
	public void setExpirationState() {
		lastState= (currentState.getClass().getName());
		currentState = expState;		
	}

}

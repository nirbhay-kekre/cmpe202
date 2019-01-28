
public interface ICreditCardStateMachine {
	
	public void setCreditCardNumState();
	public void setCVVState();
	public void setExpirationState();
	public void key(char key);

}

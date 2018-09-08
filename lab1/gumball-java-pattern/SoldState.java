

public class SoldState implements State {
 
    GumballMachine gumballMachine;
 
    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
       
	public void insertCoin(int coin) {
		System.out.println("Please wait, we're already giving you a gumball");
	}
 
	public void ejectCoins() {
		System.out.println("Sorry, you already turned the crank");
	}
 
	public void turnCrank() {
		System.out.println("despense the gumball first");
	}
 
	public void dispense() {
		gumballMachine.releaseBall();
		State nextState;
		if (gumballMachine.getCount() > 0) {
			if(gumballMachine.getMoneyInGBM()>=gumballMachine.getCost()) {
				nextState=gumballMachine.getCompleteMoneyState();
			}else if(gumballMachine.getMoneyInGBM()>0) {
				nextState = gumballMachine.getPartialMoneyState();
			}else {
				nextState = gumballMachine.getNoCoinState();
			}
		} else {
			System.out.println("Oops, out of gumballs!");
			nextState = gumballMachine.getSoldOutState();
		}
		gumballMachine.setState(nextState);
	}
 
	public String toString() {
		return "dispensing a gumball";
	}

	public void refill(int count) {
		
	}
}



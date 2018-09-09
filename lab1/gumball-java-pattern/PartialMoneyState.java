
public class PartialMoneyState implements State {
	GumballMachine gumballMachine;
 
	public PartialMoneyState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
  
	public void insertCoin(int coin) {
		if(gumballMachine.isMoreThanOneCoinAllowed() && 
				gumballMachine.getDenominationsAccepted().contains(coin)) {
			int moneyInGBM =gumballMachine.getMoneyInGBM()+coin;
			gumballMachine.setMoneyInGBM(moneyInGBM);
			System.out.println("You inserted: " +coin);
			if(moneyInGBM >= gumballMachine.getCost()) {
				State nextState = gumballMachine.getCompleteMoneyState();
				gumballMachine.setState(nextState);
			}			
		}
		else{
			System.out.println("You can't insert "+ coin);
		}
	}
 
	public void ejectCoins() {
		System.out.println(this.gumballMachine.getMoneyInGBM() + " returned");
		this.gumballMachine.setMoneyInGBM(0);
		gumballMachine.setState(gumballMachine.getNoCoinState());
	}
 
	public void turnCrank() {
		System.out.println("you need to pay "+ 
				(gumballMachine.getCost()-gumballMachine.getMoneyInGBM()) +
				" to get a gumball");
	}

    public void dispense() {
        System.out.println("No gumball dispensed");
    }
 
	public String toString() {
		return "waiting for "+ (gumballMachine.getCost()-gumballMachine.getMoneyInGBM()) +
				" money";
	}

	public void refill(int count) {
		
	}
}

public class CompleteMoneyState implements State {
	GumballMachine gumballMachine;
 
	public CompleteMoneyState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
  
	public void insertCoin(int coin) {
		if(gumballMachine.isMoreThanOneCoinAllowed() && 
				gumballMachine.getDenominationsAccepted().contains(coin)) {
			System.out.println("You inserted: "+coin);
			gumballMachine.setMoneyInGBM(gumballMachine.getMoneyInGBM()+coin);
		}
		else{
			System.out.println("You can't insert another quarter");
		}
	}
 
	public void ejectCoins() {
		System.out.println(this.gumballMachine.getMoneyInGBM() + " returned");
		this.gumballMachine.setMoneyInGBM(0);
		gumballMachine.setState(gumballMachine.getNoCoinState());
	}
 
	public void turnCrank() {
		System.out.println("You turned...");
		gumballMachine.setMoneyInGBM(gumballMachine.getMoneyInGBM()-gumballMachine.getCost());
		gumballMachine.setState(gumballMachine.getSoldState());
	}

    public void dispense() {
        System.out.println("No gumball dispensed");
    }
 
	public String toString() {
		return "waiting for turn of crank";
	}

	public void refill(int count) {
		
	}
}

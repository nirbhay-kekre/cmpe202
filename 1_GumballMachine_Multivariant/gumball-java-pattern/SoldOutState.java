

public class SoldOutState implements State {
    GumballMachine gumballMachine;
 
    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
	public void insertCoin(int coin) {
		System.out.println("You can't insert " + coin + ", the machine is sold out");
	}
 
	public void ejectCoins() {
		int ejectedAmt;
		if((ejectedAmt = this.gumballMachine.getMoneyInGBM()) >0) {
			gumballMachine.setMoneyInGBM(0);
			System.out.println(ejectedAmt + " Amount ejected");
		}else{
			System.out.println("You can't eject, you haven't inserted a quarter yet");
		}
	}
 
	public void turnCrank() {
		System.out.println("You turned, but there are no gumballs");
	}
 
	public void dispense() {
		System.out.println("No gumball dispensed");
	}
 
	@Override
	public String toString() {
		return "sold out";
	}

	public void refill(int count) {
		int moneyInGBM;
		State nextState;
		if((moneyInGBM = this.gumballMachine.getMoneyInGBM())>0) {
			if(moneyInGBM >= this.gumballMachine.getCost()) {
				nextState = this.gumballMachine.getCompleteMoneyState();
			
			}
			else {
				nextState = this.gumballMachine.getCompleteMoneyState();
			}
		}
		else {
			nextState = this.gumballMachine.getNoCoinState();
		}
		this.gumballMachine.setState(nextState);
	}
}

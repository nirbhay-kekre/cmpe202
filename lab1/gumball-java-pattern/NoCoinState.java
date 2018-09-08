

public class NoCoinState implements State {
    GumballMachine gumballMachine;
 
    public NoCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
	public void insertCoin(int coin) {
		if(gumballMachine.getDenominationsAccepted().contains(coin)) {
			gumballMachine.setMoneyInGBM(coin);
			if(coin >= gumballMachine.getCost()) {
				gumballMachine.setState(gumballMachine.getCompleteMoneyState());
			}else {
				gumballMachine.setState(gumballMachine.getPartialMoneyState());
			}
			System.out.println("You inserted: "+ coin);
		} else {
			System.out.println(coin +" coin is not accepted");
		}
	}
 
	public void ejectCoins() {
		System.out.println("You haven't inserted any coin");
	}
 
	public void turnCrank() {
		System.out.println("You turned, but there's no coin");
	 }
 
	public void dispense() {
		System.out.println("You need to pay first");
	} 
 
	public String toString() {
		return "waiting for money";
	}

	public void refill(int count) {
		
	}
}

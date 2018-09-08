import java.util.Set;

public class GumballMachine {
 
	private State soldOutState;
	private State noCoinState;
	private State completeMoneyState;
	private State soldState;
	private State partialMoneyState;
 
	private State state = soldOutState;
	private int count = 0;
	private int cost = 0;
	private boolean isMoreThanOneCoinAllowed =false;
	private int moneyInGBM=0;
	private Set<Integer> denominationsAccepted;
 
	public GumballMachine(int numberGumballs, int cost, Set<Integer> denominationsAccepted,
			boolean isMoreThanOneCoinAllowed) {
		soldOutState = new SoldOutState(this);
		noCoinState = new NoCoinState(this);
		completeMoneyState = new CompleteMoneyState(this);
		partialMoneyState = new PartialMoneyState(this);
		soldState = new SoldState(this);
		this.cost=cost;
		this.isMoreThanOneCoinAllowed = isMoreThanOneCoinAllowed;
		this.denominationsAccepted = denominationsAccepted;
		this.count = numberGumballs;		
 		if (numberGumballs > 0) {
			state = noCoinState;
		} 
	}
 
	public void insertCoin(int coin) {
		state.insertCoin(coin);
	}
 
	public void ejectQuarter() {
		state.ejectCoins();
	}
 
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}

	void setState(State state) {
		this.state = state;
	}
 
	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count != 0) {
			count = count - 1;
		}
	}
 
	int getCount() {
		return count;
	}
 
	void refill(int count) {
		if(count <=0) {
			System.out.println("you have to refill atleast one gumball");
			return;
		}
		this.count = count;
		state.refill(count);
	}

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoCoinState() {
        return noCoinState;
    }

    public State getCompleteMoneyState() {
        return completeMoneyState;
    }

    public State getSoldState() {
        return soldState;
    }
 
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}

	public State getPartialMoneyState() {
		return partialMoneyState;
	}

	public int getCost() {
		return cost;
	}

	public boolean isMoreThanOneCoinAllowed() {
		return isMoreThanOneCoinAllowed;
	}

	public int getMoneyInGBM() {
		return moneyInGBM;
	}

	public Set<Integer> getDenominationsAccepted() {
		return denominationsAccepted;
	}

	public void setMoneyInGBM(int moneyInGBM) {
		this.moneyInGBM = moneyInGBM;
	}
	
}

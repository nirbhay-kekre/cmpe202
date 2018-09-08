

public interface State {
 
	public void insertCoin(int coin);
	public void ejectCoins();
	public void turnCrank();
	public void dispense();
	void refill(int count);
}

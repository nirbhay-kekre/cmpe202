import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Set<Integer> denominationsAccepted = new HashSet<Integer>();
		denominationsAccepted.add(25);
		GumballMachine gumballMachine = new GumballMachine(5, 25, denominationsAccepted, false);
		
		System.out.println(gumballMachine);

		gumballMachine.insertCoin(25);
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);

		gumballMachine.insertCoin(10);
		gumballMachine.turnCrank();
		gumballMachine.insertCoin(25);
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);
		
		machine2();
		machine3();
	}
	
	public static void machine2() {
		Set<Integer> denominationsAccepted = new HashSet<Integer>();
		denominationsAccepted.add(25);
		GumballMachine gumballMachine = new GumballMachine(1, 50, denominationsAccepted, true);
		
		System.out.println(" -----------------");
		
		gumballMachine.insertCoin(25);
		gumballMachine.turnCrank();
		gumballMachine.insertCoin(10);
		gumballMachine.insertCoin(25);
		gumballMachine.turnCrank();
		
		System.out.println(gumballMachine);
		
		gumballMachine.insertCoin(25);
		gumballMachine.refill(1);
		gumballMachine.insertCoin(25);
		gumballMachine.insertCoin(25);
		gumballMachine.insertCoin(25);
		gumballMachine.turnCrank();
		gumballMachine.turnCrank();
		
		System.out.println(gumballMachine);
		
		gumballMachine.refill(2);
		gumballMachine.insertCoin(25);
		gumballMachine.insertCoin(25);
		gumballMachine.insertCoin(25);
		gumballMachine.turnCrank();
		gumballMachine.turnCrank();
		
		System.out.println(gumballMachine);
		System.out.println(" -----------------");
		
	}
	
	public static void machine3() {

		Set<Integer> denominationsAccepted3 = new HashSet<Integer>();
		denominationsAccepted3.add(25);
		denominationsAccepted3.add(5);
		denominationsAccepted3.add(10);
		GumballMachine gumballMachine3 = new GumballMachine(1, 50, denominationsAccepted3, true);
		System.out.println(gumballMachine3);
		
		gumballMachine3.insertCoin(10);
		gumballMachine3.insertCoin(10);
		gumballMachine3.insertCoin(5);
		gumballMachine3.insertCoin(25);
		gumballMachine3.turnCrank();
		gumballMachine3.refill(1);
		System.out.println(gumballMachine3);
		
		gumballMachine3.insertCoin(25);
		gumballMachine3.insertCoin(25);
		gumballMachine3.insertCoin(10);
		gumballMachine3.turnCrank();
		gumballMachine3.refill(1);
		System.out.println(gumballMachine3);
		
		gumballMachine3.insertCoin(25);
		gumballMachine3.insertCoin(25);
		gumballMachine3.insertCoin(10);
		gumballMachine3.turnCrank();
		gumballMachine3.refill(1);
		System.out.println(gumballMachine3);
	
	}
}

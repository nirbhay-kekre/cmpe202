import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        
        Set<Integer> denomination1=new HashSet<>();
        denomination1.add(25);
        IGumballMachine gumballMachine1 = new GumballMachine(5, 25, denomination1 );

        System.out.println(gumballMachine1);

        gumballMachine1.insertCoin( 25 );
        gumballMachine1.turnCrank();

        System.out.println(gumballMachine1);

        gumballMachine1.insertCoin( 25 );
        gumballMachine1.turnCrank();
        gumballMachine1.insertCoin( 25 );
        gumballMachine1.turnCrank();

        System.out.println(gumballMachine1);
	}
}

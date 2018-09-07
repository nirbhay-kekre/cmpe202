import java.util.HashSet;
import java.util.Set;

public class GumballMachine implements IGumballMachine
{

    private int num_gumballs;
    private Set<Integer> denominationsAccepted = new HashSet<Integer>();
    private int currentMoney;
    private int cost;

    public GumballMachine( int size, int cost, Set<Integer> denominationsAccepted )
    {
        // initialise instance variables
        this.num_gumballs = size;
        this.cost = cost;
        this.currentMoney=0;
        this.denominationsAccepted = denominationsAccepted;
    }

    public void insertCoin(int coin)
    {
        if ( denominationsAccepted.contains(coin)){
            this.currentMoney += coin ;
        }else{ 
            System.out.println("Can not insert "+ coin) ;
        }
    }
    
    public void turnCrank()
    {
    	if ( this.currentMoney >= this.cost)
    	{
    		if ( this.num_gumballs > 0 )
    		{
    			this.num_gumballs-- ;
    			this.currentMoney -= this.cost ;
    			System.out.println( "Gumball Ejected!" ) ;
    		}
    		else
    		{
    			System.out.println( "No More Gumballs!  Sorry, can't return your coins" ) ;
    		}
    	}
    	else 
    	{
    		System.out.println( "Please insert more amount" ) ;
    	}        
    }
}

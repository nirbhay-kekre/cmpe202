package cmpe202.lab6;

/**
 * @author nirbhaykekre
 * Main Enterance
 */
public class App{
	IComponent burger;
	IComponent lettuce;
	IComponent tomato;
	IComponent jalapeno;
	IComponent bacon;
	IComponent onion;
	IComponent fries;
	IComponent order;
	
	/**
	 * preventing construction
	 */
	App() {
		burger = new Burger();
		lettuce = new Lettuce();
		tomato = new Tomato();
		jalapeno = new Jalapeno();
		onion = new Onion();
		bacon = new Bacon();
		fries = new Fries();
		order = new Order();

		// setup composite pattern
		burger.addSubComponent(bacon);
		burger.addSubComponent(lettuce);
		burger.addSubComponent(tomato);
		burger.addSubComponent(onion);
		burger.addSubComponent(jalapeno);
		
		order.addSubComponent(burger);
		order.addSubComponent(fries);
		
	}

	public static void main(String[] args) {
		App app = new App();
		
		System.out.println("------------------------------------");
		((IOrder)app.order).setPrintStratagy("Customer");
		System.out.println("Customer Reciept: ");
		((IOrder)app.order).printReceipt();
		System.out.println("------------------------------------\n\n");
		System.out.println("------------------------------------");
		((IOrder)app.order).setPrintStratagy("Staff");
		System.out.println("Staff Reciept: ");
		((IOrder)app.order).printReceipt();
		System.out.println("------------------------------------");
		
	}
	
}

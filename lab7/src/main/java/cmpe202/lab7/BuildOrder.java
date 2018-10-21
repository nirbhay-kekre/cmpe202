package cmpe202.lab7;

public class BuildOrder {

	public static Component getOrder() {
		Composite order = new Composite("Order");
//        order.addChild(new Leaf("Crispy Onion Strings", 5.50 ));
//        order.addChild(new Leaf("The Purist", 8.00 ));

		CustomBurger customBurger = new CustomBurger("Build Your Own Burger");
		// base price for 1/2 lb
		Burger b = new Burger("Burger Options");
		String[] bo = { "Organic Bison", "1/2lb.", "On A Bun" };
		b.setOptions(bo);
		// 1 cheese free, extra cheese +1.00
		Cheese c = new Cheese("Cheese Options");
		String[] co = { "Yellow American", "Spicy Jalapeño Jack" };
		c.setOptions(co);
		c.wrapDecorator(b);

		PremiumCheese premiumCheese = new PremiumCheese("Premium Cheese Options");
		String[] options = { "Danish Blue Cheese" };
		premiumCheese.setOptions(options);
		premiumCheese.wrapDecorator(c);

		Sauce sauce = new Sauce("Sauce Options");
		String[] sauceOptions = { "Thai Peanut Sauce", "Mayonnaise" };
		sauce.setOptions(sauceOptions);
		sauce.wrapDecorator(premiumCheese);

		// 4 toppings free, extra +.75
		Toppings t = new Toppings("Toppings Options");
		String[] to = { "Dil Pickle Chips", "Black Olives", "Spicy Pickles" };
		t.setOptions(to);
		t.wrapDecorator(sauce);

		// premium topping +1.50
		Premium p = new Premium("Premium Options");
		String[] po = { "Marinated Tomatoes" };
		p.setOptions(po);
		p.wrapDecorator(t);

		Bun bun = new Bun("Bun Option");
		String[] bunOptions = { "Ciabatta [Vegan]" };
		bun.setOptions(bunOptions);
		bun.wrapDecorator(p);

		Side side = new Side("Sides");
		String[] sideOptions = { "Shoestring Fries" };
		side.setOptions(sideOptions);
		side.wrapDecorator(bun);

		// Setup Custom Burger Ingredients
		customBurger.setDecorator(side);
		customBurger.addChild(b);
		customBurger.addChild(c);
		customBurger.addChild(premiumCheese);
		customBurger.addChild(sauce);
		customBurger.addChild(t);
		customBurger.addChild(p);
		customBurger.addChild(bun);
		customBurger.addChild(side);

		// Add Custom Burger to the ORder
		order.addChild(customBurger);

		CustomBurger customBurger1 = new CustomBurger("Build Your Own Burger");

		b = new Burger("Burger Options");
		String[] bo1 = { "Hormone & Antibiotic Free Beef", "1/3lb.", "On A Bun" };
		b.setOptions(bo1);

		c = new Cheese("Cheese Options");
		String[] co1 = { "Smoked Gouda", "Greek Feta" };
		c.setOptions(co1);
		c.wrapDecorator(b);

		premiumCheese = new PremiumCheese("Premium Cheese Options");
		String[] options1={"Fresh Mozzarella"};
		premiumCheese.setOptions(options1);
		premiumCheese.wrapDecorator(c);

		sauce = new Sauce("Sauce Options");
		String[] sauceOptions1 = { "Habanero Salsa" };
		sauce.setOptions(sauceOptions1);
		sauce.wrapDecorator(premiumCheese);

		t = new Toppings("Toppings Options");
		String[] to1 = { "Crushed Peanuts" };
		t.setOptions(to1);
		t.wrapDecorator(sauce);

		p = new Premium("Premium Options");
		String[] po1 = { "Sunny Side Up Eggs", "Marinated Tomatoes" };
		p.setOptions(po1);
		p.wrapDecorator(t);

		bun = new Bun("Bun Option");
		String[] bunOptions1 = { "Gluten-Free Bun" };
		bun.setOptions(bunOptions1);
		bun.wrapDecorator(p);

		side = new Side("Sides");
		String[] sideOptions1 = { "Shoestring Fries" };
		side.setOptions(sideOptions1);
		side.wrapDecorator(bun);

		// Setup Custom Burger Ingredients
		customBurger1.setDecorator(side);
		customBurger1.addChild(b);
		customBurger1.addChild(c);
		customBurger1.addChild(premiumCheese);
		customBurger1.addChild(sauce);
		customBurger1.addChild(t);
		customBurger1.addChild(p);
		customBurger1.addChild(bun);
		customBurger1.addChild(side);
		// Add Custom Burger to the ORder
		order.addChild(customBurger1);
		return order;
	}

}

/*
 * 
 * Counter Burger Menu: https://thecounterburger.emn8.com/?store=Times%20Square
 * 
 */
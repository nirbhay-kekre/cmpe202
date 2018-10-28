/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

/**
 *  Main App Class for Displaying Screen.
 */
public class App {

    private Screen screen;
    private CreditCardNum num;
    private CreditCardExp exp;
    private CreditCardCVC cvc;
    private ICreditCardFieldDecorator numDeco;
    private ICreditCardFieldDecorator expDeco;
    private ICreditCardFieldDecorator cvvDeco;
    private int count;

    public App() {

        screen = new Screen();
        num = new CreditCardNum();
        exp = new CreditCardExp();
        cvc = new CreditCardCVC();
        
        numDeco = new CreditCardNumDecorator(num);
        expDeco = new CreditCardExpDecorator(exp);
        cvvDeco = new CVCDecorator(cvc);

        screen.addSubComponent(numDeco);
        screen.addSubComponent(expDeco);
        screen.addSubComponent(cvvDeco);

        count = 0;

    }

    public String display() {
        String output = "";
        output += "========================================\n";
        output += screen.name() + "\n";
        output += "========================================\n";
        output += "\n\n\n\n";
        output += screen.display() + "\n";
        output += "\n\n\n\n";
        output += "========================================\n";
        return output;
    }

    public void key(String ch) {
    	if("Delete".equals(ch) || "X".equals(ch)) {
			if(count>0) {
				screen.key(ch, count);
				count--;
			}
			
		}else {
			if(count<23) {
				count++;
				screen.key(ch, count);
			}
		}
    	
        
    }

}


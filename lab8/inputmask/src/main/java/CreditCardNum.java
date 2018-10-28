/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

public class CreditCardNum implements ICreditCardField 
{

	private IKeyEventHandler nextHandler ;
	private String number = "" ;

    public void setNext( IKeyEventHandler next) {
    	this.nextHandler = next ;
    }	

	public String display() {
		if ( number.equals("") )
			return "4444444444444444";
		else
			return number;
	}	

	public void key(String ch, int cnt) {
		if ( cnt <= 16 )
		{
			if("Delete".equals(ch) || "X".equals(ch)) {
				number= number.isEmpty()?number :number.substring(0, number.length()-1);
			}
			else {
				number += ch ;
			}
		}
		else if ( nextHandler != null )
			nextHandler.key(ch, cnt) ;
	}	

	public void addSubComponent( IDisplayComponent c ) {
		return ; // do nothing
	}

}
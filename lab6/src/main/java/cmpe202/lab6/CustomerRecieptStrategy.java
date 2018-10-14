package cmpe202.lab6;

import java.text.DecimalFormat;

public class CustomerRecieptStrategy implements IPrintRecieptStratagey {

	public String getFormattedReciept(String contents) {
		return contents;
	}

	@Override
	public String printPrice(float price) {
		DecimalFormat dFormat = new DecimalFormat("0.00");
		return "Price: "+ dFormat.format(price);
	}

}

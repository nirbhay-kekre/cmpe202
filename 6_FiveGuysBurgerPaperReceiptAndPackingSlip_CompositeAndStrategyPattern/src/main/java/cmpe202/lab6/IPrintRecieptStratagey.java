package cmpe202.lab6;

public interface IPrintRecieptStratagey {
	public String getFormattedReciept(String contents);

	public String printPrice(float price);
}

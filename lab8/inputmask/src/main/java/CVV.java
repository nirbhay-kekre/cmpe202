
public class CVV implements IComponent{

	public static final String DISPLAY ="123";
	public String digits = "";
	
	public void key(char key) {
		if(key >=48 && key <=57) {
			//key is a digit
			if(this.length() < 3) {
				digits += key;
			}
		}else if(key == 88 || key ==120) {
			// key = X or x
			if(this.length() > 0 ) {
				digits = digits.substring(0, this.length()-1);
			}
		}
		//ignore other key inputs
	}
	
	public int length() {
		return digits.length();
	}
	

	public String display() {
		return digits.isEmpty() ? DISPLAY: digits;
	}
}

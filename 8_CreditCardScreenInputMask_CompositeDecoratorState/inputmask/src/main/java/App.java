
/**
 * Hello world!
 *
 */
public class App {
	Screen screen;

	public App() {
		screen = new Screen();
	}

	public String display() {
		String output = "";
		output += "========================================\n";
		output += "CREDIT CARD SCREEN \n";
		output += "========================================\n";
		output += "\n\n\n\n";
		output += screen.display() + "\n";
		//output += "\n\n\n\n";
		output += "========================================\n";
		return output;
	}

	public void key(char ch) {
		screen.key(ch);
	}
}

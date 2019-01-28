
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		App app = new App();
		Scanner c = new Scanner(System.in);
		for (;;) {
			 System.out.print("\033[H\033[2J"); // clear the screen
			System.out.flush();
			System.out.println(app.display());
			System.out.print("Key (Digit or X or Delete) => ");
			String line = c.nextLine();
			line = line.toUpperCase();
			for (char ch : line.toCharArray()) {
				app.key(ch);
			}
		}
	}
}

package cmpe202.lab6;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StaffRecieptStrategy implements IPrintRecieptStratagey {

	public String getFormattedReciept(String contents) {
		return Arrays.stream(contents.split("\n")).sorted((component1, component2) -> {
			if (component1.startsWith("{")) {
				return 1;
			} else if (component2.startsWith("{")) {
				return -1;
			} else if (component1.startsWith("|->")) {
				return 1;
			} else if (component2.startsWith("|->")) {
				return -1;
			}
			return 0;
		}).collect(Collectors.joining("\n"));
	}

	@Override
	public String printPrice(float price) {
		return "";
	}

}

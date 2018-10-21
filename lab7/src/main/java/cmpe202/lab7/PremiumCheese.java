package cmpe202.lab7;

public class PremiumCheese extends LeafDecorator {

	private String[] options;

	public PremiumCheese(String d) {
		super(d);
	}

	/* 
	 * +$1.05 per premium cheese
	 */
	@Override
	public void setOptions(String[] options) {
		this.options = options;
		this.price += options.length * 1.50;
	}

	@Override
	public String getDescription() {
		String desc = "   ";
		for (int i = 0; i < options.length; i++) {
			if (i > 0)
				desc += " + " + options[i];
			else
				desc = options[i];
		}
		return desc;
	}

}

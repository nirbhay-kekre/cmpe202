package cmpe202.lab7;

public class Bun extends LeafDecorator {

	String[] options;
	
	public Bun(String d) {
		super(d);
	}

	@Override
	public void setOptions(String[] options) {
		this.options = options;
		if("Gluten-Free Bun".equals(options[0])) {
			this.price += 1.00;
		}
	}

	@Override
	public String getDescription() {
        String desc = "   " ;
        for ( int i = 0; i<options.length; i++ )
        {
            if (i>0) desc += " + " + options[i] ;
            else desc = options[i] ;
        }        
        return desc ;
    }

}

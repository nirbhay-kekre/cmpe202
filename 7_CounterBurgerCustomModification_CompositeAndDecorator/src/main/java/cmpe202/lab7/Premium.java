package cmpe202.lab7;
public class Premium extends LeafDecorator
{
    private String[] options ;
    
    
    public Premium( String d )
    {
        super(d) ;
    }
    
    // premium topping +1.50
    public void setOptions( String[] options )
    {
        this.options = options ;
		if (options.length > 0) {
			for (String option : options) {
				this.price += 1.00;
				if("Marinated Tomatoes".equals(option)) {
					this.price += 2.00;
				}
			}
		}
    }
    
    public String getDescription() 
    {
        String desc = "   " ;
        for ( int i = 0; i<options.length; i++ )
        {
            if (i>0) desc += " + " + options[i] ;
            else desc = options[i] ;
        }        
        return desc ;
    }
    
}
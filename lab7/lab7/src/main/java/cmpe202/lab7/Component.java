package cmpe202.lab7;  

public interface Component {

     void printDescription() ;
     void addChild(Component c);
     void removeChild(Component c);
     Component getChild(int i);

}
 

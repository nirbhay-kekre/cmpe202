package cmpe202.lab7;  

public class Client {

    public static void runTest()
    {
        Component theOrder = BuildOrder.getOrder() ;
        theOrder.printDescription();

    }
    public static void main(String arg[]) {
    	runTest();
    }
}
 

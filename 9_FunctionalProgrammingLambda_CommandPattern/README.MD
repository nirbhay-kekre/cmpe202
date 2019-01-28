## CMPE 202 - LAB #9 - Design Pattern using Lambda Expressions in Java

The command pattern encapsulate a request as an object, thereby letting you parameterize other objects with different requests, queue or log requests, and support undoable operations.

## Differences in solution between both approaches 
Below is the normal way of setting a receiver in a command pattern, [Click here to view the java file.](https://github.com/nirbhay-kekre/cmpe202/blob/master/lab9/command/src/main/java/cmpe202/command/Client.java)

```java
sayHello.setReceiver(new Receiver() {
    public void doAction() {
				System.out.println(helloMessage);
		}
});
    
sayGoodbye.setReceiver(new Receiver() {
		public void doAction() {
				System.out.println(goodbyeMessage);
		}
});
```

Now, with the help of Lambda expression we can implement these statements as follows, [Click here to view the java file.](https://github.com/nirbhay-kekre/cmpe202/blob/master/lab9/commandPattern_usingLambda/src/main/java/cmpe202/command/Client.java)

```java
sayHello.setReceiver( () -> System.out.println( helloMessage ) );

sayGoodbye.setReceiver( () -> System.out.println( goodbyeMessage ));

```

Both of the above implementation does the same thing but the implementation now looks much more clean and concise, as we’ve reduced the amount of boilerplate code.

## Reference
The original code which I refactored using lambda expression can be found [here](https://github.com/paulnguyen/cmpe202/tree/master/patterns/command). 

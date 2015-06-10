package core;



public class HelloWorldBeanFact {
	
	private HelloWorldBeanFact(){
		
	}
	public static HelloWorldBeanFact createInstance(){
		HelloWorldBeanFact hb=new HelloWorldBeanFact();
		hb.setMessage("i am factory-made...");
        return hb;
    }
/*properties that are injected*/
private String message;

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public void getIt(){
	
	System.out.println(this.getMessage());
}

}


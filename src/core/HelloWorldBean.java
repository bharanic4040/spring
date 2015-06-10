package core;



class HelloWorldHelper{
	private int no;
    private String name;
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public HelloWorldHelper(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

}

public class HelloWorldBean {
/*properties that are injected*/
private String message;
private HelloWorldHelper help;

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public HelloWorldHelper getHelp() {
	return help;
}

public void setHelp(HelloWorldHelper help) {
	this.help = help;
}

public void getIt(){
	
	System.out.println(this.getMessage()+" - "+this.getHelp().getName()+" - "+this.getHelp().getNo());
}

}


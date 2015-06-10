package annotate;

import org.springframework.beans.factory.annotation.Autowired;

public class HelloAnnotate {

    private HelloAnnotateHelper help;

	public HelloAnnotateHelper getHelp() {
		return help;
	}
  
	public void setHelp(HelloAnnotateHelper help) {
		this.help = help;
	}

	public HelloAnnotate(HelloAnnotateHelper help) {
		super();
		this.help = help;
	}
	
	
	
}
class HelloAnnotateHelper{
	

	private String name="hello bchennu";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 public void init() {
	    
	   }
	   public void cleanup() {
	   
	   }
	   
}

package core;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloLifecycle implements InitializingBean,DisposableBean {
	
	

	@Override
	public void destroy() throws Exception {
		System.out.println("HelloLifecycle bean - Inside destroy() method ");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
		System.out.println("HelloLifecycle - Inside afterPropertiesSet() method ");
	}


/*spring bean life cycle methods*/
public void createIt(){
	System.out.println("HelloLifecycle - Inside createIt() method ");
}

public void destroyIt(){
	System.out.println("HelloLifecycle - Inside destroyIt() method ");
}

private AnnotateConfigHelp annHelp;

public AnnotateConfigHelp getAnnHelp() {
	return annHelp;
}
@Autowired
public void setAnnHelp(AnnotateConfigHelp annHelp) {
	this.annHelp = annHelp;
}



}


package annotate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeginnerAnnotate {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx =   new AnnotationConfigApplicationContext();
		   ctx.register(HelloAnnotateConfig.class);
		   ctx.refresh();
		   HelloAnnotate hell = ctx.getBean(HelloAnnotate.class);
		   System.out.print(hell.getHelp().getName());

		}
	
}

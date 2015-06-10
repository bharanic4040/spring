package core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import comp.NewHireService;

public class BeginnerTwo {

	public static void main(String[] args) {
        //importing two bean configuration files
      //  ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"core-features.xml","advanced-features.xml"});
      
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"advanced-features.xml"});
      
        //spring collections dependency injection List,Set,Map etc
        HelloCollections col = (HelloCollections) applicationContext.getBean("helloCollections");
        System.out.println("Testing Collections - List - "+col.getLists());
        System.out.println("Testing Collections - Set - "+col.getSets());
        
      /*  annotation-config and lifecycle methods done here 
        HelloLifecycle life=(HelloLifecycle)applicationContext.getBean("helloLife");
        life.getAnnHelp().annotate();
        */
        /* component scanning example
        NewHireService svc= (NewHireService)applicationContext.getBean("newHireService");
        System.out.println(svc);*/
        
    }
}

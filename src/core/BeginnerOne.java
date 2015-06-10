package core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeginnerOne {

	public static void main(String[] args) {
        
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("core-features.xml");
      
        HelloWorldBean message = (HelloWorldBean) applicationContext.getBean("hello");
        message.getIt();
        System.out.println(message.hashCode()+" - hashcode()");
       // to explain scopes prototype and singleton
        HelloWorldBean message2 = (HelloWorldBean) applicationContext.getBean("hello");
       
        System.out.println(message2.hashCode()+" - hashcode()");
        
        
    }
}

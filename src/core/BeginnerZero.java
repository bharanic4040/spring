package core;

	import org.springframework.beans.factory.BeanFactory;
	import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

	public class BeginnerZero {
	   public static void main(String[] args) {
		   
	     BeanFactory factory = new XmlBeanFactory(new ClassPathResource("core-features.xml"));

	     HelloWorldBean message = (HelloWorldBean) factory.getBean("hello");
	        message.getIt();
	        
	        HelloWorldBeanFact message2 = (HelloWorldBeanFact) factory.getBean("helloFactory");
	        message2.getIt();
	        
	   }
	}
	


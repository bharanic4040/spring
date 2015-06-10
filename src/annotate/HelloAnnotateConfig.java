package annotate;

import org.springframework.context.annotation.*;

@Configuration
//@Import(HelloAnnotateChildConfig.class)
public class HelloAnnotateConfig {

   @Bean 
   @Scope("prototype")
   public HelloAnnotate helloWorld(){
      return new HelloAnnotate(helloHelp());
   }
   
   @Bean(initMethod="init",destroyMethod="cleanup")
   @Scope("singleton")
   public HelloAnnotateHelper helloHelp(){
	   return new HelloAnnotateHelper();
   }
}

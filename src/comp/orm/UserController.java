package comp.orm;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 

@Controller
public class UserController {
     
    @Autowired
    private UserDAO userDao;
    
    
    @RequestMapping(value="/user.do")
    public ModelAndView home() {
    	
        List<User> listUsers = userDao.list();
        for(User user:listUsers){
        	System.out.println(user.getName());
        }
        ModelAndView model = new ModelAndView("hello");
        model.addObject("userList", listUsers);
        return model;
    }
     
}
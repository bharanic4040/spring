package comp.rest;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest")
public class HelloRestController {

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public @ResponseBody String getUserName(@PathVariable String name) {
    
       return "hi "+name;
    }
}
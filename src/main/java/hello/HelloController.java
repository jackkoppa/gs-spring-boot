package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class HelloController {
    
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String index() {
        return "Hey it me!";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String hello() {
        return "Hello it me!";
    }
    
}

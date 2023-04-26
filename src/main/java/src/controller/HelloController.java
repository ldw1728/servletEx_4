package src.controller;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import src.service.HelloService;

@Controller
public class HelloController {

    public HelloController(){
        System.out.println("helloController init");
    }
    @Autowired
    HelloService helloService;

    //@RequestMapping get 사용
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){

        return "index";
    }

    //@GetMapping 사용
    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("data", "test");
        return "home";
    }

}

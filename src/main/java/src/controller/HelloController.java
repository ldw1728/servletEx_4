package src.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import src.service.HelloService;

@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    //@RequestMapping get 사용
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void index(){}

    //@GetMapping 사용
    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("data", "test");
        return "home";
    }

}

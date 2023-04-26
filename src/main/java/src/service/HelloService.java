package src.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public HelloService(){
        System.out.println("init HelloService");
    }

    public String getName(){
        return "wooklee";
    }
}

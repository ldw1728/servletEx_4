package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration //설정파일임을 명시
@ComponentScan
public class AppConfig {
    public AppConfig(){
        System.out.println("init AppConfig");
    }
}

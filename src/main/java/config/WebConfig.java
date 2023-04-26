package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration //설정파일임을 명시
@ComponentScan("src") //같은폴더아니면 스캔위치 잡아야함.
public class WebConfig {

    public WebConfig(){
        System.out.println("WebConfig init");
    }

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver ivr = new InternalResourceViewResolver();
        ivr.setPrefix("/WEB-INF/views/");
        ivr.setSuffix(".jsp");
        return ivr;
    }

}

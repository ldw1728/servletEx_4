package src;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {


    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Context가 초기화 되었습니다.");
        sce.getServletContext().setAttribute("name", "wookleeTest");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context가 파기 되었습니다.");
    }
}

package src;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import src.service.HelloService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //servletContext에서 webApplicationContext가져옴
        ApplicationContext ac = (ApplicationContext) getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        //ApplicationContext에서 특정 빈 호출
        HelloService helloService = ac.getBean("helloService", HelloService.class);

        System.out.println("doGet");
        resp.getWriter().println("<html><body>");
        resp.getWriter().println("<h3> Servlet </h3><br/>");
        resp.getWriter().println("hi " + helloService.getName() + "<br/>");
        resp.getWriter().println("</body></html>");
    }
}

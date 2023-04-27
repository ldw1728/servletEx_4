package config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import src.filter.RequestInfoFilter;
import src.listener.InitListener;

import javax.servlet.*;

public class WebApplication implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        //filter...
        servletContext.addFilter("CharFilter", new CharacterEncodingFilter("UTF-8"))
                      .addMappingForUrlPatterns(null, false, "/*");

        servletContext.addFilter("requestInfoFilter", new RequestInfoFilter())
                      .addMappingForUrlPatterns(null, false, "/*");

        //listener...
        servletContext.addListener(new InitListener());

        //create contextClass /  iocContainer
        AnnotationConfigWebApplicationContext annoContext = new AnnotationConfigWebApplicationContext();
        annoContext.setServletContext(servletContext);
        annoContext.register(WebConfig.class);
        annoContext.refresh();

        //create dispatcherServlet
        DispatcherServlet ds = new DispatcherServlet(annoContext);
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcherServlet", ds);
        registration.addMapping("/");



    }
}

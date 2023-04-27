package src.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Date;

public class InitListener implements ServletContextListener {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("[ ---- contextInitialized ---- " + new Date() + "]");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("[ ---- contextDestroyed ---- " + new Date() + "]");
    }
}

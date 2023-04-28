package src.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Date;


public class InitListener implements ServletContextListener {

    private static Logger log = (Logger) LogManager.getLogger(InitListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info(" ---- contextInitialized ---- ");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info(" ---- contextDestroyed ---- ");
    }
}

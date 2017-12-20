package com.test.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Bae B K on 2017. 12. 20.
 *
 * web.xml 역활을 하는 클래스이다.
 */
public class AppInitialzer implements WebApplicationInitializer{
    private Logger log = LoggerFactory.getLogger(AppInitialzer.class);
    
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("onStartup");
        WebApplicationContext context = getContext();
        
        servletContext.addListener(new ContextLoaderListener(context));
        
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");
    }
    
    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.test.config");
        return context;
    }
}

package com.test.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.FilterRegistration;
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
        log.info("onStartup!!");
        WebApplicationContext context = getContext();
        
        servletContext.addListener(new ContextLoaderListener(context));
        
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");
        
        this.addUtf8CharacterEncodingFilter(servletContext);
    }
    
    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.test.config");
        
        //context.register() 를 이용해서 설정 파일들을 불러 올 수 있다.
        context.register(AppConfig.class, WebMvcConfig.class);
        return context;
    }
    
    /**
     * UTF-8 캐릭터 인코딩 필터를 추가한다.
     * (참고 블로그 : https://blog.naver.com/PostView.nhn?blogId=sipzirala&logNo=220941894854&proxyReferer=https%3A%2F%2Fwww.google.co.kr%2F)
     * @param servletContext
     */
    private void addUtf8CharacterEncodingFilter(ServletContext servletContext)
    {
        FilterRegistration.Dynamic filter = servletContext.addFilter("CHARACTER_ENCODING_FILTER", CharacterEncodingFilter.class);
        filter.setInitParameter("encoding", "UTF-8");
        filter.setInitParameter("forceEncoding", "true");
        filter.addMappingForUrlPatterns(null, false, "/*");
    }
}

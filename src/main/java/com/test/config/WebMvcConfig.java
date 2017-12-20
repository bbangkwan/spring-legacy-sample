package com.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created by Bae B K on 2017. 12. 20.
 *
 * 이게 servlet context를 대체하는 클래스이다.
 * <mvc:annotation-driven></mvc:annotation-driven> 이 부분을 이 클래스에 작성 하면 됨.
 */
@EnableWebMvc
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport{

}

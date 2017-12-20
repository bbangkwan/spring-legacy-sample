package com.test.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Bae B K on 2017. 12. 20.
 *
 * application context 혹은 root context라고 불리우는 설정 파일을 대체한 클래스이다.
 *
 * intercepter 설정 등도 가능
 */
@Configuration
@ComponentScan(basePackages = "com.test")
public class AppConfig {
    private Logger log = LoggerFactory.getLogger(AppInitialzer.class);
}

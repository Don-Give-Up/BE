package com.virtukch.dongiveupbe.security.common.config;

import com.virtukch.dongiveupbe.security.common.interceptor.JwtTokenInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 웹 관련 설정을 위한 구성 클래스입니다. 정적 자원 처리 및 보안 필터 등록을 포함합니다. 커스텀 필터를 설정하고, 그에 맞는 경로를 설정합니다.
 *
 * @author Virtus_Chae
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    // 정적 자원을 제공하기 위한 경로
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
        "classpath:/static/",
        "classpath:/public/",
        "classpath:/",
        "classpath:/resources/",
        "classpath:/META-INF/resources/",
        "classpath:/META-INF/resources/webjars/"
    };

    /**
     * 정적 자원을 제공하기 위한 리소스 핸들러를 추가합니다.
     *
     * @param registry 리소스 핸들러 레지스트리
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

    /**
     * JwtTokenInterceptor 의 새 인스턴스를 생성하고 반환합니다.
     *
     * @return 새 JwtTokenInterceptor 인스턴스
     */
    @Bean
    public JwtTokenInterceptor jwtTokenInterceptor() {
        return new JwtTokenInterceptor();
    }
}
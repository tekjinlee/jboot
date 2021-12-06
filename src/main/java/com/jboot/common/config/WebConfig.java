package com.jboot.common.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

    /*
    스프링 시큐리티에서 스프링의 CORS설정을 가져다 사용할 수 있도록 설정
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .exposedHeaders("X-AUTH-TOKEN")
                .allowCredentials(true) // 클라이언트의 쿠키를 전달하고 받을 것이기 때문에
                .allowedOrigins("http://localhost:3000");
    }
}

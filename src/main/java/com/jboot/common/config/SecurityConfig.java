package com.jboot.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private JwtAuthenticationProvider jwtAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable() // 기본생성 로그인 페이지 사용 X
        .csrf().disable() // csrf 사용 안함 -> csrf 참고 https://zzang9ha.tistory.com/341
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // JWT인증사용하므로 세션 사용
        .and()
                .authorizeRequests() // 아래 리퀘스트에 대한 사용권한
                    .antMatchers("/*/signIn", "/*/signUp").permitAll() // 가입 및 로그인 모두 허용
        .and()
                //.exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint())
        //.and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtAuthenticationProvider), UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

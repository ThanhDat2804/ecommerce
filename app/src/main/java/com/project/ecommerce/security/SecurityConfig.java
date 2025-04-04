package com.project.ecommerce.security;

import com.project.ecommerce.security.handler.CustomAccessDeniedHandler;
import com.project.ecommerce.security.handler.CustomAuthenticationEntryPoint;
import com.project.ecommerce.security.jwt.JwtAuthenticationFilter;
import com.project.ecommerce.security.jwt.JwtTokenUtil;
import com.project.ecommerce.service.UMS.impl.MemberServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MemberServiceImpl memberService;
    private final JwtTokenUtil jwtTokenUtil;
    private final CustomAuthenticationEntryPoint authenticationEntryPoint;
    private final CustomAccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/article/all", "/article/{articleId}").permitAll()
                .antMatchers(HttpMethod.GET, "/brand/listAll", "/brand/list", "/brand/product/{brandId}", "/brand/{brandId}").permitAll()
                .antMatchers(HttpMethod.GET, "/product/listAll", "/product/{id}", "/product/list").permitAll()
                .antMatchers(HttpMethod.GET, "/review/detail/{reviewId}", "/review/getAllProductReview/**").permitAll()
                .antMatchers(HttpMethod.GET, "/sale/AllPromotionSale", "/sale/AllPromotionSaleItem", "/sale/AllFlashSaleItem").permitAll()
                .antMatchers(HttpMethod.GET,"/order/payment/**").permitAll() // remove it when you have frontend that store the jwt
                .antMatchers("/swagger-ui.html",
                        "/swagger-resources/**",
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/swagger**",
                        "/v2/api**",
                        "/webjars/**").permitAll()
                .antMatchers("/", "/user/login", "/user/register").permitAll()
                //.antMatchers("/**").permitAll()
                .anyRequest()
                .authenticated();

        // TODO: remove comment when security needed
        // authenticate the JWT token before Spring Security if you have a token.
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        // TODO: handler is not being used
        httpSecurity.exceptionHandling().accessDeniedHandler(accessDeniedHandler).authenticationEntryPoint(authenticationEntryPoint);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationFilter(memberService, jwtTokenUtil);
    }
}
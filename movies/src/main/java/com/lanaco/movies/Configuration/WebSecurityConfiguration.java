package com.lanaco.movies.Configuration;

import com.lanaco.movies.Exception.CustomAccessDeniedHandler;
import com.lanaco.movies.Exception.SimpleAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

private static final String[] ADMIN_URLS = {"/content-type/**","/content-comment/**","/country/**","/episode/**","/genre/**",
        "/language/**","/movie-people/**","/movie-cast/**","/season/**"};

private static final String[] USER_URLS = {"/content/**","/users/","/genre/all/"};

private static final String[] PERMIT_ALL_URLS = {"/users/login/",
        // -- Swagger UI v2
        "/v2/api-docs", "/swagger-resources", "/swagger-resources/**", "/configuration/ui",
        "/configuration/security", "/swagger-ui.html", "/webjars/**",
        // -- Swagger UI v3 (OpenAPI)
        "/v3/api-docs/**", "/swagger-ui/**", "/actuator/**"};
    @Autowired
     UserDetailsServiceImpl userDetailsService;
    @Autowired
    SimpleAuthenticationEntryPoint simpleAuthenticationEntryPoint;
    @Autowired
    CustomAccessDeniedHandler customAccessDeniedHandler;
    @Autowired
    JwtRequestFilter jwtRequestFilter;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(PERMIT_ALL_URLS).permitAll()
                .antMatchers(ADMIN_URLS).hasRole("ADMIN")
                .antMatchers(USER_URLS).hasAnyRole("ADMIN","USER")
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling().authenticationEntryPoint(simpleAuthenticationEntryPoint)
                .accessDeniedHandler(customAccessDeniedHandler);
        http
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder encoder() {
    return new BCryptPasswordEncoder(11);
    }

}

package com.example.training1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails john = User.builder()
//                .username("john")
//                .password("{noop}test123")
//                .roles("STUDENT")
//                .build();
//
//        UserDetails mary = User.builder()
//                .username("mary")
//                .password("{noop}test123")
//                .roles("TEACHER")
//                .build();
//
//        UserDetails susan = User.builder()
//                .username("susan")
//                .password("{noop}test123")
//                .roles("TEACHER", "HEADTEACHER")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{noop}test123")
//                .roles("STUDENT", "TEACHER", "HEADTEACHER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(john, mary, susan, admin);
//    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/grades").hasRole("STUDENT")
                        .requestMatchers(HttpMethod.GET, "/grades/**").hasRole("STUDENT")
                        .requestMatchers(HttpMethod.POST, "/grades").hasRole("TEACHER")
                        .requestMatchers(HttpMethod.POST, "/grades/**").hasRole("TEACHER")
                        .requestMatchers(HttpMethod.DELETE, "/grades").hasRole("TEACHER")
                        .requestMatchers(HttpMethod.DELETE, "/grades/**").hasRole("TEACHER")
                        .requestMatchers(HttpMethod.GET, "/students").hasRole("TEACHER")
                        .requestMatchers(HttpMethod.GET, "/students/**").hasRole("TEACHER")
                        .requestMatchers(HttpMethod.POST, "/students").hasRole("HEADTEACHER")
                        .requestMatchers(HttpMethod.POST, "/students/**").hasRole("HEADTEACHER")
                        .requestMatchers(HttpMethod.PUT, "/students").hasRole("HEADTEACHER")
                        .requestMatchers(HttpMethod.PUT, "/students/**").hasRole("HEADTEACHER")
                        .requestMatchers(HttpMethod.DELETE, "/students").hasRole("HEADTEACHER")
                        .requestMatchers(HttpMethod.DELETE, "/students/**").hasRole("HEADTEACHER")
                        .requestMatchers(HttpMethod.GET, "/subjects").hasRole("TEACHER")
                        .requestMatchers(HttpMethod.GET, "/subjects/**").hasRole("TEACHER")
                        .requestMatchers(HttpMethod.POST, "/subjects").hasRole("HEADTEACHER")
                        .requestMatchers(HttpMethod.POST, "/subjects/**").hasRole("HEADTEACHER")
                        .requestMatchers(HttpMethod.GET, "/teachers").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/teachers/**").hasRole("ADMIN")
        );
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(csrf -> csrf.disable());
        return httpSecurity.build();
    }
}

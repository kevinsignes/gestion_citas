package com.kevinsignes.academia.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

/*
    @Bean
    public UserDetailsServiceImpl userDetailsService(){
        return new UserDetailsServiceImpl();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }*/


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                //.requestMatchers("/","/asignatura","/asignaturas","/asignatura/all","/aula","/aula/all","/curso","/curso/all","/notas","/perfil","/usuario/all").authenticated()
                .requestMatchers("/**").permitAll()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .usernameParameter("username")
                .loginPage("/login")
                .defaultSuccessUrl("/index") //TODO:
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/index").permitAll();

        return http.build();
    }

}

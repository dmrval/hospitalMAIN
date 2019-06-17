package com.dmrval.hospitalapp.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ComponentScan("com.dmrval")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/administrator/**").hasAuthority("ADMIN")
                .antMatchers("/doctor/**").hasAuthority("DOCTOR")
                .antMatchers("/patient/**").hasAuthority("PATIENT")
                .anyRequest().permitAll()
                .antMatchers("/signUp").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler((req, res, auth) -> {
                    for (GrantedAuthority authority : auth.getAuthorities()) {
                        if (authority.getAuthority().equals("ADMIN")) {
                            res.sendRedirect("/administrator/");
                        } else if (authority.getAuthority().equals("DOCTOR")) {
                            res.sendRedirect("/doctor/");
                        } else if (authority.getAuthority().equals("PATIENT")) {
                            res.sendRedirect("/patient/");
                        }
                    }
                })
                .permitAll()
                .and()
                .logout()
                .permitAll().
                and()
                .exceptionHandling().accessDeniedPage("/accessDenied");
        http.csrf().disable();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);

    }


}
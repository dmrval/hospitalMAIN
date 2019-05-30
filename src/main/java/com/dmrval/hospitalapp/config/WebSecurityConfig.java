package com.dmrval.hospitalapp.config;

//import com.dmrval.hospitalapp.service.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@ComponentScan("com.dmrval")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/administrator/**").hasAuthority("ADMIN")
                    .antMatchers("/signUp").permitAll()
                    .anyRequest().permitAll()
                .and()
                    .formLogin()
                    .loginPage("/login")
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
        auth.userDetailsService(userDetailsService);


        /**this is for debug use blya*/
        /*inMemoryAuthentication()
                .withUser("dmrval").password("irbis").roles("ADM");*/
    }




}
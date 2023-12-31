package org.example.config;

import org.example.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private CustomUserDetailsService userDetailsService;

    private CustomLogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    public SecurityConfig(CustomUserDetailsService userDetailsService, CustomLogoutSuccessHandler logoutSuccessHandler){
        this.userDetailsService = userDetailsService;

        this.logoutSuccessHandler = logoutSuccessHandler;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
@Override
    protected void configure(HttpSecurity http) throws Exception {
http
        .authorizeRequests()
          .antMatchers("/public/**").permitAll()
          .anyRequest().authenticated()
          .and()
        .formLogin()
          .loginPage("/login")
          .defaultSuccessUrl("/dashboard")
          .permitAll()
          .and()
        .logout()
          .logoutUrl("/logout")
          .logoutSuccessHandler(logoutSuccessHandler)
          .permitAll();
    }

}

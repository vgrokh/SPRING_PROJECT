package com.vgrokh.springcrud.config;

import com.vgrokh.springcrud.model.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    @Qualifier("userDetailsServiceImpl")
    UserDetailsService userDetailsService;



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/**").hasAuthority(Authority.DEVELOPERS_WRITE.getAuthority())
                .antMatchers(HttpMethod.POST, "/api/**").hasAuthority(Authority.DEVELOPERS_WRITE.getAuthority())
                .antMatchers(HttpMethod.DELETE, "api/**").hasAuthority(Authority.DEVELOPERS_WRITE.getAuthority())
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder){
        authenticationManagerBuilder.authenticationProvider(daoAuthenticationProvider());
    }


    @Bean
    protected PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }


    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }
}

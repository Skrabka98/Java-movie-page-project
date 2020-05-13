package com.example.project1.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class Login extends WebSecurityConfigurerAdapter {



        //cos robiłam źle prawie działam jutro poprawie jak coś reszta kodu do tego jest w
    // aplication.properties a pod http://localhost:8080/victory powinien sie wywielic do przekierowania
    //na strone logowania github i po zalogowaniu as przekierować
    @Override
    protected void configure (HttpSecurity http) throws Exception{
            http.authorizeRequests().antMatchers("/victory").authenticated();
    }

}

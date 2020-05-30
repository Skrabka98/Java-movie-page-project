package com.example.project1.security;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@KeycloakConfiguration
public class SeciurityConfiguraction extends KeycloakWebSecurityConfigurerAdapter {

    @Bean
    KeycloakSpringBootConfigResolver keycloakConfigResolver(){
        return new KeycloakSpringBootConfigResolver();
    }

    @Autowired
    void configureGlobal(AuthenticationManagerBuilder managerBuilder){
     var authorityMapper = new SimpleAuthorityMapper();
     authorityMapper.setPrefix("ROLE_");
     authorityMapper.setConvertToUpperCase(true);
     KeycloakAuthenticationProvider keycloakProvider = keycloakAuthenticationProvider();
     keycloakProvider.setGrantedAuthoritiesMapper(authorityMapper);
     managerBuilder.authenticationProvider(keycloakProvider);
    }

    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.authorizeRequests()
                .antMatchers( "/film/*")
                .hasRole("USER")
                .antMatchers("/admin","/admin/**").hasRole("ADMIN")
                .anyRequest().permitAll();



    }

}


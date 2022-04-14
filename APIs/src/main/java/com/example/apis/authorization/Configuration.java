package com.example.apis.authorization;

import com.google.api.client.util.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.*;

//@EnableWebSecurity
//public class Configuration extends WebSecurityConfigurerAdapter {
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.oauth2ResourceServer().jwt();
////    }
//
//  /
//
////    @Override
////    public void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests()
////                .mvcMatchers("/api/public").permitAll()
////                .mvcMatchers("/api/private").authenticated()
////                .mvcMatchers("/api/private-scoped").hasAuthority("SCOPE_read:messages")
////                .and().cors()
////                .and().oauth2ResourceServer().jwt();
////    }
//
//
//}

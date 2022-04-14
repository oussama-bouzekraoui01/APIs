package com.example.apis.GoogleCalendar;

import com.example.apis.authorization.AudienceValidator;
import com.google.api.client.util.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.*;
@EnableWebSecurity
@Configuration
public class CalendarSecurity extends WebSecurityConfigurerAdapter {

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.csrf().disable().authorizeRequests()
                    .antMatchers(HttpMethod.GET).permitAll()
                    .antMatchers(HttpMethod.POST).permitAll()
                    .antMatchers(HttpMethod.DELETE).permitAll()
                    .antMatchers(HttpMethod.PUT).permitAll()
//                    .mvcMatchers("/api/public").permitAll()
//                    .mvcMatchers("/api/private").authenticated()
//                    .mvcMatchers("/api/private-scoped").hasAuthority("SCOPE_read:messages")
//                    .and().cors()
//                    .and().oauth2ResourceServer().jwt();
                    .anyRequest().authenticated();
        }
//    @Value("${auth0.audience}")
//    private String audience;
//
//    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
//    private String issuer;
//
//    @Bean
//    JwtDecoder jwtDecoder() {
//        NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder)
//                JwtDecoders.fromOidcIssuerLocation(issuer);
//
//        OAuth2TokenValidator<Jwt> audienceValidator = new AudienceValidator(audience);
//        OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuer);
//        OAuth2TokenValidator<Jwt> withAudience = new DelegatingOAuth2TokenValidator<>(withIssuer, audienceValidator);
//
//        jwtDecoder.setJwtValidator(withAudience);
//
//        return jwtDecoder;
//    }
}

package com.myorganization.myservice.configuration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SpringBootConfiguration
@EnableWebSecurity
@Profile("!unitTest")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private String policy = "default-src 'self'";

    /* ---This is how the original class is, commented to allow service run locally
    private String jwksUri;
    
    private String policy = "default-src 'self'";

    private MyServiceRestTemplateFactory restTemplateFactory;
    
    private OrganizatonalUserTokenConverter organizatonalUserTokenConverter = new OrganizatonalUserTokenConverter();


    public SecurityConfig(@Value("${authentication.discoveryURL}") String discoveryUrl , MyServiceRestTemplateFactory restTemplateFactory) throws IOException {
        RestTemplate restTemplate = restTemplateFactory.create();
        ResponseEntity<String> response = restTemplate.getForEntity(discoveryUrl, String.class);
        JsonNode node = new ObjectMapper().readTree(response.getBody());
        this.jwksUri = node.get("jwks_uri").asText();
        this.jwksUri = "jwksUri";
        this.restTemplateFactory = restTemplateFactory;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
       
    	http.headers().contentSecurityPolicy(policy); // FoD vulnerability "HTML5: Missing Content Security Policy"
    	
    	http
            .csrf().disable()
            .cors().disable()
            .httpBasic().disable()
            .authorizeRequests()
	    		// All accesses must be authenticated through token with Liferay user and password except these endpoints, 	    		
	            .antMatchers("/api/status").permitAll()
	            .anyRequest().authenticated()
            .and()
            .oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(x -> {
                    // Core framework expects Authorization to contain a specific instance (DataSourceEventUtils#setOrganizationForEvent)
                    Map<String, Object> claims = new HashMap<>(x.getClaims());
                    // Jose's JWT contains a list for Audience, but the core's converter expects a String
                    claims.computeIfPresent("aud", (before, after) -> { return ((Collection<?>)after).iterator().next().toString(); } );
                    // OrganizatonalUserTokenConverter requires Subscriber to be present
                    claims.putIfAbsent("sub", "UNKNOWN");
                    return (AbstractAuthenticationToken) organizatonalUserTokenConverter.extractAuthentication(claims);
                });
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder
                .withJwkSetUri(jwksUri)
                .restOperations(restTemplateFactory.create())
                .build();
    }
    -----------------------  */

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.headers().contentSecurityPolicy(policy); // FoD vulnerability "HTML5: Missing Content Security Policy"

        http
                .csrf().disable()
                .cors().disable()
                .httpBasic().disable()
                .authorizeRequests()
                // All accesses must be authenticated through token with Liferay user and password except these endpoints,
                .antMatchers("api/status" , "/api/idvalidator").permitAll()
                .anyRequest().authenticated();
    }

}
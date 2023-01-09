package com.shiva.learnspring;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.KeySourceException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSelector;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncodingException;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;


@Configuration
public class JwtSecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        http.sessionManagement(
                session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        http.httpBasic();

        http.csrf().disable();

        http.headers().frameOptions().sameOrigin();

        http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

        return http.build();
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
                .build();
    }

    @Bean
    public UserDetailsService userDetailService(DataSource dataSource) {

        var user = User.withUsername("in28minutes")
                //.password("{noop}dummy")
                .password("dummy")
                .passwordEncoder(str -> passwordEncoder().encode(str))
                .roles("USER")
                .build();

        var admin = User.withUsername("admin")
                //.password("{noop}dummy")
                .password("dummy")
                .passwordEncoder(str -> passwordEncoder().encode(str))
                .roles("ADMIN", "USER")
                .build();

        var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.createUser(user);
        jdbcUserDetailsManager.createUser(admin);

        return jdbcUserDetailsManager;
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }


    // Creating Decoder 1. Create RSA-Pair
    @Bean
    public KeyPair createKeyPair() throws NoSuchAlgorithmException {

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        return keyPairGenerator.generateKeyPair();
    }

    // Creating Decoder 2. create RSA-key object
    @Bean
    public RSAKey rsaKey(KeyPair keyPair) {

        return new RSAKey
                .Builder((RSAPublicKey) keyPair.getPublic())
                .privateKey(keyPair.getPrivate())
                .keyID(UUID.randomUUID().toString())
                .build();
    }

    // Creating Decoder 3. create JWKSource(Json Web Key Resource)
    @Bean
    public JWKSource<SecurityContext> jwkSource(RSAKey rsaKey){
        var jwkSet =  new JWKSet(rsaKey);

        var jwkSource =  new JWKSource<>(){
            @Override
            public List<JWK> get(JWKSelector jwkSelector, SecurityContext securityContext) throws KeySourceException {
                return jwkSelector.select(jwkSet);
            }
        };
        return jwkSource;

        // using lambda function
        // return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);
    }

    // Create Decoder -> Final step: create public RESA key
    @Bean
    public JwtDecoder jwtDecoder(RSAKey rsaKey) throws JOSEException {

        return NimbusJwtDecoder.withPublicKey(rsaKey.toRSAPublicKey()).build();
    }

    // Create Encoder
    @Bean
    public JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource){
        return new NimbusJwtEncoder(jwkSource);
    }


    // @Bean
    // public UserDetailsService userDetailService(DataSource dataSource) {
    //
    //     var user = User.withUsername("in28minutes")
    //             .password("{noop}dummy")
    //             .roles("USER")
    //             .build();
    //
    //     var admin = User.withUsername("admin")
    //             .password("{noop}dummy")
    //             .roles("ADMIN", "USER")
    //             .build();
    //
    //     var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
    //     jdbcUserDetailsManager.createUser(user);
    //     jdbcUserDetailsManager.createUser(admin);
    //
    //     return jdbcUserDetailsManager;
    // }

}


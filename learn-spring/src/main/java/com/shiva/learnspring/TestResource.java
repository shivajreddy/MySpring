package com.shiva.learnspring;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.stream.Collectors;

@RestController
public class TestResource {

    private JwtEncoder jwtEncoder;

    public TestResource(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    @GetMapping("/test")
    public String test() {
        return "test ok";
    }

    @PostMapping("/authenticate")
    public JwtResponse authenticate(Authentication authentication) {
        return new JwtResponse(createToken(authentication));

    }

    private String createToken(Authentication authentication){
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plusSeconds(60 * 30))
                .subject(authentication.getName())
                .claim("scope", createScope(authentication))
                .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(claims))
                .getTokenValue();
    }

    private String createScope(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
    }
}

record JwtResponse (String token){}
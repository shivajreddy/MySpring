package com.shiva.ss.ssc10e1.security;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;


@Configuration
public class SecurityConfiguration {

	// # 0. Filter chain for Authorization Server [@Order 1]
	@Bean
	@Order(1)
	public SecurityFilterChain securityFilterChainAuthorizationServer(HttpSecurity http) throws Exception {

		// # 1. enable oauth2 default configuration
		OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);

		// # 2. enable open-id connection
		http.getConfigurer(OAuth2AuthorizationServerConfigurer.class)
				.oidc(Customizer.withDefaults());

		// # 3. set the default login end-point
		http.exceptionHandling(ex -> {
			ex.authenticationEntryPoint(
					new LoginUrlAuthenticationEntryPoint("/login")
			);
		});

		return http.build();
	}

	// # 4. set the RegisteredClientRepository bean. (use default settings for now)
	@Bean
	public RegisteredClientRepository registeredClientRepository() {
		RegisteredClient rc = RegisteredClient.withId(UUID.randomUUID().toString())
				.clientId("client")
				.clientSecret("secret")
				.scope(OidcScopes.OPENID)
				.redirectUri("https://springone.io/authorized")
				.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
				.build();
		return new InMemoryRegisteredClientRepository(rc);
	}

	// # 5. Bean for Authorization server settings
	@Bean
	public AuthorizationServerSettings authorizationServerSettings() {
		return AuthorizationServerSettings.builder().build();
	}

	// # 6. configure the key pairs for the JWT
	@Bean
	public JWKSource<SecurityContext> jwkSource() throws Exception {
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(2048);

		KeyPair kp = kpg.generateKeyPair();

		RSAPublicKey publicKey = (RSAPublicKey) kp.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) kp.getPrivate();

		RSAKey key = new RSAKey.Builder(publicKey)
				.privateKey(privateKey)
				.keyID(UUID.randomUUID().toString())
				.build();

		JWKSet set = new JWKSet(key);
		return new ImmutableJWKSet<>(set);
	}


	// # 0. Filter chain for Application [@Order 2]
	@Bean
	@Order(2)
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				// setting the default login through form-login
				.formLogin().and()

				.authorizeHttpRequests().anyRequest().authenticated().and()

				.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager(
				User.builder()
						.username("shiva")
						.password(passwordEncoder().encode("pass"))
						//.password("{noop}pass")
						.roles("user")
						.build(),
				User.builder()
						.username("admin")
						//.password("{noop}pass")
						.password(passwordEncoder().encode("pass"))
						.roles("user", "admin")
						.build()
		);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

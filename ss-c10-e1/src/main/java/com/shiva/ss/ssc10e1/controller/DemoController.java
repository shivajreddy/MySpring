package com.shiva.ss.ssc10e1.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {

	@GetMapping("/demo")
	public String demo() {
		return "demo OAuth2 ✅";
	}


	@GetMapping("/admin")
	public String adminPage() {
		return "admin page ⛑️";
	}
}

// # http://localhost:8080/oauth2/authorize?response_type=code&client_id=client&scope=openid&redirect_uri=https://springone.io/authorized&code_challenge=xxx&&code_challenge_method=S256

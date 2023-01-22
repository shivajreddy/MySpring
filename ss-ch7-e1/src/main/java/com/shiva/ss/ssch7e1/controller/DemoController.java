package com.shiva.ss.ssch7e1.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class DemoController {

	@GetMapping("/demo")
	@PreAuthorize("hasRole('user')")
	public String demo() {
		return "ch7 demo 🔥";
	}

	@GetMapping("/demodemo")
	public String demoDemo() {
		return "demodemo 🔥";
	}

	@GetMapping("/demo/2")
	public String demo2() {
		return "demo 2️⃣ 🔥";
	}

	@PostMapping("/demo/2")
	public String postDemo2() {
		return "post demo 2️⃣ 🔥";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('admin')")
	public String adminPage() {
		return "Admin page 😶";
	}

	@GetMapping("/admin/2")
	@PreAuthorize("hasRole('admin')")
	public String adminPage2() {
		return "Admin page - 2️⃣ 😶";
	}

	@GetMapping("/profile/{name}")
	@PreAuthorize(
			"""
					(#givenName == authentication.name) or
					hasRole("admin")
					"""
	)
	public String showProfile(@PathVariable("name") String givenName) {
		return "Hi " + givenName;
	}

	@GetMapping("/post-auth")
	@PostAuthorize("returnObject == 'hi'")
	public String postAuthorizeTest() {
		return "hi";
	}

	// @PreFilter  => works with either array or Collection

	@GetMapping("/demo6")
	@PreFilter("filterObject.contains('a')")
	public String demo6(@RequestBody List<String> values) {
		System.out.println("Values: " + values);
		return "Demo 6";
	}

	// @PostFilter  => the returned type must be either a Collection or an array

	@GetMapping("/demo7")
	@PostFilter("filterObject.contains('a')")
	public List<String> demo6() {
		var list = new ArrayList<String>();
		list.add("abcd");
		list.add("wert");
		list.add("qaaz");
		list.add("wrty");

		// List.of(...) // List.of creates and immutable collection
		return list;
	}


}


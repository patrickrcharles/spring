package com.luv2code.springsecurity.demo.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationWebInitializer extends AbstractSecurityWebApplicationInitializer {

	public SecurityWebApplicationWebInitializer() {
		System.out.println("SecurityWebApplicationWebInitializer()");
	}
}

package com.luv2code.springsecurity.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringDispatchServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		// return created demo config class
		// analogue from xml : servlet
		return new Class[] { DemoAppConfig.class } ;
	}

	@Override
	protected String[] getServletMappings() {

		// return root mapping
		// analogue from xml : servlet mapping
		return new String[] { "/" };
	}

}

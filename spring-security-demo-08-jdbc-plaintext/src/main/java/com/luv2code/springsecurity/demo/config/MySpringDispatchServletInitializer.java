package com.luv2code.springsecurity.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringDispatchServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("MySpringDispatchServletInitializer: getRootConfigClasses()");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("MySpringDispatchServletInitializer: getServletConfigClasses()");
		// return created demo config class
		// analogue from xml : servlet
		return new Class[] { DemoAppConfig.class } ;
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("MySpringDispatchServletInitializer: getServletMappings()");
		// return root mapping
		// analogue from xml : servlet mapping
		return new String[] { "/" };
	}

}

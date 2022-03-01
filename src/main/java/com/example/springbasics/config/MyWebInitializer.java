package com.example.springbasics.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
public class MyWebInitializer /* extends AbstractAnnotationConfigDispatcherServletInitializer */ {

//	@Override
//	protected Class<?>[] getRootConfigClasses() {
//		return null;
//	}
//
//	@Override
//	protected Class<?>[] getServletConfigClasses() {
//
//		return new Class[] { WebConfig.class };
//	}
//
//	@Override
//	protected String[] getServletMappings() {
//
//		return new String[] { "/" };
//	}
}
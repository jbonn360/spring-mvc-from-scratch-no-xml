package com.example.springbasics;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.example.springbasics.config.WebConfig;

public class ControllerConfig implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
		root.register(WebConfig.class);

		root.refresh();
		root.setServletContext(sc);

		sc.addListener(new ContextLoaderListener(root));

		DispatcherServlet dv = new DispatcherServlet(new GenericWebApplicationContext());

		ServletRegistration.Dynamic appServlet = sc.addServlet("welcome", dv);
		appServlet.setLoadOnStartup(1);
		//appServlet.addMapping("/test/*");
		appServlet.addMapping("/welcome");
	}
}

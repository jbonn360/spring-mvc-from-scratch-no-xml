package com.example.springbasics.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyOtherWebInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebConfig.class);

		//ctx.refresh(); // <-- causes 'No Servlet Context Set' error on startup
		ctx.setServletContext(servletContext);

		servletContext.addListener(new ContextLoaderListener(ctx)); //

		DispatcherServlet dv = new DispatcherServlet(new GenericWebApplicationContext()); //
		//DispatcherServlet dv = new DispatcherServlet(ctx);

		ServletRegistration.Dynamic appServlet = servletContext.addServlet("dispatcher", dv);
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/");
	}
	
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//    	AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//        ctx.register(WebConfig.class);
//        
//        ctx.setServletContext(servletContext);
//
//        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
//        servlet.setLoadOnStartup(1);
//        servlet.addMapping("/");
//    }
}

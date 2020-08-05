package com.sk.initializer;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.sk.servlet.MarriageServlet;

public class MyWebAppInitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>>  set, ServletContext sc) throws ServletException {
		MarriageServlet servlet=null;
		//create User-Defined Servlet class Object
		servlet=new MarriageServlet();
		//Register With Container 
		ServletRegistration.Dynamic dyna=sc.addServlet("marriage",servlet);
		//enable load on Startup
		dyna.setLoadOnStartup(1);
		//add url pattern
		dyna.addMapping("/marriageurl");
	}
}

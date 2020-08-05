package com.sk.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class LcServlet extends HttpServlet{

	static {
		System.out.println("LcServlet:: static block");
	}
	
	public LcServlet(){
		System.out.println("LcServlet:: 0 - param constructor");
	}
	public void init(ServletConfig config) {
		System.out.println("LcServlet: Servletconfig "+config.getInitParameterNames());
		System.out.println("Servlet value::"+config.getInitParameter("dbname"));
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException {
		System.out.println("LcServlet.service()");
		System.out.println("service method");
		PrintWriter pw=null;
		//get print writer
		pw=res.getWriter();
		//set the ContentType
		res.setContentType("text/html");
		
		//get the logic
		pw.println("Date as ::"+new java.util.Date());
		pw.close();
	}
	
	public void destroy() {
		System.out.println("LcServlet:: Destroy the object:: Destroy()");
	}	
}

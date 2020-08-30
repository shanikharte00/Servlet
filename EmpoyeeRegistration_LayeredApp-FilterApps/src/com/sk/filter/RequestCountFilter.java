package com.sk.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/*")
public class RequestCountFilter extends HttpFilter {
	private int count;
	@Override
	public void init() throws ServletException {
		count=0;
	}	
	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
		throws IOException, ServletException {
		ServletContext sc=null;
		//increment Request count
		count++;	
		//Keep count in ServletContextObject
		sc=getServletContext();
		sc.setAttribute("reqCount",count);
		//delegate request next filter /dest comp
		chain.doFilter(request,response);
		
		}
}

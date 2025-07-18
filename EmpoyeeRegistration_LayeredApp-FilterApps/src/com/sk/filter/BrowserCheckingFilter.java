package com.sk.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class BrowserCheckingFilter extends HttpFilter {
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter pw=null;
		String browser=null;
		//get PrintWriter
		pw=res.getWriter();
		//set Contenttype
		res.setContentType("text/html");
		//get current browser name
		browser=req.getHeader("user-agent");
		if(browser.indexOf("Chrome")==-1) {
			pw.println("<h1 style='color';text-align='center'>Use chrome browser to visit this browser");
			return;
		}
		else{
			System.out.println("BrowserCheckingFilter.doFilter()::Before");
			chain.doFilter(req, res);
			System.out.println("BrowserCheckingFilter.doFilter()::After");
		}
	}
}

package com.sk.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/*")
public class TimeCheckFilter extends HttpFilter {
	static {
		System.out.println("TimeCheckFilter : static block");
	}

	public TimeCheckFilter() {
		System.out.println("TimeCheckFilter 0-param constructor");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("TimeCheckFilter.init()");
	}

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		Calendar calendar = null;
		int hour = 0;

		PrintWriter pw = null;
		// get printwriter
		pw = response.getWriter();
		// set content type
		response.setContentType("text/html");
		System.out.println("TimeCheckFilter.doFilter()");
		//System.out.println("browser name::"+request.getHeader("user-agent"));
		// get System date
		calendar = Calendar.getInstance();
		// get current hour of day
		hour = calendar.get(Calendar.HOUR_OF_DAY);
		if (hour < 9 || hour > 20 ) {
			pw.println("<h1 style='color:red;text-align:center'>Request must not be given before9 am and after 4pm</h1>");
			return;
		}
		else {
			System.out.println("TimeCheckFilter.doFilter():: Before ");
			chain.doFilter(request, response);
			System.out.println("TimeCheckFilter.doFilter():: After");
		}
	}//dofilter(-,-)
	
	@Override
	public void destroy() {
		System.out.println("TimeCheckFilter.destroy()");
	}
	
	
}

package com.sk.filter;

import java.io.IOException;
import java.util.Random;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({"/employee_register.jsp","/controller"})
public class DoublePostingPreventionFilter extends HttpFilter {
	
	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession ses=null;
		String method=null;
		RequestDispatcher rd=null;
		int clientToken=0,serverToken=0;
		//get session
		ses=request.getSession();
		//get request method
		method=request.getMethod();
		
		if(method.equalsIgnoreCase("GET")) {
			//generate serverside token and make it serverside token , also make client side token in the form page
			ses.setAttribute("sToken",new Random().nextInt(1000));
			chain.doFilter(request, response);
			
		}
		
		else {
			//read server token and client token values..
			clientToken=Integer.parseInt(request.getParameter("cToken"));
			serverToken=(int)ses.getAttribute("sToken");
			System.out.println(clientToken+"  "+serverToken);
			//compare both clientToken, serverToken
			if(clientToken==serverToken) {//if matching
					ses.setAttribute("sToken", new Random().nextInt(10000));
					chain.doFilter(request, response);
			}
			else {//if not matching
				rd=request.getRequestDispatcher("/error.html");
				rd.forward(request, response);
			}
		}
	}
}

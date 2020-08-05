package com.sk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/s1url")
public class Servlet1 extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		ServletContext sc1=null;
		
		ServletContext sc2=null;
		RequestDispatcher rd=null;
		
		//get printWriter
		pw=res.getWriter();
		//set Content Type
		res.setContentType("text/html");
		//Read form data
	    int val=Integer.parseInt(req.getParameter("t1")); 
	    pw.println("<h2 style='color:red;text-align:center'>");
	    int square=val*val;
	    pw.println("Square is::"+square);
	    //get servletContext object of current web application
	    sc1=getServletContext();
	    //get servletcontext object of WATwo web application
	    sc2=sc1.getContext("/WATwo");
	    //get ServletDispatcher object pointing to secondservlet
	    rd=sc2.getRequestDispatcher("/s2url");
	    
	    rd.include(req, res);
	    pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}

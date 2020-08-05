package com.sk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/s4url")
public class ServletForth extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String val1=null;
		PrintWriter pw=null;
		HttpSession ses=null;
		ServletContext sc=null;
		//get printWriter
		pw=res.getWriter();
		//set contentType
		res.setContentType("text/html");
		//write a business logic
		//keep the result in request scope
		pw.println("ServletForth Component"+req.getAttribute("att1"));
		//create Session
		ses=req.getSession();
		pw.println("<br>ServletForthSession Component"+ses.getAttribute("att2"));
		//create ServletContext
		sc=getServletContext();
		pw.println("<br>ServletForth Component"+sc.getAttribute("att3"));
				
		//close stream
		pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

}

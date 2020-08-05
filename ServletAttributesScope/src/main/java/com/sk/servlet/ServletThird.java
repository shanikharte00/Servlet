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
import javax.servlet.http.HttpSession;
@WebServlet("/s3url")
public class ServletThird extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String val1=null;
		PrintWriter pw=null;
		HttpSession ses=null;
		RequestDispatcher rd=null;
		ServletContext sc=null;
		//get printWriter
		pw=res.getWriter();
		//set contentType
		res.setContentType("text/html");
		//write a business logic
		//keep the result in request scope
		pw.println("ServletThird Component"+req.getAttribute("att1"));
		ses=req.getSession();
		pw.println("<br>ServletThirdSession component"+ses.getAttribute("att2"));
		//create ServletContext
		sc=getServletContext();
		pw.println("<br>ServletThirdServletContext component"+sc.getAttribute("att3"));
		//forward request to servlet third
		rd=req.getRequestDispatcher("/s4url");
		rd.forward(req, res);
		//close stream
		pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

}

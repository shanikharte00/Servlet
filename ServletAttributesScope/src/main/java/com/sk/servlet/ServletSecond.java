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
@WebServlet("/s2url")
public class ServletSecond extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String val1=null;
		PrintWriter pw=null;
		RequestDispatcher rd=null;
		HttpSession ses=null;
		ServletContext sc=null;
		//get printWriter
		pw=res.getWriter();
		//set contentType
		res.setContentType("text/html");
		//write a business logic
		pw.println("ServletSecond Component"+req.getAttribute("att1"));
		//Httpsession attribute
		ses=req.getSession();
		pw.println("<br>ServletSecondSession component"+ses.getAttribute("att2"));
		//ServletContext attribute
		sc=getServletContext();
		pw.println("<br>ServletThirdContext Component"+sc.getAttribute("att3"));
		//take the requestdispatcher  for forward the request
		rd=req.getRequestDispatcher("/s3url");
		rd.forward(req, res);
		//close stream
		pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

}

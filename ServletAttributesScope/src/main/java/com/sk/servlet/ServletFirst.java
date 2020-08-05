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
@WebServlet("/s1url")
public class ServletFirst extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		RequestDispatcher rd=null;
		HttpSession ses=null;
		ServletContext sc=null;
		//get printWriter
		pw=res.getWriter();
		//set contentType
		res.setContentType("text/html");
		//write a business logic
		//create a request attribute
		req.setAttribute("att1", "val1");
		//create a HttpSession Attribute
		ses=req.getSession();
		ses.setAttribute("att2","val2");
		//create ServletContext Attribute
		sc=getServletContext();
		sc.setAttribute("att3", "val3");
		//forward the request to second servlet
		rd=req.getRequestDispatcher("/s2url");
		rd.forward(req, res);
		//close streams
		pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}

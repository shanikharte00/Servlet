package com.sk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	String ss=null;
	PrintWriter pw=null;
	//get PrintWriter
	pw=res.getWriter();
	//set Content type
	res.setContentType("text/html");
	//get the parameter
	ss=req.getParameter("ss");
	//get the string parameter and pass to the text box
	pw.println("<a href=https://www.google.com/search?q="+ss+">serach on Google</a>");
	//close stream
	pw.close();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}

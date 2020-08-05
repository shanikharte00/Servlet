package com.sk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter pw=null;
	String pname=null,fname=null;
	String ms=null;
	//get PrintWriter
	pw=res.getWriter();
	//set Content Type
	res.setContentType("text/html");
	//get parameter
	pname=req.getParameter("pname");
	fname=req.getParameter("fname");
	ms=req.getParameter("ms");
	//handle non select state of check box
	ms=(ms==null)?"single":ms;
	//generate form2 dynamically based on marital status
	if(ms.equalsIgnoreCase("married")) {
		pw.println("<h1 style='color:red;text-align:center'>Provide Marriage life</h1>");
		pw.println("<form action='secondurl' method='post'>");
		pw.println("Spouse name:: <input type='text' name='f2t1'>");
		pw.println("Number of kids:: <input type='text' name='f2t2'><br>");
		pw.println("<input type='submit' value='register'/>");
		pw.println("</form>");
	}
	else if(ms.equalsIgnoreCase("single")) {
		pw.println("<h1 style='color:red;text-align:center'>Provide Bachelor life</h1>");
		pw.println("<form action='secondurl' method='post'>");
		pw.println("When you want to marry?::<input type='text' name='f2t1'/><br>");
		pw.println("Why do you want to marry?:: <input type='text' name='f2t2'/><br>");
		pw.println("<input type='submit' value='register'/>");
		pw.println("</form>");
	}
	//close stream
	pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}

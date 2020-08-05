package com.sk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter pw=null;
	String name=null,fname=null,ms=null;
	//get the printWriter
	pw=res.getWriter();
	//set the Content Type
	res.setContentType("text/html");
	//get the parameter
	name=req.getParameter("name");
	fname=req.getParameter("fname");
	ms=req.getParameter("ms");
	
	ms=(ms==null)?"single":ms;
	//generate form2 dynamically based on marital status
	if(ms.equalsIgnoreCase("married")) {
		pw.println("<H1 style='color:red;text-align:Center'> Married life<H1>");
		pw.println("<form action='secondurl' method='POST'>");
		pw.println("Spouse Name::<input type='text' name='spouse'>");
		pw.println("How Many kids you have??::<input type='text' name='kidscount'>");
		pw.println("<input type='hidden' name='hname' value="+name+">");
		pw.println("<input type='hidden' name='hfname' value="+fname+">");
		pw.println("<input type='hidden' name='hms' value="+ms+">");
		pw.println("<input type='submit' value='Register'>");
		
	}
	else if(ms.equalsIgnoreCase("single")) {
		pw.println("<H1 style='color:red;text:align:center'>Bachelor's life</H1>");
		pw.println("<form action='secondurl' method='POST'>");
		pw.println("Why you want marry??<input type='text' name='wtm1'>");
		pw.println("When do you want to marry?<input type='text' name='wtm2'/>");
		pw.println("<input type='hidden' name='hname' value="+name+">");
		pw.println("<input type='hidden' name='hfname' value="+fname+"><br>");
		pw.println("<input type='hidden' name='hms' value="+ms+">");
		pw.println("<input type='submit' value='Register'>");
		pw.println("</form>");
	}
	//close Stream
	pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}

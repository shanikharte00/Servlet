package com.sk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		PrintWriter pw=null;
		//get the printwriter
		pw=res.getWriter();
		res.setContentType("text/html");
		String Countrycode[]= {"New Delhi","Washigton DC","Islamabad","Mascow"};
		
		//get the request parameter
		int i=Integer.parseInt(req.getParameter("Country"));
		
		
		pw.println("<h1 style='color:red'>Country capital is::</h1>"+Countrycode[i]);
		pw.println("<a href='form.html'>home</a>");
		pw.close();
		
	}
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
				doGet(req, res);
	}
}

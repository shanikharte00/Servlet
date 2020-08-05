package com.sk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name=null;
		String tage=null;
		List<String> range=null;
		int age=0;
		String vstatus=null;
		PrintWriter pw=null;
		//get the PritWriter
		pw=res.getWriter();
		//set the response  type in MIME 
		res.setContentType("text/html");
		//get the request parameter 
		name=req.getParameter("name");
		tage=req.getParameter("age");
		//age=Integer.parseInt(tage);
		
		vstatus=req.getParameter("vflag");
		if(vstatus.equals("no")) {
		range=new ArrayList<String>();
		
		if(name.equals("") || name==null || name.length()==0) {
			range.add("Please Give the Name");
		}
	    
		if(tage.equals("") || tage==null || name.length()==0)
		{
			range.add("Please Give the age");
		}
		
		else{
		try {
			//if string value is give to value that time Number Exception will generate
			age=Integer.parseInt(tage);
			
			if(age<1 && age>130) {
				range.add("<h2 style='Color:red'>please give valid age in range of 1 to 130</h2>");
			}
		   
		}
		
		catch(NumberFormatException nfe) {
			nfe.printStackTrace();
			range.add("<h2 style='Color:red;'>Please give the valid age</h2>");
			}	
		}
	
		if(range.size()!=0) {
			for(String s:range) {
				pw.println("<h1 style='color:red;'>"+s+"</h1>");		
			}
		}
		}
	    //w. the logic
		if(age>1 && age<130) {
		if(age>18) {
			pw.println("<h1 style='color:red;text-align:center;'>"+name+" You are eligible to vote</h1>");}
		else {
			pw.println("<h1 style='color:red;text-align:center;'>"+name+" You are not eligible to vote<h1/>");}
			
		}
		
		else {
		pw.println("<h1 style='color:red;text-align:center;'>"+name+" You are not eligible to vote<h1/>");}
		pw.println("<a href='form.html'style='color:red'><img src='img\\Home-icon.png'></a>");
		pw.close();	
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}

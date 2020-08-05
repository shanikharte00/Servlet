package com.sk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
		PrintWriter pw=null;
		float val1=0.0f,val2=0.0f;	
		String Pval=null;
		//get the PrintWriter
		pw=res.getWriter();
		
		//set the MIME response type 
		res.setContentType("text/html");
		Pval=req.getParameter("s1");
		//when you take the link1 & link2 (System Properties that time val1 and val2 is goes as a null values thats why NullPointer Exception will Generate)
		//take this condition for above reason
		if(!Pval.equalsIgnoreCase("link1") && !Pval.equalsIgnoreCase("link2") )
		{
		//get the parameter
		val1=Float.parseFloat(req.getParameter("Val1"));
		val2=Float.parseFloat(req.getParameter("Val2"));
		}
		
		if(Pval.equalsIgnoreCase("add")) 
			pw.println("<h1 style='Color:Red;Text-family:Arial;Text-align:Left;'>"+ (val1+val2) +"+</h1>");
		
		else if(Pval.equalsIgnoreCase("sub")) 
			pw.println("<h1 style='Color:Blue;Text-family:Arial;Text-align:Left'>"+(val1-val2)+"</h1>");
		
		else if(Pval.equalsIgnoreCase("mul")) 
			pw.println("<h1 style='Color:Green;Text-family:Arial;Text-align:left'>"+(val1*val2)+"</h1>");
		
		else if(Pval.equalsIgnoreCase("Div")) 
			pw.println("<h1 style='Color:Red;Text-family:Arial;Text-align:left'>"+(val1/val2)+"</h1>");
		
		else if(Pval.equalsIgnoreCase("link1"))
			pw.println("<h1 style='Color:Red;Text-family:Arial;Text-align:Left'>"+System.getProperties()+"</h1>");
		
		else if(Pval.equalsIgnoreCase("link2"))
			pw.println("<h1 style='Color:Red;Text-family:Arial;Text-aligh:left'></h1>"+new Date());
		
		}		
		
		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
		}
		
}


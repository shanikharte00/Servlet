package com.sk.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarrageServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		String name=null;
		int age=0;
		String gender=null;
		PrintWriter pw=null;
		//get the PrintWriter
		pw=res.getWriter();
		//set response Content type
		res.setContentType("text/html");
		
		name=req.getParameter("name");
		age=Integer.parseInt(req.getParameter("age"));
		gender=req.getParameter("gender");
		//write a business logic
		if (gender.equalsIgnoreCase("male")) {
			if(age>21) {
				pw.println(name+"you are eligible to marrage");
			}
			else {
				pw.println(name+"you are not eligible to marrage");
			}
		}
		else {
			if(age>18) {
				pw.println(name+"you are eligible to marrage lady");
			}
			else {
				pw.println(name+"you are not eligible to marrage girl");
			}
		}
		
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		doGet(req,res);
	}
	
	
}

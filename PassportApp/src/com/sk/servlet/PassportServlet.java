package com.sk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PassportServlet extends HttpServlet{
		@Override
		public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
			String Name=null;
			int Age=0;
			String Nationality=null;
			
			PrintWriter pw=null;
			//get printwriter
			pw=res.getWriter();
			//set Mime contentType
			res.setContentType("text/html");
			
			//get the request Parameter from browser
			Name = req.getParameter("Username");
			Age = Integer.parseInt(req.getParameter("Age"));
			Nationality = req.getParameter("Nationality");
			
			if(Age>=18 && Nationality.equalsIgnoreCase("Indian"))
				pw.println("<h1 style='Color:Green'>"+Name+" you are Eligible to get Passport :</h1>");
			else
				pw.println("<h1 style='Color:Green'>"+Name+"you are not Eligible to get Passport :</h1>");
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(req, resp);
		}
	}
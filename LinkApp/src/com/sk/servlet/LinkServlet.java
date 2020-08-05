package com.sk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinkServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		String link=null;
		PrintWriter pw=null;
		//get the printWriter
		pw=res.getWriter();
		//set response type 
		res.setContentType("text/html");
		
		Locale locales[]=null;
		//get the request parameters
		link=req.getParameter("s1");
		
		if(link.equalsIgnoreCase("link1")) {
			locales = Locale.getAvailableLocales();
			for(Locale lc:locales) {
				pw.println(lc.getDisplayCountry()+"<br/>");
			}
		}
		else if(link.equalsIgnoreCase("link2")) {
			locales = Locale.getAvailableLocales();
			for(Locale lc:locales) {
				pw.println(lc.getDisplayLanguage()+"<br/>");
			}
		}
		else {
			pw.println("DAte and Time"+new Date());
		}
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}
}

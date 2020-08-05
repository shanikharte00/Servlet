package com.sk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/scsurl")
public class ShowCookiesServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		Cookie cks[]=null;
		//get printWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read cookies
		cks=req.getCookies();
		//display cookies
		pw.println("<b>All cookies are</b><br>");
		for(Cookie ck:cks)
		{
			pw.println(ck.getName()+" "+ck.getValue()+"<br>");
		}
		//close Stream
		pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}

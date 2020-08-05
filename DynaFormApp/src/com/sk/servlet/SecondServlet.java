package com.sk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name=null,fname=null, ms = null;
		String f2val1=null,f2val2=null;
		PrintWriter pw=null;
		//get PrintWriter
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read form1/req1 data
		name=req.getParameter("pname");
		fname=req.getParameter("fname");
		ms=req.getParameter("ms");
		//read form2/req2 data
		f2val1=req.getParameter("f2t1");
		f2val2=req.getParameter("f2t2");
		
		//Generate dynamic webpage displaying format1/req1 and format2/req2 data
		pw.println("<br> form1/req1 data:: "+name+".."+fname+".."+ms);
		pw.println("<br> form2/req2 data:: "+f2val1+".."+f2val2);
		pw.close();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
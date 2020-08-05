package com.sk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s2url")
public class Servlet2 extends HttpServlet {
@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int cube=0;
		PrintWriter pw=null;
		//get PrintWriter
		pw=res.getWriter();
		//set contentType
		res.setContentType("text/html");
		//w.b.logic
		int val=Integer.parseInt(req.getParameter("t1"));
		cube=val*val*val;
		pw.println("SecondServlet cube is::" +cube);
		
	}
 @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}

package com.sk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/search1url")
public class SearchServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		//get the PrintWriter
		pw=res.getWriter();
		String ss=null,engine=null,url=null;
		//set Content type
		res.setContentType("text/html");
		//read form data
		ss=req.getParameter("ss");
		engine=req.getParameter("engg");
		if(engine.equalsIgnoreCase("google"))
			url="https://www.google.com/search?q="+ss;
		else if(engine.equalsIgnoreCase("yahoo"))
			url="https://in.search.yahoo.com/search?p="+ss;
		else if(engine.equalsIgnoreCase("ask"))
			url="https://www.ask.com/web?q="+ss;
		else
			url="https://www.bing.com/search?q="+ss;
		
		//perform sendRedirection(implicit Request)
		res.sendRedirect(url);
//		RequestDispatcher rd=req.getRequestDispatcher("input.html");
//		rd.include(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}

package com.sk.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HtmlServlet extends HttpServlet
{	
	static {
		System.out.println("HtmlServlet:: static block");
	}
	public HtmlServlet(){
		System.out.println("HtmlServlet:: 0 - param constructor");
	}
	public void init(ServletConfig config) {
		System.out.println("HtmlServlet:: Servletconfig ");
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("HtmlServlet.doGet()");
	PrintWriter pw=null;
	//get the stream
	pw=res.getWriter();
	//set the MIME TYPE FOR Response content
	res.setContentType("text/html");
	//If you want then you can use ServletOutputStream to get the stream
	//ServletOutputStream out=res.getOutputStream();
	//write a business logic
	pw.println("<table border='1' style='color: #903;font-family:calibri'><tr><th>Cricketer Name</th><th>Cricketor age</th><th>Cricketor Playing Role</th><th>Cricketor Runs</th>");
	pw.println("<tr><td>Virat Kohli</td><td>30 Years 342 DAys</td><td>Batsman(Captain)</td><td>6749</td></tr>");
	pw.println("<tr><td>Rohit Sharma</td><td>32 Years 148 Days</td><td>Top Batsman</td><td>1587</td></tr>");
	pw.println("<tr><td>MS Dhoni</td><td>38 Years 80 Days</td><td>Batsman(Ex-Captain)</td><td>4876</td></tr>");
	pw.println("<tr><td>Kedar Jadhav</td><td>34 Years 183 Days</td><td>Batsman</td><td>1289</td></tr>");
	//close the printwriter stream 
	pw.close();
	}
}
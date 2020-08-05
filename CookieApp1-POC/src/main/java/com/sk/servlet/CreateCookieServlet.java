package com.sk.servlet;
/*To execute the code you have to add in browser add above slash 'ccsurl' and then to watch cookie added add 'scsurl' 
 * http://localhost:2525/CookieApp1-POC/ccsurl
 * http://localhost:2525/CookieApp1-POC/scsurl
 * 
 * */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ccsurl")
public class CreateCookieServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter pw=null;
	Cookie ck1=null,ck2=null,ck3=null,ck4=null;
	//get PrintWriter
	pw=res.getWriter();
	//set response content type
	res.setContentType("text/html");
	//create cookies(In Memory Cookie)
	ck1=new Cookie("ap","amaravathi");
	ck2=new Cookie("NY","Newyork");
	//Persistent Cookie
	ck3=new Cookie("Bihar","patna");
	ck4=new Cookie("MH","mumbai");
	ck3.setMaxAge(180);
	ck4.setMaxAge(120);
	//add cookies the Response
	res.addCookie(ck1);
	res.addCookie(ck2);
	res.addCookie(ck3);
	res.addCookie(ck4);
	//display response
	pw.println("Successful in creating cookies");
	
	//close stream
	pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
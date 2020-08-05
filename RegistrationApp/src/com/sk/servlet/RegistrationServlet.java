package com.sk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
		int age=0;
		String Name=null, gender=null,ms=null,dob=null,qualification=null;
		String J_Date=null,J_Week=null,date=null;
		String courses[]=null;
		long m_no=0;
		String phone=null,address=null,hb[]=null,favcolor=null;
		int	percentages=0;
				
		PrintWriter pw=null;
		//get the printWriter
		pw=res.getWriter();
		//set the response  type in mime form
		res.setContentType("text/html");
		
		
		//take the requested values from user
		Name=req.getParameter("pname");
		age=Integer.parseInt(req.getParameter("page"));
		gender=req.getParameter("gender");
		ms=req.getParameter("ms");
		date=req.getParameter("dates");
		dob=req.getParameter("dob");
		qualification=req.getParameter("qlfy");
		
		
		J_Date=req.getParameter("Join");
		J_Week=req.getParameter("week");
		courses= req.getParameterValues("crs");
		phone=req.getParameter("phone");
		
		hb= req.getParameterValues("hb");
		favcolor=req.getParameter("fav");		
		//m_no=Integer.parseInt(phone);
		
		address=req.getParameter("address");
		percentages=Integer.parseInt(req.getParameter("textbox"));
		
		if(gender.equalsIgnoreCase("m")) {
			if(age<=5) {
				pw.println("<h1 style='color:skyblue'>"+Name+" you are a baby boy");
			}
			else if(age<=12) {
				pw.println("<h1 style='color:skyblue'>"+Name+ " you are a small boy");
			}
			else if(age<=19) {
				pw.println("<h1 style='color:skyblue'>"+Name+ " you are a teenage boy");
			}
			else if(age<=35) {
				pw.println("<h1 style='color:skyblue'>"+Name+ " you are a young man");
				if(ms==null) {
					ms="unmarried";
					pw.println("<h1 style='color:skyblue'>"+Name+" you are a unmarrird");
				}
				else if(ms.equalsIgnoreCase(ms)) {
					pw.println("<h1 style='color:skyblue'>"+Name+" you are a marrird");
				}
			}
			
			else if(age<=50) {
				pw.println("<h1 style='color:skyblue'>"+Name+ " you are a ur are middle age man</h1>");
				}
			
			else {
				pw.println("<h1 style='color:skyblue'>"+Name+" you are older person</h1>");			
			}
		}
		
		else if(gender.equalsIgnoreCase("f")) {
			if(age<=5) {
				pw.println("<h1 style='color:skyblue'>"+Name+" you are a baby Girl");
			}
			else if(age<=12) {
				pw.println("<h1 style='color:skyblue'>"+Name+ " you are a small Girl");
			}
			else if(age<=19) {
				pw.println("<h1 style='color:skyblue'>"+Name+ " you are a teenage Girl");
			}
			else if(age<=35) {
				pw.println("<h1 style='color:skyblue'>"+Name+ " you are a young women");
			}
			
			else if(age<=50) {
				pw.println("<h1 style='color:skyblue'>"+Name+ " you are a ur are middle age women</h1>");
				}
			
			else {
				pw.println("<h1 style='color:skyblue'>"+Name+" you are old Lady</h1>");			
			}
		}		
		
		pw.println("<b>Name"+Name+"</b></br>");
		
		pw.println("<b>Marital status::"+ms+"</b></br>");
		

		pw.println("<b>DOB::"+dob+"</b></br>");
		
		pw.println("<b>qualification::"+qualification+"</b></br>");
		pw.println("<b>Courses::"+Arrays.toString(courses)+"</b></br>");
		
		pw.println("<b>Hobbies::"+Arrays.toString(hb)+"</b></br>");
		pw.println("<b>favcolor ::"+favcolor+"</b></br>");
		
		pw.println("<b>Percentages of User::"+percentages+"</b></br>");
		
		pw.println("<b>Address::"+address+"</b></br>");
		pw.println("<b>Mobile no is:: "+phone+"</b></br>");
		
		pw.println("<b>Today Date::"+date+"</b></br>");
		pw.println("<b>J_Week::"+J_Week+"</b></br>");
		pw.println("<b>J_Date::"+J_Date+"</b></br>");
		pw.close();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}	
}

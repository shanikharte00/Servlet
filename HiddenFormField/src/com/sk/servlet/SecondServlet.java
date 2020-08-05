package com.sk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	private static final String SINGLE_INSERT_QUERY="INSERT INTO PERSON_INFO(PID,PNAME,FNAME,MS,WHENTOMARRY,WHYTOMARRY) VALUES (PID_SEQ.NEXTVAL,?,?,?,?,?)";
	private static final String MARRIED_INSERT_QUERY="INSERT INTO PERSON_INFO(PID,PNAME,FNAME,MS,SPOUSE,KIDSCOUNT) VALUES (PID_SEQ.NEXTVAL,?,?,?,?,?)";
	@Resource(name="Dsjndi")
	private DataSource ds;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,fname=null,ms=null;
		String spouse=null;
		String wtm1=null,wtm2=null;
		Connection con = null;
		PreparedStatement ps = null;
		int count = 0;
		int kidscount = 0;
		//get printwriter
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read form1/req1 data from hidden boxes of form2 (session tracking)
		name=req.getParameter("hname");
		ms=req.getParameter("hms");
		fname=req.getParameter("hfname");
		
		//read form data
		if(ms.equalsIgnoreCase("single")) {
			wtm1=req.getParameter("wtm1");//when to maarry	
			wtm2=req.getParameter("wtm2");//why to marry
		}
		else if(ms.equalsIgnoreCase("married")){
			spouse=req.getParameter("spouse");
			kidscount=Integer.parseInt(req.getParameter("kidscount"));
		}
		try {
		//write jdbc code
		//GET Pooled jdbc con object
		con=ds.getConnection();
		//create preparedStatement object
		if(ms.equalsIgnoreCase("single"))
			ps=con.prepareStatement(SINGLE_INSERT_QUERY);
		else
			ps=con.prepareStatement(MARRIED_INSERT_QUERY);
			
		//SET VALUES TO QUERY PARAMS
		ps.setString(1,name);
		ps.setString(2,fname);
		ps.setString(3,ms);
		if(ms.equalsIgnoreCase("single")) {
		 ps.setString(4, wtm1);
	     ps.setString(5, wtm2);
		  }
		  else {
			  ps.setString(4, spouse);
			  ps.setInt(5, kidscount);
		  }
		  //execute the query
		  count=ps.executeUpdate();
		if(count!=0)
		pw.println("<h2 Style='color:red;text-align:center'>Registration successful<h2>");
		
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			pw.println("<h2 Style='color:red;text-align:center'>Registration failed<h2>");
		}
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<h2 Style='color:red;text-align:center'>Internal Problem<h2>");
		}
		finally {
			//close jdbc objects
			try {
				if(ps!=null)
				ps.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
				con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		//Generate  dynamic web page displaying form1/req1 and form2/req2
		pw.println("<br><br> form1/req1 data::: "+name+","+fname+"..."+ms);
		
		if(ms.equalsIgnoreCase("single")) 
			pw.println("<br> form2/req2 data :::"+wtm1+"..."+wtm2);
		else
			pw.println("<br> form2/req2 data:::"+spouse+"..."+kidscount);
		//add hyperlink
		pw.println("<br><a href='personal-info.html'>home</a>");
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
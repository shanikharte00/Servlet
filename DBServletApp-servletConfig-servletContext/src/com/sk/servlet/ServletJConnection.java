package com.sk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ServletJConnection extends HttpServlet{
	private static final String QUERY_PARAM="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?"; 
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		PrintWriter pw=null;
		int no=0;
		
		try{
//			ServletConfig cg=getServletConfig();
			ServletContext ctx=getServletContext();
			//get the printWriter
			pw=res.getWriter();
			//set the MIME Content Type
			res.setContentType("text/html");
			//read form data from form page
			no=Integer.parseInt(req.getParameter("empno"));
//			String s1=cg.getInitParameter("driver");
//			String s2=cg.getInitParameter("dburl");
//			String s3=cg.getInitParameter("dbname");
//			String s4=cg.getInitParameter("password");
//			load the class
			String s1=ctx.getInitParameter("driver");
			String s2=ctx.getInitParameter("dburl");
			String s3=ctx.getInitParameter("dbname");	
			String s4=ctx.getInitParameter("password");
			
			/*Class.forName("oracle.jdbc.driver.OracleDriver");
			 
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");*/
			Class.forName(s1);
			con=DriverManager.getConnection(s2,s3,s4);
			//create the statement
			ps=con.prepareStatement(QUERY_PARAM);
			if(con!=null)
			ps.setInt(1,no);
			//Create ResultSet object to get the output
			if(ps!=null)
				rs=ps.executeQuery();
			if(rs.next()){
				pw.println("<H1 style='color:light-Grey'> Result_is_As_Follow</h1>");
				pw.println("<H2 style='color:cyan'> Emp_no is ::"+rs.getInt(1)+"</h2>"); 
				pw.println("<H2 style='color:Grey'> Emp_Name is ::"+rs.getString(2)+"</h2>");
				pw.println("<h2 style='color:pink'> Emp_JOb is ::"+rs.getString(3)+"</h2>");
				pw.println("<h2 style='color:Green'> Emp_Sal is ::"+rs.getFloat(4)+"</h2>");
				pw.println("<h2 style='color:Blue'> Emp_deptno is ::"+rs.getInt(5)+"</h2>");
			}
			else{
				pw.println("Result is not Found !!");
			}
			pw.println("<br>Server Info"+ctx.getServerInfo());
			pw.println("<br>Server api version"+ctx.getMajorVersion()+" "+ctx.getMinorVersion());
			pw.println("<br>Path of Web application"+ctx.getRealPath("/"));
			pw.println("<br>Path of Web application"+ctx.getRealPath("/input.html"));
			pw.println("<br>Context Path"+ctx.getContextPath());
			pw.println("<br>MIME type of input.html"+ctx.getMimeType("/input.html"));
		}//try
		catch(SQLException se){
			se.printStackTrace();
			pw.println("Internal problem");
		}
//		catch(ClassNotFoundException cnf){
//			cnf.printStackTrace();
//			pw.println("Internal problem");
//		}
		catch(Exception e){
			e.printStackTrace();
			pw.println("Internal problem");
		}
		finally{
		//close Jdbc object
			try{
				if(rs!=null)
				rs.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(ps!=null)
				ps.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(con!=null)
				con.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}//finally
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		doPost(req,res);
	}//doGet
}
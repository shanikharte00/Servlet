package com.sk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
public class ServletJConnection extends HttpServlet{
	private static final String QUERY_PARAM="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?"; 
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		PrintWriter pw=null;
		int no=0;
		
		try{
			pw=res.getWriter();
			//set the MIME Content Type
			res.setContentType("text/html");
			//take empno from user as input
			no=Integer.parseInt(req.getParameter("empno"));
			//get connection
			con=getConnection();
			ps=con.prepareStatement(QUERY_PARAM);
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
		}//try
		catch(SQLException se){
			se.printStackTrace();
			pw.println("Internal problem");
		}

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
		private Connection getConnection() throws Exception
		{
			DataSource ds=null;
			//Create the connection
			Connection con=null;
			//Locate the Jndi Registry
			InitialContext ic=null;
			//crete a InitialContext
			ic=new InitialContext();
			//get lookup method for jndi Registry purpose
			//for tomcat purpose 
			ds=(DataSource)ic.lookup("java:/comp/env/Dsjndi");
			con=ds.getConnection();
			return con;
		}
}	

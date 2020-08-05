package com.sk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
@WebServlet("/testurl")
public class ConpoolJndi extends HttpServlet{
	@Resource(name="Dsjndi")
	DataSource ds;
	public final String Query="SELECT ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		
		PrintWriter pw=null;
		Connection  con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int no=0;
		try {
		//create PrintWriter
		pw=res.getWriter();
		//set MIME content type
		res.setContentType("text/html");
		//create connection using Datasource
		con=ds.getConnection();
		//Create Statement 
		if(con!=null)
		ps=con.prepareStatement(Query);
		no=Integer.parseInt(req.getParameter("empno"));
		//pass the Value
		ps.setInt(1,no);
		//Store Result
		if(ps!=null)
		rs=ps.executeQuery();
		
		if(rs.next()) {
			pw.println("<h1 color='Yellow'> ENAME::"+rs.getString(1)+"</h1>");
			pw.println("<h1 color='Yellow'>JOB::"+rs.getString(2)+"</h1>");
			pw.println("<h1 color='Yellow'>SAL:: "+rs.getInt(3)+"</h1>");
			pw.println("<h1 color='Yellow'>,DEPTNO::"+rs.getInt(4)+"</h1>");
		} 
		else {
			pw.println("Connection is Failed");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			doGet(req, res);
	}
	
}

	
	


package com.sk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/testurl")
public class ServletJConnection extends HttpServlet {
	@Resource(name = "Dsjndi")
	DataSource ds;

	private static final String QUERY_PARAM = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		PrintWriter pw = null;
		try {
			pw = res.getWriter();
			// set the MIME Content Type
			res.setContentType("text/html");
			// take emp_no from user as input
			
			con = ds.getConnection();
			int no=Integer.parseInt(req.getParameter("empno"));
			ps = con.prepareStatement(QUERY_PARAM);
			ps.setInt(1,no);
			
			// Create ResultSet object to get the output
			if (ps != null)
				rs = ps.executeQuery();
			if (rs.next()) {
				pw.println("<H1 style='color:light-Grey'> Result_is_As_Follow</h1>");
				pw.println("<H2 style='color:cyan'> Emp_no is ::" + rs.getInt(1) + "</h2>");
				pw.println("<H2 style='color:Grey'> Emp_Name is ::" + rs.getString(2) + "</h2>");
				pw.println("<h2 style='color:pink'> Emp_JOb is ::" + rs.getString(3) + "</h2>");
				pw.println("<h2 style='color:Green'> Emp_Sal is ::" + rs.getFloat(4) + "</h2>");
				pw.println("<h2 style='color:Blue'> Emp_deptno is ::" + rs.getInt(5) + "</h2>");
			} else {
				pw.println("Result is not Found !!");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//doPost 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}// doGet
}

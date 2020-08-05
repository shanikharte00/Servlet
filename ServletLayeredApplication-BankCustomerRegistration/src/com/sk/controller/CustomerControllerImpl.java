package com.sk.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sk.dto.CustomerDTO;
import com.sk.service.CustomerService;
import com.sk.service.CustomerServiceImpl;
import com.sk.vo.CustomerVO;

@WebServlet("/customerurl")
public class CustomerControllerImpl extends HttpServlet {
	private CustomerService service;
	
    public void init() {
        service=new CustomerServiceImpl();
    }
    
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name;
		String iBal,acctype;
		PrintWriter pw=null;
		//get PrintWriter
		pw=res.getWriter();
		//set MIME ContentType
		res.setContentType("text/html");
		CustomerVO vo=null;
		CustomerDTO dto=null;
		String resultMsg=null; 
		//get parameter
		name=req.getParameter("name");
		iBal=req.getParameter("initialBalance");
		acctype=req.getParameter("accounttype");
		
		//take the values from client
		vo=new CustomerVO();
		vo.setName(name);
		vo.setInitAmt(iBal);
		vo.setAccType(acctype);
		
		//convert the vo class object to dto Class object
		dto=new CustomerDTO();
		dto.setName(vo.getName());
		dto.setAccType(vo.getAccType());
		dto.setInitAmt(Float.parseFloat(vo.getInitAmt()));
		
		//use service Class
		try {
			resultMsg=service.register(dto);
			pw.println("<h1 style='color:red;'"+resultMsg+"</h1>");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		pw.println("<a href='file.html'>home</a>");
		//close stream
		pw.close();
	}//doGet(-,-)
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	@Override
	public void destroy() {
		service=null;
	}
}

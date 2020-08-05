package com.sk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;

@WebServlet("/uploadurl")
public class UploadFileServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		MultipartFormDataRequest mreq; 
		UploadBean bean=null;
		Hashtable<String, UploadFile> map=null;
		Enumeration<UploadFile> e=null;
		//get the PrintWriter
		pw=res.getWriter();
		//setContentType
		res.setContentType("text/html");
		try {
		//create Wrapper Request Object
		mreq=new MultipartFormDataRequest(req);
		//specify file upload settings
		bean=new UploadBean();
		//bean.setFilesizelimit(1*1024);
		bean.setFolderstore("F:/store");
		bean.setOverwrite(false);
		
		//complete file uploading 
		bean.store(mreq);
		pw.println("<h1>File Uploading is completed</h1>");
		pw.println("<h1>The uploaded file are </h1>");
		
		map=mreq.getFiles();
		e=map.elements();
		while(e.hasMoreElements()) {
			UploadFile file=e.nextElement();
			pw.println("<br>"+file.getFileName()+"..."+file.getFileSize()+"...."+file.getContentType());
			}
		}//try
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			pw.close();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}

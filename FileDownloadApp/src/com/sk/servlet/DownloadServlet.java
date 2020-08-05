package com.sk.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/downloadurl")
public class DownloadServlet extends HttpServlet {
       
 	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
 		ServletContext sc=null;
 		String path=null;
 		String fileName=null;
 		File file=null;
 		String mimeType=null;
 		FileInputStream is=null;
 		OutputStream os=null;
 		byte[] buffer=null;
 		int bytesRead=0; 
 		//get Access to servlet context object  
 		sc=getServletContext();
 		//get path of uploaded file
 		//path=sc.getInitParameter("downloadpath");
 		//path=sc.getRealPath("/download.html");
 		path=sc.getRealPath("/nature.jpg");
 		
 		//get filename to download request param value from hyperlink
 		//fileName=req.getParameter("/nature.jpg");
 		
 		//locate the file to be downloaded
 		file=new File(path);
 		System.out.println(path);
 		//get the length of the file and make it the length of response
 		res.setContentLengthLong(file.length());
 		//get the MIME type of file and make it response content Type
 		mimeType=sc.getMimeType(file.getPath());
 		res.setContentType(mimeType);
 		//create inputStream pointing to the file
 		is=new FileInputStream(file);
 		System.out.println(path);
 		//given instruction to browser to make response as downloadable file
 		res.setHeader("content-Disposition", "attachment;fileName="+file.getName());
 		//create outputStream pointing to response obj
 		os=res.getOutputStream();
 		//write Stream based logic to Write the file content to response obj
 		buffer=new byte[4096];
 		while((bytesRead=is.read(buffer))!=-1) {
 			os.write(buffer,0,bytesRead);
 		}
 		//close stream
 		is.close();
 		os.close();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}

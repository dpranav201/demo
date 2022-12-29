package com.sarje.serv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part = request.getPart("image");
		
		ServletContext sc = request.getServletContext();
		
		String filePath = sc.getRealPath("images");
		
		Path path = Paths.get(filePath);
		if(!Files.exists(path)) {
			Files.createDirectory(path);
		} 
		
		String fileName = part.getSubmittedFileName();
		path = path.resolve(fileName);
		System.out.println(path); 
		Files.copy(part.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		
		
		
		response.sendRedirect("user_home.jsp"); 
		
	}

}

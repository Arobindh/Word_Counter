package com.user.log.controler;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.user.log.service.Word_Process_Service;

@Controller
public class User_Controller {
	@Autowired
	private Word_Process_Service Service_object;

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@PostMapping("/upload")
	public void upload_process_file(@RequestParam("file") MultipartFile TextFile, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String Filenameextn = FilenameUtils
				.getExtension(TextFile.getOriginalFilename().toString().toLowerCase().trim());
		System.out.println(Filenameextn);
		if (Filenameextn.equals("txt")) {
			Service_object.setUploadedFile(TextFile);
			request.setAttribute("Resultmap", Service_object.UniqueWordsCounter());
			request.setAttribute("FileName", TextFile.getOriginalFilename().toString());
			request.setAttribute("Filecontent", Word_Process_Service.FileContent);
			RequestDispatcher rd = request.getRequestDispatcher("Final.jsp");
			rd.forward(request, response);

		} else {
			RequestDispatcher rb = request.getRequestDispatcher("Error.jsp");
			rb.forward(request, response);
		}
	}

}

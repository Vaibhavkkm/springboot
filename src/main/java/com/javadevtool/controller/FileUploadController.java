package com.javadevtool.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javadevtool.service.BookService;
import com.javadevtool.service.FileUploadHelper;

@RestController
public class FileUploadController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	FileUploadHelper fileUploadHelper;
	
	private org.slf4j.Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	//To post a single file
	@PostMapping("/uploadFile")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		
		if(!file.getContentType().equals("application/pdf")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		return ResponseEntity.ok("Working");
	}
	
	//To post a multiple files
		@PostMapping("/uploadFiles")
		public ResponseEntity<String> uploadFiles(@RequestParam("files") MultipartFile[] files){
			
			this.logger.info("{} number of files uploaded.", files.length);
			
			
			if (files != null && files.length > 0) {
	            try {
	            	bookService.saveFileNames(files);
	            	
	            boolean f=	fileUploadHelper.uploadFiles(files);
	            
	            if(f) {
	                return ResponseEntity.ok("Files uploaded successfully.");

	            }
	          
	            } catch (Exception e) {
	                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload files.");
	            }
	        }
	            return ResponseEntity.badRequest().body("No files were uploaded.");

		}
}

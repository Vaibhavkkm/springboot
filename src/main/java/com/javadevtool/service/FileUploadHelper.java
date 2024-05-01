package com.javadevtool.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadHelper {

		
		public final String UPLOAD_DIR= "C:\\Users\\HP\\Documents\\APIs UPLOADED FILES";


		 public boolean uploadFiles(MultipartFile[] multiparts) {
		        boolean allFilesUploaded = true;

		        for (MultipartFile multipart : multiparts) {
		            try {
		                Files.copy(multipart.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + multipart.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		            } catch (Exception e) {
		                // Handle the exception as per your requirement.
		                allFilesUploaded = false;
		            }
		        }

		        return allFilesUploaded;
		    }
}

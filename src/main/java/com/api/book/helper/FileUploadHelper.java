package com.api.book.helper;

import java.io.File;
import java.io.IOException;
//import java.io.FileOutputStream;
//import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
   //public final String UPLOAD_DIR="G:\\boot programs\\bootrestbook\\src\\main\\resources\\static\\images";
   public final String UPLOAD_DIR= new ClassPathResource("static/images/").getFile().getAbsolutePath();
   
   public FileUploadHelper()throws IOException{
	   
   }
   
   public boolean uploadFile(MultipartFile multipartfile) {
	   
	   boolean f = false;
	   
	   try {
		   
//		   // file read
//		   InputStream is = multipart.getInputStream();
//		   byte data[] = new byte[is.available()];
//		   is.read(data);
//		   
//		   // file write
//		   FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+multipart.getOriginalFilename());
//		   fos.write(data);
//		   
//		   fos.flush();
//		   fos.close();
//		   f=true;
		   
		   Files.copy(multipartfile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartfile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		   f=true;
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   
	   
	   
	   return f;
   }
}

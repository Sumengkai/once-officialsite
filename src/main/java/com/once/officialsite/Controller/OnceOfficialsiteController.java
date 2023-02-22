package com.once.officialsite.Controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.once.officialsite.Service.Ifs.OnceOfficialsiteService;
import com.once.officialsite.Vo.OnceOfficialsiteReq;
import com.once.officialsite.Vo.OnceOfficialsiteRes;

@CrossOrigin
@RestController
public class OnceOfficialsiteController {
	@Autowired
	private OnceOfficialsiteService onceOfficialsiteService;
	// ----------------------------------------------

//	@PostMapping(value = "studentCreatOrUpdate", produces = MediaType.TEXT_PLAIN_VALUE)
//	public OnceOfficialsiteRes studentCreatOrUpdate(@RequestBody OnceOfficialsiteReq req,
//			@RequestParam("file") MultipartFile file) throws IOException {
//		BufferedOutputStream out = new BufferedOutputStream(
//				new FileOutputStream(new File("C:\\Users\\lenovo\\Desktop\\日本專案test", file.getOriginalFilename())));
//		out.write(file.getBytes());
//		out.flush();
//		out.close();
//		return onceOfficialsiteService.studentCreatOrUpdate(req);
//	}
//	====
//	@PostMapping(value = "studentCreatOrUpdate")
//	public OnceOfficialsiteRes studentCreatOrUpdate(@RequestBody OnceOfficialsiteReq req) throws IOException {
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		String inputFilePath = reader.readLine();
//		FileInputStream fis = new FileInputStream(inputFilePath);
//		String outputFilePath = reader.readLine();
//		FileOutputStream fos = new FileOutputStream(outputFilePath);
//		byte[] buffer = new byte[1024];
//		int bytesRead;
//		while ((bytesRead = fis.read(buffer)) != -1) {
//			fos.write(buffer, 0, bytesRead);
//		}
//		fis.close();
//		fos.close();
//		return onceOfficialsiteService.studentCreatOrUpdate(req);
//	}
//	====
//	@PostMapping(value = "studentCreatOrUpdate")
//	public OnceOfficialsiteRes studentCreatOrUpdate(@RequestParam("file") MultipartFile file,
//			@RequestBody OnceOfficialsiteReq req) throws IOException {
//		String outputFilePath = "/path/to/output/file";
//		FileOutputStream fos = new FileOutputStream(outputFilePath);
//		byte[] buffer = new byte[1024];
//		int bytesRead;
//		InputStream is = file.getInputStream();
//		while ((bytesRead = is.read(buffer)) != -1) {
//			fos.write(buffer, 0, bytesRead);
//		}
//		is.close();
//		fos.close();
//		return onceOfficialsiteService.studentCreatOrUpdate(req);
//	}
//	====

//	@PostMapping(value = "test")
//	public OnceOfficialsiteRes test(@RequestParam("file") MultipartFile file) throws IOException {
//		try {
//			String outputFilePath = "C:\\Users\\lenovo\\Desktop\\日本專案20230214-2\\" + file.getName() + ".jpg";
//			FileOutputStream fos = new FileOutputStream(outputFilePath);
//			byte[] buffer = new byte[1024];
//			int bytesRead;
//			InputStream is = file.getInputStream();
//			while ((bytesRead = is.read(buffer)) != -1) {
//				fos.write(buffer, 0, bytesRead);
//			}
//			is.close();
//			fos.close();
//			System.out.println("迴圈結束");
//			return onceOfficialsiteService.test();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//	====

	@PostMapping(value = "test")
	public OnceOfficialsiteRes test(@RequestParam("file") MultipartFile file) throws IOException {
		try {
//			String outputFilePath = "C:\\Users\\lenovo\\Desktop\\日本專案20230214-2\\" + file.getName() + ".jpg";
//			FileOutputStream fos = new FileOutputStream(outputFilePath);
//			byte[] buffer = new byte[1024];
//			int bytesRead;
//			InputStream is = file.getInputStream();
//			while ((bytesRead = is.read(buffer)) != -1) {
//				fos.write(buffer, 0, bytesRead);
//			}
//			is.close();
//			fos.close();
//			System.out.println("迴圈結束");
			return onceOfficialsiteService.test(file);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// ----------------------------------------------
	@PostMapping(value = "getStudentInfo")
	public OnceOfficialsiteRes getStudentInfo(@RequestBody OnceOfficialsiteReq req) {
		return onceOfficialsiteService.getStudentInfo(req);
	}
}

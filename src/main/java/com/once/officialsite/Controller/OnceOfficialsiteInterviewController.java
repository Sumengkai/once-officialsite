package com.once.officialsite.Controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.once.officialsite.Service.Ifs.OnceOfficialsiteInterviewInterFace;
import com.once.officialsite.Vo.OnceOfficialsiteInterviewReq;
import com.once.officialsite.Vo.OnceOfficialsiteInterviewRes;
import com.once.officialsite.Vo.OnceOfficialsiteReq;
import com.once.officialsite.Vo.OnceOfficialsiteRes;

@CrossOrigin
@RestController
public class OnceOfficialsiteInterviewController {
	@Autowired
	OnceOfficialsiteInterviewInterFace onceOfficialsiteInterviewInterFace;

	// -------------------------------------------------新增檔案
	@PostMapping(value = "creatStudentPhoto")
	public OnceOfficialsiteInterviewRes creatStudentPhoto(@RequestParam("file") MultipartFile file) throws IOException {
		return onceOfficialsiteInterviewInterFace.creatStudentPhoto(file);
	}

	// -------------------------------------------------後台新增資料
	@PostMapping(value = "creatStudentInfoForBackstage")
	public OnceOfficialsiteInterviewRes creatStudentInfoForBackstage(@RequestBody OnceOfficialsiteInterviewReq req) {
		return onceOfficialsiteInterviewInterFace.creatStudentInfoForBackstage(req);
	}

	// -------------------------------------------------後台搜尋資料
	@PostMapping(value = "getStudentInfoForBackstage")
	public OnceOfficialsiteInterviewRes getStudentInfoForBackstage(@RequestBody OnceOfficialsiteInterviewReq req) {
		return onceOfficialsiteInterviewInterFace.getStudentInfoForBackstage(req);
	}

	// -------------------------------------------------後台拿到某學生資料
	@PostMapping(value = "getSomeStudentInfoForBackstage")
	public OnceOfficialsiteInterviewRes getSomeStudentInfoForBackstage(@RequestBody OnceOfficialsiteInterviewReq req) {
		return onceOfficialsiteInterviewInterFace.getSomeStudentInfoForBackstage(req);
	}

	// -------------------------------------------------後台更新某學生資料
	@PostMapping(value = "updateStudentInfoForBackstage")
	public OnceOfficialsiteInterviewRes updateStudentInfoForBackstage(@RequestBody OnceOfficialsiteInterviewReq req) {
		return onceOfficialsiteInterviewInterFace.updateStudentInfoForBackstage(req);
	}

	// -------------------------------------------------後台刪除某學生資料
	@PostMapping(value = "deleteStudentInfoForBackstage")
	public OnceOfficialsiteInterviewRes deleteStudentInfoForBackstage(@RequestBody OnceOfficialsiteInterviewReq req) {
		return onceOfficialsiteInterviewInterFace.deleteStudentInfoForBackstage(req);
	}

	// -------------------------------------------------前台拿到自己的資料
	@PostMapping(value = "getSomeStudentIndoForFrontDesk")
	public OnceOfficialsiteInterviewRes getSomeStudentIndoForFrontDesk(@RequestBody OnceOfficialsiteInterviewReq req) {
		return onceOfficialsiteInterviewInterFace.getSomeStudentIndoForFrontDesk(req);
	}

	// -------------------------------------------------前台更新自己的資料
	@PostMapping(value = "updateStudentInfoForFrontDesk")
	public OnceOfficialsiteInterviewRes updateStudentInfoForFrontDesk(@RequestBody OnceOfficialsiteInterviewReq req) {
		return onceOfficialsiteInterviewInterFace.updateStudentInfoForFrontDesk(req);
	}

}

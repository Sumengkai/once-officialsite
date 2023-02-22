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

	// -------------------------------------------------�s�W�ɮ�
	@PostMapping(value = "creatStudentPhoto")
	public OnceOfficialsiteInterviewRes creatStudentPhoto(@RequestParam("file") MultipartFile file) throws IOException {
		return onceOfficialsiteInterviewInterFace.creatStudentPhoto(file);
	}

	// -------------------------------------------------��x�s�W���
	@PostMapping(value = "creatStudentInfoForBackstage")
	public OnceOfficialsiteInterviewRes creatStudentInfoForBackstage(@RequestBody OnceOfficialsiteInterviewReq req) {
		return onceOfficialsiteInterviewInterFace.creatStudentInfoForBackstage(req);
	}

	// -------------------------------------------------��x�j�M���
	@PostMapping(value = "getStudentInfoForBackstage")
	public OnceOfficialsiteInterviewRes getStudentInfoForBackstage(@RequestBody OnceOfficialsiteInterviewReq req) {
		return onceOfficialsiteInterviewInterFace.getStudentInfoForBackstage(req);
	}

	// -------------------------------------------------��x����Y�ǥ͸��
	@PostMapping(value = "getSomeStudentInfoForBackstage")
	public OnceOfficialsiteInterviewRes getSomeStudentInfoForBackstage(@RequestBody OnceOfficialsiteInterviewReq req) {
		return onceOfficialsiteInterviewInterFace.getSomeStudentInfoForBackstage(req);
	}

	// -------------------------------------------------��x��s�Y�ǥ͸��
	@PostMapping(value = "updateStudentInfoForBackstage")
	public OnceOfficialsiteInterviewRes updateStudentInfoForBackstage(@RequestBody OnceOfficialsiteInterviewReq req) {
		return onceOfficialsiteInterviewInterFace.updateStudentInfoForBackstage(req);
	}

	// -------------------------------------------------��x�R���Y�ǥ͸��
	@PostMapping(value = "deleteStudentInfoForBackstage")
	public OnceOfficialsiteInterviewRes deleteStudentInfoForBackstage(@RequestBody OnceOfficialsiteInterviewReq req) {
		return onceOfficialsiteInterviewInterFace.deleteStudentInfoForBackstage(req);
	}

	// -------------------------------------------------�e�x����ۤv�����
	@PostMapping(value = "getSomeStudentIndoForFrontDesk")
	public OnceOfficialsiteInterviewRes getSomeStudentIndoForFrontDesk(@RequestBody OnceOfficialsiteInterviewReq req) {
		return onceOfficialsiteInterviewInterFace.getSomeStudentIndoForFrontDesk(req);
	}

	// -------------------------------------------------�e�x��s�ۤv�����
	@PostMapping(value = "updateStudentInfoForFrontDesk")
	public OnceOfficialsiteInterviewRes updateStudentInfoForFrontDesk(@RequestBody OnceOfficialsiteInterviewReq req) {
		return onceOfficialsiteInterviewInterFace.updateStudentInfoForFrontDesk(req);
	}

}

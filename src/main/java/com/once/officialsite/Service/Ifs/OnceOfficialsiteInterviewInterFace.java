package com.once.officialsite.Service.Ifs;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.once.officialsite.Vo.OnceOfficialsiteInterviewReq;
import com.once.officialsite.Vo.OnceOfficialsiteInterviewRes;

public interface OnceOfficialsiteInterviewInterFace {
	public OnceOfficialsiteInterviewRes creatStudentPhoto(@RequestParam("file") MultipartFile file);

	public OnceOfficialsiteInterviewRes creatStudentInfoForBackstage(OnceOfficialsiteInterviewReq req);

	public OnceOfficialsiteInterviewRes getStudentInfoForBackstage(OnceOfficialsiteInterviewReq req);

	public OnceOfficialsiteInterviewRes getSomeStudentInfoForBackstage(OnceOfficialsiteInterviewReq req);

	public OnceOfficialsiteInterviewRes updateStudentInfoForBackstage(OnceOfficialsiteInterviewReq req);

	public OnceOfficialsiteInterviewRes deleteStudentInfoForBackstage(OnceOfficialsiteInterviewReq req);

	public OnceOfficialsiteInterviewRes getSomeStudentIndoForFrontDesk(OnceOfficialsiteInterviewReq req);

	public OnceOfficialsiteInterviewRes updateStudentInfoForFrontDesk(OnceOfficialsiteInterviewReq req);

}

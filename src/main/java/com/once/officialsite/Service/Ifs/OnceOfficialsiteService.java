package com.once.officialsite.Service.Ifs;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.once.officialsite.Vo.OnceOfficialsiteReq;
import com.once.officialsite.Vo.OnceOfficialsiteRes;

@Service
public interface OnceOfficialsiteService {
	public OnceOfficialsiteRes studentCreatOrUpdate(OnceOfficialsiteReq req)throws FileNotFoundException;
	public OnceOfficialsiteRes getStudentInfo(OnceOfficialsiteReq req);
	public OnceOfficialsiteRes test(@RequestParam("file") MultipartFile file);
}

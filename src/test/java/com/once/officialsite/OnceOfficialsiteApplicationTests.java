package com.once.officialsite;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.once.officialsite.Respository.K1017AndK1018Dao;
import com.once.officialsite.Service.Ifs.OnceOfficialsiteService;
import com.once.officialsite.Vo.OnceOfficialsiteReq;
import com.once.officialsite.Vo.OnceOfficialsiteRes;

@SpringBootTest
class OnceOfficialsiteApplicationTests {
	@Autowired
	K1017AndK1018Dao k1017AndK1018Dao;
	@Autowired
	OnceOfficialsiteService k1017AndK1018Service;

	@Test
	void contextLoads() {
	}

	@Test
	void c() {
		OnceOfficialsiteReq req = new OnceOfficialsiteReq();
		req.setInterviewSummary("a");
		req.setInterviewVideo("b");
		req.setJapanLifeVideo("c");
		req.setPhoto("Capture00056_¨â¦T¥b¨­.jpg");
		req.setProfile("e");
//		OnceOfficialsiteRes res = k1017AndK1018Service.studentCreatOrUpdate(req);
//		System.out.println(res.getMessage());
	}

}

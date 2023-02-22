package com.once.officialsite.Service.Impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.once.officialsite.Entity.K1017AndK1018;
import com.once.officialsite.Respository.K1017AndK1018Dao;
import com.once.officialsite.Service.Ifs.OnceOfficialsiteService;
import com.once.officialsite.Vo.OnceOfficialsiteReq;
import com.once.officialsite.Vo.OnceOfficialsiteRes;

@Service
public class OnceOfficialsiteImpl implements OnceOfficialsiteService {
	@Autowired
	K1017AndK1018Dao k1017AndK1018Dao;
	// ==============================================
//	try (FileInputStream fis = new FileInputStream("C:\\Users\\lenovo\\Desktop\\�l��\\���۪��l��.jpg");
//			FileOutputStream fos = new FileOutputStream("D:\\firstjava\\���۪��l��Test.jpg")) {
//		System.out.println(fis.available() + " �ɮפj�p");
//		byte[] b = fis.readAllBytes();// Ū�Xfis���ɮ�
//		byte[] bb = new byte[fis.available()];
//		System.out.println(b + " ��mbyte = b");
//		System.out.println(bb + " ��mbyte = bb");
//		// �Qbyte = bŪ����Afis���ɮ״N�w���s�b
//		System.out.println(fis.available() + " �ɮפj�p�A�]���W�誺�ɮ׳Qbyte = bŪ���A�ҥH�o�̷|�Q�k�s ( fis���ɮ״N�w���s�b )");
//		System.out.println("�ɮ�Ū�����\");
//		System.out.println("------------");
//		fos.write(b);
//		System.out.println("�g�J���\ ! ");
//	} catch (Exception e) {
//		// TODO: handle exception
//	}
	// ----------------------------------------------

	@Override
	public OnceOfficialsiteRes studentCreatOrUpdate(OnceOfficialsiteReq req) throws FileNotFoundException {
		OnceOfficialsiteRes res = new OnceOfficialsiteRes();
//		if (!StringUtils.hasText(req.getInterviewSummary())) {
//			res.setMessage("��J�ĳX�ت�");
//			return res;
//		}
//		String fileName = req.getFile().toString();
//		BufferedOutputStream out = new BufferedOutputStream(
//				new FileOutputStream(new File("C:\\Users\\lenovo\\Desktop\\�饻�M��test",req.getFile().getName())));		
//		out.write(null);
//		req.getFile().g

		K1017AndK1018 k1017AndK1018 = new K1017AndK1018(req.getInterviewSummary(), req.getPhoto(), req.getProfile(),
				req.getInterviewVideo(), req.getJapanLifeVideo());
		k1017AndK1018Dao.save(k1017AndK1018);
		res.setMessage("���\");
//		res.setK1017AndK1018(k1017AndK1018);
//		UUID photoUuid = UUID.randomUUID();
//		String photoUuidString = photoUuid.toString() + req.getPhoto();
//
////		try (FileOutputStream fos = new FileOutputStream("C:\\Users\\lenovo\\Desktop\\�饻�M��20230214 -2\\" + photoUuidString)) {
////		} catch (Exception e) {
////			
////		}
//		try (FileInputStream fis = new FileInputStream("C:\\Users\\lenovo\\Desktop\\�l��\\���۪��l��.jpg");
//				FileOutputStream fos = new FileOutputStream(
//						"C:\\Users\\lenovo\\Desktop\\�饻�M��20230214 -2\\" + req.getPhoto())) {
//			byte[] b = fis.readAllBytes();
//			fos.write(b);
//		} catch (Exception e) {
//
//		}
		return res;
	}

	// ----------------------------------------------
	@Override
	public OnceOfficialsiteRes getStudentInfo(OnceOfficialsiteReq req) {
		Optional<K1017AndK1018> k1017AndK1018Optional = k1017AndK1018Dao.findById(req.getStudentUuid());
		if (!k1017AndK1018Optional.isPresent()) {
			return new OnceOfficialsiteRes("Ū������");
		}
		K1017AndK1018 k1017AndK1018Info = k1017AndK1018Optional.get();
		return new OnceOfficialsiteRes(k1017AndK1018Info);
	}

	// ----------------------------------------------
	@Override
	public OnceOfficialsiteRes test(@RequestParam("file") MultipartFile file) {
		OnceOfficialsiteRes res = new OnceOfficialsiteRes();
		try {
			String outputFilePath = "C:\\Users\\lenovo\\Desktop\\�饻�M��20230214-2\\" + file.getName() + ".jpg";
			FileOutputStream fos = new FileOutputStream(outputFilePath);
			byte[] buffer = new byte[1024];
			int bytesRead;
			InputStream is = file.getInputStream();
			while ((bytesRead = is.read(buffer)) != -1) {
				fos.write(buffer, 0, bytesRead);
			}
			is.close();
			fos.close();
			System.out.println("�j�鵲��");
			res.setMessage("���\");
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	
	}

}

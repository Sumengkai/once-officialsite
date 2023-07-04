package com.once.officialsite.Service.Impl;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.once.officialsite.Entity.OnceOfficialsiteInterviewModel;
import com.once.officialsite.Respository.OnceOfficialsiteInterviewDao;
import com.once.officialsite.Service.Ifs.OnceOfficialsiteInterviewInterFace;
import com.once.officialsite.Vo.OnceOfficialsiteInterviewReq;
import com.once.officialsite.Vo.OnceOfficialsiteInterviewRes;
import com.once.officialsite.Vo.OnceOfficialsiteRes;

@Service
public class OnceOfficialsiteInterviewImpl implements OnceOfficialsiteInterviewInterFace {
	@Autowired
	OnceOfficialsiteInterviewDao onceOfficialsiteInterviewDao;

	// ----------------------------------------------
	private String checkIsNull(String check) {
		if (!StringUtils.hasText(check)) {
			return "�L";
		}
		return check;
	}

	// ----------------------------------------------
	private List<OnceOfficialsiteInterviewModel> filterListByDeleteFlg(List<OnceOfficialsiteInterviewModel> list) {
		List<OnceOfficialsiteInterviewModel> newOnceOfficialsiteInterviewModelList = new ArrayList<>();
		for (var item : list) {
			if (item.isDelFlg() == false) {
				newOnceOfficialsiteInterviewModelList.add(item);
			}
		}
		return newOnceOfficialsiteInterviewModelList;
	}

	// ----------------------------------------------
	private List<OnceOfficialsiteInterviewModel> filterListByGender(List<OnceOfficialsiteInterviewModel> list,
			String gender) {
		List<OnceOfficialsiteInterviewModel> newOnceOfficialsiteInterviewModelList = new ArrayList<>();
		for (var item : list) {
			if (item.getClassroom().equals(gender)) {
				newOnceOfficialsiteInterviewModelList.add(item);
			}
		}
		return newOnceOfficialsiteInterviewModelList;
	}

	// ----------------------------------------------
	private List<OnceOfficialsiteInterviewModel> filterListByClassroom(List<OnceOfficialsiteInterviewModel> list,
			String classroom) {
		List<OnceOfficialsiteInterviewModel> newOnceOfficialsiteInterviewModelList = new ArrayList<>();
		for (var item : list) {
			if (item.getClassroom().equals(classroom)) {
				newOnceOfficialsiteInterviewModelList.add(item);
			}
		}
		return newOnceOfficialsiteInterviewModelList;
	}

	// ----------------------------------------------
	private List<OnceOfficialsiteInterviewModel> filterListByAge(List<OnceOfficialsiteInterviewModel> list, int age) {
		LocalDate todayDate = LocalDate.now();
		List<OnceOfficialsiteInterviewModel> newOnceOfficialsiteInterviewModelList = new ArrayList<>();

		// for�j��
//		for (var item : list) {
//			if ((todayDate.getYear() - item.getBirthdate().getYear()) == age) {
//				if (item.getBirthdate().getMonthValue() <= todayDate.getMonthValue()
//						&& item.getBirthdate().getDayOfMonth() <= todayDate.getDayOfMonth()) {
//					newOnceOfficialsiteInterviewModelList.add(item);
//				}
//			}
//			// �P�_�O���O�j��age���� �O���� ������i�s��list
//			if ((todayDate.getYear() - item.getBirthdate().getYear()) > age) {
//				newOnceOfficialsiteInterviewModelList.add(item);
//			}
//		}
		// lambda
		list.stream()
				.filter(item -> (todayDate.getYear() - item.getBirthdate().getYear()) == age
						&& item.getBirthdate().getMonthValue() <= todayDate.getMonthValue()
						&& item.getBirthdate().getDayOfMonth() <= todayDate.getDayOfMonth()
						|| (todayDate.getYear() - item.getBirthdate().getYear()) > age)
				.forEach(newOnceOfficialsiteInterviewModelList::add);
		return newOnceOfficialsiteInterviewModelList;

	}

	// ----------------------------------------------
	@Override
	public OnceOfficialsiteInterviewRes creatStudentInfoForBackstage(OnceOfficialsiteInterviewReq req) {

		OnceOfficialsiteInterviewModel onceOfficialsiteInterviewModel = new OnceOfficialsiteInterviewModel();

		if (!StringUtils.hasText(req.getInterviewSummary())) {
			return new OnceOfficialsiteInterviewRes("��J���եD��");
		}
		if (!StringUtils.hasText(req.getProfile())) {
			return new OnceOfficialsiteInterviewRes("��J����");
		}
		onceOfficialsiteInterviewModel.setInterviewSummary(req.getInterviewSummary());
		onceOfficialsiteInterviewModel.setProfile(req.getProfile());
		if (req.getBirthdate() == null) {
			String birthDateString = "1000-01-01";
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate birthDate = LocalDate.parse(birthDateString, format);
			onceOfficialsiteInterviewModel.setBirthdate(birthDate);
		} else {
			onceOfficialsiteInterviewModel.setBirthdate(req.getBirthdate());
		}

		if (!StringUtils.hasText(req.getPhoto())) {
			onceOfficialsiteInterviewModel.setPhoto("�L");
		} else {
			UUID photoUuid = UUID.randomUUID();
			String photoUuidString = photoUuid + "-" + ".jpg";
			onceOfficialsiteInterviewModel.setPhoto(photoUuidString);
		}

		onceOfficialsiteInterviewModel.setInterviewVideo(checkIsNull(req.getInterviewVideo()));
//		if (!StringUtils.hasText(req.getInterviewVideo())) {
//			onceOfficialsiteInterviewModel.setInterviewVideo(checkIsNull(req.getInterviewVideo()));
//		} else {
//			onceOfficialsiteInterviewModel.setInterviewVideo(req.getInterviewVideo());
//		}
		onceOfficialsiteInterviewModel.setJapanLifeVideo(checkIsNull(req.getJapanLifeVideo()));
//		if (!StringUtils.hasText(req.getJapanLifeVideo())) {
//			onceOfficialsiteInterviewModel.setJapanLifeVideo(checkIsNull(req.getJapanLifeVideo()));
//		} else {
//			onceOfficialsiteInterviewModel.setJapanLifeVideo(req.getJapanLifeVideo());
//		}
		onceOfficialsiteInterviewModel.setLastNameEn(checkIsNull(req.getLastNameEn()));
//		if (!StringUtils.hasText(req.getLastNameEn())) {
//			onceOfficialsiteInterviewModel.setLastNameEn("�L");
//		} else {
//			onceOfficialsiteInterviewModel.setLastNameEn(req.getLastNameEn());
//		}
		onceOfficialsiteInterviewModel.setFirstNameEn(checkIsNull(req.getFirstNameEn()));
//		if (!StringUtils.hasText(req.getFirstNameEn())) {
//			onceOfficialsiteInterviewModel.setFirstNameEn("�L");
//		} else {
//			onceOfficialsiteInterviewModel.setFirstNameEn(req.getFirstNameEn());
//		}
		onceOfficialsiteInterviewModel.setLastNameCn(checkIsNull(req.getLastNameCn()));
//		if (!StringUtils.hasText(req.getLastNameCn())) {
//			onceOfficialsiteInterviewModel.setLastNameCn("�L");
//		} else {
//			onceOfficialsiteInterviewModel.setLastNameCn(req.getLastNameCn());
//		}
		onceOfficialsiteInterviewModel.setFirstNameCn(checkIsNull(req.getFirstNameCn()));
//		if (!StringUtils.hasText(req.getFirstNameCn())) {
//			onceOfficialsiteInterviewModel.setFirstNameCn("�L");
//		} else {
//			onceOfficialsiteInterviewModel.setFirstNameCn(req.getFirstNameCn());
//		}
		onceOfficialsiteInterviewModel.setClassroom(checkIsNull(req.getClassroom()));
//		if (!StringUtils.hasText(req.getClassroom())) {
//			onceOfficialsiteInterviewModel.setClassroom("�L");
//		} else {
//			onceOfficialsiteInterviewModel.setClassroom(req.getClassroom());
//		}
		onceOfficialsiteInterviewModel.setGender(checkIsNull(req.getGender()));
//		if (!StringUtils.hasText(req.getGender())) {
//			onceOfficialsiteInterviewModel.setGender("�L");
//		} else {
//			onceOfficialsiteInterviewModel.setGender(req.getGender());
//		}
		onceOfficialsiteInterviewDao.save(onceOfficialsiteInterviewModel);
		return new OnceOfficialsiteInterviewRes("���\", onceOfficialsiteInterviewModel);
	}

	// ----------------------------------------------

	@Override
	public OnceOfficialsiteInterviewRes creatStudentPhoto(@RequestParam("file") MultipartFile file) {
		String fileName = file.getOriginalFilename().substring(0, file.getOriginalFilename().length() - 4);
		try {
			String outputFilePath = "C:\\Users\\lenovo\\Desktop\\�饻�M��test 20230225\\�Ҧ��Ӥ���\\" + fileName + ".jpg";
			FileOutputStream fos = new FileOutputStream(outputFilePath);
			byte[] buffer = new byte[1024];
			int bytesRead;
//			byte[] buffer = file.getBytes();
			InputStream is = file.getInputStream();
			while ((bytesRead = is.read(buffer)) != -1) {
				fos.write(buffer, 0, bytesRead);
			}
		
			is.close();
			fos.close();
			System.out.println("���\");
			return new OnceOfficialsiteInterviewRes("���\");
		} catch (Exception e) {
			e.printStackTrace();
			return new OnceOfficialsiteInterviewRes("���~");
		}

	}

	// ----------------------------------------------
	@Override
	public OnceOfficialsiteInterviewRes getStudentInfoForBackstage(OnceOfficialsiteInterviewReq req) {
		boolean checkStudentName = !StringUtils.hasText(req.getStudentName());// �W�l�Ŭ�true
		boolean checkClassroom = !StringUtils.hasText(req.getClassroom());// �Z�ŪŬ�true
		boolean checkGender = !StringUtils.hasText(req.getGender());// �ʧO�Ŭ�true
		boolean checkAge = req.getAge() == null;// �~���Ŭ�true
		List<OnceOfficialsiteInterviewModel> onceOfficialsiteInterviewModelList = new ArrayList<>();
		List<OnceOfficialsiteInterviewModel> newOnceOfficialsiteInterviewModelList = new ArrayList<>();
		List<OnceOfficialsiteInterviewModel> newOnceOfficialsiteInterviewModelList2 = new ArrayList<>();
		List<OnceOfficialsiteInterviewModel> newOnceOfficialsiteInterviewModelList3 = new ArrayList<>();
		List<OnceOfficialsiteInterviewModel> newOnceOfficialsiteInterviewModelList4 = new ArrayList<>();
		// 1.�W�l�B�Z�šB�ʧO�B�~�� �Ҫ�
		if (checkStudentName && checkClassroom && checkGender && checkAge) {
			onceOfficialsiteInterviewModelList = onceOfficialsiteInterviewDao.findByDelFlgFalseOrderByBirthdateAsc();
			return new OnceOfficialsiteInterviewRes(onceOfficialsiteInterviewModelList);
		}

		// 2.�W�l�B�Z�šB�ʧO�B�~�� �Ҧ�
		if (!checkStudentName && !checkClassroom && !checkGender && !checkAge) {
			onceOfficialsiteInterviewModelList = onceOfficialsiteInterviewDao
					.findByLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingAndDelFlgFalseOrderByBirthdateAsc(
							req.getStudentName(), req.getStudentName(), req.getStudentName(), req.getStudentName());
			int age = req.getAge();
			// �L�o�~��
			newOnceOfficialsiteInterviewModelList = filterListByAge(onceOfficialsiteInterviewModelList, age);
			// �L�o�Z��
			newOnceOfficialsiteInterviewModelList2 = filterListByClassroom(newOnceOfficialsiteInterviewModelList,
					req.getClassroom());
			// �L�o�ʧO
			newOnceOfficialsiteInterviewModelList3 = filterListByGender(newOnceOfficialsiteInterviewModelList2,
					req.getGender());
			// �L�o�R��
			newOnceOfficialsiteInterviewModelList4 = filterListByDeleteFlg(newOnceOfficialsiteInterviewModelList3);
			return new OnceOfficialsiteInterviewRes(newOnceOfficialsiteInterviewModelList4);
		}

		// 3.�S���W�l�B���Z�šB���ʧO�B���~��
		if (checkStudentName && !checkClassroom && !checkGender && !checkAge) {
			int age = req.getAge();
			onceOfficialsiteInterviewModelList = onceOfficialsiteInterviewDao
					.findByGenderAndClassroomAndDelFlgFalseOrderByBirthdateAsc(req.getGender(), req.getClassroom());
			newOnceOfficialsiteInterviewModelList = filterListByAge(onceOfficialsiteInterviewModelList, age);
			return new OnceOfficialsiteInterviewRes(newOnceOfficialsiteInterviewModelList);
		}

		// 4.���W�l�B�S���Z�šB���ʧO�B���~��
		if (!checkStudentName && checkClassroom && !checkGender && !checkAge) {
			int age = req.getAge();
			onceOfficialsiteInterviewModelList = onceOfficialsiteInterviewDao
					.findByLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingOrderByBirthdateAsc(
							req.getStudentName(), req.getStudentName(), req.getStudentName(), req.getStudentName());
			newOnceOfficialsiteInterviewModelList = filterListByAge(onceOfficialsiteInterviewModelList, age);
			newOnceOfficialsiteInterviewModelList = filterListByGender(newOnceOfficialsiteInterviewModelList,
					req.getGender());
			return new OnceOfficialsiteInterviewRes(newOnceOfficialsiteInterviewModelList);
		}

		// 5.���W�l�B���Z�šB���ʧO�B�S���~��
		if (!checkStudentName && !checkClassroom && !checkGender && checkAge) {
			onceOfficialsiteInterviewModelList = onceOfficialsiteInterviewDao
					.findByLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingOrderByBirthdateAsc(
							req.getStudentName(), req.getStudentName(), req.getStudentName(), req.getStudentName());
			newOnceOfficialsiteInterviewModelList = filterListByGender(newOnceOfficialsiteInterviewModelList,
					req.getGender());
			newOnceOfficialsiteInterviewModelList = filterListByClassroom(newOnceOfficialsiteInterviewModelList,
					req.getClassroom());
			return new OnceOfficialsiteInterviewRes(onceOfficialsiteInterviewModelList);
		}

		// 6.���W�l�B���Z�šB�S���ʧO�B���~��
		if (!checkStudentName && !checkClassroom && checkGender && !checkAge) {
			int age = req.getAge();
			onceOfficialsiteInterviewModelList = onceOfficialsiteInterviewDao
					.findByLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingOrderByBirthdateAsc(
							req.getStudentName(), req.getStudentName(), req.getStudentName(), req.getStudentName());
			newOnceOfficialsiteInterviewModelList = filterListByAge(onceOfficialsiteInterviewModelList, age);
			newOnceOfficialsiteInterviewModelList = filterListByClassroom(newOnceOfficialsiteInterviewModelList,
					req.getClassroom());
			return new OnceOfficialsiteInterviewRes(newOnceOfficialsiteInterviewModelList);
		}

		// 7.�S���W�l�B�S���Z�šB���ʧO�B���~��
		if (checkStudentName && checkClassroom && !checkGender && !checkAge) {
			int age = req.getAge();
			onceOfficialsiteInterviewModelList = onceOfficialsiteInterviewDao
					.findByGenderAndDelFlgFalseOrderByBirthdateAsc(req.getGender());
			newOnceOfficialsiteInterviewModelList = filterListByAge(onceOfficialsiteInterviewModelList, age);
			return new OnceOfficialsiteInterviewRes(newOnceOfficialsiteInterviewModelList);
		}

		// 8.�S���W�l�B���Z�šB���ʧO�B�S���~��
		if (checkStudentName && !checkClassroom && !checkGender && checkAge) {
			onceOfficialsiteInterviewModelList = onceOfficialsiteInterviewDao
					.findByGenderAndClassroomAndDelFlgFalseOrderByBirthdateAsc(req.getGender(), req.getClassroom());
			return new OnceOfficialsiteInterviewRes(onceOfficialsiteInterviewModelList);
		}

		// 9.���W�l�B�S���Z�šB���ʧO�B�S���~��
		if (!checkStudentName && checkClassroom && !checkGender && checkAge) {
			onceOfficialsiteInterviewModelList = onceOfficialsiteInterviewDao
					.findByLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingOrderByBirthdateAsc(
							req.getStudentName(), req.getStudentName(), req.getStudentName(), req.getStudentName());
			newOnceOfficialsiteInterviewModelList = filterListByGender(newOnceOfficialsiteInterviewModelList,
					req.getGender());
			return new OnceOfficialsiteInterviewRes(newOnceOfficialsiteInterviewModelList);
		}

		// 10.�S���W�l�B���Z�šB�S���ʧO�B���~��
		if (checkStudentName && !checkClassroom && !checkGender && checkAge) {
			int age = req.getAge();
			onceOfficialsiteInterviewModelList = onceOfficialsiteInterviewDao
					.findByClassroomAndDelFlgFalseOrderByBirthdateAsc(req.getClassroom());
			newOnceOfficialsiteInterviewModelList = filterListByAge(onceOfficialsiteInterviewModelList, age);
			return new OnceOfficialsiteInterviewRes(newOnceOfficialsiteInterviewModelList);
		}

		// 11.���W�l�B�S���Z�šB�S���ʧO�B���~��
		if (!checkStudentName && checkClassroom && checkGender && !checkAge) {
			int age = req.getAge();
			onceOfficialsiteInterviewModelList = onceOfficialsiteInterviewDao
					.findByLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingOrderByBirthdateAsc(
							req.getStudentName(), req.getStudentName(), req.getStudentName(), req.getStudentName());
			newOnceOfficialsiteInterviewModelList = filterListByAge(onceOfficialsiteInterviewModelList, age);
			newOnceOfficialsiteInterviewModelList = filterListByDeleteFlg(newOnceOfficialsiteInterviewModelList);
			return new OnceOfficialsiteInterviewRes(newOnceOfficialsiteInterviewModelList);
		}

		// 12.���W�l�B���Z�šB�S���ʧO�B�S���~��
		if (!checkStudentName && !checkClassroom && checkGender && checkAge) {
			onceOfficialsiteInterviewModelList = onceOfficialsiteInterviewDao
					.findByLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingOrderByBirthdateAsc(
							req.getStudentName(), req.getStudentName(), req.getStudentName(), req.getStudentName());
			newOnceOfficialsiteInterviewModelList = filterListByDeleteFlg(onceOfficialsiteInterviewModelList);
			newOnceOfficialsiteInterviewModelList = filterListByClassroom(newOnceOfficialsiteInterviewModelList,
					req.getClassroom());
			return new OnceOfficialsiteInterviewRes(newOnceOfficialsiteInterviewModelList);
		}

		// 13.�S���W�l�B�S���Z�šB���ʧO�B�S���~��
		if (checkStudentName && checkClassroom && !checkGender && checkAge) {
			onceOfficialsiteInterviewModelList = onceOfficialsiteInterviewDao
					.findByGenderAndDelFlgFalseOrderByBirthdateAsc(req.getGender());
			return new OnceOfficialsiteInterviewRes(onceOfficialsiteInterviewModelList);
		}

		// 14.�S���W�l�B�S���Z�šB�S���ʧO�B���~��
		if (checkStudentName && checkClassroom && checkGender && !checkAge) {
			int age = req.getAge();
			onceOfficialsiteInterviewModelList = onceOfficialsiteInterviewDao.findByDelFlgFalseOrderByBirthdateAsc();
			newOnceOfficialsiteInterviewModelList = filterListByAge(onceOfficialsiteInterviewModelList, age);
			return new OnceOfficialsiteInterviewRes(newOnceOfficialsiteInterviewModelList);
		}

		// 15.�S���W�l�B���Z�šB�S���ʧO�B�S���~��
		if (checkStudentName && !checkClassroom && checkGender && checkAge) {
			onceOfficialsiteInterviewModelList = onceOfficialsiteInterviewDao
					.findByClassroomAndDelFlgFalseOrderByBirthdateAsc(req.getClassroom());
			return new OnceOfficialsiteInterviewRes(onceOfficialsiteInterviewModelList);
		}

		// 16.���W�l�B�S���Z�šB�S���ʧO�B�S���~��
		if (!checkStudentName && checkClassroom && checkGender && checkAge) {
			onceOfficialsiteInterviewModelList = onceOfficialsiteInterviewDao
					.findByLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingOrderByBirthdateAsc(
							req.getStudentName(), req.getStudentName(), req.getStudentName(), req.getStudentName());
			onceOfficialsiteInterviewModelList = filterListByDeleteFlg(onceOfficialsiteInterviewModelList);
			return new OnceOfficialsiteInterviewRes(onceOfficialsiteInterviewModelList);
		}
		return new OnceOfficialsiteInterviewRes("��o��N���F");
	}

	// ----------------------------------------------
	@Override
	public OnceOfficialsiteInterviewRes getSomeStudentInfoForBackstage(OnceOfficialsiteInterviewReq req) {
		return new OnceOfficialsiteInterviewRes(onceOfficialsiteInterviewDao.findById(req.getStudentId()).get());
	}

	// ----------------------------------------------
	@Override
	public OnceOfficialsiteInterviewRes updateStudentInfoForBackstage(OnceOfficialsiteInterviewReq req) {
		OnceOfficialsiteInterviewModel onceOfficialsiteInterviewModel = onceOfficialsiteInterviewDao
				.findById(req.getStudentId()).get();

		if (!StringUtils.hasText(req.getInterviewSummary())) {
			return new OnceOfficialsiteInterviewRes("��J���եD��");
		}
		if (!StringUtils.hasText(req.getProfile())) {
			return new OnceOfficialsiteInterviewRes("��J����");
		}
		onceOfficialsiteInterviewModel.setInterviewSummary(req.getInterviewSummary());
		onceOfficialsiteInterviewModel.setProfile(req.getProfile());
		if (req.getBirthdate() == null) {
			String birthDateString = "1000-01-01";
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate birthDate = LocalDate.parse(birthDateString, format);
			onceOfficialsiteInterviewModel.setBirthdate(birthDate);
		} else {
			onceOfficialsiteInterviewModel.setBirthdate(req.getBirthdate());
		}
		if (!StringUtils.hasText(req.getPhoto())) {
			onceOfficialsiteInterviewModel.setPhoto("�L");
		} else {
			UUID photoUuid = UUID.randomUUID();
			String photoUuidString = photoUuid + "-" + ".jpg";
			onceOfficialsiteInterviewModel.setPhoto(photoUuidString);
		}
		onceOfficialsiteInterviewModel.setInterviewVideo(checkIsNull(req.getInterviewVideo()));
		onceOfficialsiteInterviewModel.setJapanLifeVideo(checkIsNull(req.getJapanLifeVideo()));
		onceOfficialsiteInterviewModel.setJapanLifeVideo(checkIsNull(req.getLastNameEn()));
		onceOfficialsiteInterviewModel.setJapanLifeVideo(checkIsNull(req.getFirstNameEn()));
		onceOfficialsiteInterviewModel.setJapanLifeVideo(checkIsNull(req.getLastNameCn()));
		onceOfficialsiteInterviewModel.setJapanLifeVideo(checkIsNull(req.getFirstNameCn()));
		onceOfficialsiteInterviewModel.setJapanLifeVideo(checkIsNull(req.getClassroom()));
		onceOfficialsiteInterviewModel.setJapanLifeVideo(checkIsNull(req.getGender()));
		onceOfficialsiteInterviewDao.save(onceOfficialsiteInterviewModel);
		return new OnceOfficialsiteInterviewRes("���\", onceOfficialsiteInterviewModel);
	}

	// ----------------------------------------------
	@Override
	public OnceOfficialsiteInterviewRes deleteStudentInfoForBackstage(OnceOfficialsiteInterviewReq req) {
		OnceOfficialsiteInterviewModel onceOfficialsiteInterviewModel = onceOfficialsiteInterviewDao
				.findById(req.getStudentId()).get();
		onceOfficialsiteInterviewModel.setDelFlg(true);
		onceOfficialsiteInterviewDao.save(onceOfficialsiteInterviewModel);
		return new OnceOfficialsiteInterviewRes("�R�����\");
	}

	// ----------------------------------------------
	@Override
	public OnceOfficialsiteInterviewRes getSomeStudentIndoForFrontDesk(OnceOfficialsiteInterviewReq req) {
		return new OnceOfficialsiteInterviewRes(onceOfficialsiteInterviewDao.findByPwd(req.getPassword()).get());
	}
	// ----------------------------------------------

	@Override
	public OnceOfficialsiteInterviewRes updateStudentInfoForFrontDesk(OnceOfficialsiteInterviewReq req) {
		OnceOfficialsiteInterviewModel onceOfficialsiteInterviewModel = onceOfficialsiteInterviewDao
				.findByPwd(req.getPassword()).get();

		if (!StringUtils.hasText(req.getInterviewSummary())) {
			return new OnceOfficialsiteInterviewRes("��J���եD��");
		}
		if (!StringUtils.hasText(req.getProfile())) {
			return new OnceOfficialsiteInterviewRes("��J����");
		}
		onceOfficialsiteInterviewModel.setInterviewSummary(req.getInterviewSummary());
		onceOfficialsiteInterviewModel.setProfile(req.getProfile());
		if (req.getBirthdate() == null) {
			String birthDateString = "1000-01-01";
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate birthDate = LocalDate.parse(birthDateString, format);
			onceOfficialsiteInterviewModel.setBirthdate(birthDate);
		} else {
			onceOfficialsiteInterviewModel.setBirthdate(req.getBirthdate());
		}
		if (!StringUtils.hasText(req.getPhoto())) {
			onceOfficialsiteInterviewModel.setPhoto("�L");
		} else {
			UUID photoUuid = UUID.randomUUID();
			String photoUuidString = photoUuid + "-" + ".jpg";
			onceOfficialsiteInterviewModel.setPhoto(photoUuidString);
		}
		onceOfficialsiteInterviewModel.setInterviewVideo(checkIsNull(req.getInterviewVideo()));
		onceOfficialsiteInterviewModel.setJapanLifeVideo(checkIsNull(req.getJapanLifeVideo()));
		onceOfficialsiteInterviewModel.setJapanLifeVideo(checkIsNull(req.getLastNameEn()));
		onceOfficialsiteInterviewModel.setJapanLifeVideo(checkIsNull(req.getFirstNameEn()));
		onceOfficialsiteInterviewModel.setJapanLifeVideo(checkIsNull(req.getLastNameCn()));
		onceOfficialsiteInterviewModel.setJapanLifeVideo(checkIsNull(req.getFirstNameCn()));
		onceOfficialsiteInterviewModel.setJapanLifeVideo(checkIsNull(req.getClassroom()));
		onceOfficialsiteInterviewModel.setJapanLifeVideo(checkIsNull(req.getGender()));
		onceOfficialsiteInterviewDao.save(onceOfficialsiteInterviewModel);
		return new OnceOfficialsiteInterviewRes("���\", onceOfficialsiteInterviewModel);

	}

}

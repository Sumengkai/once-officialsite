package com.once.officialsite.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.once.officialsite.Entity.K1017AndK1018;
import com.once.officialsite.Entity.OnceOfficialsiteInterviewModel;

@Repository
public interface OnceOfficialsiteInterviewDao extends JpaRepository<OnceOfficialsiteInterviewModel, Integer> {

	// ps.���Ӧ~���j��p
	// 1.�S���ʧO�B�S���~���B�S���W�l�B�S���Z��
	// 14.�S���ʧO�B���~���B�S���W�l�B�S���Z��
	public List<OnceOfficialsiteInterviewModel> findByDelFlgFalseOrderByBirthdateAsc();

	// 2.���ʧO�B���~���B���W�l�B���Z��
	// 5.���W�l�B���Z�šB���ʧO�B�S���~��
	// ���Ѫ���
	public List<OnceOfficialsiteInterviewModel> findByLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingAndGenderAndClassroomAndDelFlgFalseOrderByBirthdateAsc(
			String lastNameEn, String firstNameEn, String lastNameCn, String firstNameCn, String gender,
			String classroom);

	// 2.���ʧO�B���~���B���W�l�B���Z��
	// 5.���W�l�B���Z�šB���ʧO�B�S���~��
	public List<OnceOfficialsiteInterviewModel> findByDelFlgFalseAndGenderAndClassroomAndLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingOrderByBirthdateAsc(
			String gender, String classroom, String lastNameEn, String firstNameEn, String lastNameCn,
			String firstNameCn);

	// 3.�S���W�l�B���Z�šB���ʧO�B���~��
	// 8.�S���W�l�B���Z�šB���ʧO�B�S���~��
	public List<OnceOfficialsiteInterviewModel> findByGenderAndClassroomAndDelFlgFalseOrderByBirthdateAsc(String gender,
			String classroom);

	// 4.���W�l�B�S���Z�šB���ʧO�B���~��
	// 9.���W�l�B�S���Z�šB���ʧO�B�S���~��
	// ���Ѫ���
	public List<OnceOfficialsiteInterviewModel> findByLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingAndGenderAndDelFlgFalseOrderByBirthdateAsc(
			String lastNameEn, String firstNameEn, String lastNameCn, String firstNameCn, String gender);

	// 4.���W�l�B�S���Z�šB���ʧO�B���~��
	// 9.���W�l�B�S���Z�šB���ʧO�B�S���~��
	public List<OnceOfficialsiteInterviewModel> findByDelFlgFalseAndGenderAndLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingOrderByBirthdateAsc(
			String gender, String lastNameEn, String firstNameEn, String lastNameCn, String firstNameCn);

	// 6.���W�l�B���Z�šB�S���ʧO�B���~��
	// 12.���W�l�B���Z�šB�S���ʧO�B�S���~��
	// ���Ѫ���
	public List<OnceOfficialsiteInterviewModel> findByLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingAndClassroomAndDelFlgFalseOrderByBirthdateAsc(
			String lastNameEn, String firstNameEn, String lastNameCn, String firstNameCn, String classroom);

	// 6.���W�l�B���Z�šB�S���ʧO�B���~��
	// 12.���W�l�B���Z�šB�S���ʧO�B�S���~��
	public List<OnceOfficialsiteInterviewModel> findByDelFlgFalseAndClassroomAndLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingOrderByBirthdateAsc(
			String classroom, String lastNameEn, String firstNameEn, String lastNameCn, String firstNameCn);

	// 7.�S���W�l�B�S���Z�šB���ʧO�B���~��
	public List<OnceOfficialsiteInterviewModel> findByGenderAndDelFlgFalseOrderByBirthdateAsc(String gender);

	// 10.�S���W�l�B���Z�šB�S���ʧO�B���~��
	// 15.�S���W�l�B���Z�šB�S���ʧO�B�S���~��
	public List<OnceOfficialsiteInterviewModel> findByClassroomAndDelFlgFalseOrderByBirthdateAsc(String classroom);

	// 11.���W�l�B�S���Z�šB�S���ʧO�B���~��
	// 16.���W�l�B�S���Z�šB�S���ʧO�B�S���~��
	public List<OnceOfficialsiteInterviewModel> findByLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingAndDelFlgFalseOrderByBirthdateAsc(
			String lastNameEn, String firstNameEn, String lastNameCn, String firstNameCn);

	// ����J�W�l�����|�Ψ�
	public List<OnceOfficialsiteInterviewModel> findByLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingOrderByBirthdateAsc(
			String lastNameEn, String firstNameEn, String lastNameCn, String firstNameCn);

	// �e�x�Τ�n�J�ɡA�z�L�K�X���ӵ����
	public Optional<OnceOfficialsiteInterviewModel> findByPwd(String pwd);

}

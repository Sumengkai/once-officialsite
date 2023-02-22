package com.once.officialsite.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.once.officialsite.Entity.K1017AndK1018;
import com.once.officialsite.Entity.OnceOfficialsiteInterviewModel;

@Repository
public interface OnceOfficialsiteInterviewDao extends JpaRepository<OnceOfficialsiteInterviewModel, Integer> {

	// ps.按照年紀大到小
	// 1.沒有性別、沒有年紀、沒有名子、沒有班級
	// 14.沒有性別、有年紀、沒有名子、沒有班級
	public List<OnceOfficialsiteInterviewModel> findByDelFlgFalseOrderByBirthdateAsc();

	// 2.有性別、有年紀、有名子、有班級
	// 5.有名子、有班級、有性別、沒有年紀
	// 失敗版本
	public List<OnceOfficialsiteInterviewModel> findByLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingAndGenderAndClassroomAndDelFlgFalseOrderByBirthdateAsc(
			String lastNameEn, String firstNameEn, String lastNameCn, String firstNameCn, String gender,
			String classroom);

	// 2.有性別、有年紀、有名子、有班級
	// 5.有名子、有班級、有性別、沒有年紀
	public List<OnceOfficialsiteInterviewModel> findByDelFlgFalseAndGenderAndClassroomAndLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingOrderByBirthdateAsc(
			String gender, String classroom, String lastNameEn, String firstNameEn, String lastNameCn,
			String firstNameCn);

	// 3.沒有名子、有班級、有性別、有年紀
	// 8.沒有名子、有班級、有性別、沒有年紀
	public List<OnceOfficialsiteInterviewModel> findByGenderAndClassroomAndDelFlgFalseOrderByBirthdateAsc(String gender,
			String classroom);

	// 4.有名子、沒有班級、有性別、有年紀
	// 9.有名子、沒有班級、有性別、沒有年紀
	// 失敗版本
	public List<OnceOfficialsiteInterviewModel> findByLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingAndGenderAndDelFlgFalseOrderByBirthdateAsc(
			String lastNameEn, String firstNameEn, String lastNameCn, String firstNameCn, String gender);

	// 4.有名子、沒有班級、有性別、有年紀
	// 9.有名子、沒有班級、有性別、沒有年紀
	public List<OnceOfficialsiteInterviewModel> findByDelFlgFalseAndGenderAndLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingOrderByBirthdateAsc(
			String gender, String lastNameEn, String firstNameEn, String lastNameCn, String firstNameCn);

	// 6.有名子、有班級、沒有性別、有年紀
	// 12.有名子、有班級、沒有性別、沒有年紀
	// 失敗版本
	public List<OnceOfficialsiteInterviewModel> findByLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingAndClassroomAndDelFlgFalseOrderByBirthdateAsc(
			String lastNameEn, String firstNameEn, String lastNameCn, String firstNameCn, String classroom);

	// 6.有名子、有班級、沒有性別、有年紀
	// 12.有名子、有班級、沒有性別、沒有年紀
	public List<OnceOfficialsiteInterviewModel> findByDelFlgFalseAndClassroomAndLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingOrderByBirthdateAsc(
			String classroom, String lastNameEn, String firstNameEn, String lastNameCn, String firstNameCn);

	// 7.沒有名子、沒有班級、有性別、有年紀
	public List<OnceOfficialsiteInterviewModel> findByGenderAndDelFlgFalseOrderByBirthdateAsc(String gender);

	// 10.沒有名子、有班級、沒有性別、有年紀
	// 15.沒有名子、有班級、沒有性別、沒有年紀
	public List<OnceOfficialsiteInterviewModel> findByClassroomAndDelFlgFalseOrderByBirthdateAsc(String classroom);

	// 11.有名子、沒有班級、沒有性別、有年紀
	// 16.有名子、沒有班級、沒有性別、沒有年紀
	public List<OnceOfficialsiteInterviewModel> findByLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingAndDelFlgFalseOrderByBirthdateAsc(
			String lastNameEn, String firstNameEn, String lastNameCn, String firstNameCn);

	// 有輸入名子的都會用到
	public List<OnceOfficialsiteInterviewModel> findByLastNameEnContainingOrFirstNameEnContainingOrLastNameCnContainingOrFirstNameCnContainingOrderByBirthdateAsc(
			String lastNameEn, String firstNameEn, String lastNameCn, String firstNameCn);

	// 前台用戶登入時，透過密碼找到該筆資料
	public Optional<OnceOfficialsiteInterviewModel> findByPwd(String pwd);

}

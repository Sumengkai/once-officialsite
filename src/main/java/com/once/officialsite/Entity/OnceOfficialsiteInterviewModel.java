package com.once.officialsite.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "once_officialsite_interview")
public class OnceOfficialsiteInterviewModel {
	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;

	@Column(name = "pwd")
	private String pwd;

	@Column(name = "interview_summary")
	private String interviewSummary;

	@Column(name = "photo")
	private String photo;

	@Column(name = "profile")
	private String profile;

	@Column(name = "interview_video")
	private String interviewVideo;

	@Column(name = "japan_life_video")
	private String japanLifeVideo;

	@Column(name = "lastname_en")
	private String lastNameEn;

	@Column(name = "firstname_en")
	private String firstNameEn;

	@Column(name = "lastname_cn")
	private String lastNameCn;

	@Column(name = "firstname_cn")
	private String firstNameCn;

	@Column(name = "gender")
	private String gender;

	@Column(name = "birthdate")
	private LocalDate birthdate;

	@Column(name = "classroom")
	private String classroom;

	@Column(name = "del_flg")
	private boolean delFlg;

//	------------------------
	public OnceOfficialsiteInterviewModel() {
	}
	
	public OnceOfficialsiteInterviewModel(int studentId, String pwd, String interviewSummary, String photo, String profile,
		String interviewVideo, String japanLifeVideo, String lastNameEn, String firstNameEn, String lastNameCn,
		String firstNameCn, String gender, LocalDate birthdate, String classroom, boolean delFlg) {
	this.studentId = studentId;
	this.pwd = pwd;
	this.interviewSummary = interviewSummary;
	this.photo = photo;
	this.profile = profile;
	this.interviewVideo = interviewVideo;
	this.japanLifeVideo = japanLifeVideo;
	this.lastNameEn = lastNameEn;
	this.firstNameEn = firstNameEn;
	this.lastNameCn = lastNameCn;
	this.firstNameCn = firstNameCn;
	this.gender = gender;
	this.birthdate = birthdate;
	this.classroom = classroom;
	this.delFlg = delFlg;
}




	public int getStudentId() {
		return studentId;
	}




	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}




	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getInterviewSummary() {
		return interviewSummary;
	}

	public void setInterviewSummary(String interviewSummary) {
		this.interviewSummary = interviewSummary;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getInterviewVideo() {
		return interviewVideo;
	}

	public void setInterviewVideo(String interviewVideo) {
		this.interviewVideo = interviewVideo;
	}

	public String getJapanLifeVideo() {
		return japanLifeVideo;
	}

	public void setJapanLifeVideo(String japanLifeVideo) {
		this.japanLifeVideo = japanLifeVideo;
	}

	public String getLastNameEn() {
		return lastNameEn;
	}

	public void setLastNameEn(String lastNameEn) {
		this.lastNameEn = lastNameEn;
	}

	public String getFirstNameEn() {
		return firstNameEn;
	}

	public void setFirstNameEn(String firstNameEn) {
		this.firstNameEn = firstNameEn;
	}

	public String getLastNameCn() {
		return lastNameCn;
	}

	public void setLastNameCn(String lastNameCn) {
		this.lastNameCn = lastNameCn;
	}

	public String getFirstNameCn() {
		return firstNameCn;
	}

	public void setFirstNameCn(String firstNameCn) {
		this.firstNameCn = firstNameCn;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public boolean isDelFlg() {
		return delFlg;
	}

	public void setDelFlg(boolean delFlg) {
		this.delFlg = delFlg;
	}

}

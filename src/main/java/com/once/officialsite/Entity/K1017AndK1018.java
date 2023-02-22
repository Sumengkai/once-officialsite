package com.once.officialsite.Entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Type;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;

@Entity
@Table(name = "k1017_k1018")
public class K1017AndK1018 {
	@Id
	@Column(name = "student_uuid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentUuid;

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

	public K1017AndK1018() {
	}

	public K1017AndK1018(String interviewSummary, String photo, String profile, String interviewVideo,
			String japanLifeVideo) {
		this.interviewSummary = interviewSummary;
		this.photo = photo;
		this.profile = profile;
		this.interviewVideo = interviewVideo;
		this.japanLifeVideo = japanLifeVideo;

	}

	public int getStudentUuid() {
		return studentUuid;
	}

	public void setStudentUuid(int studentUuid) {
		this.studentUuid = studentUuid;
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

}

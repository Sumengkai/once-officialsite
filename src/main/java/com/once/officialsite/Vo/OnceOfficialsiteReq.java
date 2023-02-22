package com.once.officialsite.Vo;

import java.io.File;

public class OnceOfficialsiteReq {
	private String interviewSummary;
	private String photo;
	private String profile;
	private String interviewVideo;
	private String japanLifeVideo;
	private Integer studentUuid;
	private File file;
	
	

	public OnceOfficialsiteReq() {
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

	public Integer getStudentUuid() {
		return studentUuid;
	}

	public void setStudentUuid(Integer studentUuid) {
		this.studentUuid = studentUuid;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	

}

package com.once.officialsite.Vo;

import java.util.List;

import com.once.officialsite.Entity.OnceOfficialsiteInterviewModel;

public class OnceOfficialsiteInterviewRes {
	private String message;
	private OnceOfficialsiteInterviewModel onceOfficialsiteInterviewModel;
	private List<OnceOfficialsiteInterviewModel> onceOfficialsiteInterviewModelList;

	public OnceOfficialsiteInterviewRes() {
	}

	public OnceOfficialsiteInterviewRes(List<OnceOfficialsiteInterviewModel> onceOfficialsiteInterviewModelList) {
		this.onceOfficialsiteInterviewModelList = onceOfficialsiteInterviewModelList;
	}

	public OnceOfficialsiteInterviewRes(String message) {
		this.message = message;
	}

	public OnceOfficialsiteInterviewRes(OnceOfficialsiteInterviewModel onceOfficialsiteInterviewModel) {
		this.onceOfficialsiteInterviewModel = onceOfficialsiteInterviewModel;
	}

	public OnceOfficialsiteInterviewRes(String message, OnceOfficialsiteInterviewModel onceOfficialsiteInterviewModel) {
		this.message = message;
		this.onceOfficialsiteInterviewModel = onceOfficialsiteInterviewModel;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public OnceOfficialsiteInterviewModel getOnceOfficialsiteInterviewModel() {
		return onceOfficialsiteInterviewModel;
	}

	public void setOnceOfficialsiteInterviewModel(OnceOfficialsiteInterviewModel onceOfficialsiteInterviewModel) {
		this.onceOfficialsiteInterviewModel = onceOfficialsiteInterviewModel;
	}

	public List<OnceOfficialsiteInterviewModel> getOnceOfficialsiteInterviewModelList() {
		return onceOfficialsiteInterviewModelList;
	}

	public void setOnceOfficialsiteInterviewModelList(
			List<OnceOfficialsiteInterviewModel> onceOfficialsiteInterviewModelList) {
		this.onceOfficialsiteInterviewModelList = onceOfficialsiteInterviewModelList;
	}

}

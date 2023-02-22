package com.once.officialsite.Vo;

import com.once.officialsite.Entity.K1017AndK1018;

public class OnceOfficialsiteRes {
	private String message;
	private K1017AndK1018 k1017AndK1018;

	public OnceOfficialsiteRes() {
	}

	public OnceOfficialsiteRes(String message, K1017AndK1018 k1017AndK1018) {
		this.message = message;
		this.k1017AndK1018 = k1017AndK1018;
	}

	public OnceOfficialsiteRes(K1017AndK1018 k1017AndK1018) {
		this.k1017AndK1018 = k1017AndK1018;
	}

	public OnceOfficialsiteRes(String message) {
		this.message = message;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public K1017AndK1018 getK1017AndK1018() {
		return k1017AndK1018;
	}

	public void setK1017AndK1018(K1017AndK1018 k1017AndK1018) {
		this.k1017AndK1018 = k1017AndK1018;
	}

}

package com.github.wxiaoqi.security.things.vo;

import java.io.Serializable;

public class DownloadStatus implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2643672086635088207L;
	
	public static String DOWNLOAD_STATUS_FAIL = "FAIL";	
	public static String DOWNLOAD_STATUS_ING = "ING";
	public static String DOWNLOAD_STATUS_COMP = "COMP";
	
	/**
	 * 下载状态//FAIL/ING/COMP
	 */
	private String status;
	/**
	 * 消息
	 */
	private String msg;
	/**
	 * 下载批次号
	 */
	private Long batchId;

	private Object attachInfo;

	public DownloadStatus(String status, String msg, Long batchId) {
		this.status = status;
		this.msg = msg;
		this.batchId = batchId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	public Object getAttachInfo() {
		return attachInfo;
	}

	public void setAttachInfo(Object attachInfo) {
		this.attachInfo = attachInfo;
	}

}

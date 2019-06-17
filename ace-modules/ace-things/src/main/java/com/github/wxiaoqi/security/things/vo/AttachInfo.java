package com.github.wxiaoqi.security.things.vo;

import java.util.Date;

/**
 * <p>
 * 文件信息Model
 * </p>
 *
 * @author fuchen
 * @since 2017-06-27
 */

public class AttachInfo {
	private Long id;
	private String name;
	private String type;
	private String url;
	private Long ownerId;
	private String thumburl;
	private String suffix;
	private Long size;
	private Long createBy;
	private Date createDate;
	private String createByDesc;

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getThumburl() {
		return thumburl;
	}

	public void setThumburl(String thumburl) {
		this.thumburl = thumburl;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Long getSize() {
		return size;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateByDesc() {
		return createByDesc;
	}

	public void setCreateByDesc(String createByDesc) {
		this.createByDesc = createByDesc;
	}

	@Override
	public String toString() {
		return "{id:" + this.id + ",name:" + this.name + ",type:" + this.type + ",url:" + url + ",ownerId:"
				+ ownerId + ",thumburl:" + thumburl + ",suffix:" + suffix + ",size:" + size + "}";
	}

}

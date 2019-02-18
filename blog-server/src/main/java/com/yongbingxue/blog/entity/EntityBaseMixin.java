package com.yongbingxue.blog.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EntityBaseMixin {
	@JsonIgnore
	private Long id;

	@JsonIgnore
	protected Timestamp createdTime = new Timestamp(System.currentTimeMillis());

	@JsonIgnore
	private boolean deleted = false;

	@JsonIgnore
	protected int version = 1;

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

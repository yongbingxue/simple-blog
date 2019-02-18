package com.yongbingxue.blog.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.yongbingxue.blog.jackson.views.Views;

@MappedSuperclass
public abstract class EntityBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntityBase() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Public.class)
	private Long id;

	@NotNull
	@JsonView(Views.Public.class)
	protected Timestamp createdTime = new Timestamp(System.currentTimeMillis());

	@NotNull
	@JsonIgnore
	private boolean deleted = false;

	@Version
	@JsonIgnore
	@NotNull
	protected int version = 1;

	//
	public void initDefaults() {
		this.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		this.setVersion(1);
	}

	// @formatter:off
	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("id", this.getId())
				.append("createdTime", this.getCreatedTime())
				.append("version", this.getVersion())
				.append("deleted", this.isDeleted())
				.toString();
	}
	// @formatter:on

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		EntityBase that = (EntityBase) obj;
		return new EqualsBuilder().append(this.getId(), that.getId()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(this.getId()).toHashCode();
	}

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

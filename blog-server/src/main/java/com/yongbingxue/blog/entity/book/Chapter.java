package com.yongbingxue.blog.entity.book;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.yongbingxue.blog.entity.EntityBase;
import com.yongbingxue.blog.jackson.views.Views;

@Entity
@Table(name = "Chapter")
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Chapter extends EntityBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Chapter() {
	}

	@JsonView(Views.Public.class)
	@NotNull
	private String name;

	@JsonView(Views.Public.class)
	@NotNull
	private Integer priority;

	//
	@JsonView(Views.Public.class)
	@ManyToOne
	@NotNull
	private Book book;

	// @formatter:off
	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.appendSuper(super.toString())
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
		Chapter that = (Chapter) obj;
		return new EqualsBuilder().append(this.getId(), that.getId()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(this.getId()).toHashCode();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}

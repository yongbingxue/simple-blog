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
@Table(name = "Book")
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book extends EntityBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Book() {
	}

	@JsonView(Views.Public.class)
	@NotNull
	private String author;

	@JsonView(Views.Public.class)
	@NotNull
	private String cover;

	@JsonView(Views.Public.class)
	@NotNull
	private String description;

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
	private Category category;

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
		Book that = (Book) obj;
		return new EqualsBuilder().append(this.getId(), that.getId()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(this.getId()).toHashCode();
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}

/*
 *==================================================================================
 *== COPYRIGHT HYPERTECH COBRA TEAM. ALL RIGHT RESERVED.							==
 *== HYPERTECH PROPRIETARY/CONFIDENTIAL. USE THIS SUBJECT TO LICENSE TERMS.		==
 *==																				==
 *== VISIT HTTP://COBRAFW.IO FOR MORE INFORMATION									==
 *==================================================================================
 *
 *== File Name: Category.java
 *== Created at: Oct 10, 2017 11:57:56 PM
 *== Created by: duongnguyen
 *== Project: lesson07-hibernate
 *== Package: io.cobrafw.javaweb.model
 */
package io.cobrafw.javaweb.model;

import java.util.Set;

/**
 * Category Model
 *
 * @author duongnguyen
 */
public class Category implements java.io.Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = -1245978292251104789L;

	/** Categories.Id */
	private Integer id;

	/** Categories.FatherId */
	private Integer fatherId;

	/** Categories.Name */
	private String name;

	/** Categories.SortNo */
	private Integer sortNo;

	/** Father category */
	private Category category;

	/**  Set of sub categories */
	private Set<Category> categories;

	/**
	 * Default Constructor
	 */
	public Category() {
		super();
	}

	/**
	 * @return the categories
	 */
	public Set<Category> getCategories() {
		return this.categories;
	}

	/**
	 * @return the fatherId
	 */
	public Integer getFatherId() {
		return this.fatherId;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the sortNo
	 */
	public Integer getSortNo() {
		return this.sortNo;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	/**
	 * @param fatherId the fatherId to set
	 */
	public void setFatherId(Integer fatherId) {
		this.fatherId = fatherId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param sortNo the sortNo to set
	 */
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return this.category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
}

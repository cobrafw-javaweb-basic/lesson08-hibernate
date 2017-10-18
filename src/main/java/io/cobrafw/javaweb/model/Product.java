package io.cobrafw.javaweb.model;

import java.io.Serializable;

/**
 * Model -> Product
 *
 * @author duongnguyen
 */
public class Product implements Serializable {

	/** Serial version ID*/
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String code;

	private String name;

	private Category category;

	/**
	 *
	 */
	public Product() {
		super();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

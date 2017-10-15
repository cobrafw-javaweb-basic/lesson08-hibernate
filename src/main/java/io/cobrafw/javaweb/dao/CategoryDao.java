/*
 *==================================================================================
 *== COPYRIGHT HYPERTECH COBRA TEAM. ALL RIGHT RESERVED.							==
 *== HYPERTECH PROPRIETARY/CONFIDENTIAL. USE THIS SUBJECT TO LICENSE TERMS.		==
 *==																				==
 *== VISIT HTTP://COBRAFW.IO FOR MORE INFORMATION									==
 *==================================================================================
 *
 *== File Name: CategoryDao.java
 *== Created at: Oct 11, 2017 1:03:51 AM
 *== Created by: duongnguyen
 *== Project: lesson07-hibernate
 *== Package: io.cobrafw.javaweb.dao
 */
package io.cobrafw.javaweb.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;

import io.cobrafw.javaweb.model.Category;
import io.cobrafw.javaweb.util.HibernateUtil;

/**
 * Category Data Accessing Object
 *
 * @author duongnguyen
 */
public class CategoryDao {

	/** Hiberate DB Session */
	private Session session;

	/**
	 * Get list categories
	 *
	 * @return List Category
	 */
	public List<Category> getListCategories() {

		// Open Hibernate session
		this.openSession();

		// Create Hibernate Query
		Query<Category> query = this.session.createQuery("from Category where fatherId is null order by sortNo");

		// Execute Hibernate query and get list result
		List<Category> categoryList = query.list();

		// Close Hibernate session
		this.closeSession();

		return categoryList;
	}

	/**
	 * Get a category by id
	 *
	 * @param id Category id
	 *
	 * @return	Category
	 */
	public Category getCategory(Integer id) {

		// Open Hibernate session
		this.openSession();

		// Find category
		Category category = this.session.find(Category.class, id);

		// Close Hibernate session
		this.closeSession();

		// Return category
		return category;
	}

	/**
	 * Create new category
	 *
	 * @param category Category DTO with param
	 */
	public void createCategory(Category category) {

		// Open Hibernate session
		this.openSession();

		// Get next sort no
		Criteria criteria = this.session.createCriteria(Category.class)
							.setProjection(Projections.max("sortNo"));
		Integer sortNo = (Integer) criteria.uniqueResult();
		category.setSortNo(sortNo+1);

		// Save category
		this.session.beginTransaction();
		this.session.save(category);
		this.session.flush();
		this.session.getTransaction().commit();

		// Close Hibernate session
		this.closeSession();
	}

	/**
	 * Update category
	 *
	 * @param category  Category DTO with param
	 */
	public void updateCategory(Category category) {

		// Open Hibernate session
		this.openSession();

		// Save category
		this.session.beginTransaction();
		this.session.update(category);
		this.session.flush();
		this.session.getTransaction().commit();

		// Close Hibernate session
		this.closeSession();
	}

	/**
	 * Delete a category
	 *
	 * @param id Category ID
	 */
	public void deleteCategory(Integer id) {

		// Open Hibernate session
		this.openSession();

		// Find category
		Category category = this.session.find(Category.class, id);

		// Save category
		this.session.beginTransaction();
		this.session.delete(category);
		this.session.flush();
		this.session.getTransaction().commit();

		// Close Hibernate session
		this.closeSession();
	}

	/**
	 * Open Hibernate session
	 */
	private void openSession() {

		this.session = HibernateUtil.getSessionFactory().openSession();
	}

	/**
	 * Close Hibernate session
	 */
	private void closeSession() {

		if (this.session != null && this.session.isOpen()) {
			this.session.close();
		}
	}
}

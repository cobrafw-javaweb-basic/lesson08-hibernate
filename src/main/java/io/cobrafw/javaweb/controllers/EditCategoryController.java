/*
 *==================================================================================
 *== COPYRIGHT HYPERTECH COBRA TEAM. ALL RIGHT RESERVED.							==
 *== HYPERTECH PROPRIETARY/CONFIDENTIAL. USE THIS SUBJECT TO LICENSE TERMS.		==
 *==																				==
 *== VISIT HTTP://COBRAFW.IO FOR MORE INFORMATION									==
 *==================================================================================
 *
 *== File Name: EditCategoryController.java
 *== Created at: Oct 10, 2017 11:55:26 PM
 *== Created by: duongnguyen
 *== Project: lesson07-hibernate
 *== Package: io.cobrafw.javaweb.controllers
 */
package io.cobrafw.javaweb.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.cobrafw.javaweb.dao.CategoryDao;
import io.cobrafw.javaweb.model.Category;

/**
 * Management -> Edit category
 *
 * @author duongnguyen
 */
public class EditCategoryController extends HttpServlet {

	/** Serial Version UID */
	private static final long serialVersionUID = 2383974082637595638L;

	/** Category Dao */
	CategoryDao categoryDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditCategoryController() {
		super();
	}

	/**
	 * @see GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		this.categoryDao = new CategoryDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get parameter
		String [] idPrm = request.getParameterValues("id");

		// Validate input param
		// TODO

		// Parse param value
		Integer id = Integer.parseInt(idPrm[0]);

		// Call DAO method to get list categories
		List<Category> listCategories = this.categoryDao.getListCategories();

		// Call DAO to date current category
		Category category = this.categoryDao.getCategory(id);

		// Put data into request
		request.setAttribute("listCategories", listCategories);
		request.setAttribute("category", category);

		// Redirect to list categories JSP
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/category/edit.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set encoding
		request.setCharacterEncoding("UTF-8");

		// Get parameters
		String [] idPrm = request.getParameterValues("id");
		String [] namePrm = request.getParameterValues("name");
		String [] fatherIdPrm = request.getParameterValues("fatherId");
		String [] sortNoPrm = request.getParameterValues("sortNo");

		// Validate input parameters
		// TODO

		// Parse param value
		Integer id = Integer.parseInt(idPrm[0]);
		String name = namePrm[0];
		String fatherIdStr = fatherIdPrm[0];
		Integer fatherId = Integer.parseInt(fatherIdStr);
		Integer sortNo = Integer.parseInt(sortNoPrm[0]);

		// Create Model
		Category category = new Category();
		category.setId(id);
		category.setName(name);
		category.setFatherId(fatherId == 0 ? null : fatherId);
		category.setSortNo(sortNo);

		// Update Category
		this.categoryDao.updateCategory(category);

		// Redirect to list categories JSP
		response.sendRedirect(request.getContextPath() + "/list-categories");
	}
}

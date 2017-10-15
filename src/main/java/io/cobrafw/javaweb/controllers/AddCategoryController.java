/*
 *==================================================================================
 *== COPYRIGHT HYPERTECH COBRA TEAM. ALL RIGHT RESERVED.							==
 *== HYPERTECH PROPRIETARY/CONFIDENTIAL. USE THIS SUBJECT TO LICENSE TERMS.		==
 *==																				==
 *== VISIT HTTP://COBRAFW.IO FOR MORE INFORMATION									==
 *==================================================================================
 *
 *== File Name: AddCategoryController.java
 *== Created at: Oct 10, 2017 11:54:11 PM
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
 * Management -> Add category
 *
 * @author duongnguyen
 */
public class AddCategoryController extends HttpServlet {

	/** Serial Version UID */
	private static final long serialVersionUID = -2801783508493751174L;

	/** Category Dao */
	CategoryDao categoryDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCategoryController() {
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

		// Call DAO method to get list categories
		List<Category> listCategories = this.categoryDao.getListCategories();

		// Put data into request
		request.setAttribute("listCategories", listCategories);

		// Redirect to list categories JSP
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/category/add.jsp");
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
		String [] namePrm = request.getParameterValues("name");
		String [] fatherIdPrm = request.getParameterValues("fatherId");

		// Validate input parameters
		// TODO

		// Parse param value
		String name = namePrm[0];
		String fatherIdStr = fatherIdPrm[0];
		Integer fatherId = Integer.parseInt(fatherIdStr);

		// Create Model
		Category category = new Category();
		category.setName(name);
		category.setFatherId(fatherId == 0 ? null : fatherId);

		// Create new Category
		this.categoryDao.createCategory(category);

		// Redirect to list categories JSP
		response.sendRedirect(request.getContextPath() + "/list-categories");
	}
}

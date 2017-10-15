/*
 *==================================================================================
 *== COPYRIGHT HYPERTECH COBRA TEAM. ALL RIGHT RESERVED.							==
 *== HYPERTECH PROPRIETARY/CONFIDENTIAL. USE THIS SUBJECT TO LICENSE TERMS.		==
 *==																				==
 *== VISIT HTTP://COBRAFW.IO FOR MORE INFORMATION									==
 *==================================================================================
 *
 *== File Name: DeleteCategoryController.java
 *== Created at: Oct 10, 2017 11:54:56 PM
 *== Created by: duongnguyen
 *== Project: lesson07-hibernate
 *== Package: io.cobrafw.javaweb.controllers
 */
package io.cobrafw.javaweb.controllers;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.cobrafw.javaweb.dao.CategoryDao;
import io.cobrafw.javaweb.model.Category;

/**
 * Management -> Delete category
 *
 * @author duongnguyen
 */
public class DeleteCategoryController extends HttpServlet {

	/** Serial Version UID */
	private static final long serialVersionUID = -373299334046206684L;

	/** Category Dao */
	CategoryDao categoryDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteCategoryController() {
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

		// Call DAO to date current category
		Category category = this.categoryDao.getCategory(id);

		// Put data into request
		request.setAttribute("category", category);

		// Redirect to list categories JSP
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/category/delete.jsp");
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

		// Validate input parameters
		// TODO

		// Parse param value
		Integer id = Integer.parseInt(idPrm[0]);

		// Update Category
		this.categoryDao.deleteCategory(id);

		// Redirect to list categories JSP
		response.sendRedirect(request.getContextPath() + "/list-categories");
	}
}

/*
 *==================================================================================
 *== COPYRIGHT HYPERTECH COBRA TEAM. ALL RIGHT RESERVED.							==
 *== HYPERTECH PROPRIETARY/CONFIDENTIAL. USE THIS SUBJECT TO LICENSE TERMS.		==
 *==																				==
 *== VISIT HTTP://COBRAFW.IO FOR MORE INFORMATION									==
 *==================================================================================
 *
 *== File Name: ListCategoryController.java
 *== Created at: Oct 10, 2017 11:53:22 PM
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
 * Manage -> List Categories
 *
 * @author duongnguyen
 */
public class ListCategoryController extends HttpServlet {

	/** Serial Version UID */
	private static final long serialVersionUID = -2152629137493439650L;

	/** Category Dao */
	CategoryDao categoryDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListCategoryController() {
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
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/category/list.jsp");
		dispatcher.forward(request, response);
	}
}

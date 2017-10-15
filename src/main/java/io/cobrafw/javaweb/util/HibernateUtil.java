/*
 *==================================================================================
 *== COPYRIGHT HYPERTECH COBRA TEAM. ALL RIGHT RESERVED.							==
 *== HYPERTECH PROPRIETARY/CONFIDENTIAL. USE THIS SUBJECT TO LICENSE TERMS.		==
 *==																				==
 *== VISIT HTTP://COBRAFW.IO FOR MORE INFORMATION									==
 *==================================================================================
 *
 *== File Name: HibernateUtil.java
 *== Created at: Oct 11, 2017 12:13:48 AM
 *== Created by: duongnguyen
 *== Project: lesson07-hibernate
 *== Package: io.cobrafw.javaweb.util
 */
package io.cobrafw.javaweb.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Util
 *
 * @author duongnguyen
 */
public class HibernateUtil {

	/** Session Factory */
	private static final SessionFactory sessionFactory = buildSessionFactory();

	/**
	 * Build session factory
	 *
	 * @return SessionFactory
	 */
	private static SessionFactory buildSessionFactory() {

		try {

			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {

			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Get session factory
	 *
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Flush & close connection
	 */
	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}

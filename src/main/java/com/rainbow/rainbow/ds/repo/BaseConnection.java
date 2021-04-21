package com.rainbow.rainbow.ds.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.naming.Context;

/**
 * @author Ray Yang
 * 
 */
 
public class BaseConnection {
	private final static Logger LOGGER = Logger.getLogger(BaseConnection.class.getName());
	
	private static String RAINBOW_DB = "jdbc/rainbowDB";

	private Connection getJNDIConnection(String dc) {

		Connection conn = null;

		try {
			Context initialContext = new InitialContext();
			Context envContext  = (Context)initialContext.lookup("java:/comp/env");
			DataSource datasource = (DataSource)envContext.lookup(dc);
			if (datasource != null) {
				conn = datasource.getConnection();
			} else {
				LOGGER.info("Cannot establish the JDBC connection by JNDI context.");
			}
		} catch (Exception ex) {
			LOGGER.info(ex.getMessage());
		}

		return conn;
	}

	protected Connection rainbowConnection() {
		return getJNDIConnection(RAINBOW_DB);
	}

	protected void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}

			if (stmt != null) {
				stmt.close();
			}

			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void close(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}

			if (ps != null) {
				ps.close();
			}

			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

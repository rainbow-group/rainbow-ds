package com.rainbow.rainbow.ds.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestRepo extends BaseConnection{

	public String test() {
		
		String sql = "SELECT * FROM TEST WHERE ID = 1";
		
		Connection conn = this.rainbowConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				
				return rs.getString("test");
				
			}
		} catch (SQLException e) {
			
		} finally {
			close(rs, pstmt, conn);
		}
		
		return "";

	}
}

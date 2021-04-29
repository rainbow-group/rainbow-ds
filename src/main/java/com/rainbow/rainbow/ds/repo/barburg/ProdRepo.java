package com.rainbow.rainbow.ds.repo.barburg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rainbow.rainbow.ds.repo.BaseRepository;
import com.rainbow.rainbow.ds.vo.barburg.Category;
import com.rainbow.rainbow.ds.vo.barburg.Product;

public class ProdRepo extends BaseRepository {

	public List<Category> getCategories() {
		String sql = "SELECT * FROM category order by order_by";
		List<Category> list = new ArrayList<Category>();
		Connection conn = this.rainbowConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Category c = new Category();
				this.fillData(c, rs);

				list.add(c);
			}
		} catch (SQLException e) {

		} finally {
			close(rs, pstmt, conn);
		}

		return list;
	}
	
	public List<Product> getActiveProdByCategory(String categoryId){
		
		String sql = "select * from product where active_ind = 'Y' and category_Id=" + categoryId
				+ " order by order_by";
		
		List<Product> list = new ArrayList<Product>();
		Connection conn = this.rainbowConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Product c = new Product();
				this.fillData(c, rs);

				list.add(c);
			}
		} catch (SQLException e) {

		} finally {
			close(rs, pstmt, conn);
		}

		return list;
		
	}

}

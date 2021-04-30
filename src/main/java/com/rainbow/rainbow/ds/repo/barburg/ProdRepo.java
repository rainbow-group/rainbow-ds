package com.rainbow.rainbow.ds.repo.barburg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rainbow.rainbow.ds.repo.BaseRepository;
import com.rainbow.rainbow.ds.vo.barburg.Category;
import com.rainbow.rainbow.ds.vo.barburg.ProdInfoItem;
import com.rainbow.rainbow.ds.vo.barburg.ProdParamItem;
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

	public List<Product> getActiveProdByCategory(String categoryId) {

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

	public Product getProdDetailById(String prodId) {
		String sql = "select * from product where id=" + prodId;

		Product prod = null;
		Connection conn = this.rainbowConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				prod = new Product();
				this.fillData(prod, rs);
			}
		} catch (SQLException e) {

		} finally {
			close(rs, pstmt, conn);
		}
		return prod;
	}

	public List<ProdInfoItem> getProdInfoListByProdId(String prodId) {
		String sql = "select * from prod_info where active_ind = 'Y' and prod_id=" + prodId;
		List<ProdInfoItem> list = new ArrayList<ProdInfoItem>();
		Connection conn = this.rainbowConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProdInfoItem item = new ProdInfoItem();
				this.fillData(item, rs);
				list.add(item);
			}
		} catch (SQLException e) {

		} finally {
			close(rs, pstmt, conn);
		}
		return list;
	}
	
	public List<ProdParamItem> getProdParamsListByProdId(String prodId) {
		String sql = "select * from prod_params where active_ind = 'Y' and prod_id=" + prodId;
		List<ProdParamItem> list = new ArrayList<ProdParamItem>();
		Connection conn = this.rainbowConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProdParamItem item = new ProdParamItem();
				this.fillData(item, rs);
				list.add(item);
			}
		} catch (SQLException e) {

		} finally {
			close(rs, pstmt, conn);
		}
		return list;
	}

}

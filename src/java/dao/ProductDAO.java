package dao;

import dto.ProductDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Sample ProductDAO with basic CRUD using JDBC and Oracle SQL.
 */
public class ProductDAO extends BaseDAO {

    public List<ProductDTO> listProducts(int offset, int limit) throws Exception {
        List<ProductDTO> list = new ArrayList<>();
        String sql = "SELECT id, name, price, stock, supplier_id FROM (SELECT a.*, ROWNUM rnum FROM (SELECT id, name, price, stock, supplier_id FROM products ORDER BY id) a) WHERE rnum BETWEEN ? AND ?";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            int start = offset + 1;
            int end = offset + limit;
            ps.setInt(1, start);
            ps.setInt(2, end);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductDTO p = new ProductDTO();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                p.setStock(rs.getInt("stock"));
                p.setSupplierId(rs.getInt("supplier_id"));
                list.add(p);
            }
        } finally {
            closeQuietly(rs);
            closeQuietly(ps);
            closeQuietly(conn);
        }
        return list;
    }

    public int countAll() throws Exception {
        String sql = "SELECT COUNT(*) FROM products";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
            return 0;
        }
    }

    // Additional methods (getById, insert, update, delete) can be added similarly.
}

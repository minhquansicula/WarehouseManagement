package dao;

import entity.Supplier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO for suppliers.
 */
public class SupplierDAO extends BaseDAO {

    public List<Supplier> listAll() throws Exception {
        List<Supplier> list = new ArrayList<>();
        String sql = "SELECT id, name, contact FROM suppliers ORDER BY id";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Supplier s = new Supplier();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setContact(rs.getString("contact"));
                list.add(s);
            }
        }
        return list;
    }

    public Supplier getById(int id) throws Exception {
        String sql = "SELECT id, name, contact FROM suppliers WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Supplier s = new Supplier();
                    s.setId(rs.getInt("id"));
                    s.setName(rs.getString("name"));
                    s.setContact(rs.getString("contact"));
                    return s;
                }
            }
        }
        return null;
    }

    public int insert(Supplier s) throws Exception {
        String sql = "INSERT INTO suppliers (name, contact) VALUES (?, ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getContact());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys != null && keys.next()) return keys.getInt(1);
            }
        }
        return 0;
    }

    public void update(Supplier s) throws Exception {
        String sql = "UPDATE suppliers SET name = ?, contact = ? WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getContact());
            ps.setInt(3, s.getId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws Exception {
        String sql = "DELETE FROM suppliers WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}

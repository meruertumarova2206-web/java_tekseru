package database;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClothingItemDAO {


    public void insertItem(ClothingItem item) {
        String sql = """
                INSERT INTO clothing_items
                (name, size, price, type, has_feature)
                VALUES (?, ?, ?, ?, ?)
                """;

        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getName());
            ps.setString(2, item.getSize());
            ps.setDouble(3, item.getPrice());
            ps.setString(4, item.getType());

            if (item instanceof Shirt s) {
                ps.setBoolean(5, s.hasPrint());
            } else if (item instanceof Jacket j) {
                ps.setBoolean(5, j.hasHood());
            }

            ps.executeUpdate();
            ps.close();
            System.out.println("Item added!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }


    public List<ClothingItem> getAllItems() {
        List<ClothingItem> list = new ArrayList<>();
        String sql = "SELECT * FROM clothing_items";

        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return list;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(extract(rs));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
        return list;
    }


    public ClothingItem getById(int id) {
        String sql = "SELECT * FROM clothing_items WHERE item_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return null;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extract(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
        return null;
    }


    public void updatePrice(int id, double price) {
        String sql = "UPDATE clothing_items SET price = ? WHERE item_id = ?";
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, price);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();
            ps.close();

            if (rows > 0)
                System.out.println("Price updated!");
            else
                System.out.println("Item not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }


   public void deleteItem(int id) {
        String sql = "DELETE FROM clothing_items WHERE item_id = ?";
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            ps.close();

            if (rows > 0)
                System.out.println("Item deleted!");
            else
                System.out.println("Item not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
   }


    public List<ClothingItem> searchByPriceRange(double min, double max) {
        List<ClothingItem> list = new ArrayList<>();
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return list;

        try (PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM clothing_items WHERE price BETWEEN ? AND ? ORDER BY price DESC")) {
            ps.setDouble(1,min);
            ps.setDouble(2,max);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(extract(rs));
        } catch (SQLException e) { e.printStackTrace(); }
        finally { DatabaseConnection.closeConnection(conn); }

        return list;
    }


    public List<ClothingItem> searchByName(String name) {
        List<ClothingItem> list = new ArrayList<>();
        String sql = "SELECT * FROM clothing_items WHERE name ILIKE ?";

        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return list;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(extract(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
        return list;
    }

    public List<ClothingItem> searchByMinPrice(double minPrice) {
        List<ClothingItem> list = new ArrayList<>();
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return list;

        try (PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM clothing_items WHERE price >= ?")) {
            ps.setDouble(1, minPrice);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) list.add(extract(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
        return list;
    }

    private ClothingItem extract(ResultSet rs) throws SQLException {
        int id = rs.getInt("item_id");
        String name = rs.getString("name");
        String size = rs.getString("size");
        double price = rs.getDouble("price");
        String type = rs.getString("type");
        boolean feature = rs.getBoolean("has_feature");
        return type.equals("SHIRT")
                ? new Shirt(id, name, size, price, feature)
                : new Jacket(id, name, size, price, feature);
    }
}
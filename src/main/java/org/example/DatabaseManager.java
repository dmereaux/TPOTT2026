package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.example.Clothing;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:clothing.db";

    public Connection connect() throws SQLException {
      
    	    try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return DriverManager.getConnection(DB_URL);
  
    }

    public List<Clothing> searchClothes(String query) {
        String sql = "SELECT id, name, price, popular FROM clothes WHERE name LIKE ?";
        List<Clothing> results = new ArrayList<>();

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + query + "%");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Clothing clothing = new Clothing(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getBoolean("popular")
                );
                results.add(clothing);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return results;
    }

    public List<Clothing> getPopularClothes() {
        String sql = "SELECT id, name, price, popular FROM clothes WHERE popular = ?";
        List<Clothing> results = new ArrayList<>();

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setBoolean(1, true);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Clothing clothing = new Clothing(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getBoolean("popular")
                );
                results.add(clothing);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return results;
    }
}

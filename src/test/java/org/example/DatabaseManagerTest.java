package org.example;



import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatabaseManagerTest {
    private DatabaseManager dbManager;
    private Connection conn;

	@BeforeEach
    public void setUp() {
        dbManager = new DatabaseManager();
        conn = dbManager.connect();
    }

    @Test
    public void testConnection() {
        assertNotNull(conn);
    }

    @Test
    public void testSelectAllClothes() {
        String sql = "SELECT id, name, price, popular FROM clothes";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            assertTrue(rs.next());
            System.out.println(rs);
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println(name);
            double price = rs.getDouble("price");
            boolean isPopular = rs.getBoolean("popular");

            assertNotEquals(0, id);
            assertFalse(name.isEmpty());
            assertTrue(price > 0);
            assertTrue(isPopular || !isPopular);

        } catch (Exception e) {
            fail("Test failed: " + e.getMessage());
        }
    }

/*    @Test
    public void testSearchClothes() {
        String query = "T-Shirt";
        List<Clothing> results = dbManager.searchClothes(query);
        assertFalse(results.isEmpty());

        for (Clothing clothing : results) {
            assertTrue(clothing.getName().contains(query));
        }
    }
*/
/*    @Test
    public void testGetPopularClothes() {
        List<Clothing> popularClothes = dbManager.getPopularClothes();
        assertFalse(popularClothes.isEmpty());

        for (Clothing clothing : popularClothes) {
            assertTrue(clothing.isPopular());
        }
    }*/

    @AfterEach
    public void tearDown() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            fail("Test failed: " + e.getMessage());
        }
    }
}

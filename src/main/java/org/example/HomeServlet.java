package org.example;

import javax.servlet.*;
import javax.servlet.http.*;

import org.example.DatabaseManager;
import org.example.Clothing;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DatabaseManager dbManager = new DatabaseManager();
//        Connection conn = dbManager.connect();

        // Fetch popular clothes from the database
        List<Clothing> popularClothes = dbManager.getPopularClothes();

        request.setAttribute("popularClothes", popularClothes);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
}

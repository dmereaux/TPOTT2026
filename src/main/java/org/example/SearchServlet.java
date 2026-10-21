package org.example;

import javax.servlet.*;
import javax.servlet.http.*;

import org.example.DatabaseManager;
import org.example.Clothing;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");
        DatabaseManager dbManager = new DatabaseManager();
//        Connection conn = dbManager.connect();

        // Fetch clothes based on search query
        List<Clothing> searchedClothes = dbManager.searchClothes(query);

        request.setAttribute("searchedClothes", searchedClothes);
        request.getRequestDispatcher("/search.jsp").forward(request, response);
    }
}

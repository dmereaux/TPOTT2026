package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProduitsServlet")
public class ProduitsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DatabaseManager dbManager = new DatabaseManager();
        try {
			Connection conn = dbManager.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        List<Clothing> toto = dbManager.getAllClothes();
        System.out.print(toto.size());
        
        // Ajouter l'item à l'attribut de requête pour le transmettre à la page JSP
        request.setAttribute("liste", toto);

        // Rediriger vers la page JSP qui affiche les résultats
        request.getRequestDispatcher("/produits.jsp").forward(request, response);



        
    }
}
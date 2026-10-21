package org.example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.util.Objects.requireNonNullElse;

/**
 * Servlet implementation class RegistrationServlet as defined in web.xml
 */
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String first_name = requireNonNullElse(request.getParameter("first_name"), "");
        String last_name = requireNonNullElse(request.getParameter("last_name"), "");
        String username = requireNonNullElse(request.getParameter("username"), "");
        String password = requireNonNullElse(request.getParameter("password"), "");
        String address = requireNonNullElse(request.getParameter("address"), "");
        String contact = requireNonNullElse(request.getParameter("contact"), "");

        if (first_name.isEmpty() || last_name.isEmpty() || username.isEmpty() ||
                password.isEmpty() || address.isEmpty() || contact.isEmpty()) {
            RequestDispatcher req = request.getRequestDispatcher("/Register_1.jsp");
            req.include(request, response);
        } else {
            RequestDispatcher req = request.getRequestDispatcher("/Register_2.jsp");
            req.forward(request, response);
        }
    }
}

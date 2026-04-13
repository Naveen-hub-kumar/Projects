package com.attendance;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(username, password) VALUES (?, ?)"
            );
            ps.setString(1, user);
            ps.setString(2, pass);

            int i = ps.executeUpdate();

            if (i > 0) {
                response.sendRedirect("login.jsp?success=1");
            } else {
                response.sendRedirect("register.jsp?error=1");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
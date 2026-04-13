package com.attendance;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class AttendanceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String status = request.getParameter("status");
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps1 = con.prepareStatement(
                "SELECT id FROM users WHERE username=?"
            );
            ps1.setString(1, user);
            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                int userId = rs.getInt("id");

                PreparedStatement ps2 = con.prepareStatement(
                    "INSERT INTO attendance(user_id, date, status) VALUES (?, CURDATE(), ?)"
                );
                ps2.setInt(1, userId);
                ps2.setString(2, status);
                ps2.executeUpdate();
            }

            response.sendRedirect("dashboard.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
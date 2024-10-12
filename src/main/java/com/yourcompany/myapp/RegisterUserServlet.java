package com.yourcompany.myapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "RegisterUserServlet", urlPatterns = "/registerUser")
public class RegisterUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String mobileNumber = request.getParameter("mobileNumber");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.132.169:1521:FREE", "SCOTT", "arvind");

            String sql = "INSERT INTO users (name, mobile_number) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, mobileNumber);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                response.getWriter().println("User registered successfully!");
            } else {
                response.getWriter().println("Registration failed.");
            }

            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

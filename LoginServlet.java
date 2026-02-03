package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Get username and password from request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Generate HTML response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login Result</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; text-align: center; padding: 50px; background-color: #f4f4f4; }");
        out.println("h2 { color: #333; }");
        out.println("a { color: #007bff; text-decoration: none; }");
        out.println("a:hover { text-decoration: underline; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        
        // Check password length and display appropriate message
        if (password != null && password.length() < 8) {
            out.println("<h2>Hello " + username + ", your password is weak. Try a strong one.</h2>");
        } else {
            out.println("<h2>Welcome " + username + "</h2>");
        }
        
        out.println("<br><br>");
        out.println("<a href='login.html'>Back to Login</a>");
        out.println("</body>");
        out.println("</html>");
    }
}

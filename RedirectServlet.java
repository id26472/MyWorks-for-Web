package com.example;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Get the search query from request parameter
        String query = request.getParameter("query");
        
        // Handle null or empty query
        if (query == null || query.trim().isEmpty()) {
            query = "";
        }
        
        // URL encode the query to handle special characters
        String encodedQuery = URLEncoder.encode(query, "UTF-8");
        
        // Construct Google search URL
        String googleSearchUrl = "https://www.google.com/search?q=" + encodedQuery;
        
        // Use sendRedirect to redirect to Google
        response.sendRedirect(googleSearchUrl);
    }
}

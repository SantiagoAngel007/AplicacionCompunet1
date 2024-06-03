package org.example.virtualshop;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.virtualshop.model.Product;
import org.example.virtualshop.model.User;

import java.io.IOException;

@WebServlet(name = "SvShoppingCart", value = "/SvShoppingCart")
public class SvShoppingCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User username = (User) request.getSession().getAttribute("usuario");
        username.getListaProducts().add(new Product(request.getParameter("name"), request.getParameter("description"), Double.parseDouble(request.getParameter("price")), Integer.parseInt(request.getParameter("stock"))));
        response.sendRedirect("home.jsp");
    }
}
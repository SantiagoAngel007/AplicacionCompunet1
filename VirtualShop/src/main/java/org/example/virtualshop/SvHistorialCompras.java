package org.example.virtualshop;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.virtualshop.model.User;
import java.io.IOException;

@WebServlet(name = "SvHistorialCompras", value = "/SvHistorialCompras")
public class SvHistorialCompras extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User username = (User) request.getSession().getAttribute("usuario");
        request.getRequestDispatcher("HistorialCompras.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}

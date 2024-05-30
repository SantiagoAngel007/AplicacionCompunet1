package org.example.virtualshop;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SvUsers", value = "/SvUsers")
public class SvUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Para pruebas, envía una respuesta básica
        response.setContentType("text/html");
        response.getWriter().write("GET method is not supported.");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("usuario");
        String password = request.getParameter("contraseña");

        System.out.println("Usuario: " + name);
        System.out.println("Contraseña: " + password);

        response.setContentType("text/html");
        response.getWriter().write("Usuario: " + name + "<br>Contraseña: " + password);
    }
}

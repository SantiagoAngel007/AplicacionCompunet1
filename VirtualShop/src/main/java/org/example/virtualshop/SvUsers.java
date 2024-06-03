package org.example.virtualshop;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.example.virtualshop.model.*;

@WebServlet(name = "SvUsers", value = "/SvUsers")
public class SvUsers extends HttpServlet {

    private static List<User> listaUsuarios = new ArrayList<User>();
    private static List<Product> listaProducts = new ArrayList<Product>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("ShoppingCart.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //listaUsuarios.add(new User(request.getParameter("usuario"), request.getParameter("contraseña")));
        listaUsuarios.add(new User("Alex", "975318642"));
        listaUsuarios.add(new User("Paul", "975318642"));
        listaUsuarios.add(new User("Angel", "975318642"));

        listaProducts.add(new Product("Laptop", "Laptop HP", 500.00, 10));
        listaProducts.add(new Product("Mouse", "Mouse Logitech", 20.00, 50));
        listaProducts.add(new Product("Keyboard", "Keyboard HP", 30.00, 30));
        listaProducts.add(new Product("Monitor", "Monitor LG", 150.00, 20));

        String name = request.getParameter("usuario");
        String password = request.getParameter("contraseña");

        if(!listaUsuarios.isEmpty()){
            for(User user : listaUsuarios){
                if(user.getName().equals(name) && user.getPassword().equals(password)){
                    HttpSession session = request.getSession();
                    session.setAttribute("usuario", user);
                    session.setAttribute("productos", listaProducts);
                    response.sendRedirect("home.jsp");
                    break;
                } else {
                    System.out.println("Usuario no encontrado");
                    break;
                }
            }
        }

        response.setContentType("text/html");
        response.getWriter().write("Usuario: " + name + "<br>Contraseña: " + password);
    }
}

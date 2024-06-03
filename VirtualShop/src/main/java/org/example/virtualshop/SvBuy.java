package org.example.virtualshop;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.virtualshop.model.Buy;
import org.example.virtualshop.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SvBuy", value = "/SvBuy")
public class SvBuy extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User username = (User) request.getSession().getAttribute("usuario");

        // Obtener todos los productos del formulario
        String[] productNames = request.getParameterValues("nameProducto");
        String[] quantities = request.getParameterValues("quantity");
        String[] totals = request.getParameterValues("total");

        // Añadir cada producto a la lista de compras
        if (productNames != null) {
            for (int i = 0; i < productNames.length; i++) {
                String nameProducto = productNames[i];
                int quantity = Integer.parseInt(quantities[i]);
                double total = Double.parseDouble(totals[i]);

                username.getListaCompras().add(new Buy(nameProducto, quantity, total));
            }
        }

        // Imprimir todos los objetos de la lista con sus atributos
        System.out.println("Lista de Compras:");
        for (Buy compra : username.getListaCompras()) {
            System.out.println("Producto: " + compra.getProduct());
            System.out.println("Cantidad: " + compra.getQuantity());
            System.out.println("Costo Total: " + compra.getTotal());
            System.out.println("-------------------------------");
        }

        // Limpiar la lista de productos del usuario
        username.getListaProducts().clear();
        response.sendRedirect("ShoppingCart.jsp");
    }
}
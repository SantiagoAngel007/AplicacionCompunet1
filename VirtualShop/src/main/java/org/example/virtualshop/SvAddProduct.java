package org.example.virtualshop;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SvAddProduct", value = "/SvAddProduct")
public class SvAddProduct extends HttpServlet {

    private List<Product> productList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().write("GET method is not supported.");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("nombre");
        String description = request.getParameter("descripcion");
        double price = Double.parseDouble(request.getParameter("precio"));
        int quantity = Integer.parseInt(request.getParameter("cantidad"));

        Product newProduct = new Product(name, description, price, quantity);
        productList.add(newProduct);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Producto agregado exitosamente.</h3>");
        out.println("<a href='addProduct.jsp'>Agregar otro producto</a><br>");
        out.println("<a href='adminHome.jsp'>Volver al panel de administración</a>");
        out.println("</body></html>");
    }

    class Product {
        private String name;
        private String description;
        private double price;
        private int quantity;

        public Product(String name, String description, double price, int quantity) {
            this.name = name;
            this.description = description;
            this.price = price;
            this.quantity = quantity;
        }

        // Getters y setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}

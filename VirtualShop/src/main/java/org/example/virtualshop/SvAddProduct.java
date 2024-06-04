package org.example.virtualshop;
import org.example.virtualshop.model.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SvAddProduct", value = "/SvAddProduct")
public class SvAddProduct extends HttpServlet {

    private static final String PRODUCTS_FILE = "C:/Users/merak/OneDrive/Documents/VirtualShop/AplicacionCompunet1/VirtualShop/src/main/java/org/example/virtualshop/persistance/products.txt";

    //private List<Product> productList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().write("GET method is not supported.");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        User username = (User) request.getSession().getAttribute("usuario");

        String name = request.getParameter("nombre");
        String description = request.getParameter("descripcion");
        double price = Double.parseDouble(request.getParameter("precio"));
        int quantity = Integer.parseInt(request.getParameter("cantidad"));

        Product newProduct = new Product(name, description, price, quantity);

        List<Product> productList = leerProductosDeArchivo(PRODUCTS_FILE);
        productList.add(newProduct);

        escribirProductosAArchivo(PRODUCTS_FILE, productList);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Producto agregado exitosamente.</h3>");
        out.println("<a href='addProduct.jsp'>Agregar otro producto</a><br>");
        out.println("<a href='index.jsp'>Volver al panel de administración</a>");
        out.println("</body></html>");
    }

    private List<Product> leerProductosDeArchivo(String fileName) {
        List<Product> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0];
                    String description = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    int quantity = Integer.parseInt(parts[3]);
                    products.add(new Product(name, description, price, quantity));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    private void escribirProductosAArchivo(String fileName, List<Product> products) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Product product : products) {
                bw.write(product.getName() + "," + product.getDescription() + "," + product.getPrice() + "," + product.getQuantity());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

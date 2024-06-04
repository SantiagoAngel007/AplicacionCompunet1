package org.example.virtualshop;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

import org.example.virtualshop.model.*;


@WebServlet(name = "SvUsers", value = "/SvUsers")
public class SvUsers extends HttpServlet {

    private static final String USERS_FILE = "C:/Users/merak/OneDrive/Documents/VirtualShop/AplicacionCompunet1/VirtualShop/src/main/java/org/example/virtualshop/persistance/users.txt";
    private static final String ADMINS_FILE = "C:/Users/merak/OneDrive/Documents/VirtualShop/AplicacionCompunet1/VirtualShop/src/main/java/org/example/virtualshop/persistance/admins.txt";
    private static final String PRODUCTS_FILE = "C:/Users/merak/OneDrive/Documents/VirtualShop/AplicacionCompunet1/VirtualShop/src/main/java/org/example/virtualshop/persistance/products.txt";


    private static List<User> listaUsuarios = new ArrayList<User>();
    private static List<Administrator> listaAdministradores = new ArrayList<>();
    private static List<Product> listaProducts = new ArrayList<Product>();

    @Override
    public void init() {
        // Leer usuarios y productos del archivo al iniciar el servlet
        listaUsuarios = leerUsuariosDeArchivo(USERS_FILE);
        listaAdministradores = leerAdministradoresDeArchivo(ADMINS_FILE);
        listaProducts = leerProductosDeArchivo(PRODUCTS_FILE);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        listaUsuarios.add(new User(request.getParameter("usuario"), request.getParameter("contraseña")));
        //listaAdministradores.add(new Administrator(request.getParameter("usuario"), request.getParameter("contraseña")));



        String name = request.getParameter("usuario");
        String password = request.getParameter("contraseña");

        Path rutaRelativa = Paths.get("C:/Users/merak/OneDrive/Documents/VirtualShop/AplicacionCompunet1/VirtualShop/src/main/java/org/example/virtualshop/persistance/admins.txt");
        System.out.println(rutaRelativa.toFile().exists());

        boolean userFound = false;

        // Validar administradores primero
        for (Administrator admin : listaAdministradores) {
            if (admin.getName().equals(name) && admin.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", admin);
                response.sendRedirect("addProduct.jsp");
                userFound = true;
                break;
            }
        }

        if (!userFound) {
            // Validar usuarios normales
            for (User user : listaUsuarios) {
                if (user.getName().equals(name) && user.getPassword().equals(password)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("usuario", user);
                    session.setAttribute("productos", listaProducts);
                    actualizarListaProductosConArchivo(PRODUCTS_FILE);
                    response.sendRedirect("home.jsp");
                    userFound = true;
                    break;
                }
            }
        }

        if (!userFound) {
            response.setContentType("text/html");
            response.getWriter().write("Usuario no encontrado o contraseña incorrecta.");
        }


        if (!userFound) { // Si el usuario no se encontró, mostrar mensaje
            response.setContentType("text/html");
            response.getWriter().write("Usuario no encontrado");
        }
    }

    private List<User> leerUsuariosDeArchivo(String fileName) {
        List<User> usuarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    if ("admin".equalsIgnoreCase(parts[0])) {
                        usuarios.add(new Administrator(parts[1], parts[2]));
                    } else {
                        usuarios.add(new User(parts[1], parts[2]));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    private List<Administrator> leerAdministradoresDeArchivo(String fileName) {
        List<Administrator> administradores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    administradores.add(new Administrator(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return administradores;
    }

    private void escribirUsuariosAArchivo(String fileName, List<User> usuarios) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (User user : usuarios) {
                if (user instanceof Administrator) {
                    bw.write("admin," + user.getName() + "," + user.getPassword());
                } else {
                    bw.write("user," + user.getName() + "," + user.getPassword());
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void escribirAdministradoresAArchivo(String fileName, List<Administrator> administradores) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Administrator admin : administradores) {
                bw.write(admin.getName() + "," + admin.getPassword());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private void actualizarListaProductosConArchivo(String fileName) {
        List<Product> productosDelArchivo = leerProductosDeArchivo(fileName);
        for (Product producto : productosDelArchivo) {
            if (!listaProducts.contains(producto)) {
                listaProducts.add(producto);
            }
        }
    }

}

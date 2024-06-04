<%@ page import="java.util.List" %>
<%@ page import="org.example.virtualshop.model.Product" %>
<%@ page import="org.example.virtualshop.model.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: juan
  Date: 2/06/24
  Time: 8:00 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/carrito.css">
</head>
<body>

<%

    User username = (User) request.getSession().getAttribute("usuario");

%>

<div id="page-container">
    <div id="page1" class="fade-in">
        <div class="bloq-sup">
            <div class="bloq-sup_secd">
                <div class="div_boton_return">
                    <a href="home.jsp">  <button  class="boton-2" name="boton1" type="button"><img src="${pageContext.request.contextPath}/Images/retorno.png" height="55" width="55" alt="Botón de retorno" /> </button> </a>
                </div>
                <div class="titulo">
                    <div class="div_CCSA">
                        <h1>Mercado Libre</h1>
                    </div>
                    <div class="descripcion">
                        <h3>Carrito - Bienvenido <%= username.getName() %></h3>
                    </div>
                </div>
                <div class="carrito">

                </div>
            </div>
        </div>
        <div class="bloq-mid">
            <%--            <div class="intermed">--%>
            <%--                <h1>Iniciar Sesión</h1>--%>
            <%--            </div>--%>
            <div class="intermed-bloq">
                <%
                    List<Product> listaProductos = username.getListaProducts();
                    Map<String, Integer> productCountMap = new HashMap<>(); // Map para contar productos por nombre
                    Map<String, Double> productCostMap = new HashMap<>();  // Map para calcular el costo total por producto
                    int cont = 1;

                    // Contar la cantidad de cada producto por su nombre y calcular el costo total por producto
                    for (Product producto : listaProductos) {
                        String productName = producto.getName();
                        int currentStock = producto.getStock();
                        double currentPrice = producto.getPrice();

                        // Actualizar el mapa de conteo
                        if (productCountMap.containsKey(productName)) {
                            productCountMap.put(productName, productCountMap.get(productName) + currentStock);
                        } else {
                            productCountMap.put(productName, currentStock);
                        }

                        // Actualizar el mapa de costo total
                        if (productCostMap.containsKey(productName)) {
                            productCostMap.put(productName, productCostMap.get(productName) + (currentStock * currentPrice));
                        } else {
                            productCostMap.put(productName, currentStock * currentPrice);
                        }
                    }
                %>

                <!--//<form action="HistorialCompras.jsp" method="POST">-->
                <form action="SvBuy" method="POST">
                    <!-- Mostrar la cantidad y el costo total de cada producto -->
                    <% for (Map.Entry<String, Integer> entry : productCountMap.entrySet()) {
                        String productName = entry.getKey();
                        int totalQuantity = entry.getValue();
                        double totalCost = productCostMap.get(productName);
                    %>
                    <p><b>Producto: <%= productName %></b></p>
                    <p>Cantidad total en stock: <%= totalQuantity %></p>
                    <p>Costo total: $<%= totalCost %></p>
                    <input type="hidden" name="nameProducto" value="<%= productName %>">
                    <input type="hidden" name="quantity" value="<%= totalQuantity %>">
                    <input type="hidden" name="total" value="<%= totalCost %>">
                    <p>----------------------------------------------------</p>
                    <% } %>

                    <% for (Product producto : listaProductos) { %>
                    <p><b>Producto # <%= cont %></b></p>
                    <p>Nombre: <%= producto.getName() %></p>
                    <p>Descripción: <%= producto.getDescription() %></p>
                    <p>Precio: <%= producto.getPrice() %></p>
                    <p>----------------------------------------------------</p>

                    <% cont = cont + 1; %>
                    <% } %>
                    <button name="btn_iniciar" type="submit" class="btn-1">Comprar Productos</button>
                </form>
            </div>
        </div>
        <div class="bloq-inf">
            <h4>Mercado Libre</h4>
            <h4>Todos los derechos reservados</h4>
            <h4>1999</h4>
        </div>
    </div>
</div>
</body>
</html>

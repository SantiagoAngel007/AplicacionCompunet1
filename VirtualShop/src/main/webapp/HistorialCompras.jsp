<%--
  Created by IntelliJ IDEA.
  User: merak
  Date: 3/06/2024
  Time: 12:55 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.virtualshop.model.Product" %>
<%@ page import="org.example.virtualshop.model.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="org.example.virtualshop.model.Buy" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Historial de Compras</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/historial-compras.css">
</head>
<body>

<%
    User username = (User) request.getSession().getAttribute("usuario");
    List<Buy> historialCompras = username.getListaCompras();
%>

<div id="page-container">
    <div id="page1" class="fade-in">
        <div class="bloq-sup">
            <div class="titulo">
                <h1>Historial de Compras</h1>
            </div>
        </div>
                <table class="form-1">
                    <thead>
                        <tr>
                            <th>Fecha</th>
                            <th>Producto</th>
                            <th>Cantidad</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Buy producto : historialCompras) { %>
                        <tr>
                            <td><%= new SimpleDateFormat("dd-MM-yyyy").format(new Date()) %></td>
                            <td><%= producto.getProduct() %></td>
                            <td><%= producto.getQuantity() %></td>
                            <td>$<%= producto.getTotal() %></td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
    </div>
</div>
<div class="bloq-inf">
    <h4>Mercado Libre</h4>
    <h4>Todos los derechos reservados</h4>
    <h4>1999</h4>
    <!-- Botón para regresar a la zona de compras -->
    <a href="home.jsp" class="btn-regresar">Seguir Comprando</a>
</div>
</body>
</html>

<%--
<div class="bloq-mid">
            <div class="intermed-bloq">
                <table class="form-1">
                    <thead>
                        <tr>
                            <th>Fecha</th>
                            <th>Producto</th>
                            <th>Cantidad</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Buy producto : historialCompras) { %>
                        <tr>
                            <td><%= new SimpleDateFormat("dd-MM-yyyy").format(new Date()) %></td>
                            <td><%= producto.getProduct() %></td>
                            <td><%= producto.getQuantity() %></td>
                            <td>$<%= producto.getTotal() %></td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>

--%>
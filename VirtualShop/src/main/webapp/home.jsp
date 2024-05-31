<%@ page import="java.util.List" %>
<%@ page import="org.example.virtualshop.model.Product" %><%--
  Created by IntelliJ IDEA.
  User: juan
  Date: 30/05/24
  Time: 3:35 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css">
</head>
<body>

<%

    String username = (String) request.getSession().getAttribute("usuario");

%>

<div id="page-container">
    <div id="page1" class="fade-in">
        <div class="bloq-sup">
            <div class="bloq-sup_secd">
                <div class="div_boton_return">
                    <img src="${pageContext.request.contextPath}/Images/mercado-libre-svgrepo-com.png" height="55" width="55" alt="Botón de retorno" />
                </div>
                <div class="titulo">
                    <div class="div_CCSA">
                        <h1>Mercado Libre</h1>
                    </div>
                    <div class="descripcion">
                        <h3>Home - Bienvenido <%= username %></h3>
                    </div>
                </div>
                <div class="carrito">
                    <form action="SvUsers" method="GET">
                        <button class="boton-2" name="boton1" type="submit" onclick="redirigirServiciosAsignaciondesdeRegistro()">
                            <img src="${pageContext.request.contextPath}/Images/carro-de-la-compra.png" height="55" width="55" alt="Botón de retorno" />
                        </button>
                    </form>
                </div>
            </div>
        </div>
        <div class="bloq-mid">
<%--            <div class="intermed">--%>
<%--                <h1>Iniciar Sesión</h1>--%>
<%--            </div>--%>
            <div class="intermed-bloq">
                <%
                    List<Product> listaProductos = (List<Product>) request.getSession().getAttribute("productos");
                    int cont = 1;

                    for (Product producto : listaProductos) {
                %>

                <p><b>Producto # <%=cont%></b></p>
                <p>Nombre: <%= producto.getName() %></p>
                <p>Descripción: <%= producto.getDescription() %></p>
                <p>Precio: <%= producto.getPrice() %></p>
                <p>Stock: <%= producto.getStock() %></p>
                <p>----------------------------------------------------</p>

                <%cont = cont + 1;%>
                <% } %>
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

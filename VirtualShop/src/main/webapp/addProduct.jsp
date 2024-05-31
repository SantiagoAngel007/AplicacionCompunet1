<%--
  Created by IntelliJ IDEA.
  User: merak
  Date: 30/05/2024
  Time: 5:26 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agregar Producto</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/agregar-producto.css" type='text/css'>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/Images/mercado-libre-svgrepo-com.png">
</head>
<body>
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
                        <h3>Centro Compartido de Servicios</h3>
                    </div>
                </div>
            </div>
        </div>
        <div class="bloq-mid">
            <div class="intermed">
                <h1>Agregar Nuevo Producto</h1>
            </div>
            <div class="intermed-bloq">
                <form action="SvAddProduct" method="POST" class="form-1" autocomplete="off">
                    <p><label>Nombre del Producto:</label><input type="text" name="nombre" required></p>
                    <p><label>Descripción:</label><input type="text" name="descripcion" required></p>
                    <p><label>Precio:</label><input type="number" step="0.01" name="precio" required></p>
                    <p><label>Cantidad Disponible:</label><input type="number" name="cantidad" required></p>
                    <div class="buttondiv button-container">
                        <button type="submit" class="btn-1">Agregar Producto</button>
                    </div>
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
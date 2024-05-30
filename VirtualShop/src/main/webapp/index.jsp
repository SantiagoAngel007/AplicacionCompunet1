<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type='text/css'>
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
                <h1>Iniciar Sesión</h1>
            </div>
            <div class="intermed-bloq">
                <form action="SvUsers" method="POST" class="form-1" autocomplete="off">
                    <p><label>Usuario:</label><input type="text" name="usuario"></p>
                    <p><label>Contraseña:</label><input type="text" name="contraseña"></p>
                    <div class="buttondiv button-container">
                        <button name="btn_registrar" type="button" class="btn-1" onclick="redirigirRegistro()">Registrar</button>
                        <button name="btn_iniciar" type="submit" class="btn-1">Iniciar Sesión</button>
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

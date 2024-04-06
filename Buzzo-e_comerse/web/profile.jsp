<%-- 
    Document   : profile.jsp
    Created on : Dec 5, 2023, 7:30:17 PM
    Author     : university
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="model.Consumer"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UFT-8" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./css/styleP.css" />
    <title>Profile Consumer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
    <header>
        <div class="contenedor-hero">
            <div class="hero"></div>
            <div class="contenedor-logo">
                <h1 class="Logo">Buzzo</h1>
                <img src="./css/Logo.jpg">
            </div>
            <div class="contenedor-volver">
                <div class="contenedor-inicio">
                    <a class= "boton-menu boton-volver"href="homepage.jsp">
                        <i class="bi bi-arrow-left-circle-fill"></i>Keep buying
                    </a>
                </div>    
            </div>
        </div>
    </header>
    <section class="perfil-usuario">
        <div class="perfil-usuario-header">
            <div class="perfil-usuario-portada" >
                <div class="perfil-usuario-avatar">
                    <img src="./css/images.png" alt="img-avatar">
                    <button type="button" class="boton-avatar">
                        <i class="icon-imagen"></i>
                    </button>
                </div>
            </div>
        </div>
        <%
            Consumer user = (Consumer)request.getAttribute("user");
        %>
        <div class="seccion-body">
            <div class="perfil-usuario-bio">
                <h3 class="nombre"><%=user.getName()%></h3>
                <p class="email"><%=user.getEmail()%></p>
            </div>
        </div>
        <div class="perfil-usuario-footer">
            <div class="lista-datos">
                <ul>
                    <li><i class="bi bi-house-fill"></i>Address</li>
                    <p class="adress"> <%=user.getAddress()%></p>
                </ul>
            </div>
        </div>
        <div class="contenedor-history">
            <a class="boton-historial" href="controller_product?action=historialButton" id="historialButton">
                <i class="bi bi-cart-fill"></i> Purchase history
            </a>
        </div>
        <div class="contenedor-registro-vendedor">
            <a class="boton-registro-vendedor" href="singUpVe.jsp">
            <i class="bi bi-shop"></i>Register as a seller
            </a>
        </div>
    </section>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>

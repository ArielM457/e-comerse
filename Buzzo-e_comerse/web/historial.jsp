<%-- 
    Document   : historial.jsp
    Created on : Dec 8, 2023, 10:41:23 PM
    Author     : university
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.History" %>
<%@ page import="model.HistoryDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Map.Entry" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="es">
    <html>
<head>
    <style>
        .history-productos {
            display: flex;
            flex-wrap: wrap;
        }

        .purchase-detail {
            width: 25%;
            margin: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            padding: 10px;
        }
    </style>
</head>
<body>
<head>
    <meta charset="UFT-8" >
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./css/styleHis.css" />
    <title>historial de compras</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
    <div class="wrapper">
        <header>
            <div class="contenedor-hero">
                <div class="hero"></div>
                    <div class="contenedor-logo">
                        <h1 class="Logo">Buzzo</h1>
                        <i class="bi bi-bicycle"></i>
                    </div>
                    <div class="contenedor-volver">
                        <div class="contenedor-inicio">
                            <a class="boton-carrito" href="controller_user?action=profile">
                                <i class="bi bi-arrow-left-circle-fill"></i>Keep buying
                            </a>
                        </div>    
                    </div>
                </div>
            
            <div class="contenedor-navbar">
                <nav class="navbar">
                    <ul class="menu">
                        <li>
                            <a class="boton-menu boton-history active" href="#">Purchase history</a>
                        </li>
                        <li><span id="numerito" class="numerico">0</span></li>
                    </ul>
                    <i class="bi bi-cart-check"></i>
                    <form class="buscar-form">
                        <input type="search" placeholder="Search..." />
                        <button class="btn-buscar">
                            <i class="bi bi-search"></i>
                        </button>
                    </form>

                </nav>
            </div>
        </header>
       <main>
            <h2 class="titulo-principal">Purchase history</h2>
            <div class="contenedor-history">

                <% 
                List<History> historyUser = (List<History>)request.getAttribute("historyIn");
                if (historyUser == null || historyUser.isEmpty()) {
                %>
                    <div id="history-vacio" class="history-vacio">
                        <p>Your purchase history is empty.</p>
                        <i class="bi bi-cart-dash"></i>
                    </div>
                <% } else { %>
                    <div id="history-productos" class="history-productos">
                        <% for (History historyMin : historyUser) { %>
                            <div class="purchase-detail">
                                <p>ID: <%= historyMin.getIdPurchaseDetail() %></p>
                                <p>Product ID: <%= historyMin.getIdProduct() %></p>
                                <p>Amount: <%= historyMin.getAmount() %></p>
                                <p>Subtotal: <%= historyMin.getSubtotal() %></p>
                                <% Product product = historyMin.getProduct(); %>
                                <p>Description: <%= product.getDescription() %></p>
                                <p>Category: <%= product.getIdCategory() %></p>
                                <img src="<%= product.getImage() %>" alt="Product Image">
                            </div>
                        <% } %>
                    </div>
                <% } %>

                <div id="history-acciones" class="history-acciones disabled">
                    <!-- Tu código existente para acciones -->
                    <div class="history-acciones-izquierda">
                        <button id="historial-acciones-vaciar"  class="history-acciones-vaciar">Clear purchase history</button>
                    </div>
                    <div class="history-acciones-derecha">
                        <div class="history-acciones-total">
                            <p>Total:</p>
                            <p id="total-historial">$</p>
                        </div>
                    </div>
                </div>

            </div>
        </main>

    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="./js/historial.js"></script> 
</body>
</html>

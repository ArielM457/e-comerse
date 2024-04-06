<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="model.ShoppingCart"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UFT-8" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/styleCat.css" />
    <title>Shopping Cart</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
    <div class="wrapper">
        <header>
            <div class="contenedor-hero">
                <div class="hero"></div>
                    <div class="contenedor-logo">
                        <h1 class="Logo">Buzzo</h1>
                        <img src="css/Logo.jpg">
                    </div>
                    <div class="contenedor-volver">
                        <div class="contenedor-inicio">
                            <a class= "boton-menu boton-volver"href="controller_product?action=allproducts">
                                <i class="bi bi-arrow-left-circle-fill"></i>Keep buying
                            </a>
                        </div>    
                    </div>
                </div>
            </div>
            <div class="contenedor-navbar">
                <nav class="navbar">
                    <ul class="menu">
                        <li>
                            
                            <a class="boton-menu boton-carrito active" href="controller_shoppingCart?shoppingCart">Shopping cart</a>
                        </li>
                    </ul>
                    <i class="bi bi-cart-check"></i>
                </nav>
            </div>
        </header>
        <main>
            <h2 class="titulo-principal">Shopping cart</h2>
            <div class="contenedor-carrito">
                <div id="carrito-productos" class="carrito-productos">
                     <%  if (request.getAttribute("cartProducts")!= null){ %>
                    <table>
                        <thead>
                            <tr>
                                <th>Product</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th>Subtotal</th>
                            </tr>
                        </thead>
                        <tbody>
                           <%
                                ArrayList<ShoppingCart> list = (ArrayList<ShoppingCart>)request.getAttribute("cartProducts");
                                for(int i = 0; i < list.size(); i++)
                                {
                                    ShoppingCart sp = list.get(i);
                            %>  
                            <tr>
                                <td><img class="carrito-producto-imagen" src="<%=sp.getImage()%>" alt="<%=sp.getDescription()%>"></td>
                                
                                <td><%=sp.getQuantity()%></td>
                                <td><%=sp.getPrice()%></td>
                                <td><%=sp.getSubtotal()%></td>
                                <td>
                                    <a href="controller_shoppingCart?action=delete&id=<%=sp.getIdProduct()%>" id="btnDelete" ><i class="bi bi-trash"></i></a>
                                </td>
                            </tr>
                            <% 
                                } 
                            %>
                        </tbody>
                    </table>
                </div>
                <div id="carrito-acciones" class="carrito-acciones">
                    
                    <div class="carrito-acciones-izquierda">
                        <a class="carrito-acciones-vaciar" href="controller_shoppingCart?action=deleteAll">Empty shopping cart</a>
                    </div>
                    <div class="carrito-acciones-derecha">
                        <div class="carrito-acciones-total">
                            <p>Total:</p>
                            <p id="total" >$${total}0</p>
                        </div>
                        <a id="carrito-acciones-comprar" href="controller_user?action=buyNow" class="carrito-acciones-comprar">Buy now</a>
                    </div>
                </div>
                <% }else{ %>
                    <p id="carrito-vacio" class="carrito-vacio"> Your shopping cart is empty. <i class="bi bi-emoji-frown"></i></p>
                <%
                    } 
                %>
                <%--<p id="carrito-comprado" class="carrito-comprado disabled"> Thanks for you purchase. <i class="bi bi-emoji-laughing"></i></p>--%>
            
            </div>
                
        </main>

    <%-- <script src="./js/carrito.js"></script> --%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="js/functions.js" type="text/javascript"></script>
</body>
</html>
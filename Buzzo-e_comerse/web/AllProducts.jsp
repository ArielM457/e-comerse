<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="model.Product"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UFT-8" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/styleCat.css" />
    <title>Catalogo</title>
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
                <div class="contenedor-usuario">
                    <a class="boton-carrito" href="controller_user?action=profile">
                        <i class="bi bi-person-fill"></i>Profile
                    </a>
                    <div class="contenedor-carrito">
                        <a class="boton-carrito" href="controller_shoppingCart?action=shoppingCart">
                            <i class="bi bi-cart-fill"></i>Shopping cart
                            <label id="numerito" class="numerico">${counter}</label>
                        </a>
                    </div>
                </div>
            </div>
        <div class="contenedor-navbar">
            <nav class="navbar">
                <i class="bi bi-list"></i>
              
                <ul class="menu">
                    <li>
                        <a  class="boton-menu boton-categoria" href="controller_product?action=home" target="container">Home</a>
                    </li>
                    <li>
                        <a  class="boton-menu boton-categoria active" href="controller_product?action=allproducts" target="container">All the products</a>
                    </li>
                    <li>
                        <a id="books" href="controller_product?action=category&name=Books" class="boton-menu boton-categoria">Books</a>
                    </li>
                    <li>
                        <a id="clothes" href="controller_product?action=category&name=Clothes" class="boton-menu boton-categoria">Clothes</a>
                    </li>
                    <li>
                        <a id="scholl" href="controller_product?action=category&name=School" class="boton-menu boton-categoria ">School accesories</a>
                    </li>
                </ul>

                <form class="buscar-form" action="controller_product" method="GET">
                    <input type="search" name="searchKeyword" placeholder="Search..." />
                    <button type="submit" name="action" value="search" class="btn-buscar">
                        <i class="bi bi-search"></i>
                     </button>
                </form>
            </nav>
        </div>
        </header>   
    </div>
        <main style="padding-top: 180px">
            <h2 class="titulo-principal"  id="titulo-principal">All the products</h2>
            <div class="contenedor-productos">

                    <% 
                        if (request.getAttribute("products")!= null){
                            ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("products");
                            for(int i = 0; i < list.size(); i++)
                            {
                                Product p = list.get(i);
                    %>  
                      <div>
                        <img class = "producto-imagen" src="<%=p.getImage()%>">
                        <div class="producto-detalles">
                            <h3 class="producto-descripcion"><%=p.getDescription()%></h3>
                            <p class="producto-precio">PRICE: <%=p.getPrice()%>Bs.</p>
                            <p class="producto-cantidad" >STOCK: <%=p.getStock()%></p>
                            <a class="producto-agregar" href="controller_shoppingCart?action=addShoppingCart&id=<%=p.getIdProduct()%>">Add to cart</a>
                            
                        </div>
                      </div>
                <%
                        }
                    }
                %>
            </div>
        </main>

</body>

</html>

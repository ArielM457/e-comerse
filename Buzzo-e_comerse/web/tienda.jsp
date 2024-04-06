<%-- 
    Document   : tienda.jsp
    Created on : Dec 8, 2023, 10:43:25 PM
    Author     : university
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UFT-8" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./css/styleTienda.css" />
    <title>Bootstrap sign in Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

    <section>
        <div class="contenedor-registroStore">
            <div class="formulario">
                <form action="#">
                    <h2> Register your store </h2>
    
                    <div class="input-contenedor">
                        <i class="bi bi-shop"></i>
                        <input type="name" required>
                        <label for="#">Store name:</label>
                    </div>
                    <div class="input-contenedor">
                        <i class="bi bi-house"></i>
                        <input type="adress" required>
                        <label for="#">Adress:</label>
                    </div>
                    <div class="input-contenedor-store">
                        <select>
                            <option>Business Type</option>
                            <option>Books</option>
                            <option>Clothes</option>
                            <option>Scholl accesories</option>
                        </select>
                    </div>
                    <div>
                        <button type="submit">Register store</button>
                    </div>
                </form>
            </div>
        </div>
    </section>
</body>
</html>

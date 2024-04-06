<%-- 
    Document   : metodopago.jsp
    Created on : Dec 8, 2023, 10:42:53 PM
    Author     : university
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Metodo de pago</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/pago.css" />
</head>
<body>

    <main>
        <section id="contenedor-metodo-pago">
            <h2>Payment method</h2>
        
            <div id="seleccion-pago">
                <label>
                    <h2>$${total}0</h2>
                </label>
                <label>
                    <input type="radio" name="tipo-pago" id="pago-tarjeta" checked>
                    Card payment <i class="bi bi-credit-card"></i>
                </label>
        
                <label>
                    <input type="radio" name="tipo-pago" id="pago-efectivo">
                    Cash payment <i class="bi bi-cash"></i>
                </label>
            </div>
        
            <div id="formulario-pago">
                <div id="card-form" class="card-form disabled">
                    <label>
                        Name on the card:
                        <input id="nombre-tarjeta" type="text" placeholder="Name on the card">
                    </label>
            
                    <label>
                        Card number:
                        <input id="numero-tarjeta" type="text" placeholder="Card number">
                    </label>
            
                    <label>
                        Due date:
                        <input id="fecha-vencimiento" type="text" placeholder="MM/YY">
                    </label>
            
                    <label>
                        CVC:
                        <input id="cvc" type="text" placeholder="CVC">
                    </label>
            
                    <div id="errores-tarjeta" role="alert"></div>
            
                    <a id="boton-pago-tarjeta" href="controller_shoppingCart?action=purchase&payment=2">Pay with card</a>
                </div>
    
                <div id="efectivo-form" class="efectivo-form disabled">
                    <p>Fill in the details for cash payment:</p>
                    <label>
                        Cash amount:
                        <input type="text" id="monto-efectivo" placeholder="Cash amount">
                    </label>

                    <label>
                        Name of person collecting:
                        <input type="text" id="nombre-recogedor" placeholder="Name of person collecting">
                    </label>

                    <label>
                        Pickup number:
                        <input type="text" id="numero-recogedor" placeholder="Pickup number">
                    </label>

                    <a id="boton-pago-efectivo" href="controller_shoppingCart?action=purchase&payment=1">Pay cash</a>
                </div>
            </div>
        </section>

        <section id="agradecimiento" class="agradecimiento disabled">
            <h3>Thanks for your purchase!</h3>
            <div class="contenedor-volver">
                <div class="contenedor-inicio">
                    <a class= "boton-menu boton-volver"href="controller_product?action=allproducts">
                        <i class="bi bi-arrow-left-circle-fill"></i>Keep buying
                    </a>
                </div>    
            </div>
        </section>
        
    </main> 
    
    <script src="./js/pagos.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</body>
</html>


<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UFT-8" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/style.css" />
    <title>Login Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

    <section>
        <div class="contenedor">
            <div class="formulario">
                <form method = "POST" action="controller_login">
                    <h2> Welcome to Buzzo</h2>
                    
                    <div class="input-contenedor">
                        <select>
                            <option>Enter as</option>
                            <option>Seller</option>
                            <option>Consumer</option>
                        </select>
                    </div>
                    <div class="input-contenedor">
                        <i class="bi bi-envelope"></i>
                        <input name="txtemail" type="text" required>
                        <label for="#">Email:</label>
                    </div>

                    <div class="input-contenedor">
                        <i class="bi bi-lock-fill"></i>
                        <input name="txtpassword" type="password" required>
                        <label for="#">Password:</label>
                    </div>

                    <div class="olvidar">
                            <a href="#">Did you forget your password?</a>
                    </div>
                

                <div>
                    <button type="submit">Log in</button>

                <div class="palabra">
                    <p>or</p>
                </div>
                <div class="otros">

                    <button><i class="bi bi-google"></i></button>
                    <button><i class="bi bi-facebook"></i></button>
                    <button><i class="bi bi-instagram"></i></button>
                </div>
                    
              
                    <div class="registrar">
                        <p>Don't have an account? <a href="singUpCo.jsp" > sign up</a></p>
                    </div>
                </div>
                <div class="palabra">
                    <h6>    
                        <%
                            if(request.getAttribute("msg")!=null)
                            out.println(request.getAttribute("msg"));
                            if(request.getParameter("msg22")!=null)
                            out.println(request.getParameter("msg22"));
                        %>             
                    </h6>
                </div>
                    </form>
            </div>
                    
        </div>
    </section>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script src="./js/llevar.js"></script>
</body>
</html>

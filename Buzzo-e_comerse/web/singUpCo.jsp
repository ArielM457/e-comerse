<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UFT-8" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/stylesingup.css" />
    <title>Sign in Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

    <section>
        <div class="contenedor-signupC">
            <div class="formulario">
                <form action="controller_register">
                    <h2> Welcome to Buzzo</h2>

                    <div class="input-contenedor">
                        <i class="bi bi-person"></i>
                        <input type="text" name="txtnombre" required>
                        <label for="#">Name:</label>
                    </div>
                    <div class="input-contenedor">
                        <i class="bi bi-envelope"></i>
                        <input type="email" name="txtemail" required>
                        <label for="#">Email:</label>
                    </div>
                    <div class="input-contenedor">
                        <i class="bi bi-house"></i>
                        <input type="text" name="txtadress" required>
                        <label for="#">Adress:</label>
                    </div>
                    <div class="input-contenedor">
                        <i class="bi bi-lock-fill"></i>
                        <input type="password" name="txtpassword" required>
                        <label for="#">Password:</label>
                    </div>
                    <div>
                        <button>Sign up</button>
                        <div class="entra">
                            <p>Already have an account?<a href="index.jsp" > Log in</a></p>
                        </div>
                    </div>
                    <div class="palabra">
                        <p>or</p>
                    </div>
                    <div class="otros">
                        <button><i class="bi bi-google"></i></button>
                        <button><i class="bi bi-facebook"></i></button>
                        <button><i class="bi bi-instagram"></i></button>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
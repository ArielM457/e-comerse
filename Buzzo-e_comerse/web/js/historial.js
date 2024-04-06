let historialDeCompras = localStorage.getItem("historial-de-compras");
console.log("Datos en localStorage:", historialDeCompras);
historialDeCompras = JSON.parse(historialDeCompras);
const contenedorHistorialVacio = document.querySelector("#history-vacio");
const contenedorHistorial = document.querySelector("#history-productos");
const ContenedorHistorialAcciones = document.querySelector("#history-acciones");
let botonesElimina;
const botonVaciarHistorial = document.querySelector("#historial-acciones-vaciar");
const contenedorTotalHistorial = document.querySelector("#total-historial");

function cargarhistorialDeCompras() {
    
    if (historialDeCompras && historialDeCompras.length > 0) {
        contenedorHistorialVacio.classList.add("disabled");
        contenedorHistorial.classList.remove("disabled");
        ContenedorHistorialAcciones.classList.remove("disabled");

        contenedorHistorial.innerHTML = "";

        let totalGeneral = 0; // Inicializa el total general

        historialDeCompras.forEach(compra => {
            compra.productos.forEach(producto => {
                const div = document.createElement("div");
                div.classList.add("historial-compra");
                const totalProducto = parseFloat(producto.price) * parseInt(producto.total);
                div.innerHTML = `
                    <img class="carrito-producto-imagen" src="${producto.image}" alt="${producto.description}">
                    <div class="carrito-producto-titulo">
                        <small>Qualification</small>
                        <h3>${producto.description}</h3>
                    </div>
                    
                    <div class="carrito-producto-cantidad">
                        <small>Quantity</small>
                        <p>${producto.total}</p>
                    </div>
                    <div class="carrito-producto-precio">
                        <small>Price</small>    
                        <p>$${parseFloat(producto.price)}</p>
                    </div>
                    <p>Fecha: ${compra.date}</p>
                    <p>Total: $${totalProducto}</p>
                    <button class="carrito-producto-eliminar" data-compra="${historialDeCompras.indexOf(compra)}" data-producto="${compra.productos.indexOf(producto)}"><i class="bi bi-trash"></i></button>
                `;

                contenedorHistorial.append(div);

                console.log("Valor de compra.total:", producto.total);
                totalGeneral += totalProducto || 0;
                console.log("Total después de la compra:", totalGeneral);
            });
        });
        console.log("Total general antes de la actualización:", totalGeneral);
        contenedorTotalHistorial.innerText = totalGeneral;
        console.log("Total general después de la actualización:", contenedorTotalHistorial.innerText);
    } else {
        contenedorHistorialVacio.classList.remove("disabled");
        contenedorHistorial.classList.add("disabled");
        ContenedorHistorialAcciones.classList.add("disabled");
    }

    actualizarBotonesEliminar();
    actualizacionTotal();
}
cargarhistorialDeCompras();

function actualizarBotonesEliminar() {
    botonesElimina = document.querySelectorAll(".carrito-producto-eliminar");

    botonesElimina.forEach(boton => {
        boton.addEventListener("click", eliminardelhistorial);
    });
}

function eliminardelhistorial(e) {
    const indexCompra = e.currentTarget.getAttribute("data-compra");
    const indexProducto = e.currentTarget.getAttribute("data-producto");

    historialDeCompras[indexCompra].productos.splice(indexProducto, 1);

    if (historialDeCompras[indexCompra].productos.length === 0) {
        historialDeCompras.splice(indexCompra, 1);
    }

    cargarhistorialDeCompras();
    localStorage.setItem("historial-de-compras", JSON.stringify(historialDeCompras));
}
    
function agregarAlCarrito(e) {
    const idBoton = e.currentTarget.id;
    const productoAgregado = productos.find(producto => producto.id === idBoton);

    if (productosEnCarrito.some(producto => producto.id === idBoton)) {
        const index = productosEnCarrito.findIndex(producto => producto.id === idBoton);
        productosEnCarrito[index].cantidad++;
    } else {
        productoAgregado.cantidad = 1;
        productosEnCarrito.push(productoAgregado);
    }

    actualizarNumerito();
    localStorage.setItem("productos-en-carrito", JSON.stringify(productosEnCarrito));

    const nuevaCompra = {
        fecha: obtenerFechaActual(),
        total: productoAgregado.precio * productoAgregado.cantidad,
        productos: [productoAgregado]
    };

    historialDeCompras.push(nuevaCompra);

    localStorage.setItem("historial-de-compras", JSON.stringify(historialDeCompras));

    cargarhistorialDeCompras();
}
botonVaciarHistorial.addEventListener("click", vaciarCarrito);

function vaciarCarrito() {
    Swal.fire({
        title: 'Are you sure?',
        icon: "question",
        html: ` ${historialDeCompras.reduce((acc, compra) => acc + compra.productos.length, 0)} products will be deleted`,
        showCancelButton: true,
        focusConfirm: false,
        confirmButtonText: 'Yes',
        cancelButtonText: 'No',
    }).then((result) => {
        if (result.isConfirmed) {
            historialDeCompras.length = 0;
            localStorage.setItem("historial-de-compras", JSON.stringify(historialDeCompras));
            cargarhistorialDeCompras();
        }
    });
}

function actualizacionTotal() {
    console.log("Actualizando total...");

    let totalGeneral = 0; 

    historialDeCompras.forEach(compra => {
        compra.productos.forEach(producto => {
            totalGeneral += parseFloat(producto.price) * parseInt(producto.total) || 0;
        });
    });

    console.log("Historial de compras:", historialDeCompras);
    console.log("Total general calculado:", totalGeneral);
    contenedorTotalHistorial.innerText = totalGeneral; 
}

cargarhistorialDeCompras(); 
actualizarBotonesEliminar(); 
actualizacionTotal(); 
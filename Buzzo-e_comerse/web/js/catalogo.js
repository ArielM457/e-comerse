const productos = [
    {
        id:"1",
        descripcion:"Harry Potter book series",
        imagen:"./img/books/01.jpg",
        categoria: {
            nombre:"Books",
            id:"1"
        },
        precio: 5000,
        cantidad: 10
    },
    {
        id:"2",
        descripcion:"Love in times of anger",
        imagen:"./img/books/02.jpg",
        categoria: {
            nombre:"Books",
            id:"1"
        },
        precio: 1000,
        cantidad: 10
    },
    {
        id:"3",
        descripcion:"Dracula",
        imagen:"./img/books/03.jpg",
        categoria: {
            nombre:"Books",
            id:"1"
        },
        precio: 1500,
        cantidad: 10
    },
    {
        id:"4",
        descripcion:"Red, white and blood blood",
        imagen:"./img/books/04.jpg",
        categoria: {
            nombre:"Books",
            id:"1"
        },
        precio: 1070,
        cantidad: 10
    },
    {
        id:"5",
        descripcion:"IT",
        imagen:"./img/books/05.jpg",
        categoria: {
            nombre:"Books",
            id:"1"
        },
        precio: 2000,
        cantidad: 10
    },
    {
        id:"6",
        descripcion:"Zombie survival guide",
        imagen:"./img/books/06.jpg",
        categoria: {
            nombre:"Books",
            id:"1"
        },
        precio: 500,
        cantidad: 10
    },

    //ropa
    {
        id:"7",
        descripcion:"Wool sweater",
        imagen:"./img/clothes/01.jpg",
        categoria: {
            nombre:"Clothes",
            id:"2"
        },
        precio: 1500,
        cantidad: 10
    },
    {
        id:"8",
        descripcion:"Skirt",
        imagen:"./img/clothes/02.jpg",
        categoria: {
            nombre:"Clothes",
            id:"2"
        },
        precio: 1000,
        cantidad: 10
    },
    {
        id:"9",
        descripcion:"Tshirts",
        imagen:"./img/clothes/03.jpg",
        categoria: {
            nombre:"Clothes",
            id:"2"
        },
        precio: 1500,
        cantidad: 10
    },
    {
        id:"10",
        descripcion:"Jean pants",
        imagen:"./img/clothes/04.jpg",
        categoria: {
            nombre:"Clothes",
            id:"2"
        },
        precio: 1800,
        cantidad: 10
    },
    {
        id:"11",
        descripcion:"Jean pants",
        imagen:"./img/clothes/05.jpg",
        categoria: {
            nombre:"Clothes",
            id:"2"
        },
        precio: 1500,
        cantidad: 10
    },
    {
        id:"12",
        descripcion:"Baseball Jacket",
        imagen:"./img/clothes/06.jpg",
        categoria: {
            nombre:"Clothes",
            id:"2"
        },
        precio: 1500,
        cantidad: 10
    },
    {
        id:"13",
        descripcion:"Jean pants",
        imagen:"./img/clothes/07.jpg",
        categoria: {
            nombre:"Clothes",
            id:"2"
        },
        precio: 1500,
        cantidad: 10
    },
    {
        id:"14",
        descripcion:"Wool sweater",
        imagen:"./img/clothes/08.jpg",
        categoria: {
            nombre:"Clothes",
            id:"2"
        },
        precio: 1500,
        cantidad: 10
    },

    //utiles escolares
    {
        id:"15",
        descripcion:"Compass Ascona",
        imagen:"./img/scholl/01.jpg",
        categoria: {
            nombre:"School",
            id:"3"
        },
        precio: 800,
        cantidad: 10
    },
];

const contenedorProductos = document.querySelector("#contenedor-productos");
const botonesCategorias = document.querySelectorAll(".boton-categoria");
const tituloPrincipal = document.querySelector("#descripcion-principal");
let botonesAgregar = document.querySelectorAll(".producto-agregar");
const numerito  = document.querySelector("#numerito");

function getProducts() {
    var products = [];
            
    products = $.get('controller_producto?action=allProducts',data,function(response){
        
    });
}

function cargarProductos(productosElegidos) {

    contenedorProductos.innerHTML = "";

    productosElegidos.forEach(producto =>{

        const div = document.createElement("div");
        div.classList.add("producto");
        div.innerHTML = `
            <img class = "producto-imagen" src="${producto.imagen}" alt="${producto.descripcion}">
            <div class="producto-detalles">
                <h3 class="producto-descripcion">${producto.descripcion}</h3>
                <p class="producto-descripcion">${producto.descripcion}</p>
                <p class="producto-precio">$${producto.precio}</p>
                <button class="producto-agregar" id="${producto.id}" >Add to cart</button>
            </div>
        `;

        contenedorProductos.append(div);
    })

    actualizarBotonesAgregar(); 
}

getProducts();
cargarProductos(productos);

botonesCategorias.forEach(boton => {
    boton.addEventListener("click", (e) => {

        botonesCategorias.forEach(boton => boton.classList.remove("active"));
        e.currentTarget.classList.add("active");

        if(e.currentTarget.id != "todos"){
            const productoCategoria = productos.find(producto => producto.categoria.id === e.currentTarget.id);
            tituloPrincipal.innerText = productoCategoria.categoria.nombre;

            const productosBoton = productos.filter(producto => producto.categoria.id === e.currentTarget.id);
            cargarProductos(productosBoton);
        } else{
            tituloPrincipal.innerText = "All the products";
            cargarProductos(productos);
        }
    })
});

function actualizarBotonesAgregar(){
    botonesAgregar = document.querySelectorAll(".producto-agregar");

    botonesAgregar.forEach(boton => {
        boton.addEventListener("click", agregarAlCarrito)
    });
}

let productosEnCarrito;

let productosEnCarritoLS = localStorage.getItem("productos-en-carrito");


if(productosEnCarritoLS){
    productosEnCarrito = JSON.parse(productosEnCarritoLS);
    actualizarNumerito();
} else{
    productosEnCarrito =[]; 
}

function agregarAlCarrito(e){

    const idBoton = e.currentTarget.id;
    const productoAgregado = productos.find(producto => producto.id === idBoton);

   if(productosEnCarrito.some(producto => producto.id === idBoton)){
        const index = productosEnCarrito.findIndex(producto => producto.id === idBoton)
        productosEnCarrito[ index].cantidad++;
    
   } else{
        productoAgregado.cantidad = 1;
        productosEnCarrito.push(productoAgregado);
   }

   actualizarNumerito();
   console.log(productosEnCarrito);

   localStorage.setItem("productos-en-carrito", JSON.stringify(productosEnCarrito));

}

function actualizarNumerito(){
    let nuevoNumerito = productosEnCarrito.reduce((acc, producto) => acc + producto.cantidad, 0);
    numerito.innerText = nuevoNumerito;
}
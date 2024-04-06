document.addEventListener('DOMContentLoaded', function () {
    const pagoTarjeta = document.querySelector('#pago-tarjeta');
    const pagoEfectivo = document.querySelector('#pago-efectivo');
    const cardForm = document.querySelector('#card-form');
    const efectivoForm = document.querySelector('#efectivo-form');
    const agradecimiento = document.querySelector('#agradecimiento');
    const seleccionPago = document.querySelector('#seleccion-pago');
    const tituloPago = document.querySelector('h2');
    const botonPagoTarjeta = document.querySelector('#boton-pago-tarjeta');
    const botonPagoEfectivo = document.querySelector('#boton-pago-efectivo');

    pagoTarjeta.addEventListener('change', function () {
        cardForm.classList.remove('disabled');
        efectivoForm.classList.add('disabled');
        agradecimiento.classList.add('disabled');
    });

    pagoEfectivo.addEventListener('change', function () {
        cardForm.classList.add('disabled');
        efectivoForm.classList.remove('disabled');
        agradecimiento.classList.add('disabled');
    });

    botonPagoTarjeta.addEventListener('click', function () {
        ocultarElementos();
        mostrarAgradecimiento();
    });

    botonPagoEfectivo.addEventListener('click', function () {
        ocultarElementos();
        mostrarAgradecimiento();
    });

    function ocultarElementos() {
        seleccionPago.classList.add('disabled');
        tituloPago.classList.add('disabled');
    }

    function mostrarAgradecimiento() {
        cardForm.classList.add('disabled');
        efectivoForm.classList.add('disabled');
        agradecimiento.classList.remove('disabled');
    }
});

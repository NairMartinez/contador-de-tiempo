document.addEventListener('DOMContentLoaded', () => {

    // --- ¡IMPORTANTE! CAMBIA ESTA FECHA ---
    // Formato: 'Año-Mes-DíaTHora:Minutos:Segundos' (ej. '2023-10-26T18:00:00')
    const fechaInicio = new Date('2023-10-26T20:00:00');

    const contadorElemento = document.getElementById('contador');
    const arbolContainer = document.getElementById('arbol-container');

    // Función para crear las hojas de corazón
    function crearCorazones() {
        const numeroDeHojas = 80; // Cantidad de corazones que formarán el árbol
        
        for (let i = 0; i < numeroDeHojas; i++) {
            const hoja = document.createElement('div');
            hoja.className = 'hoja-corazon';
            
            // Calculamos una posición aleatoria dentro de una forma de corazón
            let t = Math.random() * 2 * Math.PI;
            let x = 16 * Math.pow(Math.sin(t), 3);
            let y = 13 * Math.cos(t) - 5 * Math.cos(2*t) - 2 * Math.cos(3*t) - Math.cos(4*t);

            // Ajustamos la posición y escala para que se vea bien
            hoja.style.left = `${150 + x * 7}px`;
            hoja.style.top = `${100 - y * 7}px`;
            
            // Damos colores y retrasos de animación variados para un efecto más bonito
            hoja.style.backgroundColor = Math.random() < 0.5 ? '#ff4d4d' : '#ff7b7b';
            hoja.style.animationDelay = `${2.5 + Math.random() * 2}s`; // Las hojas aparecen después del tronco

            arbolContainer.appendChild(hoja);
        }
    }


    // Función que actualiza el contador cada segundo
    function actualizarContador() {
        const ahora = new Date();
        const diferencia = ahora - fechaInicio;

        // Cálculos de tiempo
        const dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        const horas = Math.floor((diferencia % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        const minutos = Math.floor((diferencia % (1000 * 60 * 60)) / (1000 * 60));
        const segundos = Math.floor((diferencia % (1000 * 60)) / 1000);

        // Actualizamos el texto en la página
        contadorElemento.innerHTML = `
            ${dias} días, ${horas} horas,<br>${minutos} minutos y ${segundos} segundos
        `;
    }

    // Iniciar todo
    crearCorazones();
    actualizarContador(); // Llama una vez para que no haya un segundo de espera
    setInterval(actualizarContador, 1000); // Llama cada segundo para mantenerlo actualizado
});

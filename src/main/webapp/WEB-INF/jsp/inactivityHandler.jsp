<script>
  var inactivityTimeout;

  function resetInactivityTimer() {
    clearTimeout(inactivityTimeout);
    inactivityTimeout = setTimeout(function () {
      handleInactivity();
    }, 10000); //milisegundos
  }

  // Restablecer el temporizador cuando hay interacción en la página
  document.addEventListener("mousemove", resetInactivityTimer);
  document.addEventListener("keypress", resetInactivityTimer);
  document.addEventListener("click", resetInactivityTimer);

  // Inicia el temporizador al cargar la página
  resetInactivityTimer();
  
  function handleInactivity() {
       handleInactivityCloseSession();
       alert("Estas inactivo");
  }   


  function handleInactivityCloseSession() {
    // Hacer una solicitud Fetch al servidor de Spring Boot
    fetch('http://proyectopp-e23408b6aae3.herokuapp.com/springform/inactivity', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
        // Puedes agregar más encabezados según sea necesario
      },
      //body: JSON.stringify({}) // Puedes enviar datos en el cuerpo si es necesario
    })
      .then(response => {
        if (!response.ok) {
          throw new Error('Error al manejar la inactividad en el servidor');
        }
        console.log('Inactividad manejada en el servidor');
        // Puedes realizar más acciones después de manejar la inactividad en el servidor
      })
      .catch(error => {
        console.error('Error al manejar la inactividad en el servidor', error);
      });
  }
</script>
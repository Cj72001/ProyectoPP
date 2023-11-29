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
   //fetch('https://proyectopp-e23408b6aae3.herokuapp.com/springform/inactivity', {
    fetch('http://localhost:8080/springform/inactivity', {
      method: 'GET'
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Error al manejar la inactividad en el servidor');
      }
      // Redirigir en base a la respuesta del servidor
      window.location.href = response.url;
    })
    .catch(error => {
      console.error('Error al manejar la inactividad en el servidor', error);
    });
}

</script>
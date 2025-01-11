// Obtener los elementos del DOM
const modal = document.getElementById('editar-perfil-modal');
const btnEditar = document.querySelector('.editar-perfil');  // Botón de editar perfil
const btnCancelar = document.getElementById('cancelar-editar-perfil');  // Botón de cancelar

// Función para mostrar el modal
function mostrarModal() {
    modal.style.display = 'flex';
}

// Función para ocultar el modal
function ocultarModal() {
    modal.style.display = 'none';
}

// Mostrar el modal cuando se haga clic en "Editar Perfil"
btnEditar.addEventListener('click', function(e) {
    e.preventDefault();  // Prevenir la acción por defecto del enlace
    mostrarModal();
});

// Ocultar el modal cuando se haga clic en "Cancelar"
btnCancelar.addEventListener('click', ocultarModal);

// Opcional: Cerrar el modal si se hace clic fuera del contenido del modal
modal.addEventListener('click', function(e) {
    if (e.target === modal) {
        ocultarModal();
    }
});

// Formulario de "Editar Perfil"
const form = document.getElementById('form-editar-perfil');
form.addEventListener('submit', function(e) {
    e.preventDefault();  // Prevenir el envío del formulario

    // Aquí puedes agregar la lógica para manejar el formulario, por ejemplo:
    const nombre = document.getElementById('nombre').value;
    const apellido = document.getElementById('apellido').value;
    const sobreMi = document.getElementById('sobreMi').value;
    const fotoPerfil = document.getElementById('foto-perfil').files[0];

    // Simulamos un guardado de datos (por ejemplo, podrías enviarlos a un servidor)
    console.log('Datos guardados: ', { nombre, apellido, sobreMi, fotoPerfil });

    // Cerrar el modal después de guardar los cambios
    ocultarModal();
    
    // Limpiar el formulario
    form.reset();
});

// Si se hace clic fuera del formulario (pero dentro del modal), cerramos el modal
modal.addEventListener('click', function(e) {
    if (e.target === modal) {
        ocultarModal();
    }
});

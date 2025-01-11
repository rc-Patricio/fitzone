document.addEventListener('DOMContentLoaded', function () {
    const modal = document.getElementById('editar-perfil-modal');
    const btnEditar = document.querySelector('.editar-perfil');
    const btnCancelar = document.getElementById('cancelar-editar-perfil');
    const formEditarPerfil = document.getElementById('form-editar-perfil');

    if (modal && btnEditar) {
        function mostrarModal() {
            modal.style.display = 'flex';
        }

        function ocultarModal() {
            modal.style.display = 'none';
        }

        btnEditar.addEventListener('click', function (e) {
            e.preventDefault();
            mostrarModal();
        });

        if (btnCancelar) {
            btnCancelar.addEventListener('click', ocultarModal);
        }

        if (modal) {
            modal.addEventListener('click', function (e) {
                if (e.target === modal) {
                    ocultarModal();
                }
            });
        }
    }

    if (formEditarPerfil) {
        formEditarPerfil.addEventListener('submit', function (e) {
            e.preventDefault(); 
            const formData = new FormData(formEditarPerfil);
            fetch('/perfil/editar', {
                method: 'POST',
                body: formData,
                credentials: 'same-origin'
            })
            .then(response => {
                if (response.ok) {
                    alert('Perfil actualizado correctamente');
                    window.location.href = '/perfil'; 
                } else {
                    alert('Error al guardar el perfil');
                }
            })
            .catch(error => {
                console.error('Error al guardar el perfil:', error);
                alert('Hubo un error al guardar el perfil.');
            });
        });
    }
});

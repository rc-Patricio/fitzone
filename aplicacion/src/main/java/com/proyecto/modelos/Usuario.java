package com.proyecto.modelos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message= "Este campo es obligatorio.")
    @Size(min = 3, message = "Debe contener al menos 3 caracteres.")
    private String nombre;

    @NotBlank(message= "Este campo es obligatorio.")
    @Size(min = 3, message = "Debe contener al menos 3 caracteres.")
    private String apellido;

    @Column(unique = true)
    @NotBlank(message= "Este campo es obligatorio.")
    @Email(message= "Debe ser un correo electronico valido.")
    private String email;

    @NotBlank(message= "Este campo es obligatorio.")
    @Size(min = 8, message= "Debe contener al menos 8 caracteres.")
    private String clave;

    @NotBlank(message= "Este campo es obligatorio.")
    @Size(min = 3, message = "Debe contener al menos 3 caracteres.")

    private String genero;

    private String preferencia;

    private String imagen;

    @Transient
    private String confirmarClave;

    @OneToMany(mappedBy = "usuario")
    private List<Resena> resenas;

    private String sobreMi;



    public Usuario(Long id, String nombre, String apellido, String email, String clave, String confirmarClave, List<Resena> resenas, String genero, String sobremi, String preferencia, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.clave = clave;
        this.confirmarClave = confirmarClave;
        this.resenas = resenas;
        this.genero = genero;
        this.preferencia = preferencia;
        this.imagen = imagen;
    }

    public Usuario() {
        this.id = 0l;
        this.nombre = "";
        this.apellido = "";
        this.email = "";
        this.clave = "";
        this.confirmarClave = "";
        this.resenas = null;
        this.genero = "";
        this.preferencia = "";
        this.imagen = "";
    }



    public String getImagen() {
        return this.imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


    public String getPreferencia() {
        return this.preferencia;
    }

    public void setPreferencia(String preferencia) {
        this.preferencia = preferencia;
    }



    public String getSobreMi() {
        return this.sobreMi;
    }

    public void setSobreMi(String sobreMi) {
        this.sobreMi = sobreMi;
    }
    
    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getConfirmarClave() {
        return this.confirmarClave;
    }

    public void setConfirmarClave(String confirmarClave) {
        this.confirmarClave = confirmarClave;
    }


    public List<Resena> getResenas() {
        return this.resenas;
    }

    public void setResenas(List<Resena> resenas) {
        this.resenas = resenas;
    }


}

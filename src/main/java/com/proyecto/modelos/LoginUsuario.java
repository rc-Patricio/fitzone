package com.proyecto.modelos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginUsuario {

    @NotBlank(message= "Este campo es obligatorio.")
    @Email(message= "Debe ser un correo valido.")
    private String email;

    @NotBlank(message= "Este campo es obligatorio.")
    @Size(min = 8, message= "Debe contener al menos 8 caracteres.")
    private String clave;


    public LoginUsuario(String email, String clave) {
        this.email = email;
        this.clave = clave;
    }

    public LoginUsuario() {
        this.email = "";
        this.clave = "";
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


    @Override
    public String toString() {
        return "{" +
            " email='" + getEmail() + "'" +
            ", clave='" + getClave() + "'" +
            "}";
    }

}

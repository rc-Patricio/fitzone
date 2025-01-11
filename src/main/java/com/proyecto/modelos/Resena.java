
package com.proyecto.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;


@Entity
@Table(name = "resenas")
public class Resena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Min(value = 0, message =  "La puntuacion minima es de 0.")
    @Max(value = 5, message = "La puntuacion maxima es de 5.")
    private int puntuacion;

    
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "id_localizacion", nullable = false)
    private Localizacion localizaciones;


    public Resena(Long id, Usuario usuario, int puntuacion, String comentario, Localizacion localizaciones) {
        this.id = id;
        this.usuario = usuario;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.localizaciones = localizaciones;
    }

    public Resena() {
        this.id = 0l;
        this.usuario = null;
        this.puntuacion = 0;
        this.comentario = "";
        this.localizaciones = null;
    }


    public Localizacion getLocalizaciones() {
        return this.localizaciones;
    }

    public void setLocalizaciones(Localizacion localizaciones) {
        this.localizaciones = localizaciones;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getPuntuacion() {
        return this.puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", usuario='" + getUsuario() + "'" +
            ", puntuacion='" + getPuntuacion() + "'" +
            ", comentario='" + getComentario() + "'" +
            "}";
    }


}

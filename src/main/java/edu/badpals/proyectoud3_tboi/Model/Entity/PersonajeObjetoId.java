package edu.badpals.proyectoud3_tboi.Model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class PersonajeObjetoId implements java.io.Serializable {
    private static final long serialVersionUID = 5643506572348826519L;
    @Column(name = "id_personaje", nullable = false)
    private Integer idPersonaje;

    @Column(name = "id_objeto", nullable = false)
    private Integer idObjeto;

    public Integer getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(Integer idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public Integer getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(Integer idObjeto) {
        this.idObjeto = idObjeto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PersonajeObjetoId entity = (PersonajeObjetoId) o;
        return Objects.equals(this.idObjeto, entity.idObjeto) &&
                Objects.equals(this.idPersonaje, entity.idPersonaje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idObjeto, idPersonaje);
    }

}
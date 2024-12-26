package edu.badpals.proyectoud3_tboi.Model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class HabitacionEnemigoId implements java.io.Serializable {
    private static final long serialVersionUID = -8345522247308898316L;
    @Column(name = "id_habitacion", nullable = false)
    private Integer idHabitacion;

    @Column(name = "id_enemigo", nullable = false)
    private Integer idEnemigo;

    public Integer getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Integer getIdEnemigo() {
        return idEnemigo;
    }

    public void setIdEnemigo(Integer idEnemigo) {
        this.idEnemigo = idEnemigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        HabitacionEnemigoId entity = (HabitacionEnemigoId) o;
        return Objects.equals(this.idEnemigo, entity.idEnemigo) &&
                Objects.equals(this.idHabitacion, entity.idHabitacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEnemigo, idHabitacion);
    }

}
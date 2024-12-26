package edu.badpals.proyectoud3_tboi.Model.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "HabitacionEnemigos", schema = "TBOI_BBDD")
public class HabitacionEnemigo {
    @EmbeddedId
    private HabitacionEnemigoId id;

    @MapsId("idHabitacion")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_habitacion", nullable = false)
    private Habitacione idHabitacion;

    @MapsId("idEnemigo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_enemigo", nullable = false)
    private Enemigo idEnemigo;

    public HabitacionEnemigoId getId() {
        return id;
    }

    public void setId(HabitacionEnemigoId id) {
        this.id = id;
    }

    public Habitacione getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Habitacione idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Enemigo getIdEnemigo() {
        return idEnemigo;
    }

    public void setIdEnemigo(Enemigo idEnemigo) {
        this.idEnemigo = idEnemigo;
    }

}
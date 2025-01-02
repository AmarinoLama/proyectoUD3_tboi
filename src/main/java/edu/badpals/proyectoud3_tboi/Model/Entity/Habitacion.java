package edu.badpals.proyectoud3_tboi.Model.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Habitaciones", schema = "TBOI_BBDD")
public class Habitacion {
    @Id
    @Column(name = "id_habitacion", nullable = false)
    private Integer id;

    @Column(name = "tipo_habitacion", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoHabitacion tipoHabitacion;

    @Column(name = "dificultad", nullable = false)
    private Integer dificultad;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = TipoHabitacion.fromNombre(tipoHabitacion);
    }

    public Integer getDificultad() {
        return dificultad;
    }

    public void setDificultad(Integer dificultad) {
        this.dificultad = dificultad;
    }


}
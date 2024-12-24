package edu.badpals.proyectoud3_tboi.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Habitaciones", schema = "TBOI_BBDD")
public class Habitacione {
    @Id
    @Column(name = "id_habitacion", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "tipo_habitacion", nullable = false)
    private String tipoHabitacion;

    @Column(name = "dificultad", nullable = false)
    private Integer dificultad;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_piso", nullable = false)
    private edu.badpals.proyectoud3_tboi.Model.Piso idPiso;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public Integer getDificultad() {
        return dificultad;
    }

    public void setDificultad(Integer dificultad) {
        this.dificultad = dificultad;
    }

    public edu.badpals.proyectoud3_tboi.Model.Piso getIdPiso() {
        return idPiso;
    }

    public void setIdPiso(edu.badpals.proyectoud3_tboi.Model.Piso idPiso) {
        this.idPiso = idPiso;
    }

}
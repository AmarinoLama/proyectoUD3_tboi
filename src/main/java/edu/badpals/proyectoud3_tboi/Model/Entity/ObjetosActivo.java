package edu.badpals.proyectoud3_tboi.Model.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ObjetosActivos")
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("2")
public class ObjetosActivo extends Objeto {

    @Column(name = "tiempo_recarga")
    private Integer tiempoRecarga;

    public Integer getTiempoRecarga() {
        return tiempoRecarga;
    }

    public void setTiempoRecarga(Integer tiempoRecarga) {
        this.tiempoRecarga = tiempoRecarga;
    }

}
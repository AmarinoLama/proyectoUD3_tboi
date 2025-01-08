package edu.badpals.proyectoud3_tboi.Model.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Consumibles")
@PrimaryKeyJoinColumn(name = "id_objeto")
@DiscriminatorValue("3")
public class Consumible extends Objeto {

    @Column(name = "duracion_efecto")
    private Integer duracionEfecto;

    public Integer getDuracionEfecto() {
        return duracionEfecto;
    }

    public void setDuracionEfecto(Integer duracionEfecto) {
        this.duracionEfecto = duracionEfecto;
    }

}
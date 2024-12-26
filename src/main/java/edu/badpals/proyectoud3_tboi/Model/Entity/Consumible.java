package edu.badpals.proyectoud3_tboi.Model.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Consumibles")
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("1")
public class Consumible extends Objeto {

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_objeto", nullable = false)
    private Objeto objetos;

    @Column(name = "duracion_efecto")
    private Integer duracionEfecto;


    public Objeto getObjetos() {
        return objetos;
    }

    public void setObjetos(Objeto objetos) {
        this.objetos = objetos;
    }

    public Integer getDuracionEfecto() {
        return duracionEfecto;
    }

    public void setDuracionEfecto(Integer duracionEfecto) {
        this.duracionEfecto = duracionEfecto;
    }

}
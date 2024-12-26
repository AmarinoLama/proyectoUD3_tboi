package edu.badpals.proyectoud3_tboi.Model.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ObjetosPasivos")
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("3")
public class ObjetosPasivo extends Objeto {

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_objeto", nullable = false)
    private Objeto objetos;

    @Lob
    @Column(name = "mejora_estadistica")
    private String mejoraEstadistica;


    public Objeto getObjetos() {
        return objetos;
    }

    public void setObjetos(Objeto objetos) {
        this.objetos = objetos;
    }

    public String getMejoraEstadistica() {
        return mejoraEstadistica;
    }

    public void setMejoraEstadistica(String mejoraEstadistica) {
        this.mejoraEstadistica = mejoraEstadistica;
    }

}
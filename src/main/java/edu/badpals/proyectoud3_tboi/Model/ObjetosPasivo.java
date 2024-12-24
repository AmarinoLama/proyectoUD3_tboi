package edu.badpals.proyectoud3_tboi.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "ObjetosPasivos", schema = "TBOI_BBDD")
public class ObjetosPasivo {
    @Id
    @Column(name = "id_objeto", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_objeto", nullable = false)
    private Objeto objetos;

    @Lob
    @Column(name = "mejora_estadistica")
    private String mejoraEstadistica;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
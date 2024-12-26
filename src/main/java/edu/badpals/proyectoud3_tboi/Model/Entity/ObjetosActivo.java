package edu.badpals.proyectoud3_tboi.Model.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ObjetosActivos", schema = "TBOI_BBDD")
public class ObjetosActivo {
    @Id
    @Column(name = "id_objeto", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_objeto", nullable = false)
    private Objeto objetos;

    @Column(name = "tiempo_recarga")
    private Integer tiempoRecarga;

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

    public Integer getTiempoRecarga() {
        return tiempoRecarga;
    }

    public void setTiempoRecarga(Integer tiempoRecarga) {
        this.tiempoRecarga = tiempoRecarga;
    }

}
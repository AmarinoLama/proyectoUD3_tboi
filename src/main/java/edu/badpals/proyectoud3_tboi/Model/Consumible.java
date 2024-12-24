package edu.badpals.proyectoud3_tboi.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Consumibles", schema = "TBOI_BBDD")
public class Consumible {
    @Id
    @Column(name = "id_objeto", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_objeto", nullable = false)
    private edu.badpals.proyectoud3_tboi.Model.Objeto objetos;

    @Column(name = "duracion_efecto")
    private Integer duracionEfecto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public edu.badpals.proyectoud3_tboi.Model.Objeto getObjetos() {
        return objetos;
    }

    public void setObjetos(edu.badpals.proyectoud3_tboi.Model.Objeto objetos) {
        this.objetos = objetos;
    }

    public Integer getDuracionEfecto() {
        return duracionEfecto;
    }

    public void setDuracionEfecto(Integer duracionEfecto) {
        this.duracionEfecto = duracionEfecto;
    }

}
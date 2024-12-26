package edu.badpals.proyectoud3_tboi.Model.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Personajes", schema = "TBOI_BBDD")
public class Personaje {
    @Id
    @Column(name = "id_personaje", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "salud_base", nullable = false)
    private Integer saludBase;

    @Column(name = "dano_base", nullable = false)
    private Float danoBase;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getSaludBase() {
        return saludBase;
    }

    public void setSaludBase(Integer saludBase) {
        this.saludBase = saludBase;
    }

    public Float getDanoBase() {
        return danoBase;
    }

    public void setDanoBase(Float danoBase) {
        this.danoBase = danoBase;
    }

}
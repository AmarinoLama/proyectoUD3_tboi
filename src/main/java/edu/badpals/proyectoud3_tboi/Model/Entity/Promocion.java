package edu.badpals.proyectoud3_tboi.Model.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Promociones")
public class Promocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_promocion")
    private Integer id;

    @Column(name = "codigo_unipersonal", unique = true)
    private String codigoUnipersonal;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToOne(mappedBy = "promocion")
    private Personaje personaje;

    public Promocion() {

    }

    public Promocion(String codigoUnipersonal, String descripcion) {
        this.codigoUnipersonal = codigoUnipersonal;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public String getCodigoUnipersonal() {
        return codigoUnipersonal;
    }

    public void setCodigoUnipersonal(String codigoUnipersonal) {
        this.codigoUnipersonal = codigoUnipersonal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
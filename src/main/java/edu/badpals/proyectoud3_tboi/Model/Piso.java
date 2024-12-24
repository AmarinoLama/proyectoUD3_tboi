package edu.badpals.proyectoud3_tboi.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Pisos", schema = "TBOI_BBDD")
public class Piso {
    @Id
    @Column(name = "id_piso", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Lob
    @Column(name = "descripcion")
    private String descripcion;

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

}
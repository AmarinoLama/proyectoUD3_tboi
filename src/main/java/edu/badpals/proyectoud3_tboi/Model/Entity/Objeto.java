package edu.badpals.proyectoud3_tboi.Model.Entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_objeto", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")
@Table(name = "Objetos", schema = "TBOI_BBDD")
public class Objeto {
    @Id
    @Column(name = "id_objeto", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "efecto")
    private String efecto;

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

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

}
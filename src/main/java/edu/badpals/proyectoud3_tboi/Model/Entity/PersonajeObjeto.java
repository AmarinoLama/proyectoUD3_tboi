package edu.badpals.proyectoud3_tboi.Model.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PersonajeObjetos", schema = "TBOI_BBDD")
public class PersonajeObjeto {
    @EmbeddedId
    private PersonajeObjetoId id;

    @MapsId("idPersonaje")
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_personaje", nullable = false)
    private Personaje idPersonaje;

    @MapsId("idObjeto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_objeto", nullable = false)
    private Objeto idObjeto;

    public PersonajeObjetoId getId() {
        return id;
    }

    public void setId(PersonajeObjetoId id) {
        this.id = id;
    }

    public Personaje getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(Personaje idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public Objeto getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(Objeto idObjeto) {
        this.idObjeto = idObjeto;
    }

}
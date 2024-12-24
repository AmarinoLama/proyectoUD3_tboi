package edu.badpals.proyectoud3_tboi.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "PersonajeObjetos", schema = "TBOI_BBDD")
public class PersonajeObjeto {
    @EmbeddedId
    private PersonajeObjetoId id;

    @MapsId("idPersonaje")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_personaje", nullable = false)
    private edu.badpals.proyectoud3_tboi.Model.Personaje idPersonaje;

    @MapsId("idObjeto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_objeto", nullable = false)
    private Objeto idObjeto;

    public PersonajeObjetoId getId() {
        return id;
    }

    public void setId(PersonajeObjetoId id) {
        this.id = id;
    }

    public edu.badpals.proyectoud3_tboi.Model.Personaje getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(edu.badpals.proyectoud3_tboi.Model.Personaje idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public Objeto getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(Objeto idObjeto) {
        this.idObjeto = idObjeto;
    }

}
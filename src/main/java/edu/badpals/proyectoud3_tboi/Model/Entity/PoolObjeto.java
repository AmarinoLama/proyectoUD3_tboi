package edu.badpals.proyectoud3_tboi.Model.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PoolObjetos")
public class PoolObjeto {
    @EmbeddedId
    private PoolObjetoId id;

    @MapsId("idObjeto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_objeto", nullable = false)
    private Objeto idObjeto;

    @MapsId("idPool")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_pool", nullable = false)
    private Pool idPool;

    public PoolObjetoId getId() {
        return id;
    }

    public void setId(PoolObjetoId id) {
        this.id = id;
    }

    public Objeto getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(Objeto idObjeto) {
        this.idObjeto = idObjeto;
    }

    public Pool getIdPool() {
        return idPool;
    }

    public void setIdPool(Pool idPool) {
        this.idPool = idPool;
    }
}
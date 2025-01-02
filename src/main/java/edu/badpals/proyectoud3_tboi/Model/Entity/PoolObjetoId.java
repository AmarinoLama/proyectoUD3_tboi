package edu.badpals.proyectoud3_tboi.Model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class PoolObjetoId implements java.io.Serializable {
    private static final long serialVersionUID = -392908553518967768L;
    @Column(name = "id_pool", nullable = false)
    private Integer idPool;

    @Column(name = "id_objeto", nullable = false)
    private Integer idObjeto;

    public Integer getIdPool() {
        return idPool;
    }

    public void setIdPool(Integer idPool) {
        this.idPool = idPool;
    }

    public Integer getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(Integer idObjeto) {
        this.idObjeto = idObjeto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PoolObjetoId entity = (PoolObjetoId) o;
        return Objects.equals(this.idPool, entity.idPool) &&
                Objects.equals(this.idObjeto, entity.idObjeto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPool, idObjeto);
    }

}
package edu.badpals.proyectoud3_tboi.Model.Dao;

import edu.badpals.proyectoud3_tboi.Model.Entity.Objeto;
import edu.badpals.proyectoud3_tboi.Model.Entity.TipoHabitacion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class HabitacionDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    private void initHibernate() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }

    public HabitacionDAO() {
        initHibernate();
    }

    // Método para filtrar los objetos de un pool por el nombre de la habitación

    public List<Objeto> filtrarPool(String nombreHabitacion) {
        Query query = em.createQuery(
                "SELECT o FROM Objeto o " +
                        "JOIN PoolObjeto po ON po.idObjeto = o " +
                        "JOIN Pool p ON po.idPool = p " +
                        "JOIN Habitacion h ON p.idHabitacion = h " +
                        "WHERE h.tipoHabitacion = :nombreHabitacion"
        );
        query.setParameter("nombreHabitacion", TipoHabitacion.fromNombre(nombreHabitacion));
        return query.getResultList();
    }
}
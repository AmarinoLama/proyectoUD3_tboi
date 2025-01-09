package edu.badpals.proyectoud3_tboi.Model.Dao;

import edu.badpals.proyectoud3_tboi.Model.Entity.Objeto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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

    public List<Objeto> filtrarPorPool(){
        return null;
    }
}



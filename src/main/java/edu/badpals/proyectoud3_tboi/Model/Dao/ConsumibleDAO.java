package edu.badpals.proyectoud3_tboi.Model.Dao;

import edu.badpals.proyectoud3_tboi.Model.Entity.Consumible;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConsumibleDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    private void initHibernate(){
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }
    public ConsumibleDAO(){
        initHibernate();
    }

        public void crearConsumible(String nombre, String efecto, Integer duracionEfecto){
        try{
            em.getTransaction().begin();
            Consumible consumible = new Consumible();
            consumible.setNombre(nombre);
            consumible.setEfecto(efecto);
            consumible.setDuracionEfecto(duracionEfecto);
            em.persist(consumible);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}



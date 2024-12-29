package edu.badpals.proyectoud3_tboi.Model.Dao;

import edu.badpals.proyectoud3_tboi.Model.Entity.ObjetosActivo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ObjetoActivoDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    private void initHibernate(){
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }
    public ObjetoActivoDAO(){
        initHibernate();
    }

    public void crearObjetoActivo(String nombre, String efecto, Integer tiempoRecarga){
        try{
            em.getTransaction().begin();
            ObjetosActivo objetoActivo = new ObjetosActivo();
            objetoActivo.setNombre(nombre);
            objetoActivo.setEfecto(efecto);
            objetoActivo.setTiempoRecarga(tiempoRecarga);
            em.persist(objetoActivo);
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

package edu.badpals.proyectoud3_tboi.Model.Dao;

import edu.badpals.proyectoud3_tboi.Model.Entity.Consumible;
import edu.badpals.proyectoud3_tboi.Model.Entity.ObjetosActivo;
import edu.badpals.proyectoud3_tboi.Model.Entity.ObjetosPasivo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

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

    public List<ObjetosActivo> getObjetosActivos() {
        List<ObjetosActivo> objetosActivos = null;
        try {
            objetosActivos = em.createQuery("SELECT o FROM ObjetosActivo o", ObjetosActivo.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
        return objetosActivos;
    }


    public ObjetosActivo ultimoObjetoActivo(){
        ObjetosActivo objetoActivo;
        try {
            objetoActivo = em.createQuery("SELECT oa from ObjetosActivo oa inner join Objeto o on oa.id = o.id inner join" +
                            " PersonajeObjeto po on o.id = po.idObjeto.id order by oa.id desc", ObjetosActivo.class).setMaxResults(1).getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
            emf.close();
        }
        return objetoActivo;
    }
}

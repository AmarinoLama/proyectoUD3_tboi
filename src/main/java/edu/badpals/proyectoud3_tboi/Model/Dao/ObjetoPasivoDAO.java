package edu.badpals.proyectoud3_tboi.Model.Dao;

import edu.badpals.proyectoud3_tboi.Model.Entity.ObjetosPasivo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class ObjetoPasivoDAO{
    private EntityManagerFactory emf;
    private EntityManager em;

    private void initHibernate(){
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }
    public ObjetoPasivoDAO(){
        initHibernate();
    }

    public void crearObjetoPasivo(String nombre, String efecto, float mejoradano,
                                  float mejoravelocidad, float mejoralagrimas, int mejoravida,
                                  int mejorasuerte, float mejoravelocidadproyectil, float mejorarango){
        try{
            em.getTransaction().begin();
            ObjetosPasivo objetosPasivo = new ObjetosPasivo();
            objetosPasivo.setNombre(nombre);
            objetosPasivo.setEfecto(efecto);
            objetosPasivo.setMejoraDano(mejoradano);
            objetosPasivo.setMejoraVelocidad(mejoravelocidad);
            objetosPasivo.setMejoraLagrimas(mejoralagrimas);
            objetosPasivo.setMejoraSalud(mejoravida);
            objetosPasivo.setMejoraSuerte(mejorasuerte);
            objetosPasivo.setMejoraVelocidadProyectil(mejoravelocidadproyectil);
            objetosPasivo.setMejoraRango(mejorarango);
            em.persist(objetosPasivo);
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

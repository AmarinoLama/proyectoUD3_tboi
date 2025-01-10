package edu.badpals.proyectoud3_tboi.Model.Dao;

import edu.badpals.proyectoud3_tboi.Model.Entity.ObjetosPasivo;
import edu.badpals.proyectoud3_tboi.View.Alertas;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class ObjetoPasivoDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    private void initHibernate() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }

    public ObjetoPasivoDAO() {
        initHibernate();
    }

    /*
    FUNCIÓN NO UTILIZADA que servía para crear objetos pasivos

    public void crearObjetoPasivo(String nombre, String efecto, float mejoradano,
                                  float mejoravelocidad, float mejoralagrimas, int mejoravida,
                                  int mejorasuerte, float mejoravelocidadproyectil, float mejorarango) {
        try {
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
        } catch (Exception e) {
            em.getTransaction().rollback();
            Alertas.showError("Error en ObjetoPasivoDAO", "Ha dado erro el método crearObjetoPasivo");
        } finally {
            em.close();
            emf.close();
        }
    }*/

    public List<ObjetosPasivo> getObjetosPasivos() {
        List<ObjetosPasivo> objetosPasivos = null;
        try {
            objetosPasivos = em.createQuery("SELECT o FROM ObjetosPasivo o", ObjetosPasivo.class).getResultList();
        } catch (Exception e) {
            Alertas.showError("Error en ObjetoPasivoDAO", "Ha dado erro el método getObjetosPasivos");
        } finally {
            em.close();
            emf.close();
        }
        return objetosPasivos;
    }
}
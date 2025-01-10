package edu.badpals.proyectoud3_tboi.Model.Dao;

import edu.badpals.proyectoud3_tboi.Model.Entity.Objeto;
import edu.badpals.proyectoud3_tboi.View.Alertas;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class ObjetoDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    private void initHibernate() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }

    public ObjetoDAO() {
        initHibernate();
    }

    public List<Objeto> getObjetos() {
        List<Objeto> objetos = null;
        try {
            objetos = em.createQuery("SELECT o FROM Objeto o", Objeto.class).getResultList();
        } catch (Exception e) {
            Alertas.showError("Error en ObjetoDAO", "Ha dado error el método getObjetos");
        } finally {
            em.close();
            emf.close();
        }
        return objetos;
    }

    /*
    FUNCIÓN NO UTILIZADA que servía para obtener los objetos con su pool asociada

    public List<Object[]> getObjetosConPool() {
        List<Object[]> resultados = null;
        try {
            resultados = em.createQuery(
                            "SELECT o, p FROM Objeto o " +
                                    "JOIN PoolObjeto po ON o.id = po.idObjeto.id " +
                                    "JOIN Pool p ON po.idPool.id = p.id", Object[].class)
                    .getResultList();
        } catch (Exception e) {
            Alertas.showError("Error en ObjetoDAO", "Ha dado error la función getObjetosConPool");
        } finally {
            em.close();
            emf.close();
        }
        return resultados;
    }
    */
}
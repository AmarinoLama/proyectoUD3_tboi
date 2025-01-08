package edu.badpals.proyectoud3_tboi.Model.Dao;

import edu.badpals.proyectoud3_tboi.Model.Entity.Objeto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ObjetoDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    private void initHibernate(){
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }
    public ObjetoDAO(){
        initHibernate();
    }

    public List<Objeto> getObjetos() {
        List<Objeto> objetos = null;
        try {
            objetos = em.createQuery("SELECT o FROM Objeto o", Objeto.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
        return objetos;
    }

    public List<Object[]> getObjetosConPool() {
        List<Object[]> resultados = null;
        try {
            // Realizamos la consulta con JOIN entre Objeto, PoolObjetos y Pool
            resultados = em.createQuery(
                            "SELECT o, p FROM Objeto o " +
                                    "JOIN PoolObjeto po ON o.id = po.idObjeto.id " +
                                    "JOIN Pool p ON po.idPool.id = p.id", Object[].class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
        return resultados;
    }
}

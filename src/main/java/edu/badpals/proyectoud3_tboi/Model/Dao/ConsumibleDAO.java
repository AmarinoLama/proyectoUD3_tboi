package edu.badpals.proyectoud3_tboi.Model.Dao;

import edu.badpals.proyectoud3_tboi.Model.Entity.Consumible;
import edu.badpals.proyectoud3_tboi.View.Alertas;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ConsumibleDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    private void initHibernate() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }

    public ConsumibleDAO() {
        initHibernate();
    }

    public void crearConsumible(String nombre, String efecto, Integer duracionEfecto) {
        try {
            em.getTransaction().begin();
            Consumible consumible = new Consumible();
            consumible.setNombre(nombre);
            consumible.setEfecto(efecto);
            consumible.setDuracionEfecto(duracionEfecto);
            em.persist(consumible);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            Alertas.showError("Error en ConsumibleDAO", "Ha dado error el método crearConsumible");
        }
    }

    public void modificarConsumible(String nombreConsumible, String efecto, Integer duracionEfecto) {
        try {
            em.getTransaction().begin();
            Consumible consumible = em.find(Consumible.class, getConsumibleByName(nombreConsumible).getId());
            consumible.setEfecto(efecto);
            consumible.setDuracionEfecto(duracionEfecto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            //Alertas.showError("Error en ConsumibleDAO", "Ha dado error el método modificarConsumible");
        }
    }

    public void eliminarConsumible(String nombreConsumible) {
        try {
            em.getTransaction().begin();
            Consumible consumible = em.find(Consumible.class, getConsumibleByName(nombreConsumible).getId());
            if (consumible == null) {
                Alertas.showWarning("Error en ConsumibleDAO", "No se ha encontrado el consumible");
            } else if (personajeTieneConsumible(nombreConsumible)) {
                Alertas.showWarning("Error en ConsumibleDAO", "No se puede eliminar un consumible que tiene un personaje");
            } else {
                em.remove(consumible);
                em.getTransaction().commit();
            }

        } catch (Exception e) {
            em.getTransaction().rollback();
            Alertas.showError("Error en ConsumibleDAO", "Ha dado error el metodo eliminarConsumible");
        }
    }

    public void eliminarConsumibleDePools(String nombreConsumible) {
        try {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM PoolObjeto po WHERE po.idObjeto.nombre = :nombre")
                    .setParameter("nombre", nombreConsumible).executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }


    public boolean personajeTieneConsumible(String nombreConsumible) {
        try {
            em.createQuery("SELECT c FROM Consumible c join PersonajeObjeto po on c.id = po.id.idObjeto " +
                            "WHERE c.nombre = :nombre", Consumible.class)
                    .setParameter("nombre", nombreConsumible).getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean consumibleExiste(String nombreConsumible) {
        try {
            em.createQuery("SELECT c FROM Consumible c WHERE c.nombre = :nombre", Consumible.class)
                    .setParameter("nombre", nombreConsumible).getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Consumible> getConsumibles() {
        List<Consumible> consumibles = null;
        try {
            consumibles = em.createQuery("SELECT c FROM Consumible c", Consumible.class).getResultList();
        } catch (Exception e) {
            Alertas.showError("Error en ConsumibleDAO", "Ha dado error el método getConsumibles");
        } finally {
            em.close();
            emf.close();
        }
        return consumibles;
    }

    public Consumible getConsumibleByName(String nombreConsumible) {
        Consumible consumible = null;
        try {
            consumible = em.createQuery("SELECT c FROM Consumible c WHERE c.nombre = :nombre", Consumible.class)
                    .setParameter("nombre", nombreConsumible).getSingleResult();
        } catch (Exception e) {
            return consumible;
        }
        return consumible;
    }

    public Consumible ultimoConsumible() {
        Consumible consumible = null;
        try {
            consumible = em.createQuery("SELECT c from Consumible c join Objeto o on c.id = o.id join" +
                    " PersonajeObjeto po on o.id = po.idObjeto.id order by po.fechaInsercion desc", Consumible.class).setMaxResults(1).getSingleResult();
        } catch (Exception e) {
            return consumible;
        } finally {
            em.close();
            emf.close();
        }
        return consumible;
    }
}
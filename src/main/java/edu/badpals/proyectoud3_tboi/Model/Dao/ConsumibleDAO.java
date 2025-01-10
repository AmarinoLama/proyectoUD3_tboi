package edu.badpals.proyectoud3_tboi.Model.Dao;

import edu.badpals.proyectoud3_tboi.Model.Entity.Consumible;
import edu.badpals.proyectoud3_tboi.Model.Entity.ObjetosActivo;
import edu.badpals.proyectoud3_tboi.View.EmergentWindows;
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
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void modificarConsumible(String nombreConsumible, String efecto, Integer duracionEfecto) {
        try {
            em.getTransaction().begin();
            Consumible consumible = em.find(Consumible.class, nombreConsumible);
            consumible.setEfecto(efecto);
            consumible.setDuracionEfecto(duracionEfecto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void eliminarConsumible(String nombreConsumible) {
        try {
            em.getTransaction().begin();
            Consumible consumible = em.find(Consumible.class, nombreConsumible);
            if (consumible == null) {
                EmergentWindows.showError("Error en ConsumibleDAO", "No se ha encontrado el consumible");
                return;
            } else if (personajeTieneConsumible(nombreConsumible) ){
                EmergentWindows.showError("Error en ConsumibleDAO", "No se puede eliminar un consumible que tiene un personaje");
                return;

            }
            em.remove(consumible);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    private boolean personajeTieneConsumible(String nombreConsumible){
        Consumible consumibleUsado = em.createQuery("SELECT c FROM Consumible c join PersonajeObjeto po on c.id = po.id.idObjeto " +
                        "WHERE c.nombre = :nombre and c.id in po.idObjeto.id", Consumible.class)
                .setParameter("nombre", nombreConsumible).getSingleResult();
        return consumibleUsado != null;
    }

    public List<Consumible> getConsumibles() {
        List<Consumible> consumibles = null;
        try {
            consumibles = em.createQuery("SELECT c FROM Consumible c", Consumible.class).getResultList();
        } catch (Exception e) {
            EmergentWindows.showError("Error en ConsumibleDAO", "Ha dado error el método getConsumibles");
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
            EmergentWindows.showError("Error en ConsumibleDAO", "Ha dado error el método getConsumible");
        } finally {
            em.close();
            emf.close();
        }
        return consumible;
    }

    public Consumible ultimoConsumible(){
        Consumible consumible = null;
        try {
            consumible = em.createQuery("SELECT c from Consumible c join Objeto o on c.id = o.id join" +
                    " PersonajeObjeto po on o.id = po.idObjeto.id order by po.fechaInsercion desc", Consumible.class).setMaxResults(1).getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
            emf.close();
        }
        return consumible;
    }
}
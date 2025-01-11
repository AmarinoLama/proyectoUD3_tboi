package edu.badpals.proyectoud3_tboi.Model.Dao;

import edu.badpals.proyectoud3_tboi.Model.Entity.Consumible;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsumibleDAOTest {

    private ConsumibleDAO consumibleDAO;
    private EntityManagerFactory emf;
    private EntityManager em;

    @BeforeEach
    public void setUp() {
        consumibleDAO = new ConsumibleDAO();
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    @AfterEach
    public void tearDown() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        em.close();
        emf.close();
    }

    // EL test va pero el rollback no

    @Test
    public void crearConsumibleTest() {
        consumibleDAO.crearConsumible("nombre", "efecto", 1);
        Consumible consumible = em.createQuery("SELECT c FROM Consumible c WHERE c.nombre = 'nombre' AND c.efecto = 'efecto' AND c.duracionEfecto = 1", Consumible.class).getSingleResult();
        assertEquals("nombre", consumible.getNombre());
        assertEquals("efecto", consumible.getEfecto());
        assertEquals(1, consumible.getDuracionEfecto());
    }

    // EL test va pero el rollback no

    @Test
    public void modificarConsumibleTest() {
        consumibleDAO.crearConsumible("nombre", "efecto", 1);
        consumibleDAO.modificarConsumible("nombre", "a", 11);
        Consumible consumible = em.createQuery("SELECT c FROM Consumible c WHERE c.nombre = 'nombre'", Consumible.class).getSingleResult();
        assertEquals("nombre", consumible.getNombre());
        assertEquals("a", consumible.getEfecto());
        assertEquals(11, consumible.getDuracionEfecto());
    }

    // Primera línea comentada para usar este test como rollback

    @Test
    public void eliminarConsumibleTest() {
        //consumibleDAO.crearConsumible("nombre", "efecto", 1);
        consumibleDAO.eliminarConsumible("nombre");
        assertThrows(Exception.class, () -> em.createQuery("SELECT c FROM Consumible c WHERE c.nombre = 'nombre'", Consumible.class).getSingleResult());
    }

    @Test
    public void personajeTieneConsumibleTest() {
    }

    @Test
    public void getConsumiblesTest() {
    }

    @Test
    public void getConsumibleByNameTest() {
    }

    @Test
    public void ultimoConsumibleTest() {
    }
}
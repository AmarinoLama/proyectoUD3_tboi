package edu.badpals.proyectoud3_tboi.Model.Dao;

import edu.badpals.proyectoud3_tboi.Model.Entity.Consumible;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
class ConsumibleDAOTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static ConsumibleDAO consumibleDAO;
    private static List<String> createdConsumibles;

    @BeforeAll
    static void setUp() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        consumibleDAO = new ConsumibleDAO();
        createdConsumibles = new ArrayList<>();
    }

    @AfterAll
    static void tearDown() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        em.getTransaction().begin();
        for (String nombre : createdConsumibles) {
            em.createQuery("DELETE FROM Consumible c WHERE c.nombre = :nombre")
                    .setParameter("nombre", nombre)
                    .executeUpdate();
        }
        em.getTransaction().commit();
        if (em.isOpen()) em.close();
        if (emf.isOpen()) emf.close();
    }

    @Test
    @Order(1)
    void testCrearConsumible() {
        consumibleDAO.crearConsumible("Test Consumible", "Test Efecto", 5);
        createdConsumibles.add("Test Consumible");
        Consumible consumible = consumibleDAO.getConsumibleByName("Test Consumible");
        assertNotNull(consumible, "El consumible debería haberse creado");
        assertEquals("Test Consumible", consumible.getNombre());
        assertEquals("Test Efecto", consumible.getEfecto());
        assertEquals(5, consumible.getDuracionEfecto());
    }

    @Test
    @Order(2)
    void testModificarConsumible() {
        consumibleDAO.modificarConsumible("Test Consumible", "Efecto Modificado", 10);
        Consumible consumible = consumibleDAO.getConsumibleByName("Test Consumible");
        assertNotNull(consumible, "El consumible debería existir");
        assertEquals("Efecto Modificado", consumible.getEfecto());
        assertEquals(10, consumible.getDuracionEfecto());
    }

    @Test
    @Order(3)
    void testConsumibleExiste() {
        boolean existe = consumibleDAO.consumibleExiste("Test Consumible");
        assertTrue(existe, "El consumible debería existir en la base de datos");
    }

    @Test
    @Order(4)
    void testEliminarConsumibleDePools() {
        consumibleDAO.eliminarConsumibleDePools("Test Consumible");
        // No hay un método directo para verificar los pools, pero asegúrate de que no haya excepciones
        assertDoesNotThrow(() -> consumibleDAO.eliminarConsumibleDePools("Test Consumible"));
    }

    @Test
    @Order(5)
    void testPersonajeTieneConsumible() {
        boolean tieneConsumible = consumibleDAO.personajeTieneConsumible("Test Consumible");
        assertFalse(tieneConsumible, "Ningún personaje debería tener este consumible");
    }

    @Test
    @Order(6)
    void testEliminarConsumible() {
        consumibleDAO.eliminarConsumible("Test Consumible");
        boolean existe = consumibleDAO.consumibleExiste("Test Consumible");
        assertFalse(existe, "El consumible debería haberse eliminado");
    }

    @Test
    @Order(7)
    void testGetConsumibles() {
        consumibleDAO.crearConsumible("Consumible 1", "Efecto 1", 5);
        createdConsumibles.add("Consumible 1");
        consumibleDAO.crearConsumible("Consumible 2", "Efecto 2", 10);
        createdConsumibles.add("Consumible 2");

        List<Consumible> consumibles = consumibleDAO.getConsumibles();
        assertNotNull(consumibles, "La lista de consumibles no debería ser nula");
        assertTrue(consumibles.size() >= 2, "Debería haber al menos 2 consumibles en la lista");
    }

}

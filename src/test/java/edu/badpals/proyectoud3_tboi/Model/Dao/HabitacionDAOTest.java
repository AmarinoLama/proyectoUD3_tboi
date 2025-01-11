package edu.badpals.proyectoud3_tboi.Model.Dao;

import edu.badpals.proyectoud3_tboi.Model.Entity.Objeto;
import edu.badpals.proyectoud3_tboi.Model.Entity.TipoHabitacion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
class HabitacionDAOTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static HabitacionDAO habitacionDAO;

    @BeforeAll
    static void setUp() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        habitacionDAO = new HabitacionDAO();
    }

    @AfterAll
    static void tearDown() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        if (em.isOpen()) em.close();
        if (emf.isOpen()) emf.close();
    }

    @Test
    @Order(1)
    void testFiltrarPoolHabitacionNormal() {
        List<Objeto> objetos = habitacionDAO.filtrarPool("Normal");
        assertNotNull(objetos, "La lista de objetos no debería ser nula");
        assertTrue(objetos.size() >= 2, "Debería haber al menos 2 objetos en la lista para la habitación Normal");
    }

    @Test
    @Order(2)
    void testFiltrarPoolHabitacionTesoro() {
        List<Objeto> objetos = habitacionDAO.filtrarPool("Tesoro");
        assertNotNull(objetos, "La lista de objetos no debería ser nula");
        assertTrue(objetos.size() >= 2, "Debería haber al menos 2 objetos en la lista para la habitación Tesoro");
    }

    @Test
    @Order(3)
    void testFiltrarPoolHabitacionJefe() {
        List<Objeto> objetos = habitacionDAO.filtrarPool("Jefe");
        assertNotNull(objetos, "La lista de objetos no debería ser nula");
        assertTrue(objetos.size() >= 2, "Debería haber al menos 2 objetos en la lista para la habitación Jefe");
    }
}
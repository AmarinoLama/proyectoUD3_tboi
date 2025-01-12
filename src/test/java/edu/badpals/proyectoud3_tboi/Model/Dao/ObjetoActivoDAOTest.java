package edu.badpals.proyectoud3_tboi.Model.Dao;

import edu.badpals.proyectoud3_tboi.Model.Entity.ObjetosActivo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ObjetoActivoDAOTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static ObjetoActivoDAO objetoActivoDAO;

    @BeforeAll
    static void setUp() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        objetoActivoDAO = new ObjetoActivoDAO();
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
    void testGetObjetosActivos() {
        List<ObjetosActivo> objetosActivos = objetoActivoDAO.getObjetosActivos();
        assertNotNull(objetosActivos, "La lista de objetos activos no debería ser nula");
        assertTrue(objetosActivos.size() >= 1, "Debería haber al menos 1 objeto activo en la lista");

        ObjetosActivo objeto1 = objetosActivos.stream()
                .filter(o -> "The D6".equals(o.getNombre()))
                .findFirst()
                .orElse(null);
        ObjetosActivo objeto2 = objetosActivos.stream()
                .filter(o -> "Yum Heart".equals(o.getNombre()))
                .findFirst()
                .orElse(null);

        assertNotNull(objeto1, "The D6 debería existir en la base de datos");
        assertNotNull(objeto2, "Yum Heart debería existir en la base de datos");
    }
}


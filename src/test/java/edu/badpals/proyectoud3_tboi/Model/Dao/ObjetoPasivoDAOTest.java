package edu.badpals.proyectoud3_tboi.Model.Dao;

import edu.badpals.proyectoud3_tboi.Model.Entity.ObjetosPasivo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ObjetoPasivoDAOTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static ObjetoPasivoDAO objetoPasivoDAO;

    @BeforeAll
    static void setUp() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        objetoPasivoDAO = new ObjetoPasivoDAO();
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
    void testGetObjetosPasivos() {
        List<ObjetosPasivo> objetosPasivos = objetoPasivoDAO.getObjetosPasivos();
        assertNotNull(objetosPasivos, "La lista de objetos pasivos no debería ser nula");
        assertTrue(objetosPasivos.size() >= 1, "Debería haber al menos 1 objetos pasivos en la lista");

        ObjetosPasivo objeto1 = objetosPasivos.stream()
                .filter(o -> "Brimstone".equals(o.getNombre()))
                .findFirst()
                .orElse(null);
        ObjetosPasivo objeto2 = objetosPasivos.stream()
                .filter(o -> "Holy Mantle".equals(o.getNombre()))
                .findFirst()
                .orElse(null);

        assertNotNull(objeto1, "Brimstone debería existir en la base de datos");
        assertNotNull(objeto2, "Holy Mantle debería existir en la base de datos");
    }
}
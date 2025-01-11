package edu.badpals.proyectoud3_tboi.Model.Dao;

import edu.badpals.proyectoud3_tboi.Model.Entity.Objeto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ObjetoDAOTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static ObjetoDAO objetoDAO;

    @BeforeAll
    static void setUp() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        objetoDAO = new ObjetoDAO();
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
    void testGetObjetos() {
        List<Objeto> objetos = objetoDAO.getObjetos();
        assertNotNull(objetos, "La lista de objetos no debería ser nula");
        assertTrue(objetos.size() >= 1, "Debería haber al menos 1 objeto en la lista");

        Objeto objeto1 = objetos.stream()
                .filter(o -> "Sacred Heart".equals(o.getNombre()))
                .findFirst()
                .orElse(null);
        Objeto objeto2 = objetos.stream()
                .filter(o -> "Pretty Fly".equals(o.getNombre()))
                .findFirst()
                .orElse(null);
        Objeto objeto3 = objetos.stream()
                .filter(o -> "Razor Blade".equals(o.getNombre()))
                .findFirst()
                .orElse(null);

        assertNotNull(objeto1, "Sacred Heart debería existir en la base de datos");
        assertNotNull(objeto2, "Pretty Fly debería existir en la base de datos");
        assertNotNull(objeto3, "Razor Blade debería existir en la base de datos");
    }
}

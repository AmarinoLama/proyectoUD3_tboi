package edu.badpals.proyectoud3_tboi.Model.Dao;

import edu.badpals.proyectoud3_tboi.Model.Entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
class PersonajeDAOTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static PersonajeDAO personajeDAO;

    @BeforeAll
    static void setUp() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        personajeDAO = new PersonajeDAO();
    }

    @AfterAll
    static void tearDown() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        em.getTransaction().begin();
        em.createQuery("DELETE FROM PersonajeObjeto").executeUpdate();
        em.createQuery("DELETE FROM Personaje").executeUpdate();
        em.getTransaction().commit();
        if (em.isOpen()) em.close();
        if (emf.isOpen()) emf.close();
    }

    @Test
    @Order(1)
    void testCrearPersonaje() {
        Personaje personaje = personajeDAO.crearPersonaje("Isaac");
        assertNotNull(personaje, "El personaje debería haberse creado");
        assertEquals("Isaac", personaje.getNombre());
        assertEquals(3, personaje.getSaludBase());
        assertEquals(3.5f, personaje.getDanoBase());
    }

    @Test
    @Order(2)
    void testEliminarPersonaje() {
        personajeDAO.crearPersonaje("Magdalena");
        personajeDAO.eliminarPersonaje(2); // Se elimina a Magdalena
        Query query = em.createQuery("SELECT p FROM Personaje p WHERE p.id = :id");
        query.setParameter("id", 2);
        List<Personaje> resultado = query.getResultList();
        assertTrue(resultado.isEmpty(), "El personaje debería haberse eliminado");
    }

    @Test
    @Order(3)
    void testAddObjetoPasivoToPersonaje() {
        personajeDAO.crearPersonaje("Cain");
        ObjetosPasivo objetoPasivo = em.find(ObjetosPasivo.class, 1); // Se le da a Cain el Brimstone

        assertNotNull(objetoPasivo, "El objeto pasivo debería existir en la base de datos");

        personajeDAO.addObjetoPasivoToPersonaje(3, 1); // Cain
        List<Objeto> objetos = personajeDAO.showObjetosPersonaje(3);
        assertEquals(1, objetos.size(), "El personaje debería tener 1 objeto pasivo");
        assertEquals("Brimstone", objetos.get(0).getNombre());
    }

    @Test
    @Order(4)
    void testAddObjetoActivoToPersonaje() {
        personajeDAO.crearPersonaje("Judas");
        ObjetosActivo objetoActivo = em.find(ObjetosActivo.class, 2); // Se le da a Judas el The Book of Belial

        assertNotNull(objetoActivo, "El objeto activo debería existir en la base de datos");

        personajeDAO.addObjetoActivoToPersonaje(4, 2); // Judas
        List<Objeto> objetos = personajeDAO.showObjetosPersonaje(4);
        assertEquals(1, objetos.size(), "El personaje debería tener 1 objeto activo");
        assertEquals("The Book of Belial", objetos.get(0).getNombre());
    }

    @Test
    @Order(5)
    void testAddConsumibleToPersonaje() {
        personajeDAO.crearPersonaje("Eva");
        Consumible consumible = em.find(Consumible.class, 3); // Añadir The Fool Card a Eva

        assertNotNull(consumible, "El consumible debería existir en la base de datos");

        personajeDAO.addConsumibleToPersonaje(6, 3); // Eva
        List<Objeto> objetos = personajeDAO.showObjetosPersonaje(6);
        assertEquals(1, objetos.size(), "El personaje debería tener 1 consumible");
        assertEquals("The Fool Card", objetos.get(0).getNombre());
    }

    @Test
    @Order(6)
    void testShowObjetosPersonaje() {
        List<Objeto> objetos = personajeDAO.showObjetosPersonaje(3); // Cain
        assertNotNull(objetos, "La lista de objetos no debería ser nula");
        assertFalse(objetos.isEmpty(), "La lista de objetos no debería estar vacía");
    }

    @Test
    @Order(7)
    void testEliminarItemDePersonaje() {
        personajeDAO.eliminarItemDePersonaje(3, 1); // Cain eliminando el objeto
        List<Objeto> objetos = personajeDAO.showObjetosPersonaje(3);
        assertTrue(objetos.isEmpty(), "El objeto debería haberse eliminado del personaje");
    }
}

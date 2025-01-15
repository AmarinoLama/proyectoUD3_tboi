package edu.badpals.proyectoud3_tboi.Model.Dao;

import edu.badpals.proyectoud3_tboi.Model.Entity.*;
import edu.badpals.proyectoud3_tboi.View.Alertas;
import jakarta.persistence.*;
import java.util.List;

public class PersonajeDAO implements InterfazDAO<Personaje> {
    private EntityManagerFactory emf;
    private EntityManager em;

    private void initHibernate() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }

    public PersonajeDAO() {
        initHibernate();
    }

    // Método que crea un personaje y lo devuelve

    @Override
    public Personaje crearPersonaje(String nombre) {
        Personaje personaje = null;

        // COMENTARIO EXAMEN: Creamos el objeto Promocion para inicializarlo con su respectiva descripción
        Promocion promocionCreada = new Promocion();

        try {
            em.getTransaction().begin();
            switch (nombre) {
                case "Isaac":
                    personaje = new Personaje();
                    personaje.setId(1);
                    personaje.setNombre(nombre);
                    personaje.setDanoBase(3.5f);
                    personaje.setDescripcion("Un niño que se adentra en las profundidades de su sótano para escapar de su madre.");
                    personaje.setSaludBase(3);
                    personaje.setMultiplicadorDano(1f);

                    // COMENTARIO EXAMEN: Ponemos su respectivo código y lo añadimos la personaje
                    promocionCreada.setCodigoUnipersonal("isaac000");
                    promocionCreada.setDescripcion("Descripcion de isaac");
                    em.persist(promocionCreada);
                    em.flush();
                    personaje.setPromocion(promocionCreada);

                    em.persist(personaje);
                    break;

                case "Magdalena":
                    personaje = new Personaje();
                    personaje.setId(2);
                    personaje.setNombre(nombre);
                    personaje.setDanoBase(3.5f);
                    personaje.setDescripcion("Magdalena es una referencia a María Magdalena, una seguidora de Jesús que de su cuerpo salieron 7 demonios, referenciado con los 7 contenedores de vida necesarios para desbloquearla.");
                    personaje.setSaludBase(4);
                    personaje.setMultiplicadorDano(1f);

                    // COMENTARIO EXAMEN: Ponemos su respectivo código y lo añadimos la personaje
                    promocionCreada.setCodigoUnipersonal("magdalena111");
                    promocionCreada.setDescripcion("Descripcion de magadalena");
                    em.persist(promocionCreada);
                    em.flush();
                    personaje.setPromocion(promocionCreada);

                    em.persist(personaje);
                    break;

                case "Cain":
                    personaje = new Personaje();
                    personaje.setId(3);
                    personaje.setNombre(nombre);
                    personaje.setDanoBase(3.5f);
                    personaje.setDescripcion("Es una referencia a la historia bíblica de Caín y Abel, donde Caín comete el primer asesinato al matar a Abel.");
                    personaje.setSaludBase(2);
                    personaje.setMultiplicadorDano(1.2f);

                    // COMENTARIO EXAMEN: Ponemos su respectivo código y lo añadimos la personaje
                    promocionCreada.setCodigoUnipersonal("cain222");
                    promocionCreada.setDescripcion("Descripcion de cain");
                    em.persist(promocionCreada);
                    em.flush();
                    personaje.setPromocion(promocionCreada);

                    em.persist(personaje);
                    break;

                case "Judas":
                    personaje = new Personaje();
                    personaje.setId(4);
                    personaje.setNombre(nombre);
                    personaje.setDanoBase(3.5f);
                    personaje.setDescripcion("Es una referencia a la historia bíblica de Caín y Abel, donde Caín comete el primer asesinato al matar a Abel.");
                    personaje.setSaludBase(1);
                    personaje.setMultiplicadorDano(1.35f);

                    // COMENTARIO EXAMEN: Ponemos su respectivo código y lo añadimos la personaje
                    promocionCreada.setCodigoUnipersonal("judas333");
                    promocionCreada.setDescripcion("Descripcion de judas");
                    em.persist(promocionCreada);
                    em.flush();
                    personaje.setPromocion(promocionCreada);

                    em.persist(personaje);
                    break;

                case "???":
                    personaje = new Personaje();
                    personaje.setId(5);
                    personaje.setNombre(nombre);
                    personaje.setDanoBase(3.5f);
                    personaje.setDescripcion("El nombre Blue Baby viene del síndrome del bebé azul, refiriendo a un bebé recién nacido con problemas que causan un tono de piel más azul. Este ha aparecido como un personaje recurrente en los trabajos de Edmund McMillen, funcionando originalmente como la «mascota» de su cuenta en Newgrounds «Bluebaby».");
                    personaje.setSaludBase(3);
                    personaje.setMultiplicadorDano(1.05f);

                    // COMENTARIO EXAMEN: Ponemos su respectivo código y lo añadimos la personaje
                    promocionCreada.setCodigoUnipersonal("bluebaby444");
                    promocionCreada.setDescripcion("Descripcion de blueBaby");
                    em.persist(promocionCreada);
                    em.flush();
                    personaje.setPromocion(promocionCreada);

                    em.persist(personaje);
                    break;

                case "Eva":
                    personaje = new Personaje();
                    personaje.setId(6);
                    personaje.setNombre(nombre);
                    personaje.setDanoBase(3.5f);
                    personaje.setDescripcion("Según la teología bíblica, Eva fue la primera mujer en la tierra, nacida de la costilla de Adán según el libro de Génesis. En el juego original de The Binding of Isaac, Eve dejaba sangre en lugar de orina al entrar a una habitación teniendo medio corazón de vida restante; se teorizaba que esto era una referencia a la menstruación, que bíblicamente se explica como una maldición dada a Eve por Dios.");
                    personaje.setSaludBase(2);
                    personaje.setMultiplicadorDano(0.75f);

                    // COMENTARIO EXAMEN: Ponemos su respectivo código y lo añadimos la personaje
                    promocionCreada.setCodigoUnipersonal("eva555");
                    promocionCreada.setDescripcion("Descripcion de eva");
                    em.persist(promocionCreada);
                    em.flush();
                    personaje.setPromocion(promocionCreada);

                    em.persist(personaje);
                    break;

                case "Samson":
                    personaje = new Personaje();
                    personaje.setId(7);
                    personaje.setNombre(nombre);
                    personaje.setDanoBase(3.5f);
                    personaje.setDescripcion("En la Biblia, Sansón era un guerrero sobrenaturalmente fuerte que derivaba su poder de su voto nazareo, lo que le otorgaba a Sansón una fuerza inmensa si no se cortaba el cabello.");
                    personaje.setSaludBase(3);
                    personaje.setMultiplicadorDano(1f);

                    // COMENTARIO EXAMEN: Ponemos su respectivo código y lo añadimos la personaje
                    promocionCreada.setCodigoUnipersonal("samson666");
                    promocionCreada.setDescripcion("Descripcion de samson");
                    em.persist(promocionCreada);
                    em.flush();
                    personaje.setPromocion(promocionCreada);

                    em.persist(personaje);
                    break;

                case "Azazel":
                    personaje = new Personaje();
                    personaje.setId(8);
                    personaje.setNombre(nombre);
                    personaje.setDanoBase(3.5f);
                    personaje.setDescripcion("En la Biblia, Azazel es el nombre que se le da al macho cabrío que fue arrojado al monte como parte de los rituales de expiación judíos. Sin embargo, en ciertas tradiciones de las religiones abrahámicas, Azazel se refiere al ángel caído que enseñó a la gente a fabricar armas y joyas y enseñó a las mujeres el \"arte pecaminoso\" de pintarse la cara, como se menciona en el Libro apócrifo de Enoc.");
                    personaje.setSaludBase(3);
                    personaje.setMultiplicadorDano(1.5f);

                    // COMENTARIO EXAMEN: Ponemos su respectivo código y lo añadimos la personaje
                    promocionCreada.setCodigoUnipersonal("azazel777");
                    promocionCreada.setDescripcion("Descripcion de azazel");
                    em.persist(promocionCreada);
                    em.flush();
                    personaje.setPromocion(promocionCreada);

                    em.persist(personaje);
                    break;
                default:
                    break;
            }
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Se lanza excepcion " + e.getMessage());
            //Alertas.showError("Error en PersonajeDAO", "Error en el método crearPersonaje");
        }
        return personaje;
    }

    // Método que eliminar un personaje

    @Override
    public void eliminarPersonaje(int idPersonaje) {
        try {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM PersonajeObjeto po WHERE po.idPersonaje.id = :idPersonaje")
                    .setParameter("idPersonaje", idPersonaje)
                    .executeUpdate();
            em.createQuery("DELETE FROM Personaje p WHERE p.id = :idPersonaje")
                    .setParameter("idPersonaje", idPersonaje)
                    .executeUpdate();
            em.createQuery("DELETE FROM Promocion p").executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    // Método que selecciona un personaje y devuelve su id

    @Override
    public int seleccionarIDpersonaje() {
        Query query = em.createQuery("SELECT p.id FROM Personaje p ORDER BY p.id ASC");
        return (int) query.getSingleResult();
    }

    // Método que añade un objeto pasivo a un personaje

    @Override
    public void addObjetoPasivoToPersonaje(int idPersonaje, int idObjeto) {
        try {
            em.getTransaction().begin();
            Personaje personaje = em.find(Personaje.class, idPersonaje);
            if (personaje == null) {
                throw new IllegalArgumentException("Personaje no encontrado");
            }
            ObjetosPasivo objetoPasivo = em.find(ObjetosPasivo.class, idObjeto);
            if (objetoPasivo == null) {
                throw new IllegalArgumentException("El objeto pasivo con id " + idObjeto + " no existe.");
            }
            createObjetoPersonaje(idPersonaje, idObjeto, personaje, objetoPasivo);
            em.getTransaction().commit();
            addTiempoRelacionPersonajeObjeto(idObjeto, idPersonaje);
        } catch (Exception e) {
            em.getTransaction().rollback();
            Alertas.showWarning("Objeto pasivo existente", "El objeto pasivo que estás intentando añadir ya está en el inventario, seleccione uno distinto");
        }
    }

    // Método que añade un objeto activo a un personaje

    @Override
    public void addObjetoActivoToPersonaje(int idPersonaje, int idObjeto) {
        try {
            em.getTransaction().begin();
            Personaje personaje = em.find(Personaje.class, idPersonaje);
            if (personaje == null) {
                throw new IllegalArgumentException("Personaje no encontrado");
            }
            ObjetosActivo objetoActivo = em.find(ObjetosActivo.class, idObjeto);
            if (objetoActivo == null) {
                throw new IllegalArgumentException("El objeto activo con id " + idObjeto + " no existe.");
            }
            createObjetoPersonaje(idPersonaje, idObjeto, personaje, objetoActivo);
            em.getTransaction().commit();
            addTiempoRelacionPersonajeObjeto(idObjeto, idPersonaje);
        } catch (Exception e) {
            em.getTransaction().rollback();
            Alertas.showWarning("Objeto activo existente", "El objeto activo que estás intentando añadir ya está en el inventario, seleccione uno distinto");
        }
    }

    // Método que añade un consumible a un personaje

    @Override
    public void addConsumibleToPersonaje(int idPersonaje, int idObjeto) {
        try {
            em.getTransaction().begin();
            Personaje personaje = em.find(Personaje.class, idPersonaje);
            if (personaje == null) {
                throw new IllegalArgumentException("Personaje no encontrado");
            }
            Consumible consumible = em.find(Consumible.class, idObjeto);
            if (consumible == null) {
                throw new IllegalArgumentException("El consumible con id " + idObjeto + " no existe.");
            }
            createObjetoPersonaje(idPersonaje, idObjeto, personaje, consumible);
            em.getTransaction().commit();
            addTiempoRelacionPersonajeObjeto(idObjeto, idPersonaje);
        } catch (Exception e) {
            em.getTransaction().rollback();
            Alertas.showWarning("Objeto consumible existente", "El objeto consumible que estás intentando añadir ya está en el inventario, seleccione uno distinto");
        }
    }

    // Función creada para que se haga otro update en la bbdd

    private void addTiempoRelacionPersonajeObjeto(Integer idObjeto, Integer idPersonaje) {
        String tiempoAhora = java.time.LocalTime.now().toString();
        try {
            em.getTransaction().begin();
            PersonajeObjetoId personajeObjetoId = new PersonajeObjetoId();
            personajeObjetoId.setIdPersonaje(idPersonaje);
            personajeObjetoId.setIdObjeto(idObjeto);
            PersonajeObjeto personajeObjetoUpdate = em.find(PersonajeObjeto.class, personajeObjetoId);
            personajeObjetoUpdate.setFechaInsercion(tiempoAhora);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            Alertas.showError("Error en PersonajeDAO", "Error en el método addTiempoRelacionPersonajeObjeto");
        }
    }

    // Método que crea una relación entre un personaje y un objeto

    private void createObjetoPersonaje(int idPersonaje, int idObjeto, Personaje personaje, Objeto objeto) {
        PersonajeObjetoId personajeObjetoId = new PersonajeObjetoId();
        personajeObjetoId.setIdPersonaje(idPersonaje);
        personajeObjetoId.setIdObjeto(idObjeto);
        PersonajeObjeto personajeObjeto = new PersonajeObjeto();
        personajeObjeto.setId(personajeObjetoId);
        personajeObjeto.setIdPersonaje(personaje);
        personajeObjeto.setIdObjeto(objeto);
        em.persist(personajeObjeto);
    }

    // Método que devuelve una lista con los objetos de un personaje

    public List<Objeto> showObjetosPersonaje(int idPersonaje) {
        Query query = em.createQuery("SELECT o FROM PersonajeObjeto p JOIN p.idObjeto o WHERE p.idPersonaje.id = :idPersonaje");
        query.setParameter("idPersonaje", idPersonaje);
        List<Objeto> result = query.getResultList();
        return result;
    }

    // Método que elimina un item de un personaje

    public void eliminarItemDePersonaje(int idPersonaje, int idObjeto) {
        try {
            PersonajeObjetoId relacionId = new PersonajeObjetoId();
            relacionId.setIdPersonaje(idPersonaje);
            relacionId.setIdObjeto(idObjeto);

            // Buscar la relación específica
            PersonajeObjeto relacion = em.find(PersonajeObjeto.class, relacionId);

            if (relacion != null) {
                em.getTransaction().begin();
                em.remove(relacion);

                em.getTransaction().commit();
                System.out.println("Relación eliminada correctamente.");
            } else {
                System.out.println("No se encontró la relación especificada.");
            }

        } catch (Exception e) {
            em.getTransaction().rollback();
            Alertas.showError("Error en PersonajeDAO", "Error en el método eliminarItemDePersonaje");
        }
    }

    // Método que devuelve un objeto pasivo

    public ObjetosPasivo getObjetoPasivo(Integer idObjeto) {
        ObjetosPasivo objetoPasivo = null;
        try {
            em.getTransaction().begin();
            objetoPasivo = em.find(ObjetosPasivo.class, idObjeto);
        } catch (Exception e) {
            em.getTransaction().rollback();
            Alertas.showError("Error en PersonajeDAO", "Error en el método getObjetoPasivo");
        }
        return objetoPasivo;
    }

    public String getCodigoPromocional() {
        try {
            em.getTransaction().begin();
            Personaje personajeActual = em.find(Personaje.class, seleccionarIDpersonaje());
            return personajeActual.getPromocion().getCodigoUnipersonal();
        } catch (Exception e) {
            em.getTransaction().rollback();
            Alertas.showError("Error en PersonajeDAO", "Error en el método getCodigoPromocional");
        }
        return "Ninguno";
    }
}

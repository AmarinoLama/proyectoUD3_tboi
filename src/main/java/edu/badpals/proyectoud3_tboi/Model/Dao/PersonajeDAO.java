package edu.badpals.proyectoud3_tboi.Model.Dao;

import edu.badpals.proyectoud3_tboi.Model.Entity.*;
import edu.badpals.proyectoud3_tboi.View.EmergentWindows;
import jakarta.persistence.*;

import java.util.List;

public class PersonajeDAO implements InterfazDAO<Personaje>{
    private EntityManagerFactory emf;
    private EntityManager em;

    private void initHibernate(){
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }
    public PersonajeDAO(){
        initHibernate();
    }

    public void closeHibernate(){
        em.close();
        emf.close();
    }

    @Override
    public Personaje crearPersonaje(String nombre){
        Personaje personaje = null;
        try{
            em.getTransaction().begin();
            switch (nombre){
                case "Isaac":
                    personaje = new Personaje();
                    personaje.setId(1);
                    personaje.setNombre(nombre);
                    personaje.setDanoBase(3.5f);
                    personaje.setDescripcion("Un niño que se adentra en las profundidades de su sótano para escapar de su madre.");
                    personaje.setSaludBase(3);
                    personaje.setMultiplicadorDano(1f);
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
                    em.persist(personaje);
                    break;
                default:
                    break;
            }
            EmergentWindows.showInfo("Personaje creado","El personaje ha sido creado exitosamente");
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            EmergentWindows.showError("Error en PersonajeDAO","Error en el método crearPersonaje");
        }
        return personaje;
    }

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
            em.getTransaction().commit();
            EmergentWindows.showInfo("Personaje borrado","El personaje ha sido borrado exitosamente");
        } catch (Exception e) {
            em.getTransaction().rollback();
            EmergentWindows.showError("Error en PersonajeDAO","Error en el método eliminarPersonaje");
        }
    }

    @Override
    public int seleccionarIDpersonaje(){
        Query query = em.createQuery("SELECT p.id FROM Personaje p ORDER BY p.id ASC");
        return (int) query.getSingleResult();
    }
    
    @Override
    public void addObjetoPasivoToPersonaje(int idPersonaje, int idObjeto){
        try {
            String tiempoAhora = java.time.LocalTime.now().toString();
            em.getTransaction().begin();
            Personaje personaje = em.find(Personaje.class, idPersonaje);
            if (personaje == null) {
                throw new IllegalArgumentException("Personaje no encontrado");
            }
            ObjetosPasivo objetoPasivo = em.find(ObjetosPasivo.class, idObjeto);
            if (objetoPasivo == null) {
                throw new IllegalArgumentException("El objeto pasivo con id " + idObjeto + " no existe.");
            }
            createObjetoPersonaje(idPersonaje, idObjeto, personaje, objetoPasivo, tiempoAhora);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            EmergentWindows.showWarning("Objeto pasivo existente","El objeto pasivo que estás intentando añadir ya está en el inventario, seleccione uno distinto");
        }
    }

    @Override
    public void addObjetoActivoToPersonaje(int idPersonaje, int idObjeto){
        try {
            String tiempoAhora = java.time.LocalTime.now().toString();
            em.getTransaction().begin();
            Personaje personaje = em.find(Personaje.class, idPersonaje);
            if (personaje == null) {
                throw new IllegalArgumentException("Personaje no encontrado");
            }
            ObjetosActivo objetoActivo = em.find(ObjetosActivo.class, idObjeto);
            if (objetoActivo == null) {
                throw new IllegalArgumentException("El objeto activo con id " + idObjeto + " no existe.");
            }
            createObjetoPersonaje(idPersonaje, idObjeto, personaje, objetoActivo, tiempoAhora);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            EmergentWindows.showWarning("Objeto activo existente","El objeto activo que estás intentando añadir ya está en el inventario, seleccione uno distinto");
        }
    }

    @Override
    public void addConsumibleToPersonaje(int idPersonaje, int idObjeto){
        try {
            String tiempoAhora = java.time.LocalTime.now().toString();
            em.getTransaction().begin();
            Personaje personaje = em.find(Personaje.class, idPersonaje);
            if (personaje == null) {
                throw new IllegalArgumentException("Personaje no encontrado");
            }
            Consumible consumible = em.find(Consumible.class, idObjeto);
            if (consumible == null) {
                throw new IllegalArgumentException("El consumible con id " + idObjeto + " no existe.");
            }
            createObjetoPersonaje(idPersonaje, idObjeto, personaje, consumible, tiempoAhora);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            EmergentWindows.showWarning("Objeto consumible existente","El objeto consumible que estás intentando añadir ya está en el inventario, seleccione uno distinto");
        }
    }


    private void createObjetoPersonaje(int idPersonaje, int idObjeto, Personaje personaje, Objeto objeto, String tiempoAhora) {
        PersonajeObjetoId personajeObjetoId = new PersonajeObjetoId();
        personajeObjetoId.setIdPersonaje(idPersonaje);
        personajeObjetoId.setIdObjeto(idObjeto);
        PersonajeObjeto personajeObjeto = new PersonajeObjeto();
        personajeObjeto.setId(personajeObjetoId);
        personajeObjeto.setIdPersonaje(personaje);
        personajeObjeto.setIdObjeto(objeto);
        personajeObjeto.setFechaInsercion(tiempoAhora);
        em.persist(personajeObjeto);
    }

    public List<Objeto> showObjetosPersonaje(int idPersonaje){
        Query query = em.createQuery("SELECT o FROM PersonajeObjeto p JOIN p.idObjeto o WHERE p.idPersonaje.id = :idPersonaje");
        query.setParameter("idPersonaje", idPersonaje);
        List<Objeto> result = query.getResultList();
        return result;
    }

    public void eliminarItemDePersonaje(int idPersonaje, int idObjeto){
        try{
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
            EmergentWindows.showError("Error en PersonajeDAO","Error en el método eliminarItemDePersonaje");
        }
    }

    public ObjetosPasivo getObjetoPasivo(Integer idObjeto) {
        ObjetosPasivo objetoPasivo = null;
        try{
            em.getTransaction().begin();
            objetoPasivo = em.find(ObjetosPasivo.class, idObjeto);
        } catch (Exception e){
            em.getTransaction().rollback();
            EmergentWindows.showError("Error en PersonajeDAO","Error en el método getObjetoPasivo");
        }
        return objetoPasivo;
    }
}

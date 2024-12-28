package edu.badpals.proyectoud3_tboi.Model.Dao;

import edu.badpals.proyectoud3_tboi.Model.Entity.Personaje;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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

    @Override
    public void crearPersonaje(String nombre){
        try{
            em.getTransaction().begin();
            switch (nombre){
                case "Isaac":
                    Personaje isaac = new Personaje();
                    isaac.setId(1);
                    isaac.setNombre(nombre);
                    isaac.setDanoBase(3.5f);
                    isaac.setDescripcion("Un niño que se adentra en las profundidades de su sótano para escapar de su madre.");
                    isaac.setSaludBase(3);
                    em.persist(isaac);
                    em.getTransaction().commit();
                break;

                case "Magdalene":
                    Personaje magdalene = new Personaje();
                    magdalene.setId(2);
                    magdalene.setNombre(nombre);
                    magdalene.setDanoBase(3.5f);
                    magdalene.setDescripcion("Magdalena es una referencia a María Magdalena, una seguidora de Jesús que de su cuerpo salieron 7 demonios, referenciado con los 7 contenedores de vida necesarios para desbloquearla.");
                    magdalene.setSaludBase(4);
                    em.persist(magdalene);
                    em.getTransaction().commit();
                    break;

                case "Cain":
                    Personaje cain = new Personaje();
                    cain.setId(3);
                    cain.setNombre(nombre);
                    cain.setDanoBase(4.2f);
                    cain.setDescripcion("Es una referencia a la historia bíblica de Caín y Abel, donde Caín comete el primer asesinato al matar a Abel.");
                    cain.setSaludBase(2);
                    em.persist(cain);
                    em.getTransaction().commit();
                    break;

                case "Judas":
                    Personaje judas = new Personaje();
                    judas.setId(4);
                    judas.setNombre(nombre);
                    judas.setDanoBase(4.73f);
                    judas.setDescripcion("Es una referencia a la historia bíblica de Caín y Abel, donde Caín comete el primer asesinato al matar a Abel.");
                    judas.setSaludBase(1);
                    em.persist(judas);
                    em.getTransaction().commit();
                    break;

                case "Blue Baby":
                    Personaje bluebaby = new Personaje();
                    bluebaby.setId(5);
                    bluebaby.setNombre(nombre);
                    bluebaby.setDanoBase(3.68f);
                    bluebaby.setDescripcion("El nombre Blue Baby viene del síndrome del bebé azul, refiriendo a un bebé recién nacido con problemas que causan un tono de piel más azul. Este ha aparecido como un personaje recurrente en los trabajos de Edmund McMillen, funcionando originalmente como la «mascota» de su cuenta en Newgrounds «Bluebaby».");
                    bluebaby.setSaludBase(3);
                    em.persist(bluebaby);
                    em.getTransaction().commit();
                    break;

                case "Eva":
                    Personaje eva = new Personaje();
                    eva.setId(6);
                    eva.setNombre(nombre);
                    eva.setDanoBase(2.63f);
                    eva.setDescripcion("Según la teología bíblica, Eva fue la primera mujer en la tierra, nacida de la costilla de Adán según el libro de Génesis. En el juego original de The Binding of Isaac, Eve dejaba sangre en lugar de orina al entrar a una habitación teniendo medio corazón de vida restante; se teorizaba que esto era una referencia a la menstruación, que bíblicamente se explica como una maldición dada a Eve por Dios.");
                    eva.setSaludBase(2);
                    em.persist(eva);
                    em.getTransaction().commit();
                    break;

                case "Samson":
                    Personaje samson = new Personaje();
                    samson.setId(7);
                    samson.setNombre(nombre);
                    samson.setDanoBase(3.5f);
                    samson.setDescripcion("En la Biblia, Sansón era un guerrero sobrenaturalmente fuerte que derivaba su poder de su voto nazareo, lo que le otorgaba a Sansón una fuerza inmensa si no se cortaba el cabello.");
                    samson.setSaludBase(3);
                    em.persist(samson);
                    em.getTransaction().commit();
                    break;

                case "Azazel":
                    Personaje azazel = new Personaje();
                    azazel.setId(8);
                    azazel.setNombre(nombre);
                    azazel.setDanoBase(5.25f);
                    azazel.setDescripcion("En la Biblia, Azazel es el nombre que se le da al macho cabrío que fue arrojado al monte como parte de los rituales de expiación judíos. Sin embargo, en ciertas tradiciones de las religiones abrahámicas, Azazel se refiere al ángel caído que enseñó a la gente a fabricar armas y joyas y enseñó a las mujeres el \"arte pecaminoso\" de pintarse la cara, como se menciona en el Libro apócrifo de Enoc.");
                    azazel.setSaludBase(3);
                    em.persist(azazel);
                    em.getTransaction().commit();
                    break;
                default:
                    break;
            }
            System.out.println("Personaje creado con éxito");
            // crear mensaje emergente conforme se ha creado correctamente el personaje

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}

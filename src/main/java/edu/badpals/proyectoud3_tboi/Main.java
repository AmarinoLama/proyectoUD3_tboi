package edu.badpals.proyectoud3_tboi;

import edu.badpals.proyectoud3_tboi.Model.Entity.Personaje;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/hello-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("The Binding of Isaac: Rebirth");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public static void crearPersonajePrueba() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        Personaje personaje = new Personaje();
        personaje.setNombre("Isaac");
        personaje.setId(1);
        personaje.setDescripcion("Un niño que se adentra en las profundidades de su sótano para escapar de su madre.");
        personaje.setDanoBase(3.5f);
        personaje.setSaludBase(3);

        try{
            em.getTransaction().begin();
            em.persist(personaje);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            System.out.println("Error malo" + e.getMessage());
        }

        em.close();
        emf.close();

    }

    public static void main(String[] args) {
        Application.launch(args);
        //crearPersonajePrueba();
    }
}
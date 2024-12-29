package edu.badpals.proyectoud3_tboi;

import edu.badpals.proyectoud3_tboi.Model.Dao.InterfazDAO;
import edu.badpals.proyectoud3_tboi.Model.Dao.PersonajeDAO;
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

        //FXMLLoader loader = new FXMLLoader(getClass().getResource("/seleccionPersonaje.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/seleccionPersonaje.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("The Binding of Isaac: Rebirth");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }


    public static void main(String[] args) {
        Application.launch(args);
        //PersonajeDAO judas = new PersonajeDAO();
        //judas.crearPersonaje("Judas");
    }
}
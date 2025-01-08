package edu.badpals.proyectoud3_tboi;

import edu.badpals.proyectoud3_tboi.Model.Dao.ObjetoDAO;
import edu.badpals.proyectoud3_tboi.Model.Dao.ObjetoPasivoDAO;
import edu.badpals.proyectoud3_tboi.Model.Dao.PersonajeDAO;
import edu.badpals.proyectoud3_tboi.Model.Entity.Objeto;
import edu.badpals.proyectoud3_tboi.Model.Entity.ObjetosPasivo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

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
        /*PersonajeDAO personaje = new PersonajeDAO();

        personaje.addObjetoPasivoToPersonaje(4,1);
        personaje.addObjetoActivoToPersonaje(4,5);
        personaje.addConsumibleToPersonaje(4,3);
        personaje.showObjetosPersonaje(4);
        personaje.closeHibernate();

        personaje.showObjetosPersonaje(4);*/
    }
}
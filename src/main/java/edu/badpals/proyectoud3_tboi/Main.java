package edu.badpals.proyectoud3_tboi;

import edu.badpals.proyectoud3_tboi.Model.Dao.ConsumibleDAO;
import edu.badpals.proyectoud3_tboi.Model.Dao.HabitacionDAO;
import edu.badpals.proyectoud3_tboi.Model.Dao.PersonajeDAO;
import edu.badpals.proyectoud3_tboi.Model.Entity.Objeto;
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

    private static void dropPersonajeObjeto() {
        PersonajeDAO personajeDAO = new PersonajeDAO();
        personajeDAO.eliminarPersonaje(personajeDAO.seleccionarIDpersonaje());
    }

    public static void main(String[] args) {
        Application.launch(args);
        dropPersonajeObjeto();
        /*HabitacionDAO habitacionDAO = new HabitacionDAO();
        List<Objeto> objetos = habitacionDAO.filtrarPool("Secreta");
        for (Objeto objeto : objetos) {
            System.out.println(objeto.getNombre());
        }*/
        ConsumibleDAO consumibleDAO = new ConsumibleDAO();
        consumibleDAO.crearConsumible("Pocion de vida", "Recupera 1 corazon", 0);
        /*consumibleDAO.eliminarConsumible("Pocion de vida");
        consumibleDAO.modificarConsumible("Pocion de vida", "Recupera 2 corazones", 0);*/
    }
}
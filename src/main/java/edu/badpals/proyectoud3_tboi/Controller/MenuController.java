package edu.badpals.proyectoud3_tboi.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private ImageView imgPersonaje;

    @FXML
    private Button btnAnadirItem;

    @FXML
    private Button btnCambiarPersonaje;

    @FXML
    private Button btnQuitarItem;

    @FXML
    private MenuButton mbtnHabitacion;

    @FXML
    private MenuButton mbtnTipoObjeto;

    @FXML
    private Text txtAlcance;

    @FXML
    private Text txtAtaque;

    @FXML
    private Text txtConsumible;

    @FXML
    private Text txtItemActivo;

    @FXML
    private Text txtLagrimas;

    @FXML
    private Text txtSuerte;

    @FXML
    private Text txtVelocidad;

    @FXML
    private Text txtVelocidadLagrimas;

    @FXML
    private Text txtVida;

    @FXML
    void anadirItem(ActionEvent event) {

    }

    @FXML
    void cambiarPersonaje(ActionEvent event) {
        cargarVentana();
    }

    @FXML
    void quitarItem(ActionEvent event) {

    }

    public void cargarVentana() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/seleccionPersonaje.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setTitle("The Binding of Isaac: Rebirth");
            newStage.setScene(scene);
            newStage.setResizable(false);
            newStage.show();

            Stage currentStage = (Stage) imgPersonaje.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ImageView getImgPersonaje() {
        return imgPersonaje;
    }

    public void setImgPersonaje(String personaje) {
        imgPersonaje.setImage(new Image(getClass().getResource("/img/personajes/" + personaje + ".png").toExternalForm()));
    }
}
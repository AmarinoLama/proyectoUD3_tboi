package edu.badpals.proyectoud3_tboi.Controller;

import edu.badpals.proyectoud3_tboi.Model.Dao.PersonajeDAO;
import edu.badpals.proyectoud3_tboi.View.Warnings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SeleccionPersonaje {

    @FXML
    private ImageView azazel;

    @FXML
    private ImageView blueBaby;

    @FXML
    private ImageView cain;

    @FXML
    private ImageView eva;

    @FXML
    private ImageView isaac;

    @FXML
    private ImageView judas;

    @FXML
    private ImageView magdalene;

    @FXML
    private ImageView samson;

    @FXML
    private Text heart;

    @FXML
    private Text damage;

    @FXML
    private Text speed;

    @FXML
    private Text name;

    @FXML
    void createAzazel(MouseEvent event) {
        name.setText("Azazel");
        speed.setText("👞 I I I");
        damage.setText("⚔ I I I I");
        heart.setText("❤ -I");
    }

    @FXML
    void createBlueBaby(MouseEvent event) {
        name.setText("???");
        speed.setText("👞 I I");
        damage.setText("⚔ I I");
        heart.setText("❤ -I");
    }

    @FXML
    void createCain(MouseEvent event) {
        name.setText("Cain");
        speed.setText("👞 I I I ");
        damage.setText("⚔ I I I");
        heart.setText("❤ I I");
    }

    @FXML
    void createEva(MouseEvent event) {
        name.setText("Eva");
        speed.setText("👞 I I I");
        damage.setText("⚔ I");
        heart.setText("❤ I I");
    }

    @FXML
    void createIsaac(MouseEvent event) {
        name.setText("Isaac");
        speed.setText("👞 I I");
        damage.setText("⚔ I I");
        heart.setText("❤ I I I");
    }

    @FXML
    void createJudas(MouseEvent event) {
        name.setText("Judas");
        speed.setText("👞 I I");
        damage.setText("⚔ I I I I");
        heart.setText("❤ I");
    }

    @FXML
    void createMagdalene(MouseEvent event) {
        name.setText("Magdalena");
        speed.setText("👞 I");
        damage.setText("⚔ I I");
        heart.setText("❤ I I I I");
    }

    @FXML
    void createSamson(MouseEvent event) {
        name.setText("Samson");
        speed.setText("👞 I I");
        damage.setText("⚔ I I");
        heart.setText("❤ I I I");
    }

    @FXML
    void createCharacterPressed(ActionEvent event) {
        if (name.getText().equals("Selecciona un personaje")) {
            Warnings.showError("Selecciona un personaje");
            return;
        }
        PersonajeDAO personaje = new PersonajeDAO();
        personaje.crearPersonaje(name.getText());
        abrirMenuPrincipal();
    }

    public void abrirMenuPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/menuPrincipal.fxml"));
            Parent root = loader.load();

            // usa esto para pasarle la vida inicial de los personajes, trata los corazones negativos como 0,5 y listo
            MenuController menuController = loader.getController();
            String personajeName = name.getText().equals("???") ? "blueBaby" : name.getText().toLowerCase();
            menuController.setImgPersonaje(personajeName);

            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setTitle("The Binding of Isaac: Rebirth");
            newStage.setScene(scene);
            newStage.setResizable(false);
            newStage.show();

            Stage currentStage = (Stage) heart.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
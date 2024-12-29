package edu.badpals.proyectoud3_tboi.Controller;

import edu.badpals.proyectoud3_tboi.Model.Dao.PersonajeDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

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
        System.out.println("Azazel");
        name.setText("Azazel");
        speed.setText("👞 I I I");
        damage.setText("⚔ I I I I");
        heart.setText("❤ -I");
    }

    @FXML
    void createBlueBaby(MouseEvent event) {
        System.out.println("Blue Baby");
        name.setText("Blue Baby");
        speed.setText("👞 I I");
        damage.setText("⚔ I I");
        heart.setText("❤ -I");
    }

    @FXML
    void createCain(MouseEvent event) {
        System.out.println("Cain");
        name.setText("Cain");
        speed.setText("👞 I I I ");
        damage.setText("⚔ I I I");
        heart.setText("❤ I I");
    }

    @FXML
    void createEva(MouseEvent event) {
        System.out.println("Eva");
        name.setText("Eva");
        speed.setText("👞 I I I");
        damage.setText("⚔ I");
        heart.setText("❤ I I");
    }

    @FXML
    void createIsaac(MouseEvent event) {
        System.out.println("Isaac");
        name.setText("Isaac");
        speed.setText("👞 I I");
        damage.setText("⚔ I I");
        heart.setText("❤ I I I");
    }

    @FXML
    void createJudas(MouseEvent event) {
        System.out.println("Judas");
        name.setText("Judas");
        speed.setText("👞 I I");
        damage.setText("⚔ I I I I");
        heart.setText("❤ I");
    }

    @FXML
    void createMagdalene(MouseEvent event) {
        System.out.println("Magdalene");
        name.setText("Magdalene");
        speed.setText("👞 I");
        damage.setText("⚔ I I");
        heart.setText("❤ I I I I");
    }

    @FXML
    void createSamson(MouseEvent event) {
        System.out.println("Samson");
        name.setText("Samson");
        speed.setText("👞 I I");
        damage.setText("⚔ I I");
        heart.setText("❤ I I I");
    }

    @FXML
    void createCharacterPressed(ActionEvent event) {
        PersonajeDAO personaje = new PersonajeDAO();
        personaje.crearPersonaje(name.getText());
        System.out.println("Character created");
    }

}
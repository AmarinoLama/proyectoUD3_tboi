package edu.badpals.proyectoud3_tboi.Controller;

import edu.badpals.proyectoud3_tboi.Model.Dao.ConsumibleDAO;
import edu.badpals.proyectoud3_tboi.View.Alertas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CrearConsumibleController {

    @FXML
    public TextField nombreCrear;

    @FXML
    public TextField duracionCrear;

    @FXML
    private TextArea efectoCrear;

    @FXML
    private Button btnCrear;

    public void crearConsumible(ActionEvent event) {
        ConsumibleDAO consumibleDAO = new ConsumibleDAO();
        if (nombreCrear.getText().isEmpty() || duracionCrear.getText().isEmpty() || efectoCrear.getText().isEmpty()) {
            Alertas.showWarning("Error", "Por favor llene todos los campos");
            return;
        } else if (!duracionCrear.getText().matches("[0-9]+")) {
            Alertas.showError("Error", "La duración debe ser un número entero");
            return;
        }
        consumibleDAO.crearConsumible(nombreCrear.getText(), efectoCrear.getText(), Integer.parseInt(duracionCrear.getText()));
        Alertas.showInfo("Consumible creado", "El consumible se ha creado con exitosamente");
    }
}

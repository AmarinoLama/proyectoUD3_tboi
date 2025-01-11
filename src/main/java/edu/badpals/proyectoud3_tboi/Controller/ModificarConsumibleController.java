package edu.badpals.proyectoud3_tboi.Controller;

import edu.badpals.proyectoud3_tboi.Model.Dao.ConsumibleDAO;
import edu.badpals.proyectoud3_tboi.Model.Entity.Consumible;
import edu.badpals.proyectoud3_tboi.View.Alertas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ModificarConsumibleController {

    @FXML
    private Button btnCargarDatos;

    @FXML
    private Button btnModificiar;

    @FXML
    private TextField duracionModificar;

    @FXML
    private TextArea efectoModificar;

    @FXML
    private TextField nombreModificar;

    @FXML
    public void modificarDatos(ActionEvent event) {
        ConsumibleDAO consumibleDAO = new ConsumibleDAO();

        if (consumibleDAO.personajeTieneConsumible(nombreModificar.getText())) {
            Alertas.showWarning("Advertencia", "El consumible " + nombreModificar.getText() + " está siendo usado por un personaje");
            return;
        }

        if (nombreModificar.getText().isEmpty() || duracionModificar.getText().isEmpty() || efectoModificar.getText().isEmpty()) {
            Alertas.showWarning("Error", "Por favor llene todos los campos");
            return;
        } else if (!duracionModificar.getText().matches("[0-9]+")) {
            Alertas.showWarning("Error", "La duración debe ser un número entero");
            return;
        } else if (!consumibleDAO.consumibleExiste(nombreModificar.getText())) {
            Alertas.showWarning("Error", "El consumible no existe");
            nombreModificar.clear();
            efectoModificar.clear();
            duracionModificar.clear();
            return;
        }
        consumibleDAO.modificarConsumible(nombreModificar.getText(), efectoModificar.getText(), Integer.parseInt(duracionModificar.getText()));
        Alertas.showInfo("Consumible modificado", "El consumible se ha modificado con exitosamente");
    }

    @FXML
    public void cargarDatos(ActionEvent event) {
        ConsumibleDAO consumibleDAO = new ConsumibleDAO();
        if (nombreModificar.getText().isEmpty()) {
            Alertas.showWarning("Error", "Por favor llene el campo de nombre");
        } else {
            Consumible consumible = consumibleDAO.getConsumibleByName(nombreModificar.getText());
            if (!(consumible == null)) {
                efectoModificar.setText(consumible.getEfecto());
                duracionModificar.setText(consumible.getDuracionEfecto().toString());
            }else{
                Alertas.showWarning("Error", "El consumible no existe");
                nombreModificar.clear();
                efectoModificar.clear();
                duracionModificar.clear();
            }

        }
    }
}
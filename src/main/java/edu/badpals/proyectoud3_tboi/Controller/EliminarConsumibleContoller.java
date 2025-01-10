package edu.badpals.proyectoud3_tboi.Controller;

import edu.badpals.proyectoud3_tboi.Model.Dao.ConsumibleDAO;
import edu.badpals.proyectoud3_tboi.Model.Entity.Consumible;
import edu.badpals.proyectoud3_tboi.View.Alertas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EliminarConsumibleContoller {

    @FXML
    private Button btnBorrar;

    @FXML
    private Button btnComprobarExiste;

    @FXML
    private TextField nombreBorrar;

    public void clickBorrarConsumible(ActionEvent event) {
        if (checkExisteConsumible()) {
            ConsumibleDAO consumibleDAO = new ConsumibleDAO();
            consumibleDAO.eliminarConsumible(nombreBorrar.getText());
            Alertas.showInfo("Consumible eliminado", "El consumible " + nombreBorrar.getText() + " ha sido eliminado");
        }
    }

    public void clickComprarExisteConsumible(ActionEvent event) {
        if (checkExisteConsumible()) {
            Alertas.showInfo("Consumible encontrado", "El consumible " + nombreBorrar.getText() + " ha sido encontrado");
        } else {
            Alertas.showWarning("Consumible no encontrado", "El consumible " + nombreBorrar.getText() + " no ha sido encontrado");
        }
    }

    private boolean checkExisteConsumible() {
        ConsumibleDAO consumibleDAO = new ConsumibleDAO();
        Consumible consumible = consumibleDAO.getConsumibleByName(nombreBorrar.getText());
        return consumible != null;
    }
}

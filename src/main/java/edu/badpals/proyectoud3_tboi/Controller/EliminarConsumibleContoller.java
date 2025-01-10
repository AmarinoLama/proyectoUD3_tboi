package edu.badpals.proyectoud3_tboi.Controller;

import edu.badpals.proyectoud3_tboi.Model.Dao.ConsumibleDAO;
import edu.badpals.proyectoud3_tboi.Model.Entity.Consumible;
import edu.badpals.proyectoud3_tboi.View.Alertas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EliminarConsumibleContoller {

    @FXML
    private Button btnBorrar;

    @FXML
    private Button btnComprobarExiste;

    @FXML
    private TextField nombreBorrar;

    @FXML
    public void clickBorrarConsumible(ActionEvent event) {
        ConsumibleDAO consumibleDAO = new ConsumibleDAO();
        if (consumibleDAO.personajeTieneConsumible(nombreBorrar.getText())) {
            Alertas.showWarning("Advertencia", "El consumible " + nombreBorrar.getText() + " está siendo usado por un personaje");
        } else if (checkConsumibleDisponible()) {
            consumibleDAO.eliminarConsumible(nombreBorrar.getText());
            Alertas.showInfo("Consumible eliminado", "El consumible " + nombreBorrar.getText() + " ha sido eliminado");
        }
    }

    @FXML
    public void clickComprarExisteConsumible(ActionEvent event) {
        if (checkConsumibleDisponible()) {
            Alertas.showInfo("Consumible encontrado", "El consumible " + nombreBorrar.getText() + " ha sido encontrado");
        } else {
            Alertas.showWarning("Consumible no encontrado", "El consumible " + nombreBorrar.getText() + " no ha sido encontrado");
        }
    }

    private boolean checkConsumibleDisponible() {
        ConsumibleDAO consumibleDAO = new ConsumibleDAO();
        Consumible consumible = consumibleDAO.getConsumibleByName(nombreBorrar.getText());
        return consumible != null;
    }
}

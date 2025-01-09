package edu.badpals.proyectoud3_tboi.View;

import javafx.scene.control.Alert;

public class Warnings {

    public static void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void showExisteObjeto(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error al añadir");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void showNadaSeleccionado() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error al seleccionar");
        alert.setHeaderText(null);
        alert.setContentText("No has seleccionado ningún objeto");
        alert.showAndWait();
    }

}
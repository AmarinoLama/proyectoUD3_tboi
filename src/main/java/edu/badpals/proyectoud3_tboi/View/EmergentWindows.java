package edu.badpals.proyectoud3_tboi.View;

import javafx.scene.control.Alert;

public class EmergentWindows {

    public static void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void showWarning(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void showInfo(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void showNadaSeleccionado() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error al seleccionar");
        alert.setHeaderText(null);
        alert.setContentText("No has seleccionado ninguna opción");
        alert.showAndWait();
    }

}
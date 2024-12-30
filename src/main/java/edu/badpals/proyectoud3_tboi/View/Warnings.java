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

}

module edu.badpals.proyectoud3_tboi {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;

    opens edu.badpals.proyectoud3_tboi to javafx.fxml;
    opens edu.badpals.proyectoud3_tboi.Controller to javafx.fxml;
    opens edu.badpals.proyectoud3_tboi.Model.Entity to org.hibernate.orm.core;

    exports edu.badpals.proyectoud3_tboi;
}
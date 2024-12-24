module edu.badpals.proyectoud3_tboi {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;

    opens edu.badpals.proyectoud3_tboi.Model to org.hibernate.orm.core;
    exports edu.badpals.proyectoud3_tboi;
}
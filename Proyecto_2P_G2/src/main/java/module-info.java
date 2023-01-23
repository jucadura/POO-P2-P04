module com.mycompany.proyecto_p2_g2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.proyectop2_g2 to javafx.fxml;
    exports com.mycompany.proyectop2_g2;
}

module com.mycompany.proyectop2_g2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.proyectop2_g2 to javafx.fxml;
    exports com.mycompany.proyectop2_g2;
}

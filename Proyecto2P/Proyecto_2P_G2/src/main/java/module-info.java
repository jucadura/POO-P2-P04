module com.pooespol.mavenproject1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.pooespol.mavenproject1 to javafx.fxml;
    exports com.pooespol.mavenproject1;
}

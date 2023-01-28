package com.pooespol.mavenproject1;

import java.io.IOException;
import javafx.fxml.FXML;

public class VentanaOpcionesController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}
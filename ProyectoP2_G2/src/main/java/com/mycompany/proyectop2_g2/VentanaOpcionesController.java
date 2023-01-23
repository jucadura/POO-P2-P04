package com.mycompany.proyectop2_g2;

import java.io.IOException;
import javafx.fxml.FXML;

public class VentanaOpcionesController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.restaurante;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Grupo2
 */
public class MenuController implements Initializable {

    @FXML
    Label lblNombre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblNombre.setText("Bienvenid@ " + App.usuarioActual.getNombre());
        lblNombre.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        lblNombre.setAlignment(Pos.CENTER);

    }

    @FXML
    public void mostrarLocales(ActionEvent event) {
        App.cargarVentana("locales", 1200, 800);

    }

    @FXML
    public void hacerPedido(ActionEvent event) {
        App.cargarVentana("pedido", 1000, 400);
    }

    
}

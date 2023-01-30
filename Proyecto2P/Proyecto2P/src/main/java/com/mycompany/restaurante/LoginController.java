/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.restaurante;

import logica.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Grupo2
 */
public class LoginController implements Initializable {

    @FXML
    TextField txtUsuario;
    @FXML
    TextField txtContraseña;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void ingresar(ActionEvent event) {
        if (!txtUsuario.getText().isBlank() && !txtContraseña.getText().isBlank()) {
            Usuario user = App.verificarUsuario(App.usuarios, txtUsuario.getText(), txtContraseña.getText());
            if (user != null) {
                App.usuarioActual=user;
                try {
                    App.setRoot("menu");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                
            }

        }
    }
}

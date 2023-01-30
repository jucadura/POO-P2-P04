/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.restaurante;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Grupo2
 */
public class InfoPedidoController implements Initializable {

    @FXML
    Label lblInfo;
    @FXML
    Label lblTiempo;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lblInfo.setText("Su pedido Nro " + PedidoController.pedido.getIdPedido() + " ha sido pagado y ahora empezaremos a prepararlo.");
        Thread hiloDetalles = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 5; 0 <= i; i--) {
                    int contador = i;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            if (contador == 0) {
                                App.stagePago.close();
                            }
                            lblTiempo.setText("Cerrando en " + contador + "...");

                        }

                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });
        hiloDetalles.start();
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.restaurante;

import static com.mycompany.restaurante.PedidoController.pedido;
import static com.mycompany.restaurante.PedidoController.total;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logica.Archivos;
import logica.Pago;
import logica.Pedido;
import logica.PedidoTabla;
import logica.TipoPedido;

/**
 * FXML Controller class
 *
 * @author Michael
 */
public class PagoController implements Initializable {

    @FXML
    TextField txtDireccion;
    @FXML
    VBox contenedorInfo;
    @FXML
    private ToggleGroup opciones;
    private double totalPago;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void continuar(ActionEvent event) {
        if (!txtDireccion.getText().isBlank() && opciones.getSelectedToggle() != null) {
            Toggle toggle = opciones.getSelectedToggle();
            TipoPedido tipo = null;
            if (toggle instanceof RadioButton) {
                RadioButton radioButton = (RadioButton) toggle;
                if (radioButton.getText().equals("Efectivo")) {
                    tipo = TipoPedido.E;
                } else if (radioButton.getText().equals("Tarjeta de crédito")) {
                    tipo = TipoPedido.C;
                }

                // hacer algo con radioButton
            }
            String idPago = App.crearCodigoUnico();
            Pedido pedido = PedidoController.pedido;
            LocalDate fecha = LocalDate.now();
            Pago pago = new Pago(idPago, pedido, pedido.getCliente(), totalPago, fecha, tipo);
            String mensaje = idPago + "," + pedido.getIdPedido() + "," + pedido.getCliente().getNombre() + " " + pedido.getCliente().getApellido() + "," + String.valueOf(totalPago) + "," + String.valueOf(fecha) + "," + String.valueOf(tipo);
            Archivos.escribirArchivo(App.pathFiles + "pagos.txt", mensaje);
            App.cerrarVentana(event);
            App.stagePago=App.cargarVentana("infoPedido", 600, 400);

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Llene los datos faltantes");
            alert.setHeaderText(null);
            alert.setContentText("Llene los datos faltantes");
            ButtonType continuar = new ButtonType("Aceptar");
            alert.getButtonTypes().setAll(continuar);
            alert.showAndWait();
        }
    }

    @FXML
    public void limpiar(ActionEvent event) {
        opciones.selectToggle(null);
        contenedorInfo.getChildren().clear();
        txtDireccion.clear();
    }

    @FXML
    public void cargarEfectivo(ActionEvent event) {
        contenedorInfo.getChildren().clear();
        totalPago = PedidoController.total;
        Label mensajePago = new Label("Tendrá que pagar un total de " + String.valueOf(totalPago) + " dólares.");
        Label mensaje = new Label("Aségurese de tener el dinero completo por si el repartidor no tiene cambio.");
        contenedorInfo.getChildren().addAll(mensajePago, mensaje);

    }

    @FXML
    public void cargarTarjeta(ActionEvent event) {
        contenedorInfo.getChildren().clear();
        String[] textos = {"Titular: ", "Número: ", "Caducidad: ", "CVV: "};
        totalPago = PedidoController.total + (PedidoController.total * 0.05);
        for (String texto : textos) {
            HBox contenedorDatos = new HBox();
            Label lbl = new Label(texto);
            TextField txt = new TextField();
            contenedorDatos.getChildren().addAll(lbl, txt);
            contenedorInfo.getChildren().add(contenedorDatos);
        }
        Label infoPago = new Label("Tendrá que pagar un total de " + String.valueOf(total) + " dólares por el incremento del 5% por uso de la tarjeta");
        contenedorInfo.getChildren().add(infoPago);

    }
}

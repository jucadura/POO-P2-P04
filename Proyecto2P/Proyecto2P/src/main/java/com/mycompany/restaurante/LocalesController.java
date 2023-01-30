/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.restaurante;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.Local;

/**
 * FXML Controller class
 *
 * @author Grupo2
 */
public class LocalesController implements Initializable {

    @FXML
    Pane paneMapa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Local local : App.locales) {
                    Random rand = new Random();
                    int num = rand.nextInt(10) + 1;
                    Image image = null;
                    ImageView imageView = new ImageView();
                    imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                        Stage stage = new Stage();
                        stage.setTitle("Nueva Ventana");
                        VBox vbox = new VBox();
                        vbox.setSpacing(20);
                        vbox.setPadding(new Insets(30, 30, 30, 40));
                        vbox.setAlignment(Pos.CENTER_LEFT);
                        HBox hbox = new HBox();
                        hbox.setAlignment(Pos.CENTER);
                        hbox.setSpacing(20);
                        Label textoHilo = new Label();                      
                        Label nombre = new Label(local.getNombre());
                        Label direccion = new Label(local.getDirección());
                        Label horario = new Label(local.getHorario());
                        textoHilo.setStyle("-fx-font-weight: bold;");
                        nombre.setStyle("-fx-font-weight: bold;");
                        direccion.setStyle("-fx-font-weight: bold;");
                        horario.setStyle("-fx-font-weight: bold;");                      
                        Button button = new Button("Aceptar");
                        button.setStyle("-fx-background-color: #7ab3ff;");
                        button.addEventHandler(ActionEvent.ACTION, a -> {
                            stage.close();
                        });
                        hbox.getChildren().addAll(textoHilo, button);
                        vbox.getChildren().addAll(nombre, direccion, horario, hbox);
                        vbox.setStyle("-fx-background-color: #ed9700;");
                        Scene scene = new Scene(vbox);
                        stage.initStyle(StageStyle.UNDECORATED);
                        stage.setScene(scene);
                        stage.show();
                        stage.setMinWidth(320);
                        stage.setMinHeight(100);
                        Thread hiloDetalles = new Thread(new Runnable() {

                            @Override
                            public void run() {
                                for (int i = 5; 0 <= i; i--) {
                                    int contador = i;
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            if (contador == 0) {
                                                stage.close();
                                            }
                                            textoHilo.setText("Mostrando por " + contador + " segundos...");

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
                    });
                    try ( FileInputStream f = new FileInputStream(new File("src/main/resources/img/ubicacion.png"))) {
                        image = new Image(f);
                        imageView.setImage(image);
                        imageView.setFitHeight(50);
                        imageView.setFitWidth(50);
                        imageView.setLayoutX(local.getCoordenadaX());
                        imageView.setLayoutY(local.getCoordenadaY());

                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            paneMapa.getChildren().add(imageView);

                        }

                    });
                    try {
                        Thread.sleep(num * 1000);

                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

            }

        });
        hilo.start();

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.restaurante;

import static com.mycompany.restaurante.App.menu;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import logica.Archivos;
import logica.Menu;
import logica.Pedido;
import logica.PedidoTabla;
import logica.Tipo;
import logica.ValorInsuficienteException;

/**
 * FXML Controller class
 *
 * @author Michael
 */
public class PedidoController implements Initializable {

    @FXML
    ComboBox<String> cbxTipo;
    @FXML
    ComboBox<String> cbxOrdenar;
    @FXML
    VBox contenedorMenu;
    @FXML
    TableView<PedidoTabla> tbvPedido;
    @FXML
    Label lblSubtotal;
    @FXML
    Label lblIva;
    @FXML
    Label lblTotal;
    @FXML
    VBox root;
    ObservableList<PedidoTabla> pedidos = FXCollections.observableArrayList();
    private double subtotal;
    private double iva;
    public static double total;
    public static Pedido pedido;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VBox.setVgrow(root, Priority.ALWAYS);
        String[] opciones = {"Plato fuerte", "Postre", "Bebida", "Piqueo"};
        cbxTipo.getItems().addAll(opciones);
        String[] tipos = {"Precio", "Nombre"};
        cbxOrdenar.getItems().addAll(tipos);
        TableColumn<PedidoTabla, String> descripcionColumn = new TableColumn<>("Descripción");
        descripcionColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcion()));
        descripcionColumn.setPrefWidth(150);

        TableColumn<PedidoTabla, String> cantidadColumn = new TableColumn<>("Cantidad");
        cantidadColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCantidad())));
        cantidadColumn.setPrefWidth(100);

        TableColumn<PedidoTabla, String> valorColumn = new TableColumn<>("Valor");
        valorColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrecio())));
        valorColumn.setPrefWidth(100);

        tbvPedido.getColumns().addAll(descripcionColumn, cantidadColumn, valorColumn);
        tbvPedido.setItems(pedidos);

        cbxTipo.addEventHandler(ActionEvent.ACTION, e -> {
            mostrarComida();

        });

    }

    private void mostrarComida() {
        if (cbxTipo.getSelectionModel().getSelectedItem() != null) {
            cbxOrdenar.setDisable(false);
            String tipo = (String) cbxTipo.getValue();
            switch (tipo) {
                case "Plato fuerte":
                    // Acciones para plato fuerte
                    contenedorMenu.getChildren().clear();
                    mostrarMenu(Tipo.F);
                    break;
                case "Postre":
                    // Acciones para postre
                    contenedorMenu.getChildren().clear();
                    mostrarMenu(Tipo.P);
                    break;
                case "Bebida":
                    // Acciones para bebida
                    contenedorMenu.getChildren().clear();
                    mostrarMenu(Tipo.B);
                    break;
                case "Piqueo":
                    // Acciones para piqueo
                    contenedorMenu.getChildren().clear();
                    mostrarMenu(Tipo.Q);
                    break;
                default:
                    // Acciones para cuando no se ha seleccionado ninguna opción
                    break;
            }

        }
    }

    @FXML
    public void continuar(ActionEvent event) throws IOException {
        if (!pedidos.isEmpty()) {
            ArrayList<PedidoTabla> listaPedidos = new ArrayList<>(pedidos);
            String idPedido = App.crearCodigoUnico();
            pedido = new Pedido(idPedido, listaPedidos, App.usuarioActual, null, subtotal, iva, total);
            String linea = pedido.getIdPedido() + "," + pedido.getCliente().getNombre() + " " + pedido.getCliente().getApellido() + "," + String.valueOf(pedido.getTotal());
            Archivos.escribirArchivo(App.pathFiles + "pedidos.txt", linea);
            try ( ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("pedido" + idPedido + ".bin"))) {
                ob.writeObject(pedido);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            App.cerrarVentana(event);
            App.cargarVentana("pago", 600, 400);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Seleccione alguna comida");
            alert.setHeaderText(null);
            alert.setContentText("Seleccione alguna comida");
            ButtonType continuar = new ButtonType("Aceptar");
            alert.getButtonTypes().setAll(continuar);
            alert.showAndWait();
        }
    }

    @FXML
    public void limpiar(ActionEvent event) {
        contenedorMenu.getChildren().clear();
        cbxTipo.setValue(null);
        cbxOrdenar.setDisable(true);
        lblSubtotal.setText("Subtotal: 0.00");
        lblIva.setText("IVA: 0.00");
        lblTotal.setText("Total: 0.00");
        pedidos.clear();
    }

    private void mostrarMenu(Tipo tipo) {
        Collections.sort(App.menu);
        for (Menu menu : App.menu) {
            if (menu.getTipo().equals(tipo)) {
                HBox contenedor = new HBox();
                Label descripcion = new Label(menu.getDescripcion());
                Label precio = new Label(String.valueOf(menu.getPrecio()));
                descripcion.setMinWidth(112);
                precio.setMinWidth(40);
                TextField cantidad = new TextField();
                cantidad.setMinWidth(54);
                Button botonAgregar = new Button("Agregar");
                botonAgregar.setMinWidth(80);
                contenedor.setSpacing(50);
                contenedor.getChildren().addAll(descripcion, precio, cantidad, botonAgregar);
                contenedorMenu.getChildren().add(contenedor);
                botonAgregar.addEventHandler(ActionEvent.ACTION, e -> {
                    if (!cantidad.getText().isBlank()) {
                        int unidades = Integer.parseInt(cantidad.getText());
                        if (unidades > 0) {
                            PedidoTabla pedido = new PedidoTabla(unidades, menu.getDescripcion(), menu.getPrecio(), menu.getTipo());
                            boolean actualizado = actualizarPedido(pedido);
                            if (!actualizado) {
                                pedidos.add(pedido);
                            }
                            ArrayList<PedidoTabla> listaPedidos = new ArrayList<>(pedidos);
                            subtotal = 0.0;
                            iva = 0.0;
                            total = 0.0;
                            if (!listaPedidos.isEmpty()) {
                                for (PedidoTabla pt : listaPedidos) {
                                    subtotal += pt.getPrecio() * pt.getCantidad();
                                }
                                iva += subtotal * 0.12;
                                total += (subtotal + iva);
                                DecimalFormat df = new DecimalFormat("#.##");
                                lblSubtotal.setText("Subtotal: " + String.valueOf(subtotal));
                                lblIva.setText("IVA: " + String.valueOf(iva));
                                lblTotal.setText("Total: " + df.format(total));
                            }

                        } else {
                            try {
                                throw new ValorInsuficienteException("Ingresar una cantidad válida");
                            } catch (ValorInsuficienteException ex) {
                                Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("Ingresar una cantidad válida");
                                alert.setHeaderText(null);
                                alert.setContentText("Por favor ingresa una cantidad válida");
                                ButtonType continuar = new ButtonType("Aceptar");
                                alert.getButtonTypes().setAll(continuar);
                                alert.showAndWait();
                            }
                        }
                    }
                });

            }
        }

    }

    private boolean actualizarPedido(PedidoTabla pedido) {

        for (PedidoTabla p : pedidos) {
            if (p.getDescripcion().equals(pedido.getDescripcion())) {
                p.setCantidad(pedido.getCantidad());
                tbvPedido.setItems(pedidos);
                tbvPedido.refresh();
                return true;
            }
        }
        return false;
    }

}

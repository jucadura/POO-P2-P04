package com.mycompany.restaurante;

import logica.Archivos;
import logica.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import logica.Local;
import logica.Menu;
import logica.Tipo;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static String pathFiles = "src/main/resources/files/";
    public static String pathImages = "src/main/resources/img/";
    public static ArrayList<Usuario> usuarios = llenarUsuarios();
    public static Usuario usuarioActual;
    public static ArrayList<Local>locales=llenarLocales();
    public static ArrayList<Menu>menu=llenarMenu();
    private static ArrayList<String> l_codigos = new ArrayList<>();
    public static Stage stagePago;

    
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"), 626, 417);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
        
    }

    /**
     * Método estático que carga la ventana que recibe como parámetro
     *
     * @param ventana
     * @param height
     * @param width
     */
    public static Stage cargarVentana(String ventana, int width, int height) {
        Scene scene = null;
        try {
            scene = new Scene(loadFXML(ventana), width, height);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        return stage;

    }

    public static void cerrarVentana(ActionEvent event) {
        Node source = (Node) event.getSource();     //Me devuelve el elemento al que hice click
        Stage stage = (Stage) source.getScene().getWindow();    //Me devuelve la ventana donde se encuentra el elemento
        stage.close();                          //Me cierra la ventana
    }

    private static ArrayList<Usuario> llenarUsuarios() {
        ArrayList<String[]> lineas = Archivos.generarArreglo(pathFiles+"usuarios.txt");
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        for (String[] linea : lineas) {
            listaUsuarios.add(new Usuario(linea[0], linea[1], linea[2], linea[3], linea[4], linea[5]));
        }
        return listaUsuarios;

    }
    public static Usuario verificarUsuario(ArrayList<Usuario>usuarios,String usuario,String contraseña){
        Usuario user=null;
        for(Usuario u:usuarios){
            if(u.getUsuario().equals(usuario)&&u.getContraseña().equals(contraseña)){
                user=u;
            }
        }
        return user;
    }
    private static ArrayList<Local> llenarLocales() {
        ArrayList<String[]> lineas = Archivos.generarArreglo(pathFiles+"locales.txt");
        ArrayList<Local> listaLocales = new ArrayList<>();
        for (String[] linea : lineas) {
            listaLocales.add(new Local(linea[0], Double.parseDouble(linea[1]), Double.parseDouble(linea[2]), linea[3], linea[4]));
        }
        return listaLocales;

    }
    private static ArrayList<Menu> llenarMenu() {
        ArrayList<String[]> lineas = Archivos.generarArreglo(pathFiles+"menu.txt");
        ArrayList<Menu> listaMenu = new ArrayList<>();
        for (String[] linea : lineas) {
            listaMenu.add(new Menu(linea[0], Double.parseDouble(linea[1]),Tipo.valueOf(linea[2])));
        }
        return listaMenu;

        
    }
    public static String crearCodigoUnico(){ // creacion de codigo unicos para permisos
        String cod = "";
        Random rd = new Random();
        for(int i=0;i<5;i++){
            int numero = rd.nextInt(10);
            String num = String.valueOf(numero);
            cod+=num;
        }
        while(l_codigos.contains(cod)){ // resive la variable cod la cual almacena el codigo creado
            String codg="";
            for(int i=0;i<5;i++){
                int numero = rd.nextInt(10);
                String num = String.valueOf(numero);
                codg+=num;
            }
            cod=codg;
        }
        l_codigos.add(cod);
        return cod;
    }
}

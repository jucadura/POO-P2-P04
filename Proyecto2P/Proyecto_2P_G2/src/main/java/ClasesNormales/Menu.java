/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesNormales;

import Enums.TipoPlato;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Menu {
    private String descripcion;
    private double precio;
    private TipoPlato tipo;
    
    public static ArrayList<Menu> cargarMenu(String string) {  //Debe retornar un arraylist de menu
        return null;
    }
    
    //En este metodo está la base para la opción 2
    //Se deben generar los puntos en la imagen poco a poco dentro del while mejor
    
    public static ArrayList<Menu> cargarSucursales(String string) {  //Debe retornar un arraylist de menu
        ArrayList<local> locales = new ArrayList<local>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("locales.txt", StandardCharsets.UTF_8));
            String line;
            while ((line = br.readLine()) != null) {
                String[] DatosSucursales = line.strip().split(",");
                String Nombre = DatosSucursales[0];
                String Direccion = DatosSucursales[1];
                String Horario = DatosSucursales[2];
                int CoordenadaX = Integer.parseInt(DatosSucursales[3]);
                int CoordenadaY = Integer.parseInt(DatosSucursales[3]);
                
                locales.add(new local(Nombre,Direccion,Horario,CoordenadaX,CoordenadaY));
                
            }
        } catch (IOException ex) {
            System.out.println("No existe el archivo buscado");
        }
        return null;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the tipo
     */
    public TipoPlato getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoPlato tipo) {
        this.tipo = tipo;
    }
}
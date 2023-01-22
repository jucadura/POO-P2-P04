/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesNormales;

import Enums.TipoPlato;
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
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Enums_Excepciones.TipoPlato;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Menu {

    private String descripcion;
    private double precio;
    private TipoPlato tipo;

    public Menu(String descripcion, double precio, TipoPlato tipo) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoPlato getTipo() {
        return tipo;
    }

    public void setTipo(TipoPlato tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Menu> cargarMenu(String v){
        return null;
    }
}

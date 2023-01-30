/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;


/**
 *
 * @author Michael
 */
public class PedidoTabla extends Menu implements Serializable{
    private int cantidad;

    public PedidoTabla(int cantidad, String descripcion, double precio, Tipo tipo) {
        super(descripcion, precio, tipo);
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}

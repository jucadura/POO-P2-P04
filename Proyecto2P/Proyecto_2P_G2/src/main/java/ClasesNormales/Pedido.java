/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesNormales;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import ClasesNormales.*;

/**
 *
 * @author Usuario
 */
public class Pedido implements Serializable{
    private ArrayList<String> opciones;
    private Cliente cliente;
    private String direccion;
    private double subTotal;
    private double Total;
    private double iva;
    private static int numero;
    public static void crearPedido(Pedido pedido){  //Debe crear un archivo
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        
        try {
            FileWriter escribir = new FileWriter("locales.txt", true);
            escribir.write(" ");
            
        } catch (IOException ex) {
            System.out.println("No existe el archivo buscado");
        }
        
    }

    /**
     * @return the opciones
     */
    public ArrayList<String> getOpciones() {
        return opciones;
    }

    /**
     * @param opciones the opciones to set
     */
    public void setOpciones(ArrayList<String> opciones) {
        this.opciones = opciones;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the subTotal
     */
    public double getSubTotal() {
        return subTotal;
    }

    /**
     * @param subTotal the subTotal to set
     */
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * @return the Total
     */
    public double getTotal() {
        return Total;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(double Total) {
        this.Total = Total;
    }

    /**
     * @return the iva
     */
    public double getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(double iva) {
        this.iva = iva;
    }

    /**
     * @return the numero
     */
    public static int getNumero() {
        return numero;
    }

    /**
     * @param aNumero the numero to set
     */
    public static void setNumero(int aNumero) {
        numero = aNumero;
    }
    
    
    
}

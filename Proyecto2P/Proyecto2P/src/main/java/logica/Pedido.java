/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Grupo2
 */
public class Pedido implements Serializable{
    private String idPedido;
    private ArrayList<PedidoTabla> pedidos;
    private Usuario cliente;
    private String direccionEntrega;
    private double subtotal;
    private double iva;
    private double total;

    public Pedido(String idPedido, ArrayList<PedidoTabla> pedidos, Usuario cliente, String direccionEntrega, double subtotal, double iva, double total) {
        this.idPedido = idPedido;
        this.pedidos = pedidos;
        this.cliente = cliente;
        this.direccionEntrega = direccionEntrega;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public ArrayList<PedidoTabla> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<PedidoTabla> pedidos) {
        this.pedidos = pedidos;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}

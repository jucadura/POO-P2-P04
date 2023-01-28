/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesNormales;

/**
 *
 * @author Usuario
 */
public class local {
    private String nombre;
    private String direccion;
    private String horario;
    private int CoordenadaX;
    private int CoordenadaY;
    
    public local(String nombre, String direccion,String horario,int CoordenadaX,int CoordenadaY){
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.CoordenadaX = CoordenadaX;
        this.CoordenadaY = CoordenadaY;
}

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @return the CoordenadaX
     */
    public int getCoordenadaX() {
        return CoordenadaX;
    }

    /**
     * @return the CoordenadaY
     */
    public int getCoordenadaY() {
        return CoordenadaY;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interno;

/**
 *
 * @author ingri
 */
public class Producto {
    private String nombre;
    private double precio;
    private int codigo; //Posicion que tenga el producto
    private int tipo; //1 = comida, 2 = limpieza

    public Producto(String nombre, double precio, int codigo, int tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
        this.tipo = tipo;
    }
    
    public Producto(String nombre, double precio, int codigo){
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
        this.tipo = 1;
    }
    
    public void verDescripcion(){
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Precio: " + this.getPrecio());
        if(this.getTipo() == 1) System.out.println("Tipo: Comida");
        else System.out.println("Tipo: Limpieza");
    }
    
    
    public void getDescripcion(){
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Precio: " + this.getPrecio());
        if(this.getTipo() == 1) System.out.println("Tipo: Comida");
        else System.out.println("Tipo: Limpieza");
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
    
}

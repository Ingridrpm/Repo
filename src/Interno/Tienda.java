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
public class Tienda {
    private String nombre;
    private Producto[] catalogo;

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.catalogo =  new Producto[20];
    }
    
    public boolean agregarProducto(String nombre, double precio, int tipo){
        int i = encontrarVacio();
        if(i == -1) return false;
        this.catalogo[i] = new Producto(nombre, precio, i, tipo);
        return true;
    }
    
    public void modifocarProducto(int codigo, String nombre, double precio, int tipo){
        this.catalogo[codigo].setNombre(nombre);
        this.catalogo[codigo].setPrecio(precio);
        this.catalogo[codigo].setTipo(tipo);
    }
    
    private int encontrarVacio(){
        for(int i = 0; i< this.catalogo.length; i++){
            if(this.catalogo[i]==null){
                return i;
            }
        }
        return -1;
    }
    
   public Object[][] getTable(){
       Object[][] tabla = new Object[20][4];
       for(int i = 0; i<tabla.length;i++){
            if(catalogo[i] == null) continue;
            tabla[i][0] = catalogo[i].getCodigo();
            tabla[i][1] = catalogo[i].getNombre();
            tabla[i][2] = catalogo[i].getPrecio();
            tabla[i][3] = catalogo[i].getTipo() == 1 ? "Comida" : "Limpieza";
       }
       return tabla;
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
     * @return the catalogo
     */
    public Producto[] getCatalogo() {
        return catalogo;
    }

    /**
     * @param catalogo the catalogo to set
     */
    public void setCatalogo(Producto[] catalogo) {
        this.catalogo = catalogo;
    }

    public void eliminarProducto(int indice) {
        catalogo[indice] = null;
    }
    
    public String[] elegirProducto(){
        String cadena = "";
        for(Producto p : catalogo){
            if(p == null) continue;
            cadena+=p.getCodigo() + " - " + p.getNombre() + "\n";
        }
        return cadena.split("\n");
    }
    
    public Producto getProducto(int indice){
        return catalogo[indice];
    }
    
}

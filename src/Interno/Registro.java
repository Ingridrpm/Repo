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
public class Registro {

    private Usuario[] usuarios;
    private Usuario maestro;
    
    public Registro(String nombre, String contrasena) {
        maestro = new Usuario(nombre,contrasena);
        usuarios = new Usuario[10];
    }
    
    public String getDatos(){
        String datos = "";
        for(Usuario user: usuarios){
            if(user==null) continue;
            datos+="Nombre:"+user.getNombre() + ", Contraseña: " + user.getPassword() + "\n";
        }
        return datos;
    }
    
    public Usuario validarCredenciales(String nombre, String contra){
        if(!existeUsuario(nombre)) return null;
        if(maestro.validarCredenciales(nombre, contra)) return maestro;
        for(Usuario usuario:usuarios){
            if(usuario==null)continue;
            if(usuario.validarCredenciales(nombre, contra)) return usuario;
        }
        return null;
    }
    
    public boolean agregarUsuario(String nombre, String contra){
        if(existeUsuario(nombre)) return false;
        for(int i = 0; i<getUsuarios().length;i++){
            if(getUsuarios()[i]==null){
                getUsuarios()[i] = new Usuario(nombre,contra);
                return true;
            }
        }
        return false;
    }
    
    public boolean existeUsuario(String nombre){
        if(getMaestro().getNombre().equalsIgnoreCase(nombre)) return true;
        for (Usuario usuario : getUsuarios()) {
            if(usuario==null)continue;
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean estaLleno(){
        for(Usuario usuario : getUsuarios()){
            if(usuario == null){
                return false;
            }
        }
        return true;
    }

    /**
     * @return the usuarios
     */
    public Usuario[] getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * @return the maestro
     */
    public Usuario getMaestro() {
        return maestro;
    }

    /**
     * @param maestro the maestro to set
     */
    public void setMaestro(Usuario maestro) {
        this.maestro = maestro;
    }
    
}

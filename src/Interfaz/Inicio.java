/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Interno.Usuario;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author ingri
 */
public class Inicio {
    
    JFrame ventanaPrincipal;
    ActionListener actionListener;
    JTextField txtNombreTienda;
    Usuario usuarioActual;
    
    public Inicio(Usuario usuarioActual){
        this.usuarioActual = usuarioActual;
        ventanaPrincipal = new JFrame();
        configurarVentana();
        agregarBienvenido();
        agregarUsuario();
        agregarNombreTienda();
        agregarBotonPrincipal();
    }

    private void configurarVentana() {
        ventanaPrincipal.setTitle("Crear Tienda");
        ventanaPrincipal.setSize(800,600);
        ventanaPrincipal.setVisible(true);
    	ventanaPrincipal.setLayout(null); //new FlowLayout()
        ventanaPrincipal.setLocationRelativeTo(null);
        //ventanaPrincipal.
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void agregarBienvenido() {
        JLabel lblBienvenido = new JLabel("Bienvenido!");
        lblBienvenido.setBounds(200,125,375,50); //x,y,width,heigth
    	lblBienvenido.setFont(new Font("Verdana", Font.PLAIN, 60)); 
    	lblBienvenido.setForeground(new Color(0, 0, 0));
    	ventanaPrincipal.add(lblBienvenido);
    }
    
    private void agregarUsuario() {
        JLabel lblBienvenido = new JLabel("User: " + this.usuarioActual.getNombre());
        lblBienvenido.setBounds(600,10,375,50); //x,y,width,heigth
    	lblBienvenido.setFont(new Font("Verdana", Font.PLAIN, 10)); 
    	lblBienvenido.setForeground(new Color(0, 0, 0));
    	ventanaPrincipal.add(lblBienvenido);
    }
    
    private void agregarNombreTienda() {
        txtNombreTienda = new JTextField("Ingrese nombre");
        txtNombreTienda.setBounds(200,200,375,50); //x,y,width,heigth
        ventanaPrincipal.add(txtNombreTienda);
        ventanaPrincipal.repaint();
    }
    
    private void agregarBotonPrincipal(){
        JButton btnPrincipal = new JButton("Crear tienda");
        btnPrincipal.setBounds(200,275,375,50);
        ventanaPrincipal.add(btnPrincipal);
        ventanaPrincipal.repaint();
        btnPrincipal.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             System.out.println("Nombre de la tienda: " + txtNombreTienda.getText());
             ventanaPrincipal.setVisible(false);
             new Tienda(usuarioActual, new Interno.Tienda(txtNombreTienda.getText()));
         }
        });
    }

}

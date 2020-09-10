/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ingri
 */
public class Registro extends JFrame implements ActionListener{

    JTextField txtUsuario;
    JPasswordField txtContra;
    JButton btnRegistrarse;
    Interno.Registro registro;
    
    public Registro(Interno.Registro registro){
        this.registro = registro;
        configurarVentana();
        addLabel(new JLabel(), "Registrarse", 50, 50, 400, 40, 30);
        addLabel(new JLabel(), "Nombre:", 100, 100, 200, 30, 15);
        txtUsuario = addTextField("", 350, 100, 200, 30);
        addLabel(new JLabel(), "Contraseña:", 100, 150, 200, 30, 15);
        txtContra = addPasswordField("", 350, 150, 200, 30);
        btnRegistrarse = addButton("Registrarse", 200,200,150,30);
    }
    
    private void configurarVentana() {
        this.setTitle("Registrarse");
        this.setSize(700, 300);//x,y
        this.setVisible(true);
        this.setLayout(null); //new FlowLayout()
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void addLabel(JLabel label, String texto, int x, int y, int ancho, int altura, int tamano) {
        label = new JLabel(texto);
        label.setBounds(x, y, ancho, altura); //x,y,width,heigth
        label.setFont(new Font("Verdana", Font.PLAIN, tamano));
        label.setForeground(new Color(0, 0, 0));
        add(label);
        repaint();
    }

    private JTextField addTextField(String texto, int x, int y, int ancho, int altura) {
        JTextField txt = new JTextField(texto);
        txt.setBounds(x, y, ancho, altura); //x,y,width,heigth
        txt.setForeground(new Color(0, 0, 0));
        add(txt);
        repaint();
        return txt;
    }
    
    private JPasswordField addPasswordField(String texto, int x, int y, int ancho, int altura) {
        JPasswordField txt = new JPasswordField(texto);
        txt.setBounds(x, y, ancho, altura); //x,y,width,heigth
        txt.setForeground(new Color(0, 0, 0));
        add(txt);
        repaint();
        return txt;
    }
    
    private JButton addButton(String texto, int x, int y, int ancho, int altura) {
        JButton btn = new JButton(texto);
        btn.setBounds(x,y,ancho,altura);
        add(btn);
        repaint();
        btn.addActionListener(this);
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == this.btnRegistrarse){
            if(this.registro.agregarUsuario(this.txtUsuario.getText(), this.txtContra.getText())){
                JOptionPane.showMessageDialog(this, "Registro exitoso");
                this.setVisible(false);
                System.out.println(this.registro.getDatos());
                new Login(this.registro);
                this.dispose();
            }else {
                JOptionPane.showMessageDialog(this, "Ya existe un usuario con este nombre, intente uno nuevo.");
            }
        }
    }
    
}

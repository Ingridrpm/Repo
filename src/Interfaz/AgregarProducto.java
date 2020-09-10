/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Interno.Usuario;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ingri
 */
public class AgregarProducto extends JFrame implements ActionListener{
    String nombre;
    Interno.Tienda tienda;
    JTextField txtNombre, txtPrecio;
    JComboBox cbTipo;
    Usuario usuarioActual;
    JButton btnAgregarProducto;

    public AgregarProducto(Usuario usuarioActual, Interno.Tienda tienda) {
        this.usuarioActual = usuarioActual;
        this.nombre = nombre;
        this.tienda = tienda;
        configurarVentana();
        addLabel(new JLabel(), "Agregar Producto", 50, 50, 400, 40, 30);
        addLabel(new JLabel(), "Nombre:", 100, 100, 200, 30, 15);
        txtNombre = addTextField("", 350, 100, 200, 30);
        addLabel(new JLabel(), "Precio:", 100, 150, 200, 30, 15);
        txtPrecio = addTextField("", 350, 150, 200, 30);
        addLabel(new JLabel(), "Tipo:", 100, 200, 200, 30, 15);
        String[] opciones = {"Comida", "Limpieza"};
        cbTipo = addComboBox(opciones, 350, 200, 200, 30);
        addButton("Agregar Producto",200,250,200,30);
    }

    private void configurarVentana() {
        setTitle(nombre);
        setSize(600, 400);//x,y
        setVisible(true);
        setLayout(null); //new FlowLayout()
        setLocationRelativeTo(null);
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

    private JComboBox addComboBox(String[] opciones, int x, int y, int ancho, int altura) {
        JComboBox cb = new JComboBox(opciones);
        cb.setSelectedIndex(0);
        cb.setBounds(x,y,ancho,altura);
        add(cb);
        repaint();
        return cb;
    }

    private void addButton(String texto, int x, int y, int ancho, int altura) {
        this.btnAgregarProducto = new JButton(texto);
        this.btnAgregarProducto.setBounds(x,y,ancho,altura);
        add(this.btnAgregarProducto);
        repaint();
        this.btnAgregarProducto.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == this.btnAgregarProducto){
            this.tienda.agregarProducto(txtNombre.getText(), Double.parseDouble(txtPrecio.getText()), cbTipo.getSelectedIndex()+1);
            setVisible(false);
            new Tienda(usuarioActual, tienda);
            this.dispose();
        }
    }


}

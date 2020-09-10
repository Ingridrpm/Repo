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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author ingri
 */
public class Tienda extends JFrame implements ActionListener {

    String nombre;
    Interno.Tienda tienda;
    JLabel lblNombreTienda;
    JButton btnAgregar, btnGenerarPDF, btnModificar, btnEliminar, btnLeerArchivo;
    JTable tblProductos;
    Usuario usuarioActual;

    public Tienda(Usuario usuarioActual, Interno.Tienda tienda) {
        this.usuarioActual = usuarioActual;
        this.tienda = tienda;
        this.nombre = tienda.getNombre();
        configurarVentana();
        addLabel(new JLabel(), this.usuarioActual.getNombre(), 600, 10, 375, 50, 15);
        addLabel(lblNombreTienda, this.nombre, 50, 50, 400, 40, 30);
        btnAgregar = botonAgregarProducto();
        btnModificar = addButton("Modificar Producto", 50, 475, 150, 50);
        btnEliminar = addButton("Eliminar Producto", 225,475,150,50);
        btnLeerArchivo = addButton("Leer archivo", 400,475,150,50);
        this.agregarTabla();
    }

    private void configurarVentana() {
        this.setTitle(this.nombre);
        this.setSize(800, 600);//x,y
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
        this.add(label);
    }

    private JButton botonAgregarProducto() {
        JButton btn = new JButton("Agregar Producto");
        btn.setBounds(600, 50, 150, 50);
        this.add(btn);
        this.repaint();
        btn.addActionListener(this);
        return btn;
    }

    public void agregarTabla() {
        String[] columnas = {"Codigo", "Nombre", "Precio", "Tipo"};
        Object[][] datos = this.tienda.getTable();
        tblProductos = new JTable(datos, columnas);
        JScrollPane sp = new JScrollPane(tblProductos);
        sp.setBounds(50, 100, 700, 350);
        this.add(sp);
        this.repaint();
    }

    private JButton addButton(String texto, int x, int y, int ancho, int altura) {
        JButton btn = new JButton(texto);
        btn.setBounds(x, y, ancho, altura);
        add(btn);
        repaint();
        btn.addActionListener(this);
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.btnAgregar) {
            new AgregarProducto(usuarioActual, tienda);
            this.dispose();
        }

        if (ae.getSource() == this.btnModificar) {
            String[] list = this.tienda.elegirProducto();
            JComboBox jcb = new JComboBox(list);
            jcb.setEditable(true);
            JOptionPane.showMessageDialog(null, jcb, "Seleccione un producto", JOptionPane.QUESTION_MESSAGE);
            int indiceSeleccionado = jcb.getSelectedIndex();
            String producto = list[indiceSeleccionado];
            String[] datosProducto = producto.split(" - ");
            int indice = Integer.parseInt(datosProducto[0]);
            new ModificarProducto(this.usuarioActual,this.tienda,indice);
            this.dispose();
        }
        
        if (ae.getSource() == this.btnEliminar) {
            int indice = this.tblProductos.getSelectedRow();
            this.tienda.eliminarProducto(indice);
            new Tienda(this.usuarioActual,this.tienda);
            this.dispose();
        }
        
        if (ae.getSource() == this.btnLeerArchivo) {
            String archivo = Archivos.leerArchivo(this);
            System.out.println("--------------");
            System.out.println(archivo);
            System.out.println("-------------");
        }

    }

}

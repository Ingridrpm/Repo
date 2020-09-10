/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ingri
 */
public class Archivos {

    public static String leerArchivo(JFrame componente) {
        String aux = "";
        String texto = "";
        try {
            /**
             * llamamos el metodo que permite cargar la ventana
             */
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(componente);
            /**
             * abrimos el archivo seleccionado
             */
            File archivo = file.getSelectedFile();

            /**
             * recorremos el archivo, lo leemos para plasmarlo en el area de
             * texto
             */
            if (archivo != null) {
                FileReader archivos = new FileReader(archivo);
                BufferedReader lee = new BufferedReader(archivos);
                while ((aux = lee.readLine()) != null) {
                    texto += aux + "\n";
                }
                lee.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "", JOptionPane.WARNING_MESSAGE);
        }
        return texto;
    }

}

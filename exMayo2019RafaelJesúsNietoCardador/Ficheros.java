package exMayo2019RafaelJesúsNietoCardador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


public class Ficheros {

  private JFrame frmCorrompeficheros;
  private JTextField ficheroOrigen;
  private JTextField ficheroDestino;
  private JButton btnNewButton_2;
  
  private File fOrigen;
  private File fDestino;
  private JScrollPane scrollPane;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Ficheros window = new Ficheros();
          window.frmCorrompeficheros.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public Ficheros() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmCorrompeficheros = new JFrame();
    frmCorrompeficheros.setResizable(false);
    frmCorrompeficheros.getContentPane().setBackground(new Color(0, 0, 0));
    frmCorrompeficheros.setTitle("Corrompe-Ficheros");
    frmCorrompeficheros.setBounds(100, 100, 652, 593);
    frmCorrompeficheros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmCorrompeficheros.getContentPane().setLayout(null);
    
    ficheroOrigen = new JTextField();
    ficheroOrigen.setEditable(false);
    ficheroOrigen.setBackground(new Color(153, 153, 153));
    ficheroOrigen.setBounds(18, 99, 242, 20);
    frmCorrompeficheros.getContentPane().add(ficheroOrigen);
    ficheroOrigen.setColumns(10);
    
    JLabel lblIntroduzcaElNombre = new JLabel("Ruta del fichero de origen");
    lblIntroduzcaElNombre.setForeground(new Color(0, 204, 0));
    lblIntroduzcaElNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblIntroduzcaElNombre.setBounds(55, 27, 173, 20);
    frmCorrompeficheros.getContentPane().add(lblIntroduzcaElNombre);
    
    ficheroDestino = new JTextField();
    ficheroDestino.setEditable(false);
    ficheroDestino.setColumns(10);
    ficheroDestino.setBackground(new Color(153, 153, 153));
    ficheroDestino.setBounds(384, 99, 242, 20);
    frmCorrompeficheros.getContentPane().add(ficheroDestino);
    
    /**
     * Botón Seleccionar archivo
     * Permite al usuario seleccionar un archivo del sistema y cambia el valor
     * del JTextField que tiene debajo
     */
    btnNewButton_2 = new JButton("Seleccionar archivo");
    btnNewButton_2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int fileC = fileChooser.showOpenDialog(frmCorrompeficheros);
        if (fileC == JFileChooser.APPROVE_OPTION) {
          fDestino = fileChooser.getSelectedFile();
          ficheroDestino.setText(fDestino.getAbsolutePath());
        }
      }
    });
    btnNewButton_2.setBounds(431, 59, 153, 28);
    frmCorrompeficheros.getContentPane().add(btnNewButton_2);
    
    JLabel lblRutaDelFichero = new JLabel("Ruta del fichero de destino");
    lblRutaDelFichero.setForeground(new Color(0, 204, 0));
    lblRutaDelFichero.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblRutaDelFichero.setBounds(411, 27, 229, 20);
    frmCorrompeficheros.getContentPane().add(lblRutaDelFichero);
    
    scrollPane = new JScrollPane();
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrollPane.setBounds(31, 242, 595, 307);
    frmCorrompeficheros.getContentPane().add(scrollPane);
    
    JTextArea textArea = new JTextArea();
    textArea.setEditable(false);
    scrollPane.setViewportView(textArea);
    
    /**
     * Botón Corromper
     * Modifica el contenido del segundo archivo introducido, sustituyéndolo por el
     * del primero y además modificando algunos de sus caráctes.
     */
    JButton btnNewButton = new JButton("C0RR0MP3R");
    btnNewButton.setForeground(new Color(0, 51, 0));
    btnNewButton.setBackground(new Color(153, 153, 153));
    btnNewButton.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 18));
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        try {
          String contenidoDocumentoC = "";
          BufferedReader br = new BufferedReader(new FileReader(ficheroOrigen.getText()));
          
          ArrayList<String> contenidoFichero= new ArrayList<String>();

          String linea = "";
          while (linea != null) {
            linea = br.readLine();
            if (linea != null) {
              contenidoFichero.add(linea);
            }
          }
          br.close();
          
          BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroDestino.getText()));
          linea = "";
          for(int i = 0; i < contenidoFichero.size(); i++) {
            bw.write(contenidoFichero.get(i).replace('A', '4').replace('a', '4').replace('B', '8').replace('b', '8').replace('E', '3').replace('I', '1').replace('i', '1').replace('O', '0').replace('o', '0').replace('S', '5').replace('s', '5').replace('T', '7').replace('t', '7'));  
            bw.newLine();
          }
          
          bw.close();
          
          BufferedReader br2 = new BufferedReader(new FileReader(ficheroDestino.getText()));
          
          while (linea != null) {
            linea = br2.readLine();
            if (linea != null) {
              contenidoDocumentoC = contenidoDocumentoC + linea + "\n";
            }
          }
          textArea.append(contenidoDocumentoC);
          
          br2.close();
          
          JOptionPane.showMessageDialog(null, "F1ch3r0 c0rr0mp1d0 c0rr3ct4m3nt3.");

        } catch (FileNotFoundException e) {
          JOptionPane.showMessageDialog(null, "Error, fichero no encontrado.");
        } catch (IOException e) {
          JOptionPane.showMessageDialog(null, "Error al leer el fichero.");
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Error en la entrada de datos.");
        }
      }
    });
    btnNewButton.setBounds(225, 164, 202, 59);
    frmCorrompeficheros.getContentPane().add(btnNewButton);
    
    /**
     * Botón Seleccionar archivo
     * Permite al usuario seleccionar un archivo del sistema y cambia el valor
     * del JTextField que tiene debajo
     */
    JButton btnNewButton_1 = new JButton("Seleccionar archivo");
    btnNewButton_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        JFileChooser fileChooser = new JFileChooser();
        int fileC = fileChooser.showOpenDialog(frmCorrompeficheros);
        if (fileC == JFileChooser.APPROVE_OPTION) {
          fOrigen = fileChooser.getSelectedFile();
          ficheroOrigen.setText(fOrigen.getAbsolutePath());
        }
      }
      
    });
    btnNewButton_1.setBounds(69, 59, 148, 28);
    frmCorrompeficheros.getContentPane().add(btnNewButton_1);
    
   
  }
  
}

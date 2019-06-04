package exMayo2019RafaelJesúsNietoCardador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Ficheros {

  private JFrame frmCorrompeficheros;
  private JTextField textField;
  private JTextField textField_1;

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
    frmCorrompeficheros.setBounds(100, 100, 631, 349);
    frmCorrompeficheros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmCorrompeficheros.getContentPane().setLayout(null);
    
    textField = new JTextField();
    textField.setBackground(new Color(153, 153, 153));
    textField.setBounds(35, 68, 223, 20);
    frmCorrompeficheros.getContentPane().add(textField);
    textField.setColumns(10);
    
    JLabel lblIntroduzcaElNombre = new JLabel("Introduzca el nombre del fichero a corromper");
    lblIntroduzcaElNombre.setForeground(new Color(0, 204, 0));
    lblIntroduzcaElNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblIntroduzcaElNombre.setBounds(10, 36, 285, 20);
    frmCorrompeficheros.getContentPane().add(lblIntroduzcaElNombre);
    
    JButton btnNewButton = new JButton("C0RR0MP3R");
    btnNewButton.setForeground(new Color(0, 51, 0));
    btnNewButton.setBackground(new Color(153, 153, 153));
    btnNewButton.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 18));
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        String nombreFichero = textField.getText();
        
        corrompeFichero(nombreFichero);
      }
    });
    btnNewButton.setBounds(46, 234, 202, 59);
    frmCorrompeficheros.getContentPane().add(btnNewButton);
    
    textField_1 = new JTextField();
    textField_1.setHorizontalAlignment(SwingConstants.LEFT);
    textField_1.setEditable(false);
    textField_1.setBackground(new Color(255, 255, 255));
    textField_1.setBounds(307, 23, 294, 256);
    frmCorrompeficheros.getContentPane().add(textField_1);
    textField_1.setColumns(10);
  }
  
  public void corrompeFichero(String nombreFichero) {
    try {
      BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\d17nicar\\eclipse-workspace\\Programacion2\\exMayo2019RafaelJesúsNietoCardador\\src\\exMayo2019RafaelJesúsNietoCardador\\Ficheros\\"
              + nombreFichero + ".txt"));
      
      ArrayList<String> contenidoFichero= new ArrayList<String>();

      String linea = "";
      while (linea != null) {
        linea = br.readLine();
        if (linea != null) {
          contenidoFichero.add(linea);
        }
      }
      br.close();
      
      String nombreFicheroC = nombreFichero.replace('A', '4').replace('a', '4').replace('B', '8').replace('b', '8').replace('E', '3').replace('I', '1').replace('i', '1').replace('O', '0').replace('o', '0').replace('S', '5').replace('s', '5').replace('T', '7').replace('t', '7');
      
      BufferedWriter bw = new BufferedWriter(new FileWriter( "C:\\Users\\d17nicar\\eclipse-workspace\\Programacion2\\exMayo2019RafaelJesúsNietoCardador\\src\\exMayo2019RafaelJesúsNietoCardador\\Ficheros\\"
          + nombreFicheroC+"C.txt"));
      linea = "";
      for(int i = 0; i < contenidoFichero.size(); i++) {
        bw.write(contenidoFichero.get(i).replace('A', '4').replace('a', '4').replace('B', '8').replace('b', '8').replace('E', '3').replace('I', '1').replace('i', '1').replace('O', '0').replace('o', '0').replace('S', '5').replace('s', '5').replace('T', '7').replace('t', '7'));  
        bw.newLine();
      }
      
      bw.close();
      
      BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\d17nicar\\eclipse-workspace\\Programacion2\\exMayo2019RafaelJesúsNietoCardador\\src\\exMayo2019RafaelJesúsNietoCardador\\Ficheros\\"
          + nombreFicheroC+"C.txt"));
      
      String contenidoDocumentoC = "";
      while (linea != null) {
        linea = br2.readLine();
        if (linea != null) {
          contenidoDocumentoC = contenidoDocumentoC + linea + "\n";
        }
      }
      textField_1.setText(contenidoDocumentoC);
      
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
}

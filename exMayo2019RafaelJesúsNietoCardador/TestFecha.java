package exMayo2019RafaelJesúsNietoCardador;

import java.util.Date;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TestFecha {
  
  Fecha fechaAlmacenada;
  private JFrame frmGestinFechas;
  private JTextField fechaIntroducida;
  private JTextField fechaHoy;
  
  java.util.Date hoy = new Date();
  String HOY = fechaIntACadena(hoy.getDate(),hoy.getMonth()+1, hoy.getYear()+1900);
  final static int [] DIAS_MES = {31,28,31,30,31,30,31,31,30,31,30,31}; 
  
  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          TestFecha window = new TestFecha();
          window.frmGestinFechas.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public TestFecha() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmGestinFechas = new JFrame();
    frmGestinFechas.setResizable(false);
    frmGestinFechas.setTitle("Gestión fechas");
    frmGestinFechas.setBounds(100, 100, 546, 300);
    frmGestinFechas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmGestinFechas.getContentPane().setLayout(null);
    
    JLabel lblIntroduzcaUnaFecha = new JLabel("Introduzca una fecha");
    lblIntroduzcaUnaFecha.setBounds(199, 11, 190, 20);
    frmGestinFechas.getContentPane().add(lblIntroduzcaUnaFecha);
    
    fechaIntroducida = new JTextField();
    fechaIntroducida.setBounds(199, 30, 126, 20);
    frmGestinFechas.getContentPane().add(fechaIntroducida);
    fechaIntroducida.setColumns(10);
    
    /**
     * Botón Validar Fecha
     * Muestra diferentes mensajes dependiendo de si la fecha introducida es válida o no
     */
    JButton btnNewButton = new JButton("Validar fecha");
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        try {  
          Fecha fecha = new Fecha(fechaIntroducida.getText());
          JOptionPane.showMessageDialog(null, "La fecha es válida.");
        }catch (FechaNoValidaException fnve) {
          JOptionPane.showMessageDialog(null, fnve.getMessage());
        }
      }
    });
    btnNewButton.setBounds(10, 95, 136, 72);
    frmGestinFechas.getContentPane().add(btnNewButton);
    
    /**
     * Botón Día Posterior
     * Aumenta un día a la fecha introducida
     */
    JButton btnSumarA = new JButton("Dia posterior");
    btnSumarA.setFont(new Font("Tahoma", Font.PLAIN, 11));
    btnSumarA.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          Fecha fecha = new Fecha(fechaIntroducida.getText());
          fecha.suma1DiaFecha();
          //fechaA.setText(fechaIntACadena(fechaAlmacenada.getDia(), fechaAlmacenada.getMes(),fechaAlmacenada.getAnho()));
          fecha.setFecha(fechaIntACadena(fecha.getDia(), fecha.getMes(),fecha.getAnho()));
          fechaIntroducida.setText(fecha.getFecha());
        } catch (FechaNoValidaException fnve) {
          JOptionPane.showMessageDialog(null, fnve.getMessage());
        } catch (NullPointerException ex) {
          JOptionPane.showMessageDialog(null, "Fecha no válida.");
        }
      }
    });
    btnSumarA.setBounds(144, 95, 132, 72);
    frmGestinFechas.getContentPane().add(btnSumarA);
    
    /**
     * Botón Día anterior
     * Resta un día a la fecha introducida
     */
    JButton btnRestarA = new JButton("Dia anterior");
    btnRestarA.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          Fecha fecha = new Fecha(fechaIntroducida.getText());
          fecha.resta1DiaFecha();
          fecha.setFecha(fechaIntACadena(fecha.getDia(), fecha.getMes(),fecha.getAnho()));
          fechaIntroducida.setText(fecha.getFecha());
        } catch (FechaNoValidaException fnve) {
          JOptionPane.showMessageDialog(null, fnve.getMessage());
        } catch (NullPointerException ex) {
          JOptionPane.showMessageDialog(null, "Fecha no válida.");
        }
      }
    });
    btnRestarA.setFont(new Font("Tahoma", Font.PLAIN, 11));
    btnRestarA.setBounds(275, 95, 114, 72);
    frmGestinFechas.getContentPane().add(btnRestarA);
    
    /**
     * Botón Días hasta hoy
     * Calcula los días que hay entre la fecha de hoy y la fecha introducida
     */
    JButton btnDiasHastaHoy = new JButton("Dias hasta hoy");
    btnDiasHastaHoy.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          Fecha fecha = new Fecha(fechaIntroducida.getText());
          JOptionPane.showMessageDialog(null, "Hay "+fecha.diasHastaHoy(HOY)+" días entre la fecha almacenada y la fecha de hoy.");
        }catch (ParseException |FechaNoValidaException ex) {
          JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (NullPointerException ex) {
          JOptionPane.showMessageDialog(null, "Fecha no válida.");
        }

      }
    });
    btnDiasHastaHoy.setFont(new Font("Tahoma", Font.PLAIN, 11));
    btnDiasHastaHoy.setBounds(385, 95, 143, 72);
    frmGestinFechas.getContentPane().add(btnDiasHastaHoy);
    
    JLabel lblFechaDeHoy = new JLabel("Fecha de hoy");
    lblFechaDeHoy.setBounds(226, 200, 146, 14);
    frmGestinFechas.getContentPane().add(lblFechaDeHoy);
    
    fechaHoy = new JTextField();
    fechaHoy.setEditable(false);
    fechaHoy.setBounds(226, 225, 86, 20);
    frmGestinFechas.getContentPane().add(fechaHoy);
    fechaHoy.setColumns(10);
    fechaHoy.setText(HOY);
  }
  /**
   * Pasándole un día, un mes y un año, devuelve una cadena válida de fecha
   * @param dia
   * @param mes
   * @param anho
   * @return fecha válida
   */
  public String fechaIntACadena (int dia, int mes, int anho) {
    String f = "";
    if(dia < 10) {
      f += "0"+dia+"/";
    }else{
      f += dia+"/";
    } if(mes < 10) {
      f +="0"+mes+"/";
    } else {
      f += mes+"/";
    }if(anho < 10) {
      f +="0"+anho;
    }else if(anho < 100) {
      f +="00"+anho;
    }else if(anho < 1000) {
      f +="000"+anho;
    }else {
      f += anho;
    }
    return f;
  }
}

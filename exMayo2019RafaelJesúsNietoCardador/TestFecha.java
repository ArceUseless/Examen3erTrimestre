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
  private JTextField textField;
  private JTextField textField_1;
  private JTextField textField_2;
  
  java.util.Date hoy = new Date();
  String HOY = fechaIntACadena(hoy.getDate(),hoy.getMonth()+1, hoy.getYear()+1900);
  
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
    
    textField = new JTextField();
    textField.setBounds(199, 30, 126, 20);
    frmGestinFechas.getContentPane().add(textField);
    textField.setColumns(10);
    
    textField_1 = new JTextField();
    textField_1.setEditable(false);
    textField_1.setBounds(78, 224, 86, 20);
    frmGestinFechas.getContentPane().add(textField_1);
    textField_1.setColumns(10);
    textField_1.setText("");
    
    JLabel lblFechaAlmacenada = new JLabel("Fecha almacenada");
    lblFechaAlmacenada.setBounds(66, 199, 156, 14);
    frmGestinFechas.getContentPane().add(lblFechaAlmacenada);
    
    JButton btnNewButton = new JButton("Validar fecha");
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        try {
          Fecha fecha = new Fecha(textField.getText());
          textField_1.setText(fecha.getFecha());
          fechaAlmacenada = fecha;
        }catch (FechaNoValidaException fnve) {
          JOptionPane.showMessageDialog(null, fnve.getMessage());
        }
      }
    });
    btnNewButton.setBounds(10, 95, 136, 72);
    frmGestinFechas.getContentPane().add(btnNewButton);
    
    JButton btnSumarA = new JButton("Dia posterior");
    btnSumarA.setFont(new Font("Tahoma", Font.PLAIN, 11));
    btnSumarA.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          fechaAlmacenada.suma1DiaFecha();
          textField_1.setText(fechaIntACadena(fechaAlmacenada.getDia(), fechaAlmacenada.getMes(),fechaAlmacenada.getAnho()));
          fechaAlmacenada.setFecha(fechaIntACadena(fechaAlmacenada.getDia(), fechaAlmacenada.getMes(),fechaAlmacenada.getAnho()));
        } catch (FechaNoValidaException fnve) {
          JOptionPane.showMessageDialog(null, fnve.getMessage());
        } catch (NullPointerException ex) {
          JOptionPane.showMessageDialog(null, "Fecha no validada.");
        }
      }
    });
    btnSumarA.setBounds(144, 95, 132, 72);
    frmGestinFechas.getContentPane().add(btnSumarA);
    
    JButton btnRestarA = new JButton("Dia anterior");
    btnRestarA.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          fechaAlmacenada.resta1DiaFecha();
          textField_1.setText(fechaIntACadena(fechaAlmacenada.getDia(), fechaAlmacenada.getMes(),fechaAlmacenada.getAnho()));
          fechaAlmacenada.setFecha(fechaIntACadena(fechaAlmacenada.getDia(), fechaAlmacenada.getMes(),fechaAlmacenada.getAnho()));
        } catch (FechaNoValidaException  ex) {
          JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (NullPointerException ex) {
          JOptionPane.showMessageDialog(null, "Fecha no validada.");
        }
      }
    });
    btnRestarA.setFont(new Font("Tahoma", Font.PLAIN, 11));
    btnRestarA.setBounds(275, 95, 114, 72);
    frmGestinFechas.getContentPane().add(btnRestarA);
    

    
    JButton btnDiasHastaHoy = new JButton("Dias hasta hoy");
    btnDiasHastaHoy.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          JOptionPane.showMessageDialog(null, "Hay "+fechaAlmacenada.diasHastaHoy(HOY)+" días entre la fecha almacenada y la fecha de hoy.");
          
        } catch (ParseException ex) {
          JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (NullPointerException ex) {
          JOptionPane.showMessageDialog(null, "Fecha no validada.");
        }

      }
    });
    btnDiasHastaHoy.setFont(new Font("Tahoma", Font.PLAIN, 11));
    btnDiasHastaHoy.setBounds(385, 95, 143, 72);
    frmGestinFechas.getContentPane().add(btnDiasHastaHoy);
    
    JLabel lblFechaDeHoy = new JLabel("Fecha de hoy");
    lblFechaDeHoy.setBounds(369, 199, 146, 14);
    frmGestinFechas.getContentPane().add(lblFechaDeHoy);
    
    textField_2 = new JTextField();
    textField_2.setEditable(false);
    textField_2.setBounds(369, 224, 86, 20);
    frmGestinFechas.getContentPane().add(textField_2);
    textField_2.setColumns(10);
    textField_2.setText(HOY);
  }
  
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

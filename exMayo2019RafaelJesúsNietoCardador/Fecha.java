package exMayo2019RafaelJesúsNietoCardador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {
  private int dia;
  private int mes;
  private int anho;
  String fecha;
  
  final static int [] DIAS_MES = {31,28,31,30,31,30,31,31,30,31,30,31}; 
  
  public Fecha(String fecha) throws FechaNoValidaException {
    setFecha(fecha);
    setAnho(Integer.parseInt(fecha.substring(6)));
    setMes(Integer.parseInt(fecha.substring(3,5)));
    setDia(Integer.parseInt(fecha.substring(0, 2)));
  }
  
  public Fecha(int dia, int mes, int anho) throws FechaNoValidaException {
    setAnho(anho);
    setMes(mes);
    setDia(dia);
  }
  
  private void setMes(int mes) throws FechaNoValidaException {
    if (mes<1 || mes>12) {
      throw new FechaNoValidaException("ERROR: El mes introducido no es válido.");
    }
    this.mes = mes;
    
  }
  
  private void setDia(int dia) throws FechaNoValidaException {
    int diasmes = DIAS_MES[mes-1];
    if (mes==2 && this.anho%4==0 && (this.anho%100!=0 || this.anho%400==0)) {
      diasmes++;
    }
    if (dia > diasmes || dia <1) {
      throw new FechaNoValidaException("ERROR: El dia introducido no es válido.");
    }
    this.dia = dia;

  }
  
  private void setAnho(int anho) throws FechaNoValidaException {
    if (anho > 9999 || anho < 1) {
      throw new FechaNoValidaException("ERROR: El año introducido no es válido.");
    }
    this.anho = anho;
  }
  
  public void setFecha(String fecha) throws FechaNoValidaException{
    // comprobar que es un formato dd/mm/aaaa
    if (fecha.length()!=10  || !Character.isDigit(fecha.charAt(0)) || !Character.isDigit(fecha.charAt(1)) || !Character.isDigit(fecha.charAt(3))
                        || !Character.isDigit(fecha.charAt(4)) || !Character.isDigit(fecha.charAt(6)) || !Character.isDigit(fecha.charAt(7))
                        || !Character.isDigit(fecha.charAt(8)) || !Character.isDigit(fecha.charAt(9))
                        || fecha.charAt(2)!='/' || fecha.charAt(5)!='/') {
      throw new FechaNoValidaException("ERROR: La fecha introducida no es válida.");
    }
    this.fecha = fecha;
  }
  
  public String getFecha() {
    return this.fecha;
  }
  
  public int getDia() {
    return this.dia;
  }

  public int getMes() {
    return this.mes;
  }

  public int getAnho() {
    return this.anho;
  }

  public static boolean validarFecha(String f) {
    if (f.length() != 10 || !Character.isDigit(f.charAt(0)) || !Character.isDigit(f.charAt(1))
        || !Character.isDigit(f.charAt(3)) || !Character.isDigit(f.charAt(4)) || !Character.isDigit(f.charAt(6))
        || !Character.isDigit(f.charAt(7)) || !Character.isDigit(f.charAt(8)) || !Character.isDigit(f.charAt(9))
        || f.charAt(2) != '/' || f.charAt(5) != '/') {
      return false;
    }
    int mes = Integer.parseInt(f.substring(3, 5));
    if (mes < 1 || mes > 12) {
      return false;
    }
    int dia = Integer.parseInt(f.substring(0, 2));
    int anho = Integer.parseInt(f.substring(6));
    int diasmes = DIAS_MES[mes - 1];
    if (mes == 2 && anho % 4 == 0 && (anho % 100 != 0 || anho % 400 == 0)) {
      diasmes++;
    }
    return (dia > 0 && dia <= diasmes);
  }
  
  public void suma1DiaFecha() throws FechaNoValidaException {
    int dia = Integer.parseInt(this.fecha.substring(0, 2));
    int mes = Integer.parseInt(this.fecha.substring(3, 5));
    int anho = Integer.parseInt(this.fecha.substring(6));
    
    int diasmes = DIAS_MES[mes-1];
    // ¿febrero y año bisisesto?
    if (mes==2 && anho%4==0 && (anho%100!=0 || anho%400==0)) {
      diasmes++;
    }
    dia++;
    if (dia>diasmes) {
      dia = 1;
      mes++;
      if (mes==13) {
        mes = 1;
        anho++;
      }
    }
    setDia(dia);
    setMes(mes);
    setAnho(anho);
    
  }
  public void resta1DiaFecha() throws FechaNoValidaException {
    int dia = Integer.parseInt(this.fecha.substring(0, 2));
    int mes = Integer.parseInt(this.fecha.substring(3, 5));
    int anho = Integer.parseInt(this.fecha.substring(6));
    
    dia--;
    if (dia==0) { // mes anterior
      mes--;
      if (mes==0) { // año anterior
        mes=12;
        anho--;
      } 
      dia = DIAS_MES[mes-1];
      // ¿febrero y año bisisesto?
      if (mes==2 && anho%4==0 && (anho%100!=0 || anho%400==0)) {
        dia++;
      }
    }
    setDia(dia);
    setMes(mes);
    setAnho(anho);
  }
  
  public int diasHastaHoy(String fH) throws ParseException {
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date fecha=dateFormat.parse(getFecha());
    Date fechaHoy=dateFormat.parse(fH);
    
    int dias = (int) ((fechaHoy.getTime() - fecha.getTime())/ 86400000);
    return Math.abs(dias);

}
  @Override
  public String toString() {
    return this.fecha;
  }

  

}

package exMayo2019RafaelJesúsNietoCardador;

public class Fecha {
  private int dia;
  private int mes;
  private int anho;
  String fecha;
  
  final static int [] DIAS_MES = {31,28,31,30,31,30,31,31,30,31,30,31}; 
  
  public Fecha(String fecha) throws FechaNoValidaException {
    setFecha(fecha); 
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
  
  private void setFecha(String fecha) throws FechaNoValidaException{
    // comprobar que es un formato dd/mm/aaaa
    if (fecha.length()!=10  || !Character.isDigit(fecha.charAt(0)) || !Character.isDigit(fecha.charAt(1)) || !Character.isDigit(fecha.charAt(3))
                        || !Character.isDigit(fecha.charAt(4)) || !Character.isDigit(fecha.charAt(6)) || !Character.isDigit(fecha.charAt(7))
                        || !Character.isDigit(fecha.charAt(8)) || !Character.isDigit(fecha.charAt(9))
                        || fecha.charAt(2)!='/' || fecha.charAt(5)!='/') {
      throw new FechaNoValidaException("ERROR: La fecha introducida no es válida.");
    }
    setAnho(Integer.parseInt(fecha.substring(6)));
    setMes(Integer.parseInt(fecha.substring(3,5)));
    setDia(Integer.parseInt(fecha.substring(0, 2)));
    this.fecha = fecha;
  }

  public String suma1DiaFecha() throws FechaNoValidaException {
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
    setFecha(f);
    return f;
  }
  
  public String resta1DiaFecha() throws FechaNoValidaException {
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
    
    setFecha(f);
    return f;
}
  @Override
  public String toString() {
    return this.fecha;
  }

  

}

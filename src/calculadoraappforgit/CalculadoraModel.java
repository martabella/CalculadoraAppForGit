/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraappforgit;

/**
 *
 * @author mbella
 */
public class CalculadoraModel {
    
  private float display;
  private float acumulador;
  private int operador; 
  private boolean rewrite = true;

  private static final int NADA = 0;
  public static final int SUMA = 1;
  public static final int RESTA = 2;
  public static final int MULTIPLICA = 3;
  public static final int DIVIDE = 4;
  private static final int IGUAL = 5;
  
  
  public CalculadoraModel() {
    reset();
  }

  public void reset() {
    display = 0;
    acumulador = 0;
    operador = CalculadoraModel.NADA;
  }
  
  public float getDisplay() {
    return display;
  }

  public void setNumber(int n) {
    if (rewrite) { display=0; rewrite = false; }
    display = display*10 + n;
  }
   
  public void setOperation(int op) {
    updateValue(op);
    operador = op;
    rewrite = true;
  }
    
  public void result() {
    updateValue(CalculadoraModel.IGUAL);
    operador = CalculadoraModel.NADA;
    rewrite = true;
  }
    
  private void updateValue(int op) {
    switch (operador){
      case CalculadoraModel.NADA: acumulador = display; break;
      case CalculadoraModel.SUMA: acumulador = acumulador + display; break;
      case CalculadoraModel.RESTA: acumulador = acumulador - display; break;
      case CalculadoraModel.MULTIPLICA: acumulador = acumulador * display; break;
      case CalculadoraModel.DIVIDE: acumulador = acumulador / display; break;
    }
    display = acumulador;     
  }
    
}

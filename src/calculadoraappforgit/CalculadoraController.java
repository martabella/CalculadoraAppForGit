/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraappforgit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *Nuevos comentarios By Student
 * @author mbella
 */
public class CalculadoraController implements ActionListener{
    
    private CalculadoraModel model;
    private CalculadoraView view;

    public CalculadoraController(CalculadoraModel model, CalculadoraView view) {
        this.model = model;
        this.view = view;
        
        //Add listeners to the view
        this.view.addListeners(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        for (JButton button : view.getButtons()){
            
            if (button == ae.getSource()){
                System.out.println(button.getText());
            
                switch (button.getText()){
                    case "+": 
                        model.setOperation(model.SUMA);
                        break;
                    case "-": 
                        model.setOperation(model.RESTA);
                        break;
                    case "*": 
                        model.setOperation(model.MULTIPLICA);
                        break;
                    case "/": 
                        model.setOperation(model.DIVIDE);
                        break;
                    case "C": 
                        model.reset();
                        break;
                    case "=": 
                        model.result();
                        break;
                    default: //Numero 0-9
                        model.setNumber(Integer.parseInt(button.getText()));
                }
                
                view.setValueToDisplay(Float.toString(model.getDisplay()));
                break;
            }
        
        }
    }
    
}

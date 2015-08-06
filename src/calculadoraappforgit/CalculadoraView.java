package calculadoraappforgit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Interfaz gráfica que muestra una calculadora con las operaciones +, -, * y /
 * @author mbella
 */
public class CalculadoraView extends JFrame{
    
    //Model
    private CalculadoraModel model;
    
    
    private JLabel display;
    private JButton[] buttons;

    public CalculadoraView(CalculadoraModel model) {
        this.model = model;
    //Create and set up the window.
      this.setTitle("Calculadora");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Set up the content pane.
      addComponentsToPane(this.getContentPane());
      this.setResizable(false);
      //Display the window.
      this.pack();
      this.setVisible(true);
    }
    
    void addComponentsToPane(Container pane) {
    
            
        pane.setLayout(new BorderLayout(8, 8));

        //Display JLabel
        display = new JLabel("");
        display.setHorizontalAlignment(SwingConstants.RIGHT);
	display.setOpaque(true);
	display.setBackground(Color.WHITE); 
	pane.add(display, BorderLayout.NORTH);

        //JPanel buttons
        JPanel buttonsPanel = new JPanel(new GridLayout(4, 4));
        String[] values = {"7","8","9","+","4","5","6","-","1","2","3","*","0","C","=","/"};
        buttons = new JButton[values.length];
        for (int i=0;i<values.length;i++) {
          buttons[i] = new JButton(values[i]);
          buttons[i].setPreferredSize(new Dimension(50,40));
          buttonsPanel.add(buttons[i]);
        }
        pane.add(buttonsPanel, BorderLayout.CENTER);
    }
    
    public JButton[] getButtons() {
        return buttons;
    }

    public void setValueToDisplay(String value){
        this.display.setText(value);
    }
    
    public void addListeners(CalculadoraController controller){
        for (JButton button : buttons){
            button.addActionListener(controller);
        }

    }
    
}

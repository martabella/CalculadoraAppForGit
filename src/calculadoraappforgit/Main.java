package calculadoraappforgit;

/**
 *
 * @author mbella
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CalculadoraModel model = new CalculadoraModel();
        CalculadoraView view = new CalculadoraView(model);
        CalculadoraController controller = new CalculadoraController(model, view);
    }
    
}

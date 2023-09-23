
/**
 *
 * @author Arthur Felipe MS
 */

public class Main {
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new JanelaTeste().setVisible(true);
            //Mudar depois para TelaPrincipal
        }
        });
    }
}
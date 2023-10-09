package Telas;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 *
 * @author Arthur Felipe MS
 */
public class TelaSecundaria extends javax.swing.JFrame{
    private javax.swing.JTextPane SaidaDasInformacoes;
    private javax.swing.JScrollPane jScrollPane1;
    private TelaPrincipal telaPrincipal;
    
    public TelaSecundaria(TelaPrincipal telaPrincipal, String texto) {
        this.telaPrincipal = telaPrincipal;       
        this.initComponents();        
        this.setTexto(texto);
        setLocationRelativeTo(null);
        setResizable(false);
        SaidaDasInformacoes.setEditable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                fecharJanelaSecundaria();
            }
        });
    }
  
    @SuppressWarnings("unchecked")                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        SaidaDasInformacoes = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Informações");

        jScrollPane1.setToolTipText("");
        jScrollPane1.setViewportView(SaidaDasInformacoes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }
    
    private void setTexto(String texto){
        try {
            Document doc = SaidaDasInformacoes.getDocument();
            doc.insertString(doc.getLength(), texto, null);
        } catch (BadLocationException ex) {
            Logger.getLogger(TelaSecundaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void fecharJanelaSecundaria() {
        dispose();
        this.telaPrincipal.setVisible(true);
    }
    
    
}

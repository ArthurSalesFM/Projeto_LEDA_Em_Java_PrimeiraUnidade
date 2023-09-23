
package Telas;
import CSV.ArquivoCSV;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Gasparzinho
 */
public class TelaPrincipal extends javax.swing.JFrame{
    
    private javax.swing.JButton BotaoIniciar;
    private javax.swing.JButton CancelarProcesso;
    private javax.swing.JButton GerarRelatorio;
    private javax.swing.JMenuBar MenuPrincipal;
    private javax.swing.JPanel PainelPrincipal;
    private javax.swing.JTextPane SaidaInformacoes;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    
    public TelaPrincipal(){
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    private void initComponents() {

        PainelPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        GerarRelatorio = new javax.swing.JButton();
        CancelarProcesso = new javax.swing.JButton();
        BotaoIniciar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        SaidaInformacoes = new javax.swing.JTextPane();
        MenuPrincipal = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arthur Felipe MS - LEDA");

        PainelPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GerarRelatorio.setText("Gerar Relatório");

        CancelarProcesso.setText("Cancelar Processo");
        CancelarProcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarProcessoActionPerformed(evt);
            }
        });

        BotaoIniciar.setText("Iniciar");
        BotaoIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(BotaoIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(CancelarProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(GerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotaoIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(GerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CancelarProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(SaidaInformacoes);

        javax.swing.GroupLayout PainelPrincipalLayout = new javax.swing.GroupLayout(PainelPrincipal);
        PainelPrincipal.setLayout(PainelPrincipalLayout);
        PainelPrincipalLayout.setHorizontalGroup(
            PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PainelPrincipalLayout.setVerticalGroup(
            PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Menu");

        jMenu3.setText("Informações");

        jMenuItem2.setText("Gerais");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("Projeto (Passwords)");
        jMenu3.add(jMenuItem3);

        jMenu1.add(jMenu3);
        jMenu1.add(jSeparator1);

        jMenu4.setText("Algorítmos");

        jMenuItem1.setText("Counting Sort");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem4.setText("Heap Sort");
        jMenu4.add(jMenuItem4);

        jMenuItem5.setText("Insertion Sort");
        jMenu4.add(jMenuItem5);

        jMenuItem6.setText("Merge Sort");
        jMenu4.add(jMenuItem6);

        jMenuItem7.setText("Q.S c/ Mediana de 3");
        jMenu4.add(jMenuItem7);

        jMenuItem8.setText("Quick Sort");
        jMenu4.add(jMenuItem8);

        jMenuItem9.setText("Selection Sort");
        jMenu4.add(jMenuItem9);

        jMenu1.add(jMenu4);

        MenuPrincipal.add(jMenu1);

        setJMenuBar(MenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void CancelarProcessoActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void BotaoIniciarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        ArquivoCSV ar = new ArquivoCSV();
    StringBuilder texto = new StringBuilder();
    String nomeDoArquivo = "passwords.csv"; // Nome do arquivo a ser lido
    
    // Verifica se o arquivo existe
    if (!new File("src/main/java/ArquivoBaseCSV/" + nomeDoArquivo).exists()) {
        JOptionPane.showMessageDialog(this, "O arquivo " + nomeDoArquivo + " não foi encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        return; // Sai do método se o arquivo não existir
    }
    
    texto.append("Iniciando o Processo...\n"); 
    SaidaInformacoes.setText(texto.toString());
    
    String saidas[] = ar.lerArquivoCSV(nomeDoArquivo);       
    
    texto.append("Criando o Arquivo teste...\n");
    // Defina o texto na caixa de texto SaidaInformacoes
    SaidaInformacoes.setText(texto.toString());        
    
    nomeDoArquivo = "teste.csv";
    ar.criarArquivoCSV(nomeDoArquivo, saidas);
    texto.append("Arquivo "+ nomeDoArquivo + " criado...\n");
    SaidaInformacoes.setText(texto.toString());
    }
    
}

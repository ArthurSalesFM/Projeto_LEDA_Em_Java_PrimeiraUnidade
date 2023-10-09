package Telas;

import Fachada.Fachada;
import InfoSistema.InfoDoSistema;

/**
 *
 * @author Arthur Felipe MS
 */
public class TelaPrincipal extends javax.swing.JFrame {
    
    private javax.swing.JMenu Algoritmos;
    private javax.swing.JButton BotaoIniciar;
    private javax.swing.JButton GerarRelatorio;
    private javax.swing.JMenuItem InfoGeral;
    private javax.swing.JMenu Informacoes;
    private javax.swing.JMenuItem MenuCountingSort;
    private javax.swing.JMenu MenuGeralProjeto;
    private javax.swing.JMenuItem MenuHeapSort;
    private javax.swing.JMenuItem MenuInsertionSort;
    private javax.swing.JMenuItem MenuMergeSort;
    private javax.swing.JMenuBar MenuPrincipal;
    private javax.swing.JMenuItem MenuQScMedianade3;
    private javax.swing.JMenuItem MenuQuickSort;
    private javax.swing.JMenuItem MenuSelectionSort;
    private javax.swing.JPanel PainelPrincipal;
    private javax.swing.JMenuItem ProjetoPasswords;
    private javax.swing.JTextPane SaidaInformacoes;
    private javax.swing.JMenuItem SobreOAutor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private TelaSecundaria secundaria;
    private InfoDoSistema infoSis;
    private Fachada fachada;

    public TelaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        infoSis =  new InfoDoSistema();
        GerarRelatorio.setEnabled(false);
        SaidaInformacoes.setEditable(false);
        fachada = new Fachada();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
    @SuppressWarnings("unchecked")                         
    private void initComponents() {

        PainelPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        GerarRelatorio = new javax.swing.JButton();
        BotaoIniciar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        SaidaInformacoes = new javax.swing.JTextPane();
        MenuPrincipal = new javax.swing.JMenuBar();
        MenuGeralProjeto = new javax.swing.JMenu();
        Informacoes = new javax.swing.JMenu();
        InfoGeral = new javax.swing.JMenuItem();
        ProjetoPasswords = new javax.swing.JMenuItem();
        SobreOAutor = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        Algoritmos = new javax.swing.JMenu();
        MenuCountingSort = new javax.swing.JMenuItem();
        MenuHeapSort = new javax.swing.JMenuItem();
        MenuInsertionSort = new javax.swing.JMenuItem();
        MenuMergeSort = new javax.swing.JMenuItem();
        MenuQScMedianade3 = new javax.swing.JMenuItem();
        MenuQuickSort = new javax.swing.JMenuItem();
        MenuSelectionSort = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arthur Felipe Muniz Sales - LEDA - UEPB");
        setResizable(false);

        PainelPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GerarRelatorio.setText("Gerar Relatório");
        GerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GerarRelatorioActionPerformed(evt);
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
                .addGap(120, 120, 120)
                .addComponent(BotaoIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
                .addComponent(GerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(SaidaInformacoes);

        javax.swing.GroupLayout PainelPrincipalLayout = new javax.swing.GroupLayout(PainelPrincipal);
        PainelPrincipal.setLayout(PainelPrincipalLayout);
        PainelPrincipalLayout.setHorizontalGroup(
            PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        PainelPrincipalLayout.setVerticalGroup(
            PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        MenuPrincipal.setToolTipText("AAAAA");

        MenuGeralProjeto.setText("Projeto");

        Informacoes.setText("Informações");

        InfoGeral.setText("Gerais");
        InfoGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfoGeralActionPerformed(evt);
            }
        });
        Informacoes.add(InfoGeral);

        ProjetoPasswords.setText("Projeto (Passwords)");
        ProjetoPasswords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProjetoPasswordsActionPerformed(evt);
            }
        });
        Informacoes.add(ProjetoPasswords);

        SobreOAutor.setText("Sobre o Autor");
        SobreOAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SobreOAutorActionPerformed(evt);
            }
        });
        Informacoes.add(SobreOAutor);

        MenuGeralProjeto.add(Informacoes);
        MenuGeralProjeto.add(jSeparator1);

        Algoritmos.setText("Algorítmos");

        MenuCountingSort.setText("Counting Sort");
        MenuCountingSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCountingSortActionPerformed(evt);
            }
        });
        Algoritmos.add(MenuCountingSort);

        MenuHeapSort.setText("Heap Sort");
        MenuHeapSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuHeapSortActionPerformed(evt);
            }
        });
        Algoritmos.add(MenuHeapSort);

        MenuInsertionSort.setText("Insertion Sort");
        MenuInsertionSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuInsertionSortActionPerformed(evt);
            }
        });
        Algoritmos.add(MenuInsertionSort);

        MenuMergeSort.setText("Merge Sort");
        MenuMergeSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuMergeSortActionPerformed(evt);
            }
        });
        Algoritmos.add(MenuMergeSort);

        MenuQScMedianade3.setText("Q.S c/ Mediana de 3");
        MenuQScMedianade3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuQScMedianade3ActionPerformed(evt);
            }
        });
        Algoritmos.add(MenuQScMedianade3);

        MenuQuickSort.setText("Quick Sort");
        MenuQuickSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuQuickSortActionPerformed(evt);
            }
        });
        Algoritmos.add(MenuQuickSort);

        MenuSelectionSort.setText("Selection Sort");
        MenuSelectionSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSelectionSortActionPerformed(evt);
            }
        });
        Algoritmos.add(MenuSelectionSort);

        MenuGeralProjeto.add(Algoritmos);

        MenuPrincipal.add(MenuGeralProjeto);

        setJMenuBar(MenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void InfoGeralActionPerformed(java.awt.event.ActionEvent evt) {                                          
        AtivadesativaTela(false);        
        secundaria = new TelaSecundaria(this,infoSis.infoGeral());
        secundaria.setVisible(true);        
    }                                         
    
    private void GerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {                                               
        AtivadesativaTela(false);        
        secundaria = new TelaSecundaria(this, fachada.informacoesDaMatriz());
        secundaria.setVisible(true);
        BotaoIniciar.setEnabled(true);
        GerarRelatorio.setEnabled(true);
    }
    
    private void MenuCountingSortActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        AtivadesativaTela(false);        
        secundaria = new TelaSecundaria(this,infoSis.infoCountingSort());
        secundaria.setVisible(true);
    }                                                

    private void BotaoIniciarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        //this.desativaBotoes();
        SaidaInformacoes.setText(null);              
        fachada.iniciarProcesso(SaidaInformacoes, BotaoIniciar, GerarRelatorio, MenuGeralProjeto);
        //this.ativaBotoes();
    }                                            

    private void SobreOAutorActionPerformed(java.awt.event.ActionEvent evt) {                                            
        AtivadesativaTela(false);        
        secundaria = new TelaSecundaria(this,infoSis.infoSobreAutor());
        secundaria.setVisible(true);
    }                                           

    private void ProjetoPasswordsActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        AtivadesativaTela(false);        
        secundaria = new TelaSecundaria(this,infoSis.infoProjetoSenhas());
        secundaria.setVisible(true);
    }                                                

    private void MenuHeapSortActionPerformed(java.awt.event.ActionEvent evt) {                                             
        AtivadesativaTela(false);        
        secundaria = new TelaSecundaria(this,infoSis.infoHeapSort());
        secundaria.setVisible(true);
    }                                            

    private void MenuInsertionSortActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        AtivadesativaTela(false);        
        secundaria = new TelaSecundaria(this,infoSis.infoInsertion());
        secundaria.setVisible(true);
    }                                                 

    private void MenuMergeSortActionPerformed(java.awt.event.ActionEvent evt) {                                              
        AtivadesativaTela(false);        
        secundaria = new TelaSecundaria(this,infoSis.infoMerge());
        secundaria.setVisible(true);
    }                                             

    private void MenuQScMedianade3ActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        AtivadesativaTela(false);        
        secundaria = new TelaSecundaria(this,infoSis.infoQuickMedianaDe3());
        secundaria.setVisible(true);
    }                                                 

    private void MenuQuickSortActionPerformed(java.awt.event.ActionEvent evt) {                                              
        AtivadesativaTela(false);        
        secundaria = new TelaSecundaria(this,infoSis.infoQuick());
        secundaria.setVisible(true);
    }                                             

    private void MenuSelectionSortActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        AtivadesativaTela(false);        
        secundaria = new TelaSecundaria(this,infoSis.infoSelection());
        secundaria.setVisible(true);
    }                                                 
    
    private void desativaBotoes(){
        GerarRelatorio.setEnabled(false);
        BotaoIniciar.setEnabled(false);
        MenuGeralProjeto.setEnabled(false);
        Informacoes.setEnabled(false);
        Algoritmos.setEnabled(false);
    }
    
    private void ativaBotoes(){
        GerarRelatorio.setEnabled(true);
        BotaoIniciar.setEnabled(true);
        MenuGeralProjeto.setEnabled(true);
        Informacoes.setEnabled(true);
        Algoritmos.setEnabled(true);
    }
    
    private void AtivadesativaTela(boolean valor){
        setVisible(valor);
    }  
    
}

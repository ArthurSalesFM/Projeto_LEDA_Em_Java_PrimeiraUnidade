package Telas;

import AlgoritmosDeOrdenação.InsertionSort;
import AlgoritmosDeOrdenação.MergeSort;
import AlgoritmosDeOrdenação.SelectionSort;
import CSV.ArquivoCSV;
import Classificações_Transformações.ClassificacaoSenha;
import Classificações_Transformações.Transformacoes;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.text.Document;

/**
 *
 * @author Gasparzinho
 */
public class TelaPrincipal extends javax.swing.JFrame{
    
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
    
    public TelaPrincipal(){
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        GerarRelatorio.setEnabled(false);
        SaidaInformacoes.setEditable(false);
    }
    
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
        setTitle("Arthur FMS - Laboratório de Estrutura de Dados - LEDA");
        setResizable(false);

        PainelPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GerarRelatorio.setText("Gerar Relatório");

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
                .addGap(78, 78, 78)
                .addComponent(BotaoIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(GerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
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
        Algoritmos.add(MenuHeapSort);

        MenuInsertionSort.setText("Insertion Sort");
        Algoritmos.add(MenuInsertionSort);

        MenuMergeSort.setText("Merge Sort");
        Algoritmos.add(MenuMergeSort);

        MenuQScMedianade3.setText("Q.S c/ Mediana de 3");
        Algoritmos.add(MenuQScMedianade3);

        MenuQuickSort.setText("Quick Sort");
        Algoritmos.add(MenuQuickSort);

        MenuSelectionSort.setText("Selection Sort");
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

    private void InfoGeralActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void MenuCountingSortActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void BotaoIniciarActionPerformed(java.awt.event.ActionEvent evt) {
        
        SaidaInformacoes.setText(null);
        
        this.desativaBotoes();
        
        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            
            @Override
            protected Void doInBackground() throws Exception {
                ArquivoCSV ar = new ArquivoCSV();
                ClassificacaoSenha trans = new ClassificacaoSenha();
                Transformacoes transformacoes = new Transformacoes();
                //SelectionSort selection = new SelectionSort();
                //InsertionSort insertion = new InsertionSort();
                MergeSort merge = new MergeSort();
                Document doc = SaidaInformacoes.getDocument();
                
                String nomeDoArquivo = "passwords.csv"; // Nome do arquivo a ser lido
                
                if (new File("src/main/java/ArquivoBaseCSV/" + nomeDoArquivo).exists()) {
                    
                    doc.insertString(doc.getLength(), " =========================INICIANDO O PROCESSO===========================\n\n", null);
                    
                    Thread.sleep(1000);
                    
                    doc.insertString(doc.getLength(), "Lendo o arquivo: " + nomeDoArquivo + ".\n", null);
                    String saidas[] = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    //=================================================================================================================================
                    
                    Thread.sleep(1000);
                    
                    doc.insertString(doc.getLength(), "Criando a Classificação das senhas.\n", null);
                    saidas = trans.calssificaSenha(saidas);            
                    doc.insertString(doc.getLength(), "Classificação das senhas concluida!\n\n", null);
                    
                    //=================================================================================================================================
                    
                    Thread.sleep(1000);
            
                    nomeDoArquivo = "password_classifier.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + ".\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    //=================================================================================================================================
                    
                    Thread.sleep(1000);
                
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para realizar as transfomações das datas.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                
                    //=================================================================================================================================
                    
                    Thread.sleep(1000);
                    
                    doc.insertString(doc.getLength(), "Realizando as transformações das datas do Arquivo: " + nomeDoArquivo + ".\n", null);
                    saidas = transformacoes.transformaData(saidas);
                    doc.insertString(doc.getLength(), "Transformações das datas do Arquivo: " + nomeDoArquivo + " realizada com sucesso!\n\n", null);
                
                    //=================================================================================================================================
                    
                    Thread.sleep(1000);
                    
                    nomeDoArquivo = "passwords_formated_data.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + ".\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    //=================================================================================================================================
                    
                    Thread.sleep(1000);
                    
                    nomeDoArquivo = "password_classifier.csv";
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para selecionar as senhas Boa e Muito Boa.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    //=================================================================================================================================
                    
                    Thread.sleep(1000);
                    
                    doc.insertString(doc.getLength(), "Buscando a senhas Boa e Muito Boa.\n", null);
                    saidas = trans.buscaSenhaBoaEMuitoBoa(saidas);
                    doc.insertString(doc.getLength(), "Busca realizada.\n\n", null);
                    
                    //=================================================================================================================================
                    
                    Thread.sleep(1000);
                    
                    nomeDoArquivo = "passwords_classifier.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + ".\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    //=================================================================================================================================
                    
                    Thread.sleep(1000);
                    
                    doc.insertString(doc.getLength(), "\n========================INICIANDO AS ORDENAÇÕES=========================\n\n", null);
                    
                    doc.insertString(doc.getLength(), "\n===============================MERGE SORT===============================\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    
                    nomeDoArquivo = "passwords_formated_data.csv";                    
                    
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);                    
        
                    doc.insertString(doc.getLength(), "ORDENAÇÂO MÉDIO CASO Campo Length.\n", null);
                    saidas = merge.ordenacaoMedioMelhorCasoCampoLength(saidas, 2);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_length_mergeSort_medioCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    Thread.sleep(2000);                
                    nomeDoArquivo = "passwords_length_mergeSort_medioCaso.csv";                    
                    
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);                    
        
                    doc.insertString(doc.getLength(), "ORDENAÇÂO MELHOR CASO Campo Length.\n", null);
                    saidas = merge.ordenacaoMedioMelhorCasoCampoLength(saidas, 2);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_length_mergeSort_melhorCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    
                    Thread.sleep(2000);
                    nomeDoArquivo = "passwords_length_mergeSort_melhorCaso.csv";                    
                    
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);                    
        
                    doc.insertString(doc.getLength(), "ORDENAÇÂO PIOR CASO Campo Length.\n", null);
                    saidas = merge.ordenacaoPiorCasoCampoLength(saidas, 2);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_length_mergeSort_piorCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    
                    
                    
                    Thread.sleep(2000);
                    doc.insertString(doc.getLength(), "Processo concuído!\n", null);
                    ativaBotoes();
                
                    
                } 
                else {
                    JOptionPane.showMessageDialog(null, "O arquivo " + nomeDoArquivo + " não foi encontrado.\nPor favor insira o arquivo na pasta.\nsrc/main/java/ArquivoBaseCSV/", "Erro", JOptionPane.ERROR_MESSAGE);
                    GerarRelatorio.setEnabled(false);
                }

                return null;
            }
        };
        
        worker.execute();
    }                                            

    private void SobreOAutorActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
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
    
}


/*
                    asdadsads
                    
                    doc.insertString(doc.getLength(), "============================SELECTION SORT==============================\n\n", null);
                                        
                    nomeDoArquivo = "passwords_formated_data.csv";                    
                    
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);                    
        
                    doc.insertString(doc.getLength(), "ORDENAÇÂO MÉDIO CASO Campo Length.\n", null);
                    saidas = selection.ordenacaoMedioMelhorCasoCampoLength(saidas, 2);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_length_selectionSort_medioCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_length_selectionSort_medioCaso.csv";
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    doc.insertString(doc.getLength(), "ORDENAÇÂO MELHOR CASO Campo Length.\n", null);
                    saidas = selection.ordenacaoMedioMelhorCasoCampoLength(saidas, 2);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_length_selectionSort_melhorCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_length_selectionSort_melhorCaso.csv";
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    doc.insertString(doc.getLength(), "ORDENAÇÂO PIOR CASO Campo Length.\n", null);
                    saidas = selection.ordenacaoPiorCasoCampoLength(saidas, 2);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_length_selectionSort_piorCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    //=================================================================================================================================
                    //=================================================================================================================================
                    //=================================================================================================================================
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_formated_data.csv";
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    doc.insertString(doc.getLength(), "ORDENAÇÂO MÉDIO CASO Campo month.\n", null);
                    saidas = selection.ordenacaoMedioMelhorCasoCampoMes(saidas, 3);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_month_selectionSort_medioCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_month_selectionSort_medioCaso.csv";
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    doc.insertString(doc.getLength(), "ORDENAÇÂO MELHOR CASO Campo month.\n", null);
                    saidas = selection.ordenacaoMedioMelhorCasoCampoMes(saidas, 3);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_month_selectionSort_melhorCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_month_selectionSort_melhorCaso.csv";
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    doc.insertString(doc.getLength(), "ORDENAÇÂO PIOR CASO Campo month.\n", null);
                    saidas = selection.ordenacaoPiorCasoCampoMes(saidas, 3);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_month_selectionSort_piorCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);

                    //=================================================================================================================================
                    //=================================================================================================================================
                    //=================================================================================================================================
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_formated_data.csv";
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    doc.insertString(doc.getLength(), "ORDENAÇÂO MÉDIO CASO Campo Data.\n", null);
                    saidas = selection.ordenacaoMedioMelhorCasoCampoData(saidas, 3);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_selectionSort_medioCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_selectionSort_medioCaso.csv";
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    doc.insertString(doc.getLength(), "ORDENAÇÂO MELHOR CASO Campo Data.\n", null);
                    saidas = selection.ordenacaoMedioMelhorCasoCampoData(saidas, 3);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_selectionSort_melhorCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_selectionSort_melhorCaso.csv";
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    doc.insertString(doc.getLength(), "ORDENAÇÂO PIOR CASO Campo Data.\n", null);
                    saidas = selection.ordenacaoPiorCasoCampoData(saidas, 3);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_selectionSort_piorCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    
                    //=================================================================================================================================
                    //=================================================================================================================================
                    //=================================================================================================================================
                                        
                    doc.insertString(doc.getLength(), "===========================INSERTION SORT==============================\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_formated_data.csv";                    
                    
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);                    
        
                    doc.insertString(doc.getLength(), "ORDENAÇÂO MÉDIO CASO Campo Length.\n", null);
                    saidas = insertion.ordenacaoMedioMelhorCasoCampoLength(saidas, 2);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_length_insertionSort_medioCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                                        
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_length_insertionSort_medioCaso.csv";                    
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);                    
        
                    doc.insertString(doc.getLength(), "ORDENAÇÂO MELHOR CASO Campo Length.\n", null);
                    saidas = insertion.ordenacaoMedioMelhorCasoCampoLength(saidas, 2);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_length_insertionSort_melhorCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_length_insertionSort_melhorCaso.csv";                    
                    
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);                    
        
                    doc.insertString(doc.getLength(), "ORDENAÇÂO PIOR CASO Campo Length.\n", null);
                    saidas = insertion.ordenacaoPiorCasoCampoLength(saidas, 2);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_length_insertionSort_piorCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                            
                    //=================================================================================================================================
                    //=================================================================================================================================
                    //=================================================================================================================================
                    
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_formated_data.csv";                    
                    
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);                    
        
                    doc.insertString(doc.getLength(), "ORDENAÇÂO MÉDIO CASO Campo MONTH.\n", null);
                    saidas = insertion.ordenacaoMedioMelhorCasoCampoMes(saidas, 3);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_month_insertionSort_medioCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                                        
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_month_insertionSort_medioCaso.csv";                    
                    
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);                    
        
                    doc.insertString(doc.getLength(), "ORDENAÇÂO MElHOR CASO Campo MONTH.\n", null);
                    saidas = insertion.ordenacaoMedioMelhorCasoCampoMes(saidas, 3);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_month_insertionSort_melhorCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    
                    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                                        
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_month_insertionSort_melhorCaso.csv";                    
                    
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);                    
        
                    doc.insertString(doc.getLength(), "ORDENAÇÂO PIOR CASO Campo MONTH.\n", null);
                    saidas = insertion.ordenacaoPiorCasoCampoMes(saidas, 3);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_month_insertionSort_piorCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    //=================================================================================================================================
                    //=================================================================================================================================
                    //=================================================================================================================================
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_formated_data.csv";                    
                    
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);                    
        
                    doc.insertString(doc.getLength(), "ORDENAÇÂO MÉDIO CASO Campo DATA .\n", null);
                    saidas = insertion.ordenacaoMedioMelhorCasoCampoData(saidas, 3);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_insertionSort_medioCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_insertionSort_medioCaso.csv";                   
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);                    
        
                    doc.insertString(doc.getLength(), "ORDENAÇÂO MELHOR CASO Campo DATA .\n", null);
                    saidas = insertion.ordenacaoMedioMelhorCasoCampoData(saidas, 3);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_insertionSort_melhorCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    
                     //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_insertionSort_melhorCaso.csv";                   
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);                    
        
                    doc.insertString(doc.getLength(), "ORDENAÇÂO PIOR CASO Campo DATA .\n", null);
                    saidas = insertion.ordenacaoPiorCasoCampoData(saidas, 3);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_insertionSort_piorCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);

                    //=================================================================================================================================
                    //=================================================================================================================================
                    //=================================================================================================================================

                    
                    Thread.sleep(2000);

                    doc.insertString(doc.getLength(), "\n===============================MERGE SORT===============================\n\n", null);
                    
                    nomeDoArquivo = "passwords_formated_data.csv";                    
                    
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);                    
        
                    doc.insertString(doc.getLength(), "ORDENAÇÂO MÉDIO CASO Campo Mes.\n", null);
                    saidas = merge.ordenacaoMedioMelhorCasoCampoMes(saidas, 3);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_month_mergeSort_medioCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    Thread.sleep(2000);                
                    nomeDoArquivo = "passwords_data_month_mergeSort_medioCaso.csv";                    
                    
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);                    
        
                    doc.insertString(doc.getLength(), "ORDENAÇÂO MELHOR CASO Campo Mes.\n", null);
                    saidas = merge.ordenacaoMedioMelhorCasoCampoMes(saidas, 3);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_month_mergeSort_melhorCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    
                    Thread.sleep(2000);
                    nomeDoArquivo = "passwords_data_month_insertionSort_melhorCaso.csv";                    
                    
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);                    
        
                    doc.insertString(doc.getLength(), "ORDENAÇÂO PIOR CASO Campo Mes.\n", null);
                    saidas = merge.ordenacaoPiorCasoCampoMes(saidas, 3);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_month_mergenSort_piorCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);

                    Thread.sleep(2000);
                    //=================================================================================================================================
                    //=================================================================================================================================
                    //=================================================================================================================================
                    






                    Thread.sleep(2000);
                    //=================================================================================================================================
                    //=================================================================================================================================
                    //=================================================================================================================================
                    
                    Thread.sleep(2000);
                    nomeDoArquivo = "passwords_formated_data.csv";                    
                    
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);                    
        
                    doc.insertString(doc.getLength(), "ORDENAÇÂO MÉDIO CASO Campo Data.\n", null);
                    saidas = merge.ordenacaoMedioMelhorCasoCampoData(saidas, 3);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_mergeSort_medioCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                                        
                    nomeDoArquivo = "passwords_data_mergeSort_medioCaso.csv";                    
                    
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);                    
        
                    doc.insertString(doc.getLength(), "ORDENAÇÂO MELHOR CASO Campo Data.\n", null);
                    saidas = merge.ordenacaoMedioMelhorCasoCampoData(saidas, 3);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_mergeSort_melhorCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                                        
                    nomeDoArquivo = "passwords_data_mergeSort_melhorCaso.csv";                    
                    
                    doc.insertString(doc.getLength(), "Lendo o Arquivo: " + nomeDoArquivo + ", para Inciar a ordenção.\n", null);
                    saidas = ar.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "Leitura do arquivo: " + nomeDoArquivo + " realizado com sucesso!\n\n", null);
                    
                    Thread.sleep(2000);                    
        
                    doc.insertString(doc.getLength(), "ORDENAÇÂO PIOR CASO Campo Data.\n", null);
                    saidas = merge.ordenacaoPiorCasoCampoData(saidas, 3);
                    doc.insertString(doc.getLength(), "Ordenação Conluida com sucesso\n\n", null);
                    
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_data_mergeSort_piorCaso.csv";
                    doc.insertString(doc.getLength(), "Criando o Arquivo: " + nomeDoArquivo + " após a ordenação.\n", null);
                    ar.criarArquivoCSV(nomeDoArquivo, saidas);
                    doc.insertString(doc.getLength(), "Arquivo " + nomeDoArquivo + " criado com sucesso!\n\n", null);
                    
                    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    
                    
                    //=================================================================================================================================
                    //=================================================================================================================================
                    //=================================================================================================================================
                    
                    
                    asdadsads
                            */
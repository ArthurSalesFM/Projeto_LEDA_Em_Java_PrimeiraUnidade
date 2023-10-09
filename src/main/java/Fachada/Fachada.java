package Fachada;

import AlgoritmosDeOrdenação.CountingSort;
import AlgoritmosDeOrdenação.HeapSort;
import AlgoritmosDeOrdenação.InsertionSort;
import AlgoritmosDeOrdenação.MergeSort;
import AlgoritmosDeOrdenação.QuickSort;
import AlgoritmosDeOrdenação.QuickSort_Com_MedianaDe3;
import AlgoritmosDeOrdenação.SelectionSort;
import CSV.ArquivoCSV;
import Classificações_Transformações.ClassificacaoSenha;
import Classificações_Transformações.Transformacoes;
import DadosDasOrdenacoes.MatrizDosDados;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.SwingWorker;
import javax.swing.text.Document;

/**
 *
 * @author Gasparzinho
 */
public class Fachada {
    
    private ArquivoCSV arquivoCSV;
    private ClassificacaoSenha classificacaoSenhas;
    private Transformacoes transformacoes;
    private String dados[];
    private SelectionSort selection;
    private InsertionSort insertion;
    private MergeSort merge;
    private QuickSort quick;
    private QuickSort_Com_MedianaDe3 quickCM3;
    private CountingSort counting;
    private HeapSort heap;
    private MatrizDosDados matriz;
    
    public Fachada(){
        this.arquivoCSV = new ArquivoCSV();
        this.classificacaoSenhas = new ClassificacaoSenha();
        this.transformacoes = new Transformacoes();
        this.selection = new SelectionSort();
        this.insertion = new InsertionSort();
        this.merge =  new MergeSort();
        this.quick = new QuickSort();
        this.quickCM3 = new QuickSort_Com_MedianaDe3();
        this.counting = new CountingSort();
        this.heap = new HeapSort();
        this.matriz = new MatrizDosDados();
    }
    
    
    public void iniciarProcesso( JTextPane SaidaInformacoes, JButton BotaoIniciar, JButton GerarRelatorio, JMenu MenuGeralProjeto){
                        
        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            
            @Override
            protected Void doInBackground() throws Exception {
                
                BotaoIniciar.setEnabled(false);
                GerarRelatorio.setEnabled(false);
                MenuGeralProjeto.setEnabled(false);
                
                Document doc = SaidaInformacoes.getDocument();                
                String nomeDoArquivo = "passwords.csv";
                
                if (new File("src/main/java/ArquivoBaseCSV/" + nomeDoArquivo).exists()) {
                    
                    long tempoInicial = 0;
                    long tempoFinal = 0;
                    double tempoTotal = 0;
                    
                    doc.insertString(doc.getLength(), " ========================================INICIANDO O PROCESSO======================================== \n\n\n", null);                   
                    Thread.sleep(3000);         
                    
                    
                    doc.insertString(doc.getLength(), " =========================================Classificação das Senha======================================== \n\n", null);
                    Thread.sleep(1000);
                    
                    doc.insertString(doc.getLength(), "Lendo arquivo : " + nomeDoArquivo, null); 
                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                    Thread.sleep(1000);                                        
                                       
                    doc.insertString(doc.getLength(), "\n\nClassificando as Senhas.", null); 
                    dados = classificacaoSenhas.calssificaSenha(dados);
                    doc.insertString(doc.getLength(), "\nCassificação das senhas realizada.", null);
                    Thread.sleep(1000);                    
                    
                    nomeDoArquivo = "password_classifier.csv";
                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!" + nomeDoArquivo, null);
                    Thread.sleep(3000);
                    
                    
                    
                    doc.insertString(doc.getLength(), "\n\n\n ======================================Transformações do Campo DATA===================================== \n\n", null);
                    Thread.sleep(1000);
                    
                    doc.insertString(doc.getLength(), "Lendo arquivo : " + nomeDoArquivo, null); 
                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                    Thread.sleep(2000);
                    
                    
                    doc.insertString(doc.getLength(), "\n\nRealizando as transformações.", null); 
                    dados = transformacoes.transformaData(dados);
                    doc.insertString(doc.getLength(), "\nTransformações Realizada com Sucesso!", null);
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_formated_data.csv";
                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                    Thread.sleep(3000);
                    
                    
                    
                    doc.insertString(doc.getLength(), "\n\n\n =====================================Filtrando Senhas Boa e Muito Boa==================================== \n\n", null);
                    Thread.sleep(1000);
                    
                    doc.insertString(doc.getLength(), "Lendo arquivo : " + nomeDoArquivo, null); 
                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                    Thread.sleep(2000);
                    
                    
                    doc.insertString(doc.getLength(), "\n\nRealizando a filtragem das Senhas.", null); 
                    dados = classificacaoSenhas.buscaSenhaBoaEMuitoBoa(dados);
                    doc.insertString(doc.getLength(), "\nFiltragem Realizada com Sucesso!", null);
                    Thread.sleep(2000);
                    
                    nomeDoArquivo = "passwords_classifier.csv";
                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                    Thread.sleep(3000);
                    
                    
                    doc.insertString(doc.getLength(), "\n\n\n =========================================Iniciando as Ordenações========================================", null);
  
                    for(int linha = 0; linha < 7; linha++){
                        
                        if(linha == 0){                            
                            doc.insertString(doc.getLength(), "\n\n\n ============================================SELECTION SORT==========================================\n", null);                                
                        }
                        else if(linha == 1){                            
                            doc.insertString(doc.getLength(), "\n\n\n ===========================================INSERTION SORT===========================================\n", null);
                        }
                        else if(linha == 2){                            
                            doc.insertString(doc.getLength(), "\n\n\n =============================================MERGE SORT=============================================\n", null);                                
                        }
                        else if(linha == 3){
                            doc.insertString(doc.getLength(), "\n\n\n =============================================QUICK SORT=============================================\n", null);                                
                        }
                        else if(linha == 4){
                            doc.insertString(doc.getLength(), "\n\n\n ========================================QUICK SORT Com Mediana======================================\n", null);   
                        }
                        else if(linha == 5){                            
                            doc.insertString(doc.getLength(), "\n\n\n ============================================COUNTING SORT===========================================\n", null);
                        }
                        else {                           
                            doc.insertString(doc.getLength(), "\n\n\n ==============================================HEAP SORT=============================================\n", null);    
                        } 
                        
                        for(int coluna = 0; coluna < 9; coluna++){
                            
                            //SELCTION
                            if(linha == 0){
                                
                                if(coluna == 0){
                                    
                                    nomeDoArquivo = "passwords_formated_data.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MÉDIO CASO, campo LENGTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = selection.ordenacaoMedioMelhorCasoCampoLength(dados, 2);
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_length_selectionSort_medioCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================
                                }
                                else if(coluna == 1){
                                    
                                    nomeDoArquivo = "passwords_length_selectionSort_medioCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MELHOR CASO, campo LENGTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = selection.ordenacaoMedioMelhorCasoCampoLength(dados, 2);
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_length_selectionSort_melhorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================                                    
                                }
                                else if(coluna == 2){
                                    
                                    nomeDoArquivo = "passwords_length_selectionSort_melhorCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação PIOR CASO, campo LENGTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = selection.ordenacaoPiorCasoCampoLength(dados, 2);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_length_selectionSort_piorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);                                 
                                }                                                             
                                else if(coluna == 3){
                                    
                                    nomeDoArquivo = "passwords_formated_data.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MÉDIO CASO, campo MONTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = selection.ordenacaoMedioMelhorCasoCampoMes(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_month_selectionSort_medioCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================
                                }
                                else if(coluna == 4){
                                    
                                    nomeDoArquivo = "passwords_data_month_selectionSort_medioCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MELHOR CASO, campo MONTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = selection.ordenacaoMedioMelhorCasoCampoMes(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_month_selectionSort_melhorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================                                    
                                }
                                else if(coluna == 5){
                                    
                                    nomeDoArquivo = "passwords_data_month_selectionSort_melhorCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação PIOR CASO, campo MONTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = selection.ordenacaoPiorCasoCampoMes(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_month_selectionSort_piorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);                                 
                                }
                                else if(coluna == 6){
                                    
                                    nomeDoArquivo = "passwords_formated_data.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MÉDIO CASO, campo DATA.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = selection.ordenacaoMedioMelhorCasoCampoData(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_selectionSort_medioCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================
                                }
                                else if(coluna == 7){
                                    
                                    nomeDoArquivo = "passwords_data_selectionSort_medioCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MELHOR CASO, campo DATA.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = selection.ordenacaoMedioMelhorCasoCampoData(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_selectionSort_melhorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================                                    
                                }
                                else{
                                    
                                    nomeDoArquivo = "passwords_data_selectionSort_melhorCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação PIOR CASO, campo DATA.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = selection.ordenacaoPiorCasoCampoData(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_selectionSort_piorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);                                 
                                }
                            }                            
                            
                            //INSERTION
                            else if(linha == 1){
                                
                                if(coluna == 0){
                                    
                                    nomeDoArquivo = "passwords_formated_data.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MÉDIO CASO, campo LENGTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = insertion.ordenacaoMedioMelhorCasoCampoLength(dados, 2);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_length_insertionSort_medioCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================
                                }
                                else if(coluna == 1){
                                    
                                    nomeDoArquivo = "passwords_length_insertionSort_medioCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MELHOR CASO, campo LENGTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = insertion.ordenacaoMedioMelhorCasoCampoLength(dados, 2);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_length_insertionSort_melhorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================                                    
                                }
                                else if(coluna == 2){
                                    
                                    nomeDoArquivo = "passwords_length_insertionSort_melhorCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação PIOR CASO, campo LENGTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = insertion.ordenacaoPiorCasoCampoLength(dados, 2);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_length_insertionSort_piorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);                                 
                                }                                                             
                                else if(coluna == 3){
                                    
                                    nomeDoArquivo = "passwords_formated_data.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MÉDIO CASO, campo MONTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = insertion.ordenacaoMedioMelhorCasoCampoMes(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_month_insertionSort_medioCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================
                                }
                                else if(coluna == 4){
                                    
                                    nomeDoArquivo = "passwords_data_month_insertionSort_medioCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MELHOR CASO, campo MONTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = insertion.ordenacaoMedioMelhorCasoCampoMes(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_month_insertionSort_melhorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================                                    
                                }
                                else if(coluna == 5){
                                    
                                    nomeDoArquivo = "passwords_data_month_insertionSort_melhorCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação PIOR CASO, campo MONTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = insertion.ordenacaoPiorCasoCampoMes(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_month_insertionSort_piorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);                                 
                                }
                                else if(coluna == 6){
                                    
                                    nomeDoArquivo = "passwords_formated_data.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MÉDIO CASO, campo DATA.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = insertion.ordenacaoMedioMelhorCasoCampoData(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_insertionSort_medioCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================
                                }
                                else if(coluna == 7){
                                    
                                    nomeDoArquivo = "passwords_data_insertionSort_medioCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MELHOR CASO, campo DATA.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = insertion.ordenacaoMedioMelhorCasoCampoData(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_insertionSort_melhorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================                                    
                                }
                                else{
                                    
                                    nomeDoArquivo = "passwords_data_insertionSort_melhorCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação PIOR CASO, campo DATA.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = insertion.ordenacaoPiorCasoCampoData(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_insertionSort_piorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);                                 
                                }
                            }
                                                        
                            //MERGE
                            else if(linha == 2){
                                
                                if(coluna == 0){
                                    
                                    nomeDoArquivo = "passwords_formated_data.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MÉDIO CASO, campo LENGTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = merge.ordenacaoMedioMelhorCasoCampoLength(dados, 2);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_length_mergeSort_medioCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================
                                }
                                else if(coluna == 1){
                                    
                                    nomeDoArquivo = "passwords_length_mergeSort_medioCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MELHOR CASO, campo LENGTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = merge.ordenacaoMedioMelhorCasoCampoLength(dados, 2);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_length_mergeSort_melhorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================                                    
                                }
                                else if(coluna == 2){
                                    
                                    nomeDoArquivo = "passwords_length_mergeSort_melhorCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação PIOR CASO, campo LENGTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = merge.ordenacaoPiorCasoCampoLength(dados, 2);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_length_mergeSort_piorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);                                 
                                }                                                             
                                else if(coluna == 3){
                                    
                                    nomeDoArquivo = "passwords_formated_data.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MÉDIO CASO, campo MONTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = merge.ordenacaoMedioMelhorCasoCampoMes(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_month_mergeSort_medioCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================
                                }
                                else if(coluna == 4){
                                    
                                    nomeDoArquivo = "passwords_data_month_mergeSort_medioCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MELHOR CASO, campo MONTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = merge.ordenacaoMedioMelhorCasoCampoMes(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_month_mergeSort_melhorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================                                    
                                }
                                else if(coluna == 5){
                                    
                                    nomeDoArquivo = "passwords_data_month_mergeSort_melhorCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação PIOR CASO, campo MONTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = merge.ordenacaoPiorCasoCampoMes(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_month_mergeSort_piorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);                                 
                                }
                                else if(coluna == 6){
                                    
                                    nomeDoArquivo = "passwords_formated_data.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MÉDIO CASO, campo DATA.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = merge.ordenacaoMedioMelhorCasoCampoData(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_mergeSort_medioCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================
                                }
                                else if(coluna == 7){
                                    
                                    nomeDoArquivo = "passwords_data_mergeSort_medioCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MELHOR CASO, campo DATA.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = merge.ordenacaoMedioMelhorCasoCampoData(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_mergeSort_melhorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================                                    
                                }
                                else{
                                    
                                    nomeDoArquivo = "passwords_data_mergeSort_melhorCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação PIOR CASO, campo DATA.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = merge.ordenacaoPiorCasoCampoData(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_mergeSort_piorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);                                 
                                }
                            }
                            
                            //QUICK
                            else if(linha == 3){
                                
                                if(coluna == 0){
                                    
                                    nomeDoArquivo = "passwords_formated_data.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MÉDIO CASO, campo LENGTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = quick.ordenacaoMedioMelhorCasoCampoLength(dados, 2);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_length_quickSort_medioCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================
                                }
                                else if(coluna == 1){
                                    
                                    nomeDoArquivo = "passwords_length_quickSort_medioCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MELHOR CASO, campo LENGTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = quick.ordenacaoMedioMelhorCasoCampoLength(dados, 2);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_length_quickSort_melhorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================                                    
                                }
                                else if(coluna == 2){
                                    
                                    nomeDoArquivo = "passwords_length_quickSort_melhorCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação PIOR CASO, campo LENGTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = quick.ordenacaoPiorCasoCampoLength(dados, 2);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_length_quickSort_piorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);                                 
                                }                                                             
                                else if(coluna == 3){
                                    
                                    nomeDoArquivo = "passwords_formated_data.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MÉDIO CASO, campo MONTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = quick.ordenacaoMedioMelhorCasoCampoMes(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_month_quickSort_medioCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================
                                }
                                else if(coluna == 4){
                                    
                                    nomeDoArquivo = "passwords_data_month_quickSort_medioCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MELHOR CASO, campo MONTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = quick.ordenacaoMedioMelhorCasoCampoMes(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_month_quickSort_melhorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================                                    
                                }
                                else if(coluna == 5){
                                    
                                    nomeDoArquivo = "passwords_data_month_quickSort_melhorCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação PIOR CASO, campo MONTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = quick.ordenacaoPiorCasoCampoMes(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_month_quickSort_piorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);                                 
                                }
                                else if(coluna == 6){
                                    
                                    nomeDoArquivo = "passwords_formated_data.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MÉDIO CASO, campo DATA.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = quick.ordenacaoMedioMelhorCasoCampoData(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_quickSort_medioCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================
                                }
                                else if(coluna == 7){
                                    
                                    nomeDoArquivo = "passwords_data_quickSort_medioCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MELHOR CASO, campo DATA.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = quick.ordenacaoMedioMelhorCasoCampoData(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_quickSort_melhorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================                                    
                                }
                                else{
                                    
                                    nomeDoArquivo = "passwords_data_quickSort_melhorCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação PIOR CASO, campo DATA.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = quick.ordenacaoPiorCasoCampoData(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_quickSort_piorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);                                 
                                }
                            }
                        
                            //QUICK COM MEDIANA
                            else if(linha == 4){
                                
                                if(coluna == 0){
                                    
                                    nomeDoArquivo = "passwords_formated_data.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MÉDIO CASO, campo LENGTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = quickCM3.ordenacaoMedioMelhorCasoCampoLength(dados, 2);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_length_quickCM3Sort_medioCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================
                                }
                                else if(coluna == 1){
                                    
                                    nomeDoArquivo = "passwords_length_quickCM3Sort_medioCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MELHOR CASO, campo LENGTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = quickCM3.ordenacaoMedioMelhorCasoCampoLength(dados, 2);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_length_quickCM3Sort_melhorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================                                    
                                }
                                else if(coluna == 2){
                                    
                                    nomeDoArquivo = "passwords_length_quickCM3Sort_melhorCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação PIOR CASO, campo LENGTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = quickCM3.ordenacaoPiorCasoCampoLength(dados, 2);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_length_quickCM3Sort_piorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);                                 
                                }                                                             
                                else if(coluna == 3){
                                    
                                    nomeDoArquivo = "passwords_formated_data.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MÉDIO CASO, campo MONTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = quickCM3.ordenacaoMedioMelhorCasoCampoMes(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_month_quickCM3Sort_medioCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================
                                }
                                else if(coluna == 4){
                                    
                                    nomeDoArquivo = "passwords_data_month_quickCM3Sort_medioCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MELHOR CASO, campo MONTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = quickCM3.ordenacaoMedioMelhorCasoCampoMes(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_month_quickCM3Sort_melhorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================                                    
                                }
                                else if(coluna == 5){
                                    
                                    nomeDoArquivo = "passwords_data_month_quickCM3Sort_melhorCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação PIOR CASO, campo MONTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = quickCM3.ordenacaoPiorCasoCampoMes(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_month_quickCM3Sort_piorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);                                 
                                }
                                else if(coluna == 6){
                                    
                                    nomeDoArquivo = "passwords_formated_data.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MÉDIO CASO, campo DATA.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = quickCM3.ordenacaoMedioMelhorCasoCampoData(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_quickCM3Sort_medioCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================
                                }
                                else if(coluna == 7){
                                    
                                    nomeDoArquivo = "passwords_data_quickCM3Sort_medioCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MELHOR CASO, campo DATA.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = quickCM3.ordenacaoMedioMelhorCasoCampoData(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_quickCM3Sort_melhorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================                                    
                                }
                                else{
                                    
                                    nomeDoArquivo = "passwords_data_quickCM3Sort_melhorCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação PIOR CASO, campo DATA.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = quickCM3.ordenacaoPiorCasoCampoData(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_quickCM3Sort_piorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);                                 
                                }
                            }
                            
                            //COUNTING
                            else if(linha == 5){
                                
                                if(coluna == 0){
                                    
                                    nomeDoArquivo = "passwords_formated_data.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MÉDIO CASO, campo LENGTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = counting.ordenacaoMedioMelhorCasoCampoLength(dados, 2);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_length_countingSort_medioCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================
                                }
                                else if(coluna == 1){
                                    
                                    nomeDoArquivo = "passwords_length_countingSort_medioCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MELHOR CASO, campo LENGTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = counting.ordenacaoMedioMelhorCasoCampoLength(dados, 2);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_length_countingSort_melhorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================                                    
                                }
                                else if(coluna == 2){
                                    
                                    nomeDoArquivo = "passwords_length_quickCM3Sort_melhorCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação PIOR CASO, campo LENGTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = counting.ordenacaoPiorCasoCampoLength(dados, 2);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_length_countingSort_piorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);                                 
                                }                                                             
                                else if(coluna == 3){
                                    
                                    nomeDoArquivo = "passwords_formated_data.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MÉDIO CASO, campo MONTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = counting.ordenacaoMedioMelhorCasoCampoMes(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_month_countingSort_medioCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================
                                }
                                else if(coluna == 4){
                                    
                                    nomeDoArquivo = "passwords_data_month_countingSort_medioCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MELHOR CASO, campo MONTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = counting.ordenacaoMedioMelhorCasoCampoMes(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_month_countingSort_melhorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================                                    
                                }
                                else if(coluna == 5){
                                    
                                    nomeDoArquivo = "passwords_data_month_countingSort_melhorCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação PIOR CASO, campo MONTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = counting.ordenacaoPiorCasoCampoMes(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_month_countingSort_piorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);                                 
                                }
                                else if(coluna == 6){
                                    
                                    nomeDoArquivo = "passwords_formated_data.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MÉDIO CASO, campo DATA.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = counting.ordenacaoMedioMelhorCasoCampoData(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_countingSort_medioCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================
                                }
                                else if(coluna == 7){
                                    
                                    nomeDoArquivo = "passwords_data_countingSort_medioCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MELHOR CASO, campo DATA.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = counting.ordenacaoMedioMelhorCasoCampoData(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_countingSort_melhorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================                                    
                                }
                                else{
                                    
                                    nomeDoArquivo = "passwords_data_countingSort_melhorCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação PIOR CASO, campo DATA.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = counting.ordenacaoPiorCasoCampoData(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_countingSort_piorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);                                 
                                }
                            }
                            
                            //HEAP
                            else{
                                if(coluna == 0){
                                    
                                    nomeDoArquivo = "passwords_formated_data.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MÉDIO CASO, campo LENGTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = heap.ordenacaoMedioMelhorCasoCampoLength(dados, 2);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_length_heapSort_medioCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================
                                }
                                else if(coluna == 1){
                                    
                                    nomeDoArquivo = "passwords_length_heapSort_medioCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MELHOR CASO, campo LENGTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = heap.ordenacaoMedioMelhorCasoCampoLength(dados, 2);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_length_heapSort_melhorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================                                    
                                }
                                else if(coluna == 2){
                                    
                                    nomeDoArquivo = "passwords_length_heapSort_melhorCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação PIOR CASO, campo LENGTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = heap.ordenacaoPiorCasoCampoLength(dados, 2);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_length_heapSort_piorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);                                 
                                }                                                             
                                else if(coluna == 3){
                                    
                                    nomeDoArquivo = "passwords_formated_data.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MÉDIO CASO, campo MONTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = heap.ordenacaoMedioMelhorCasoCampoMes(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_month_heapSort_medioCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================
                                }
                                else if(coluna == 4){
                                    
                                    nomeDoArquivo = "passwords_data_month_heapSort_medioCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MELHOR CASO, campo MONTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = heap.ordenacaoMedioMelhorCasoCampoMes(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_month_heapSort_melhorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================                                    
                                }
                                else if(coluna == 5){
                                    
                                    nomeDoArquivo = "passwords_data_month_heapSort_melhorCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação PIOR CASO, campo MONTH.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = heap.ordenacaoPiorCasoCampoMes(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_month_heapSort_piorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);                                 
                                }
                                else if(coluna == 6){
                                    
                                    nomeDoArquivo = "passwords_formated_data.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MÉDIO CASO, campo DATA.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = heap.ordenacaoMedioMelhorCasoCampoData(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_heapSort_medioCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================
                                }
                                else if(coluna == 7){
                                    
                                    nomeDoArquivo = "passwords_data_heapSort_medioCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação MELHOR CASO, campo DATA.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = heap.ordenacaoMedioMelhorCasoCampoData(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_heapSort_melhorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);
                                    //=================================================================================================================                                    
                                }
                                else{
                                    
                                    nomeDoArquivo = "passwords_data_heapSort_melhorCaso.csv";
                                    
                                    doc.insertString(doc.getLength(), "\n\nLendo arquivo : " + nomeDoArquivo, null); 
                                    dados = arquivoCSV.lerArquivoCSV(nomeDoArquivo);
                                    doc.insertString(doc.getLength(), "\nLeitura Realizada com Sucesso!", null);
                                    Thread.sleep(1000);                                        
                                       
                                    doc.insertString(doc.getLength(), "\n\nOrdenação PIOR CASO, campo DATA.", null); 
                                    tempoInicial =  System.nanoTime();
                                    dados = heap.ordenacaoPiorCasoCampoData(dados, 3);                                    
                                    tempoFinal = System.nanoTime();
                                    tempoTotal = (tempoFinal - tempoInicial) / 1e9;
                                    matriz.inserirValoresNaMatriz(tempoTotal, linha, coluna);
                                    doc.insertString(doc.getLength(), "\nOrdenação realizada!", null);
                                    Thread.sleep(1000);                    
                    
                                    nomeDoArquivo = "passwords_data_heapSort_piorCaso.csv";
                                    doc.insertString(doc.getLength(), "\n\nCriando o Arquivo : " + nomeDoArquivo, null); 
                                    arquivoCSV.criarArquivoCSV(nomeDoArquivo, dados);
                                    doc.insertString(doc.getLength(), "\nArquivo criado com Sucesso!", null);
                                    Thread.sleep(2000);                                 
                                }
                            }
                        }                   
                    }
                    
                    doc.insertString(doc.getLength(), "\n\n\n =========================================PROCESSO CONCLUÍDO=========================================\n\n\n", null);
                    Thread.sleep(1000);
                    
                    BotaoIniciar.setEnabled(true);
                    GerarRelatorio.setEnabled(true);
                    MenuGeralProjeto.setEnabled(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "O arquivo " + nomeDoArquivo + " não foi encontrado.\nPor favor insira o arquivo na pasta.\nsrc/main/java/ArquivoBaseCSV/", "Erro", JOptionPane.ERROR_MESSAGE);
                }                
                return null;
            }
        };
                
        worker.execute();        
    }  
    
}

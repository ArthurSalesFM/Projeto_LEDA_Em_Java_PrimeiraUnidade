package Interfaces;

/**
 * Interface para operações de ordenação em vetores de strings.
 * 
 * @author Arthur Felipe MS
 */
public interface I_Ordenacao {
    
    String[] ordenacaoTamanho(String[] vetor, int colunaOrdenacao);

    String[] ordenacaoMes(String[] vetor, int colunaOrdenacao);
    
    String[] ordenacaoData(String[] vetor, int colunaOrdenacao);
}
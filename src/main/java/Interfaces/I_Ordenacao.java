package Interfaces;

/**
 * Interface para operações de ordenação em vetores de strings.
 * 
 * @author Arthur Felipe MS
 */
public interface I_Ordenacao {
    
    String[] ordenacaoMedioMelhorCasoCampoLength(String[] vetor, int colunaOrdenacao);
    String[] ordenacaoPiorCasoCampoLength(String[] vetor, int colunaOrdenacao);

    String[] ordenacaoMedioMelhorCasoCampoMes(String[] vetor, int colunaOrdenacao);
    String[] ordenacaoPiorCasoCampoMes(String[] vetor, int colunaOrdenacao);
    
    String[] ordenacaoMedioMelhorCasoCampoData(String[] vetor, int colunaOrdenacao);
    String[] ordenacaoPiorCasoCampoData(String[] vetor, int colunaOrdenacao);
}
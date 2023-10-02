package AlgoritmosDeOrdenação;

import Interfaces.I_Ordenacao;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Arthur Felipe MS
 */
public class MergeSort implements I_Ordenacao{

    @Override
    public String[] ordenacaoMedioMelhorCasoCampoLength(String[] vetor, int colunaOrdenacao) {
        mergeSortLength(vetor, colunaOrdenacao, 1, vetor.length - 1, 2);
        return vetor;
    }

    @Override
    public String[] ordenacaoPiorCasoCampoLength(String[] vetor, int colunaOrdenacao) {
        mergeSortLength(vetor, colunaOrdenacao, 1, vetor.length - 1, 1);
        return vetor;
    }

    @Override
    public String[] ordenacaoMedioMelhorCasoCampoMes(String[] vetor, int colunaOrdenacao) {
        mergeSortMes(vetor, colunaOrdenacao,2);
        return vetor;
    }

    @Override
    public String[] ordenacaoPiorCasoCampoMes(String[] vetor, int colunaOrdenacao) {
        mergeSortMes(vetor, colunaOrdenacao, 1);
        return vetor;
    }

    @Override
    public String[] ordenacaoMedioMelhorCasoCampoData(String[] vetor, int colunaOrdenacao) {
        mergeSortData(vetor, colunaOrdenacao, 2);
        return vetor;    
    }

    @Override
    public String[] ordenacaoPiorCasoCampoData(String[] vetor, int colunaOrdenacao) {
        mergeSortData(vetor, colunaOrdenacao, 1);
        return vetor;
    }
      
    private void mergeSortLength(String[] vetor, int colunaOrdenacao, int inicio, int fim, int tipo) {
        if (inicio < fim) {
            int meio = inicio + (fim - inicio) / 2;

            mergeSortLength(vetor, colunaOrdenacao, inicio, meio, tipo);
            mergeSortLength(vetor, colunaOrdenacao, meio + 1, fim, tipo);

            mergeLength(vetor, colunaOrdenacao, inicio, meio, fim, tipo);
        }
    }
    
    private void mergeLength(String[] vetor, int colunaOrdenacao, int inicio, int meio, int fim, int tipo) {
        String[] temp = new String[fim - inicio + 1];
        int i = inicio, j = meio + 1, k = 0;

        while (i <= meio && j <= fim) {
            if (compararLinhasLength(vetor[i], vetor[j], colunaOrdenacao, tipo) <= 0) {
                temp[k++] = vetor[i++];
            } 
            else {
                temp[k++] = vetor[j++];
            }
        }

        while (i <= meio) {
            temp[k++] = vetor[i++];
        }

        while (j <= fim) {
            temp[k++] = vetor[j++];
        }

        for (i = 0; i < temp.length; i++) {
            vetor[inicio + i] = temp[i];
        }
    }
    
    private int compararLinhasLength(String linhaA, String linhaB, int colunaOrdenacao, int tipo) {
        String[] partesA = linhaA.split(",");
        String[] partesB = linhaB.split(",");

        if (partesA.length <= colunaOrdenacao || partesB.length <= colunaOrdenacao) {
            return 0;
        }

        try {
            double valorA, valorB;

            if (partesA.length > 4 || partesB.length > 4) {
                int colunaCorretaA = partesA.length - 3;
                int colunaCorretaB = partesB.length - 3;

                valorA = converterParaDouble(partesA[colunaCorretaA]);
                valorB = converterParaDouble(partesB[colunaCorretaB]);
            } 
            else {
                valorA = converterParaDouble(partesA[colunaOrdenacao]);
                valorB = converterParaDouble(partesB[colunaOrdenacao]);
            }
            if (tipo == 1) {
                return Double.compare(valorA, valorB);
            } 
            else {
                return Double.compare(valorB, valorA);
            }
        } 
        catch (NumberFormatException e) {
            System.err.println("Erro ao converter valores: " + e.getMessage());
            e.printStackTrace();
        }

        return 0;
    }

    private double converterParaDouble(String valor) {
        if (valor == null || valor.isEmpty()) {
            return 0.0;
        }

        valor = valor.replaceAll("[^0-9.]", "");

        if (valor.isEmpty()) {
            return 0.0;
        }

        try {
            return Double.parseDouble(valor);
        } 
        catch (NumberFormatException e) {
            System.err.println("Erro ao converter valor: " + e.getMessage());
            e.printStackTrace();
            return 0.0;
        }
    }
    
    private void mergeSortMes(String[] vetor, int colunaOrdenacao, int tipo) {

        if (vetor.length > 1) {
            int meio = vetor.length / 2;

            String[] metadeEsquerda = Arrays.copyOfRange(vetor, 1, meio);
            String[] metadeDireita = Arrays.copyOfRange(vetor, meio, vetor.length);

            mergeSortData(metadeEsquerda, colunaOrdenacao, tipo);
            mergeSortData(metadeDireita, colunaOrdenacao, tipo);

            int i = 0, j = 0, k = 0;

            while (i < metadeEsquerda.length && j < metadeDireita.length) {
                String[] linhaA = metadeEsquerda[i].split(",");
                String[] linhaB = metadeDireita[j].split(",");

                if (linhaA.length <= colunaOrdenacao || linhaB.length <= colunaOrdenacao) {                
                    i++;
                    j++;
                    continue;
                }

                try {
                    String dataA = linhaA[colunaOrdenacao];
                    String dataB = linhaB[colunaOrdenacao];

                    String[] partesDataA = dataA.split("/");
                    String[] partesDataB = dataB.split("/");

                    int mesA = Integer.parseInt(partesDataA[1]);
                    int mesB = Integer.parseInt(partesDataB[1]);

                    if (tipo == 2) {
                        if (mesA > mesB) {
                            vetor[k] = metadeEsquerda[i];
                            i++;
                        } 
                        else {
                            vetor[k] = metadeDireita[j];
                            j++;
                        }
                    } 
                    else {
                        if (mesA < mesB) {
                            vetor[k] = metadeEsquerda[i];
                            i++;
                        } 
                        else {
                            vetor[k] = metadeDireita[j];
                            j++;
                        }
                    }
                } 
                catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    i++;
                    j++;
                }
                k++;
            }
            
            while (i < metadeEsquerda.length) {
                vetor[k] = metadeEsquerda[i];
                i++;
                k++;
            }

            while (j < metadeDireita.length) {
                vetor[k] = metadeDireita[j];
                j++;
                k++;
            }
        }
    }
    
    private void mergeSortData(String[] vetor, int colunaOrdenacao, int tipo) {
        
        if (vetor.length > 1) {
            int meio = vetor.length / 2;

            String[] metadeEsquerda = Arrays.copyOfRange(vetor, 1, meio);
            String[] metadeDireita = Arrays.copyOfRange(vetor, meio, vetor.length);

            mergeSortData(metadeEsquerda, colunaOrdenacao, tipo);
            mergeSortData(metadeDireita, colunaOrdenacao, tipo);

            int i = 0, j = 0, k = 0;
        
            while (i < metadeEsquerda.length && j < metadeDireita.length) {
                String[] linhaA = metadeEsquerda[i].split(",");
                String[] linhaB = metadeDireita[j].split(",");
            
                if (linhaA.length <= colunaOrdenacao || linhaB.length <= colunaOrdenacao) {
                // Trate os casos em que não há dados suficientes para ordenação
                    i++;
                    j++;
                    continue;
                }

                try {
                    String dataA = linhaA[colunaOrdenacao];
                    String dataB = linhaB[colunaOrdenacao];

                    String[] partesDataA = dataA.split("/");
                    String[] partesDataB = dataB.split("/");

                    int anoA = Integer.parseInt(partesDataA[2]);
                    int anoB = Integer.parseInt(partesDataB[2]);

                    
                    if(tipo == 2){
                        if (anoA > anoB || (anoA == anoB && partesDataA[1].compareTo(partesDataB[1]) > 0) || (anoA == anoB && partesDataA[1].equals(partesDataB[1]) && partesDataA[0].compareTo(partesDataB[0]) > 0)) {
                            vetor[k] = metadeEsquerda[i];
                            i++;
                        }
                        else {
                            vetor[k] = metadeDireita[j];
                            j++;
                        }
                    }
                    else{
                        if (anoA < anoB || (anoA == anoB && partesDataA[1].compareTo(partesDataB[1]) < 0) || (anoA == anoB && partesDataA[1].equals(partesDataB[1]) && partesDataA[0].compareTo(partesDataB[0]) < 0)) {
                            vetor[k] = metadeEsquerda[i];
                            i++;
                        } 
                        else {
                            vetor[k] = metadeDireita[j];
                            j++;
                        }
                    }               
                } 
                catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    // Trate exceções
                    i++;
                    j++;
                }
                k++;
            }

            // Lidar com elementos restantes em ambas as metades
            while (i < metadeEsquerda.length) {
                vetor[k] = metadeEsquerda[i];
                i++;
                k++;
            }

            while (j < metadeDireita.length) {
                vetor[k] = metadeDireita[j];
                j++;
                k++;
            }
        }
    }
    
}

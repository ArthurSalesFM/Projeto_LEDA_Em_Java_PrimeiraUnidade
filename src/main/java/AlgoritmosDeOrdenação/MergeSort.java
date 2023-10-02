package AlgoritmosDeOrdenação;

import Interfaces.I_Ordenacao;

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
        mergeSortMes(vetor, colunaOrdenacao, 1, vetor.length - 1, 1);
        return vetor;
    }

    @Override
    public String[] ordenacaoPiorCasoCampoMes(String[] vetor, int colunaOrdenacao) {
        mergeSortMes(vetor, colunaOrdenacao, 1, vetor.length - 1, 2);
        return vetor;
    }

    @Override
    public String[] ordenacaoMedioMelhorCasoCampoData(String[] vetor, int colunaOrdenacao) {
        mergeSortData(vetor, colunaOrdenacao, 1, vetor.length - 1, 1);
        return vetor;
    }

    @Override
    public String[] ordenacaoPiorCasoCampoData(String[] vetor, int colunaOrdenacao) {
        mergeSortData(vetor, colunaOrdenacao, 1, vetor.length - 1, 1);
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

    private void mergeSortMes(String[] vetor, int colunaOrdenacao, int inicio, int fim, int tipo) { 
        if (inicio < fim) {
            int meio = inicio + (fim - inicio) / 2;

            mergeSortMes(vetor, colunaOrdenacao, inicio, meio, tipo);
            mergeSortMes(vetor, colunaOrdenacao, meio + 1, fim, tipo);

            mergeMes(vetor, colunaOrdenacao, inicio, meio, fim, tipo);
        }
    }
    
    private void mergeSortData(String[] vetor, int colunaOrdenacao, int inicio, int fim, int tipo) {
        if (inicio < fim) {
            int meio = inicio + (fim - inicio) / 2;

            mergeSortData(vetor, colunaOrdenacao, inicio, meio, tipo);
            mergeSortData(vetor, colunaOrdenacao, meio + 1, fim, tipo);

            mergeData(vetor, colunaOrdenacao, inicio, meio, fim, tipo);
        }
    }

    private void mergeLength(String[] vetor, int colunaOrdenacao, int inicio, int meio, int fim, int tipo) {
        int tamanho1 = meio - inicio + 1;
        int tamanho2 = fim - meio;
    
        String[] metadeEsquerda = new String[tamanho1];
        String[] metadeDireita = new String[tamanho2];
    
        for (int i = 0; i < tamanho1; i++) {
            metadeEsquerda[i] = vetor[inicio + i];
        }
    
        for (int j = 0; j < tamanho2; j++) {
            metadeDireita[j] = vetor[meio + 1 + j];
        }
    
        int i = 0, j = 0;
        int k = inicio;
    
        while (i < tamanho1 && j < tamanho2) {
            
            if(tipo == 1){
                if (compararLinhasLength(metadeEsquerda[i], metadeDireita[j], colunaOrdenacao, tipo) <= 0) {
                    vetor[k] = metadeEsquerda[i];
                    i++;
                } 
                else {
                    vetor[k] = metadeDireita[j];
                    j++;
                }
                k++;
            }
            else{
                if (compararLinhasLength(metadeEsquerda[i], metadeDireita[j], colunaOrdenacao, tipo) <= 0) {
                    vetor[k] = metadeEsquerda[i];
                    i++;
                } 
                else {
                    vetor[k] = metadeDireita[j];
                    j++;
                }
                k++;
            }          
        }
    
        while (i < tamanho1) {
            vetor[k] = metadeEsquerda[i];
            i++;
            k++;
        }
    
        while (j < tamanho2) {
            vetor[k] = metadeDireita[j];
            j++;
            k++;
        }
    }
    
    private void mergeMes(String[] vetor, int colunaOrdenacao, int inicio, int meio, int fim, int tipo) {
        int tamanho1 = meio - inicio + 1;
        int tamanho2 = fim - meio;

        String[] metadeEsquerda = new String[tamanho1];
        String[] metadeDireita = new String[tamanho2];

        for (int i = 0; i < tamanho1; i++) {
            metadeEsquerda[i] = vetor[inicio + i];
        }

        for (int j = 0; j < tamanho2; j++) {
            metadeDireita[j] = vetor[meio + 1 + j];
        }

        int i = 0, j = 0;
        int k = inicio;

        while (i < tamanho1 && j < tamanho2) {
            if (tipo == 1) {
                if (compararLinhasMes(metadeEsquerda[i], metadeDireita[j], colunaOrdenacao, tipo) <= 0) {
                    vetor[k] = metadeEsquerda[i];
                    i++;
                } 
                else {
                    vetor[k] = metadeDireita[j];
                    j++;
                }
            } 
            else {
                if (compararLinhasMes(metadeEsquerda[i], metadeDireita[j], colunaOrdenacao, tipo) <= 0) {
                    vetor[k] = metadeEsquerda[i];
                    i++;
                } 
                else {
                    vetor[k] = metadeDireita[j];
                    j++;
                }
            }
            k++;
        }

        while (i < tamanho1) {
            vetor[k] = metadeEsquerda[i];
            i++;
            k++;
        }

        while (j < tamanho2) {
            vetor[k] = metadeDireita[j];
            j++;
            k++;
        }
    }
    
    private void mergeData(String[] vetor, int colunaOrdenacao, int inicio, int meio, int fim, int tipo) {
        int tamanho1 = meio - inicio + 1;
        int tamanho2 = fim - meio;

        String[] metadeEsquerda = new String[tamanho1];
        String[] metadeDireita = new String[tamanho2];

        for (int i = 0; i < tamanho1; i++) {
            metadeEsquerda[i] = vetor[inicio + i];
        }

        for (int j = 0; j < tamanho2; j++) {
            metadeDireita[j] = vetor[meio + 1 + j];
        }

        int i = 0, j = 0;
        int k = inicio;

        while (i < tamanho1 && j < tamanho2) {
        
            int comparacao;
        
            if(tipo == 1){
                comparacao = compararLinhasDataCrescente(metadeEsquerda[i], metadeDireita[j], colunaOrdenacao);
            }
            else{
                comparacao = compararLinhasDataDecrescente(metadeEsquerda[i], metadeDireita[j], colunaOrdenacao);
            }        

            if (comparacao <= 0) {
                vetor[k] = metadeEsquerda[i];
                i++;
            } 
            else {
                vetor[k] = metadeDireita[j];
                j++;
            }
            k++;
        }

        while (i < tamanho1) {
            vetor[k] = metadeEsquerda[i];
            i++;
            k++;
        }

        while (j < tamanho2) {
            vetor[k] = metadeDireita[j];
            j++;
            k++;
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
    
    private int compararLinhasMes(String linhaA, String linhaB, int colunaOrdenacao, int tipo) {
        String[] partesA = linhaA.split(",");
        String[] partesB = linhaB.split(",");

        if (partesA.length <= colunaOrdenacao || partesB.length <= colunaOrdenacao) {
            return tipo == 1 ? 1 : -1;
        }

        String dataA = partesA[colunaOrdenacao];
        String dataB = partesB[colunaOrdenacao];

        if (isValidDate(dataA) && isValidDate(dataB)) {
            try {
                double mesA = Double.parseDouble(dataA.split("/")[1]);
                double mesB = Double.parseDouble(dataB.split("/")[1]);

                if (tipo == 1) {
                    return Double.compare(mesB, mesA);
                } 
                else {
                    return Double.compare(mesA, mesB);
                }
            } 
            catch (NumberFormatException e) {
                System.err.println("Erro ao converter valores: " + e.getMessage());
                e.printStackTrace();
            }
        }

        return tipo == 1 ? 1 : -1;
    }

    private int compararLinhasDataCrescente(String linhaA, String linhaB, int colunaOrdenacao) {
        String[] partesA = linhaA.split(",");
        String[] partesB = linhaB.split(",");

        if (partesA.length <= colunaOrdenacao || partesB.length <= colunaOrdenacao) {
            return -1;
        }

        String dataA = partesA[colunaOrdenacao];
        String dataB = partesB[colunaOrdenacao];

        if (isValidDate(dataA) && isValidDate(dataB)) {
            try {
                String[] partesDataA = dataA.split("/");
                String[] partesDataB = dataB.split("/");

                double anoA = Double.parseDouble(partesDataA[2]);
                double anoB = Double.parseDouble(partesDataB[2]);

                int comparacaoAno = Double.compare(anoA, anoB);
                if (comparacaoAno != 0) {
                    return comparacaoAno;
                }

                double mesA = Double.parseDouble(partesDataA[1]);
                double mesB = Double.parseDouble(partesDataB[1]);

                int comparacaoMes = Double.compare(mesA, mesB);
                if (comparacaoMes != 0) {
                    return comparacaoMes;
                }

                double diaA = Double.parseDouble(partesDataA[0]);
                double diaB = Double.parseDouble(partesDataB[0]);

                return Double.compare(diaA, diaB);
            } 
            catch (NumberFormatException e) {
                System.err.println("Erro ao converter valores: " + e.getMessage());
                e.printStackTrace();
            }
        }

        return -1;
    }

    private int compararLinhasDataDecrescente(String linhaA, String linhaB, int colunaOrdenacao) {
        String[] partesA = linhaA.split(",");
        String[] partesB = linhaB.split(",");

        if (partesA.length <= colunaOrdenacao || partesB.length <= colunaOrdenacao) {
            return 1; 
        }

        String dataA = partesA[colunaOrdenacao];
        String dataB = partesB[colunaOrdenacao];

        if (isValidDate(dataA) && isValidDate(dataB)) {
            try {
                String[] partesDataA = dataA.split("/");
                String[] partesDataB = dataB.split("/");

                double anoA = Double.parseDouble(partesDataA[2]);
                double anoB = Double.parseDouble(partesDataB[2]);

                int comparacaoAno = Double.compare(anoB, anoA);
                if (comparacaoAno != 0) {
                    return comparacaoAno;
                }

                double mesA = Double.parseDouble(partesDataA[1]);
                double mesB = Double.parseDouble(partesDataB[1]);

                int comparacaoMes = Double.compare(mesB, mesA);
                if (comparacaoMes != 0) {
                    return comparacaoMes;
                }

                double diaA = Double.parseDouble(partesDataA[0]);
                double diaB = Double.parseDouble(partesDataB[0]);

                return Double.compare(diaB, diaA); 
            } 
            catch (NumberFormatException e) {
                System.err.println("Erro ao converter valores: " + e.getMessage());
                e.printStackTrace();
            }
        }

        return 1;
    }

    private boolean isValidDate(String date) {
        return date.matches("\\d{2}/\\d{2}/\\d{4}");
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
    
}

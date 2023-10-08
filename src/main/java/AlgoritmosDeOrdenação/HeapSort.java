package AlgoritmosDeOrdenação;

import Interfaces.I_Ordenacao;

/**
 *
 * @author Arthur Felipe MS
 */
public class HeapSort implements I_Ordenacao{

    @Override
    public String[] ordenacaoMedioMelhorCasoCampoLength(String[] vetor, int colunaOrdenacao) {
        heapSortLength(vetor, 1);
        return vetor;
    }

    @Override
    public String[] ordenacaoPiorCasoCampoLength(String[] vetor, int colunaOrdenacao) {
        heapSortLength(vetor, 2);
        return vetor;
    }

    @Override
    public String[] ordenacaoMedioMelhorCasoCampoMes(String[] vetor, int colunaOrdenacao) {
        //heapSortMes(vetor, 1);
        return vetor;
    }

    @Override
    public String[] ordenacaoPiorCasoCampoMes(String[] vetor, int colunaOrdenacao) {
        //heapSortMes(vetor, 2);
        return vetor;
    }

    @Override
    public String[] ordenacaoMedioMelhorCasoCampoData(String[] vetor, int colunaOrdenacao) {
        //heapSortData(vetor, 1);
        return vetor;
    }

    @Override
    public String[] ordenacaoPiorCasoCampoData(String[] vetor, int colunaOrdenacao) {
        //heapSortData(vetor, 2);
        return vetor;
    }
    
    
    private void heapSortLength(String[] vetor, int tipo) {
        int n = vetor.length;

        for (int i = (n / 2) - 1; i >= 1; i--) {
            heapifyLength(vetor, n, i, tipo);
        }

        for (int i = n - 1; i >= 2; i--) {
            String temp = vetor[1];
            vetor[1] = vetor[i];
            vetor[i] = temp;

            heapifyLength(vetor, i, 1, tipo);
        }
    }
    
    private void heapifyLength(String[] vetor, int n, int i, int tipo) {
        int maior = i;
        int esquerda = 2 * i;
        int direita = (2 * i) + 1;

        if (esquerda < n && compareLength(vetor[esquerda], vetor[maior], tipo) > 0) {
            maior = esquerda;
        }

        if (direita < n && compareLength(vetor[direita], vetor[maior], tipo) > 0) {
            maior = direita;
        }

        if (maior != i) {
            String temp = vetor[i];
            vetor[i] = vetor[maior];
            vetor[maior] = temp;

            heapifyLength(vetor, n, maior, tipo);
        }
    }
    
    
    private int compareLength(String a, String b, int tipo) {
        String[] partesDataA = a.split(",");
        String[] partesDataB = b.split(",");

        if (partesDataA.length <= 2 || partesDataB.length <= 2) {
            return 0;
        }

        String tamanhoA = partesDataA[partesDataA.length - 3];
        String tamanhoB = partesDataB[partesDataB.length - 3];

        int lengthA = Integer.parseInt(tamanhoA);
        int lengthB = Integer.parseInt(tamanhoB);

        if (tipo == 2) {
            if (lengthA > lengthB ) {
                return 1;
            } 
            else {
                return 0;
            }
        } 
        else {
            if (lengthA < lengthB) {
                return 1;
            } 
            else {
                return 0;
            }
        }
    }
    
     /*
    private void heapSortMes(String[] vetor, int tipo) {
        int n = vetor.length;

        for (int i = (n / 2) - 1; i >= 1; i--) {
            heapifyMes(vetor, n, i, tipo);
        }

        for (int i = n - 1; i >= 2; i--) {
            String temp = vetor[1];
            vetor[1] = vetor[i];
            vetor[i] = temp;

            heapifyMes(vetor, i, 1, tipo);
        }
    }
    
    private void heapifyMes(String[] vetor, int n, int i, int tipo) {
        int maior = i;
        int esquerda = 2 * i;
        int direita = (2 * i) + 1;

        if (esquerda < n && compareMes(vetor[esquerda], vetor[maior], tipo) > 0) {
            maior = esquerda;
        }

        if (direita < n && compareMes(vetor[direita], vetor[maior], tipo) > 0) {
            maior = direita;
        }

        if (maior != i) {
            String temp = vetor[i];
            vetor[i] = vetor[maior];
            vetor[maior] = temp;

            heapifyMes(vetor, n, maior, tipo);
        }
    }
    
    private int compareMes(String a, String b, int tipo) {
        String[] partesDataA = a.split(",");
        String[] partesDataB = b.split(",");

        if (partesDataA.length <= 2 || partesDataB.length <= 2) {
            return 0;
        }

        String dataA = partesDataA[partesDataA.length - 2];
        String dataB = partesDataB[partesDataB.length - 2];

        String[] partesDataNumericaA = dataA.split("/");
        String[] partesDataNumericaB = dataB.split("/");

        int mesA = Integer.parseInt(partesDataNumericaA[1]);
        int mesB = Integer.parseInt(partesDataNumericaB[1]);

        if (tipo == 2) {
            if (mesA > mesB ) {
                return 1;
            } 
            else {
                return 0;
            }
        } 
        else {
            if (mesA < mesB) {
                return 1;
            } 
            else {
                return 0;
            }
        }
    }
    
    
    
   
    private void heapSortData(String[] vetor, int tipo) {
        int n = vetor.length;

        for (int i = (n / 2) - 1; i >= 1; i--) {
            heapifyData(vetor, n, i, tipo);
        }

        for (int i = n - 1; i >= 2; i--) {
            String temp = vetor[1];
            vetor[1] = vetor[i];
            vetor[i] = temp;

            heapifyData(vetor, i, 1, tipo);
        }
    }

    private void heapifyData(String[] vetor, int n, int i, int tipo) {
        int maior = i;
        int esquerda = 2 * i;
        int direita = (2 * i) + 1;

        if (esquerda < n && compareData(vetor[esquerda], vetor[maior], tipo) > 0) {
            maior = esquerda;
        }

        if (direita < n && compareData(vetor[direita], vetor[maior], tipo) > 0) {
            maior = direita;
        }

        if (maior != i) {
            String temp = vetor[i];
            vetor[i] = vetor[maior];
            vetor[maior] = temp;

            heapifyData(vetor, n, maior, tipo);
        }
    }

    private int compareData(String a, String b, int tipo) {
        String[] partesDataA = a.split(",");
        String[] partesDataB = b.split(",");

        if (partesDataA.length <= 2 || partesDataB.length <= 2) {
            return 0;
        }

        String dataA = partesDataA[partesDataA.length - 2];
        String dataB = partesDataB[partesDataB.length - 2];

        String[] partesDataNumericaA = dataA.split("/");
        String[] partesDataNumericaB = dataB.split("/");

        int anoA = Integer.parseInt(partesDataNumericaA[2]);
        int mesA = Integer.parseInt(partesDataNumericaA[1]);
        int diaA = Integer.parseInt(partesDataNumericaA[0]);

        int anoB = Integer.parseInt(partesDataNumericaB[2]);
        int mesB = Integer.parseInt(partesDataNumericaB[1]);
        int diaB = Integer.parseInt(partesDataNumericaB[0]);

        if (tipo == 2) {
            if (anoA > anoB || (anoA == anoB && mesA > mesB) || (anoA == anoB && mesA == mesB && diaA > diaB)) {
                return 1;
            } 
            else if (anoA < anoB || (anoA == anoB && mesA < mesB) || (anoA == anoB && mesA == mesB && diaA < diaB)) {
                return -1;
            } 
            else {
                return 0;
            }
        } 
        else {
            if (anoA < anoB || (anoA == anoB && mesA < mesB) || (anoA == anoB && mesA == mesB && diaA < diaB)) {
                return 1;
            } 
            else if (anoA > anoB || (anoA == anoB && mesA > mesB) || (anoA == anoB && mesA == mesB && diaA > diaB)) {
                return -1;
            } 
            else {
                return 0;
            }
        }
    }
    */
}

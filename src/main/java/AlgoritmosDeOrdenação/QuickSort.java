package AlgoritmosDeOrdenação;

import Interfaces.I_Ordenacao;

/**
 *
 * @author Arthur Felipe MS
 */
public class QuickSort implements I_Ordenacao{
    
    public QuickSort(){
        
    }

    @Override
    public String[] ordenacaoMedioMelhorCasoCampoLength(String[] vetor, int colunaOrdenacao) {
        quickSortLength(vetor, 1, vetor.length - 1, colunaOrdenacao, 1);
        return vetor;
    }

    @Override
    public String[] ordenacaoPiorCasoCampoLength(String[] vetor, int colunaOrdenacao) {
        quickSortLength(vetor, 1, vetor.length - 1, colunaOrdenacao, 2);
        return vetor;
    }

    @Override
    public String[] ordenacaoMedioMelhorCasoCampoMes(String[] vetor, int colunaOrdenacao) {
        quickSortMes(vetor, 1, vetor.length - 1, colunaOrdenacao, 1 );
        return vetor;
    }

    @Override
    public String[] ordenacaoPiorCasoCampoMes(String[] vetor, int colunaOrdenacao) {
        quickSortMes(vetor, 1, vetor.length - 1, colunaOrdenacao, 2 );
        return vetor;
    }

    @Override
    public String[] ordenacaoMedioMelhorCasoCampoData(String[] vetor, int colunaOrdenacao) {
        quickSortData(vetor, 1, vetor.length - 1, colunaOrdenacao, 1);
        return vetor;
    }

    @Override
    public String[] ordenacaoPiorCasoCampoData(String[] vetor, int colunaOrdenacao) {
        quickSortData(vetor, 1, vetor.length - 1, colunaOrdenacao, 2);
        return vetor;
    }
    
    private void quickSortData(String[] vetor, int inicio, int fim, int colunaOrdenacao, int tipo) {
        if (inicio < fim) {
            int indiceParticao = particionarData(vetor, inicio, fim, colunaOrdenacao, tipo);

            quickSortData(vetor, inicio, indiceParticao - 1, colunaOrdenacao, tipo);
            quickSortData(vetor, indiceParticao + 1, fim, colunaOrdenacao, tipo);
        }
    }
    
    private int compararStringsData(String str1, String str2, int colunaOrdenacao, int tipo) {
        String[] camposA = str1.split(",");
        String[] camposB = str2.split(",");

        if (colunaOrdenacao < 0 || colunaOrdenacao >= camposA.length || colunaOrdenacao >= camposB.length) {
            return 0;
        }

        String dataA = camposA[colunaOrdenacao];
        String dataB = camposB[colunaOrdenacao];

        String[] partesDataA = dataA.split("/");
        String[] partesDataB = dataB.split("/");

        int anoA = Integer.parseInt(partesDataA[2]);
        int anoB = Integer.parseInt(partesDataB[2]);

        if (tipo == 2) {
            if (anoA > anoB || (anoA == anoB && partesDataA[1].compareTo(partesDataB[1]) > 0) || (anoA == anoB && partesDataA[1].equals(partesDataB[1]) && partesDataA[0].compareTo(partesDataB[0]) > 0)) {
                return 1;
            } 
            else if (anoA == anoB && partesDataA[1].equals(partesDataB[1]) && partesDataA[0].equals(partesDataB[0])) {
                return 0;
            } 
            else {
                return -1;
            }
        } 
        else {
            if (anoA < anoB || (anoA == anoB && partesDataA[1].compareTo(partesDataB[1]) < 0) || (anoA == anoB && partesDataA[1].equals(partesDataB[1]) && partesDataA[0].compareTo(partesDataB[0]) < 0)) {
                return 1;
            } 
            else if (anoA == anoB && partesDataA[1].equals(partesDataB[1]) && partesDataA[0].equals(partesDataB[0])) {
                return 0;
            } 
            else {
                return -1;
            }
        }
    }
    
    private int particionarData(String[] vetor, int inicio, int fim, int colunaOrdenacao, int tipo) {
        String pivo = vetor[fim];
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (compararStringsData(vetor[j], pivo, colunaOrdenacao, tipo) <= 0) {
                i++;
                trocarElementos(vetor, i, j);
            }
        }

        trocarElementos(vetor, i + 1, fim);
        return i + 1;
    }
    
    private void quickSortMes(String[] vetor, int inicio, int fim, int colunaOrdenacao, int tipo) {
        if (inicio < fim) {
            int indiceParticao = particionarMes(vetor, inicio, fim, colunaOrdenacao, tipo);

            quickSortMes(vetor, inicio, indiceParticao - 1, colunaOrdenacao, tipo);
            quickSortMes(vetor, indiceParticao + 1, fim, colunaOrdenacao, tipo);
        }
    }   
    
    private int particionarMes(String[] vetor, int inicio, int fim, int colunaOrdenacao, int tipo) {
        String pivo = vetor[fim];
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (compararStringsMes(vetor[j], pivo, colunaOrdenacao, tipo) <= 0) {
                i++;
                trocarElementos(vetor, i, j);
            }
        }

        trocarElementos(vetor, i + 1, fim);
        return i + 1;
    }
    
    private int compararStringsMes(String str1, String str2, int colunaOrdenacao, int tipo) {
        String[] camposA = str1.split(",");
        String[] camposB = str2.split(",");

        if (colunaOrdenacao < 0 || colunaOrdenacao >= camposA.length || colunaOrdenacao >= camposB.length) {
            return 0;
        }

        String dataA = camposA[colunaOrdenacao];
        String dataB = camposB[colunaOrdenacao];

        String[] partesDataA = dataA.split("/");
        String[] partesDataB = dataB.split("/");

        if (partesDataA.length < 2 || partesDataB.length < 2) {
            return 0;
        }

        int mesA = Integer.parseInt(partesDataA[1]);
        int mesB = Integer.parseInt(partesDataB[1]);

        if (tipo == 2) {
             if (mesA > mesB) {
                return 1;
            }
            else {
                return -1;
            }
        }
        else{
            if (mesA < mesB) {
                return 1;
            }
            else {
                return -1;
            }
        }        
    }
    
    private void quickSortLength(String[] vetor, int inicio, int fim, int colunaOrdenacao, int tipo) {
        if (inicio < fim) {
            int indiceParticao = particionarLength(vetor, inicio, fim, colunaOrdenacao, tipo);

            quickSortLength(vetor, inicio, indiceParticao - 1, colunaOrdenacao, tipo);
            quickSortLength(vetor, indiceParticao + 1, fim, colunaOrdenacao, tipo);
        }
    } 
        
    private int particionarLength(String[] vetor, int inicio, int fim, int colunaOrdenacao, int tipo) {
        String pivo = vetor[fim];
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (compararStringsLength(vetor[j], pivo, colunaOrdenacao, tipo) <= 0) {
                i++;
                trocarElementos(vetor, i, j);
            }
        }

        trocarElementos(vetor, i + 1, fim);
        return i + 1;
    }
 
    private int compararStringsLength(String str1, String str2, int colunaOrdenacao, int tipo) {
        String[] camposA = str1.split(",");
        String[] camposB = str2.split(",");

        if (colunaOrdenacao < 0 || colunaOrdenacao >= camposA.length || colunaOrdenacao >= camposB.length) {
            return 0;
        }

        int valorA = Integer.parseInt(camposA[colunaOrdenacao]);
        int valorB = Integer.parseInt(camposB[colunaOrdenacao]);

        if (tipo == 2) {
            return Integer.compare(valorA, valorB); // Ordenação ascendente
        } 
        else {
            return Integer.compare(valorB, valorA); // Ordenação descendente
        }
    }

    
    private void trocarElementos(String[] vetor, int i, int j) {
        String temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
  
}

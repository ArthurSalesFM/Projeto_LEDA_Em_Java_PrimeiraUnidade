package AlgoritmosDeOrdenação;

import Interfaces.I_Ordenacao;

/**
 *
 * @author Arthur Felipe MS
 */
public class QuickSort_Com_MedianaDe3 implements I_Ordenacao{
    
    public QuickSort_Com_MedianaDe3(){
        
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
    
    
    //================================   LENGTH   ================================    
    private void quickSortLength(String[] vetor, int inicio, int fim, int colunaOrdenacao, int tipo) {
        if (inicio < fim) {
            int posicaoPivo = particionarLength(vetor, inicio, fim, colunaOrdenacao, tipo);

            quickSortLength(vetor, inicio, posicaoPivo, colunaOrdenacao, tipo);
            quickSortLength(vetor, posicaoPivo + 1, fim, colunaOrdenacao, tipo);
        }
    }
  
    private int compararStringsLength(String str1, String str2, int colunaOrdenacao, int tipo) {
        String[] camposA = str1.split(",");
        String[] camposB = str2.split(",");

        if (colunaOrdenacao < 0 || colunaOrdenacao >= camposA.length || colunaOrdenacao >= camposB.length) {
            return 0;
        }

        String campoA = camposA[camposA.length - 3];
        String campoB = camposB[camposB.length - 3];
    
        int tamanhoA = Integer.parseInt(campoA);
        int tamanhoB = Integer.parseInt(campoB);

        if (tipo == 2) {
            if (tamanhoA > tamanhoB) {
                return 1;
            } 
            else if (tamanhoA == tamanhoB) {
                return 0;
            } 
            else {
                return -1;
            }
        } 
        else {
            if (tamanhoA < tamanhoB) {
                return 1;
            } 
            else if (tamanhoA == tamanhoB) {
                return 0;
            } 
            else {
                return -1;
            }
        }
    }
    
    private int particionarLength(String[] vetor, int inicio, int fim, int colunaOrdenacao, int tipo) {
        String pivo = medianaDeTresLength(vetor[inicio], vetor[(inicio + fim) / 2], vetor[fim], colunaOrdenacao, tipo);

        int i = inicio;
        int j = fim;

        while (true) {
            while (compararStringsLength(vetor[i], pivo, colunaOrdenacao, tipo) < 0) {
                i++;
            }
            while (compararStringsLength(vetor[j], pivo, colunaOrdenacao, tipo) > 0) {
                j--;
            }
            if (i >= j) {
                return j;
            }
            trocarElementos(vetor, i, j);
            i++;
            j--;
        }
    }

    
    //================================   MÊS   ================================    
    private void quickSortMes(String[] vetor, int inicio, int fim, int colunaOrdenacao, int tipo) {
        if (inicio < fim) {
            int posicaoPivo = particionarMes(vetor, inicio, fim, colunaOrdenacao, tipo);

            quickSortMes(vetor, inicio, posicaoPivo, colunaOrdenacao, tipo);
            quickSortMes(vetor, posicaoPivo + 1, fim, colunaOrdenacao, tipo);
        }
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

        int mesA = Integer.parseInt(partesDataA[1]);
        int mesB = Integer.parseInt(partesDataB[1]);

        if (tipo == 2) {
            if (mesA > mesB) {
                return 1;
            } 
            else if (mesA == mesB) {
                return 0;
            } 
            else {
                return -1;
            }
        } 
        else {
            if (mesA < mesB) {
                return 1;
            } 
            else if (mesA == mesB) {
                return 0;
            } 
            else {
                return -1;
            }
        }
    }
    
    private int particionarMes(String[] vetor, int inicio, int fim, int colunaOrdenacao, int tipo) {
        String pivo = medianaDeTresMes(vetor[inicio], vetor[(inicio + fim) / 2], vetor[fim], colunaOrdenacao, tipo);

        int i = inicio;
        int j = fim;

        while (true) {
            while (compararStringsMes(vetor[i], pivo, colunaOrdenacao, tipo) < 0) {
                i++;
            }
            while (compararStringsMes(vetor[j], pivo, colunaOrdenacao, tipo) > 0) {
                j--;
            }
            if (i >= j) {
                return j;
            }
            trocarElementos(vetor, i, j);
            i++;
            j--;
        }
    }   
    
    
    //================================   DATA   ================================    
    private void quickSortData(String[] vetor, int inicio, int fim, int colunaOrdenacao, int tipo) {
        if (inicio < fim) {
            int posicaoPivo = particionarData(vetor, inicio, fim, colunaOrdenacao, tipo);
            
            quickSortData(vetor, inicio, posicaoPivo, colunaOrdenacao, tipo);
            quickSortData(vetor, posicaoPivo + 1, fim, colunaOrdenacao, tipo);
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
        int meio = (inicio + fim) / 2;
        String pivo = medianaDeTresData(vetor[inicio], vetor[meio], vetor[fim], colunaOrdenacao, tipo);

        int i = inicio;
        int j = fim;

        while (true) {
            while (compararStringsData(vetor[i], pivo, colunaOrdenacao, tipo) < 0) {
                i++;
            }
            while (compararStringsData(vetor[j], pivo, colunaOrdenacao, tipo) > 0) {
                j--;
            }
            if (i >= j) {
                return j;
            }
            trocarElementos(vetor, i, j);
            i++;
            j--;
        }
    }

    
    //================================   OUTROS   ================================        
    private String medianaDeTresLength(String a, String b, String c, int colunaOrdenacao, int tipo) {
        if (compararStringsLength(a, b, colunaOrdenacao, tipo) <= 0 && compararStringsLength(b, c, colunaOrdenacao, tipo) <= 0) {
            return b;
        } 
        else if (compararStringsLength(a, c, colunaOrdenacao, tipo) <= 0 && compararStringsLength(c, b, colunaOrdenacao, tipo) <= 0) {
            return c;
        } 
        else {
            return a;
        }
    }
 
    private String medianaDeTresMes(String a, String b, String c, int colunaOrdenacao, int tipo) {
        if (compararStringsMes(a, b, colunaOrdenacao, tipo) <= 0 && compararStringsMes(b, c, colunaOrdenacao, tipo) <= 0) {
            return b;
        } 
        else if (compararStringsMes(a, c, colunaOrdenacao, tipo) <= 0 && compararStringsMes(c, b, colunaOrdenacao, tipo) <= 0) {
            return c;
        } 
        else {
            return a;
        }
    }  
    
    private String medianaDeTresData(String a, String b, String c, int colunaOrdenacao, int tipo) {
        if (compararStringsData(a, b, colunaOrdenacao, tipo) <= 0 && compararStringsData(b, c, colunaOrdenacao, tipo) <= 0) {
            return b;
        } 
        else if (compararStringsData(a, c, colunaOrdenacao, tipo) <= 0 && compararStringsData(c, b, colunaOrdenacao, tipo) <= 0) {
            return c;
        } 
        else {
            return a;
        }
    }
    
    private void trocarElementos(String[] vetor, int i, int j) {
        String temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
   
}

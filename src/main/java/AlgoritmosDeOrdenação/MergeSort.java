package AlgoritmosDeOrdenação;

import Interfaces.I_Ordenacao;

/**
 *
 * @author Arthur Felipe MS
 */
public class MergeSort implements I_Ordenacao{

    @Override
    public String[] ordenacaoMedioMelhorCasoCampoLength(String[] vetor, int colunaOrdenacao) {
        mergeSortLength(vetor, 1, vetor.length, 2);
        return vetor;
    }

    @Override
    public String[] ordenacaoPiorCasoCampoLength(String[] vetor, int colunaOrdenacao) {
        mergeSortLength(vetor, 1, vetor.length, 1);
        return vetor;
    }

    @Override
    public String[] ordenacaoMedioMelhorCasoCampoMes(String[] vetor, int colunaOrdenacao) {
        mergeSortMes(vetor, 1, vetor.length, 2);
        return vetor;
    }

    @Override
    public String[] ordenacaoPiorCasoCampoMes(String[] vetor, int colunaOrdenacao) {
        mergeSortMes(vetor, 1, vetor.length, 1);
        return vetor;
    }

    @Override
    public String[] ordenacaoMedioMelhorCasoCampoData(String[] vetor, int colunaOrdenacao) {
        mergeSortData(vetor, 1, vetor.length, 2);
        return vetor;   
    }

    @Override
    public String[] ordenacaoPiorCasoCampoData(String[] vetor, int colunaOrdenacao) {
        mergeSortData(vetor, 1, vetor.length, 1);
        return vetor;
    }
      
    private void mergeSortLength(String[] vetor, int inicio, int fim, int tipo) {
        if (inicio < fim - 1) {
            int meio = (inicio + fim) / 2;

            mergeSortLength(vetor, inicio, meio, tipo);
            mergeSortLength(vetor, meio, fim, tipo);

            intercalaLength(vetor, inicio, meio, fim, tipo);
        }
    }
    
    private void intercalaLength(String[] vetor, int inicio, int meio, int fim, int tipo) {
        String[] novoVetor = new String[fim - inicio];
        int i = inicio;
        int m = meio;
        int pos = 0;

        while (i < meio && m < fim) {
            String[] linhaA = vetor[i].split(",");
            String[] linhaB = vetor[m].split(",");

            if (linhaA.length <= 2 || linhaB.length <= 2) {
                i++;
                m++;
                continue;
            }

            String lengthA = linhaA[linhaA.length - 3];
            String lengthB = linhaB[linhaB.length - 3];
            
            int A = Integer.parseInt(lengthA);            
            int B = Integer.parseInt(lengthB);

            if (tipo == 2) {
                if (A > B) {
                    novoVetor[pos] = vetor[i];
                    pos++;
                    i++;
                } 
                else {
                    novoVetor[pos] = vetor[m];
                    pos++;
                    m++;
                }
            } 
            else {
                if (A < B) {
                    novoVetor[pos] = vetor[i];
                    pos++;
                    i++;
                } 
                else {
                    novoVetor[pos] = vetor[m];
                    pos++;
                    m++;
                }
            }
        }

        while (i < meio) {
            novoVetor[pos] = vetor[i];
            pos++;
            i++;
        }

        while (m < fim) {
            novoVetor[pos] = vetor[m];
            pos++;
            m++;
        }

        System.arraycopy(novoVetor, 0, vetor, inicio, novoVetor.length);
    } 
    
    private void mergeSortMes(String[] vetor, int inicio, int fim, int tipo) {
        if (inicio < fim - 1) {
            int meio = (inicio + fim) / 2;

            mergeSortMes(vetor, inicio, meio, tipo);
            mergeSortMes(vetor, meio, fim, tipo);

            intercalaMes(vetor, inicio, meio, fim, tipo);
        }
    }

    private void intercalaMes(String[] vetor, int inicio, int meio, int fim, int tipo) {
        String[] novoVetor = new String[fim - inicio];
        int i = inicio;
        int m = meio;
        int pos = 0;

        while (i < meio && m < fim) {
            String[] linhaA = vetor[i].split(",");
            String[] linhaB = vetor[m].split(",");

            if (linhaA.length <= 2 || linhaB.length <= 2) {
                i++;
                m++;
                continue;
            }

            String dataA = linhaA[linhaA.length - 2];
            String dataB = linhaB[linhaB.length - 2];

            String[] partesDataA = dataA.split("/");
            String[] partesDataB = dataB.split("/");

            
            int mesA = Integer.parseInt(partesDataA[1]);            
            int mesB = Integer.parseInt(partesDataB[1]);

            if (tipo == 2) {
                if (mesA > mesB) {
                    novoVetor[pos] = vetor[i];
                    pos++;
                    i++;
                } 
                else {
                    novoVetor[pos] = vetor[m];
                    pos++;
                    m++;
                }
            } 
            else {
                if (mesA< mesB) {
                    novoVetor[pos] = vetor[i];
                    pos++;
                    i++;
                } 
                else {
                    novoVetor[pos] = vetor[m];
                    pos++;
                    m++;
                }
            }
        }

        while (i < meio) {
            novoVetor[pos] = vetor[i];
            pos++;
            i++;
        }

        while (m < fim) {
            novoVetor[pos] = vetor[m];
            pos++;
            m++;
        }

        System.arraycopy(novoVetor, 0, vetor, inicio, novoVetor.length);
    } 
    
    private void mergeSortData(String[] vetor, int inicio, int fim, int tipo) {
        if (inicio < fim - 1) {
            int meio = (inicio + fim) / 2;

            mergeSortData(vetor, inicio, meio, tipo);
            mergeSortData(vetor, meio, fim, tipo);

            intercalaData(vetor, inicio, meio, fim, tipo);
        }
    }

    private void intercalaData(String[] vetor, int inicio, int meio, int fim, int tipo) {
        String[] novoVetor = new String[fim - inicio];
        int i = inicio;
        int m = meio;
        int pos = 0;

        while (i < meio && m < fim) {
            String[] linhaA = vetor[i].split(",");
            String[] linhaB = vetor[m].split(",");

            if (linhaA.length <= 2 || linhaB.length <= 2) {
                i++;
                m++;
                continue;
            }

            String dataA = linhaA[linhaA.length - 2];
            String dataB = linhaB[linhaB.length - 2];

            String[] partesDataA = dataA.split("/");
            String[] partesDataB = dataB.split("/");

            int anoA = Integer.parseInt(partesDataA[2]);
            int mesA = Integer.parseInt(partesDataA[1]);
            int diaA = Integer.parseInt(partesDataA[0]);

            int anoB = Integer.parseInt(partesDataB[2]);
            int mesB = Integer.parseInt(partesDataB[1]);
            int diaB = Integer.parseInt(partesDataB[0]);

            if (tipo == 2) {
                if (anoA > anoB || (anoA == anoB && mesA > mesB) || (anoA == anoB && mesA == mesB && diaA > diaB)) {
                    novoVetor[pos] = vetor[i];
                    pos++;
                    i++;
                } 
                else {
                    novoVetor[pos] = vetor[m];
                    pos++;
                    m++;
                }
            } 
            else {
                if (anoA < anoB || (anoA == anoB && mesA < mesB) || (anoA == anoB && mesA == mesB && diaA < diaB)) {
                    novoVetor[pos] = vetor[i];
                    pos++;
                    i++;
                } 
                else {
                    novoVetor[pos] = vetor[m];
                    pos++;
                    m++;
                }
            }
        }

        while (i < meio) {
            novoVetor[pos] = vetor[i];
            pos++;
            i++;
        }

        while (m < fim) {
            novoVetor[pos] = vetor[m];
            pos++;
            m++;
        }

        System.arraycopy(novoVetor, 0, vetor, inicio, novoVetor.length);
    }  
    
    
}

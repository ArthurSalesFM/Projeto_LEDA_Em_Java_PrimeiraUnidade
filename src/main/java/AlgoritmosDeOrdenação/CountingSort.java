package AlgoritmosDeOrdenação;

import Interfaces.I_Ordenacao;
import java.util.Arrays;

/**
 *
 * @author Arthur Felipe MS
 */
public class CountingSort implements I_Ordenacao{

    @Override
    public String[] ordenacaoMedioMelhorCasoCampoLength(String[] vetor, int colunaOrdenacao) {
        countingSortLength(vetor, 1);
        return vetor;
    }

    @Override
    public String[] ordenacaoPiorCasoCampoLength(String[] vetor, int colunaOrdenacao) {
        countingSortLength(vetor, 2);
        return vetor;
    }

    @Override
    public String[] ordenacaoMedioMelhorCasoCampoMes(String[] vetor, int colunaOrdenacao) {
        countingSortMes(vetor, 1);
        return vetor;
    }

    @Override
    public String[] ordenacaoPiorCasoCampoMes(String[] vetor, int colunaOrdenacao) {
        countingSortMes(vetor, 2);
        return vetor;
    }

    @Override
    public String[] ordenacaoMedioMelhorCasoCampoData(String[] vetor, int colunaOrdenacao) {
        countingSortData(vetor, 1);
        return vetor;
    }

    @Override
    public String[] ordenacaoPiorCasoCampoData(String[] vetor, int colunaOrdenacao) {
        countingSortData(vetor, 2);
        return vetor;
    }
    
    private void countingSortLength(String[] vetor, int tipo) {
        int n = vetor.length;

        int[][] numericValuesAndLines = new int[n][2];

        for (int i = 1; i < n; i++) {
            String linha = vetor[i];
            String[] partes = linha.split(",");
            if (partes.length < 5) {
                continue;
            }
            String campoNumericoStr = partes[2].trim(); 
            int campoNumerico = Integer.parseInt(campoNumericoStr); 
            numericValuesAndLines[i][0] = campoNumerico;
            numericValuesAndLines[i][1] = i; 
        }

        Arrays.sort(numericValuesAndLines, 1, n, (a, b) -> {
            if (tipo == 2) {
                return Integer.compare(a[0], b[0]);
            } 
            else {
                return Integer.compare(b[0], a[0]);
            }
        });

        String[] output = new String[n];

        output[0] = vetor[0];

        for (int i = 1; i < n; i++) {
            int originalIndex = numericValuesAndLines[i][1];
            output[i] = vetor[originalIndex];
        }

        System.arraycopy(output, 0, vetor, 0, n);
    }
        
    private void countingSortMes(String[] vetor, int tipo) {
        int n = vetor.length;

        int[][] monthValuesAndLines = new int[n][2];

        for (int i = 1; i < n; i++) {
            String linha = vetor[i];
            String[] partes = linha.split(",");
            if (partes.length < 4) {
                continue;
            }
            String dataStr = partes[3].trim(); 
            int monthValue = getMonthValue(dataStr);
            monthValuesAndLines[i][0] = monthValue;
            monthValuesAndLines[i][1] = i; 
        }

        Arrays.sort(monthValuesAndLines, 1, n, (a, b) -> {
            if (tipo == 2) {
                return Integer.compare(a[0], b[0]);
            } 
            else {
                return Integer.compare(b[0], a[0]);
            }
        });

        String[] output = new String[n];

        output[0] = vetor[0];

        for (int i = 1; i < n; i++) {
            int originalIndex = monthValuesAndLines[i][1];
            output[i] = vetor[originalIndex];
        }

        System.arraycopy(output, 0, vetor, 0, n);
    }

    private static int getMonthValue(String date) {
        String[] parts = date.split("/");
        int month = Integer.parseInt(parts[1]);
        return month;
    }
        
    private void countingSortData(String[] vetor, int tipo) {
        int n = vetor.length;

        int[][] dateValuesAndLines = new int[n][2];

        for (int i = 1; i < n; i++) {
            String linha = vetor[i];
            String[] partes = linha.split(",");
            if (partes.length < 4) {
                continue;
            }
            String dataStr = partes[3].trim();
            int dateValue = getDateValue(dataStr); 
            dateValuesAndLines[i][0] = dateValue;
            dateValuesAndLines[i][1] = i; 
        }

        Arrays.sort(dateValuesAndLines, 1, n, (a, b) -> {
            if (tipo == 2) {
                return Integer.compare(a[0], b[0]);
            } 
            else {
                return Integer.compare(b[0], a[0]);
            }
        });

        String[] output = new String[n];

        output[0] = vetor[0];

        for (int i = 1; i < n; i++) {
            int originalIndex = dateValuesAndLines[i][1];
            output[i] = vetor[originalIndex];
        }

        System.arraycopy(output, 0, vetor, 0, n);
    }

    private static int getDateValue(String date) {
        String[] parts = date.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        return year * 10000 + month * 100 + day;
    }
      
}

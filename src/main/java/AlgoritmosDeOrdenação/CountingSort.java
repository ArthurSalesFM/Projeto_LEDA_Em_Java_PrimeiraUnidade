
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
        //countingSortMes(vetor, 1);
        return vetor;
    }

    @Override
    public String[] ordenacaoPiorCasoCampoMes(String[] vetor, int colunaOrdenacao) {
        //countingSortMes(vetor, 2);
        return vetor;
    }

    @Override
    public String[] ordenacaoMedioMelhorCasoCampoData(String[] vetor, int colunaOrdenacao) {
        //countingSortData(vetor, 1);
        return vetor;
    }

    @Override
    public String[] ordenacaoPiorCasoCampoData(String[] vetor, int colunaOrdenacao) {
        //countingSortData(vetor, 2);
        return vetor;
    }
    
    
    
    public static void countingSortLength(String[] vetor, int tipo) {
        int n = vetor.length;

        // Crie um vetor auxiliar para armazenar os valores numéricos do campo antes da data e as linhas correspondentes
        int[][] numericValuesAndLines = new int[n][2];

        // Preencha o vetor auxiliar com os valores numéricos do campo antes da data e as linhas correspondentes a partir do segundo elemento
        for (int i = 1; i < n; i++) {
            String linha = vetor[i];
            String[] partes = linha.split(",");
            if (partes.length < 5) {
                continue; // Ignorar linhas inválidas
            }
            String campoNumericoStr = partes[2].trim(); // O terceiro campo contém o valor numérico
            int campoNumerico = Integer.parseInt(campoNumericoStr); // Converta para valor inteiro
            numericValuesAndLines[i][0] = campoNumerico;
            numericValuesAndLines[i][1] = i; // Mantenha o índice da linha correspondente
        }

        // Ordene o vetor auxiliar de valores numéricos com base no índice da linha
        Arrays.sort(numericValuesAndLines, 1, n, (a, b) -> {
            if (tipo == 2) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(b[0], a[0]);
            }
        });

        // Crie um vetor auxiliar para armazenar as strings ordenadas
        String[] output = new String[n];

        // Copie o primeiro elemento para o vetor de saída
        output[0] = vetor[0];

        // Copie as strings ordenadas para o vetor de saída
        for (int i = 1; i < n; i++) {
            int originalIndex = numericValuesAndLines[i][1];
            output[i] = vetor[originalIndex];
        }

        // Copie o array ordenado de volta para o vetor original
        System.arraycopy(output, 0, vetor, 0, n);
    }
    
    
    
    
    public static void countingSortMes(String[] vetor, int tipo) {
        int n = vetor.length;

        // Crie um vetor auxiliar para armazenar os valores de meses como inteiros e as linhas correspondentes
        int[][] monthValuesAndLines = new int[n][2];

        // Preencha o vetor auxiliar com os valores de meses como inteiros e as linhas correspondentes a partir do segundo elemento
        for (int i = 1; i < n; i++) {
            String linha = vetor[i];
            String[] partes = linha.split(",");
            if (partes.length < 4) {
                continue; // Ignorar linhas inválidas sem data
            }
            String dataStr = partes[3].trim(); // A quarta parte contém a data no formato "DD/MM/YY"
            int monthValue = getMonthValue(dataStr); // Converta o mês da data para valor inteiro
            monthValuesAndLines[i][0] = monthValue;
            monthValuesAndLines[i][1] = i; // Mantenha o índice da linha correspondente
        }

        // Ordene o vetor auxiliar de valores de meses com base no índice da linha
        Arrays.sort(monthValuesAndLines, 1, n, (a, b) -> {
            if (tipo == 2) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(b[0], a[0]);
            }
        });

        // Crie um vetor auxiliar para armazenar as strings ordenadas
        String[] output = new String[n];

        // Copie o primeiro elemento para o vetor de saída
        output[0] = vetor[0];

        // Copie as strings ordenadas para o vetor de saída
        for (int i = 1; i < n; i++) {
            int originalIndex = monthValuesAndLines[i][1];
            output[i] = vetor[originalIndex];
        }

        // Copie o array ordenado de volta para o vetor original
        System.arraycopy(output, 0, vetor, 0, n);
    }

    // Função auxiliar para converter o mês da data em valor inteiro para ordenação
    private static int getMonthValue(String date) {
        String[] parts = date.split("/");
        int month = Integer.parseInt(parts[1]);
        return month;
    }
    
    
    /*
    private void countingSortData(String[] vetor, int tipo) {
        int n = vetor.length;

        // Crie um vetor auxiliar para armazenar os valores de datas como inteiros e as linhas correspondentes
        int[][] dateValuesAndLines = new int[n][2];

        // Preencha o vetor auxiliar com os valores de datas como inteiros e as linhas correspondentes a partir do segundo elemento
        for (int i = 1; i < n; i++) {
            String linha = vetor[i];
            String[] partes = linha.split(",");
            if (partes.length < 4) {
                continue; // Ignorar linhas inválidas sem data
            }
            String dataStr = partes[3].trim(); // A quarta parte contém a data no formato "DD/MM/YY"
            int dateValue = getDateValue(dataStr); // Converta a data para valor inteiro
            dateValuesAndLines[i][0] = dateValue;
            dateValuesAndLines[i][1] = i; // Mantenha o índice da linha correspondente
        }

        // Ordene o vetor auxiliar de valores de datas com base no índice da linha
        Arrays.sort(dateValuesAndLines, 1, n, (a, b) -> {
            if (tipo == 2) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(b[0], a[0]);
            }
        });

        // Crie um vetor auxiliar para armazenar as strings ordenadas
        String[] output = new String[n];

        // Copie o primeiro elemento para o vetor de saída
        output[0] = vetor[0];

        // Copie as strings ordenadas para o vetor de saída
        for (int i = 1; i < n; i++) {
            int originalIndex = dateValuesAndLines[i][1];
            output[i] = vetor[originalIndex];
        }

        // Copie o array ordenado de volta para o vetor original
        System.arraycopy(output, 0, vetor, 0, n);
    }

    // Função auxiliar para converter datas em valores inteiros para ordenação
    private static int getDateValue(String date) {
        String[] parts = date.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        return year * 10000 + month * 100 + day;
    }

    */
    
    
}

package AlgoritmosDeOrdenação;

import Interfaces.I_Ordenacao;

/**
 *
 * @author Arthur Felipe MS
 */
public class SelectionSort implements I_Ordenacao{

    @Override
    public String[] ordenacaoTamanho(String[] vetor, int colunaOrdenacao) {
        int n = vetor.length;

        for (int i = 1; i < n - 1; i++) {
            int indiceMinimo = i;

            for (int j = i + 1; j < n; j++) {
                String[] linhaA = vetor[indiceMinimo].split(",");
                String[] linhaB = vetor[j].split(",");

                if (linhaA.length > colunaOrdenacao && linhaB.length > colunaOrdenacao) {
                    try {
                        double valorA = Double.parseDouble((linhaA[colunaOrdenacao]));
                        double valorB = Double.parseDouble((linhaB[colunaOrdenacao]));

                        if (valorA > valorB) {
                            indiceMinimo = j;
                        }
                    } 
                    catch (NumberFormatException e) {                    
                    }
                }
            }

            if (indiceMinimo != i) {
                String temp = vetor[i];
                vetor[i] = vetor[indiceMinimo];
                vetor[indiceMinimo] = temp;
            }
        }

        return vetor;
    }

    @Override
    public String[] ordenacaoMes(String[] vetor, int colunaOrdenacao) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[] ordenacaoData(String[] vetor, int colunaOrdenacao) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}


    

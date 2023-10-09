package AlgoritmosDeOrdenação;

import Interfaces.I_Ordenacao;

/**
 *
 * @author Arthur Felipe MS
 */
public class InsertionSort implements I_Ordenacao{

    public InsertionSort(){        
    }

   @Override
    public String[] ordenacaoMedioMelhorCasoCampoLength(String[] vetor, int colunaOrdenacao) {
        int n = vetor.length - 1;

        for (int i = 1; i < n; i++) {
            String chave = vetor[i];
            int j = i - 1;

            while (j >= 0) {
                String[] linhaA = vetor[j].split(",");
                String[] linhaB = chave.split(",");
                
                if(linhaA.length > 4 || linhaB.length > 4){
                    
                    int colunaCorretaA = linhaA.length - 3;
                    int colunaCorretaB = linhaB.length - 3;
                    
                    if (linhaA.length > colunaCorretaA && linhaB.length > colunaCorretaB) {
                        try {
                            double valorA = limparEConverterParaDouble(linhaA[colunaCorretaA]);
                            double valorB = limparEConverterParaDouble(linhaB[colunaCorretaB]);

                            if (valorA < valorB) { 
                                vetor[j + 1] = vetor[j];
                                j--;
                            } 
                            else {
                                break;
                            }
                        } 
                        catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    } 
                    else {
                        break;
                    }
                }
                else{                    
                    if (linhaA.length > colunaOrdenacao && linhaB.length > colunaOrdenacao) {
                        try {
                            double valorA = limparEConverterParaDouble(linhaA[colunaOrdenacao]);
                            double valorB = limparEConverterParaDouble(linhaB[colunaOrdenacao]);

                            if (valorA < valorB) { 
                                vetor[j + 1] = vetor[j];
                                j--;
                            } 
                            else {
                                break;
                            }
                        } 
                        catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    } 
                    else {
                        break;
                    }                   
                }               
            }
            vetor[j + 1] = chave;
        }
        return vetor;
    }
    
    @Override
    public String[] ordenacaoPiorCasoCampoLength(String[] vetor, int colunaOrdenacao) {    
        int n = vetor.length - 1;

        for (int i = 1; i < n; i++) {
            String chave = vetor[i];
            int j = i - 1;

            while (j >= 0) {
                String[] linhaA = vetor[j].split(",");
                String[] linhaB = chave.split(",");
                
                if(linhaA.length > 4 || linhaB.length > 4){
                    
                    int colunaCorretaA = linhaA.length - 3;
                    int colunaCorretaB = linhaB.length - 3;
                    
                    if (linhaA.length > colunaCorretaA && linhaB.length > colunaCorretaB) {
                        try {
                            double valorA = limparEConverterParaDouble(linhaA[colunaCorretaA]);
                            double valorB = limparEConverterParaDouble(linhaB[colunaCorretaB]);

                            if (valorA > valorB) { 
                                vetor[j + 1] = vetor[j];
                                j--;
                            } 
                            else {
                                break;
                            }
                        } 
                        catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    } 
                    else {
                        break;
                    }
                }
                else{                    
                    if (linhaA.length > colunaOrdenacao && linhaB.length > colunaOrdenacao) {
                        try {
                            double valorA = limparEConverterParaDouble(linhaA[colunaOrdenacao]);
                            double valorB = limparEConverterParaDouble(linhaB[colunaOrdenacao]);

                            if (valorA > valorB) { 
                                vetor[j + 1] = vetor[j];
                                j--;
                            } 
                            else {
                                break;
                            }
                        } 
                        catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    } 
                    else {
                        break;
                    }                   
                }               
            }
            vetor[j + 1] = chave;
        }
        return vetor;
    }
    
    @Override
    public String[] ordenacaoMedioMelhorCasoCampoMes(String[] vetor, int colunaOrdenacao) {
        int n = vetor.length;

        for (int i = 1; i < n; i++) { 
            String chave = vetor[i];
            int j = i - 1;

            while (j > 0) {
                String[] linhaA = vetor[j].split(",");
                String[] linhaB = chave.split(",");

                if (linhaA.length > colunaOrdenacao && linhaB.length > colunaOrdenacao) {
                    try {                        
                        String dataA = linhaA[colunaOrdenacao].split("/")[1];
                        String dataB = linhaB[colunaOrdenacao].split("/")[1];
                    
                        double mesA = limparEConverterParaDouble(dataA);
                        double mesB = limparEConverterParaDouble(dataB);
                    
                        if (mesA < mesB) {
                            vetor[j + 1] = vetor[j];
                            j--;
                        } 
                        else {
                            break;
                        }
                    } 
                    catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                } 
                else {
                    break;
                }
            }
            vetor[j + 1] = chave;
        }
        return vetor;
        
    }

    @Override
    public String[] ordenacaoPiorCasoCampoMes(String[] vetor, int colunaOrdenacao) {
        int n = vetor.length;

        for (int i = 1; i < n; i++) { 
            String chave = vetor[i];
            int j = i - 1;

            while (j > 0) {
                String[] linhaA = vetor[j].split(",");
                String[] linhaB = chave.split(",");

                if (linhaA.length > colunaOrdenacao && linhaB.length > colunaOrdenacao) {
                    try {                        
                        String dataA = linhaA[colunaOrdenacao].split("/")[1];
                        String dataB = linhaB[colunaOrdenacao].split("/")[1];
                    
                        double mesA = limparEConverterParaDouble(dataA);
                        double mesB = limparEConverterParaDouble(dataB);
                    
                        if (mesA > mesB) {
                            vetor[j + 1] = vetor[j];
                            j--;
                        } 
                        else {
                            break;
                        }
                    } 
                    catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                } 
                else {
                    break;
                }
            }
            vetor[j + 1] = chave;
        }
        return vetor;       
    }

    @Override
    public String[] ordenacaoMedioMelhorCasoCampoData(String[] vetor, int colunaOrdenacao) {
        int n = vetor.length;

        for (int i = 1; i < n - 1; i++) {
            int indiceMinimo = i;

            for (int j = i + 1; j < n; j++) {
                String[] linhaA = vetor[indiceMinimo].split(",");
                String[] linhaB = vetor[j].split(",");
            
                if (linhaA.length > 4 || linhaB.length > 4) {
                    int posicaoA = linhaA.length - 2;
                    int posicaoB = linhaB.length - 2;
                
                    if (linhaA.length > colunaOrdenacao && linhaB.length > colunaOrdenacao) {
                        try {
                            String dataA = linhaA[posicaoA];
                            String dataB = linhaB[posicaoB];

                            String[] partesDataA = dataA.split("/");
                            String[] partesDataB = dataB.split("/");

                            int anoA = Integer.parseInt(partesDataA[2]);
                            int anoB = Integer.parseInt(partesDataB[2]);

                            if (anoA < anoB) {
                                indiceMinimo = j;
                            } 
                            else if (anoA == anoB) {
                                int mesA = Integer.parseInt(partesDataA[1]);
                                int mesB = Integer.parseInt(partesDataB[1]);

                                if (mesA < mesB) {
                                    indiceMinimo = j;
                                } 
                                else if (mesA == mesB) {
                                    int diaA = Integer.parseInt(partesDataA[0]);
                                    int diaB = Integer.parseInt(partesDataB[0]);

                                    if (diaA < diaB) {
                                        indiceMinimo = j;
                                    }
                                }
                            }
                        }
                        catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                        }
                    }                    
                }
                else {
                    if (linhaA.length > colunaOrdenacao && linhaB.length > colunaOrdenacao) {
                        try {
                            String dataA = linhaA[colunaOrdenacao];
                            String dataB = linhaB[colunaOrdenacao];

                            String[] partesDataA = dataA.split("/");
                            String[] partesDataB = dataB.split("/");

                            int anoA = Integer.parseInt(partesDataA[2]);
                            int anoB = Integer.parseInt(partesDataB[2]);

                            if (anoA < anoB) {
                                indiceMinimo = j;
                            } 
                            else if (anoA == anoB) {
                                int mesA = Integer.parseInt(partesDataA[1]);
                                int mesB = Integer.parseInt(partesDataB[1]);

                                if (mesA < mesB) {
                                    indiceMinimo = j;
                                } 
                                else if (mesA == mesB) {
                                    int diaA = Integer.parseInt(partesDataA[0]);
                                    int diaB = Integer.parseInt(partesDataB[0]);

                                    if (diaA < diaB) {
                                        indiceMinimo = j;
                                    }
                                }
                            }
                        } 
                        catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {                    
                        }
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
    public String[] ordenacaoPiorCasoCampoData(String[] vetor, int colunaOrdenacao) {    
        int n = vetor.length;

        for (int i = 1; i < n - 1; i++) {
            int indiceMinimo = i;

            for (int j = i + 1; j < n; j++) {
                String[] linhaA = vetor[indiceMinimo].split(",");
                String[] linhaB = vetor[j].split(",");
            
                if (linhaA.length > 4 || linhaB.length > 4) {
                    int posicaoA = linhaA.length - 2;
                    int posicaoB = linhaB.length - 2;
                
                    if (linhaA.length > colunaOrdenacao && linhaB.length > colunaOrdenacao) {
                        try {
                            String dataA = linhaA[posicaoA];
                            String dataB = linhaB[posicaoB];

                            String[] partesDataA = dataA.split("/");
                            String[] partesDataB = dataB.split("/");

                            int anoA = Integer.parseInt(partesDataA[2]);
                            int anoB = Integer.parseInt(partesDataB[2]);

                            if (anoA > anoB) {
                                indiceMinimo = j;
                            } 
                            else if (anoA == anoB) {
                                int mesA = Integer.parseInt(partesDataA[1]);
                                int mesB = Integer.parseInt(partesDataB[1]);

                                if (mesA > mesB) {
                                    indiceMinimo = j;
                                } 
                                else if (mesA == mesB) {
                                    int diaA = Integer.parseInt(partesDataA[0]);
                                    int diaB = Integer.parseInt(partesDataB[0]);

                                    if (diaA > diaB) {
                                        indiceMinimo = j;
                                    }
                                }
                            }
                        }
                        catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                        }
                    }                    
                }
                else {
                    if (linhaA.length > colunaOrdenacao && linhaB.length > colunaOrdenacao) {
                        try {
                            String dataA = linhaA[colunaOrdenacao];
                            String dataB = linhaB[colunaOrdenacao];

                            String[] partesDataA = dataA.split("/");
                            String[] partesDataB = dataB.split("/");

                            int anoA = Integer.parseInt(partesDataA[2]);
                            int anoB = Integer.parseInt(partesDataB[2]);

                            if (anoA > anoB) {
                                indiceMinimo = j;
                            } 
                            else if (anoA == anoB) {
                                int mesA = Integer.parseInt(partesDataA[1]);
                                int mesB = Integer.parseInt(partesDataB[1]);

                                if (mesA > mesB) {
                                    indiceMinimo = j;
                                } 
                                else if (mesA == mesB) {
                                    int diaA = Integer.parseInt(partesDataA[0]);
                                    int diaB = Integer.parseInt(partesDataB[0]);

                                    if (diaA > diaB) {
                                        indiceMinimo = j;
                                    }
                                }
                            }
                        } 
                        catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {                    
                        }
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
    
    private double limparEConverterParaDouble(String valor) {
        String valorLimpo = valor.replaceAll("[^0-9.Ee+-]", "");

        try {
            return Double.parseDouble(valorLimpo);
        } 
        catch (NumberFormatException e) {
            return Double.NaN;
        }
    }
    
}

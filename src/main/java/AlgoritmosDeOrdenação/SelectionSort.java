package AlgoritmosDeOrdenação;

import Interfaces.I_Ordenacao;

/**
 *
 * @author Arthur Felipe MS
 */
public class SelectionSort implements I_Ordenacao{

    @Override
    public String[] ordenacaoMedioMelhorCasoCampoLength(String[] vetor, int colunaOrdenacao) {
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

                        if (valorA < valorB) {
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
    public String[] ordenacaoPiorCasoCampoLength(String[] vetor, int colunaOrdenacao) {
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
    public String[] ordenacaoMedioMelhorCasoCampoMes(String[] vetor, int colunaOrdenacao) {
        int n = vetor.length;

        for (int i = 1; i < n - 1; i++) {
            int indiceMinimo = i;

            for (int j = i + 1; j < n; j++) {
                String[] linhaA = vetor[indiceMinimo].split(",");
                String[] linhaB = vetor[j].split(",");

                if (linhaA.length > colunaOrdenacao && linhaB.length > colunaOrdenacao) {
                    try {
                    
                        String dataA = linhaA[colunaOrdenacao].split("/")[1];
                        String dataB = linhaB[colunaOrdenacao].split("/")[1];

                        double mesA = Double.parseDouble(dataA);
                        double mesB = Double.parseDouble(dataB);

                        if (mesA < mesB) {
                            indiceMinimo = j;
                        }
                    } 
                    catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                        
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
    public String[] ordenacaoPiorCasoCampoMes(String[] vetor, int colunaOrdenacao) {
        int n = vetor.length;

        for (int i = 1; i < n - 1; i++) {
            int indiceMinimo = i;

            for (int j = i + 1; j < n; j++) {
                String[] linhaA = vetor[indiceMinimo].split(",");
                String[] linhaB = vetor[j].split(",");

                if (linhaA.length > colunaOrdenacao && linhaB.length > colunaOrdenacao) {
                    try {
                    
                        String dataA = linhaA[colunaOrdenacao].split("/")[1];
                        String dataB = linhaB[colunaOrdenacao].split("/")[1];

                        double mesA = Double.parseDouble(dataA);
                        double mesB = Double.parseDouble(dataB);

                        if (mesA > mesB) {
                            indiceMinimo = j;
                        }
                    } 
                    catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                        
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
    public String[] ordenacaoMedioMelhorCasoCampoData(String[] vetor, int colunaOrdenacao) {
        int n = vetor.length;

    for (int i = 1; i < n - 1; i++) {
        int indiceMinimo = i;

        for (int j = i + 1; j < n; j++) {
            String[] linhaA = vetor[indiceMinimo].split(",");
            String[] linhaB = vetor[j].split(",");

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
                    } else if (anoA == anoB) {
                        int mesA = Integer.parseInt(partesDataA[1]);
                        int mesB = Integer.parseInt(partesDataB[1]);

                        if (mesA < mesB) {
                            indiceMinimo = j;
                        } else if (mesA == mesB) {
                            int diaA = Integer.parseInt(partesDataA[0]);
                            int diaB = Integer.parseInt(partesDataB[0]);

                            if (diaA < diaB) {
                                indiceMinimo = j;
                            }
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    // Lidar com exceções, se necessário
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
                    } else if (anoA == anoB) {
                        int mesA = Integer.parseInt(partesDataA[1]);
                        int mesB = Integer.parseInt(partesDataB[1]);

                        if (mesA > mesB) {
                            indiceMinimo = j;
                        } else if (mesA == mesB) {
                            int diaA = Integer.parseInt(partesDataA[0]);
                            int diaB = Integer.parseInt(partesDataB[0]);

                            if (diaA > diaB) {
                                indiceMinimo = j;
                            }
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    // Lidar com exceções, se necessário
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

   

}


    

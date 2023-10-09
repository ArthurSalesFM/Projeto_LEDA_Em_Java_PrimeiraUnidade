package DadosDasOrdenacoes;

/**
 *
 * @author Arthur Felipe MS
 */
public class MatrizDosDados {
    
    private double matriz[][] = new double[7][9];
    
    public MatrizDosDados(){
        this.preencheMatriz();
    }
    
    public void inserirValoresNaMatriz(double tempo, int linha, int coluna){
        matriz[linha][coluna] = tempo;
    }
    
    public String informacoesDeTodasAsOrdenacoes(){  
                                     
        String saidaDasInformacoes = "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n" +
                "\t\t\tInformações de Execução das Ordenações." +
                "\n" +
                "\n" +
                "\n" +                
                "\tLENGTH \t\t\tMOUNTH \t\t\tDATA" +
                "\n" +
                "\n" +
                "\tMédio \tMelhor\tPior  \tMédio \tMelhor\tPior  \tMédio \tMelhor\tPior  " +
                "\n" +
                "\n";
        
        for(int linha = 0; linha < 7; linha ++){
            for(int coluna = 0; coluna < 9; coluna ++){
                
                if(linha == 0 && coluna == 0){
                    saidaDasInformacoes += "SELECTION\t";
                }
                else if(linha == 1 && coluna == 0){
                    saidaDasInformacoes += "INSERTION\t";
                }
                else if(linha == 2 && coluna == 0){
                    saidaDasInformacoes += "MERGE    \t";
                }
                else if(linha == 3 && coluna == 0){
                    saidaDasInformacoes += "QUICK    \t";
                }
                else if(linha == 4 && coluna == 0){
                    saidaDasInformacoes += "QUICKCM3 \t";
                }
                else if(linha == 5 && coluna == 0){
                    saidaDasInformacoes += "COUNTING \t";
                }
                else if(linha == 6 && coluna == 0){
                    saidaDasInformacoes += "HEAP     \t";
                }
                
                saidaDasInformacoes += matriz[linha][coluna] + "\t";
                //System.out.print(matriz[linha][coluna] + "\t");
            }
            saidaDasInformacoes += "\n";
            //System.out.print("\n");
        }
        saidaDasInformacoes += "\n\n" +
                "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
    return saidaDasInformacoes;        
    }
    
    private void preencheMatriz(){
        for(int linha = 0; linha < 7; linha ++){
            for(int coluna = 0; coluna < 9; coluna ++){
                matriz[linha][coluna] = 0.0;
            }
        }
    }    
    
    public String informacoesEspecificaPorTipoDeOrdenacao(int tipoOrdenacao, String nomeDaOrdenacao){
        
        double tempoTotalDasExecucoes = 0;        
        double tempoTotalTamanho = 0;
        double tempoTotalMes = 0;
        double tempoTotalData = 0;
        
        String saida = "\n\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n" +
                "\t\t\t"+ nomeDaOrdenacao +
                "\n" +
                "\n" +
                "\n" +                
                "LENGTH \t\t\tMOUNTH \t\t\tDATA" +
                "\n" +
                "\n" +
                "Médio \tMelhor\tPior  \tMédio \tMelhor\tPior  \tMédio \tMelhor\tPior  " +
                "\n" +
                "\n";
        
        for(int i = 0; i < 9; i ++){
            tempoTotalDasExecucoes += matriz[tipoOrdenacao][i];
            saida += matriz[tipoOrdenacao][i] + "\t";
            
            if(i < 3){
                tempoTotalTamanho += matriz[tipoOrdenacao][i];
            }
            else if (i >= 3 && i < 6){
                tempoTotalMes += matriz[tipoOrdenacao][i];
            }
            else{
                tempoTotalData += matriz[tipoOrdenacao][i];
            }
            
        }
        
        saida += "\n\nTempo total em TODAS as execuções : " + tempoTotalDasExecucoes;
        saida += "\nMédia geral de TODAS as execuções : " + (tempoTotalDasExecucoes  / 9);
        
        saida += "\n\nTempo total do campo LENGTH : " + tempoTotalTamanho;
        saida += "\nMédia geral do campo LENGTH : " + (tempoTotalTamanho  / 3);
        
        saida += "\n\nTempo total do campo MONTH : " + tempoTotalMes;
        saida += "\nMédia geral do campo MONTH : " + (tempoTotalMes  / 3);
        
        saida += "\n\nTempo total do campo DATA : " + tempoTotalData;
        saida += "\nMédia geral do campo DATA : " + (tempoTotalData  / 3);
        
        saida += "\n";
        
        
        saida += "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n";
        
        return saida;
    }
    
    
   
    
}

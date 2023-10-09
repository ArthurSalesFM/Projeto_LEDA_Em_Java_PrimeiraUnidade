package Classificações_Transformações;

import java.util.Arrays;

/**
 *
 * @author Arthur Felipe MS
 */
public class ClassificacaoSenha {    
    
    public ClassificacaoSenha(){    
    }
    
    public String[] buscaSenhaBoaEMuitoBoa(String vetor[]){
        
        int posicaoDeParadaNoVetor = 1;        
        String vetorComAsSenhas[] = new String[vetor.length];
        
        vetorComAsSenhas[0] = vetor[0];
        
        for(int x = 1; x < vetor.length; x++){
            String partes[] = vetor[x].split(",");
            
            int totalVetor = partes.length - 1;            
            
            if( partes[totalVetor].equals("Boa") ){
                vetorComAsSenhas[posicaoDeParadaNoVetor] = vetor[x];
                posicaoDeParadaNoVetor++;
            }
            else if(partes[totalVetor].equals("Muito Boa")){
                vetorComAsSenhas[posicaoDeParadaNoVetor] = vetor[x];
                posicaoDeParadaNoVetor++;
            }
        }
        
        for(int i = 0; i < vetor.length; i++){
            vetor[i] = "";
        }
        
        vetor = Arrays.copyOf(vetorComAsSenhas, vetorComAsSenhas.length);      
        
        return vetor;
    }
    
    public String[] calssificaSenha(String vetor[]){        
        String novaColuna = ""; 
        String[] partes;
        
        for (int i = 0; i < vetor.length; i++) {
            partes = vetor[i].split(",");
            
            if(partes.length > 4){                
                String senhaModificada = "";
                
                for(int j = 1; j < partes.length - 2; j++){                   
                    if(j == (partes.length - 2) - 1){
                       senhaModificada +=  partes[j];                       
                    }
                    else{
                        senhaModificada +=  partes[j] + ".";
                    }                    
                }
                vetor[i] = partes[0] + "," + senhaModificada + "," + partes[partes.length - 2] + "," + partes[partes.length - 1];
            }
            
            partes = vetor[i].split(",");            
            
            if(i == 0){
                String linhaModificada = vetor[i] + "," + "class";
                vetor[i] = linhaModificada;
            }
            else{
                novaColuna = classificacao(partes[1]);
                String linhaModificada = vetor[i] + "," + novaColuna;
                vetor[i] = linhaModificada;
                novaColuna = "";
            }                        
        }        
        return vetor;
    }
    
    private static String classificacao(String senha) {
        int tamanho = senha.length();
        boolean contemLetrasMinusculas = false;
        boolean contemLetrasMaiusculas = false;
        boolean contemNumeros = false;
        boolean contemCaracteresEspeciais = false;

        for (int i = 0; i < tamanho; i++) {
            char caractere = senha.charAt(i);

            if (Character.isLowerCase(caractere)) {
                contemLetrasMinusculas = true;
            } 
            else if (Character.isUpperCase(caractere)) {
                contemLetrasMaiusculas = true;
            } 
            else if (Character.isDigit(caractere)) {
                contemNumeros = true;
            } 
            else if (!Character.isLetterOrDigit(caractere)) {
                contemCaracteresEspeciais = true;
            }
        }

        if (tamanho < 5 && (contemApenasUmTipoDeCaracter(contemLetrasMinusculas, contemLetrasMaiusculas, contemNumeros, contemCaracteresEspeciais))) {
            return "Muito Ruim";
        } 
        else if (tamanho <= 5 && (contemApenasUmTipoDeCaracter(contemLetrasMinusculas, contemLetrasMaiusculas, contemNumeros, contemCaracteresEspeciais))) {
            return "Ruim";
        } 
        else if (tamanho <= 6 && contemDoisTiposDeCaracteres(contemLetrasMinusculas, contemLetrasMaiusculas, contemNumeros, contemCaracteresEspeciais)) {
            return "Fraca";
        } 
        else if (tamanho <= 7 && contemTodosTiposDeCaracteres(contemLetrasMinusculas, contemLetrasMaiusculas, contemNumeros, contemCaracteresEspeciais)) {
            return "Boa";
        } 
        else if (tamanho > 8 && contemTodosTiposDeCaracteres(contemLetrasMinusculas, contemLetrasMaiusculas, contemNumeros, contemCaracteresEspeciais)) {
            return "Muito Boa";
        } 
        else {
        return "Sem Classificação";
        }
    }

    private static boolean contemApenasUmTipoDeCaracter(boolean... tipos) {
        int contador = 0;
        for (boolean tipo : tipos) {
            if (tipo) {
                contador++;
            }
        }
        return contador == 1;
    }

    private static boolean contemDoisTiposDeCaracteres(boolean... tipos) {
        int contador = 0;
        for (boolean tipo : tipos) {
            if (tipo) {
                contador++;
            }
        }
        return contador == 2;
    }

    private static boolean contemTodosTiposDeCaracteres(boolean... tipos) {
        for (boolean tipo : tipos) {
            if (!tipo) {
                return false;
            }
        }
        return true;
    }
    
}

package Classificações_Transformações;

import java.util.Arrays;

/**
 *
 * @author Arthur Felipe MS
 */
public class ClassificacaoSenha {
    
    
    public ClassificacaoSenha(){    
    }
    
    public String[] calssificaSenha(String vetor[]){        
        String novaColuna = "";        
        
        for (int i = 0; i < vetor.length; i++) {
            String[] partes = vetor[i].split(",");
            
            if(i == 0){
                String linhaModificada = vetor[i] + "," + "class";
                vetor[i] = linhaModificada;
            }
            else{
                novaColuna = classificacao(partes[1]);
                String linhaModificada = vetor[i] + "," + novaColuna;
                vetor[i] = linhaModificada;
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

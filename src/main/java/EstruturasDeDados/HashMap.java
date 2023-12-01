package EstruturasDeDados;

/**
 *
 * @author Gasparzinho
 */
public class HashMap {
    
    private static final int TAMANHO_INICIAL = 16;
    public ListaEncadeada[] tabela;
    
    public HashMap() {
        this.tabela = new ListaEncadeada[TAMANHO_INICIAL];
        for (int i = 0; i < TAMANHO_INICIAL; i++) {
            tabela[i] = new ListaEncadeada();
        }
    }
    
    private int calcularIndice(String chave) {
        return Math.abs(chave.hashCode()) % tabela.length;
    }

    public void put(String chave, String valor) {
        int indice = calcularIndice(chave);
        tabela[indice].inserir(valor);
    }

    public String get(String chave) {
        int indice = calcularIndice(chave);
        if (tabela[indice].contem(chave)) {
            return chave;
        }
        return null;
    }

    public void remover(String chave) {
        int indice = calcularIndice(chave);
        tabela[indice].remover(chave);
    }
    
    public int tamanho() {
        int tamanhoTotal = 0;
        for (ListaEncadeada lista : tabela) {
            tamanhoTotal += lista.paraArray().length;
        }
        return tamanhoTotal;
    }
}

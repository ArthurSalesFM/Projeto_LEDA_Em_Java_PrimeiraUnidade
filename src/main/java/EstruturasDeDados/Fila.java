package EstruturasDeDados;

/**
 *
 * @author Arthur Felipe MS
 */
public class Fila {
    private No inicio;
    private No fim;

    public Fila() {
        this.inicio = null;
        this.fim = null;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public void enfileirar(String dado) {
        No novoNo = new No(dado);
        if (estaVazia()) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.proximo = novoNo;
            fim = novoNo;
        }
    }

    public String desenfileirar() {
        if (estaVazia()) {
            return null;
        } else {
            String dado = inicio.dado;
            inicio = inicio.proximo;
            if (inicio == null) {
                fim = null;
            }
            return dado;
        }
    }

    public String[] paraArray() {
        if (estaVazia()) {
            return new String[0];
        }

        No temp = inicio;
        int contador = 0;
        while (temp != null) {
            contador++;
            temp = temp.proximo;
        }

        String[] array = new String[contador];
        temp = inicio;
        int indice = 0;
        while (temp != null) {
            array[indice++] = temp.dado;
            temp = temp.proximo;
        }

        return array;
    }
}

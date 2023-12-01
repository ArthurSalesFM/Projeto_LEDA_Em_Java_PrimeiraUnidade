package EstruturasDeDados;

/**
 *
 * @author Arthur Felipe MS
 */
public class ListaEncadeada {
    No cabeca;

    public ListaEncadeada() {
        this.cabeca = null;
    }

    public void inserir(String dado) {
        No novoNo = new No(dado);
        if (cabeca == null) {
            cabeca = novoNo;
        } else {
            No temp = cabeca;
            while (temp.proximo != null) {
                temp = temp.proximo;
            }
            temp.proximo = novoNo;
        }
    }

    public String[] paraArray() {
        if (cabeca == null) {
            return new String[0];
        }

        No temp = cabeca;
        int contador = 0;
        while (temp != null) {
            contador++;
            temp = temp.proximo;
        }

        String[] array = new String[contador];
        temp = cabeca;
        int indice = 0;
        while (temp != null) {
            array[indice++] = temp.dado;
            temp = temp.proximo;
        }

        return array;
    }    
    
    public boolean contem(String dado) {
        No temp = cabeca;
        while (temp != null) {
            if (temp.dado.equals(dado)) {
                return true;
            }
            temp = temp.proximo;
        }
        return false;
    }

    public void remover(String dado) {
        if (cabeca == null) {
            return;
        }
        if (cabeca.dado.equals(dado)) {
            cabeca = cabeca.proximo;
            return;
        }
        No anterior = cabeca;
        No atual = cabeca.proximo;
        while (atual != null && !atual.dado.equals(dado)) {
            anterior = atual;
            atual = atual.proximo;
        }
        if (atual != null) {
            anterior.proximo = atual.proximo;
        }
    }
}

package lista;

public class Lista<T> {

    private No<T> primeiro;

    private No<T> ultimo;
    private int tamanho;

    public No<T> getPrimeiro() {
        return primeiro;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void adc(T valor) {
        No<T> no = new No();
        no.setValor(valor);

        if (this.primeiro == null && this.ultimo == null) {
            this.primeiro = no;
        } else {
            this.ultimo.setProximo(no);
        }
        this.ultimo = no;
        this.tamanho++;
    }

    public void remover(T pessoa) {
        No<T> anterior = null;
        No<T> atual = getPrimeiro();

        for (int i = 0; i < this.getTamanho(); i++) {
            if (atual.getValor().equals(pessoa)) {
                if (this.tamanho == 1) {   //remoção do primeiro valor
                    this.primeiro = null;
                    this.ultimo = null;

                } else if (atual == primeiro) {// remoção de valores do meio
                    this.primeiro = atual.getProximo();
                    atual.setProximo(null);

                } else if (atual == ultimo) { //remoção do último valor
                    this.ultimo = anterior; // coloca o anterior como último
                    anterior.setProximo(null); //

                } else {
                    anterior.setProximo(atual.getProximo());
                }
                tamanho--;
                break;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.tamanho == 0) {
            System.out.println("A lista está vazia! ");
        } else {
            No<T> p = primeiro;
            while (p != null) {
                sb.append(p.getValor());
                p = p.getProximo();
            }
        }
        return sb.toString();
    }
}

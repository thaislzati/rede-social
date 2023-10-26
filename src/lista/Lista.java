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

    public void adc(T valor) {                 //f(n) = 7
        No<T> no = new No();                                   //1
        no.setValor(valor);                                         //1

        if (this.primeiro == null && this.ultimo == null) {         //2
            this.primeiro = no;                                     //1
        } else {
            this.ultimo.setProximo(no);
        }
        this.ultimo = no;                                           //1
        this.tamanho++;                                             //1
    }

    public void remover(T pessoa) {  //f(n) = 10n + 4
        No<T> anterior = null;                                    //1
        No<T> atual = getPrimeiro();                              //1

        for (int i = 0; i < this.getTamanho(); i++) {                   //2+2n
            if (atual.getValor().equals(pessoa)) {                        //n
                if (this.tamanho == 1) {   //remoção do primeiro valor   //n
                    this.primeiro = null;                               //n
                    this.ultimo = null;                                 //n

                } else if (atual == primeiro) {// remoção de valores do meio
                    this.primeiro = atual.getProximo();
                    atual.setProximo(null);

                } else if (atual == ultimo) { //remoção do último valor
                    this.ultimo = anterior; // coloca o anterior como último
                    anterior.setProximo(null); //

                } else {
                    anterior.setProximo(atual.getProximo());
                }
                tamanho--;                                          //n
                break;                                              //n
            }
            anterior = atual;                                          //n
            atual = atual.getProximo();                                //n
        }
    }

    @Override
    public String toString() {          //f(n) = 3n + 5
        StringBuilder sb = new StringBuilder();                         //1
        if (this.tamanho == 0) {
            System.out.println("A lista está vazia! ");
        } else {                                                        //1
            No<T> p = primeiro;                                    //1
            while (p != null) {                                         //n+1
                sb.append(p.getValor());                                //n
                p = p.getProximo();                                     //n
            }
        }
        return sb.toString();                                           //1
    }
}

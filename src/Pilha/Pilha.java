package Pilha;


import static java.util.Objects.isNull;

public class Pilha<T> {

    private class Item<T> {
        private T valor;
        private Item<T> proximo;

        public T getValor() {
            return valor;
        }

        public void setValor(T valor) {
            this.valor = valor;
        }

        public Item<T> getProximo() {
            return proximo;
        }

        public void setProximo(Item<T> proximo) {
            this.proximo = proximo;
        }
    }

    private Item<T> topo;

    public Item<T> getTopo() {
        return topo;
    }

    public Boolean estaVazia() {
        return isNull(topo);
    }

    public void adcPilha(T valor) {
        if (estaVazia()) {
            topo = new Item();
            topo.setValor(valor);
        } else {
            Item anterior = topo;
            topo = new Item();
            topo.setValor(valor);
            topo.setProximo(anterior);
        }
    }

    public T esvaziarPilha() throws Exception {
        if (estaVazia())
            throw new Exception("A pilha está vazia");
        else {
            T valor = topo.getValor();
            topo = topo.getProximo();
            return valor;
        }
    }

     public T retornar() {
        T valor = topo.getValor();
        return valor;
    }

}

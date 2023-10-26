package bubbleSort;

import lista.Lista;
import lista.No;
import program.Pessoa;

public class BubbleSort {
    public Lista<Pessoa> bubbleSort(Lista<Pessoa>   lista) {              //f(n) = 33n²+3n+3
        No<Pessoa> p1;
        No<Pessoa> p2;
        p1 = lista.getPrimeiro();                           //1

        while (p1 != null) {                                //1+3n * (10n+1) = 30n² +3n + 1
            p2 = p1.getProximo();                           //n
            while (p2 != null) {                                                        //n+1
                if ((p1.getValor().getIdade() > p2.getValor().getIdade())) {            //n
                    troca(p1, p2);                                                      //3n
                }

                if (p1.getValor().getSexo().equalsIgnoreCase("f")
                        && p2.getValor().getSexo().equalsIgnoreCase("m")) {  //n
                    troca(p1, p2);                                                      //3n
                }
                p2 = p2.getProximo();                                                   //n
            }

            p1 = p1.getProximo();                          //n
        }
        return lista;                                       //1
    }

    public void troca(No<Pessoa> p1, No<Pessoa> p2) {           //3
        Pessoa aux;

        aux = p1.getValor();
        p1.setValor(p2.getValor());
        p2.setValor(aux);

    }

}

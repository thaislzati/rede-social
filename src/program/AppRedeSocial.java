package program;

import Pilha.Pilha;
import bubbleSort.BubbleSort;
import lista.Lista;
import lista.No;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class AppRedeSocial {   //f(n) = 33n³ + 83n² + 101n + 8
    public static Lista<Pessoa> lista = new Lista<>();      //1
    public static Lista<Pessoa> listaOriginal = new Lista<>();  //1
    public static Pilha<Pessoa> pilha = new Pilha<Pessoa>();        //1


    public static void main(String[] args) throws Exception {

        inicio();   //f(n) = 13n² + 27n +3
        menu();  //f(n) = 33n³ + 70n² + 74n + 2

    }

    public static void inicio() {          //f(n) = 13n² + 27n +3
        Scanner leia = new Scanner(System.in);                                        //1
        String opcao;
        System.out.println("-------- REDE SOCIAL JOÃOZINHO --------" +                //1
                "\nIndique quantos amigos quiser para participar!");
        do {
            adcPessoa();                                                                        //n(10n + 24) = 10n²+24n
            System.out.println("Se desejar adicionar mais pressione 's', senão qualquer tecla."); //n
            opcao = leia.nextLine();                                                              //n
        } while (opcao.equalsIgnoreCase("s"));                                       //n+1
    }

    public static void menu() throws Exception {  //f(n) = 33n³ + 70n² + 74n + 2
        String opcao;
        Scanner read = new Scanner(System.in);                          //1

        do {
            System.out.println("""              
                    ----- MENU -----
                    1. Indicar amigos
                    2. Remover amigos indicados
                    3. Listar amigos
                    4. Ver raking de amigos
                    5. SAIR""");                                                    //n
            opcao = read.nextLine();                                                //n

            switch (opcao) {                                                        //n
                case "1" -> adcPessoa();                                            //n(10n + 24) = 10n² + 24n
                case "2" -> removerPessoa();                                        //n(36n + 28) = 36n² + 28n
                case "3" -> exibirAmigos();                                         //n(33n² + 6n + 8) = 33n³+6n²+8n
                case "4" -> exibirRanking();                                        //n(18n + 8 ) = 18n² + 8n
                case "5" -> System.out.println("Programa encerrado.");              //n
                default -> //evitar erro                                            //n
                        System.out.println("Opção inválida, tente novamente!");
            }
        } while (!opcao.equals("5")); //programa encerra com o cancelar                 /n+1
    }

    public static void adcPessoa() {                    //f(n) = 10n + 24
        Scanner leia = new Scanner(System.in);                      //1
        String nome;

        System.out.print("Nome: ");                                 //1
        nome = leia.nextLine();                                     //1

        if (procurarNomeLista(nome)) { //Só continua se o nome não foi digitado ainda         //4n + 3
            Pessoa amigo = new Pessoa(nome, adcIdade(leia), adcSexo(leia));     //10n + 4 =(construtor + adcIdade + adcSexo)
            lista.adc(amigo);                                               //7
            listaOriginal.adc(amigo);                                       //7
        } else {
            System.out.println("Este amigo já foi convidado! :)");
        }
    }

    public static Integer adcIdade(Scanner leia) {            //f(n) = 5n + 2
        int idade;

        do {
            try {
                System.out.print("Idade: ");
                idade = leia.nextInt();
            } catch (InputMismatchException e) {                                                //n
                leia.nextLine();                                                                //n
                System.out.println("Digite apenas números: ");                                  //n
                idade = -1; //recebe esse valor para que ela caia no while da classe pessoa     //n
            }
        } while (idade < 0);                                                                     //n+1
        return idade;                                   //1
    }

    public static String adcSexo(Scanner leia) {         //f(n) = 5n + 2
        String sexo;
        do {
            System.out.print("Sexo: ");                                                           //n
            sexo = leia.nextLine();                                                               //n
            if (!(sexo.equalsIgnoreCase("f")
                    || sexo.equalsIgnoreCase("m"))) {                                 //n
                System.out.println("Digite apenas F ou M");                                      //n
            }
        } while (!(sexo.equalsIgnoreCase("f") || sexo.equalsIgnoreCase("m"))); //n+1
        return sexo;                                                                                   //1
    }

    public static void removerPessoa() {            //f(n) = 36n + 28
        if (lista.getTamanho() > 0) {                                           //1
            String nome = nomeParaExcluir();                                    //3n+9
            if (!procurarNomeLista(nome)) {                                    //4n + 3
                Pessoa pessoa = new Pessoa(nome);                               //1
                lista.remover(pessoa);                                          //13n+4
                listaOriginal.remover(pessoa);                                  //13n+4
                System.out.println("Excluído!");                                //1
            } else {
                System.out.println("O nome digitado não foi encontrado!");
            }
        }
        System.out.println(lista);                                              // 3n+5
    }

    public static String nomeParaExcluir() {      //f(n) = 3n + 8
        Scanner leia = new Scanner(System.in);                                          //1

        System.out.println(lista);                                                      //3n+5
        System.out.println("Digite o nome completo do amigo que deseja excluir: ");     //1

        return leia.nextLine();                                                         //1
    }

    //Percorre a lista e compara os nomes
    public static boolean procurarNomeLista(String nome) {            //f(n) =  4n + 3
        No<Pessoa> p = lista.getPrimeiro();                                   //1

        while (p != null) {                                                  //n+1
            if (p.getValor().getNome().equalsIgnoreCase(nome)) {              //n
                return false;                                                 //n
            }
            p = p.getProximo();                                               //n
        }
        return true;                                                         //1
    }

    public static void exibirRanking() throws Exception {       //f(n)= 18n + 8
        quiz();                                                                 //11n + 6

        while (pilha.getTopo() != null) {                                       //n+1
            System.out.println("Nome: " + pilha.retornar().getNome() + "  "
                    + " Afinidade: " + pilha.retornar().getAfinidade() + "%");  //2n
            pilha.esvaziarPilha();                                              //4n
        }
        System.out.println();                                                   //1
    }

    public static void quiz() {
        Scanner leia = new Scanner(System.in);
        Random rd = new Random();

        if (listaOriginal.getTamanho() > 0) {                               //1
            No<Pessoa> p = listaOriginal.getPrimeiro();                     //1

            while (p != null) {                                              //n+1
                responderQuiz(p, leia, rd);                                   //4n
                pilha.adcPilha(p.getValor());                                 //5n
                p = p.getProximo();                                           //n
            }
            System.out.println("\nRanking dos melhores amigos <3 ");          //1
        } else {
            System.out.println("Não há amigos para responder o quiz.");
        }
    }

    public static void responderQuiz(No<Pessoa> p, Scanner leia, Random rd) {  //f(n) = 4n
        if (p.getValor().getAfinidade() == -1) {                                                       //n
            System.out.print("Qual é a cor favorita do seu amigo " + p.getValor().getNome() + ": ");  //n
            leia.nextLine(); //Simular que a resposta foi salva                                       //n
            p.getValor().setAfinidade(rd.nextInt(100));                                        //n
        }
    }

    public static void exibirAmigos() {//f(n) = 33n² + 6n + 8

        if (lista.getTamanho() > 0) {                   //1
            BubbleSort bS = new BubbleSort();           //1
            bS.bubbleSort(lista);                      //f(n) = 30n² +3n + 1
            System.out.println(lista);                  //3n+5 ->Valor do método toString
        } else {
            System.out.println("Não há amigos para exibir");
        }
    }

}



package program;

import Pilha.Pilha;
import bubbleSort.BubbleSort;
import lista.Lista;
import lista.No;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class AppRedeSocial {   
    public static Lista<Pessoa> lista = new Lista<>();      
    public static Lista<Pessoa> listaOriginal = new Lista<>();
    public static Pilha<Pessoa> pilha = new Pilha<Pessoa>();


    public static void main(String[] args) throws Exception {

        inicio();
        menu();

    }

    public static void inicio() {
        Scanner leia = new Scanner(System.in);
        String opcao;
        System.out.println("-------- REDE SOCIAL JOÃOZINHO --------" +
                "\nIndique quantos amigos quiser para participar!");
        do {
            adcPessoa();
            System.out.println("Se desejar adicionar mais pressione 's', senão qualquer tecla.");
            opcao = leia.nextLine();
        } while (opcao.equalsIgnoreCase("s"));
    }

    public static void menu() throws Exception {
        String opcao;
        Scanner read = new Scanner(System.in);

        do {
            System.out.println("""              
                    ----- MENU -----
                    1. Indicar amigos
                    2. Remover amigos indicados
                    3. Listar amigos
                    4. Ver raking de amigos
                    5. SAIR""");
            opcao = read.nextLine();

            switch (opcao) {
                case "1" -> adcPessoa();
                case "2" -> removerPessoa();
                case "3" -> exibirAmigos();
                case "4" -> exibirRanking();
                case "5" -> System.out.println("Programa encerrado.");
                default -> //evitar erro
                        System.out.println("Opção inválida, tente novamente!");
            }
        } while (!opcao.equals("5")); //programa encerra com o cancelar
    }

    public static void adcPessoa() {
        Scanner leia = new Scanner(System.in);
        String nome;

        System.out.print("Nome: ");
        nome = leia.nextLine();

        if (procurarNomeLista(nome)) { //Só continua se o nome não foi digitado ainda
            Pessoa amigo = new Pessoa(nome, adcIdade(leia), adcSexo(leia));
            lista.adc(amigo);
            listaOriginal.adc(amigo);
        } else {
            System.out.println("Este amigo já foi convidado! :)");
        }
    }

    public static Integer adcIdade(Scanner leia) {
        int idade;

        do {
            try {
                System.out.print("Idade: ");
                idade = leia.nextInt();
            } catch (InputMismatchException e) {
                leia.nextLine();
                System.out.println("Digite apenas números: ");
                idade = -1; //recebe esse valor para que ela caia no while da classe pessoa
            }
        } while (idade < 0);
        return idade;
    }

    public static String adcSexo(Scanner leia) {
        String sexo;
        do {
            System.out.print("Sexo: ");
            sexo = leia.nextLine();
            if (!(sexo.equalsIgnoreCase("f")
                    || sexo.equalsIgnoreCase("m"))) {
                System.out.println("Digite apenas F ou M");
            }
        } while (!(sexo.equalsIgnoreCase("f") || sexo.equalsIgnoreCase("m")));
        return sexo;
    }

    public static void removerPessoa() {
        if (lista.getTamanho() > 0) {
            String nome = nomeParaExcluir();
            if (!procurarNomeLista(nome)) {
                Pessoa pessoa = new Pessoa(nome);
                lista.remover(pessoa);
                listaOriginal.remover(pessoa);
                System.out.println("Excluído!");
            } else {
                System.out.println("O nome digitado não foi encontrado!");
            }
        }
        System.out.println(lista);
    }

    public static String nomeParaExcluir() {
        Scanner leia = new Scanner(System.in);

        System.out.println(lista);
        System.out.println("Digite o nome completo do amigo que deseja excluir: ");

        return leia.nextLine();
    }

    //Percorre a lista e compara os nomes
    public static boolean procurarNomeLista(String nome) {
        No<Pessoa> p = lista.getPrimeiro();

        while (p != null) {
            if (p.getValor().getNome().equalsIgnoreCase(nome)) {
                return false;
            }
            p = p.getProximo();
        }
        return true;
    }

    public static void exibirRanking() throws Exception {
        quiz();

        while (pilha.getTopo() != null) {
            System.out.println("Nome: " + pilha.retornar().getNome() + "  "
                    + " Afinidade: " + pilha.retornar().getAfinidade() + "%");
            pilha.esvaziarPilha();
        }
        System.out.println();
    }

    public static void quiz() {
        Scanner leia = new Scanner(System.in);
        Random rd = new Random();

        if (listaOriginal.getTamanho() > 0) {
            No<Pessoa> p = listaOriginal.getPrimeiro();

            while (p != null) {
                responderQuiz(p, leia, rd);
                pilha.adcPilha(p.getValor());
                p = p.getProximo();
            }
            System.out.println("\nRanking dos melhores amigos <3 ");
        } else {
            System.out.println("Não há amigos para responder o quiz.");
        }
    }

    public static void responderQuiz(No<Pessoa> p, Scanner leia, Random rd) {
        if (p.getValor().getAfinidade() == -1) {
            System.out.print("Qual é a cor favorita do seu amigo " + p.getValor().getNome() + ": ");
            leia.nextLine(); //Simular que a resposta foi salva
            p.getValor().setAfinidade(rd.nextInt(100));
        }
    }

    public static void exibirAmigos() {

        if (lista.getTamanho() > 0) {
            BubbleSort bS = new BubbleSort();
            bS.bubbleSort(lista);
            System.out.println(lista);
        } else {
            System.out.println("Não há amigos para exibir");
        }
    }

}



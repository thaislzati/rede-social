package program;

import java.util.Scanner;

public class Pessoa {
    private String nome;
    private Integer idade;
    private String sexo;
    private int afinidade;

    public Pessoa(String nome, int idade, String sexo) {    //f(n) = 4
        setNome(nome);
        setIdade(idade);
        setSexo(sexo);
        setAfinidade(-1);
    }

    public Pessoa(String nome){
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getAfinidade() {
        return afinidade;
    }

    public void setAfinidade(int afinidade) {
        this.afinidade = afinidade;
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Pessoa))
            return false;
        return (nome.equals(((Pessoa) obj).getNome()));
    }
    
    @Override
    public String toString() {
        return "Nome='" + nome + '\'' +
                ", idade=" + idade +
                ", gênero='" + sexo + '\'' +
                "\n";
    }
}


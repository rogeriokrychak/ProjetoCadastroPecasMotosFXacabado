package com.example.projetocadastropecasmotos;

public class Pecas {
    private int id;
    private String nome;
    private String quantidade;
    private String data;
    private String descricao;

    public Pecas(int id, String nome, String quantidade, String data, String descricao) {

        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.data = data;
        this.descricao = descricao;
    }


    public int getId() {return id;}

    public String getNome() {
        return nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public String getData() {return data;}

    public String getDescricao() {
        return descricao;
    }

}

package com.example.builder;

import com.example.model.entity.GerenciarArmas;
import com.example.model.entity.GerenciarClasses;
import com.example.model.entity.Jogador;
import com.example.model.entity.classes.ClasseEspecial;

public class JogadorBuilder {
    private String nome;
    private int ataque;
    private int defesa;
    private int HP;
    private GerenciarArmas gerenciadorDeArmas; //separar responsabilidades de arma
    private GerenciarClasses gerenciadorDeClasses; //separar responsabilidades de classe
    private ClasseEspecial classeEspecial;
   
    public JogadorBuilder(ClasseEspecial classeEspecial) {
        this.nome = "Sem nome";
        this.ataque = -1;
        this.defesa = -1;
        this.classeEspecial = classeEspecial;
    }

    public JogadorBuilder withNome(String nome){
        this.nome = nome;
        return this;
    }
    
    public JogadorBuilder withAtaque(int ataque){
        this.ataque = ataque;
        return this;
    }

    public JogadorBuilder withDefesa(int defesa){
        this.defesa = defesa;
        return this;
    }

    public JogadorBuilder withHP(int hp){
        this.HP = hp;
        return this;
    }
    
    public JogadorBuilder whithGerenciadorArmas(GerenciarArmas armas){
        this.gerenciadorDeArmas = armas;
        return this;
    }

    public JogadorBuilder whithGerenciadorClasses(GerenciarClasses classes){
        this.gerenciadorDeClasses = classes;
        return this;
    }
    
    public Jogador build(){
        Jogador jogador = new Jogador(this.nome,this.ataque,this.defesa,this.classeEspecial);
        jogador.setNome(this.nome);
        jogador.setAtaque(this.ataque);
        jogador.setDefesa(this.defesa);
        jogador.setHP(this.HP);
        this.gerenciadorDeArmas = new GerenciarArmas(jogador);
        this.gerenciadorDeClasses = new GerenciarClasses(jogador);
        this.gerenciadorDeClasses.mudarClasse(this.classeEspecial);

        return jogador;
    }
    
}

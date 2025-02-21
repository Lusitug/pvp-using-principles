package com.example.model.entity;

import com.example.estrategy.AtaqueBasicoEstrategia;
import com.example.model.entity.armas.Arma;
import com.example.model.entity.classes.ClasseEspecial;
import com.example.view.IArma;
import com.example.view.IAtaqueEstrategia;

public class Jogador {
    private String nome;
    private int ataque;
    private int defesa;
    private int HP;
    private GerenciarArmas gerenciadorDeArmas; //separar responsabilidades de arma
    private GerenciarClasses gerenciadorDeClasses; //separar responsabilidades de classe
    private IAtaqueEstrategia estrategiaAtual; // estrategia

    public Jogador(String nome, int ataque, int defesa, ClasseEspecial classeEspecial) {
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
        this.HP = 500;
        this.gerenciadorDeClasses = new GerenciarClasses(this); // passando o objeto jogador instanciado para gerenciar arma
        this.gerenciadorDeArmas = new GerenciarArmas(this); // passando o objeto jogador instanciado para gerenciar classe
        this.gerenciadorDeClasses.mudarClasse(classeEspecial);
        this.estrategiaAtual = new AtaqueBasicoEstrategia(); // estrategia
    }

    public void equiparArma(IArma arma) {
        gerenciadorDeArmas.equiparArma(arma);
    }

    public void mudarClasse(ClasseEspecial classeEspecial) {
        gerenciadorDeClasses.mudarClasse(classeEspecial);
    }

    public Boolean compararCompatibilidadeClasseArma(IArma arma) {
        return gerenciadorDeClasses.getClasseEspecial().getClasseEspecialClass()
                .equals(((Arma) arma).getClasseEspecialClass());
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getAtaque() { return ataque; }
    public void setAtaque(int ataque) { this.ataque = ataque; }
    public int getDefesa() { return defesa; }
    public void setDefesa(int defesa) { this.defesa = defesa; }
    public int getHP() { return HP; }
    public void setHP(int HP) { this.HP = HP; }
    public IArma getArma() { return this.gerenciadorDeArmas.getArma(); }
    public ClasseEspecial getClasseEspecial() { return this.gerenciadorDeClasses.getClasseEspecial(); }

    @Override
    public String toString() {
        IArma arma = gerenciadorDeArmas.getArma();
        ClasseEspecial classe = gerenciadorDeClasses.getClasseEspecial();

        if (arma == null && classe == null) {
            return "\nNome:" + nome + "\nAtaque: " + ataque + "\nDefesa: " + defesa + "\nHP: " + HP + "\nClasse: Nenhuma" + "\nArma: Nenhuma\n";
        } else if (arma == null) {
            return "\nNome:" + nome + "\nAtaque: " + ataque + "\nDefesa: " + defesa + "\nHP: " + HP + "\nClasse: " + classe.getNome() + "\nArma: Nenhuma\n";
        }
        return "\nNome:" + nome + "\nAtaque: " + ataque + "\nDefesa: " + defesa + "\nHP: " + HP + "\nClasse: " + classe.getNome() + "\nArma: " + arma.getNome();
    }

    public int armaAtaqueEspecial(){ // metodo para usar na estrategia de ataque com arma
        if(this.getArma() == null) {
            System.out.println("Sem arma equipada.");
            return 0;
        }else{
            return this.getArma().ataqueEspecial();
        }   
    }

    public void setEstrategiaAtual(IAtaqueEstrategia estrategiaNova){// manipular estrategia de ataque usada
        this.estrategiaAtual = estrategiaNova;
    }

    public int atacar(){ // chamar metodo especifico de estrategia
        return this.estrategiaAtual.atacando(this);
    }
}
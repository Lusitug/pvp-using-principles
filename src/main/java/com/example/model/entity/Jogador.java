package com.example.model.entity;

import com.example.model.entity.armas.Arma;
import com.example.model.entity.classes.ClasseEspecial;
import com.example.view.IJogadorCombatibilidades;
import com.example.view.IJogadorStatusClasseArma;

// comecei o desenvolvimento pela estrutura básica da classe.
public class Jogador implements IJogadorCombatibilidades, IJogadorStatusClasseArma{
    private String nome;
    private int ataque;
    private int defesa;
    private int HP;
    private Arma arma; 
    private ClasseEspecial classeEspecial;

    public Jogador(String nome, int ataque, int defesa, ClasseEspecial classeEspecial){
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
        this.HP = 1000;
        this.classeEspecial = classeEspecial;
        this.arma = null;
    }
    
    // DIVIDINDO RESPONSABILIDADES DE COMPATIBILIDADE EM METODOS SEPARADOS
    @Override
    public Boolean compararCompatibilidadeClasseArma(Arma arma){ // apenas se ja possuir uma arma
        // if(this.arma == null) return false; // EVITAR QUEBRAR COM NUYLL POINTER EXCEPTION
        return this.classeEspecial.getClasseEspecialClass().equals(arma.getClasseEspecialClass());
    }
    
    // DIVIDINDO RESPONSABILIDADES DE COMPATIBILIDADE EM METODOS SEPARADOS
    @Override
    public void verificarCompatibilidadeClasseArma(){
        //se o jogador possui arma, mas a classe dele nao bate com a da arma
        if(this.arma != null && !compararCompatibilidadeClasseArma(this.arma)){
            this.arma = null; // entao remove a arma
        }
    }
    
    @Override
    public int getAtaqueArma(){
        return this.arma.getAtaqueExtra();
    }

    @Override
    public int getAtaqueArmaEspecial(){
        return this.arma.ataqueEspecial();
    }

    @Override
    public int getAtaqueClasseEspecial(){
        return this.classeEspecial.getAtaqueEspecial();
    }

    @Override
    public void atribuirStatusClasseEspecial(){}

    @Override
    public void atribuirStatusArma(){}



    @Override
    public String toString() {
        if(this.arma ==null){
            return "\nNome:"+ this.nome + "\nAtaque: "+this.ataque+"\nDefesa: "+this.defesa+"\nHP: "+ this.HP+"\nClasse: "+ this.classeEspecial.getNome() +"\nArma: Nenhuma\n";
        }
        return "\nNome:"+ this.nome + "\nAtaque: "+this.ataque+"\nDefesa: "+this.defesa+"\nHP: "+ this.HP+"\nClasse: "+ this.classeEspecial.getNome()  +"\nArma: "+this.arma.getNome();
    
    }

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public int getAtaque() {return ataque;}

    public void setAtaque(int ataque) {this.ataque = ataque;}

    public int getDefesa() {return defesa;}

    public void setDefesa(int defesa) {this.defesa = defesa;}

    public int getHP() {return HP;}

    public void setHP(int hP) {HP = hP;}

    public Arma getArma() {return arma;}

    public ClasseEspecial getClasseEspecial() {return classeEspecial;}
    
    public void setArma(Arma arma) { //CONDICIONAR METODO SETTER(visando: SETTER INJECTION)
        if(compararCompatibilidadeClasseArma(arma)){//se for de classes iguais, adiciona
            this.arma = arma;
        }else{ // se for de classes diferentes, remove a arma ou nao adiciona 
            this.arma = null;
        }
    }
    public void setClasseEspecial(ClasseEspecial classeEspecial) {
        this.classeEspecial = classeEspecial; // muda de classe independentemente
        this.verificarCompatibilidadeClasseArma(); 
        //verifica se a classe da arma atual e da nova clsse sao compativeis
        //se não são compativeis então remove a arma.

    }
}

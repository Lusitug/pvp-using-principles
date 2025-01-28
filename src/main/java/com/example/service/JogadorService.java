package com.example.service;

import com.example.model.entity.Jogador;
import com.example.model.entity.armas.Arma;
import com.example.model.entity.classes.ClasseEspecial;

public class JogadorService { // implements IJogadorAcoes/Service // controlar ações de combate
    private Jogador jogador;
    private ClasseEspecial classeEspecial;
    private Arma arma;
    
    public JogadorService(Jogador jogador){
        this.jogador = jogador;
    }

    // criando metodos dentro de jogador com base no relacionamento
    // jogador-arma para facilitar essa troca de informação para ataque e defesa
    public int atacar(){
        return this.jogador.getAtaque();
    }
    public int atacarComArma(){
        return this.jogador.getAtaque() + this.jogador.getAtaqueArma();
    }

    public int ataqueEspecialArma(){
        return this.atacarComArma() + this.jogador.getAtaqueArmaEspecial();
    }

    public int ataqueEspecialClasse(){
        return this.atacar() + this.jogador.getAtaqueClasseEspecial();
    }

    public int defender(){ //DEFENDE E DEVOLVE 1 DE DANO
        return (int)(this.jogador.getDefesa()*(1.5));
    }
    public int defesaReforcada(){//DEFENDE E REFLETE PARTE DO DANO
        return (int)(this.jogador.getDefesa()*(2.5));
        
    }
    // public void refletirDano(){}//acredito fazer mais setindo sendo função do proprio jogo   

}

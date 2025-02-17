package com.example.model.entity.classes;

import com.example.view.IGuerreiro;

public class Guerreiro extends ClasseEspecial implements IGuerreiro{
    //arma
    public Guerreiro(){
        super("Guerreiro", 5,1);
    }

    @Override
    public void curar(){
        System.out.println("CURAR!");
        // retun 5;
    }

    @Override
    public void aumentarAtaque() {
        System.out.println("mais ataque");
        // return 2;
    }
    
    @Override
    public void ataqueDuplo() {
        System.out.println("ataque duplo");
        //dobra o dano? faz sentido certo? um golpe de cada mao
    }
    
}

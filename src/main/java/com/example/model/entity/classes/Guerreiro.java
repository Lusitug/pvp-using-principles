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
    }

    @Override
    public void aumentarAtaque() {
        System.out.println("mais ataque");
    }
    
    @Override
    public void ataqueDuplo() {
        System.out.println("ataque duplo");
    
    }
    
}

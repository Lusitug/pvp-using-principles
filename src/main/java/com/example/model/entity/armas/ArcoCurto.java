package com.example.model.entity.armas;

import com.example.model.entity.classes.Guerreiro;

public class ArcoCurto extends Arma{
        public ArcoCurto(){
        super("Arco Curto",2, 0, new Guerreiro());
    }
    
    @Override
    public int ataqueEspecial() {
        System.out.println("CHUVA DE FLECHAS");
        return 3;
    }
}

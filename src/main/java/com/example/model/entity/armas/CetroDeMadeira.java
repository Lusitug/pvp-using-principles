package com.example.model.entity.armas;

import com.example.model.entity.classes.Mago;

public class CetroDeMadeira extends Arma {

    public CetroDeMadeira(){
        super("Cetro de Madeira",2, 3, new Mago());
    }
    
    @Override
    public int ataqueEspecial() {
        System.out.println("BOLA DE FOGO!");
        return 3;
    }
    
}

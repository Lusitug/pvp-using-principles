package com.example.model.entity.armas;

import com.example.model.entity.classes.Mago;

public class CetroDeMadeira extends Arma {

    public CetroDeMadeira(){
        super("Cetro de Madeira",1, 1, new Mago());
    }
    
    @Override
    public int ataqueEspecial() {
        return 1;
    }
    
}

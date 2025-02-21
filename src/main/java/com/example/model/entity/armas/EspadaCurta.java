package com.example.model.entity.armas;

import com.example.model.entity.classes.Guerreiro;

public class EspadaCurta extends Arma {
    public EspadaCurta(){
        super("Espada Curta",3,1, new Guerreiro());   
    }
    
    @Override
    public int ataqueEspecial() {
        System.out.println("CORTE RÁPIDO");
        return 3;
    }
    
}

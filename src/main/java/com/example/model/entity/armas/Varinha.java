package com.example.model.entity.armas;

import com.example.model.entity.classes.Mago;

public class Varinha extends Arma{
    public Varinha(){
        super("Varinha", 2, 2, new Mago());
    }
    @Override
    public int ataqueEspecial() {
        System.out.println("RAIO ELETRICO");
        return 1;
    }
    
}

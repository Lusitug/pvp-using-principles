package com.example.model.entity.armas;

import com.example.model.entity.classes.Mago;

public class Varinha extends Arma{
    public Varinha(){
        super("Varinha", 1, 1, new Mago());
    }
    @Override
    public int ataqueEspecial() {
        return 1;
    }
    
}

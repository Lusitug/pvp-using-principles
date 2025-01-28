package com.example.model.entity.classes;

import com.example.view.IMago;

public class Mago extends ClasseEspecial implements IMago{
//arma
    public Mago(){
        super("Mago",2 , 2);
    }

    @Override
    public void curar() {
        System.out.println("CURAR!");
    }

    @Override
    public void bolaDeFogo() {
        System.out.println("BOLA DE FOGO!");
    }
    
    @Override
    public void buffarAtributos() {
        System.out.println("BUFFAR");
    }
    
}

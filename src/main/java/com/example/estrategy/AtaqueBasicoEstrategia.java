package com.example.estrategy;

import com.example.model.entity.Jogador;
import com.example.view.IAtaqueEstrategia;

public class AtaqueBasicoEstrategia implements IAtaqueEstrategia{

    @Override
    public int atacando(Jogador jogador) {
        System.out.println("\nAtaque Básico.");
        return jogador.getAtaque();
    }
    
}

package com.example.estrategy;

import com.example.model.entity.Jogador;
import com.example.view.IAtaqueEstrategia;

public class AtaqueArmaEstrategia implements IAtaqueEstrategia{
    
    @Override
    public int atacando(Jogador jogador) {
        System.out.println("\nAtaque com Arma.");
        return jogador.getAtaque() + jogador.armaAtaqueEspecial();
    }
}

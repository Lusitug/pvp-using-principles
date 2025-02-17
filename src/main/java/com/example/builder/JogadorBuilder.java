package com.example.builder;

import com.example.model.entity.GerenciarArmas;
import com.example.model.entity.GerenciarClasses;
import com.example.view.IAtaqueEstrategia;

public class JogadorBuilder {
    private String nome;
    private int ataque;
    private int defesa;
    private int HP;
    private GerenciarArmas gerenciadorDeArmas; //separar responsabilidades de arma
    private GerenciarClasses gerenciadorDeClasses; //separar responsabilidades de classe
    private IAtaqueEstrategia estrategiaAtual; // estrategia
}

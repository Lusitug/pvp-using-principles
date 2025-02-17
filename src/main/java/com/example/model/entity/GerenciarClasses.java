package com.example.model.entity;

import com.example.model.entity.classes.ClasseEspecial;

public class GerenciarClasses { //separei as gerencia de informações de classe do jogador

    private ClasseEspecial classeEspecial;
    private Jogador jogador;

    public GerenciarClasses(Jogador jogador) {
        this.jogador = jogador;
    }

    public void mudarClasse(ClasseEspecial classeEspecial) {
        this.classeEspecial = classeEspecial;
        this.aplicarStatusClasse();
    }

    private void aplicarStatusClasse() {
        this.jogador.setAtaque(jogador.getAtaque() + classeEspecial.getAtaqueEspecial());
        this.jogador.setDefesa(jogador.getDefesa() + classeEspecial.getDefesaEspecial());
    }

    public ClasseEspecial getClasseEspecial() {
        return this.classeEspecial;
    }
}

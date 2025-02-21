package com.example.model.entity;

import com.example.view.IArma;

public class GerenciarArmas { //separei as gerencia de informações de classe do jogador
    private IArma arma;
    private Jogador jogador;

    public GerenciarArmas(Jogador jogador) {
        this.jogador = jogador;
    }

    public void equiparArma(IArma arma) {
        if (arma == null) { // se a nova arma passada por parametro for null, entao arma recebe null;
            if (this.arma != null) { // se tiver alguma arma equipada, remove o status da arma e em seguida arma recebe null
                this.removerStatusArma();
            }
            this.arma = null;
            return;
        }

        if (this.arma == null && !this.jogador.compararCompatibilidadeClasseArma(arma)) { // compara a compatibildade entre a classe do jogador e da nova arma
            return; // Não permite equipar arma de classe incompatível 
        }

        if (this.jogador.compararCompatibilidadeClasseArma(arma)) {     // compara a compatibilidade das classes da nova arma, se for compativel
            if (this.arma != null) { // se houver uma arma equipada entao remove o status dela
                this.removerStatusArma();
            }
            this.arma = arma;    // equipa a nova arma
            this.aplicarStatusArma();  // aplica os status de ataque e defesa da nova arma
        } else { // se a nova arma for incompatível
            if (this.arma != null) { // se houver arma equipada entao remove o status dela e a arma atual é removida(recebe null)
                this.removerStatusArma();
            }
            this.arma = null;
        }
    }

    private void aplicarStatusArma() {
        this.jogador.setAtaque(jogador.getAtaque() + arma.getAtaqueExtra());
        this.jogador.setDefesa(jogador.getDefesa() + arma.getDefesaExtra());
    }

    private void removerStatusArma() {
        this.jogador.setAtaque(jogador.getAtaque() - arma.getAtaqueExtra());
        this.jogador.setDefesa(jogador.getDefesa() - arma.getDefesaExtra());
    }

    public IArma getArma() {
        return this.arma;
    }
}

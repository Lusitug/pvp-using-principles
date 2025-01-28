package com.example.view;

import com.example.model.entity.armas.Arma;

public interface IJogadorCombatibilidades {
    public Boolean compararCompatibilidadeClasseArma(Arma arma);
    public void verificarCompatibilidadeClasseArma();
}

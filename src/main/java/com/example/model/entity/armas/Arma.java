package com.example.model.entity.armas;

import com.example.model.entity.classes.ClasseEspecial;

public abstract class Arma {
    private String nome;
    private int ataqueExtra;
    private int defesaExtra;
    private ClasseEspecial classePermitida;

    public Arma(String nome, int ataqueExtra, int defesaExtra, ClasseEspecial classe){
        this.nome = nome;
        this.ataqueExtra = ataqueExtra;
        this.defesaExtra = defesaExtra;
        this.classePermitida = classe;
    }

    public abstract int ataqueEspecial();

    public String getNomeClasse(){
        return this.classePermitida.getNome();
    }

    public Class<?> getClasseEspecialClass(){  // mesma assinatura e comportamento similar localizado em ClasseEspecial
        return this.classePermitida.getClass();
    }
    
    public String getNome() {        return nome;    }

    public void setNome(String nome) {        this.nome = nome;    }

    public int getAtaqueExtra() {        return ataqueExtra;    }

    public void setAtaqueExtra(int ataqueExtra) {        this.ataqueExtra = ataqueExtra;     }

    public int getDefesaExtra() {        return defesaExtra;    }

    public void setDefesaExtra(int defesaExtra) {        this.defesaExtra = defesaExtra;    }

    public ClasseEspecial getClassePermitida() {        return classePermitida;    }

    public void setClassePermitida(ClasseEspecial classePermitida) {
        this.classePermitida = classePermitida;
    }

    @Override
    public String toString() {
        return "Arma [nome=" + nome + ", ataqueExtra=" + ataqueExtra + ", defesaExtra=" + defesaExtra
                + ", classePermitida=" + classePermitida.getNome() + "]";
    }


    
}

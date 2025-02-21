package com.example.model.entity.classes;

import com.example.view.IClasseEspecial;

public abstract class ClasseEspecial implements IClasseEspecial {
    private int ataqueEspecial;
    private int defesaEspecial;
    private String nome;
    

    public ClasseEspecial(String nome, int ataqueEspecial, int defesaEspecial){
        this.nome = nome;
        this.ataqueEspecial = ataqueEspecial;
        this.defesaEspecial = defesaEspecial;
    }
   
    public int getAtaqueEspecial(){ return this.ataqueEspecial;}
    public int getDefesaEspecial(){ return this.defesaEspecial;}

    public void setAtaqueEspecial(int ataqueEspecial) {        this.ataqueEspecial = ataqueEspecial;    }
    public void setDefesaEspecial(int defesaEspecial) {        this.defesaEspecial = defesaEspecial;    }

    public String getNome() {        return nome;    }
    public void setNome(String nome) {        this.nome = nome;    }

    public Class<?> getClasseEspecialClass(){ // //retornar a classe especial do jogador
        return this.getClass();
    }

    // verifica se a classe especial jogador é igual a classe especial da arma
    @Override
    public boolean equals(Object obj){ // comparar getClasseEspecialClass() da classe especial e da arma
        if( this == obj) return true;
        if( obj == null || this.getClass() != obj.getClass()) return false;
        
        return this.getClass().equals(obj.getClass());
    } //verifica se as duas instâncias de classe especial(do jogador e da arma) são consideradas iguais
    // apenas se forem exatamente da mesma classe.

    @Override
    public int hashCode(){ // mantem as duas instâncias de classe especial com o mesmo código hash 
        return getClass().hashCode(); // hash code da class
        // comparar classes com hashes diferentes dá erro.
    }

}

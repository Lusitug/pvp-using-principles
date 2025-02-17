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

    public Class<?> getClasseEspecialClass(){ // mesma assinatura e comportamento similar localizado em Arma
        return this.getClass();
    }

    // comparaçao de classe entre objetos
    @Override
    public boolean equals(Object obj){
        if( this == obj) return true;
        if( obj == null || this.getClass() != obj.getClass()) return false;
        
        return this.getClass().equals(obj.getClass());
    }

    @Override
    public int hashCode(){
        return getClass().hashCode(); // hash code da class
    }

}

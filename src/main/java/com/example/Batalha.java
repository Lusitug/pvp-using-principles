package com.example;

import java.util.Scanner;

import com.example.estrategy.AtaqueArmaEstrategia;
import com.example.estrategy.AtaqueBasicoEstrategia;
import com.example.factory.ArmaIncialFactory;
import com.example.model.entity.Jogador;
import com.example.model.entity.classes.Guerreiro;
import com.example.model.entity.classes.Mago;
import com.example.model.enums.ETipoArma;
import com.example.view.IArma;
import com.example.view.IArmaFactory;

public class Batalha {
    // private ArrayList<IMonstro> monstros = new ArrayList<IMonstro>();
    boolean alertaMorte = false;

    public boolean jogadorMorreu(){
        return alertaMorte;
    }
    
    public void escolherEstratégia(Jogador jogador) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEscolha sua estratégia de ataque:");
        System.out.println("1 - Ataque Básico");
        System.out.println("2 - Ataque com Arma");

        int escolha = scanner.nextInt();
        switch (escolha) {
            case 1 -> jogador.setEstrategiaAtual(new AtaqueBasicoEstrategia());
            case 2 -> jogador.setEstrategiaAtual(new AtaqueArmaEstrategia());
            default -> {
                System.out.println("Escolha inválida. Usando Ataque Básico como padrão.");
                jogador.setEstrategiaAtual(new AtaqueBasicoEstrategia());
            }
        }
    }

    public void batalhar(Jogador jogador1, Jogador jogador2) {
        while (jogador1.getHP() > 0 && jogador2.getHP() > 0) {
            // Jogador 1 escolhe sua estratégia
            System.out.println("\n"+jogador1.getNome() + ", sua vez!");
            escolherEstratégia(jogador1);  // Jogador 1 escolhe a estratégia
            // Jogador 1 ataca jogador 2
            int dano1 = jogador1.atacar();
            jogador2.setHP(jogador2.getHP() - dano1);
            System.out.println(jogador1.getNome() + " atacou " + jogador2.getNome() + " causando " + dano1 + " de dano.");
            System.out.println("HP de " + jogador2.getNome() + ": " + jogador2.getHP());

            if (jogador2.getHP() <= 0) {
                System.out.println("\n" + jogador1.getNome() + " venceu!");
                System.out.println(jogador1.toString());
                alertaMorte = true;
                break;
            }

            // Jogador 2 escolhe sua estratégia
            System.out.println("\n"+jogador2.getNome() + ", sua vez!");
            escolherEstratégia(jogador2);  // Jogador 2 escolhe a estratégia
            // Jogador 2 ataca jogador 1
            int dano2 = jogador2.atacar();
            jogador1.setHP(jogador1.getHP() - dano2);
            System.out.println(jogador2.getNome() + " atacou " + jogador1.getNome() + " causando " + dano2 + " de dano.");
            System.out.println("HP de " + jogador1.getNome() + ": " + jogador1.getHP());
            
            if (jogador1.getHP() <= 0) {
                System.out.println("\n" + jogador2.getNome() + " venceu!");
                System.out.println(jogador2.toString());
                alertaMorte = true;
                break;
            }
        }
    }

    

    public void rodar() {
        Jogador jogador1 = new Jogador("Luis", 20, 5, new Guerreiro());
        IArmaFactory armaFactory = ArmaIncialFactory.getInstance();
        IArma arma1 = armaFactory.criaArma(ETipoArma.ARCOCURTO);
        jogador1.equiparArma(arma1);
        Jogador jogador2 = new Jogador("Rayssa", 30, 5, new Mago());
        IArma arma2 = armaFactory.criaArma(ETipoArma.VARINHA);
        jogador2.equiparArma(arma2);
        batalhar(jogador1, jogador2);
        System.out.println(alertaMorte);
        
  
    }

}


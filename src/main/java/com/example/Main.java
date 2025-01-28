package com.example;

import com.example.model.entity.Jogador;
import com.example.model.entity.armas.ArcoCurto;
import com.example.model.entity.armas.Arma;
import com.example.model.entity.classes.Guerreiro;
import com.example.service.JogadorService;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        // Mago mago = new Mago();
        Jogador jogador1 = new Jogador("Luis",2,5, new Guerreiro());
        // Jogador jogador2 = new Jogador("Rayssa",1,1, new Mago());

        // Arma varinha = new Varinha();
        // Arma espadaCurta = new EspadaCurta();
        Arma arcoCurto = new ArcoCurto();
        // Arma cetroDeMadeira = new CetroDeMadeira();

        // System.out.println(jogador1.toString());
        jogador1.setArma(arcoCurto);
        System.out.println(jogador1.toString());
        
        // System.out.println(jogador2.toString());
        // jogador2.setArma(varinha);
        // System.out.println(jogador2.toString());
        
        // jogador1.setClasseEspecial(mago);
        // System.out.println(jogador1.toString());
        // jogador1.setClasseEspecial(guerreiro);
        // System.out.println(jogador1.toString());
        // jogador1.setArma(varinha);
        // System.out.println(jogador1.toString());
        // jogador1.setArma(arcoCurto);
        // System.out.println(jogador1.toString());
        // jogador1.setArma(espadaCurta);
        // System.out.println(jogador1.toString());
        // jogador1.setArma(cetroDeMadeira);
        // System.out.println(jogador1.toString());
        JogadorService jogadorService = new JogadorService(jogador1);
        
        System.out.println(jogadorService.defender());
        System.out.println(jogadorService.defesaReforcada());
        
        System.out.println(jogadorService.atacar());
        System.out.println(jogadorService.atacarComArma());
        System.out.println(jogadorService.ataqueEspecialArma());
        System.out.println(jogadorService.ataqueEspecialClasse());
        // System.out.println(jogador1.getClasseEspecial().equals(espadaCurta.getClassePermitida()));
        // System.out.println(jogador1.compararCompatibilidadeClasseArma());

        // jogador1.setArma(espadaLonga);
        // jogador2.setArma(cajado);
        
        // int HP_j1 = 20;
        // int HP_j2 = 20;
        
        // while (HP_j1 > 0 && HP_j2 > 0) {
        //     // Jogador 1 escolhe a ação
        //     System.out.println("--------------------------");
        //     System.out.println("\nJogador 1 (" + jogador1.getNome() + "), escolha sua ação:");
        //     System.out.println("1. Atacar\n2. Defender\n3. Nada");
        //     int acao1 = scanner.nextInt();
        //     System.out.println("--------------------------");
            
        //     int defesaJ1 = jogador1.getDefesa(); // Defesa padrão
        //     if (acao1 == 2) {
        //         defesaJ1 = jogador1.defesaReforcada(); // Defesa reforçada
        //         System.out.println("defesa: "+defesaJ1);
        //     }
            
        //     // Jogador 2 escolhe a ação
        //     System.out.println("--------------------------");
        //     System.out.println("\nJogador 2 (" + jogador2.getNome() + "), escolha sua ação:");
        //     System.out.println("1. Atacar\n2. Defender\n3. Nada");
        //     int acao2 = scanner.nextInt();
        //     System.out.println("--------------------------");
            
        //     int defesaJ2 = jogador2.getDefesa(); // Defesa padrão
        //     if (acao2 == 2) {
        //         defesaJ2 = jogador2.defesaReforcada(); // Defesa reforçada
        //         System.out.println("defesa: "+defesaJ2);
        //     }
        
        //     // Cálculo de dano
        //     if (acao1 == 1) {
        //         int dano = Math.max(1, jogador1.atacarComArma() - defesaJ2);
        //         System.out.println("dano: "+dano);
        //         HP_j2 -= dano;
        //         System.out.println(jogador1.getNome() + " causou " + dano + " de dano em " + jogador2.getNome());
        //     }
        //     if (acao2 == 1) {
        //         int dano = Math.max(1, jogador2.atacarComArma() - defesaJ1);
        //         System.out.println("dano: "+dano);
        //         HP_j1 -= dano;
        //         System.out.println(jogador2.getNome() + " causou " + dano + " de dano em " + jogador1.getNome());
        //     }
        
        //     // Exibe status
        //     System.out.println("*****************************");
        //     System.out.println("\nEstado atual:");
        //     System.out.println(jogador1 + "HP: " + HP_j1);
        //     System.out.println(jogador2 + "HP: " + HP_j2);
        //     System.out.println("*****************************");
        // }
        // // Determina o vencedor
        // if (HP_j1 > 0) {
        //     System.out.println("\n" + jogador1.getNome() + " venceu a batalha!");
        // } else if (HP_j2 > 0) {
        //     System.out.println("\n" + jogador2.getNome() + " venceu a batalha!");
        // } else {
        //     System.out.println("\nA batalha terminou em empate!");
        // }
        
    
    }

}

//se usar 3 nada carrega poder magico de classe
//reimplementar classe

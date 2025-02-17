package com.example;

import java.util.Scanner;

import com.example.builder.JogadorBuilder;
import com.example.estrategy.AtaqueArmaEstrategia;
import com.example.estrategy.AtaqueBasicoEstrategia;
import com.example.factory.ArmaIncialFactory;
import com.example.model.entity.Jogador;
import com.example.model.entity.classes.ClasseEspecial;
import com.example.model.entity.classes.Guerreiro;
import com.example.model.entity.classes.Mago;
import com.example.model.enums.ETipoArma;
import com.example.view.IArma;
import com.example.view.IArmaFactory;

public class Batalha {
    // private ArrayList<IMonstro> monstros = new ArrayList<IMonstro>();
    Scanner scanner = new Scanner(System.in);
    
    public void escolherEstratégia(Jogador jogador) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEscolha sua estratégia de ataque:");
        System.out.println("1 - Ataque Básico");
        System.out.println("2 - Ataque com Arma");
        // System.out.println("3 - Ver Status");

        int escolha = scanner.nextInt();
        switch (escolha) {
            case 1 -> jogador.setEstrategiaAtual(new AtaqueBasicoEstrategia());
            case 2 -> jogador.setEstrategiaAtual(new AtaqueArmaEstrategia());
            // case 3 -> System.out.println(jogador.toString());
            default -> {
                System.out.println("Escolha inválida. Usando Ataque Básico como padrão.");
                jogador.setEstrategiaAtual(new AtaqueBasicoEstrategia());
            }
        }
    }
    public Jogador criarJogador(){
        String nome;
        int ataque, defesa;
        Jogador jogador;
        ClasseEspecial classeEspecial;

        System.out.println("\nQual o nome do personagem?");
        nome = scanner.nextLine();

        System.out.println("Qual o ataque do personagem?");
        ataque = scanner.nextInt();    scanner.nextLine();  // Limpar o buffer após nextInt()

        System.out.println("Qual a defesa do personagem?");
        defesa = scanner.nextInt();    scanner.nextLine();  // Limpar o buffer após nextInt()
        
        System.out.println("Qual a classe especial do personagem?");
        System.out.println("\tGuerreiro[1]\n\tMago[2]\n");
        int classeInt = scanner.nextInt();    scanner.nextLine();  // Limpar o buffer após nextInt()
        
        classeEspecial = switch (classeInt) {
            case 1 -> new Guerreiro();
            case 2 -> new Mago();
            default -> {System.out.println("Opção inválida"); yield new Guerreiro();}
            
        };
        
        jogador = new JogadorBuilder(classeEspecial)
        .withNome(nome)
            .withAtaque(ataque)
            .withDefesa(defesa)
            .withHP(200)
            .build();    

        // System.out.println(jogador.toString());
        return jogador;
    }

    public IArma fabricarArma(){
        IArmaFactory armaFactory = ArmaIncialFactory.getInstance();
        IArma arma ;
        
        System.out.println("É possivel fabricar uma arma:");
        System.out.println("\tEspada Curta[1]\n\tArco Curto[2]\n\tVarinha[3]\n\tCetro de Madeira[4]");
        int armaInt = scanner.nextInt();    scanner.nextLine();  // Limpar o buffer após nextInt()

        arma = switch (armaInt) {
            case 1-> armaFactory.criaArma(ETipoArma.ESPADACURTA);
            case 2-> armaFactory.criaArma(ETipoArma.ARCOCURTO);
            case 3-> armaFactory.criaArma(ETipoArma.VARINHA);
            case 4-> armaFactory.criaArma(ETipoArma.CETRODEMADEIRA);
            default -> {System.out.println("Opção inválida"); yield arma = null;}
        };

        return arma;
    }
    
    public void fabricarArmaParaJogador(Jogador jogador, int[] contagemArma) {
        if (contagemArma[0] > 0) {
            System.out.println("Você deseja criar uma nova arma? (Sim: 1 / Não: 2)\n\tLimite de fabricação [" + contagemArma[0] + "]");
            int fabricar = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer após nextInt()

            if (fabricar == 1) {
                contagemArma[0]--;  // Atualiza a contagem de armas fabricadas
                IArma arma = fabricarArma();
                jogador.equiparArma(arma);
                if (arma != null) {
                    System.out.println("Arma fabricada com sucesso!");
                } else {
                    System.out.println("Arma não foi fabricada!");
                }
                System.out.println("Criação de armas restantes: " + contagemArma[0]);
            }
        }
    }
    
    public void batalhar(Jogador jogador1, Jogador jogador2) {
        int[] contagemFabricarArma1 = {3};  // Inicializando com 3
        int[] contagemFabricarArma2 = {3};  // Inicializando com 3

        while (jogador1.getHP() > 0 && jogador2.getHP() > 0) {
            System.out.println("***************************************************************************************");
    
            // escolher estratégia
            System.out.println("\n" + jogador1.getNome() + ", sua vez!");
            fabricarArmaParaJogador(jogador1, contagemFabricarArma1); // Passa o valor de contagemFabricarArma
            escolherEstratégia(jogador1);  
            // jogador 1 ataca jogador 2
            int dano1 = jogador1.atacar();
            jogador2.setHP(jogador2.getHP() - dano1);
            System.out.println(jogador1.getNome() + " atacou " + jogador2.getNome() + " causando " + dano1 + " de dano.");
            System.out.println("HP de " + jogador2.getNome() + ": " + jogador2.getHP());
    
            if (jogador2.getHP() <= 0) {
                System.out.println("\n" + jogador1.getNome() + " venceu!");
                System.out.println(jogador1.toString());
                break;
            }
            System.out.println("***************************************************************************************");
            
            // escolher estratégia
            System.out.println("\n" + jogador2.getNome() + ", sua vez!");
            fabricarArmaParaJogador(jogador2, contagemFabricarArma2); // Passa o valor de contagemFabricarArma2
            escolherEstratégia(jogador2); 
            // jogador 2 ataca jogador 1
            int dano2 = jogador2.atacar();
            jogador1.setHP(jogador1.getHP() - dano2);
            System.out.println(jogador2.getNome() + " atacou " + jogador1.getNome() + " causando " + dano2 + " de dano.");
            System.out.println("HP de " + jogador1.getNome() + ": " + jogador1.getHP());
    
            if (jogador1.getHP() <= 0) {
                System.out.println("\n" + jogador2.getNome() + " venceu!");
                System.out.println(jogador2.toString());
                break;
            }
            System.out.println("***************************************************************************************");
        }
    }
    


    public void rodar() {
        Jogador jogador1 = this.criarJogador();
        Jogador jogador2 = this.criarJogador();
        this.batalhar(jogador1, jogador2);


        
        
  
    }

}


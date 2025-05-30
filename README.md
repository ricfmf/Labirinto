
Sistema Tron: Uma Aventura na Grade Digital
Este projeto é um jogo simples baseado em texto que simula uma aventura na Grade Digital, inspirada no universo de Tron. O jogador (um "Programa Principal") navega por um labirinto, coletando fragmentos de código (tesouros) e enfrentando ameaças digitais (perigos) para otimizar o sistema e alcançar a vitória.

Funcionalidades do Jogo
Navegação no Labirinto: O jogador pode se mover para cima, baixo, esquerda e direita dentro de uma grade digital.

Coleta de Tesouros: Encontre e colete diferentes tipos de tesouros, cada um com um valor de pontos e um efeito único ao ser coletado:

Atualização de Sistema: Otimiza o sistema, aprimorando o tempo de resposta.

Fragmento de Código: Incorpora o fragmento ao sistema.

Token de Acesso: Desbloqueia um novo setor da grade.

Tesouro da Vitória: Encerra o jogo com vitória imediatamente ao ser coletado.

Enfrentamento de Perigos: Cuidado com as ameaças digitais que podem comprometer a integridade do seu programa (pontos):

Bug Corrompido: Um fragmento instável de código que causa falhas no sistema.

Sentinela Hostil: Um programa de segurança desviado que ataca usuários não autorizados.

Game Over Perigo: Uma armadilha fatal que encerra o jogo imediatamente.

Sistema de Pontuação: Colete tesouros para ganhar pontos e desvie de perigos para evitar perdê-los. O objetivo é atingir 40 pontos ou mais para vencer o desafio da Rede Tron.
Inventário: Verifique os fragmentos de código coletados e sua pontuação atual.

Mapa: Visualize o labirinto com a posição do jogador, tesouros e perigos.
Easter Egg: Descubra um easter egg especial relacionado a League of Legends para ganhar pontos extras!
Como Jogar
Compile o Projeto: Utilize um ambiente de desenvolvimento Java (IDE) como o NetBeans ou IntelliJ IDEA para compilar os arquivos .java.

Execute o Arquivo Main.java: Inicie a simulação do jogo.

Comandos: Digite as letras correspondentes para mover o jogador ou interagir com o sistema:

W: Mover para cima

S: Mover para baixo

A: Mover para esquerda

D: Mover para direita

I: Ver inventário

M: Mostrar mapa completo

Q: Sair do jogo

Estrutura do Projeto
Main.java: Contém a lógica principal do jogo, incluindo a interface do usuário e o loop do jogo.
Aventureiro.java: Representa o jogador, suas ações (mover, coletar tesouro, enfrentar perigo) e seu inventário.
Labirinto.java: Gerencia a grade digital, a adição e remoção de tesouros e perigos, e a validação de posições.
Tesouro.java: Classe abstrata base para todos os tesouros do jogo, definindo propriedades como nome, valor e localização, além de um método efeito() abstrato.
AtualizacaoDeSistema.java: Implementação de um tesouro que otimiza o sistema.
FragmentoDeCodigo.java: Implementação de um tesouro que incorpora um fragmento ao sistema.
TokenDeAcesso.java: Implementação de um tesouro que desbloqueia um novo setor da grade.
VitoriaTesouro.java: Implementação de um tesouro que concede a vitória imediata ao jogador.
Perigo.java: Classe abstrata base para todas as ameaças digitais, com propriedades como localização, dano, nome e descrição.
BugCorrompido.java: Implementação de um perigo que representa um bug do sistema fora de controle.
SentinelaHostil.java: Implementação de um perigo que representa uma sentinela hostil.
GameOverPerigo.java: Implementação de um perigo que encerra o jogo imediatamente.
Requisitos do Sistema
Java Development Kit (JDK) 8 ou superior.
Autor
Este projeto foi desenvolvido como parte de uma atividade acadêmica/pessoal.

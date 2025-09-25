
public class ControladorJogo {
    private Jogo jogo;
    private Jogador jogador;
    private TelaJogo tela;
    private BancoPalavras banco;

    public ControladorJogo(String nomeJogador) {
        this.tela = new TelaJogo();
        this.jogador = new Jogador(nomeJogador);
        this.banco = new BancoPalavras();
    }

    public void iniciarJogo() {
        String palavra = banco.sortearPalavra();
        this.jogo = new Jogo(palavra);

        // System.out.println("DEBUG - Palavra sorteada: " + palavra);

        tela.mostrarMensagem("Vamos começar a brincadeira, " + jogador.getNome() + "! Vamos Jogar Forca!");
        while (!jogo.venceu() && !jogo.perdeu()) {
            tela.mostrarEstado(jogo.getPalavraParcial(), jogo.getTentativasRestantes());
            char palpite = tela.lerPalpite();

            if (jogador.jaPalpitou(palpite)) {
                tela.mostrarMensagem("Voce ja usuou essa letra!");
                continue;
            }

            boolean acertou = jogo.verificarPalpite(palpite, jogador);

            if (acertou) {
                tela.mostrarMensagem("Boa! Você acertou");
            } else {
                tela.mostrarMensagem("Errou");
            }

        }
        if (jogo.venceu()) {
            tela.mostrarMensagem("PARABENS, VOCE EH BOM E NOVO");
        } else {
            tela.mostrarMensagem("GAME OVER! TREINE MAIS");
        }
    }
}

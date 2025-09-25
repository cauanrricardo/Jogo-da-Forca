import java.util.*;

public class Jogo {
    private String palavraSecreta;
    private Set<Character> letrasAcertadas;
    private int tentativasRestantes;

    public Jogo(String palavraSecreta) {
        this.palavraSecreta = palavraSecreta.toLowerCase();
        this.letrasAcertadas = new HashSet<>();
        this.tentativasRestantes = 6;
    }

    public boolean verificarPalpite(char letra, Jogador jogador) {
        letra = Character.toLowerCase(letra);
        // ja tentou a letra
        if (jogador.jaPalpitou(letra)) {
            return false;
        }
        // se nao for repetido adiiciona essa letra nos palpites
        jogador.fazerPalpite(letra);

        // verificar se o palpite do jogador existe na palavra, pq retorna > 1. o
        // indexOF retorna -1 caso o caractere nao exista na palavra
        if (palavraSecreta.contains(String.valueOf(letra))) {
            letrasAcertadas.add(letra);
            return true;
        } else {
            tentativasRestantes--;
            return false;
        }
    }

    public boolean venceu() {
        for (char letra : palavraSecreta.toCharArray()) { // toCharArray() = converte string pra array
            if (!letrasAcertadas.contains(letra)) { // se achar uma letra que não foi acertada ainda, já dá return false
                return false;
            }
        }
        return true;
    }

    public boolean perdeu() {
        return tentativasRestantes <= 0;
    }

    public String getPalavraParcial() {
        StringBuilder sb = new StringBuilder();
        for (char letra : palavraSecreta.toCharArray()) {
            if (letrasAcertadas.contains(letra)) { // se o jogador ja acertou a letra,a diciona ela
                sb.append(letra);
            } else {
                sb.append("_");
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    public int getTentativasRestantes() {
        return tentativasRestantes;
    }
}

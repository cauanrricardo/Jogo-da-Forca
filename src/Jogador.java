import java.util.*;

public class Jogador {
    private String nome;;
    private List<Character> palpites;

    public Jogador(String nome) {
        this.nome = nome;
        this.palpites = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void fazerPalpite(char letra) {
        palpites.add(Character.toLowerCase(letra));
        palpites.add(letra);
    }

    public boolean jaPalpitou(char letra) {
        letra = Character.toLowerCase(letra);
        return palpites.contains(letra);
    }

    public List<Character> getPalpites() {
        return palpites; // perigoso por questao de seguranca, o obejto tem acesso total ao arrayliste

    }

}

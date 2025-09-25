import java.util.*;

public class TelaJogo {
    private Scanner leitura = new Scanner(System.in);

    public void mostrarEstado(String palavra, int tentativas) {
        System.out.println("Palavra: " + palavra);
        System.out.println("Tentativas restantes: " + tentativas);
    }

    public void mostrarMensagem(String msg) {
        System.out.println(msg);
    }

    public char lerPalpite() {
        System.out.println("Digite uma letra: ");
        return leitura.next().toLowerCase().charAt(0); // toLowCAse tranfroma en letra minuscula
    }
}

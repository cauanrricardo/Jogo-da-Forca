import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class BancoPalavras {
    private final List<String> palavras;

    public BancoPalavras() {
        palavras = new ArrayList<>(
                Arrays.asList("mulher", "xerox", "teclado", "basquete", "agentina"));
    }

    public String sortearPalavra() {
        return palavras.get(ThreadLocalRandom.current().nextInt(palavras.size()));
    }
}

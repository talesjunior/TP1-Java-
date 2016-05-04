package empresa;
import java.util.Date;

public class Chamada {
    protected String numOrigem, numDestino;
    protected Date inicio, fim;

    public Chamada(String numOrigem, String numDestino, Date inicio, Date fim) {
        this.numOrigem = numOrigem;
        this.numDestino = numDestino;
        this.inicio = inicio;
        this.fim = fim;
    }
    
}

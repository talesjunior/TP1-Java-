package empresa;
import java.util.Date;

public class Telefone {
    protected String telefone; 
    protected Date ativacao;
    protected Date cancelamento;
    protected int pagamento, cliente, plano;

    public Telefone(String telefone, int plano, Date ativacao, int pagamento, int cliente) {
        this.telefone = telefone;
        this.plano = plano;
        this.ativacao = ativacao;
        this.pagamento = pagamento;
        this.cliente = cliente;
        this.cancelamento=null;
    }
}

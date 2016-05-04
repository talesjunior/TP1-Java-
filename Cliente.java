package empresa;
public class Cliente{
    protected String cpf, endereço;
    public String nome;

    public Cliente(String cpf, String endereço, String nome) {
        this.cpf = cpf;
        this.endereço = endereço;
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }  
}

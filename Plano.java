package empresa;

public class Plano {
    public int codigo, franquia;
    public String descrição;
    public Double valorMensal, valorChamada;

    public Plano(int codigo, int franquia, String descrição, Double valorMensal, Double valorChamada) {
        this.codigo = codigo;
        this.franquia = franquia;
        this.descrição = descrição;
        this.valorMensal = valorMensal;
        this.valorChamada = valorChamada;
    }
}

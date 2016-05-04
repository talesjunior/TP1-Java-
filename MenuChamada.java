package empresa;
import static empresa.MenuTelefone.listaTelefones;
import static empresa.MenuCliente.listaClientes;
import static empresa.MenuPlano.listaPlanos;
import java.util.Scanner;

public class MenuChamada {
    public static Chamada[] listaChamadas = new Chamada[10000];
    public static int registrarChamada(int i, int z, int b){
        Scanner input= new Scanner (System.in);
        if(i==0){
            System.out.println("Não há telefones cadastrados no sistema para realizar uma chamada. Pressione ENTER para retornar ao menu.");
            input.nextLine();
            return b;
        }
        System.out.println("Digite o número de origem: ");
        String numero;
        numero=input.nextLine();
        int j;
        for(j=0;j<z;)
        {
            if(listaTelefones[j].telefone.equals(numero)){
                System.out.println("Digite o número de destino: ");
                String numero2=input.nextLine();
                System.out.println("Digite a hora da chamada: ");
            }
        }
        return b+1;
    }
    public static int menuChamada(int i, int z, int b){
        Scanner input = new Scanner (System.in);
        int op;
        do{
            System.out.println("1 - Registrar Chamada Originada\n2 - Excluir uma Chamada\n3 - Listar Chamadas\n4 - Pesquisar uma Chamada\n0 - Voltar\n> ");
            op=input.nextInt();
            switch(op){
                case 1: b=menuChamada(i,z,b); break;
                case 2: break;
                case 3: break;
                case 4: break;
            }
        } while(op!=0);
        return b;
    }
}

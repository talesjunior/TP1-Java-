import java.util.Scanner;
import empresa.MenuCliente;
import empresa.MenuPlano;
import empresa.MenuTelefone;
import empresa.MenuChamada;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner (System.in);
        int op, clientesCadastrados=0, planosCadastrados=0, telefonesCadastrados=0, chamadasCadastradas=0;
        do{
            System.out.printf("\n\n---------- Menu Principal ----------\n1 - Planos \n2 - Clientes\n3 - Número de Telefone\n4 - Chamada Originada\n5 - Relatórios\n0 - Sair\n> ");
            op=input.nextInt();
            switch(op){
                case 1: planosCadastrados=MenuPlano.menuPlano(planosCadastrados); break;
                case 2: clientesCadastrados=MenuCliente.menuCliente(clientesCadastrados,telefonesCadastrados); break;
                case 3: telefonesCadastrados=MenuTelefone.menuTelefone(telefonesCadastrados,clientesCadastrados,planosCadastrados); break;
                case 4: chamadasCadastradas=MenuChamada.menuChamada(chamadasCadastradas,clientesCadastrados,telefonesCadastrados); break;
                case 5: break;
                case 0: System.out.println("Programa finalizado."); break;
                default: System.out.println("Opção inválda, tente novamente."); break;
            }
        } while(op!=0);
    }
}
oi gustavo cuxao

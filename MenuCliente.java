package empresa;
import java.util.Scanner;
import static empresa.MenuTelefone.listaTelefones;

public class MenuCliente {
    public static Cliente[] listaClientes = new Cliente[10000];
    public static void cadastrar(int i){
        Scanner input = new Scanner (System.in);
        int j; 
        String nome, endereço, cpf;
        System.out.println("Digite seu CPF(apenas números): ");
        cpf=input.next();
        if(i>0){
            for(j=0;j<i;j++){
                while(listaClientes[j].cpf.equals(cpf)){
                    System.out.println("CPF já cadastrado, tente novamente: ");
                    cpf=input.next();
                }
            }
        }
        input.nextLine();
        System.out.println("Digite seu nome completo: ");
        nome=input.nextLine();
        System.out.println("Digite seu endereço: ");
        endereço=input.nextLine();
        listaClientes[i]= new Cliente(cpf,endereço,nome);
        System.out.printf("Cliente cadastrado com sucesso! Pressione ENTER para continuar.");
        input.nextLine();
    }
    
    public static int alterar(int i){
        Scanner input = new Scanner (System.in);
        if(i==0){
            System.out.printf("Não há Clientes cadastrados. Pressione ENTER para retornar ao menu.");
            input.nextLine();
            return 0;
        }
        else{
            int j,op,aux=0;
            String cpf;
            System.out.println("Digite o CPF(apenas números): ");
            cpf=input.next();
            for(j=0;j<i;j++){
                if(listaClientes[j].cpf.equals(cpf)){
                    do{
                        System.out.printf("\n1 - Alterar nome\n2 - Alterar endereço\n0 - Voltar\n> ");
                        op=input.nextInt();
                        switch(op){
                            case 1: {
                                String nome;
                                System.out.printf("Nome atual: %s.\nDigite o novo nome: ",listaClientes[j].nome);
                                input.nextLine();
                                nome=input.nextLine();
                                listaClientes[j].nome=nome;
                                System.out.printf("Nome alterado com sucesso! Pressione ENTER para retornar ao menu");
                                input.nextLine();
                                break;
                            }
                            case 2: {
                                String endereço;
                                System.out.printf("Endereço atual: %s.\nDigite o novo endereço: ",listaClientes[j].endereço);
                                input.nextLine();
                                endereço=input.nextLine();
                                listaClientes[j].endereço=endereço;
                                System.out.printf("Endereço alterado com sucesso! Pressione ENTER para retornar ao menu.");
                                input.nextLine();
                                break;
                            }
                            case 0: break;
                            default : System.out.println("Opção inválida, tente novamente."); break;
                        }
                    } while(op!=0);
                    aux=1;
                }
            }
            if(aux==0){
                input.nextLine();
                System.out.printf("CPF não encontrado. Pressione ENTER para retornar ao menu.");
                input.nextLine();
            }
        }
        return 1;
    }
    
    public static int excluir(int i, int k){
        Scanner input = new Scanner (System.in);
        if(i==0){
            System.out.printf("Não há Clientes cadastrados. Pressione ENTER para retornar ao menu.");
            input.nextLine();
            return i;
        }
        else{
            int j,aux=0;
            String cpf;
            System.out.println("Digite o CPF do cliente que deseja excluir: ");
            cpf=input.nextLine();
            for(j=0;j<i;j++)
            {
                if(listaClientes[j].cpf.equals(cpf)){
                    int x;
                    for(x=0;x<k;x++){
                        if(listaTelefones[x].cliente==j){
                            System.out.println("Cliente cadastrado em um ou mais números de Telefone. Exclua o(s) número(s) ou cancele-o(s) para excluír o Cliente desejado. Pressione ENTER para voltar ao menu;");
                            input.nextLine();
                            return i;
                        }
                    }
                    aux=1;
                    while(j<i){
                        listaClientes[j]=listaClientes[j+1];
                        j=j+1;
                    }
                    break;
                }
            }
            if(aux==0){
                input.nextLine();
                System.out.println("CPF não encontrado. Pressione ENTER para retornar ao menu.");
                input.nextLine();
                return i;
            }
        }
        return i=(i-1);
    }
    
    public static int listar(int i){
        Scanner input = new Scanner (System.in);
        if(i==0){
            System.out.printf("Não há Clientes cadastrados. Pressione ENTER para retornar ao menu.");
            input.nextLine();
            return 0;
        }
        else{
            int j;
            for(j=0;j<i;j++){
                System.out.printf("\nCPF: %s\nNome: %s\nEndereço: %s\n",listaClientes[j].cpf,listaClientes[j].nome,listaClientes[j].endereço);
            }
            System.out.printf("\nTotal de Clientes listados: %d. Pressione ENTER para retornar ao menu.",j);
            input.nextLine();
        }
        return 1;
    }
    
    public static int pesquisar(int i){
        Scanner input = new Scanner (System.in);
        if(i==0){
            System.out.printf("Não há Clientes cadastrados. Pressione ENTER para retornar ao menu.");
            input.nextLine();
            return 0;
        }
        else{
            int j, aux=0;
            String cpf;
            System.out.println("Digite o CPF do Cliente desejado (apenas números): ");
            cpf=input.next();
            for(j=0;j<i;j++){
                if(listaClientes[j].cpf.equals(cpf)){
                    System.out.printf("\n\nCPF: %s\nNome: %s\nEndereço: %s\n",listaClientes[j].cpf,listaClientes[j].nome,listaClientes[j].endereço);
                    aux=1;
                }
            }
            if(aux==0)
            {
                input.nextLine();
                System.out.printf("CPF não encontrado. Pressione ENTER para retornar ao menu");
                input.nextLine();
            }
            input.nextLine();
            System.out.printf("Pressione ENTER para retornar ao menu.");
            input.nextLine();
        }
        return 1;
     }
    
    public static int menuCliente(int i, int k){
        Scanner input = new Scanner (System.in);
        int op;
        do{
            System.out.printf("\n\n--------- Menu de Clientes ---------\n1 - Cadastrar\n2 - Alterar\n3 - Excluir\n4 - Listar\n5 - Pesquisar\n0 - Voltar\n> ");
            op=input.nextInt();
            switch(op){
                case 1: cadastrar(i); i=i+1; break;
                case 2: alterar(i); break;
                case 3: i=excluir(i,k); break;
                case 4: listar(i); break;
                case 5: pesquisar(i);
                case 0: break;
                default: System.out.println("Opção inválida, tente novamente."); break;
            }
        } while(op!=0);
        return i;
    }
}

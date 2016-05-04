package empresa;
import java.util.Scanner;

public class MenuPlano {
    public static Plano[] listaPlanos = new Plano[10000];         //Método responsável por cadastrar um plano no sistema,
    public static void cadastrar(int i){                          //requerindo que o usuário digite seu código, franquia,
        Scanner input = new Scanner (System.in);                  //descrição, valor mensal e valor por chamada. Se o código
        int j, codigo, franquia;                                  //fornecido já estiver em uso por outro plano previamente cadastrado
        String descrição;                                         //o método retornará uma mensagem de erro e pedirá um código diferente.
        Double valorMensal, valorChamada;
        System.out.println("Digite o código do plano: ");
        codigo=input.nextInt();
        for(j=0;j<i;j++){
            while(listaPlanos[j].codigo==codigo){
                System.out.println("Códgo já cadastrado, tente novamente: ");
                codigo=input.nextInt();
            }
        }
        System.out.println("Digite a descrição do plano: ");
        input.nextLine();
        descrição=input.nextLine();
        System.out.println("Digite a franquia do plano, em minutos: ");
        franquia=input.nextInt();
        System.out.println("Digite o valor mensal do plano: ");
        valorMensal=input.nextDouble();
        System.out.println("Digite o valor da chamada: ");
        valorChamada=input.nextDouble();
        listaPlanos[i] = new Plano(codigo,franquia,descrição,valorMensal,valorChamada);
        System.out.println("Cadastro efetuado com sucesso!");
    }
    
    public static int alterar(int i){
        Scanner input = new Scanner (System.in); 
        if(i==0){
            System.out.printf("Não há planos cadastrados. Pressione ENTER para retornar ao menu.");
            input.nextLine();
            return 0;
        }                                                                         //Método responsável por alterar um Plano previamente
        else{                                                                     //cadastrado. Requer que o usuário digite o código específico
            int j, op, codigo, aux=0;                                             //do plano que deseja alterar. Se o código não estiver cadastrado
            System.out.println("Digite o código do plano que deseja alterar: ");  //no sistema, o método retornará uma mensagem de erro.
            codigo=input.nextInt();                                               //Após fornecer o código do plano desejado, será exibido um novo
            for(j=0;j<i;j++){                                                     //menu para o usuário escolher qual parâmetro deseja alterar.
                if(listaPlanos[j].codigo==codigo){
                    do{
                        System.out.printf("\n1 - Alterar Descrição\n2 - Alterar Franquia\n3 - Alterar Valor Mensal\n4 - Alterar Valor da Chamada\n0 - Voltar\n> ");
                        op=input.nextInt();
                        switch(op){
                            case 1: {
                                System.out.printf("\nDescrição Atual: %s\nNova Descrição: ",listaPlanos[j].descrição);
                                input.nextLine();
                                listaPlanos[j].descrição=input.nextLine();
                                input.nextLine();
                                System.out.printf("Descrição alterada com sucesso! Pressione ENTER para continuar.");
                                input.nextLine();
                                break;
                            }
                            case 2: {
                                int franquia;
                                System.out.printf("\nFranquia Atual: %d\nNova Franquia: ",listaPlanos[j].franquia);
                                listaPlanos[j].franquia=input.nextInt();
                                input.nextLine();
                                System.out.printf("Franquia alterada com sucesso! Pressione ENTER para continuar.");
                                input.nextLine();
                                break;
                            }
                            case 3: {
                                System.out.printf("Valor mensal atual: %.2f\nNovo valor mensal: ",listaPlanos[j].valorMensal);
                                listaPlanos[j].valorMensal=input.nextDouble();
                                input.nextLine();
                                System.out.printf("Valor mensal alterado com sucesso! Pressione ENTER para continuar.");
                                input.nextLine();
                                break;
                            }
                            case 4: {
                                System.out.printf("Valor da chamada atual: %.2f\nNovo valor da chaamda: ",listaPlanos[j].valorChamada);
                                listaPlanos[j].valorChamada=input.nextDouble();
                                input.nextLine();
                                System.out.printf("Valor da chamada alterado com sucesso! Pressione ENTER para continuar.");
                                input.nextLine();
                                break;
                            }
                            case 0: break;
                            default: System.out.println("Opção inválida, tente novamente: "); break;
                        }
                    } while(op!=0);
                    aux=1;
                }
            }
            if(aux==0){
                input.nextLine();
                System.out.printf("Código não cadastrado! Pressione ENTER para retornar o menu.");
                input.nextLine();
            }
        }
        return 1;
    }
    
    public static int excluir(int i){
        Scanner input = new Scanner (System.in);
        if(i==0){
            System.out.printf("Não há planos cadastrados. Pressione ENTER para retornar ao menu.");
            input.nextLine();
            return 0;
        }
        else{
            int codigo, aux=0;
            System.out.println("Digite o código do Plano que deseja excluir do sistema: ");
            codigo=input.nextInt();
            int j;
            for(j=0;j<i;j++){
                if(listaPlanos[j].codigo==codigo){
                    while(j<i){
                        listaPlanos[j]=listaPlanos[j+1];
                        j=j+1;
                    }
                    aux=1;
                }
            }
            if(aux==0){
                input.nextLine();
                System.out.printf("Código não cadastrado! Pressione ENTER para retornar o menu.");
                input.nextLine();
            }
            else{
                input.nextLine();
                System.out.printf("Plano excluído com sucesso! Pressione ENTER para retornar ao menu");
                input.nextLine();
            }
        }
        return (i=i-1);
    }
    
    public static int listar(int i){                     //Método responsável por listar todos os planos cadastrados
        Scanner input = new Scanner (System.in);         //no sistema. Se não houver planos cadastrados, retorna uma
        if(i==0){                                        //mensagem de erro.
            System.out.printf("Não há planos cadastrados. Pressione ENTER para retornar ao menu.");
            input.nextLine();
            return 0;
        }            
        else{
            int j;                                            
            for(j=0;j<i;j++){
                System.out.printf("\nCódigo: %d\nDescrição: %s\nFranquia: %d minutos\nValor Mensal: R$%.2f\nValor por Chamada: R$%.2f\n",listaPlanos[j].codigo,listaPlanos[j].descrição,listaPlanos[j].franquia,listaPlanos[j].valorMensal,listaPlanos[j].valorChamada);
            }
            System.out.printf("\nTotal de Planos listados: %d. Pressione ENTER para retornar ao menu.",i);
            input.nextLine();
        }
        return 1;
    }
    
    public static void pesquisar(int i){                 //Método responsável por listar um plano específico, após
        Scanner input = new Scanner (System.in);         //o usuário específicar qual o código do plano desejado.
            int codigo, j, aux=0;                        //Se o código não existir, o método retornará uma mensagem de erro.
            System.out.println("Digite o código do plano desejado: ");
            codigo=input.nextInt();
            for(j=0;j<i;j++){
                if(listaPlanos[j].codigo==codigo){
                System.out.printf("\nCódigo: %d\nDescrição: %s\nFranquia: %d minutos\nValor Mensal: R$%.2f\nValor por Chamada: R$%.2f\n",listaPlanos[j].codigo,listaPlanos[j].descrição,listaPlanos[j].franquia,listaPlanos[j].valorMensal,listaPlanos[j].valorChamada);
                aux=1;
                break;
                }
            }
            if(aux==0){
                input.nextLine();
                System.out.printf("Código não cadastrado! Pressione ENTER para retornar o menu.");
                input.nextLine();
            }
            else{
                input.nextLine();
                System.out.printf("Pressione ENTER para retornar ao menu");
                input.nextLine();
        }
    }
    
    public static int menuPlano(int i){
        Scanner input = new Scanner (System.in);
        int op;
        do{
            System.out.printf("\n\n---------- Menu de Planos ----------\n1 - Cadastrar\n2 - Alterar\n3 - Excluir\n4 - Listar\n5 - Pesquisar\n0 - Voltar\n> ");
            op=input.nextInt();
            switch(op){
                case 1: cadastrar(i); i=i+1; break;                      //Menu responsável por gerenciar os métodos dos Planos
                case 2: alterar(i); break;                               //sendo eles: Cadastrar, Alterar, Exluir, Listar e Pesquisar.
                case 3: i=excluir(i); break;                             //A opção "0" (zero), retorna ao menu principal do sistema.
                case 4: listar(i); break;
                case 5: pesquisar(i); break;
                case 0: break;
                default: System.out.println("Opção inválida, tente novamente."); break;
            }
        } while(op!=0);
        return i;
    }
}

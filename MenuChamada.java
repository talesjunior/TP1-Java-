package empresa;
import static empresa.MenuTelefone.listaTelefones;
import java.util.Scanner;
import java.util.Date;

public class MenuChamada {
    public static Chamada[] listaChamadas = new Chamada[10000];
    public static int registrarChamada(int i, int z, int b){
        Scanner input= new Scanner (System.in);
        if(b==0){
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
            if(listaTelefones[j].telefone.equals(numero)&&listaTelefones[j].cancelamento==null){
                System.out.println("Digite o número de destino: ");
                String numero2=input.nextLine();
                System.out.println("Digite as informações sobre o Dia/Horário de início: ");
                int ano,mes,dia,hora,min,seg;
                System.out.printf("Ano: ");
                ano=input.nextInt();
                System.out.printf("Mes: ");
                mes=input.nextInt();
                System.out.printf("Dia: ");
                dia=input.nextInt();
                System.out.printf("Hora: ");
                hora=input.nextInt();
                System.out.printf("Minuto: ");
                min=input.nextInt();
                System.out.printf("Segundo: ");
                seg=input.nextInt();
                Date dataInicio = new Date(ano-1900,mes-1,dia,hora,min,seg);
                while(dataInicio.before(listaTelefones[j].ativacao)){
                    System.out.println("Data inválida, tente novamente: ");
                    System.out.printf("Ano: ");
                    ano=input.nextInt();
                    System.out.printf("Mes: ");
                    mes=input.nextInt();
                    System.out.printf("Dia: ");
                    dia=input.nextInt();
                    System.out.printf("Hora: ");
                    hora=input.nextInt();
                    System.out.printf("Minuto: ");
                    min=input.nextInt();
                    System.out.printf("Segundo: ");
                    seg=input.nextInt();
                    dataInicio = new Date(ano-1900,mes-1,dia,hora,min,seg);
                }
                System.out.println("Agora digite as informações sobre o Dia/Horário de término: ");
                System.out.printf("Ano: ");
                ano=input.nextInt();
                System.out.printf("Mes: ");
                mes=input.nextInt();
                System.out.printf("Dia: ");
                dia=input.nextInt();
                System.out.printf("Hora: ");
                hora=input.nextInt();
                System.out.printf("Minuto: ");
                min=input.nextInt();
                System.out.printf("Segundo: ");
                seg=input.nextInt();
                Date dataTermino = new Date(ano-1900,mes-1,dia,hora,min,seg);
                while(dataTermino.before(dataInicio)||dataTermino.before(listaTelefones[j].ativacao)){
                    System.out.println("Data inválida, tente novamente: ");
                    System.out.printf("Ano: ");
                    ano=input.nextInt();
                    System.out.printf("Mes: ");
                    mes=input.nextInt();
                    System.out.printf("Dia: ");
                    dia=input.nextInt();
                    System.out.printf("Hora: ");
                    hora=input.nextInt();
                    System.out.printf("Minuto: ");
                    min=input.nextInt();
                    System.out.printf("Segundo: ");
                    seg=input.nextInt();
                    dataTermino = new Date(ano-1900,mes-1,dia,hora,min,seg);
                }
                System.out.printf("\nChamada registrada com sucesso! Pressone ENTER para retornar ao menu.");
                input.nextLine();
                input.nextLine();
                listaChamadas[i] = new Chamada (numero,numero2,dataInicio,dataTermino);
                break;
            }
            if(j==(z-1)){
                System.out.println("Número não encontrado no sistema ou possui data de cancelamento, tente novamente: ");
                numero=input.nextLine();
                j=0;
            }
            else{
                j++;
            }
        }
        return i+1;
    }
    
    public static int excluirChamadas(int i){
        Scanner input = new Scanner (System.in);
        if(i==0){
            System.out.println("Não há chamadas registradas no sistema. Pressione ENTER para retornar ao menu.");
            input.nextLine();
            return i;
        }
        System.out.println("Ao listar e/ou pesquisar chamadas, todas possuem um número de identificação próprio.\nPara excluir um número, digite o código e cofirme sua escolha.\n");
        int j,chamada;
        chamada=input.nextInt();
        for(j=0;j<i;j++){
            if(j==chamada){
                int op;
                do{
                    System.out.println("Tem certeza que deseja excluir a chamada?\n1 - SIM\n2 - NÃO\n> ");
                    op=input.nextInt();
                    switch(op){
                        case 1:{
                            while(j<i){
                                listaChamadas[j]=listaChamadas[j+1];
                            }
                        } break;
                        case 2: return i;
                        default: System.out.println("Opção inválida, tente novamente: "); break;
                    }
                }while(op!=2);
            }
        }
        System.out.println("Chamada excluída com sucesso! Pressione ENTER para retornar ao menu.");
        input.nextLine();
        return i-1;
    }
    
    public static int listarChamadas(int i){
        Scanner input = new Scanner (System.in);
        if(i==0){
            System.out.printf("Não há Chamadas registradas no sistema. Pressione ENTER para retornar ao menu.");
            input.nextLine();
            return i;
        }
        int j;
        for(j=0;j<i;j++){
            System.out.printf("\n[Chamada]\nNúmero de Origem: %s\nNúmero de Destino: %s\nData de Início: %s\nData de Término: %s\n--------------------------------\n\n",listaChamadas[j].numOrigem,listaChamadas[j].numDestino,listaChamadas[j].inicio,listaChamadas[j].fim);
        }
        System.out.printf("Foram listadas %d chamadas. Pressione ENTER para retornar ao menu.",i);
        input.nextLine();
        return i;
    }
    
    public static int pesquisarChamadas(int i){
        Scanner input = new Scanner (System.in);
        if(i==0){
            System.out.printf("Não há chamadas registradas no sistema. Pressione ENTER para retornar ao menu.");
            input.nextLine();
            return i;
        }
        System.out.println("Digite o número de telefone que deseja pesquisar: ");
        String telefone;
        telefone=input.nextLine();
        int j,contador=0;
        for(j=0;j<i;j++){
            if(listaChamadas[j].numOrigem.equals(telefone)){
                System.out.printf("\n[Informações da Chamada]\nNúmero de Origem: %s\nNúmero de Destino: %s\nHora de Início: %s\nHora do Término: %s\n\n-----------------------------------\n\n",listaChamadas[j].numOrigem,listaChamadas[j].numDestino,listaChamadas[j].inicio,listaChamadas[j].fim);
                contador++;
            }
        }
        if(contador==0){
            System.out.printf("Não foram encontrados registros de chamadas do Número %s. Pressione ENTER para retornar ao menu.",telefone);
            input.nextLine();
            return i;
        }
        System.out.printf("Foram exibidos %d chamadas. Pressione ENTER para retornar ao menu.",contador);
        input.nextLine();
        return i;
    }
    public static int menuChamada(int i, int z, int b){
        Scanner input = new Scanner (System.in);
        int op;
        do{
            System.out.println("\n\n--------- Menu de Chamadas ---------\n1 - Registrar Chamada Originada\n2 - Excluir uma Chamada\n3 - Listar Chamadas\n4 - Pesquisar uma Chamada\n0 - Voltar\n> ");
            op=input.nextInt();
            switch(op){
                case 1: i=registrarChamada(i,z,b); break;
                case 2: i=excluirChamadas(i); break; //Loop Infinito
                case 3: i=listarChamadas(i); break;
                case 4: i=pesquisarChamadas(i); break;
                case 0: break;
                default : System.out.println("Opção inválida, tente novamente: "); break;
            }
        } while(op!=0);
        return b;
    }
}

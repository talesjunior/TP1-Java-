package empresa;
import static empresa.MenuCliente.listaClientes;
import static empresa.MenuPlano.listaPlanos;
import java.util.Scanner;
import java.util.Date;

public class MenuTelefone {
    public static Telefone[] listaTelefones = new Telefone[10000];
    public static int cadastrar(int i, int k, int z) {
        Scanner input = new Scanner(System.in);
        if (k == 0 && z == 0) {
            System.out.printf("Não há Clientes e Planos cadastrados no sistema. Pressione ENTER para retornar ao menu");
            input.nextLine();
            return i;
        }
        if (k == 0 && z != 0) {
            System.out.printf("Não há Clientes cadastrados no sistema. Pressione ENTER para retornar ao menu.");
            input.nextLine();
            return i;
        }
        if (k != 0 && z == 0) {
            System.out.printf("Não há Planos cadastrados no sistema. Pressione ENTER para retornar ao menu.");
            input.nextLine();
            return i;
        }
        int j, cliente=0, codigo, pagamento;
        String telefone, cpf;
        Date data;
        data=new Date();
        System.out.println("Digite o número a ser cadastrado: ");
        telefone = input.nextLine();
        if(i>0){
            for (j=0;j<i;j++) {
                if (listaTelefones[j].telefone.equals(telefone)&&listaTelefones[j].cancelamento==null) {
                    System.out.printf("Número cadastrado e sem data de cancelamento. Pressione ENTER para voltar ao menu.");
                    input.nextLine();
                    return i;
                }
                if(listaTelefones[j].telefone.equals(telefone)&&data.before(listaTelefones[j].cancelamento)){
                    System.out.printf("Número cadastrado e ainda ativo no sistema. Pressione ENTER para voltar ao menu.");
                    input.nextLine();
                    return i;
                }
                if(listaTelefones[j].telefone.equals(telefone)&&data.after(listaTelefones[j].cancelamento)){
                    System.out.printf("ATENÇÃO! Os dados do Cliente antigo serão excluídos do número desejado!\nPressione ENTER para continuar.");
                    input.nextLine();
                    System.out.println("Digite o CPF do novo Cliente: ");
                    cpf=input.nextLine();
                    int aux=j;
                    for(j=0;j<k;){
                        if(listaClientes[j].cpf.equals(cpf)){
                            listaTelefones[aux].cliente=j;
                            break;
                        }
                        if(j==(i-1)){
                            System.out.println("CPF não encontrado no sistema, tente novamente: ");
                            cpf=input.nextLine();
                            j=0;
                        }
                        else{
                            j++;
                        }
                    }
                    System.out.println("Digite o código do Plano desejado: ");
                    codigo=input.nextInt();
                    for(j=0;j<z;){
                        if(listaPlanos[j].codigo==codigo){
                            listaTelefones[aux].plano=j;
                            break;
                        }
                        if(j==(i-1)){
                            System.out.println("Código não encontrado no sistema, tente novamente: ");
                            codigo=input.nextInt();
                            j=0;
                        }
                        else{
                            j++;
                        }
                    }
                    System.out.println("Escolha o dia do pagamento(Dia 1, Dia 5, Dia 10 ou Dia 15): ");
                    pagamento=input.nextInt();
                    while(pagamento!=1 && pagamento!=5 && pagamento!=10 && pagamento!=15){
                        System.out.println("Dia inválido, tente novamente: ");
                        pagamento=input.nextInt();
                    }
                    listaTelefones[aux].pagamento=pagamento;
                    listaTelefones[aux].ativacao=data;
                    System.out.print("Número cadastrado em novo Cliente com sucesso! Pressione ENTER para retornar ao menu.");
                    input.nextLine();
                    return i;
                }
                else {
                    System.out.println("Digite o CPF do Cliente que será vinculado ao número");
                    cpf = input.nextLine();
                    for (j=0;j<k;) {
                        if (listaClientes[j].cpf.equals(cpf)) {
                            cliente=j;
                            break;
                        }
                        else{
                            if(j==k-1){
                                System.out.println("CPF não encontrado no sistema. Tente novamente: ");
                                cpf=input.nextLine();
                                j=0;
                            }
                            else
                                j++;
                        }
                    }
                    System.out.println("Digite o Código do Plano que será vinculado ao número: ");
                    codigo = input.nextInt();
                    for (j=0;j<z;) {
                        if (listaPlanos[j].codigo == codigo) {
                            codigo=j;
                            break;
                        } 
                        else {
                            if(j==z-1){
                            System.out.println("Código não encontrado no sistema. Tente novamente: ");
                            codigo = input.nextInt();
                            j=0;
                            }
                            else
                                j++;
                        }
                    }
                    System.out.println("Escolha um dos dias para realizar o pagamento: Dia 1, Dia 5, Dia 10 ou Dia 15.");
                    pagamento = input.nextInt();
                    while (pagamento != 15 && pagamento != 10 && pagamento != 5 && pagamento != 1) {
                        System.out.println("Dia inválido, tente novamente: ");
                        pagamento = input.nextInt();
                    }
                    listaTelefones[i] = new Telefone(telefone, codigo, data, pagamento, cliente);
                    input.nextLine();
                    System.out.printf("Telefone cadastrado com sucesso! Pressione ENTER para retornar ao menu.");
                    input.nextLine();
                    return (i + 1);
                }
            }
        }
        System.out.println("Digite o CPF do Cliente que será vinculado ao número: ");
        cpf=input.nextLine();
        for(j=0;j<k;){
            if(listaClientes[j].cpf.equals(cpf)){
                cliente=j;
                break;
            }
            else{
                if(j==k-1){
                    System.out.println("CPF não encontrado no sistema. Tente novamente: ");
                    cpf=input.nextLine();
                    j=0;
                }
                else
                    j++;
            }
        }
        System.out.println("Digite o código do Plano que será vinculado ao número: ");
        codigo=input.nextInt();
        for(j=0;j<z;){
            if(listaPlanos[j].codigo==codigo){
                codigo=j;
                break;
            }
            else{
                if(j==z-1){
                    System.out.println("Código não encontrado no sistema. Tente novamente: ");
                    codigo=input.nextInt();
                }
                else
                    j++;
            }
        }
        System.out.println("Escolha um dos dias para realizar o pagamento: Dia 1, Dia 5, Dia 10 ou Dia 15.");
        pagamento = input.nextInt();
        while (pagamento != 15 && pagamento != 10 && pagamento != 5 && pagamento != 1) {
            System.out.println("Dia inválido, tente novamente: ");
            pagamento = input.nextInt();
        }
        listaTelefones[i] = new Telefone(telefone, codigo, new Date(), pagamento, cliente);
        input.nextLine();
        System.out.printf("Telefone cadastrado com sucesso! Pressione ENTER para retornar ao menu.");
        input.nextLine();
        return (i+1);
    }
    
    public static int alterar(int i, int k, int z){
        Scanner input = new Scanner (System.in);
        if(i==0){
            System.out.printf("Não há números cadastrados no sistema. Pressione ENTER para retornar ao menu");
            input.nextLine();
            return i;
        }
        String telefone;
        System.out.println("Digite o número do telefone no qual deseja fazer alterações: ");
        telefone=input.nextLine();
        int j, aux=0;
        for(j=0;j<i;j++){
            if(listaTelefones[j].telefone.equals(telefone)){
                int op, y=j;
                do{
                    System.out.printf("\nEscolha o que deseja alterar:\n1 - Alterar Cliente\n2 - Alterar Plano\n3 - Alterar Dia do Pagamento\n4 - Alterar data de Cancelamento\n0 - Voltar\n> ");
                    op=input.nextInt();
                    switch(op){
                        case 1: {
                            String cpf;
                            input.nextLine();
                            System.out.printf("\nCliente atual:\nCPF: %s\nNome: %s\nEndereço: %s\n\nDigite o CPF do novo Cliente: ",listaClientes[listaTelefones[y].cliente].cpf,listaClientes[listaTelefones[y].cliente].nome,listaClientes[listaTelefones[y].cliente].endereço);
                            cpf=input.nextLine();
                            for(j=0;j<k;){
                                if(listaClientes[j].cpf.equals(cpf)){
                                    listaTelefones[y].cliente=j;
                                    break;
                                }
                                if(j==(i-1)){
                                    System.out.println("CPF não encontrado no sistema, digite o CPF novamente: ");
                                    cpf=input.nextLine();
                                    j=0;
                                }
                                else{
                                    j++;
                                }
                            }
                            System.out.printf("Cliente alterado com sucesso!\n\nCliente atual:\nCPF: %s\nNome: %s\nEndereço: %s\n\nPressione ENTER para retornar ao menu: ",listaClientes[listaTelefones[y].cliente].cpf,listaClientes[listaTelefones[y].cliente].nome,listaClientes[listaTelefones[y].cliente].endereço);
                            input.nextLine();                            
                        } break;
                        case 2: {
                            int codigo;
                            System.out.printf("Plano atual:\nCodigo: %d\nDescrição: %s\nFranquia: %d\nValor Mensal: R$%.2f\nValor por Chamada: R$%.2f\n\nDigite o código do novo Plano: ",listaPlanos[listaTelefones[y].plano].codigo,listaPlanos[listaTelefones[y].plano].descrição,listaPlanos[listaTelefones[y].plano].franquia,listaPlanos[listaTelefones[y].plano].valorMensal,listaPlanos[listaTelefones[y].plano].valorChamada);
                            codigo=input.nextInt();
                            for(j=0;j<z;){
                                if(listaPlanos[j].codigo==codigo){
                                    listaTelefones[y].plano=j;
                                    break;
                                }
                                if(j==(i-1)){
                                    System.out.println("Código não encontrado no sistema, digite o código novamente: ");
                                    codigo=input.nextInt();
                                    j=0;
                                }
                                else{
                                    j++;
                                }
                            }
                            System.out.printf("Plano alterado com sucesso!\n\nNovo Plano:\nCodigo: %d\nDescrição: %s\nFranquia: %d\nValor Mensal: %.2f\nValor por Chamada: %.2f\n\nPressione ENTER para retornar ao menu.",listaPlanos[listaTelefones[y].plano].codigo,listaPlanos[listaTelefones[y].plano].descrição,listaPlanos[listaTelefones[y].plano].franquia,listaPlanos[listaTelefones[y].plano].valorMensal,listaPlanos[listaTelefones[y].plano].valorChamada);
                            input.nextLine();
                            input.nextLine();
                        } break;
                        case 3:{
                            int dia;
                            System.out.printf("Dia de pagamento atual: %d\nEscolha um novo dia para efetuar o pagamento(Dia 1, Dia 5, Dia 10 ou Dia 15): ",listaTelefones[y].pagamento);
                            dia=input.nextInt();
                            while(dia!=1 && dia!=5 && dia!=10 && dia!=15){
                                System.out.printf("Opção inválida! O pagamento só pode ser efetuado nos dias 1, 5, 10 e 15. Escolha um destes: ");
                                dia=input.nextInt();
                            }
                            listaTelefones[y].pagamento=dia;
                            System.out.printf("Dia do pagamento alterado com sucesso! Novo dia de pagamento: %d\n\nPressione ENTER para retornar ao menu.",listaTelefones[y].pagamento);
                            input.nextLine();
                            input.nextLine();
                        } break;
                        case 4: {
                            if(listaTelefones[y].cancelamento==null){
                                System.out.println("Número não possui data de cancelamento definida. Adicione-a em \"Menu Telefones>Cancelar\"\nPressione ENTER para voltar ao menu.");
                                input.nextLine();
                                input.nextLine();
                                break;
                            }
                            System.out.printf("Data de Cancelamento atual: %s\nDigite uma nova data de cancelamento: ",listaTelefones[y].cancelamento);
                            int ano,mes,dia;
                            System.out.printf("\nAno: ");
                            ano=input.nextInt();
                            System.out.printf("Mes: ");
                            mes=input.nextInt();
                            System.out.printf("Dia: ");
                            dia=input.nextInt();
                            Date novaData = new Date(ano-1900,mes-1,dia);
                            while(novaData.before(listaTelefones[y].ativacao)&&novaData.before(new Date())){
                                System.out.println("Data inválida, tente novamente:");
                                System.out.printf("Ano: ");
                                ano=input.nextInt();
                                System.out.printf("Mes: ");
                                mes=input.nextInt();
                                System.out.printf("Dia: ");
                                dia=input.nextInt();
                                novaData = new Date(ano-1900,mes-1,dia);
                            }
                            listaTelefones[y].cancelamento=novaData;
                            System.out.println("Data de cancelamento alterada com sucesso!\nNova data de Cancelamento: "+listaTelefones[y].cancelamento+".\n\nPressione ENTER para retornar ao menu.");
                            input.nextLine();                            
                        } break;
                        case 0: break;
                        default: System.out.println("Opção inválida, tente novamente."); break;
                    }
                }while(op!=0);
                aux=1;
            }
        }
        return i;
    }
    
    public static int cancelar(int i){
        Scanner input = new Scanner (System.in);
        if(i==0){
            System.out.println("Não há telefones cadastrados no sistema. Pressione ENTER para retornar ao menu.");
            input.nextLine();
            return i;
        }
        System.out.println("Digite o telefone que deseja cancelar: ");
        String telefone;
        telefone=input.nextLine();
        int j;
        for(j=0;j<i;){
            if(listaTelefones[j].telefone.equals(telefone)){
                if(listaTelefones[j].cancelamento!=null){
                    System.out.printf("Esta linha já possui data de cancelamento definida. Altere-a em \"Menu Telefones>Alterar>Alterar Data de Cancelamento\".\nPressione ENTER para retornar ao menu.");
                    input.nextLine();
                    return i;
                }
                System.out.println("Digite uma data para realizar o cancelamento da linha: ");
                Date data;
                System.out.printf("Digite um ano: ");
                int ano,mes,dia;
                ano=input.nextInt();
                System.out.printf("Digite um mes: ");
                mes=input.nextInt();
                System.out.printf("Digite um dia: ");
                dia=input.nextInt();
                data=new Date(ano-1900,mes-1,dia);
                while(data.before(listaTelefones[j].ativacao)){
                    System.out.printf("Data inválida, tente novamente.\nAno: ");
                    ano=input.nextInt();
                    System.out.printf("Mes: ");
                    mes=input.nextInt();
                    System.out.printf("Dia: ");
                    dia=input.nextInt();
                    data=new Date(ano-1900,mes-1,dia);
                }
                listaTelefones[j].cancelamento=data;
                System.out.printf("Data de cancelamento adicionada com sucesso! Pressione ENTER para retornar ao menu. ");
                input.nextLine();
                input.nextLine();
                return i;
            }
        }
        System.out.println("Telefone não encontrado no sistema. Pressione ENTER para retornar ao menu. ");
        input.nextLine();
        input.nextLine();
        return i;
    }
    
    public static int excluir(int i){
        Scanner input = new Scanner (System.in);
        if(i==0){
            System.out.printf("Não há telefones cadastados no sistema. Pressione ENTER para retornar ao menu.");
            input.nextLine();
            return i;
        }
        String telefone;
        System.out.println("Digite o número de telefone que deseja excluir do sistema: ");
        telefone=input.nextLine();
        int j;
        for(j=0;j<i;j++){
            if(listaTelefones[j].telefone.equals(telefone)){
                int confirmar;
                do{
                System.out.printf("Tem certeza que deseja excluir o número: %s do sistema?\n1 - Sim\n2 - Não\n",listaTelefones[j].telefone);
                confirmar=input.nextInt();
                switch(confirmar){
                    case 1:{
                        while(j<i){
                        listaTelefones[j]=listaTelefones[j+1];
                        j++;
                        }
                        System.out.println("Telefone excluído com sucesso! Pressione ENTER para retornar ao menu.");
                        input.nextLine();
                        return i-1;
                    }
                    case 2: return i;
                    default : System.out.println("Opção inválida, tente novamente."); break;
                    }
                } while(confirmar!=0);
            }
        }
        return i;
    }
    
    public static int exibir(int i, int k, int z){
        Scanner input = new Scanner(System.in);
        if(i==0){
            System.out.printf("Não há números de telefone cadastrados no sistema. Pressione ENTER para retornar ao menu.");
            input.nextLine();
            return i;
        }
        int j;
        for(j=0;j<i;j++){
            System.out.printf("[Cliente]\nCPF: %s\nNome: %s\nEndereço: %s\nNúmero: %s\n\n[Plano]\nCódigo: %d\nDescrição: %s\nFranquia: %d minutos\nValor Mensal: R$%.2f\nValor por Chamada: %.2f\nDia do Pagamento: %d\n",listaClientes[listaTelefones[j].cliente].cpf,listaClientes[listaTelefones[j].cliente].nome,listaClientes[listaTelefones[j].cliente].endereço,listaTelefones[j].telefone,listaPlanos[listaTelefones[j].plano].codigo,listaPlanos[listaTelefones[j].plano].descrição,listaPlanos[listaTelefones[j].plano].franquia,listaPlanos[listaTelefones[j].plano].valorMensal,listaPlanos[listaTelefones[j].plano].valorChamada,listaTelefones[j].pagamento);
            System.out.println("Data de ativação: "+listaTelefones[j].ativacao+"");
            if(listaTelefones[j].cancelamento!=null){
                System.out.println("Data de cancelamento: "+listaTelefones[j].cancelamento+"\n\n------------------------------------------\n");
            }
            else{
                System.out.println("Não há data de Cancelamento para esta linha\n\n------------------------------------------\n");
            }
        }
        System.out.printf("Lembre-se que um Cliente pode possuir múltiplos números.\nTotal de Números exibidos: %d. Pressione ENTER para voltar ao menu.",i);
        input.nextLine();
        return i;
    }
    
    public static int pesquisar (int i, int k, int z){
        Scanner input = new Scanner (System.in);
        if(i==0){
            System.out.printf("Não há números cadastrados no sistema. Pressione ENTER para retornar ao menu.");
            input.nextLine();
            return i;
        }
        int op,j;
        do{
            System.out.println("\n--------------- Selecione um modo de Pesquisa ---------------");
            System.out.println("1 - Pesquisar por CPF: exibe um ou mais números cadastrados para um mesmo Cliente;");
            System.out.println("2 - Pesquisar por Número: exibe apenas o Cliente cadastrado no número desejado.");
            System.out.printf("0 - Voltar\n> ");
            op=input.nextInt();
            switch(op){
                case 1: {
                    int contador=0;
                    String cpf;
                    input.nextLine();
                    System.out.println("Digite o CPF do Cliente desejado: ");
                    cpf=input.nextLine();
                    for(j=0;j<i;){
                        if(listaClientes[listaTelefones[j].cliente].cpf.equals(cpf)){
                            System.out.printf("[Cliente]\nCPF: %s\nNome: %s\nEndereço: %s\nNúmero: %s\n\n[Plano]\nCódigo: %d\nDescrição: %s\nFranquia: %d minutos\nValor Mensal: R$%.2f\nValor por Chamada: %.2f\nDia do Pagamento: %d\n\n--------------------------------\n\n",listaClientes[listaTelefones[j].cliente].cpf,listaClientes[listaTelefones[j].cliente].nome,listaClientes[listaTelefones[j].cliente].endereço,listaTelefones[j].telefone,listaPlanos[listaTelefones[j].plano].codigo,listaPlanos[listaTelefones[j].plano].descrição,listaPlanos[listaTelefones[j].plano].franquia,listaPlanos[listaTelefones[j].plano].valorMensal,listaPlanos[listaTelefones[j].plano].valorChamada,listaTelefones[j].pagamento);
                            contador=contador+1;
                            j++;
                        }
                        else{
                            if(j==i-1){
                                System.out.println("CPF não encontrado no sistema. Tente novamente: ");
                                cpf=input.nextLine();
                                j=0;
                            }
                            else
                                j++;
                        }
                    }
                    System.out.printf("Há %d Números de Telefone cadastrados no CPF: %s. Pressione ENTER para retornar ao menu de pesquisas.",contador,cpf);
                    input.nextLine();
                }; break;
                case 2:{
                    String telefone;
                    System.out.println("Digite o Número de Telefone desejado:");
                    input.nextLine();
                    telefone=input.nextLine();
                    for(j=0;j<i;){
                        if(listaTelefones[j].telefone.equals(telefone)){
                            System.out.printf("\n[Cliente]\nCPF: %s\nNome: %s\nEndereço: %s\nNúmero: %s\n\n[Plano]\nCódigo: %d\nDescrição: %s\nFranquia: %d\nValor Mensal: R$%.2f\nValor por Chamada: R$%.2f\nData de Ativação: %s\n",listaClientes[listaTelefones[j].cliente].cpf,listaClientes[listaTelefones[j].cliente].nome,listaClientes[listaTelefones[j].cliente].endereço,listaTelefones[j].telefone,listaPlanos[listaTelefones[j].plano].codigo,listaPlanos[listaTelefones[j].plano].descrição,listaPlanos[listaTelefones[j].plano].franquia,listaPlanos[listaTelefones[j].plano].valorMensal,listaPlanos[listaTelefones[j].plano].valorChamada,listaTelefones[j].ativacao);
                            if(listaTelefones[j].cancelamento==null){
                                System.out.println("Não há Data de Cancelamento para esta Linha.");
                            }
                            else{
                                System.out.printf("Data de Cancelamento: %s\n--------------------------------------\n\n",listaTelefones[j].cancelamento);
                            }
                            break;
                        }
                        if(j==(i-1)){
                            System.out.println("Número não encontrado no sistema, tente novamente: ");
                            telefone=input.nextLine();
                            j=0;
                        }
                        else{
                            j++;
                        }
                    }
                    System.out.printf("Pressione ENTER para voltar ao menu.");
                    input.nextLine();
                } break;
                case 0: break;
                default: System.out.println("Opção Inválida, tente novamente."); break;
            }
        }while(op!=0);
        return i;
    }

    public static int menuTelefone(int i, int k, int z) {
        Scanner input = new Scanner(System.in);
        int op;
        do {
            System.out.printf("\n\n--------- Menu de Telefones ---------\n1 - Cadastrar\n2 - Alterar\n3 - Excluir\n4 - Cancelar\n5 - Listar\n6 - Pesquisar\n0 - Voltar\n> ");
            op = input.nextInt();
            switch (op) {
                case 1: i = cadastrar(i, k, z); break;
                case 2: alterar(i,k,z); break;
                case 3: i = excluir(i); break;
                case 4: cancelar(i); break;
                case 5: exibir(i,k,z); break;
                case 6: pesquisar(i,k,z); break;
                case 7: break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        } while (op != 0);
        return i;
    }
} 

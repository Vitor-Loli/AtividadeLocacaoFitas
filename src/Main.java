
public class Main {
    public static void main(String[] args) {
        int opc = 0;
        Teclado teclado = new Teclado();
        GerenciadorLocadora locacao = new GerenciadorLocadora();

        do{
            System.out.println("MENU");
            System.out.println("[1] - Cadastrar Mídias");
            System.out.println("[2] - Cadastrar Clientes");
            System.out.println("[3] - Listar Mídias");
            System.out.println("[4] - Listar Clientes");
            System.out.println("[5] - Alocar");
            System.out.println("[6] - Devolução");
            System.out.println("[7] - Histórico de Alocação");
            System.out.println("[8] - Total Arrecadado");
            System.out.println("[9] - Sair");
            opc = teclado.readInt("Informe a opção desejada: ");

            switch(opc){
                case 1:
                    String tituloObra = teclado.readString("Informe a titulo da obra: ");
                    double preco = teclado.readDouble("Informe o preço base para alocação da obra: ");
                    int tipo = teclado.readInt("Informe o tipo da mídia: \n[1] - VHS\n[2] - DVD\n[3] - Streaming\n");

                    switch(tipo){
                        case 1:
                            locacao.cadMidias(new Vhs(tituloObra, preco, false));
                            break;
                        case 2:
                            int extras = teclado.readInt("A mídia possúi um ou mais extras?: \n[1] - Sim\n[2] - Não\n");
                            switch(extras){
                                case 1:
                                    locacao.cadMidias(new Dvd(tituloObra, preco, false, true));
                                    break;
                                case 2:
                                    locacao.cadMidias(new Dvd(tituloObra, preco, false, false));
                                    break;
                                default:
                                    System.out.println("Opção inválida!\n");
                            }
                            break;
                        case 3:
                            String plataforma = teclado.readString("Informe a plataforma: ");
                            locacao.cadMidias(new Streaming(tituloObra, preco, false, plataforma));
                            break;
                        default:
                            System.out.println("Opção Inválida!\n");
                    }
                    break;
                case 2:
                    String nome = teclado.readString("Informe o nome do cliente: ");
                    String cpf = teclado.readString("Informe o cpf do cliente: ");
                    String email = teclado.readString("Informe o email do cliente: ");

                    locacao.cadClientes(new Cliente(nome, cpf, email));

                    break;
                case 3:
                    if (locacao.listarMidias()){
                        System.out.println("Não há mídias cadastradas!\n");
                    }
                    break;
                case 4:
                    if (locacao.listarClientes()){
                        System.out.println("Não há clientes cadastrados!\n");
                    }
                    break;
                case 5:
                    if(locacao.listarMidiasDisponiveis()){
                        System.out.println("Não há mídias disponíveis!\n");
                    }else{
                        int midia =  teclado.readInt("Informe a mídia a ser alocada: ");
                        if(locacao.listarClientes()){
                            System.out.println("Não há clientes cadastradas!\n");
                        }else{
                            int cliente = teclado.readInt("Informe o cliente: ");
                            int dias = teclado.readInt("Informe quantos dias a mídia será alocada: ");
                            locacao.alocar(locacao.clientes.get(cliente) ,locacao.midias.get(midia), dias);
                        }
                    }
                    break;
                case 6:
                    if(locacao.listarLocacoesAtivas()){
                        System.out.println("Não há locações Cadastradas!");
                    }else{
                        int l = teclado.readInt("Informe a locação a ser devolvida: ");
                        locacao.devolucao(locacao.locacoes.get(l));
                    }
                    break;
                case 7:
                    if(locacao.listarLocacoes()){
                        System.out.println("Não há locações cadastradas!");
                    }
                    break;
                case 8:
                    if (locacao.valorTotal()){
                        System.out.println("Não há locações cadastradas!");
                    }
                    break;
                case 9:
                    System.out.println("Até logo!");
                default:
                    System.out.println("Opção inválida!");
            }

        }while(opc!=9);
    }
}
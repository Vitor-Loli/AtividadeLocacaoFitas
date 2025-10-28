import java.util.List;
import java.util.ArrayList;

public class GerenciadorLocadora {

    List<Midia> midias = new ArrayList<>();
    List<Cliente> clientes = new ArrayList<>();
    List<Locacao> locacoes = new ArrayList<>();

    public void cadMidias(Midia midia){
        midias.add(midia);
    };
    public void cadClientes(Cliente cliente){
        clientes.add(cliente);
    }

    public void cadLocacoes(Locacao locacao){
        locacoes.add(locacao);
    }

    public boolean listarMidias(){
        if(midias.isEmpty()){
            return true;
        }else{
            for(int i = 0; i < midias.size(); i++){
                    System.out.println("["+i+"] - " + midias.get(i).exibirInfo());
            }
            return false;
        }
    }
    public boolean listarClientes(){
        if(clientes.isEmpty()){
            return true;
        }else{
            for(int i = 0; i < clientes.size(); i++){
                System.out.println("["+i+"] - Nome: " + clientes.get(i).getNome() + ", Email: " + clientes.get(i).getEmail() + ", CPF: " + clientes.get(i).getCpf());
            }
            return false;
        }
    }

    public boolean listarMidiasDisponiveis(){
        if(midias.isEmpty()){
            return true;
        }else{
            boolean flag = true;
            for(int i = 0; i < midias.size(); i++){
                if(!midias.get(i).getAlocado()){
                    System.out.println("["+i+"] - " + midias.get(i).exibirInfo());
                    flag = false;
                }
            }
            return flag;
        }
    }

    public void alocar(Cliente cliente, Midia midia, int dias){
        Locacao locacao = new Locacao(cliente, midia, dias);
        locacoes.add(locacao);
    }

    public boolean devolucao(Locacao locacao){
        if(locacoes.isEmpty()){
            return true;
        }else{
            for(int i = 0; i < locacoes.size(); i++){
                if(locacoes.get(i).equals(locacao)){
                    if(locacoes.get(i).getMidia().getTipo() == "VHS"){
                        int opc = Teclado.readInt("Cliente rebobinou a fita ao devolver: \n[1] - Sim\n[2] - Não\n");
                        Vhs vhs = (Vhs) locacoes.get(i).getMidia();

                        if (opc == 1) {
                            vhs.setRebobinada(true);
                        } else {
                            vhs.setRebobinada(false);
                        }
                        locacoes.get(i).setValorTotal(locacoes.get(i).getMidia().calcularPreco(locacoes.get(i).getDias()));
                    }
                    locacoes.get(i).finalizarLocacao();
                    System.out.println("Preço final: R$" + locacoes.get(i).getValorTotal());
                }
            }
            return false;
        }

    }

    public boolean listarLocacoes(){
        if(locacoes.isEmpty()){
            return true;
        }else{
            for(int i = 0; i < locacoes.size(); i ++){
                System.out.println("["+i+"] - Cliente: " + locacoes.get(i).getCliente().getNome() + ", Obra alocada: " + locacoes.get(i).getMidia().getTituloObra() + ", Dias alocado:" + locacoes.get(i).getDias() + ", Valor total: " + locacoes.get(i).getValorTotal() + ", Ativo: " + (locacoes.get(i).getAtiva()? "Sim": "Não"));
            }
            return false;
        }
    }

    public boolean listarLocacoesAtivas(){
        if(locacoes.isEmpty()){
            return true;
        }else{
            boolean flag = true;
            for(int i = 0; i < locacoes.size(); i ++){
                if(locacoes.get(i).getAtiva()){
                    System.out.println("["+i+"] - Cliente: " + locacoes.get(i).getCliente().getNome() + ", Obra alocada: " + locacoes.get(i).getMidia().getTituloObra() + ", Dias alocado:" + locacoes.get(i).getDias() + ", Ativo: " + (locacoes.get(i).getAtiva()? "Sim": "Não"));
                    flag = false;
                }
            }
            return flag;
        }
    }
    public boolean valorTotal(){
        if(locacoes.isEmpty()){
            return true;
        }else{
            double total = 0;
            for(int i = 0; i < locacoes.size(); i ++){
                total = total + locacoes.get(i).getValorTotal();
            }
            System.out.println("Valor total: " + total);
            return false;
        }
    }



}

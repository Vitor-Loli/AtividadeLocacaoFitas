public class Vhs extends Midia{
    private boolean rebobinada = true;

    public Vhs(String tituloObra, double preco, boolean alocado){
        super(tituloObra, preco, "VHS", alocado);
    }

    public void setRebobinada(boolean rebobinada){
        this.rebobinada = rebobinada;
    }
    public boolean getRebobinada(){
        return this.rebobinada;
    }

    @Override
    public double calcularPreco(int dias) {

        if(rebobinada){
            return this.getPreco()*dias;
        }else {
            return (this.getPreco()*1.15) * dias;
        }

    }

    public String exibirInfo(){
        return "Título: " + getTituloObra() + ", Preço base: R$" + getPreco() + ", Tipo: " + getTipo() + ", Disponível: " + (getAlocado()? "Não": "Sim") + ", Rebobinada: " + (getRebobinada()? "Sim": "Não");
    }
}

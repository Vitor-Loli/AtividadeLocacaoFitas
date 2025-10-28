public class Dvd extends Midia {
    private boolean contemExtras = false;

    public Dvd(String tituloObra, double preco, boolean alocado, boolean contemExtras) {
        super(tituloObra, preco, "DVD", alocado);
        this.setContemExtras(contemExtras);
    }

    public void setContemExtras(boolean contemExtras) {
        this.contemExtras = contemExtras;
    }
    public boolean getContemExtras() {
        return contemExtras;
    }

    @Override
    public double calcularPreco(int dias) {
        if (contemExtras) {
            return (this.getPreco() * 1.25) * dias;
        }else{
            return this.getPreco() * dias;
        }
    }

    public String exibirInfo(){
        return "Título: " + getTituloObra() + ", Preço base: R$" + getPreco() + ", Tipo: " + getTipo() + ", Disponível: " + (getAlocado()? "Não": "Sim") + ", Contém extras: " + (getContemExtras()? "Sim": "Não");
    }
}

public class Streaming extends Midia{
    private String plataforma;

    public Streaming(String tituloObra, double preco, boolean alocado, String plataforma){
        super(tituloObra, preco, "Streaming", alocado);
        this.setPlataforma(plataforma);
    }

    public void setPlataforma(String plataforma){
        this.plataforma = plataforma;
    }
    public String getPlataforma(){
        return this.plataforma;
    }

    @Override
    public double calcularPreco(int dias) {
        return (this.getPreco() * 0.90) * dias;
    }

    public String exibirInfo(){
        return "Título: " + getTituloObra() + ", Preço base: R$" + getPreco() + ", Tipo: " + getTipo() + ", Disponível: " + (getAlocado()? "Não": "Sim") + ", Plataforma: " + getPlataforma();
    }
}

public abstract class Midia {
    private String tituloObra;
    private double preco;
    private String tipo;
    private boolean alocado;

    public Midia(String tituloObra, double preco, String tipo, boolean alocado){
        this.setTituloObra(tituloObra);
        this.setPreco(preco);
        this.setTipo(tipo);
        this.setAlocado(alocado);
    }

    public void setTituloObra(String tituloObra) {
        this.tituloObra = tituloObra;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setAlocado(boolean alocado) {
        this.alocado = alocado;
    }
    public String getTituloObra() {
        return tituloObra;
    }
    public double getPreco() {
        return preco;
    }
    public String getTipo() {
        return tipo;
    }
    public boolean getAlocado() {
        return alocado;
    }

    public abstract double calcularPreco(int dias);
    public abstract String exibirInfo();
}

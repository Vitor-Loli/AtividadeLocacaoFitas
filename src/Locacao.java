public class Locacao {
    private Cliente cliente;
    private Midia midia;
    private int dias;
    private double valorTotal;
    private boolean ativa;

    public Locacao(Cliente cliente, Midia midia, int dias) {
        this.cliente = cliente;
        this.midia = midia;
        this.dias = dias;
        this.valorTotal = midia.calcularPreco(dias);
        this.ativa = true;
        midia.setAlocado(true);
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public void setDias(int dias) {
        this.dias = dias;
    }
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public Midia getMidia() {
        return midia;
    }
    public int getDias() {
        return dias;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public boolean getAtiva() {
        return ativa;
    }

    public void finalizarLocacao() {
        this.ativa = false;
        midia.setAlocado(false);
    }
}

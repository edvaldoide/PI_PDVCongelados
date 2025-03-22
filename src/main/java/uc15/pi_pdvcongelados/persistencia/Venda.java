package uc15.pi_pdvcongelados.persistencia;

public class Venda {

    private int id;
    private String descricaoProduto;
    private int quantPedido;
    private double precoVendaUnitario;
    private double precoVendaTotal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public int getQuantPedido() {
        return quantPedido;
    }

    public void setQuantPedido(int quantPedido) {
        this.quantPedido = quantPedido;
    }

    public double getPrecoVendaUnitario() {
        return precoVendaUnitario;
    }

    public void setPrecoVendaUnitario(double precoVendaUnitario) {
        this.precoVendaUnitario = precoVendaUnitario;
    }

    public double getPrecoVendaTotal() {
        return precoVendaTotal;
    }

    public void setPrecoVendaTotal(double precoVendaTotal) {
        this.precoVendaTotal = precoVendaTotal;
    }



}

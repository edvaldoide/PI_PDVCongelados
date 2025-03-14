package uc15.pi_pdvcongelados.persistencia;

public class Produto {

    private int id;
    private String descricao;
    private int quantidadeEstoque;
    private double precoCustoUnitario;
    private double precoVendaUnitario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getPrecoCustoUnitario() {
        return precoCustoUnitario;
    }

    public void setPrecoCustoUnitario(double precoCustoUnitario) {
        this.precoCustoUnitario = precoCustoUnitario;
    }

    public double getPrecoVendaUnitario() {
        return precoVendaUnitario;
    }

    public void setPrecoVendaUnitario(double precoVendaUnitario) {
        this.precoVendaUnitario = precoVendaUnitario;
    }

}

package uc15.pi_pdvcongelados.persistencia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String idVenda;
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

    public String getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(String idVenda) {
        this.idVenda = idVenda;
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

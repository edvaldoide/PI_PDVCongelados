package uc15.pi_pdvcongelados.persistencia;

import jakarta.persistence.EntityManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VendaDAO {

    /**
     * Método para conectar ao banco de dados
     */
    Connection conn;
    PreparedStatement st;
    ResultSet rs;

    public boolean conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdvcongelados", "root", "");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar: " + ex.getMessage());
            return false;
        }
    }

    public void cadastrar(Venda v) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(v);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }

    /**
     * Criação de lista para apresentação de resultados
     */
    public List<Venda> getVenda(String idvenda) { //parâmetro para buscar a empresa pelo nome

        conectar(); // conexao com o banco de dados

        String sql = "SELECT * FROM venda WHERE idvenda LIKE ?"; //LIKE nos permite pesquisar por partes de um nome, ao invés de pesquisarmos por todo nome

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, idvenda); //Conforme for a palavra ou letra digitada para pesquisa, será buscada antes, no meio e no fim
            ResultSet rs = stmt.executeQuery();

            List<Venda> listaVendas = new ArrayList<>();

            while (rs.next()) { //.next retorna verdadeiro caso exista uma próxima posição dentro do array
                Venda venda = new Venda();

                venda.setId(rs.getInt("id"));
                venda.setIdVenda(rs.getString("idvenda"));
                venda.setDescricaoProduto(rs.getString("descricaoproduto"));
                venda.setQuantPedido(rs.getInt("quantpedido"));
                venda.setPrecoVendaUnitario(rs.getDouble("precovendaunitario"));
                venda.setPrecoVendaTotal(rs.getDouble("precovendatotal"));

                listaVendas.add(venda);
            }
            return listaVendas;

            //Se o método entrar no "Catch" quer dizer que não encontrou nenhuma empresa, então damos um "return null"
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nenhuma venda encontrada");
            return null;
        }
    }
    
        public List<Venda> getVendaTotal() { //parâmetro para buscar a empresa pelo nome

        conectar(); // conexao com o banco de dados

        String sql = "SELECT * FROM venda"; //LIKE nos permite pesquisar por partes de um nome, ao invés de pesquisarmos por todo nome

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            List<Venda> listaTotal = new ArrayList<>();

            while (rs.next()) { //.next retorna verdadeiro caso exista uma próxima posição dentro do array
                Venda venda = new Venda();

                venda.setId(rs.getInt("id"));
                venda.setIdVenda(rs.getString("idvenda"));
                venda.setDescricaoProduto(rs.getString("descricaoproduto"));
                venda.setQuantPedido(rs.getInt("quantpedido"));
                venda.setPrecoVendaUnitario(rs.getDouble("precovendaunitario"));
                venda.setPrecoVendaTotal(rs.getDouble("precovendatotal"));

                listaTotal.add(venda);
            }
            return listaTotal;

            //Se o método entrar no "Catch" quer dizer que não encontrou nenhuma empresa, então damos um "return null"
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nenhuma venda encontrada");
            return null;
        }
    }

}

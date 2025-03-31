package uc15.pi_pdvcongelados.persistencia;

import jakarta.persistence.EntityManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ProdutoDAO {

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

    public void cadastrar(Produto p) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }

    public ResultSet listarProduto() {

        conectar();

        String sql = "SELECT * FROM produto ORDER BY id";

        try {

            st = conn.prepareStatement(sql);
            return st.executeQuery();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ListarProduto ProdutoDAO " + e.getMessage());
            return null;
        }
    }

    /**
     * Método para consulta de produtos cadastrados
     */
    public Produto getProduto(int id) {

        conectar();

        String sql = "SELECT * FROM produto WHERE id = ?";
        try {

            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            Produto produto = new Produto();

            rs.next();
            produto.setId(id);
            produto.setDescricao(rs.getString("descricao"));
            produto.setQuantidade(rs.getInt("quantidade"));
            produto.setEstoque(rs.getInt("estoque"));
            produto.setPrecoCustoUnitario(rs.getDouble("precocustounitario"));
            produto.setPrecoVendaUnitario(rs.getDouble("precovendaunitario"));

            return produto;

            //tratando o erro, caso ele ocorra
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * Método para editar o estoque cadastrado
     */
    public void editarEstoque(Produto produto) {

        conectar();
        //string sql com o código de update para o banco de dados
        String sql = "UPDATE produto SET estoque=? WHERE id=?";
        try {
            //esse trecho é igual ao método inserir
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            //Setando os parâmetros
            stmt.setInt(1, produto.getEstoque());
            stmt.setInt(2, produto.getId());
            //Executando a query
            stmt.execute();
            //tratando o erro, caso ele ocorra
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar Produto: " + e.getMessage());
        }

    }

}

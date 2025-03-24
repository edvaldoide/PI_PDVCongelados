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

        String sql = "SELECT * FROM produto ORDER BY descricao";

        try {

            st = conn.prepareStatement(sql);
            return st.executeQuery();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ListarProduto ProdutoDAO " + e.getMessage());
            return null;
        }
    }
}

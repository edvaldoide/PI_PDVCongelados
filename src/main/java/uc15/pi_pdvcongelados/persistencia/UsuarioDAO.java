package uc15.pi_pdvcongelados.persistencia;

import jakarta.persistence.EntityManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {

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

    public void cadastrar(Usuario u) {

        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }

    public static Usuario validarUsuarioSeguro(Usuario usuario) {
        // Criando consulta parametrizada
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
        Usuario usuarioEncontrado = null;

        try {
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdvcongelados", "root", "");
            PreparedStatement statement = conexao.prepareStatement(sql);

            // Atribuindo os valores na consulta
            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getSenha());
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                usuarioEncontrado = new Usuario();
                usuarioEncontrado.setId(rs.getInt("id"));
                usuarioEncontrado.setNome(rs.getString("nome"));
                usuarioEncontrado.setEmail(rs.getString("email"));
                usuarioEncontrado.setSenha(rs.getString("senha"));
                usuarioEncontrado.setTipoUsuario(rs.getString("tipousuario"));
            }
        } catch (SQLException ex) {
            System.out.println("Sintaxe de comando invalida");
        }

        return usuarioEncontrado;

    }

}

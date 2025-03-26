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

    public ArrayList<Venda> listarTodasVendas() {

        conn = new conectaDAO().connectDB();

        String sql = "SELECT * FROM venda";

        try {

            PreparedStatement stmt = this.conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            //Vamos criar um objeto do tipo List
            //Faça a importação do ArrayList
            ArrayList<Venda> listagemVendas = new ArrayList<>();
            //percorrer o resultSet e salvar as informações dentro de uma variável "Empresa"
            //Depois salva esse objeto dentro da lista

            //Estrutura de repetição While
            while (rs.next()) { //.next retorna verdadeiro caso exista uma próxima posição dentro do array
                Venda produtoVendido = new Venda();
                //Salvar dentro do objeto empresa as informações            
                produtoVendido.setId(rs.getInt("ID"));
                produtoVendido.setIdVenda(rs.getString("ID venda"));
                produtoVendido.setDescricaoProduto(rs.getString("Produto"));
                produtoVendido.setQuantPedido(rs.getInt("Quantidade"));
                produtoVendido.setPrecoVendaUnitario(rs.getDouble("Preço unitário (R$)"));
                produtoVendido.setPrecoVendaTotal(rs.getDouble("Total (R$)"));

                //Adicionando os elementos na lista criada
                listagemVendas.add(produtoVendido);

            }
            //Após finalizar o while, o retorno será a listaEmpresas, onde cada posição é um registro do banco de dados
            return listagemVendas;

            //Se o método entrar no "Catch" quer dizer que não encontrou nenhuma empresa, então damos um "return null"
        } catch (Exception e) {
            return null;
        }

    }

    public ArrayList<Venda> listarTodasAsVendas() {

        conn = new conectaDAO().connectDB();

        String sql = "SELECT * FROM produtos";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            //Vamos criar um objeto do tipo List
            //Faça a importação do ArrayList
            ArrayList<Venda> listagemVendidos = new ArrayList<>();
            //percorrer o resultSet e salvar as informações dentro de uma variável "Empresa"
            //Depois salva esse objeto dentro da lista

            //Estrutura de repetição While
            while (rs.next()) { //.next retorna verdadeiro caso exista uma próxima posição dentro do array
                Venda produtoVendido = new Venda();
                //Salvar dentro do objeto empresa as informações            
                produtoVendido.setId(rs.getInt("id"));
                produtoVendido.setIdVenda(rs.getString("idvenda"));
                produtoVendido.setDescricaoProduto(rs.getString("descricaoproduto"));
                produtoVendido.setQuantPedido(rs.getInt("quantpedido"));
                produtoVendido.setPrecoVendaUnitario(rs.getDouble("precovendaunitario"));
                produtoVendido.setPrecoVendaTotal(rs.getDouble("precovendatotal"));

                //Adicionando os elementos na lista criada
                listagemVendidos.add(produtoVendido);

            }
            //Após finalizar o while, o retorno será a listaEmpresas, onde cada posição é um registro do banco de dados
            return listagemVendidos;

            //Se o método entrar no "Catch" quer dizer que não encontrou nenhuma empresa, então damos um "return null"
        } catch (Exception e) {
            return null;
        }

    }

}

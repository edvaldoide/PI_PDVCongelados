/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uc15.pi_pdvcongelados.gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import uc15.pi_pdvcongelados.persistencia.Produto;
import uc15.pi_pdvcongelados.persistencia.ProdutoDAO;
import uc15.pi_pdvcongelados.persistencia.Venda;
import uc15.pi_pdvcongelados.persistencia.VendaDAO;

/**
 *
 * @author edval
 */
public class TelaVenda extends javax.swing.JFrame {

    /**
     * Creates new form TelaVendas
     */
    public TelaVenda() {
        initComponents();
        restaurarDadosComboboxProduto();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblDescricao = new javax.swing.JLabel();
        cmbDescricao = new javax.swing.JComboBox<>();
        lblPrecoCusto = new javax.swing.JLabel();
        lblPrecoCusto1 = new javax.swing.JLabel();
        txtIDVenda = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        txtQuantidade = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVenda = new javax.swing.JTable();
        btnFinalizarVenda = new javax.swing.JButton();
        lblPrecoCusto2 = new javax.swing.JLabel();
        lblPrecoCusto4 = new javax.swing.JLabel();
        txtValorTotalCompra = new javax.swing.JTextField();
        lblPrecoCusto3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Delicias_food.jpg"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("VENDA DE PRODUTOS");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do produto"));

        lblDescricao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDescricao.setText("Produto:");

        cmbDescricao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbDescricao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        lblPrecoCusto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPrecoCusto.setText("Quantidade:");

        lblPrecoCusto1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPrecoCusto1.setText("ID da venda");

        txtIDVenda.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnAdicionar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        txtQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPrecoCusto1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrecoCusto)
                            .addComponent(lblDescricao))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbDescricao, javax.swing.GroupLayout.Alignment.LEADING, 0, 420, Short.MAX_VALUE)
                            .addComponent(txtIDVenda, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecoCusto1)
                    .addComponent(txtIDVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao)
                    .addComponent(cmbDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecoCusto)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdicionar)
                .addGap(12, 12, 12))
        );

        tblVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID da venda", "Produto", "Quantidade", "Preço unitário (R$)", "Total (R$)"
            }
        ));
        jScrollPane1.setViewportView(tblVenda);

        btnFinalizarVenda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnFinalizarVenda.setText("Finalizar venda");
        btnFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarVendaActionPerformed(evt);
            }
        });

        lblPrecoCusto2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPrecoCusto2.setText("Quantidade:");

        lblPrecoCusto4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPrecoCusto4.setText("Total (R$)");

        txtValorTotalCompra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(btnFinalizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(lblPrecoCusto4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtValorTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(245, 245, 245)
                    .addComponent(lblPrecoCusto2)
                    .addContainerGap(245, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecoCusto4)
                            .addComponent(txtValorTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btnFinalizarVenda)
                        .addGap(20, 20, 20))))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(132, 132, 132)
                    .addComponent(lblPrecoCusto2)
                    .addContainerGap(133, Short.MAX_VALUE)))
        );

        lblPrecoCusto3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPrecoCusto3.setText("Quantidade:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblLogo)
                        .addGap(126, 126, 126)
                        .addComponent(lblTitulo))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(270, 270, 270)
                    .addComponent(lblPrecoCusto3)
                    .addContainerGap(270, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lblTitulo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(308, 308, 308)
                    .addComponent(lblPrecoCusto3)
                    .addContainerGap(309, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed

        Venda novaVenda = new Venda();
        try {

            String strIDVenda = txtIDVenda.getText();
            boolean idVenda = strIDVenda.isEmpty();

            String strProduto = cmbDescricao.getSelectedItem().toString();
            boolean produto = strProduto == "Selecione";

            String strQuantidade = txtQuantidade.getText();
            boolean quantidade = strQuantidade.isEmpty();

            if (idVenda == true || strIDVenda == "") {
                JOptionPane.showMessageDialog(null, "O campo ID da venda deve ser informado e válido");
            } else if (produto == true) {
                JOptionPane.showMessageDialog(null, "O campo Produto deve ser selecionado");
            } else if (quantidade == true || strQuantidade == "") {
                JOptionPane.showMessageDialog(null, "O campo Quantidade deve ser informado e válido");
            } else {
                //para o ID da venda capturamos direto o valor do campo de texto
                novaVenda.setIdVenda(txtIDVenda.getText());

                //para a quantidade do pedido capturamos o valor do campo de texto e convertemos para valor inteiro
                novaVenda.setQuantPedido(Integer.parseInt(strQuantidade));

                int indexProduto = cmbDescricao.getSelectedIndex();

                ProdutoDAO produtodao = new ProdutoDAO();
                Produto produtovenda = produtodao.getProduto(indexProduto);

                //para descrição do produto pegamos a informação do combobox
                novaVenda.setDescricaoProduto(produtovenda.getDescricao());

                //para o preço de custo unitário capturamos o valor do campo de texto e convertemos para valor double
                novaVenda.setPrecoVendaUnitario(produtovenda.getPrecoVendaUnitario());

                double valorTotal = Integer.parseInt(strQuantidade) * produtovenda.getPrecoVendaUnitario();
                //para o preço de venda unitário capturamos o valor do campo de texto e convertemos para valor double
                novaVenda.setPrecoVendaTotal(valorTotal);

                //gravando os dados no repositório
                VendaDAO vendadao = new VendaDAO();
                vendadao.cadastrar(novaVenda);

                //limpando os campos de dados
                cmbDescricao.setSelectedIndex(0);
                txtQuantidade.setText("");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu uma falha:\n" + e.getMessage());
        }

    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFinalizarVendaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnFinalizarVenda;
    private javax.swing.JComboBox<String> cmbDescricao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPrecoCusto;
    private javax.swing.JLabel lblPrecoCusto1;
    private javax.swing.JLabel lblPrecoCusto2;
    private javax.swing.JLabel lblPrecoCusto3;
    private javax.swing.JLabel lblPrecoCusto4;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblVenda;
    private javax.swing.JTextField txtIDVenda;
    private javax.swing.JFormattedTextField txtQuantidade;
    private javax.swing.JTextField txtValorTotalCompra;
    // End of variables declaration//GEN-END:variables

    public void restaurarDadosComboboxProduto() {
        try {
            ProdutoDAO objprodutodao = new ProdutoDAO();
            ResultSet rs = objprodutodao.listarProduto();

            while (rs.next()) {
                cmbDescricao.addItem(rs.getString(2));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Carregar Produto TelaAdicionarProdutos: " + erro);
        }
    }

}

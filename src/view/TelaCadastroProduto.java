/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import utils.Validador;
import DAO.ProdutoDAO;
import model.Produto;
import java.util.ArrayList;

/**
 *
 * @author igorr
 */
public class TelaCadastroProduto extends javax.swing.JFrame {
    
    Produto objProduto = new Produto();

    /**
     * Creates new form TelaCadastroProduto
     */
    public TelaCadastroProduto() {
        initComponents();
        objProduto = new Produto();
        
        setLocationRelativeTo(null);
    }
    
    
    public TelaCadastroProduto(Produto p) {
        initComponents();
        this.objProduto = p;
        
        this.txtNome.setText(p.getNome());
        this.txtQtd.setText(p.getQtd());
        this.txtPreco.setText(p.getPreco());
        this.txtNumero.getSelectedItem().toString();
        
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        txtNumero = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtQtd = new javax.swing.JFormattedTextField();
        btnPesquisar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtPreco = new javax.swing.JTextField();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Quantidade", "Preço"
            }
        ));
        tblProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutosMouseClicked(evt);
            }
        });
        tblProdutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblProdutosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblProdutos);

        jLabel1.setText("Nome do produto*");

        jLabel2.setText("Quantidade*");

        jLabel3.setText("Preço*");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        txtNumero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "20-21", "22-23", "24-25", "26-27", "28-29", "30-31", "32-33", "34-35", "36-37", "38-39", "40-41", "42-43" }));

        jLabel4.setText("Numero do Calçado");

        txtQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtNome)
                                        .addGap(72, 72, 72))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(101, 101, 101))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtPreco, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtQtd))
                                .addGap(266, 266, 266)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPesquisar)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(101, 101, 101))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 16, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCadastrar)
                                .addGap(18, 18, 18)
                                .addComponent(btnAtualizar)
                                .addGap(47, 47, 47)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))))
                .addComponent(btnPesquisar)
                .addContainerGap())
        );

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnSair)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(btnSair))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
      
     
            if(txtNome.getText().trim().equals("")){
          JOptionPane.showMessageDialog(this," Digite o nome do produto ");
          
            Validador.ValidarNumeros(txtQtd);
          Validador.ValidarNumeros(txtPreco);
          return;
          
            }else{
      
           String Nome = txtNome.getText();
           String Qtd = txtQtd.getText();
           String Preco = txtPreco.getText();
           String Numero = txtNumero.getSelectedItem().toString();
           
           objProduto.setNome(Nome);
           objProduto.setQtd(Qtd);
           objProduto.setPreco(Preco);
           objProduto.setNumero(Numero);
       
        
            }
       try {
              boolean retorno = ProdutoDAO.cadastrar(objProduto);
              JOptionPane.showMessageDialog(this,"Produto cadastrado com sucesso!","Produto Cadastrado",JOptionPane.INFORMATION_MESSAGE);
          } catch (Exception e) {
              
              JOptionPane.showMessageDialog(this,"Falha ao gravar no banco de dados\n"+ e.getMessage(), 
                                                "Aviso de Falha", JOptionPane.ERROR_MESSAGE);
          }
             
    
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
  
    /*if(tblProdutos.getSelectedRow() != -1){
    DefaultTableModel dtmProdutos = (DefaultTableModel) tblProdutos.getModel();
    dtmProdutos.removeRow(tblProdutos.getSelectedRow());
    }else{
        JOptionPane.showMessageDialog(null," Selecione Um Produto Para Excluir ");
    }*/
    
    if(tblProdutos.getRowCount()>0) {
        
        int numeroLinha = tblProdutos.getSelectedRow();
        
            int IDproduto = Integer.parseInt(tblProdutos.getModel().getValueAt(numeroLinha, 0).toString());
            String nome = tblProdutos.getModel().getValueAt(numeroLinha, 1).toString();
            String quantidade = tblProdutos.getModel().getValueAt(numeroLinha, 2).toString();
            String preco = tblProdutos.getModel().getValueAt(numeroLinha, 3).toString();
            
            objProduto.setId(IDproduto);
            objProduto.setNome(nome);
            objProduto.setQtd(quantidade);
            objProduto.setPreco(preco);
            
            if(ProdutoDAO.excluir(objProduto.getId())){
                JOptionPane.showMessageDialog(this, "Produto excluído com sucesso!");
            }else{
                JOptionPane.showMessageDialog(this, "Falha ao excluir o produto!");
            }
            
            CarregarJtable();
            
    } else {
         JOptionPane.showMessageDialog(this, "Selecione um produto da tabela!");
    }
    
    

    }//GEN-LAST:event_btnExcluirActionPerformed

    public void CarregarJtable() {
        ArrayList<Produto> listaClientes = ProdutoDAO.consultarProduto();
        
        DefaultTableModel tmProdutos = new DefaultTableModel();
        tmProdutos.addColumn("Id_produto");
        tmProdutos.addColumn("Nome");
        tmProdutos.addColumn("Quantidade");
        tmProdutos.addColumn("Preco");
        
        tblProdutos.setModel(tmProdutos);
        
        tmProdutos.setRowCount(0);
        
        for (Produto c : listaClientes) {
            tmProdutos.addRow(new Object[]{c.getId(),c.getNome(),c.getQtd(), c.getPreco()});
        }
        
        tblProdutos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblProdutos.getColumnModel().getColumn(1).setPreferredWidth(300);
        tblProdutos.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblProdutos.getColumnModel().getColumn(2).setPreferredWidth(100);
    }
    
    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        if(tblProdutos.getSelectedRow() != -1){
            tblProdutos.setValueAt(txtNome.getText(), tblProdutos.getSelectedRow(),0);
            tblProdutos.setValueAt(txtQtd.getText(), tblProdutos.getSelectedRow(),1);
            tblProdutos.setValueAt(txtPreco.getText(), tblProdutos.getSelectedRow(),2);
        }
        
        String Nome = txtNome.getText();
           String Qtd = txtQtd.getText();
           String Preco = txtPreco.getText();
           String Numero = txtNumero.getSelectedItem().toString();
           
           objProduto.setNome(Nome);
           objProduto.setQtd(Qtd);
           objProduto.setPreco(Preco);
           objProduto.setNumero(Numero);
           
           try {
              boolean retorno = ProdutoDAO.atualizar(objProduto);
              JOptionPane.showMessageDialog(this,"Produto atualizado com sucesso!","Produto Atualizado",JOptionPane.INFORMATION_MESSAGE);
          } catch (Exception e) {
              JOptionPane.showMessageDialog(this,"Falha ao gravar no banco de dados\n"+ e.getMessage(), 
                                                "Aviso de Falha", JOptionPane.ERROR_MESSAGE);
          }
           
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void tblProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutosMouseClicked
        if(tblProdutos.getSelectedRow()!=-1){
            txtNome.setText(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0).toString());
            txtQtd.setText(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 1).toString());
            txtPreco.setText(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 2).toString());
        }
            

    }//GEN-LAST:event_tblProdutosMouseClicked

    private void tblProdutosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProdutosKeyReleased
       if(tblProdutos.getSelectedRow()!=-1){
            txtNome.setText(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0).toString());
            txtQtd.setText(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 1).toString());
            txtPreco.setText(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 2).toString());  
        
       }
    }//GEN-LAST:event_tblProdutosKeyReleased

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
       
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
        ArrayList<Produto> listaProduto = ProdutoDAO.consultarProduto(txtNome.getText());
        
        DefaultTableModel tmProdutos = new DefaultTableModel();
        tmProdutos.addColumn("Id");
        tmProdutos.addColumn("Nome");
        tmProdutos.addColumn("Quantidade");
        tmProdutos.addColumn("Preço");
        tblProdutos.setModel(tmProdutos);
        
        tblProdutos.removeColumn(tblProdutos.getColumnModel().getColumn(0));
        
        tmProdutos.setRowCount(0);
        
        for (Produto c : listaProduto) {
            tmProdutos.addRow(new Object[]{c.getId(),c.getNome(),c.getQtd(), c.getPreco()});
        }
        tblProdutos.getColumnModel().getColumn(0).setPreferredWidth(300);
        tblProdutos.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblProdutos.getColumnModel().getColumn(2).setPreferredWidth(100);
    }//GEN-LAST:event_btnPesquisarActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtNome;
    private javax.swing.JComboBox<String> txtNumero;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JFormattedTextField txtQtd;
    // End of variables declaration//GEN-END:variables
}
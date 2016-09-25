package view;

import dao.Pessoa;
import dao.Locacao;
import dao.Veiculo;
import dao.ModeloTabela;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;

public class JFLocacao extends javax.swing.JFrame {

    /**
     * Creates new form JFLocacao
     */
    public JFLocacao() throws SQLException {
        initComponents();

        // incluir uma máscara de data
        try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.install(txtDataLocacao);

            MaskFormatter dateMask2 = new MaskFormatter("##/##/####");
            dateMask2.install(txtDataDevolucao);
        } catch (Exception e) {
        }

        this.populeCbbCliente();

        this.populeCbbVeiculo();

        this.preenchaTabela();

    }

    public void preenchaTabela() {
        String[] colunas = new String[]{"Cód.", "Veiculo", "Marca",
            "Dt. Loc.", "Dt. Dev."};

        ArrayList dados = new ArrayList();

        Locacao locacao = new Locacao();
        ResultSet rs = locacao.listeLocacoes();

        try {
            rs.first();
            do {
                dados.add(new Object[]{
                    rs.getInt("locacao_id"),
                    rs.getString("nome"),
                    rs.getString("modelo"),
                    rs.getString("data_locacao"),
                    rs.getString("data_devolucao"),
                    rs.getDouble("valor_locacao")
                });
            } while (rs.next());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao preencher "
                    + "a tabela");
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tblLocacao.setModel(modelo);
    }
    // criar uma lista de objetos de Cliente
    ArrayList<Pessoa> listaCliente = new ArrayList<Pessoa>();

    public void populeCbbCliente() throws SQLException {
        // cria uma instancia da classe Cliente
        Pessoa Cliente = new Pessoa();
        ResultSet rs = Cliente.listeCliente();

        // enquanto existir um próximo registro
        while (rs.next()) {

            // cria um novo objeto da classe Cliente
            Cliente = new Pessoa();
            // determina os atributos nome e Cliente_id do objeto
            Cliente.setNome(rs.getString("nome"));
            Cliente.setClienteId(rs.getInt("Cliente_id"));

            // adiciona à lista de objetos de Clientes o objeto atual
            listaCliente.add(Cliente);

            // determina o valor do cbbCliente
            cbbCliente.addItem(Cliente.getNome());
        }
    }

    // cria uma lista de objetos de veiculo
    ArrayList<Veiculo> listaVeiculo = new ArrayList<Veiculo>();

    public void populeCbbVeiculo() throws SQLException {
        // cria uma instancia da classe veiculo
        Veiculo veiculo = new Veiculo();
        ResultSet rs = veiculo.listeVeiculos();

        // enquanto existir um próximo registro
        while (rs.next()) {

            // cria um novo objeto da classe veiculo
            veiculo = new Veiculo();
            // determina os atributos titulo e veiculo_id do objeto
            veiculo.setMarca(rs.getString("marca"));
            veiculo.setVeiculoId(rs.getInt("veiculo_id"));

            // adiciona à lista de objetos de veiculos o objeto atual
            listaVeiculo.add(veiculo);

            // determina o valor do cbbveiculo
            cbbVeiculo.addItem(veiculo.getMarca());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbbCliente = new javax.swing.JComboBox<>();
        cbbVeiculo = new javax.swing.JComboBox<>();
        txtDataLocacao = new javax.swing.JFormattedTextField();
        txtDataDevolucao = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLocacao = new javax.swing.JTable();
        labelSair = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JLabel();
        btnNovo = new javax.swing.JLabel();
        btnGravar = new javax.swing.JLabel();
        txtNovo = new javax.swing.JLabel();
        txtVeiculo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1024, 768));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1024, 768));
        setResizable(false);
        getContentPane().setLayout(null);

        getContentPane().add(cbbCliente);
        cbbCliente.setBounds(130, 80, 750, 40);

        getContentPane().add(cbbVeiculo);
        cbbVeiculo.setBounds(130, 150, 750, 40);
        getContentPane().add(txtDataLocacao);
        txtDataLocacao.setBounds(260, 220, 220, 40);

        txtDataDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataDevolucaoActionPerformed(evt);
            }
        });
        getContentPane().add(txtDataDevolucao);
        txtDataDevolucao.setBounds(650, 220, 220, 40);

        tblLocacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Cliente", "Veiculo", "Data Loc", "Data Dev", "Valor"
            }
        ));
        tblLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLocacaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLocacao);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(130, 380, 750, 300);

        labelSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sair.png"))); // NOI18N
        labelSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSairMouseClicked(evt);
            }
        });
        getContentPane().add(labelSair);
        labelSair.setBounds(400, 310, 50, 50);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExcluirMouseClicked(evt);
            }
        });
        getContentPane().add(btnExcluir);
        btnExcluir.setBounds(320, 310, 40, 50);

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        getContentPane().add(btnNovo);
        btnNovo.setBounds(240, 310, 40, 50);

        btnGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ok.png"))); // NOI18N
        btnGravar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGravarMouseClicked(evt);
            }
        });
        getContentPane().add(btnGravar);
        btnGravar.setBounds(150, 310, 50, 50);

        txtNovo.setText("Cliente");
        getContentPane().add(txtNovo);
        txtNovo.setBounds(40, 100, 60, 16);

        txtVeiculo.setText("Veiculo");
        getContentPane().add(txtVeiculo);
        txtVeiculo.setBounds(40, 170, 60, 16);

        jLabel1.setText("Data Locaocao");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 230, 97, 16);

        jLabel2.setText("Data Devolucao");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(520, 230, 106, 16);

        labelFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        labelFundo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(labelFundo);
        labelFundo.setBounds(0, 0, 990, 700);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   
    public int locacaoId = -1;
    
    private void labelSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSairMouseClicked
        //fecha a janela
        dispose();
    }//GEN-LAST:event_labelSairMouseClicked

    private void btnExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMouseClicked
        Locacao locacao = new Locacao();
        locacao.setLocacaoId(this.locacaoId);
        locacao.delete();
        this.preenchaTabela();
        
    }//GEN-LAST:event_btnExcluirMouseClicked

    private void btnGravarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGravarMouseClicked
        int alunoId = listaCliente.get(cbbCliente.getSelectedIndex()).getClienteId();
        int livroId = listaVeiculo.get(cbbVeiculo.getSelectedIndex()).getVeiculoId();
        String dataLocacao
                = txtDataLocacao.getText().substring(6, 10) + "-"
                + txtDataLocacao.getText().substring(3, 5) + "-"
                + txtDataLocacao.getText().substring(0, 2);
        String dataDevolucao = null;
        if (this.locacaoId != -1) {
            dataDevolucao = txtDataDevolucao.getText().substring(6, 10) + "-"
                    + txtDataDevolucao.getText().substring(3, 5) + "-"
                    + txtDataDevolucao.getText().substring(0, 2);
        }
        // cria um objeto da classe locacao
        Locacao locacao = new Locacao(this.locacaoId,
                dataLocacao, dataDevolucao, alunoId, livroId);
        // invoca o método que persite as informações para o banco de dados
        locacao.salve();
        // preenche o componente JTable com os registros atualizados
        this.preenchaTabela();

        
    }//GEN-LAST:event_btnGravarMouseClicked

    private void tblLocacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLocacaoMouseClicked
      
        // recupera o índice da linha selecionada
        int i = tblLocacao.getSelectedRow();
        // criar um objeto da classe tablemodel
        TableModel model = tblLocacao.getModel();
        this.locacaoId = Integer.parseInt(model.getValueAt(i, 0).toString());

        // desabilita os campos que não podem ser alterados
        cbbCliente.setEnabled(false);
        cbbVeiculo.setEnabled(false);
        txtDataLocacao.setEnabled(false);
        txtDataDevolucao.setEnabled(true);
        btnExcluir.setEnabled(true);

        // povoa o formulário
        cbbCliente.setSelectedItem(model.getValueAt(i, 1).toString());
        cbbVeiculo.setSelectedItem(model.getValueAt(i, 2).toString());
        txtDataLocacao.setText(model.getValueAt(i, 3).toString());
        txtDataDevolucao.setText(model.getValueAt(i, 4).toString());
        
    }//GEN-LAST:event_tblLocacaoMouseClicked

    private void txtDataDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataDevolucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataDevolucaoActionPerformed

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
            java.util.logging.Logger.getLogger(JFLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFLocacao().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(JFLocacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnExcluir;
    private javax.swing.JLabel btnGravar;
    private javax.swing.JLabel btnNovo;
    private javax.swing.JComboBox<String> cbbCliente;
    private javax.swing.JComboBox<String> cbbVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFundo;
    private javax.swing.JLabel labelSair;
    private javax.swing.JTable tblLocacao;
    private javax.swing.JFormattedTextField txtDataDevolucao;
    private javax.swing.JFormattedTextField txtDataLocacao;
    private javax.swing.JLabel txtNovo;
    private javax.swing.JLabel txtVeiculo;
    // End of variables declaration//GEN-END:variables
}

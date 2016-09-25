package view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

class JFPrincipal extends javax.swing.JFrame {

    public JFPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnCliente = new javax.swing.JLabel();
        btnVeiculo = new javax.swing.JLabel();
        btnLocacao = new javax.swing.JLabel();
        btnFechar = new javax.swing.JLabel();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");
        setMaximumSize(new java.awt.Dimension(1024, 768));
        setMinimumSize(new java.awt.Dimension(1030, 770));
        setName("Locadora"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo1.png"))); // NOI18N
        getContentPane().add(logo);
        logo.setBounds(90, 340, 750, 370);

        jPanel1.setBackground(new java.awt.Color(242, 250, 252));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cliente1.png"))); // NOI18N
        btnCliente.setText("Cliente");
        btnCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClienteMouseClicked(evt);
            }
        });

        btnVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carro1.png"))); // NOI18N
        btnVeiculo.setText("Veiculo");
        btnVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVeiculoMouseClicked(evt);
            }
        });

        btnLocacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/locacao.png"))); // NOI18N
        btnLocacao.setText("Locação");
        btnLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLocacaoMouseClicked(evt);
            }
        });

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sair1.png"))); // NOI18N
        btnFechar.setText("Sair");
        btnFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFecharMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(btnVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(btnLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 70, 1020, 110);

        fundo.setBackground(new java.awt.Color(1, 1, 1));
        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        fundo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fundo.setMaximumSize(new java.awt.Dimension(1024, 768));
        fundo.setMinimumSize(new java.awt.Dimension(1024, 768));
        fundo.setPreferredSize(new java.awt.Dimension(1030, 770));
        fundo.setRequestFocusEnabled(false);
        fundo.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(fundo);
        fundo.setBounds(0, 0, 1030, 770);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseClicked
        JFCliente cliente = new JFCliente();
        cliente.setVisible(true);
    }//GEN-LAST:event_btnClienteMouseClicked

    private void btnFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharMouseClicked
        dispose();
    }//GEN-LAST:event_btnFecharMouseClicked

    private void btnVeiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVeiculoMouseClicked
        JFVeiculo veiculo = new JFVeiculo();
        veiculo.setVisible(true);
    }//GEN-LAST:event_btnVeiculoMouseClicked

    private void btnLocacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLocacaoMouseClicked
        try {
            JFLocacao locacao = new JFLocacao();
            locacao.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(JFPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLocacaoMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JFPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCliente;
    private javax.swing.JLabel btnFechar;
    private javax.swing.JLabel btnLocacao;
    private javax.swing.JLabel btnVeiculo;
    private javax.swing.JLabel fundo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}

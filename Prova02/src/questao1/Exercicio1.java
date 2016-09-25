package questao1;

import javax.swing.JOptionPane;

public class Exercicio1 extends javax.swing.JFrame {

    public Exercicio1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelPeso = new javax.swing.JLabel();
        btnCalcula = new javax.swing.JButton();
        txtPeso = new javax.swing.JTextField();
        btnMercurio = new javax.swing.JRadioButton();
        btnVenus = new javax.swing.JRadioButton();
        btnMarte = new javax.swing.JRadioButton();
        btnJupiter = new javax.swing.JRadioButton();
        btnSaturno = new javax.swing.JRadioButton();
        btnUrano = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Peso Planetas");

        labelPeso.setText("Digite o Peso");

        btnCalcula.setText("Calcula");
        btnCalcula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculaActionPerformed(evt);
            }
        });

        btnMercurio.setText("Mercurio");
        btnMercurio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMercurioActionPerformed(evt);
            }
        });

        btnVenus.setText("Venus");

        btnMarte.setText("Marte");

        btnJupiter.setText("Jupter");

        btnSaturno.setText("Saturno");

        btnUrano.setText("Urano");

        jLabel1.setText("Escolha um planeta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPeso)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnCalcula)))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMercurio)
                        .addGap(37, 37, 37)
                        .addComponent(btnVenus))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMarte)
                            .addComponent(btnSaturno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUrano)
                            .addComponent(btnJupiter))))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMercurio)
                            .addComponent(btnVenus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMarte)
                            .addComponent(btnJupiter))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSaturno)
                            .addComponent(btnUrano)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCalcula)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculaActionPerformed

        double peso = Double.parseDouble(txtPeso.getText()), total;

        if (btnMercurio.isSelected()) {
            total = peso / 10 * 0.37;
            JOptionPane.showMessageDialog(null,"Em Mercurio seu peso sera equivalente a: " + total +"Kg");

        }
        if (btnVenus.isSelected()) {
            total = peso / 10 * 0.88;
            JOptionPane.showMessageDialog(null, "Em Venus seu peso sera equivalente a: " + total +"Kg");
        }
        if (btnMarte.isSelected()) {
            total = peso / 10 * 0.38;
            JOptionPane.showMessageDialog(null, "Em Marte seu peso sera equivalente a: " + total +"Kg");
        }
        if (btnJupiter.isSelected()) {
            total = peso / 10 * 2.64;
            JOptionPane.showMessageDialog(null, "Em Jupiter seu peso sera equivalente a: " + total +"Kg");
        }
        if (btnSaturno.isSelected()) {
            total = peso / 10 * 1.15;
            JOptionPane.showMessageDialog(null, "Em Saturno seu peso sera equivalente a: " + total +"Kg");
        }
        if (btnUrano.isSelected()) {
            total = peso / 10 * 1.17;
            JOptionPane.showMessageDialog(null, "Em Urano seu peso sera equivalente a: " + total +"Kg");
        }

      

    }//GEN-LAST:event_btnCalculaActionPerformed

    private void btnMercurioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMercurioActionPerformed


    }//GEN-LAST:event_btnMercurioActionPerformed

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
            java.util.logging.Logger.getLogger(Exercicio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Exercicio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Exercicio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Exercicio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Exercicio1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcula;
    private javax.swing.JRadioButton btnJupiter;
    private javax.swing.JRadioButton btnMarte;
    private javax.swing.JRadioButton btnMercurio;
    private javax.swing.JRadioButton btnSaturno;
    private javax.swing.JRadioButton btnUrano;
    private javax.swing.JRadioButton btnVenus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelPeso;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CompositionPattern.GUI;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class StonksBank extends javax.swing.JFrame {

    /**
     * Creates new form StonksBank
     */
    public StonksBank() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        DA1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        DA2 = new javax.swing.JTextField();
        chkDA1 = new javax.swing.JCheckBox();
        chkDA2 = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        txtTotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        cmbBalance = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        SA1 = new javax.swing.JTextField();
        SA2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        chkSA1 = new javax.swing.JCheckBox();
        chkSA2 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stonks Bank Account");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Stonks Bank Account");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(34, 34, 34));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Deposit Accounts");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("$");

        DA1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DA1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        DA1.setText("0.00");
        DA1.setEnabled(false);
        DA1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DA1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DA1KeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("$");

        DA2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DA2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        DA2.setText("0.00");
        DA2.setEnabled(false);
        DA2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DA2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DA2KeyTyped(evt);
            }
        });

        chkDA1.setBackground(new java.awt.Color(51, 51, 51));
        chkDA1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkDA1.setForeground(new java.awt.Color(255, 255, 255));
        chkDA1.setText("Account 1");
        chkDA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDA1ActionPerformed(evt);
            }
        });

        chkDA2.setBackground(new java.awt.Color(51, 51, 51));
        chkDA2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkDA2.setForeground(new java.awt.Color(255, 255, 255));
        chkDA2.setText("Account 2");
        chkDA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDA2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(DA2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(chkDA1)
                                .addComponent(chkDA2)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(40, 40, 40)
                                    .addComponent(jLabel9)
                                    .addGap(18, 18, 18)
                                    .addComponent(DA1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(chkDA1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(DA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chkDA2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(DA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        txtTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotal.setText("0.00 $");
        txtTotal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Account Balance");

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setText("Total Balance");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cmbBalance.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbBalance.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Total Account Balance", "Deposit Account Balance", "Savings Account Balance" }));
        cmbBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBalanceActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton4.setText("Savings Balance");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton5.setText("Deposit Balance");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbBalance, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(cmbBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(26, 26, 26))
        );

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Savings Accounts");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("$");

        SA1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SA1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        SA1.setText("0.00");
        SA1.setEnabled(false);
        SA1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SA1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SA1KeyTyped(evt);
            }
        });

        SA2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SA2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        SA2.setText("0.00");
        SA2.setEnabled(false);
        SA2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SA2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SA2KeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("$");

        chkSA1.setBackground(new java.awt.Color(51, 51, 51));
        chkSA1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkSA1.setForeground(new java.awt.Color(255, 255, 255));
        chkSA1.setText("Account 1");
        chkSA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSA1ActionPerformed(evt);
            }
        });

        chkSA2.setBackground(new java.awt.Color(51, 51, 51));
        chkSA2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkSA2.setForeground(new java.awt.Color(255, 255, 255));
        chkSA2.setText("Account 2");
        chkSA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSA2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkSA2)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(SA1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chkSA1)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(SA2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(chkSA1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(SA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chkSA2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(SA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        calculateTotal();        
        JOptionPane.showMessageDialog(this, "Total Account Balance: "+ txtTotal.getText());
        cmbBalance.setSelectedIndex(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void DA1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DA1KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {

            if (c != '.') {
                evt.consume();
            }
        }
    }//GEN-LAST:event_DA1KeyTyped

    private void SA1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SA1KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {

            if (c != '.') {
                evt.consume();
            }
        }
    }//GEN-LAST:event_SA1KeyTyped

    private void DA1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DA1KeyPressed
        if (evt.getKeyCode() == 10) {
            DA2.grabFocus();
            calculateTotal();
        }
    }//GEN-LAST:event_DA1KeyPressed

    private void SA1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SA1KeyPressed
        if (evt.getKeyCode() == 10) {
            SA2.grabFocus();
            calculateTotal();
        }
    }//GEN-LAST:event_SA1KeyPressed

    private void cmbBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBalanceActionPerformed

        try {
            float DepA1 = Float.parseFloat(DA1.getText());
            float DepA2 = Float.parseFloat(DA2.getText());
            float SavA1 = Float.parseFloat(SA1.getText());
            float SavA2 = Float.parseFloat(SA2.getText());

            switch (cmbBalance.getSelectedIndex()) {
                case 0:
                    calculateTotal();
                    break;

                case 1:
                    CompositeAccount depositAccount = new CompositeAccount();
                    depositAccount.addAccount(new DepositAccount("DA001", DepA1));
                    depositAccount.addAccount(new DepositAccount("DA002", DepA2));

                    float depBalance = depositAccount.getBalance();
                    txtTotal.setText(depBalance + " $");
                    break;

                case 2:
                    CompositeAccount savingsAccount = new CompositeAccount();
                    savingsAccount.addAccount(new DepositAccount("SA001", SavA1));
                    savingsAccount.addAccount(new DepositAccount("SA002", SavA2));

                    float savBalance = savingsAccount.getBalance();
                    txtTotal.setText(savBalance +" $");
                    break;

                default:
                    calculateTotal();
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_cmbBalanceActionPerformed

    private void DA2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DA2KeyPressed
        if (evt.getKeyCode() == 10) {
            SA1.grabFocus();
            calculateTotal();
        }
    }//GEN-LAST:event_DA2KeyPressed

    private void DA2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DA2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_DA2KeyTyped

    private void SA2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SA2KeyPressed
        if (evt.getKeyCode() == 10) {
            calculateTotal();
        }
    }//GEN-LAST:event_SA2KeyPressed

    private void SA2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SA2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_SA2KeyTyped

    private void chkDA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDA1ActionPerformed
        if (chkDA1.isSelected()) {
            int option = JOptionPane.showConfirmDialog(this, "Do you want to Open 'Deposit Account 1'?", "Account Activation", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                DA1.setEnabled(true);
                JOptionPane.showMessageDialog(this, "'Deposit Account 1' has been Activated!");
                DA1.setText("");
                DA1.grabFocus();
            } else {
                chkDA1.setSelected(false);
            }
        } else {
            int option = JOptionPane.showConfirmDialog(this, "Do you want to Close 'Deposit Account 1'?", "Account Deactivation", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                DA1.setEnabled(false);
                DA1.setText("0.00");
                JOptionPane.showMessageDialog(this, "'Deposit Account 1' has been Closed!");
                calculateTotal();
            } else {
                chkDA1.setSelected(true);
            }
        }
    }//GEN-LAST:event_chkDA1ActionPerformed

    private void chkDA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDA2ActionPerformed
        if (chkDA2.isSelected()) {
            int option = JOptionPane.showConfirmDialog(this, "Do you want to Open 'Deposit Account 2'?", "Account Activation", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                DA2.setEnabled(true);
                JOptionPane.showMessageDialog(this, "'Deposit Account 2' has been Activated!");
                DA2.setText("");
                DA2.grabFocus();
            } else {
                chkDA2.setSelected(false);
            }

        } else {
            int option = JOptionPane.showConfirmDialog(this, "Do you want to Close 'Deposit Account 2'?", "Account Deactivation", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                DA2.setEnabled(false);
                DA2.setText("0.00");
                JOptionPane.showMessageDialog(this, "'Deposit Account 2' has been Closed!");
                calculateTotal();
            } else {
                chkDA2.setSelected(true);
            }
        }

    }//GEN-LAST:event_chkDA2ActionPerformed

    private void chkSA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSA1ActionPerformed
        if (chkSA1.isSelected()) {
            int option = JOptionPane.showConfirmDialog(this, "Do you want to Open 'Savings Account 1'?", "", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                SA1.setEnabled(true);
                JOptionPane.showMessageDialog(this, "'Savings Account 1' has been Activated!");
                SA1.setText("");
                SA1.grabFocus();
            } else {
                chkSA1.setSelected(false);
            }
        } else {
            int option = JOptionPane.showConfirmDialog(this, "Do you want to Close 'Savings Account 1'?", "", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                SA1.setEnabled(false);
                SA1.setText("0.00");
                JOptionPane.showMessageDialog(this, "'Savings Account 1' has been Closed!");
                calculateTotal();
            } else {
                chkSA1.setSelected(true);
            }

        }
    }//GEN-LAST:event_chkSA1ActionPerformed

    private void chkSA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSA2ActionPerformed
        if (chkSA2.isSelected()) {
            int option = JOptionPane.showConfirmDialog(this, "Do you want to Open 'Savings Account 2'?", "", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                SA2.setEnabled(true);
                JOptionPane.showMessageDialog(this, "'Savings Account 2' has been Activated!");
                SA2.setText("");
                SA2.grabFocus();
            } else {
                chkSA2.setSelected(false);
            }
        } else {
            int option = JOptionPane.showConfirmDialog(this, "Do you want to Close 'Savings Account 2'?", "", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                SA2.setEnabled(false);
                SA2.setText("0.00");
                JOptionPane.showMessageDialog(this, "'Savings Account 2' has been Closed!");
                calculateTotal();
            } else {
                chkSA2.setSelected(true);
            }
        }
    }//GEN-LAST:event_chkSA2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        cmbBalance.setSelectedIndex(2);
        JOptionPane.showMessageDialog(this, "Savings Account Balance: "+ txtTotal.getText());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        cmbBalance.setSelectedIndex(1);
        JOptionPane.showMessageDialog(this, "Deposit Account Balance: "+ txtTotal.getText());
    }//GEN-LAST:event_jButton5ActionPerformed

    private void calculateTotal() {
        try {
            String DAA1 = DA1.getText();
            String DAA2 = DA1.getText();
            String SAA1 = SA1.getText();
            String SAA2 = SA1.getText();

            if ("".equals(DAA1)) {
                JOptionPane.showMessageDialog(this, "Please Fill the Deposit Account 1");
                DA1.grabFocus();

            } else if ("".equals(DAA2)) {
                JOptionPane.showMessageDialog(this, "Please Fill the Deposit Account 2");
                DA2.grabFocus();

            } else if ("".equals(SAA1)) {
                JOptionPane.showMessageDialog(this, "Please Fill the Savings Account 1");
                SA1.grabFocus();

            } else if ("".equals(SAA2)) {
                JOptionPane.showMessageDialog(this, "Please Fill the Savings Account 2");
                SA2.grabFocus();

            } else {
                float DepA1 = Float.parseFloat(DA1.getText());
                float DepA2 = Float.parseFloat(DA2.getText());
                float SavA1 = Float.parseFloat(SA1.getText());
                float SavA2 = Float.parseFloat(SA2.getText());

                CompositeAccount component = new CompositeAccount();
                component.addAccount(new DepositAccount("DA001", DepA1));
                component.addAccount(new DepositAccount("DA002", DepA2));
                component.addAccount(new SavingsAccount("SA001", SavA1));
                component.addAccount(new SavingsAccount("SA002", SavA2));

                float totalBalance = component.getBalance();
                txtTotal.setText(totalBalance + " $");

            }
        } catch (HeadlessException | NumberFormatException e) {
            System.out.println(e);
        }
        cmbBalance.setSelectedIndex(0);

    }

    interface Account {

        public abstract float getBalance();
    }

    class DepositAccount implements Account {

        private String accountNo;
        private float accountBalance;

        public DepositAccount(String accountNo, float accountBalance) {
            super();
            this.accountNo = accountNo;
            this.accountBalance = accountBalance;
        }

        @Override
        public float getBalance() {
            return accountBalance;
        }
    }

    class SavingsAccount implements Account {

        private String accountNo;
        private float accountBalance;

        public SavingsAccount(String accountNo, float accountBalance) {
            super();
            this.accountNo = accountNo;
            this.accountBalance = accountBalance;
        }

        @Override
        public float getBalance() {
            return accountBalance;
        }

    }

    class CompositeAccount implements Account {

        private float totalBalance;
        private List<Account> accountList = new ArrayList<>();

        @Override
        public float getBalance() {
            totalBalance = 0;
            for (Account f : accountList) {
                totalBalance = totalBalance + f.getBalance();
            }
            return totalBalance;
        }

        public void addAccount(Account acc) {
            accountList.add(acc);
        }

    }

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
            java.util.logging.Logger.getLogger(StonksBank.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StonksBank.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StonksBank.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StonksBank.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StonksBank().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DA1;
    private javax.swing.JTextField DA2;
    private javax.swing.JTextField SA1;
    private javax.swing.JTextField SA2;
    private javax.swing.JCheckBox chkDA1;
    private javax.swing.JCheckBox chkDA2;
    private javax.swing.JCheckBox chkSA1;
    private javax.swing.JCheckBox chkSA2;
    private javax.swing.JComboBox<String> cmbBalance;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}

/*
 * Copyright (c) 2018 Spyder Innovations </Akila Ranasinghe>
 * All rights reserved.
 */
package Views;

import Ctrl.JDBC;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;

/**
 * @author AKILA
 */
public class Customer_AccountDetails extends javax.swing.JDialog {

    /**
     * Creates new form Customer_AccountDetails
     *
     * @param parent
     * @param modal
     * @param payeeAccID
     */
    String custAccountID = "";
    public static JPasswordField pswField;

    public Customer_AccountDetails(java.awt.Frame parent, boolean modal, String csAccID) {
        super(parent, modal);
        initComponents();
        custAccountID = csAccID;
        loadTransRecords();

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_background = new javax.swing.JPanel(){
            private Image image;{
                try{
                    ImageIcon ii = new ImageIcon(getClass().getResource("/Images/background.png"));
                    image = ii.getImage();
                }catch(Exception e){
                }
            }
            @Override
            protected void paintComponent(Graphics graphcs){
                super.paintComponent(graphcs);
                graphcs.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        Panel_header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Panel_content = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_payment = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_reload = new javax.swing.JTable();
        Panel_details = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbl_contactNo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_accBalance = new javax.swing.JLabel();
        btn_changeCntc = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelRs = new javax.swing.JLabel();
        btn_changePsw = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbl_accID = new javax.swing.JLabel();
        lbl_custName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn_refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);

        Panel_header.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        jLabel1.setText("Account Details");

        jLabel5.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Customer");

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(160, 160, 160)));

        javax.swing.GroupLayout Panel_headerLayout = new javax.swing.GroupLayout(Panel_header);
        Panel_header.setLayout(Panel_headerLayout);
        Panel_headerLayout.setHorizontalGroup(
            Panel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(Panel_headerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        Panel_headerLayout.setVerticalGroup(
            Panel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        Panel_content.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel2.setText("Transactions History");

        jTabbedPane1.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N

        Table_payment.setAutoCreateRowSorter(true);
        Table_payment.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        Table_payment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time", "Location", "Amount (Rs.)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Table_payment);

        jTabbedPane1.addTab("Payment", jScrollPane2);

        Table_reload.setAutoCreateRowSorter(true);
        Table_reload.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        Table_reload.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time", "Authority", "Amount (Rs.)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table_reload);

        jTabbedPane1.addTab("Reload", jScrollPane1);

        Panel_details.setBackground(new java.awt.Color(255, 255, 255));
        Panel_details.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        jLabel3.setText("Contact Number  :");

        lbl_contactNo.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        lbl_contactNo.setForeground(new java.awt.Color(0, 102, 102));
        lbl_contactNo.setText("4354");

        jLabel6.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        jLabel6.setText("Account Balance");

        lbl_accBalance.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        lbl_accBalance.setForeground(new java.awt.Color(0, 102, 102));
        lbl_accBalance.setText("0.00");

        btn_changeCntc.setBackground(new java.awt.Color(255, 153, 51));
        btn_changeCntc.setFont(new java.awt.Font("Open Sans", 1, 13)); // NOI18N
        btn_changeCntc.setForeground(new java.awt.Color(255, 255, 255));
        btn_changeCntc.setText("Change Contact No.");
        btn_changeCntc.setContentAreaFilled(false);
        btn_changeCntc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_changeCntc.setFocusPainted(false);
        btn_changeCntc.setFocusable(false);
        btn_changeCntc.setOpaque(true);
        btn_changeCntc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_changeCntcActionPerformed(evt);
            }
        });

        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(160, 160, 160)));

        jLabelRs.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        jLabelRs.setForeground(new java.awt.Color(0, 102, 102));
        jLabelRs.setText("Rs.");

        btn_changePsw.setBackground(new java.awt.Color(0, 125, 184));
        btn_changePsw.setFont(new java.awt.Font("Open Sans", 1, 13)); // NOI18N
        btn_changePsw.setForeground(new java.awt.Color(255, 255, 255));
        btn_changePsw.setText("Change Password");
        btn_changePsw.setContentAreaFilled(false);
        btn_changePsw.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_changePsw.setFocusPainted(false);
        btn_changePsw.setFocusable(false);
        btn_changePsw.setOpaque(true);
        btn_changePsw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_changePswActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        jLabel4.setText("Account ID             :");

        lbl_accID.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        lbl_accID.setForeground(new java.awt.Color(0, 102, 102));
        lbl_accID.setText("423432");

        lbl_custName.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        lbl_custName.setForeground(new java.awt.Color(0, 102, 102));
        lbl_custName.setText("name here");

        jLabel7.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        jLabel7.setText("Customer Name  :");

        jLabel10.setFont(new java.awt.Font("Open Sans", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

        javax.swing.GroupLayout Panel_detailsLayout = new javax.swing.GroupLayout(Panel_details);
        Panel_details.setLayout(Panel_detailsLayout);
        Panel_detailsLayout.setHorizontalGroup(
            Panel_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(Panel_detailsLayout.createSequentialGroup()
                .addGroup(Panel_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_detailsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Panel_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_changeCntc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_changePsw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Panel_detailsLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelRs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_accBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Panel_detailsLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_contactNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Panel_detailsLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_accID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Panel_detailsLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_custName, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Panel_detailsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel7});

        Panel_detailsLayout.setVerticalGroup(
            Panel_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_detailsLayout.createSequentialGroup()
                .addGroup(Panel_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbl_accID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbl_custName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbl_contactNo))
                .addGap(48, 48, 48)
                .addComponent(jLabel10)
                .addGap(0, 0, 0)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_accBalance)
                    .addComponent(jLabelRs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_changePsw, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_changeCntc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Panel_detailsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel7, lbl_accID, lbl_contactNo, lbl_custName});

        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Ref2.png"))); // NOI18N
        btn_refresh.setToolTipText("Refresh");
        btn_refresh.setContentAreaFilled(false);
        btn_refresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_refresh.setFocusable(false);
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_contentLayout = new javax.swing.GroupLayout(Panel_content);
        Panel_content.setLayout(Panel_contentLayout);
        Panel_contentLayout.setHorizontalGroup(
            Panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(Panel_contentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel_details, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                    .addGroup(Panel_contentLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        Panel_contentLayout.setVerticalGroup(
            Panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_contentLayout.createSequentialGroup()
                .addGroup(Panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_contentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Panel_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Panel_contentLayout.createSequentialGroup()
                        .addGroup(Panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_refresh)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout Panel_backgroundLayout = new javax.swing.GroupLayout(Panel_background);
        Panel_background.setLayout(Panel_backgroundLayout);
        Panel_backgroundLayout.setHorizontalGroup(
            Panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Panel_content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel_backgroundLayout.setVerticalGroup(
            Panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_backgroundLayout.createSequentialGroup()
                .addComponent(Panel_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Panel_content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed

        loadTransRecords();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_changeCntcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_changeCntcActionPerformed

        try {
            Home.subWindowName = "CustomerAccountDetails";
            pswField = new JPasswordField();
            int confirmPSW = JOptionPane.showConfirmDialog(rootPane, pswField, "Please Insert Current Password", JOptionPane.OK_CANCEL_OPTION);
            if (confirmPSW == 0) { // if yes
                if (!pswField.getText().toString().trim().isEmpty()) {
                    ResultSet rs = JDBC.getData("SELECT customer_id, password FROM customer WHERE customer_id='" + custAccountID + "' AND password = '" + pswField.getText().toString().trim() + "' ");
                    if (rs.next()) {

                        new Customer_ChangeContact(null, true, custAccountID).setVisible(true);
                        btn_refresh.doClick();
                        Home.subWindowName = "";
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Invalid Password.", "Access Denied", 2);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Please Insert Valid Password.", "Access Denied", 2);
                }
            }
            Home.subWindowName = "";

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btn_changeCntcActionPerformed

    private void btn_changePswActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_changePswActionPerformed

        try {
            Home.subWindowName = "CustomerAccountDetails";
            pswField = new JPasswordField();
            int confirmPSW = JOptionPane.showConfirmDialog(rootPane, pswField, "Please Insert Current Password", JOptionPane.OK_CANCEL_OPTION);
            if (confirmPSW == 0) { // if yes
                if (!pswField.getText().toString().trim().isEmpty()) {
                    ResultSet rs = JDBC.getData("SELECT customer_id, password FROM customer WHERE customer_id='" + custAccountID + "' AND password = '" + pswField.getText().toString().trim() + "' ");
                    if (rs.next()) {
                        new Customer_ChangePassword(null, true, custAccountID).setVisible(true);
                        btn_refresh.doClick();
                        Home.subWindowName = "";
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Invalid Password.", "Access Denied", 2);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Please Insert Valid Password.", "Access Denied", 2);
                }
            }
            Home.subWindowName = "";

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btn_changePswActionPerformed

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
            java.util.logging.Logger.getLogger(Customer_AccountDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_AccountDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_AccountDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_AccountDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Customer_AccountDetails dialog = new Customer_AccountDetails(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_background;
    private javax.swing.JPanel Panel_content;
    private javax.swing.JPanel Panel_details;
    private javax.swing.JPanel Panel_header;
    private javax.swing.JTable Table_payment;
    private javax.swing.JTable Table_reload;
    private javax.swing.JButton btn_changeCntc;
    private javax.swing.JButton btn_changePsw;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelRs;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_accBalance;
    private javax.swing.JLabel lbl_accID;
    private javax.swing.JLabel lbl_contactNo;
    private javax.swing.JLabel lbl_custName;
    // End of variables declaration//GEN-END:variables

    private void loadTransRecords() {
        try {
            // load PAYMENT transactions
            DefaultTableModel dtmPayment = (DefaultTableModel) Table_payment.getModel();
            ResultSet rsLoct;
            ResultSet rsPayment = JDBC.getData("SELECT * FROM payment WHERE customer_id = '" + custAccountID + "'  ");
            dtmPayment.setRowCount(0);
            while (rsPayment.next()) {
                Vector v = new Vector();
                v.add(rsPayment.getString("date"));
                v.add(rsPayment.getString("time"));
                rsLoct = JDBC.getData("SELECT payee_account_id,account_name  FROM payee_account WHERE payee_account_id = '" + rsPayment.getString("payee_account_id") + "'  ");
                if (rsLoct.next()) {
                    v.add(rsLoct.getString("account_name"));
                }
                v.add(new DecimalFormat("#0.00").format(rsPayment.getDouble("amount")));
                dtmPayment.addRow(v);
            }

            // load RELOAD  transactions
            DefaultTableModel dtmRld = (DefaultTableModel) Table_reload.getModel();
            ResultSet rsAdmin;
            ResultSet rsReload = JDBC.getData("SELECT * FROM reload WHERE customer_id = '" + custAccountID + "'  ");
            dtmRld.setRowCount(0);
            while (rsReload.next()) {
                Vector v = new Vector();
                v.add(rsReload.getString("date"));
                v.add(rsReload.getString("time"));
                rsAdmin = JDBC.getData("SELECT id,user_name FROM admin WHERE id = '" + rsReload.getString("admin_id") + "'  ");
                if (rsAdmin.next()) {
                    v.add(rsAdmin.getString("user_name"));
                }
                v.add(new DecimalFormat("#0.00").format(rsReload.getDouble("amount")));
                dtmRld.addRow(v);
            }

            // load Account Details
            ResultSet rCust = JDBC.getData("SELECT * FROM customer WHERE customer_id = '" + custAccountID + "'  ");
            if (rCust.next()) {
                lbl_accID.setText(rCust.getString("customer_id"));
                lbl_custName.setText(rCust.getString("f_name") + " " + rCust.getString("l_name"));
                lbl_contactNo.setText(rCust.getString("contact_no"));
                lbl_accBalance.setText(String.valueOf(new DecimalFormat("#0.00").format(rCust.getDouble("balance"))));

                // set Action buttons
                if (rCust.getString("status").equals("Active")) {
                    btn_changePsw.setEnabled(true);
                    btn_changePsw.setBackground(new Color(0, 125, 184));
                    btn_changeCntc.setEnabled(true);
                    btn_changeCntc.setBackground(new Color(255, 153, 51));
                } else {
                    btn_changePsw.setEnabled(false);
                    btn_changePsw.setBackground(new Color(240, 240, 240));
                    btn_changeCntc.setEnabled(false);
                    btn_changeCntc.setBackground(new Color(240, 240, 240));
                }
            } else {
                lbl_accBalance.setText("0.00");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

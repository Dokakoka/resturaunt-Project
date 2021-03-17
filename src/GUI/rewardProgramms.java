package GUI;

import DB.ManageCustomers;
import DB.DB;
import resturaunt.customerInfo;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.TableRowSorter;
import resturaunt.*;

public class rewardProgramms extends javax.swing.JFrame {

    public rewardProgramms() {
        initComponents();
        double bill = 0;
        show_user(bill);
        setTitle("Reward Programs");
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
    }
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public static String E_mail;
    
    public ArrayList<customerInfo>userlist(double bill) {
        ArrayList<customerInfo>usersList = new ArrayList<>();
        try {
            DB d = new DB();
            con = d.connect();
            String query1 = "SELECT customers.id, customer_name, number_of_orders, meal_title, total_bill from customers join orders on customers.id = orders.customer_id where total_bill>=" + bill;
                    
            Statement st = con.createStatement();
            rs = st.executeQuery(query1);
            customerInfo user;
            while(rs.next()) {
                user = new customerInfo(rs.getInt("id"), rs.getString("customer_name"), rs.getInt("number_of_orders"), rs.getString("meal_title"), rs.getFloat("total_bill"));
                usersList.add(user);    
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        return usersList;
    }
     
     public void show_user(double bill) {
         ArrayList<customerInfo> list = userlist(bill);
         DefaultTableModel model = (DefaultTableModel)reward.getModel();
         Object[] row = new Object [5];
         for(int i= 0; i< list.size(); i++) {
             row[0] = list.get(i).getid();
             row[1] = list.get(i).getCustomerName();
             row[2] = list.get(i).getNumberOfOrders();
             row[3] = list.get(i).getMealTitle();
             row[4] = list.get(i).getTotalBill();
             model.addRow(row);
         }
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        reward = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        money = new javax.swing.JTextField();
        searchData = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Reward programms");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        reward.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Number of Orders", "Meal Title", "Total Bill"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reward.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rewardMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(reward);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("Money to give the customer");

        money.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moneyActionPerformed(evt);
            }
        });

        searchData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDataActionPerformed(evt);
            }
        });
        searchData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchDataKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchDataKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 255));
        jLabel5.setText("Total Bill");

        jButton2.setForeground(new java.awt.Color(51, 102, 255));
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(money, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(searchData))
                                .addGap(38, 38, 38)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 601, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(money, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchData, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Programms().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchDataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchDataKeyReleased
       
    }//GEN-LAST:event_searchDataKeyReleased

    private void rewardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rewardMouseClicked
        int i = reward.getSelectedRow();
        TableModel model = reward.getModel();
        int row = reward.getSelectedRow();
        String value = money.getText();
        double moneyNumber = Double.parseDouble(value);
        String id = (reward.getModel().getValueAt(row, 0).toString());
        int number_of_orders = (int) model.getValueAt(i, 2);
        float total_bill = (float) model.getValueAt(i, 4);
        String amount = searchData.getText();
        double totalAmount = Double.parseDouble(amount);
        
        if(value.equals("") || amount.equals("")){
            JOptionPane.showMessageDialog(null,"You should enter all fields", "Error", JOptionPane.ERROR_MESSAGE);   
        }
        
        else {
        int opt = JOptionPane.showConfirmDialog(null, "Are You want to give this customer " + moneyNumber + "EGP", "Delete", JOptionPane.YES_NO_OPTION);
        if(opt == 0) {
            
        ManageCustomers c = new ManageCustomers();
        boolean getOrders = c.checkOrders(id, totalAmount, total_bill, moneyNumber);
        
        if(getOrders){
        EmailSender e = new EmailSender();
        try {
            String password = e.getEmailByID(id);
            c.addReward(id, moneyNumber);
            e.reward(E_mail, password, moneyNumber);
        }   catch (SQLException ex) {
                Logger.getLogger(rewardProgramms.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        }
        }
    }//GEN-LAST:event_rewardMouseClicked

    private void moneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moneyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moneyActionPerformed

    private void searchDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchDataActionPerformed

    private void searchDataKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchDataKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_searchDataKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       String value = searchData.getText();
       double total = Double.parseDouble(value);
       
       if(value.equals("")) {
           JOptionPane.showMessageDialog(null,"You should enter all fields", "Error", JOptionPane.ERROR_MESSAGE);
       }
       else{
       DefaultTableModel model = (DefaultTableModel) reward.getModel();
            model.setRowCount(0);
       
       show_user(total);
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rewardProgramms().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField money;
    private javax.swing.JTable reward;
    private javax.swing.JTextField searchData;
    // End of variables declaration//GEN-END:variables
}

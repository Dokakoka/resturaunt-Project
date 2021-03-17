package GUI;

import DB.DB;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import resturaunt.*;

public class reports extends javax.swing.JFrame {

    public reports() {
        initComponents();
        setTitle("Reports");
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
    }
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
public ArrayList<reportInfo>employeeList() {
        ArrayList<reportInfo>usersList = new ArrayList<>();
        try {
            DB d = new DB();
            con = d.connect();
            String query = "SELECT * FROM users where Roll_id = 2";
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            reportInfo user;
            while(rs.next()) {
                user = new reportInfo(rs.getInt("id"), rs.getString("username"), rs.getString("email"));
                usersList.add(user);
                
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        return usersList;
    }

public ArrayList<reportInfo>customerList() {
        ArrayList<reportInfo>usersList = new ArrayList<>();
        try {
            DB d = new DB();
            con = d.connect();
            String query = "SELECT * FROM customers";
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            reportInfo user;
            while(rs.next()) {
                user = new reportInfo(rs.getInt("id"), rs.getString("customer_name"), rs.getString("email"));
                usersList.add(user);
                
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        return usersList;
    }
    
    public void show_user(String comboBox) {
        
        if(comboBox.equals("Employee")){
         ArrayList<reportInfo> list = employeeList();
         DefaultTableModel model = (DefaultTableModel)displayInfo.getModel();
         Object[] row = new Object [4];
         for(int i= 0; i< list.size(); i++) {
             row[0] = list.get(i).getid();
             row[1] = list.get(i).getusername();
             row[2] = list.get(i).getemail();
             model.addRow(row);
         }
    }
        else if(comboBox.equals("Customer")){
         ArrayList<reportInfo> list = customerList();
         DefaultTableModel model = (DefaultTableModel)displayInfo.getModel();
         Object[] row = new Object [4];
         for(int i= 0; i< list.size(); i++) {
             row[0] = list.get(i).getid();
             row[1] = list.get(i).getusername();
             row[2] = list.get(i).getemail();
             model.addRow(row);
         }       
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        displayInfo = new javax.swing.JTable();
        comboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Reports to employees and customers");

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 51, 255));
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        displayInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        displayInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayInfoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(displayInfo);

        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Employee", "Customer" }));
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("Select type");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new admin().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        String type = comboBox.getSelectedItem().toString();
        DefaultTableModel model = (DefaultTableModel) displayInfo.getModel();
        model.setRowCount(0);
        show_user(type);
    }//GEN-LAST:event_comboBoxActionPerformed

    private void displayInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayInfoMouseClicked
        int i = displayInfo.getSelectedRow();
        TableModel model = displayInfo.getModel();
        int row = displayInfo.getSelectedRow();
        int id = (int) model.getValueAt(i, 0);
        String name = model.getValueAt(i, 1).toString();
        
        String text = textArea.getText();
        
        int opt = JOptionPane.showConfirmDialog(null, "Are You sure to send this report?", "Send Report", JOptionPane.YES_NO_OPTION);
        if(opt == 0) {
            String email = model.getValueAt(i, 2).toString();
            if(email.equals("No Email") || text.equals("")){
                JOptionPane.showMessageDialog(null,"You should enter email and text to report", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            else{
                EmailSender e = new EmailSender();
                try {
                    String password = e.getEmailByIntID(id);
                    e.report(email, password, text);
                } catch (SQLException ex) {
                    Logger.getLogger(reports.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }//GEN-LAST:event_displayInfoMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JTable displayInfo;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}

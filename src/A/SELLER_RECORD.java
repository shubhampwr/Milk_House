/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author LENOVO
 */
public class SELLER_RECORD extends javax.swing.JFrame {
     public Connection conn=null;
    public ResultSet rs=null;
    PreparedStatement pst=null;

     public Connection getConn(){
        
        try {
            Class.forName("org.postgresql.Driver");
            
        } catch (ClassNotFoundException ex) {
           
            Logger.getLogger(MILK_SUBMIT.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      try {
        String url="jdbc:postgresql://localhost/postgres";
        String user="postgres";
        String password="shubhampwr";
        
        
            conn=DriverManager.getConnection(url, user, password);
            ///JOptionPane.showMessageDialog(null,"connect");
        } catch (SQLException ex) {
            Logger.getLogger(MILK_SUBMIT.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;
        
    }
    
    public void fetch()
    {
        try
        {
           
        String q="SELECT id, password, \"Name\", \"City\", \"Animal\", \"Reg_date\"\n" +
"	FROM public.\"Seller1\";";
        pst=conn.prepareStatement(q);
        rs=pst.executeQuery();
        
        jtb1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);};
    }
   
    public SELLER_RECORD() {
        initComponents();
        getConn();
        fetch();
        
        
    }

    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtb1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(533, 354));
        setPreferredSize(new java.awt.Dimension(533, 354));
        getContentPane().setLayout(null);

        jtb1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "PASSWORD", "NAME", "CITY", "ANIMAL", "REG_DATE"
            }
        ));
        jScrollPane1.setViewportView(jtb1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 40, 479, 210);

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 102, 0));
        jButton1.setMnemonic('C');
        jButton1.setText("CLOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(200, 270, 120, 30);

        jLabel1.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 51));
        jLabel1.setText("SELLER LIST ...");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 370, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/A/a2.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-30, 0, 580, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int a= JOptionPane.showConfirmDialog(null,"Are You Sure Want To Close...???");
        if(a==JOptionPane.YES_OPTION)
        {
            new SELLER().setVisible(true);
            
           //.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        }else if(a==JOptionPane.NO_OPTION)
        {
            
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SELLER_RECORD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SELLER_RECORD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SELLER_RECORD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SELLER_RECORD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SELLER_RECORD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtb1;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams;

import green.ams.controllers.AuthController;
import green.ams.models.User;
import java.sql.Date;
import java.util.ResourceBundle;

import javax.swing.JPanel;

/**
 *
 * @author Adham
 */
public class MEWA extends javax.swing.JFrame {

    /**
     * Creates new form APP
     *
     * @param language
     */
    public MEWA() {
        initComponents();

        Start();
        
        switchLanguage();
    }
       

    // APP Frame Intialization
    APP app;

    // User Model Intializaition
    User user;

    // Current Date Intializaition
    Date currentDate;

    // User Authentication Intializaition
    AuthController auth = new AuthController();

    private void Start() {

        MEWANavigation.setVisible(true);
    }

    private void MoveTo(JPanel o1, JPanel o2) {
        o1.setVisible(false);
        o2.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        PanelHome = new javax.swing.JPanel();
        BtnSignOut = new javax.swing.JButton();
        BtnSupport = new javax.swing.JLabel();
        BtnSetting = new javax.swing.JLabel();
        BtnUserProfile = new javax.swing.JLabel();
        MEWANavigation = new javax.swing.JPanel();
        nav_request_area = new javax.swing.JLabel();
        nav_areas = new javax.swing.JLabel();
        starRating = new green.ams.components.StarRating();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("green/ams/Bundle"); // NOI18N
        jMenu1.setText(bundle.getString("MEWA.jMenu1.text")); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(bundle.getString("MEWA.title")); // NOI18N
        setBackground(new java.awt.Color(237, 233, 224));
        setForeground(new java.awt.Color(237, 233, 224));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setName("AppJFrame"); // NOI18N
        setResizable(false);

        PanelHome.setBackground(new java.awt.Color(245, 255, 243));
        PanelHome.setMaximumSize(new java.awt.Dimension(1366, 768));
        PanelHome.setMinimumSize(new java.awt.Dimension(1366, 768));
        PanelHome.setPreferredSize(new java.awt.Dimension(1366, 776));
        PanelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnSignOut.setBackground(new java.awt.Color(204, 255, 204));
        BtnSignOut.setFont(new java.awt.Font("Traditional Arabic", 1, 12)); // NOI18N
        BtnSignOut.setText(bundle.getString("MEWA.BtnSignOut.text")); // NOI18N
        BtnSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSignOutActionPerformed(evt);
            }
        });
        PanelHome.add(BtnSignOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        BtnSupport.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        BtnSupport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/support-removebg-preview.png"))); // NOI18N
        BtnSupport.setText(bundle.getString("MEWA.BtnSupport.text")); // NOI18N
        BtnSupport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSupport.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        PanelHome.add(BtnSupport, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 660, 280, 60));

        BtnSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/user-removebg-preview.png"))); // NOI18N
        BtnSetting.setText(bundle.getString("MEWA.BtnSetting.text")); // NOI18N
        BtnSetting.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelHome.add(BtnSetting, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 10, 70, 70));

        BtnUserProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/settings-removebg-preview.png"))); // NOI18N
        BtnUserProfile.setText(bundle.getString("MEWA.BtnUserProfile.text")); // NOI18N
        BtnUserProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelHome.add(BtnUserProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 10, 70, 70));

        MEWANavigation.setBackground(new java.awt.Color(245, 255, 243));
        MEWANavigation.setMinimumSize(new java.awt.Dimension(500, 500));
        MEWANavigation.setPreferredSize(new java.awt.Dimension(1350, 330));
        MEWANavigation.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 20));

        nav_request_area.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        nav_request_area.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/rate-removebg-preview.png"))); // NOI18N
        nav_request_area.setText(bundle.getString("MEWA.nav_request_area.text")); // NOI18N
        nav_request_area.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_request_area.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nav_request_area.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MEWANavigation.add(nav_request_area);

        nav_areas.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        nav_areas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/consultant-removebg-preview.png"))); // NOI18N
        nav_areas.setText(bundle.getString("MEWA.nav_areas.text")); // NOI18N
        nav_areas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_areas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nav_areas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MEWANavigation.add(nav_areas);

        PanelHome.add(MEWANavigation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 1350, -1));
        PanelHome.add(starRating, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelHome, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSignOutActionPerformed
        // TODO add your handling code here:

        user = null;
        this.dispose();
        app = new APP();
        app.setVisible(true);

    }//GEN-LAST:event_BtnSignOutActionPerformed

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
            java.util.logging.Logger.getLogger(MEWA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MEWA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MEWA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MEWA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MEWA().setVisible(true);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnSetting;
    private javax.swing.JButton BtnSignOut;
    private javax.swing.JLabel BtnSupport;
    private javax.swing.JLabel BtnUserProfile;
    private javax.swing.JPanel MEWANavigation;
    private javax.swing.JPanel PanelHome;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JLabel nav_areas;
    private javax.swing.JLabel nav_request_area;
    private green.ams.components.StarRating starRating;
    // End of variables declaration//GEN-END:variables

    private void switchLanguage() {

        // Reload ResourceBundle with correct package
        GLOBAL.bundle = ResourceBundle.getBundle("green.ams.Bundle", GLOBAL.currentLocale);

        // Update UI Components
        GLOBAL.updateTextFields(this, "USER", GLOBAL.bundle);
    }

}

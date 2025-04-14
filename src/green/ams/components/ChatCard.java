package green.ams.components;

import green.ams.GLOBAL;
import green.ams.models.Sample;
import green.ams.models.SampleItem;
import green.ams.controllers.SampleController;
import java.text.DecimalFormat;

public class ChatCard extends javax.swing.JPanel {


    public ChatCard() {
        initComponents();
    }


    public void setData() {
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbItemID = new javax.swing.JLabel();
        PanelChatCard = new javax.swing.JPanel();
        PanelChatMessages = new javax.swing.JPanel();
        LblChatMessages = new javax.swing.JLabel();
        PanelChatUserName = new javax.swing.JPanel();
        LblChatUserName = new javax.swing.JLabel();

        lbItemID.setText("jLabel1");

        setBackground(new java.awt.Color(168, 207, 182));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(300, 1000));
        setMinimumSize(new java.awt.Dimension(250, 350));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(500, 300));
        setLayout(new java.awt.CardLayout());

        PanelChatCard.setBackground(new java.awt.Color(255, 255, 255));
        PanelChatCard.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        PanelChatCard.setPreferredSize(new java.awt.Dimension(500, 300));
        PanelChatCard.setLayout(new javax.swing.BoxLayout(PanelChatCard, javax.swing.BoxLayout.LINE_AXIS));

        PanelChatMessages.setBackground(new java.awt.Color(255, 255, 255));
        PanelChatMessages.setOpaque(false);
        PanelChatMessages.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 5, 30));

        LblChatMessages.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblChatMessages.setForeground(new java.awt.Color(255, 51, 51));
        LblChatMessages.setText("4");
        PanelChatMessages.add(LblChatMessages);

        PanelChatCard.add(PanelChatMessages);

        PanelChatUserName.setBackground(new java.awt.Color(255, 255, 255));
        PanelChatUserName.setOpaque(false);
        PanelChatUserName.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.TRAILING, 5, 30));

        LblChatUserName.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblChatUserName.setText("Mohamed");
        PanelChatUserName.add(LblChatUserName);

        PanelChatCard.add(PanelChatUserName);

        add(PanelChatCard, "card5");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblChatMessages;
    private javax.swing.JLabel LblChatUserName;
    private javax.swing.JPanel PanelChatCard;
    private javax.swing.JPanel PanelChatMessages;
    private javax.swing.JPanel PanelChatUserName;
    private javax.swing.JLabel lbItemID;
    // End of variables declaration//GEN-END:variables

}
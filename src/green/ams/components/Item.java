package green.ams.components;

import green.ams.GLOBAL;
import green.ams.models.Sample;
import green.ams.models.SampleItem;
import green.ams.controllers.SampleController;
import java.text.DecimalFormat;

public class Item extends javax.swing.JPanel {

    private int item_id;

    public Item() {
        initComponents();
    }

    private Sample sample;

    public void setData(Sample sample) {
        this.sample = sample;
        item_id = sample.getId();
        lbItemName.setText(sample.getName());
        lbDescription.setText(sample.getDescription());
        lbCategory.setText(sample.getCategory());
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        lbPrice.setText(df.format(sample.getPrice()));
        pictureBox.setImage(sample.getImageIcon());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbItemID = new javax.swing.JLabel();
        PanelItemCard = new javax.swing.JPanel();
        Container = new javax.swing.JPanel();
        lbItemName = new javax.swing.JLabel();
        pictureBox = new green.ams.components.PictureBox();
        lbPrice = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbDescription = new javax.swing.JTextArea();
        SubContainer = new javax.swing.JPanel();
        lbCategory = new javax.swing.JLabel();
        BtnItemCart = new javax.swing.JButton();

        lbItemID.setText("jLabel1");

        setBackground(new java.awt.Color(168, 207, 182));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(300, 1000));
        setMinimumSize(new java.awt.Dimension(250, 350));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(300, 500));
        setLayout(new java.awt.CardLayout());

        PanelItemCard.setBackground(new java.awt.Color(168, 207, 182));
        PanelItemCard.setLayout(new javax.swing.BoxLayout(PanelItemCard, javax.swing.BoxLayout.Y_AXIS));

        Container.setOpaque(false);
        Container.setLayout(new java.awt.BorderLayout());

        lbItemName.setBackground(new java.awt.Color(0, 0, 0));
        lbItemName.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        lbItemName.setForeground(new java.awt.Color(76, 76, 76));
        lbItemName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbItemName.setText("Item Name");
        lbItemName.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 1, 10, 1));
        Container.add(lbItemName, java.awt.BorderLayout.PAGE_START);

        pictureBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));
        pictureBox.setImage(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/images/sample-outdoor.png"))); // NOI18N
        Container.add(pictureBox, java.awt.BorderLayout.CENTER);

        lbPrice.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        lbPrice.setForeground(new java.awt.Color(76, 76, 76));
        lbPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPrice.setText("$0.00");
        Container.add(lbPrice, java.awt.BorderLayout.PAGE_END);

        PanelItemCard.add(Container);

        lbDescription.setEditable(false);
        lbDescription.setBackground(new java.awt.Color(168, 207, 182));
        lbDescription.setColumns(20);
        lbDescription.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        lbDescription.setLineWrap(true);
        lbDescription.setRows(5);
        lbDescription.setToolTipText("");
        lbDescription.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(lbDescription);

        PanelItemCard.add(jScrollPane1);

        SubContainer.setOpaque(false);
        SubContainer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 5));

        lbCategory.setFont(new java.awt.Font("Traditional Arabic", 1, 12)); // NOI18N
        lbCategory.setForeground(new java.awt.Color(76, 76, 76));
        lbCategory.setText("Category");
        SubContainer.add(lbCategory);

        BtnItemCart.setFont(new java.awt.Font("Traditional Arabic", 1, 12)); // NOI18N
        BtnItemCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/cart-icon-removebg-preview.png"))); // NOI18N
        BtnItemCart.setText("Add Cart");
        BtnItemCart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnItemCart.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        BtnItemCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnItemCartActionPerformed(evt);
            }
        });
        SubContainer.add(BtnItemCart);

        PanelItemCard.add(SubContainer);

        add(PanelItemCard, "card5");
    }// </editor-fold>//GEN-END:initComponents

    private void BtnItemCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnItemCartActionPerformed
        // TODO add your handling code here:

        System.out.println("Item ID Inserted: " + item_id);
        
        SampleItem sample_item = new SampleItem(item_id, 1);
        sample_item.setUser_id(GLOBAL.user_id);
      
        SampleController sample_controller = new SampleController();
        
        if (sample_controller.SampleItem(sample_item)) {
            System.out.println("Ture");
        }else {
            System.out.println("False");
        }

    }//GEN-LAST:event_BtnItemCartActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnItemCart;
    private javax.swing.JPanel Container;
    private javax.swing.JPanel PanelItemCard;
    private javax.swing.JPanel SubContainer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCategory;
    private javax.swing.JTextArea lbDescription;
    private javax.swing.JLabel lbItemID;
    private javax.swing.JLabel lbItemName;
    private javax.swing.JLabel lbPrice;
    private green.ams.components.PictureBox pictureBox;
    // End of variables declaration//GEN-END:variables

}
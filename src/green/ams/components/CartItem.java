package green.ams.components;

import green.ams.controllers.SampleController;
import green.ams.models.SampleItem;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class CartItem extends javax.swing.JPanel {

    private int item_id;

    public CartItem() {
        initComponents();
    }

    private SampleItem sample_item;

    public void setData(SampleItem sample_item) {
        this.sample_item = sample_item;
        item_id = sample_item.getId();
        lbItemName.setText(sample_item.getName());
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        lbPrice.setText(df.format(sample_item.getPrice()));
        TFQuantity.setText("" + sample_item.getQuantity());
        pictureBox.setImage(sample_item.getImageIcon());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbItemID = new javax.swing.JLabel();
        PanelItemCard = new javax.swing.JPanel();
        Container = new javax.swing.JPanel();
        lbItemName = new javax.swing.JLabel();
        pictureContainer = new javax.swing.JPanel();
        pictureBox = new green.ams.components.PictureBox();
        lbPrice = new javax.swing.JLabel();
        QuantityBar = new javax.swing.JPanel();
        BtnIncrement = new javax.swing.JButton();
        TFQuantity = new javax.swing.JTextField();
        BtnDecrement = new javax.swing.JButton();
        BtnDeleteItem = new javax.swing.JButton();

        lbItemID.setText("jLabel1");

        setBackground(new java.awt.Color(168, 207, 182));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(300, 1000));
        setMinimumSize(new java.awt.Dimension(250, 350));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(250, 400));
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

        pictureContainer.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 10, 20, 10));
        pictureContainer.setOpaque(false);
        pictureContainer.setLayout(new javax.swing.BoxLayout(pictureContainer, javax.swing.BoxLayout.LINE_AXIS));

        pictureBox.setImage(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/images/sample-outdoor.png"))); // NOI18N
        pictureContainer.add(pictureBox);

        Container.add(pictureContainer, java.awt.BorderLayout.CENTER);

        lbPrice.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        lbPrice.setForeground(new java.awt.Color(76, 76, 76));
        lbPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPrice.setText("$0.00");
        Container.add(lbPrice, java.awt.BorderLayout.PAGE_END);

        PanelItemCard.add(Container);

        BtnIncrement.setText("+");
        BtnIncrement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIncrementActionPerformed(evt);
            }
        });
        QuantityBar.add(BtnIncrement);

        TFQuantity.setEditable(false);
        TFQuantity.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        TFQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFQuantity.setText("1");
        TFQuantity.setBorder(null);
        TFQuantity.setPreferredSize(new java.awt.Dimension(100, 30));
        QuantityBar.add(TFQuantity);

        BtnDecrement.setText("-");
        BtnDecrement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDecrementActionPerformed(evt);
            }
        });
        QuantityBar.add(BtnDecrement);

        PanelItemCard.add(QuantityBar);

        BtnDeleteItem.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        BtnDeleteItem.setText("Remove Item");
        BtnDeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteItemActionPerformed(evt);
            }
        });
        PanelItemCard.add(BtnDeleteItem);

        add(PanelItemCard, "card5");
    }// </editor-fold>//GEN-END:initComponents

    private void BtnIncrementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIncrementActionPerformed
        // TODO add your handling code here:

        int quantity = Integer.parseInt(TFQuantity.getText());

        quantity++;

        TFQuantity.setText("" + quantity);

    }//GEN-LAST:event_BtnIncrementActionPerformed

    private void BtnDecrementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDecrementActionPerformed
        // TODO add your handling code here:

        int quantity = Integer.parseInt(TFQuantity.getText());

        if (quantity <= 1) {
            JOptionPane.showMessageDialog(null, "This Is The Minimum Quantity");
        } else {
            quantity--;
        }

        TFQuantity.setText("" + quantity);


    }//GEN-LAST:event_BtnDecrementActionPerformed

    private void BtnDeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteItemActionPerformed
        // TODO add your handling code here:
        
        SampleController sample_controller = new SampleController();
        
        sample_controller.removeSampleItem(item_id);
        
        this.disable();
        
    }//GEN-LAST:event_BtnDeleteItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDecrement;
    private javax.swing.JButton BtnDeleteItem;
    private javax.swing.JButton BtnIncrement;
    private javax.swing.JPanel Container;
    private javax.swing.JPanel PanelItemCard;
    private javax.swing.JPanel QuantityBar;
    private javax.swing.JTextField TFQuantity;
    private javax.swing.JLabel lbItemID;
    private javax.swing.JLabel lbItemName;
    private javax.swing.JLabel lbPrice;
    private green.ams.components.PictureBox pictureBox;
    private javax.swing.JPanel pictureContainer;
    // End of variables declaration//GEN-END:variables

    public SampleItem getSampleItem() {
        return this.sample_item;
    }

    public int getQuantity() {
        return Integer.parseInt(TFQuantity.getText()); // or spinner.getValue()
    }

}

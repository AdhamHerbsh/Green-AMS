package green.ams.components;

import javax.swing.*;
import java.awt.*;

public class ChatCard extends JPanel {

    public ChatCard() {
        initComponents();
    }

    public void setUserInfo(String fullName, String lastMessagePreview) {
        LblChatUserName.setText(fullName != null ? fullName : "Unknown User");
        LblChatMessages.setText(lastMessagePreview != null ? lastMessagePreview : "No messages");
    }

    public void setLastMessagePreview(String preview) {
        LblChatMessages.setText(preview != null && preview.length() > 30 ? preview.substring(0, 27) + "..." : preview);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        lbItemID = new JLabel();
        PanelChatCard = new JPanel();
        PanelChatMessages = new JPanel();
        LblChatMessages = new JLabel();
        PanelChatUserName = new JPanel();
        LblChatUserName = new JLabel();

        lbItemID.setText("jLabel1");

        setBackground(new Color(168, 207, 182));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setMaximumSize(new Dimension(300, 1000));
        setMinimumSize(new Dimension(250, 350));
        setOpaque(false);
        setPreferredSize(new Dimension(500, 300));
        setLayout(new CardLayout());

        PanelChatCard.setBackground(new Color(255, 255, 255));
        PanelChatCard.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 10));
        PanelChatCard.setPreferredSize(new Dimension(500, 300));
        PanelChatCard.setLayout(new BoxLayout(PanelChatCard, BoxLayout.LINE_AXIS));

        PanelChatMessages.setBackground(new Color(255, 255, 255));
        PanelChatMessages.setOpaque(false);
        PanelChatMessages.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 30));

        LblChatMessages.setFont(new Font("Traditional Arabic", Font.BOLD, 24));
        LblChatMessages.setForeground(new Color(255, 51, 51));
        LblChatMessages.setText("No messages");
        PanelChatMessages.add(LblChatMessages);

        PanelChatCard.add(PanelChatMessages);

        PanelChatUserName.setBackground(new Color(255, 255, 255));
        PanelChatUserName.setOpaque(false);
        PanelChatUserName.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 30));

        LblChatUserName.setFont(new Font("Traditional Arabic", Font.BOLD, 24));
        LblChatUserName.setText("User");
        PanelChatUserName.add(LblChatUserName);

        PanelChatCard.add(PanelChatUserName);

        add(PanelChatCard, "card5");
    }

    private JLabel LblChatMessages;
    private JLabel LblChatUserName;
    private JPanel PanelChatCard;
    private JPanel PanelChatMessages;
    private JPanel PanelChatUserName;
    private JLabel lbItemID;
}
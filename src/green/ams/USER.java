
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams;

import static com.oracle.jrockit.jfr.ContentType.Timestamp;
import static green.ams.GLOBAL.bundle;
import green.ams.controllers.AttachementsController;
import green.ams.controllers.SampleController;
import green.ams.controllers.AreaController;
import green.ams.controllers.UserController;
import green.ams.components.RoundedBorder;
import green.ams.components.RequestArea;
import green.ams.components.ResponseArea;
import green.ams.components.StarRating;
import green.ams.components.WrapLayout;
import green.ams.components.CartItem;
import green.ams.models.Attachements;
import green.ams.models.Consultation;
import java.awt.image.BufferedImage;
import green.ams.models.SampleItem;
import green.ams.models.OrderItem;
import java.awt.HeadlessException;
import green.ams.models.Feedback;
import green.ams.models.Evaluate;
import green.ams.components.Item;
import green.ams.models.Request;
import green.ams.models.Response;
import green.ams.models.Sample;
import green.ams.models.Order;
import green.ams.models.User;
import green.ams.models.Area;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.SwingConstants;

/**
 *
 * @author Adham
 */
public class USER extends javax.swing.JFrame {

    /**
     * Creates new form APP
     *
     * @param language
     */
    // Validation patterns
    private static final Pattern PHONE_PATTERN = Pattern.compile("^[+]?[0-9]{10,13}$");

    // APP Frame Intialization
    APP app;

    // User Model Intializaition
    User user;

    // Area Model Intializaition
    Area area;

    // Attachements Model Intializaition
    Attachements attachements;

    // Request Model Intializaition
    Request request;

    // Evaluate Model Intializaition
    Evaluate evaluate;

    // Star Rating Component Intialization   
    StarRating ratingComponent;

    // Feedback Model Intializaition
    Feedback feedback;

    // Sample Model Intializaition
    Sample sample;

    // Sample Item Model Intializaition
    SampleItem sample_item;

    // Order Model Intializaition
    Order order;

    // Order Items Model Intializaition
    OrderItem order_item;

    // Consultation Model Intializaition
    Consultation consultation;

    // User Controller Intializaition
    UserController user_controller = new UserController();

    // Area Controller Intializaition
    AreaController area_controller = new AreaController();

    // Attachements Controller Intializaition
    AttachementsController attachements_controller = new AttachementsController();

    // Sample Controller Intialization
    SampleController sample_controller = new SampleController();

    // Current Date Intializaition
    Date current_date;

    private int orderNumber;

    private List<Request> requests_list;

    private List<Response> responses_list;

    private List<Sample> samples_list;

    private List<SampleItem> selectedItems;

    private List<SampleItem> samples_items_list;

    private List<CartItem> sample_item_panels;

    private String sample_category = "";

    private JFileChooser fileChooser;
    private File[] files;
    private File file;

    // Add these variables to the class declaration
    private JScrollPane chatScrollPane;
    private JPanel messagesPanel;
// Updated class variables
    private int lastMessageId = -1;
    private Set<Integer> displayedMessageIds = new HashSet<>();
    private Timer refreshTimer; // Now javax.swing.Timer
    private static final int MESSAGE_LIMIT = 50; // Load 50 messages initially
    private int oldestMessageId = -1; // Track oldest message for "Load More"

    public USER() {
        initComponents();

        Start();

        CustomeEdits();

        switchLanguage();

        setupChat();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DialogStarRating = new javax.swing.JDialog();
        ButtonsPanel = new javax.swing.JPanel();
        BtnRateSubmit = new javax.swing.JButton();
        BtnRateCancle = new javax.swing.JButton();
        GBtnPaymentMethod = new javax.swing.ButtonGroup();
        DialogSupport = new javax.swing.JDialog();
        PanelSupportContaiiner4 = new javax.swing.JPanel();
        LblSupport4 = new javax.swing.JLabel();
        PanelSupportForm4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        TFSupportTopic = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TASupportMessage = new javax.swing.JTextArea();
        PanelSupportButtons = new javax.swing.JPanel();
        BtnCancel = new javax.swing.JButton();
        BtnSupportSubmit = new javax.swing.JButton();
        PanelHome = new javax.swing.JPanel();
        BtnSupport = new javax.swing.JLabel();
        BtnUserProfile = new javax.swing.JLabel();
        BtnSettings = new javax.swing.JLabel();
        UserNavigation = new javax.swing.JPanel();
        nav_rate = new javax.swing.JLabel();
        nav_consultant = new javax.swing.JLabel();
        nav_sample = new javax.swing.JLabel();
        nav_location = new javax.swing.JLabel();
        PanelFeedback = new javax.swing.JPanel();
        FeedbackPanelHeader = new javax.swing.JPanel();
        PanelTitle = new javax.swing.JLabel();
        FormFeedback = new javax.swing.JPanel();
        PanelContainer = new javax.swing.JPanel();
        PanelLeft = new javax.swing.JPanel();
        LblMessage = new javax.swing.JLabel();
        ScrollPane = new javax.swing.JScrollPane();
        TAMessage = new javax.swing.JTextArea();
        PanelRight = new javax.swing.JPanel();
        LblName = new javax.swing.JLabel();
        TFFullName = new javax.swing.JTextField();
        LblEmailAddress = new javax.swing.JLabel();
        TFEmailAddress = new javax.swing.JTextField();
        LblPhone = new javax.swing.JLabel();
        TFPhone = new javax.swing.JTextField();
        PanelButtons = new javax.swing.JPanel();
        BtnSend = new javax.swing.JButton();
        BtnBack = new javax.swing.JButton();
        PanelUserProfile = new javax.swing.JPanel();
        FormUserProfile = new javax.swing.JPanel();
        PanelContainer1 = new javax.swing.JPanel();
        PanelLeft1 = new javax.swing.JPanel();
        LblScore = new javax.swing.JLabel();
        PanelRight1 = new javax.swing.JPanel();
        LblUserName = new javax.swing.JLabel();
        UPLblFullName = new javax.swing.JLabel();
        UPTFFullName = new javax.swing.JTextField();
        UPLblAddress = new javax.swing.JLabel();
        UPTFAddress = new javax.swing.JTextField();
        UPLblPhone = new javax.swing.JLabel();
        UPTFPhone = new javax.swing.JTextField();
        UPLblResetPassword = new javax.swing.JLabel();
        UPTFResetPassword = new javax.swing.JTextField();
        PanelButtons1 = new javax.swing.JPanel();
        BtnSave = new javax.swing.JButton();
        BtnBack1 = new javax.swing.JButton();
        PanelSettings = new javax.swing.JPanel();
        PanelSettingsHeader = new javax.swing.JPanel();
        PanelTitle5 = new javax.swing.JLabel();
        nav_back8 = new javax.swing.JLabel();
        PanelSeetingsBody = new javax.swing.JPanel();
        BtnDeleteAccount = new javax.swing.JButton();
        BtnSignOut = new javax.swing.JButton();
        PanelPublicLocations = new javax.swing.JPanel();
        PanelPublicLocationHeader = new javax.swing.JPanel();
        PanelTitle1 = new javax.swing.JLabel();
        nav_responses = new javax.swing.JLabel();
        FormPublicLocation = new javax.swing.JPanel();
        PanelContainer2 = new javax.swing.JPanel();
        PanelLeft2 = new javax.swing.JPanel();
        LblDescription = new javax.swing.JLabel();
        ScrollPane1 = new javax.swing.JScrollPane();
        TADescription = new javax.swing.JTextArea();
        CotainerBtnFile = new javax.swing.JPanel();
        BtnChooseImages = new javax.swing.JButton();
        LblImages = new javax.swing.JLabel();
        PanelRight2 = new javax.swing.JPanel();
        LblRegionName = new javax.swing.JLabel();
        TFRegionName = new javax.swing.JTextField();
        LblAddress = new javax.swing.JLabel();
        TFAddress = new javax.swing.JTextField();
        LblLandArea = new javax.swing.JLabel();
        TFLandArea = new javax.swing.JTextField();
        PanelButtons2 = new javax.swing.JPanel();
        BtnSend1 = new javax.swing.JButton();
        BtnBack2 = new javax.swing.JButton();
        PanelResponsesAreas = new javax.swing.JPanel();
        ResponsesPanelHeader = new javax.swing.JPanel();
        PanelTitle4 = new javax.swing.JLabel();
        nav_back5 = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        ScrollResponsesPane = new javax.swing.JScrollPane();
        PanelResponsesItem = new green.ams.components.PanelItem();
        responseArea1 = new green.ams.components.ResponseArea();
        PanelSample = new javax.swing.JPanel();
        PanelSamplesHeader = new javax.swing.JPanel();
        PanelTitle2 = new javax.swing.JLabel();
        nav_back4 = new javax.swing.JLabel();
        PanelSamplesContainer = new javax.swing.JPanel();
        LblTruckIcon = new javax.swing.JLabel();
        SamplesNavigation = new javax.swing.JPanel();
        nav_suggested_samples = new javax.swing.JLabel();
        nav_suggested_outdoor = new javax.swing.JLabel();
        nav_suggested_indoor1 = new javax.swing.JLabel();
        PanelSamples = new javax.swing.JPanel();
        PanelNavHeader = new javax.swing.JPanel();
        PanelLeavesImage = new javax.swing.JLabel();
        PanelSamplesTitle = new javax.swing.JPanel();
        LblSamplesTitle = new javax.swing.JLabel();
        nav_back2 = new javax.swing.JLabel();
        PanelNavContainer = new javax.swing.JPanel();
        nav_indoor_plants = new javax.swing.JLabel();
        nav_trees = new javax.swing.JLabel();
        nav_fruits_vegetables = new javax.swing.JLabel();
        nav_flowers = new javax.swing.JLabel();
        PanelSamplesShop = new javax.swing.JPanel();
        PanelSamplesShopHeader = new javax.swing.JPanel();
        nav_back1 = new javax.swing.JLabel();
        LblSampleShopTitle = new javax.swing.JLabel();
        nav_cart1 = new javax.swing.JLabel();
        PanelSamplesShopContainer = new javax.swing.JPanel();
        ScrollSamplesPane = new javax.swing.JScrollPane();
        PanelSamplesItem = new green.ams.components.PanelItem();
        item1 = new green.ams.components.Item();
        PanelBottom = new javax.swing.JPanel();
        PanelSamplesCart = new javax.swing.JPanel();
        PanelSamplesCartHeader = new javax.swing.JPanel();
        nav_back6 = new javax.swing.JLabel();
        LblSampleShopTitle1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BtnCartClear = new javax.swing.JButton();
        BtnCartRefresh = new javax.swing.JButton();
        PanelSamplesCartContainer = new javax.swing.JPanel();
        ScrollSamplesPane1 = new javax.swing.JScrollPane();
        PanelSamplesCartItem = new green.ams.components.PanelItem();
        cartItem = new green.ams.components.CartItem();
        PanelBottom1 = new javax.swing.JPanel();
        BtnPay = new javax.swing.JButton();
        PanelPlaceOrder = new javax.swing.JPanel();
        PanelPlaceOrderHeader = new javax.swing.JPanel();
        LblSampleShopTitle2 = new javax.swing.JLabel();
        PanelPlaceOrderContainer = new javax.swing.JPanel();
        PanelPaymentMethod = new javax.swing.JPanel();
        RBtnApplyPay = new javax.swing.JRadioButton();
        RBtnCash = new javax.swing.JRadioButton();
        PanelOrderDetails = new javax.swing.JPanel();
        LblOrderTotalAmount1 = new javax.swing.JLabel();
        LblOrignalCost = new javax.swing.JLabel();
        LblOrderTotalAmount = new javax.swing.JLabel();
        LblDiscountCost = new javax.swing.JLabel();
        PanelOrderCoupon = new javax.swing.JPanel();
        LblCoupon = new javax.swing.JLabel();
        PanelBottom2 = new javax.swing.JPanel();
        LblApplePay = new javax.swing.JLabel();
        PanelThanks = new javax.swing.JPanel();
        PanelPlaceOrderContainer1 = new javax.swing.JPanel();
        nav_back7 = new javax.swing.JLabel();
        pictureBox1 = new green.ams.components.PictureBox();
        LblOrderNumber2 = new javax.swing.JLabel();
        LblOrderNumber1 = new javax.swing.JLabel();
        PanelBottom3 = new javax.swing.JPanel();
        LblOrderNumber = new javax.swing.JLabel();
        PanelConsultant = new javax.swing.JPanel();
        PanelConsultantHeader = new javax.swing.JPanel();
        PanelTitle3 = new javax.swing.JLabel();
        nav_back3 = new javax.swing.JLabel();
        PanelConsultantionContainer = new javax.swing.JPanel();
        PanelControllers1 = new javax.swing.JPanel();
        LblConsultationTopic = new javax.swing.JLabel();
        TFConsultationTopic = new javax.swing.JTextField();
        BtnTopic = new javax.swing.JButton();
        PanelChatBody = new javax.swing.JPanel();
        PanelControllers = new javax.swing.JPanel();
        TFMessage = new javax.swing.JTextField();
        BtnMessageSend = new green.ams.components.GButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("green/ams/Bundle"); // NOI18N
        DialogStarRating.setTitle(bundle.getString("USER.DialogStarRating.title")); // NOI18N
        DialogStarRating.setBackground(new java.awt.Color(245, 255, 243));
        DialogStarRating.setLocation(new java.awt.Point(733, 334));
        DialogStarRating.setMaximumSize(new java.awt.Dimension(400, 300));
        DialogStarRating.setResizable(false);
        DialogStarRating.setSize(new java.awt.Dimension(400, 200));
        DialogStarRating.setType(java.awt.Window.Type.POPUP);

        ButtonsPanel.setBackground(new java.awt.Color(245, 255, 243));

        BtnRateSubmit.setBackground(new java.awt.Color(33, 104, 73));
        BtnRateSubmit.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        BtnRateSubmit.setForeground(new java.awt.Color(255, 255, 255));
        BtnRateSubmit.setText(bundle.getString("USER.BtnRateSubmit.text")); // NOI18N
        BtnRateSubmit.setAlignmentY(0.0F);
        BtnRateSubmit.setBorder(null);
        BtnRateSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnRateSubmit.setDefaultCapable(false);
        BtnRateSubmit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnRateSubmit.setMaximumSize(new java.awt.Dimension(80, 30));
        BtnRateSubmit.setMinimumSize(new java.awt.Dimension(40, 15));
        BtnRateSubmit.setPreferredSize(new java.awt.Dimension(100, 40));
        BtnRateSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRateSubmitActionPerformed(evt);
            }
        });
        ButtonsPanel.add(BtnRateSubmit);

        BtnRateCancle.setBackground(new java.awt.Color(121, 110, 113));
        BtnRateCancle.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        BtnRateCancle.setForeground(new java.awt.Color(255, 255, 255));
        BtnRateCancle.setText(bundle.getString("USER.BtnRateCancle.text")); // NOI18N
        BtnRateCancle.setAlignmentY(0.0F);
        BtnRateCancle.setBorder(null);
        BtnRateCancle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnRateCancle.setDefaultCapable(false);
        BtnRateCancle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnRateCancle.setMaximumSize(new java.awt.Dimension(80, 30));
        BtnRateCancle.setMinimumSize(new java.awt.Dimension(40, 15));
        BtnRateCancle.setPreferredSize(new java.awt.Dimension(100, 40));
        BtnRateCancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRateCancleActionPerformed(evt);
            }
        });
        ButtonsPanel.add(BtnRateCancle);

        DialogStarRating.getContentPane().add(ButtonsPanel, java.awt.BorderLayout.PAGE_END);

        DialogStarRating.getAccessibleContext().setAccessibleParent(null);

        DialogSupport.setTitle(bundle.getString("USER.DialogSupport.title")); // NOI18N
        DialogSupport.setBackground(new java.awt.Color(245, 255, 243));
        DialogSupport.setLocation(new java.awt.Point(733, 334));
        DialogSupport.setResizable(false);
        DialogSupport.setSize(new java.awt.Dimension(400, 300));
        DialogSupport.setType(java.awt.Window.Type.POPUP);

        PanelSupportContaiiner4.setBackground(new java.awt.Color(245, 255, 243));
        PanelSupportContaiiner4.setLayout(new java.awt.BorderLayout());

        LblSupport4.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblSupport4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblSupport4.setText(bundle.getString("USER.LblSupport.text")); // NOI18N
        PanelSupportContaiiner4.add(LblSupport4, java.awt.BorderLayout.PAGE_START);

        PanelSupportForm4.setBackground(new java.awt.Color(255, 255, 255));
        PanelSupportForm4.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        PanelSupportForm4.setOpaque(false);
        PanelSupportForm4.setLayout(new java.awt.GridLayout(2, 0, 50, 20));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setOpaque(false);

        TFSupportTopic.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        TFSupportTopic.setText(bundle.getString("USER.TFSupportTopic.text")); // NOI18N
        TFSupportTopic.setPreferredSize(new java.awt.Dimension(250, 35));
        TFSupportTopic.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TFSupportTopicFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(TFSupportTopic, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(30, Short.MAX_VALUE)
                    .addComponent(TFSupportTopic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(31, Short.MAX_VALUE)))
        );

        PanelSupportForm4.add(jPanel5);

        TASupportMessage.setColumns(20);
        TASupportMessage.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        TASupportMessage.setLineWrap(true);
        TASupportMessage.setRows(5);
        TASupportMessage.setText(bundle.getString("USER.TASupportMessage.text")); // NOI18N
        TASupportMessage.setWrapStyleWord(true);
        TASupportMessage.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TASupportMessageFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(TASupportMessage);

        PanelSupportForm4.add(jScrollPane1);

        PanelSupportContaiiner4.add(PanelSupportForm4, java.awt.BorderLayout.CENTER);

        PanelSupportButtons.setBackground(new java.awt.Color(255, 255, 255));
        PanelSupportButtons.setOpaque(false);
        PanelSupportButtons.setPreferredSize(new java.awt.Dimension(400, 50));

        BtnCancel.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        BtnCancel.setText(bundle.getString("USER.BtnCancel.text")); // NOI18N
        BtnCancel.setActionCommand(bundle.getString("USER.BtnCancel.actionCommand")); // NOI18N
        BtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelActionPerformed(evt);
            }
        });

        BtnSupportSubmit.setBackground(new java.awt.Color(102, 153, 0));
        BtnSupportSubmit.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        BtnSupportSubmit.setForeground(new java.awt.Color(255, 255, 255));
        BtnSupportSubmit.setText(bundle.getString("USER.BtnSupportSubmit.text")); // NOI18N
        BtnSupportSubmit.setActionCommand(bundle.getString("USER.BtnSupportSubmit.actionCommand")); // NOI18N
        BtnSupportSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSupportSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelSupportButtonsLayout = new javax.swing.GroupLayout(PanelSupportButtons);
        PanelSupportButtons.setLayout(PanelSupportButtonsLayout);
        PanelSupportButtonsLayout.setHorizontalGroup(
            PanelSupportButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSupportButtonsLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(BtnSupportSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnCancel)
                .addContainerGap(147, Short.MAX_VALUE))
        );
        PanelSupportButtonsLayout.setVerticalGroup(
            PanelSupportButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSupportButtonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelSupportButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCancel)
                    .addComponent(BtnSupportSubmit))
                .addGap(34, 34, 34))
        );

        PanelSupportContaiiner4.add(PanelSupportButtons, java.awt.BorderLayout.PAGE_END);

        DialogSupport.getContentPane().add(PanelSupportContaiiner4, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(bundle.getString("USER.title")); // NOI18N
        setBackground(new java.awt.Color(237, 233, 224));
        setForeground(new java.awt.Color(237, 233, 224));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setName("AppJFrame"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        PanelHome.setBackground(new java.awt.Color(245, 255, 243));
        PanelHome.setMaximumSize(new java.awt.Dimension(1366, 768));
        PanelHome.setMinimumSize(new java.awt.Dimension(1366, 768));
        PanelHome.setPreferredSize(new java.awt.Dimension(1366, 768));
        PanelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnSupport.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        BtnSupport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/support-removebg-preview.png"))); // NOI18N
        BtnSupport.setText(bundle.getString("USER.BtnSupport.text")); // NOI18N
        BtnSupport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSupport.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        BtnSupport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnSupportMouseClicked(evt);
            }
        });
        PanelHome.add(BtnSupport, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 668, 280, 60));

        BtnUserProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/user-profile-removebg-preview.png"))); // NOI18N
        BtnUserProfile.setText(bundle.getString("USER.BtnUserProfile.text")); // NOI18N
        BtnUserProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnUserProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnUserProfileMouseClicked(evt);
            }
        });
        PanelHome.add(BtnUserProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 10, 70, 60));

        BtnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/settings-removebg-preview.png"))); // NOI18N
        BtnSettings.setText(bundle.getString("USER.BtnSettings.text")); // NOI18N
        BtnSettings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnSettingsMouseClicked(evt);
            }
        });
        PanelHome.add(BtnSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 10, 70, 60));

        UserNavigation.setBackground(new java.awt.Color(245, 255, 243));
        UserNavigation.setMinimumSize(new java.awt.Dimension(500, 500));
        UserNavigation.setPreferredSize(new java.awt.Dimension(1350, 330));
        UserNavigation.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 20));

        nav_rate.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        nav_rate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/rate-removebg-preview.png"))); // NOI18N
        nav_rate.setText(bundle.getString("USER.nav_rate.text")); // NOI18N
        nav_rate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_rate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nav_rate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nav_rate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_rateMouseClicked(evt);
            }
        });
        UserNavigation.add(nav_rate);

        nav_consultant.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        nav_consultant.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/consultant-removebg-preview.png"))); // NOI18N
        nav_consultant.setText(bundle.getString("USER.nav_consultant.text")); // NOI18N
        nav_consultant.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_consultant.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nav_consultant.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nav_consultant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_consultantMouseClicked(evt);
            }
        });
        UserNavigation.add(nav_consultant);

        nav_sample.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        nav_sample.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/sample-removebg-preview.png"))); // NOI18N
        nav_sample.setText(bundle.getString("USER.nav_sample.text")); // NOI18N
        nav_sample.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_sample.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nav_sample.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nav_sample.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_sampleMouseClicked(evt);
            }
        });
        UserNavigation.add(nav_sample);

        nav_location.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        nav_location.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/location-removebg-preview.png"))); // NOI18N
        nav_location.setText(bundle.getString("USER.nav_location.text")); // NOI18N
        nav_location.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_location.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nav_location.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nav_location.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_locationMouseClicked(evt);
            }
        });
        UserNavigation.add(nav_location);

        PanelHome.add(UserNavigation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 1350, -1));

        getContentPane().add(PanelHome);
        PanelHome.setBounds(0, 0, 1366, 730);

        PanelFeedback.setBackground(new java.awt.Color(245, 255, 243));
        PanelFeedback.setEnabled(false);
        PanelFeedback.setMaximumSize(new java.awt.Dimension(1366, 768));
        PanelFeedback.setMinimumSize(new java.awt.Dimension(1366, 768));
        PanelFeedback.setPreferredSize(new java.awt.Dimension(1366, 768));
        PanelFeedback.setLayout(new java.awt.BorderLayout(0, 30));

        FeedbackPanelHeader.setBackground(new java.awt.Color(203, 225, 196));
        FeedbackPanelHeader.setPreferredSize(new java.awt.Dimension(1366, 50));
        FeedbackPanelHeader.setLayout(new java.awt.BorderLayout());

        PanelTitle.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        PanelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelTitle.setText(bundle.getString("USER.PanelTitle.text")); // NOI18N
        FeedbackPanelHeader.add(PanelTitle, java.awt.BorderLayout.PAGE_START);

        PanelFeedback.add(FeedbackPanelHeader, java.awt.BorderLayout.PAGE_START);

        FormFeedback.setMaximumSize(new java.awt.Dimension(1366, 768));
        FormFeedback.setMinimumSize(new java.awt.Dimension(100, 100));
        FormFeedback.setPreferredSize(new java.awt.Dimension(1366, 300));
        FormFeedback.setLayout(new java.awt.BorderLayout());

        PanelContainer.setBackground(new java.awt.Color(245, 255, 243));
        PanelContainer.setMaximumSize(new java.awt.Dimension(1366, 768));
        PanelContainer.setMinimumSize(new java.awt.Dimension(100, 100));
        PanelContainer.setPreferredSize(new java.awt.Dimension(768, 100));

        PanelLeft.setBackground(new java.awt.Color(245, 255, 243));
        PanelLeft.setMaximumSize(new java.awt.Dimension(1366, 768));
        PanelLeft.setMinimumSize(new java.awt.Dimension(100, 100));
        PanelLeft.setPreferredSize(new java.awt.Dimension(500, 400));
        PanelLeft.setLayout(new java.awt.BorderLayout());

        LblMessage.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblMessage.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblMessage.setText(bundle.getString("USER.LblMessage.text")); // NOI18N
        PanelLeft.add(LblMessage, java.awt.BorderLayout.PAGE_START);

        ScrollPane.setMaximumSize(new java.awt.Dimension(300, 300));
        ScrollPane.setPreferredSize(new java.awt.Dimension(300, 200));

        TAMessage.setColumns(20);
        TAMessage.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        TAMessage.setLineWrap(true);
        TAMessage.setRows(5);
        TAMessage.setWrapStyleWord(true);
        TAMessage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(33, 104, 73), 3, true));
        TAMessage.setMaximumSize(new java.awt.Dimension(300, 300));
        TAMessage.setPreferredSize(new java.awt.Dimension(300, 200));
        ScrollPane.setViewportView(TAMessage);

        PanelLeft.add(ScrollPane, java.awt.BorderLayout.CENTER);

        PanelRight.setBackground(new java.awt.Color(245, 255, 243));
        PanelRight.setPreferredSize(new java.awt.Dimension(500, 400));
        PanelRight.setLayout(new java.awt.GridLayout(8, 0, 0, 5));

        LblName.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblName.setText(bundle.getString("USER.LblName.text")); // NOI18N
        PanelRight.add(LblName);

        TFFullName.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        TFFullName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TFFullName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(33, 104, 73), 3, true));
        TFFullName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        TFFullName.setMaximumSize(new java.awt.Dimension(100, 200));
        PanelRight.add(TFFullName);

        LblEmailAddress.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblEmailAddress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblEmailAddress.setText(bundle.getString("USER.LblEmailAddress.text")); // NOI18N
        PanelRight.add(LblEmailAddress);

        TFEmailAddress.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        TFEmailAddress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TFEmailAddress.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(33, 104, 73), 3, true));
        TFEmailAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        PanelRight.add(TFEmailAddress);

        LblPhone.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblPhone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblPhone.setText(bundle.getString("USER.LblPhone.text")); // NOI18N
        PanelRight.add(LblPhone);

        TFPhone.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        TFPhone.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TFPhone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(33, 104, 73), 3, true));
        TFPhone.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        PanelRight.add(TFPhone);

        PanelButtons.setBackground(new java.awt.Color(245, 255, 243));

        BtnSend.setBackground(new java.awt.Color(33, 104, 73));
        BtnSend.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        BtnSend.setForeground(new java.awt.Color(255, 255, 255));
        BtnSend.setText(bundle.getString("USER.BtnSend.text")); // NOI18N
        BtnSend.setAlignmentY(0.0F);
        BtnSend.setBorder(null);
        BtnSend.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSend.setDefaultCapable(false);
        BtnSend.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnSend.setMaximumSize(new java.awt.Dimension(80, 30));
        BtnSend.setMinimumSize(new java.awt.Dimension(40, 15));
        BtnSend.setPreferredSize(new java.awt.Dimension(100, 40));
        BtnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSendActionPerformed(evt);
            }
        });
        PanelButtons.add(BtnSend);

        BtnBack.setBackground(new java.awt.Color(121, 110, 113));
        BtnBack.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        BtnBack.setForeground(new java.awt.Color(255, 255, 255));
        BtnBack.setText(bundle.getString("USER.BtnBack.text")); // NOI18N
        BtnBack.setAlignmentY(0.0F);
        BtnBack.setBorder(null);
        BtnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBack.setDefaultCapable(false);
        BtnBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnBack.setMaximumSize(new java.awt.Dimension(80, 30));
        BtnBack.setMinimumSize(new java.awt.Dimension(40, 15));
        BtnBack.setPreferredSize(new java.awt.Dimension(100, 40));
        BtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBackActionPerformed(evt);
            }
        });
        PanelButtons.add(BtnBack);

        javax.swing.GroupLayout PanelContainerLayout = new javax.swing.GroupLayout(PanelContainer);
        PanelContainer.setLayout(PanelContainerLayout);
        PanelContainerLayout.setHorizontalGroup(
            PanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContainerLayout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(PanelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(PanelRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContainerLayout.createSequentialGroup()
                .addComponent(PanelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 1366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelContainerLayout.setVerticalGroup(
            PanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addComponent(PanelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        FormFeedback.add(PanelContainer, java.awt.BorderLayout.CENTER);

        PanelFeedback.add(FormFeedback, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanelFeedback);
        PanelFeedback.setBounds(0, 0, 1366, 730);

        PanelUserProfile.setBackground(new java.awt.Color(245, 255, 243));
        PanelUserProfile.setAlignmentX(0.15F);
        PanelUserProfile.setEnabled(false);
        PanelUserProfile.setMaximumSize(new java.awt.Dimension(1366, 768));
        PanelUserProfile.setMinimumSize(new java.awt.Dimension(1366, 768));
        PanelUserProfile.setPreferredSize(new java.awt.Dimension(1366, 768));
        PanelUserProfile.setLayout(new java.awt.BorderLayout(0, 30));

        FormUserProfile.setBackground(new java.awt.Color(245, 255, 243));
        FormUserProfile.setMaximumSize(new java.awt.Dimension(1366, 768));
        FormUserProfile.setPreferredSize(new java.awt.Dimension(1366, 300));
        FormUserProfile.setLayout(new javax.swing.BoxLayout(FormUserProfile, javax.swing.BoxLayout.PAGE_AXIS));

        PanelContainer1.setBackground(new java.awt.Color(245, 255, 243));
        PanelContainer1.setMaximumSize(new java.awt.Dimension(1366, 768));
        PanelContainer1.setMinimumSize(new java.awt.Dimension(100, 100));
        PanelContainer1.setPreferredSize(new java.awt.Dimension(768, 646));
        PanelContainer1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 20));

        PanelLeft1.setBackground(new java.awt.Color(245, 255, 243));
        PanelLeft1.setPreferredSize(new java.awt.Dimension(500, 500));
        PanelLeft1.setLayout(new java.awt.BorderLayout());

        LblScore.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblScore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/score-removebg-preview.png"))); // NOI18N
        LblScore.setText(bundle.getString("USER.LblScore.text")); // NOI18N
        LblScore.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        LblScore.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LblScore.setMinimumSize(new java.awt.Dimension(50, 110));
        LblScore.setPreferredSize(new java.awt.Dimension(50, 110));
        LblScore.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PanelLeft1.add(LblScore, java.awt.BorderLayout.PAGE_START);

        PanelContainer1.add(PanelLeft1);

        PanelRight1.setBackground(new java.awt.Color(245, 255, 243));
        PanelRight1.setMinimumSize(new java.awt.Dimension(500, 725));
        PanelRight1.setPreferredSize(new java.awt.Dimension(500, 600));
        PanelRight1.setRequestFocusEnabled(false);
        PanelRight1.setLayout(new java.awt.GridLayout(10, 0, 10, 5));

        LblUserName.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        LblUserName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblUserName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/user-profile-removebg-preview.png"))); // NOI18N
        LblUserName.setText(bundle.getString("USER.LblUserName.text")); // NOI18N
        LblUserName.setAlignmentX(0.5F);
        LblUserName.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        PanelRight1.add(LblUserName);

        UPLblFullName.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        UPLblFullName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        UPLblFullName.setText(bundle.getString("USER.UPLblFullName.text")); // NOI18N
        PanelRight1.add(UPLblFullName);

        UPTFFullName.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        UPTFFullName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        UPTFFullName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(33, 104, 73), 3, true));
        UPTFFullName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        UPTFFullName.setMaximumSize(new java.awt.Dimension(100, 200));
        PanelRight1.add(UPTFFullName);

        UPLblAddress.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        UPLblAddress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        UPLblAddress.setText(bundle.getString("USER.UPLblAddress.text")); // NOI18N
        PanelRight1.add(UPLblAddress);

        UPTFAddress.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        UPTFAddress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        UPTFAddress.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(33, 104, 73), 3, true));
        UPTFAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        PanelRight1.add(UPTFAddress);

        UPLblPhone.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        UPLblPhone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        UPLblPhone.setText(bundle.getString("USER.UPLblPhone.text")); // NOI18N
        PanelRight1.add(UPLblPhone);

        UPTFPhone.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        UPTFPhone.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        UPTFPhone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(33, 104, 73), 3, true));
        UPTFPhone.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        PanelRight1.add(UPTFPhone);

        UPLblResetPassword.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        UPLblResetPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        UPLblResetPassword.setText(bundle.getString("USER.UPLblResetPassword.text")); // NOI18N
        PanelRight1.add(UPLblResetPassword);

        UPTFResetPassword.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        UPTFResetPassword.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        UPTFResetPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(33, 104, 73), 3, true));
        UPTFResetPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        PanelRight1.add(UPTFResetPassword);

        PanelContainer1.add(PanelRight1);

        FormUserProfile.add(PanelContainer1);

        PanelButtons1.setBackground(new java.awt.Color(245, 255, 243));

        BtnSave.setBackground(new java.awt.Color(33, 104, 73));
        BtnSave.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        BtnSave.setForeground(new java.awt.Color(255, 255, 255));
        BtnSave.setText(bundle.getString("USER.BtnSave.text")); // NOI18N
        BtnSave.setAlignmentY(0.0F);
        BtnSave.setBorder(null);
        BtnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSave.setDefaultCapable(false);
        BtnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnSave.setMaximumSize(new java.awt.Dimension(80, 30));
        BtnSave.setMinimumSize(new java.awt.Dimension(40, 15));
        BtnSave.setPreferredSize(new java.awt.Dimension(100, 40));
        BtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaveActionPerformed(evt);
            }
        });
        PanelButtons1.add(BtnSave);

        BtnBack1.setBackground(new java.awt.Color(121, 110, 113));
        BtnBack1.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        BtnBack1.setForeground(new java.awt.Color(255, 255, 255));
        BtnBack1.setText(bundle.getString("USER.BtnBack1.text")); // NOI18N
        BtnBack1.setAlignmentY(0.0F);
        BtnBack1.setBorder(null);
        BtnBack1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBack1.setDefaultCapable(false);
        BtnBack1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnBack1.setMaximumSize(new java.awt.Dimension(80, 30));
        BtnBack1.setMinimumSize(new java.awt.Dimension(40, 15));
        BtnBack1.setPreferredSize(new java.awt.Dimension(100, 40));
        BtnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBack1ActionPerformed(evt);
            }
        });
        PanelButtons1.add(BtnBack1);

        FormUserProfile.add(PanelButtons1);

        PanelUserProfile.add(FormUserProfile, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanelUserProfile);
        PanelUserProfile.setBounds(0, 0, 1366, 768);

        PanelSettings.setBackground(new java.awt.Color(245, 255, 243));
        PanelSettings.setAlignmentX(0.15F);
        PanelSettings.setEnabled(false);
        PanelSettings.setMaximumSize(new java.awt.Dimension(1366, 768));
        PanelSettings.setMinimumSize(new java.awt.Dimension(1366, 768));
        PanelSettings.setPreferredSize(new java.awt.Dimension(1366, 768));
        PanelSettings.setLayout(new java.awt.BorderLayout(0, 30));

        PanelSettingsHeader.setBackground(new java.awt.Color(203, 225, 196));
        PanelSettingsHeader.setPreferredSize(new java.awt.Dimension(1366, 50));
        PanelSettingsHeader.setLayout(new java.awt.BorderLayout());

        PanelTitle5.setBackground(new java.awt.Color(203, 225, 196));
        PanelTitle5.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        PanelTitle5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelTitle5.setText(bundle.getString("USER.PanelTitle5.text")); // NOI18N
        PanelSettingsHeader.add(PanelTitle5, java.awt.BorderLayout.CENTER);

        nav_back8.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        nav_back8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/back-icon-removebg-preview.png"))); // NOI18N
        nav_back8.setText(bundle.getString("USER.nav_back8.text")); // NOI18N
        nav_back8.setAlignmentX(0.5F);
        nav_back8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 20));
        nav_back8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_back8.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        nav_back8.setMaximumSize(new java.awt.Dimension(122, 100));
        nav_back8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_back8MouseClicked(evt);
            }
        });
        PanelSettingsHeader.add(nav_back8, java.awt.BorderLayout.LINE_END);

        PanelSettings.add(PanelSettingsHeader, java.awt.BorderLayout.PAGE_START);

        PanelSeetingsBody.setBackground(new java.awt.Color(255, 255, 255));
        PanelSeetingsBody.setOpaque(false);

        BtnDeleteAccount.setBackground(new java.awt.Color(255, 51, 51));
        BtnDeleteAccount.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        BtnDeleteAccount.setForeground(new java.awt.Color(255, 255, 255));
        BtnDeleteAccount.setText(bundle.getString("USER.BtnDeleteAccount.text")); // NOI18N
        BtnDeleteAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnDeleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteAccountActionPerformed(evt);
            }
        });

        BtnSignOut.setBackground(new java.awt.Color(204, 255, 204));
        BtnSignOut.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        BtnSignOut.setText(bundle.getString("USER.BtnSignOut.text")); // NOI18N
        BtnSignOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSignOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelSeetingsBodyLayout = new javax.swing.GroupLayout(PanelSeetingsBody);
        PanelSeetingsBody.setLayout(PanelSeetingsBodyLayout);
        PanelSeetingsBodyLayout.setHorizontalGroup(
            PanelSeetingsBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSeetingsBodyLayout.createSequentialGroup()
                .addGap(484, 484, 484)
                .addGroup(PanelSeetingsBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnDeleteAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(486, Short.MAX_VALUE))
        );
        PanelSeetingsBodyLayout.setVerticalGroup(
            PanelSeetingsBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSeetingsBodyLayout.createSequentialGroup()
                .addContainerGap(257, Short.MAX_VALUE)
                .addComponent(BtnDeleteAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(BtnSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262))
        );

        PanelSettings.add(PanelSeetingsBody, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanelSettings);
        PanelSettings.setBounds(0, 0, 1366, 768);

        PanelPublicLocations.setBackground(new java.awt.Color(245, 255, 243));
        PanelPublicLocations.setEnabled(false);
        PanelPublicLocations.setMaximumSize(new java.awt.Dimension(1366, 768));
        PanelPublicLocations.setMinimumSize(new java.awt.Dimension(1366, 768));
        PanelPublicLocations.setPreferredSize(new java.awt.Dimension(1366, 768));
        PanelPublicLocations.setLayout(new java.awt.BorderLayout(0, 30));

        PanelPublicLocationHeader.setBackground(new java.awt.Color(203, 225, 196));
        PanelPublicLocationHeader.setPreferredSize(new java.awt.Dimension(1366, 50));
        PanelPublicLocationHeader.setLayout(new java.awt.BorderLayout());

        PanelTitle1.setBackground(new java.awt.Color(203, 225, 196));
        PanelTitle1.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        PanelTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelTitle1.setText(bundle.getString("USER.PanelTitle1.text")); // NOI18N
        PanelPublicLocationHeader.add(PanelTitle1, java.awt.BorderLayout.CENTER);

        nav_responses.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        nav_responses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/requests.png"))); // NOI18N
        nav_responses.setText(bundle.getString("USER.nav_responses.text")); // NOI18N
        nav_responses.setAlignmentX(0.5F);
        nav_responses.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        nav_responses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_responses.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        nav_responses.setMaximumSize(new java.awt.Dimension(122, 100));
        nav_responses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_responsesMouseClicked(evt);
            }
        });
        PanelPublicLocationHeader.add(nav_responses, java.awt.BorderLayout.LINE_START);

        PanelPublicLocations.add(PanelPublicLocationHeader, java.awt.BorderLayout.PAGE_START);

        FormPublicLocation.setMaximumSize(new java.awt.Dimension(1366, 768));
        FormPublicLocation.setPreferredSize(new java.awt.Dimension(1366, 300));
        FormPublicLocation.setLayout(new java.awt.BorderLayout());

        PanelContainer2.setBackground(new java.awt.Color(245, 255, 243));
        PanelContainer2.setMaximumSize(new java.awt.Dimension(1366, 768));
        PanelContainer2.setMinimumSize(new java.awt.Dimension(100, 100));
        PanelContainer2.setPreferredSize(new java.awt.Dimension(768, 100));

        PanelLeft2.setBackground(new java.awt.Color(245, 255, 243));
        PanelLeft2.setMaximumSize(new java.awt.Dimension(1366, 768));
        PanelLeft2.setMinimumSize(new java.awt.Dimension(100, 100));
        PanelLeft2.setPreferredSize(new java.awt.Dimension(500, 400));
        PanelLeft2.setLayout(new java.awt.BorderLayout(0, 20));

        LblDescription.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblDescription.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblDescription.setText(bundle.getString("USER.LblDescription.text")); // NOI18N
        PanelLeft2.add(LblDescription, java.awt.BorderLayout.PAGE_START);

        ScrollPane1.setMaximumSize(new java.awt.Dimension(300, 300));
        ScrollPane1.setPreferredSize(new java.awt.Dimension(300, 200));

        TADescription.setColumns(20);
        TADescription.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        TADescription.setLineWrap(true);
        TADescription.setRows(5);
        TADescription.setWrapStyleWord(true);
        TADescription.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(33, 104, 73), 3, true));
        TADescription.setMaximumSize(new java.awt.Dimension(300, 300));
        TADescription.setPreferredSize(new java.awt.Dimension(300, 200));
        ScrollPane1.setViewportView(TADescription);

        PanelLeft2.add(ScrollPane1, java.awt.BorderLayout.CENTER);

        CotainerBtnFile.setBackground(new java.awt.Color(245, 255, 243));
        CotainerBtnFile.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        BtnChooseImages.setBackground(new java.awt.Color(161, 164, 151));
        BtnChooseImages.setFont(new java.awt.Font("Traditional Arabic", 0, 14)); // NOI18N
        BtnChooseImages.setForeground(new java.awt.Color(255, 255, 255));
        BtnChooseImages.setText(bundle.getString("USER.BtnChooseImages.text")); // NOI18N
        BtnChooseImages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnChooseImagesActionPerformed(evt);
            }
        });
        CotainerBtnFile.add(BtnChooseImages);

        LblImages.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblImages.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblImages.setText(bundle.getString("USER.LblImages.text")); // NOI18N
        CotainerBtnFile.add(LblImages);

        PanelLeft2.add(CotainerBtnFile, java.awt.BorderLayout.PAGE_END);

        PanelRight2.setBackground(new java.awt.Color(245, 255, 243));
        PanelRight2.setPreferredSize(new java.awt.Dimension(500, 400));
        PanelRight2.setLayout(new java.awt.GridLayout(8, 0, 0, 5));

        LblRegionName.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblRegionName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblRegionName.setText(bundle.getString("USER.LblRegionName.text")); // NOI18N
        PanelRight2.add(LblRegionName);

        TFRegionName.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        TFRegionName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TFRegionName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(33, 104, 73), 3, true));
        TFRegionName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        TFRegionName.setMaximumSize(new java.awt.Dimension(100, 200));
        TFRegionName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFRegionNameActionPerformed(evt);
            }
        });
        PanelRight2.add(TFRegionName);

        LblAddress.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblAddress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblAddress.setText(bundle.getString("USER.LblAddress.text")); // NOI18N
        PanelRight2.add(LblAddress);

        TFAddress.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        TFAddress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TFAddress.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(33, 104, 73), 3, true));
        TFAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        PanelRight2.add(TFAddress);

        LblLandArea.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblLandArea.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblLandArea.setText(bundle.getString("USER.LblLandArea.text")); // NOI18N
        PanelRight2.add(LblLandArea);

        TFLandArea.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        TFLandArea.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TFLandArea.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(33, 104, 73), 3, true));
        TFLandArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        PanelRight2.add(TFLandArea);

        PanelButtons2.setBackground(new java.awt.Color(245, 255, 243));

        BtnSend1.setBackground(new java.awt.Color(33, 104, 73));
        BtnSend1.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        BtnSend1.setForeground(new java.awt.Color(255, 255, 255));
        BtnSend1.setText(bundle.getString("USER.BtnSend1.text")); // NOI18N
        BtnSend1.setAlignmentY(0.0F);
        BtnSend1.setBorder(null);
        BtnSend1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSend1.setDefaultCapable(false);
        BtnSend1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnSend1.setMaximumSize(new java.awt.Dimension(80, 30));
        BtnSend1.setMinimumSize(new java.awt.Dimension(40, 15));
        BtnSend1.setPreferredSize(new java.awt.Dimension(100, 40));
        BtnSend1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSend1ActionPerformed(evt);
            }
        });
        PanelButtons2.add(BtnSend1);

        BtnBack2.setBackground(new java.awt.Color(121, 110, 113));
        BtnBack2.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        BtnBack2.setForeground(new java.awt.Color(255, 255, 255));
        BtnBack2.setText(bundle.getString("USER.BtnBack2.text")); // NOI18N
        BtnBack2.setAlignmentY(0.0F);
        BtnBack2.setBorder(null);
        BtnBack2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBack2.setDefaultCapable(false);
        BtnBack2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnBack2.setMaximumSize(new java.awt.Dimension(80, 30));
        BtnBack2.setMinimumSize(new java.awt.Dimension(40, 15));
        BtnBack2.setPreferredSize(new java.awt.Dimension(100, 40));
        BtnBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBack2ActionPerformed(evt);
            }
        });
        PanelButtons2.add(BtnBack2);

        javax.swing.GroupLayout PanelContainer2Layout = new javax.swing.GroupLayout(PanelContainer2);
        PanelContainer2.setLayout(PanelContainer2Layout);
        PanelContainer2Layout.setHorizontalGroup(
            PanelContainer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContainer2Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(PanelLeft2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(PanelRight2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContainer2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(PanelButtons2, javax.swing.GroupLayout.PREFERRED_SIZE, 1366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelContainer2Layout.setVerticalGroup(
            PanelContainer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContainer2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelContainer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelRight2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelLeft2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addComponent(PanelButtons2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        FormPublicLocation.add(PanelContainer2, java.awt.BorderLayout.CENTER);

        PanelPublicLocations.add(FormPublicLocation, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanelPublicLocations);
        PanelPublicLocations.setBounds(0, 0, 1366, 768);

        PanelResponsesAreas.setBackground(new java.awt.Color(237, 239, 230));
        PanelResponsesAreas.setEnabled(false);
        PanelResponsesAreas.setMaximumSize(new java.awt.Dimension(1366, 768));
        PanelResponsesAreas.setMinimumSize(new java.awt.Dimension(1366, 768));
        PanelResponsesAreas.setPreferredSize(new java.awt.Dimension(1366, 768));
        PanelResponsesAreas.setLayout(new java.awt.BorderLayout());

        ResponsesPanelHeader.setBackground(new java.awt.Color(203, 225, 196));
        ResponsesPanelHeader.setPreferredSize(new java.awt.Dimension(0, 50));
        ResponsesPanelHeader.setLayout(new java.awt.BorderLayout());

        PanelTitle4.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        PanelTitle4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelTitle4.setText(bundle.getString("USER.PanelTitle4.text")); // NOI18N
        ResponsesPanelHeader.add(PanelTitle4, java.awt.BorderLayout.CENTER);

        nav_back5.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        nav_back5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/back-icon-removebg-preview.png"))); // NOI18N
        nav_back5.setText(bundle.getString("USER.nav_back5.text")); // NOI18N
        nav_back5.setAlignmentX(0.5F);
        nav_back5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 20));
        nav_back5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_back5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        nav_back5.setMaximumSize(new java.awt.Dimension(122, 100));
        nav_back5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_back5MouseClicked(evt);
            }
        });
        ResponsesPanelHeader.add(nav_back5, java.awt.BorderLayout.LINE_END);

        PanelResponsesAreas.add(ResponsesPanelHeader, java.awt.BorderLayout.NORTH);

        contentPanel.setBackground(new java.awt.Color(245, 255, 243));
        contentPanel.setMaximumSize(new java.awt.Dimension(32767, 300));
        contentPanel.setOpaque(false);
        contentPanel.setPreferredSize(new java.awt.Dimension(252, 200));
        contentPanel.setLayout(new javax.swing.BoxLayout(contentPanel, javax.swing.BoxLayout.LINE_AXIS));

        ScrollResponsesPane.setBorder(null);
        ScrollResponsesPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollResponsesPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        responseArea1.setMaximumSize(new java.awt.Dimension(350, 600));
        responseArea1.setMinimumSize(new java.awt.Dimension(350, 600));
        responseArea1.setPreferredSize(new java.awt.Dimension(350, 600));
        PanelResponsesItem.add(responseArea1);

        ScrollResponsesPane.setViewportView(PanelResponsesItem);

        contentPanel.add(ScrollResponsesPane);

        PanelResponsesAreas.add(contentPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanelResponsesAreas);
        PanelResponsesAreas.setBounds(0, 0, 1366, 768);

        PanelSample.setBackground(new java.awt.Color(245, 255, 243));
        PanelSample.setEnabled(false);
        PanelSample.setMaximumSize(new java.awt.Dimension(1366, 768));
        PanelSample.setMinimumSize(new java.awt.Dimension(1366, 768));
        PanelSample.setPreferredSize(new java.awt.Dimension(1366, 768));
        PanelSample.setLayout(new java.awt.BorderLayout());

        PanelSamplesHeader.setBackground(new java.awt.Color(203, 225, 196));
        PanelSamplesHeader.setPreferredSize(new java.awt.Dimension(1366, 50));
        PanelSamplesHeader.setLayout(new java.awt.BorderLayout());

        PanelTitle2.setBackground(new java.awt.Color(203, 225, 196));
        PanelTitle2.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        PanelTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelTitle2.setText(bundle.getString("USER.PanelTitle2.text")); // NOI18N
        PanelSamplesHeader.add(PanelTitle2, java.awt.BorderLayout.CENTER);

        nav_back4.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        nav_back4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/back-icon-removebg-preview.png"))); // NOI18N
        nav_back4.setText(bundle.getString("USER.nav_back4.text")); // NOI18N
        nav_back4.setAlignmentX(0.5F);
        nav_back4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 20));
        nav_back4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_back4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        nav_back4.setMaximumSize(new java.awt.Dimension(122, 100));
        nav_back4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_back4MouseClicked(evt);
            }
        });
        PanelSamplesHeader.add(nav_back4, java.awt.BorderLayout.LINE_END);

        PanelSample.add(PanelSamplesHeader, java.awt.BorderLayout.PAGE_START);

        PanelSamplesContainer.setBackground(new java.awt.Color(245, 255, 243));

        LblTruckIcon.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        LblTruckIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/truck-removebg-preview.png"))); // NOI18N
        LblTruckIcon.setText(bundle.getString("USER.LblTruckIcon.text")); // NOI18N

        SamplesNavigation.setBackground(new java.awt.Color(245, 255, 243));
        SamplesNavigation.setMinimumSize(new java.awt.Dimension(500, 200));
        SamplesNavigation.setPreferredSize(new java.awt.Dimension(1350, 200));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 100);
        flowLayout1.setAlignOnBaseline(true);
        SamplesNavigation.setLayout(flowLayout1);

        nav_suggested_samples.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        nav_suggested_samples.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/create-sample-removebg-preview.png"))); // NOI18N
        nav_suggested_samples.setText(bundle.getString("USER.nav_suggested_samples.text")); // NOI18N
        nav_suggested_samples.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_suggested_samples.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nav_suggested_samples.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nav_suggested_samples.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_suggested_samplesMouseClicked(evt);
            }
        });
        SamplesNavigation.add(nav_suggested_samples);
        nav_suggested_samples.getAccessibleContext().setAccessibleDescription(bundle.getString("USER.nav_suggested_samples.AccessibleContext.accessibleDescription")); // NOI18N

        nav_suggested_outdoor.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        nav_suggested_outdoor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/external-suggestion-sample-removebg-preview.png"))); // NOI18N
        nav_suggested_outdoor.setText(bundle.getString("USER.nav_suggested_outdoor.text")); // NOI18N
        nav_suggested_outdoor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_suggested_outdoor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nav_suggested_outdoor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nav_suggested_outdoor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_suggested_outdoorMouseClicked(evt);
            }
        });
        SamplesNavigation.add(nav_suggested_outdoor);

        nav_suggested_indoor1.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        nav_suggested_indoor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/suggestion-sample-removebg-preview.png"))); // NOI18N
        nav_suggested_indoor1.setText(bundle.getString("USER.nav_suggested_indoor1.text")); // NOI18N
        nav_suggested_indoor1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_suggested_indoor1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nav_suggested_indoor1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nav_suggested_indoor1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_suggested_indoor1MouseClicked(evt);
            }
        });
        SamplesNavigation.add(nav_suggested_indoor1);

        javax.swing.GroupLayout PanelSamplesContainerLayout = new javax.swing.GroupLayout(PanelSamplesContainer);
        PanelSamplesContainer.setLayout(PanelSamplesContainerLayout);
        PanelSamplesContainerLayout.setHorizontalGroup(
            PanelSamplesContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSamplesContainerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(PanelSamplesContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LblTruckIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SamplesNavigation, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)))
        );
        PanelSamplesContainerLayout.setVerticalGroup(
            PanelSamplesContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSamplesContainerLayout.createSequentialGroup()
                .addComponent(SamplesNavigation, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblTruckIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 212, Short.MAX_VALUE))
        );

        PanelSample.add(PanelSamplesContainer, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanelSample);
        PanelSample.setBounds(0, 0, 1366, 768);

        PanelSamples.setBackground(new java.awt.Color(245, 255, 243));
        PanelSamples.setEnabled(false);
        PanelSamples.setMaximumSize(new java.awt.Dimension(1366, 768));
        PanelSamples.setMinimumSize(new java.awt.Dimension(1366, 768));
        PanelSamples.setPreferredSize(new java.awt.Dimension(1366, 768));
        PanelSamples.setLayout(new java.awt.BorderLayout());

        PanelNavHeader.setBackground(new java.awt.Color(245, 255, 243));
        PanelNavHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelLeavesImage.setBackground(new java.awt.Color(78, 107, 94));
        PanelLeavesImage.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        PanelLeavesImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/leaves-removebg-preview.png"))); // NOI18N
        PanelLeavesImage.setText(bundle.getString("USER.PanelLeavesImage.text")); // NOI18N
        PanelNavHeader.add(PanelLeavesImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 150));

        PanelSamplesTitle.setBackground(new java.awt.Color(78, 107, 94));
        PanelSamplesTitle.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        LblSamplesTitle.setBackground(new java.awt.Color(78, 107, 94));
        LblSamplesTitle.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        LblSamplesTitle.setForeground(new java.awt.Color(255, 255, 255));
        LblSamplesTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblSamplesTitle.setText(bundle.getString("USER.LblSamplesTitle.text")); // NOI18N
        LblSamplesTitle.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        LblSamplesTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout PanelSamplesTitleLayout = new javax.swing.GroupLayout(PanelSamplesTitle);
        PanelSamplesTitle.setLayout(PanelSamplesTitleLayout);
        PanelSamplesTitleLayout.setHorizontalGroup(
            PanelSamplesTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LblSamplesTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
        );
        PanelSamplesTitleLayout.setVerticalGroup(
            PanelSamplesTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LblSamplesTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 48, Short.MAX_VALUE)
        );

        PanelNavHeader.add(PanelSamplesTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 270, 50));

        nav_back2.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        nav_back2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        nav_back2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/back-removebg-preview.png"))); // NOI18N
        nav_back2.setText(bundle.getString("USER.nav_back2.text")); // NOI18N
        nav_back2.setAlignmentX(5.0F);
        nav_back2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        nav_back2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_back2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_back2MouseClicked(evt);
            }
        });
        PanelNavHeader.add(nav_back2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 10, -1, -1));

        PanelSamples.add(PanelNavHeader, java.awt.BorderLayout.PAGE_START);

        PanelNavContainer.setBackground(new java.awt.Color(245, 255, 243));
        PanelNavContainer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 100));

        nav_indoor_plants.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        nav_indoor_plants.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/indoor-plants-removebg-preview.png"))); // NOI18N
        nav_indoor_plants.setText(bundle.getString("USER.nav_indoor_plants.text")); // NOI18N
        nav_indoor_plants.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_indoor_plants.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nav_indoor_plants.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nav_indoor_plants.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_indoor_plantsMouseClicked(evt);
            }
        });
        PanelNavContainer.add(nav_indoor_plants);

        nav_trees.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        nav_trees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/trees-removebg-preview.png"))); // NOI18N
        nav_trees.setText(bundle.getString("USER.nav_trees.text")); // NOI18N
        nav_trees.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_trees.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nav_trees.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nav_trees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_treesMouseClicked(evt);
            }
        });
        PanelNavContainer.add(nav_trees);

        nav_fruits_vegetables.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        nav_fruits_vegetables.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/fruits-vegetables-removebg-preview.png"))); // NOI18N
        nav_fruits_vegetables.setText(bundle.getString("USER.nav_fruits_vegetables.text")); // NOI18N
        nav_fruits_vegetables.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_fruits_vegetables.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nav_fruits_vegetables.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nav_fruits_vegetables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_fruits_vegetablesMouseClicked(evt);
            }
        });
        PanelNavContainer.add(nav_fruits_vegetables);

        nav_flowers.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        nav_flowers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/flowers-removebg-preview.png"))); // NOI18N
        nav_flowers.setText(bundle.getString("USER.nav_flowers.text")); // NOI18N
        nav_flowers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_flowers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nav_flowers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nav_flowers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_flowersMouseClicked(evt);
            }
        });
        PanelNavContainer.add(nav_flowers);

        PanelSamples.add(PanelNavContainer, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanelSamples);
        PanelSamples.setBounds(0, 0, 1366, 730);

        PanelSamplesShop.setBackground(new java.awt.Color(245, 255, 243));
        PanelSamplesShop.setEnabled(false);
        PanelSamplesShop.setMaximumSize(new java.awt.Dimension(1366, 768));
        PanelSamplesShop.setMinimumSize(new java.awt.Dimension(1366, 768));
        PanelSamplesShop.setPreferredSize(new java.awt.Dimension(1366, 768));
        PanelSamplesShop.setLayout(new java.awt.BorderLayout());

        PanelSamplesShopHeader.setBackground(new java.awt.Color(203, 225, 196));
        PanelSamplesShopHeader.setPreferredSize(new java.awt.Dimension(1366, 50));
        PanelSamplesShopHeader.setLayout(new java.awt.BorderLayout());

        nav_back1.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        nav_back1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/back-icon-removebg-preview.png"))); // NOI18N
        nav_back1.setText(bundle.getString("USER.nav_back1.text")); // NOI18N
        nav_back1.setAlignmentX(0.5F);
        nav_back1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 20));
        nav_back1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_back1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        nav_back1.setMaximumSize(new java.awt.Dimension(122, 100));
        nav_back1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_back1MouseClicked(evt);
            }
        });
        PanelSamplesShopHeader.add(nav_back1, java.awt.BorderLayout.LINE_END);

        LblSampleShopTitle.setBackground(new java.awt.Color(203, 225, 196));
        LblSampleShopTitle.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        LblSampleShopTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblSampleShopTitle.setText(bundle.getString("USER.LblSampleShopTitle.text")); // NOI18N
        PanelSamplesShopHeader.add(LblSampleShopTitle, java.awt.BorderLayout.CENTER);

        nav_cart1.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        nav_cart1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/cart-removebg-preview.png"))); // NOI18N
        nav_cart1.setText(bundle.getString("USER.nav_cart1.text")); // NOI18N
        nav_cart1.setAlignmentX(0.5F);
        nav_cart1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        nav_cart1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_cart1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        nav_cart1.setMaximumSize(new java.awt.Dimension(122, 100));
        nav_cart1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_cart1MouseClicked(evt);
            }
        });
        PanelSamplesShopHeader.add(nav_cart1, java.awt.BorderLayout.LINE_START);

        PanelSamplesShop.add(PanelSamplesShopHeader, java.awt.BorderLayout.PAGE_START);

        PanelSamplesShopContainer.setBackground(new java.awt.Color(245, 255, 243));
        PanelSamplesShopContainer.setLayout(new javax.swing.BoxLayout(PanelSamplesShopContainer, javax.swing.BoxLayout.PAGE_AXIS));

        ScrollSamplesPane.setAutoscrolls(true);
        ScrollSamplesPane.setOpaque(false);

        PanelSamplesItem.setBackground(new java.awt.Color(245, 255, 243));
        PanelSamplesItem.add(item1);

        ScrollSamplesPane.setViewportView(PanelSamplesItem);

        PanelSamplesShopContainer.add(ScrollSamplesPane);

        PanelSamplesShop.add(PanelSamplesShopContainer, java.awt.BorderLayout.CENTER);

        PanelBottom.setBackground(new java.awt.Color(203, 225, 196));
        PanelBottom.setPreferredSize(new java.awt.Dimension(1366, 50));

        javax.swing.GroupLayout PanelBottomLayout = new javax.swing.GroupLayout(PanelBottom);
        PanelBottom.setLayout(PanelBottomLayout);
        PanelBottomLayout.setHorizontalGroup(
            PanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        PanelBottomLayout.setVerticalGroup(
            PanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        PanelSamplesShop.add(PanelBottom, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(PanelSamplesShop);
        PanelSamplesShop.setBounds(0, 0, 1366, 768);

        PanelSamplesCart.setBackground(new java.awt.Color(245, 255, 243));
        PanelSamplesCart.setEnabled(false);
        PanelSamplesCart.setMaximumSize(new java.awt.Dimension(1366, 768));
        PanelSamplesCart.setMinimumSize(new java.awt.Dimension(1366, 768));
        PanelSamplesCart.setPreferredSize(new java.awt.Dimension(1366, 768));
        PanelSamplesCart.setLayout(new java.awt.BorderLayout());

        PanelSamplesCartHeader.setBackground(new java.awt.Color(203, 225, 196));
        PanelSamplesCartHeader.setPreferredSize(new java.awt.Dimension(1366, 50));
        PanelSamplesCartHeader.setLayout(new java.awt.BorderLayout());

        nav_back6.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        nav_back6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/back-icon-removebg-preview.png"))); // NOI18N
        nav_back6.setText(bundle.getString("USER.nav_back6.text")); // NOI18N
        nav_back6.setAlignmentX(0.5F);
        nav_back6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 20));
        nav_back6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_back6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        nav_back6.setMaximumSize(new java.awt.Dimension(122, 100));
        nav_back6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_back6MouseClicked(evt);
            }
        });
        PanelSamplesCartHeader.add(nav_back6, java.awt.BorderLayout.LINE_END);

        LblSampleShopTitle1.setBackground(new java.awt.Color(203, 225, 196));
        LblSampleShopTitle1.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        LblSampleShopTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblSampleShopTitle1.setText(bundle.getString("USER.LblSampleShopTitle1.text")); // NOI18N
        PanelSamplesCartHeader.add(LblSampleShopTitle1, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        BtnCartClear.setText(bundle.getString("USER.BtnCartClear.text")); // NOI18N
        BtnCartClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCartClearActionPerformed(evt);
            }
        });
        jPanel1.add(BtnCartClear);

        BtnCartRefresh.setText(bundle.getString("USER.BtnCartRefresh.text")); // NOI18N
        BtnCartRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnCartRefreshMouseClicked(evt);
            }
        });
        BtnCartRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCartRefreshActionPerformed(evt);
            }
        });
        jPanel1.add(BtnCartRefresh);

        PanelSamplesCartHeader.add(jPanel1, java.awt.BorderLayout.WEST);

        PanelSamplesCart.add(PanelSamplesCartHeader, java.awt.BorderLayout.PAGE_START);

        PanelSamplesCartContainer.setBackground(new java.awt.Color(245, 255, 243));
        PanelSamplesCartContainer.setLayout(new javax.swing.BoxLayout(PanelSamplesCartContainer, javax.swing.BoxLayout.PAGE_AXIS));

        ScrollSamplesPane1.setAutoscrolls(true);
        ScrollSamplesPane1.setOpaque(false);

        PanelSamplesCartItem.setBackground(new java.awt.Color(245, 255, 243));
        PanelSamplesCartItem.add(cartItem);

        ScrollSamplesPane1.setViewportView(PanelSamplesCartItem);

        PanelSamplesCartContainer.add(ScrollSamplesPane1);

        PanelSamplesCart.add(PanelSamplesCartContainer, java.awt.BorderLayout.CENTER);

        PanelBottom1.setBackground(new java.awt.Color(203, 225, 196));
        PanelBottom1.setPreferredSize(new java.awt.Dimension(1366, 100));
        PanelBottom1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        BtnPay.setBackground(new java.awt.Color(238, 249, 235));
        BtnPay.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        BtnPay.setText(bundle.getString("USER.BtnPay.text")); // NOI18N
        BtnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPayActionPerformed(evt);
            }
        });
        PanelBottom1.add(BtnPay);

        PanelSamplesCart.add(PanelBottom1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(PanelSamplesCart);
        PanelSamplesCart.setBounds(0, 0, 1366, 768);

        PanelPlaceOrder.setBackground(new java.awt.Color(245, 255, 243));
        PanelPlaceOrder.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 100, 50, 100));
        PanelPlaceOrder.setEnabled(false);
        PanelPlaceOrder.setMaximumSize(new java.awt.Dimension(1366, 768));
        PanelPlaceOrder.setMinimumSize(new java.awt.Dimension(1366, 768));
        PanelPlaceOrder.setPreferredSize(new java.awt.Dimension(1366, 768));
        PanelPlaceOrder.setLayout(new java.awt.BorderLayout(50, 20));

        PanelPlaceOrderHeader.setBackground(new java.awt.Color(203, 225, 196));
        PanelPlaceOrderHeader.setPreferredSize(new java.awt.Dimension(1366, 80));
        PanelPlaceOrderHeader.setLayout(new java.awt.BorderLayout());

        LblSampleShopTitle2.setBackground(new java.awt.Color(203, 225, 196));
        LblSampleShopTitle2.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        LblSampleShopTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblSampleShopTitle2.setText(bundle.getString("USER.LblSampleShopTitle2.text")); // NOI18N
        LblSampleShopTitle2.setMaximumSize(new java.awt.Dimension(244, 80));
        LblSampleShopTitle2.setPreferredSize(new java.awt.Dimension(244, 80));
        PanelPlaceOrderHeader.add(LblSampleShopTitle2, java.awt.BorderLayout.CENTER);

        PanelPlaceOrder.add(PanelPlaceOrderHeader, java.awt.BorderLayout.PAGE_START);

        PanelPlaceOrderContainer.setBackground(new java.awt.Color(230, 244, 226));
        PanelPlaceOrderContainer.setLayout(new javax.swing.BoxLayout(PanelPlaceOrderContainer, javax.swing.BoxLayout.PAGE_AXIS));

        PanelPaymentMethod.setBackground(new java.awt.Color(203, 225, 196));

        GBtnPaymentMethod.add(RBtnApplyPay);
        RBtnApplyPay.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        RBtnApplyPay.setText(bundle.getString("USER.RBtnApplyPay.text")); // NOI18N
        RBtnApplyPay.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        RBtnApplyPay.setOpaque(false);
        PanelPaymentMethod.add(RBtnApplyPay);

        GBtnPaymentMethod.add(RBtnCash);
        RBtnCash.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        RBtnCash.setSelected(true);
        RBtnCash.setText(bundle.getString("USER.RBtnCash.text")); // NOI18N
        RBtnCash.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        RBtnCash.setOpaque(false);
        PanelPaymentMethod.add(RBtnCash);

        PanelPlaceOrderContainer.add(PanelPaymentMethod);

        PanelOrderDetails.setOpaque(false);
        PanelOrderDetails.setPreferredSize(new java.awt.Dimension(1166, 654));
        PanelOrderDetails.setLayout(new javax.swing.BoxLayout(PanelOrderDetails, javax.swing.BoxLayout.PAGE_AXIS));

        LblOrderTotalAmount1.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        LblOrderTotalAmount1.setText(bundle.getString("USER.LblOrderTotalAmount1.text")); // NOI18N
        PanelOrderDetails.add(LblOrderTotalAmount1);

        LblOrignalCost.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblOrignalCost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblOrignalCost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/riyal-removebg-preview.png"))); // NOI18N
        LblOrignalCost.setText(bundle.getString("USER.LblOrignalCost.text")); // NOI18N
        PanelOrderDetails.add(LblOrignalCost);

        LblOrderTotalAmount.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        LblOrderTotalAmount.setText(bundle.getString("USER.LblOrderTotalAmount.text")); // NOI18N
        PanelOrderDetails.add(LblOrderTotalAmount);

        LblDiscountCost.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblDiscountCost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/riyal-removebg-preview.png"))); // NOI18N
        LblDiscountCost.setText(bundle.getString("USER.LblDiscountCost.text")); // NOI18N
        PanelOrderDetails.add(LblDiscountCost);

        PanelPlaceOrderContainer.add(PanelOrderDetails);

        PanelOrderCoupon.setBackground(new java.awt.Color(255, 255, 255));

        LblCoupon.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblCoupon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/correct-icon-removebg-preview.png"))); // NOI18N
        LblCoupon.setText(bundle.getString("USER.LblCoupon.text")); // NOI18N
        LblCoupon.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout PanelOrderCouponLayout = new javax.swing.GroupLayout(PanelOrderCoupon);
        PanelOrderCoupon.setLayout(PanelOrderCouponLayout);
        PanelOrderCouponLayout.setHorizontalGroup(
            PanelOrderCouponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOrderCouponLayout.createSequentialGroup()
                .addContainerGap(936, Short.MAX_VALUE)
                .addComponent(LblCoupon)
                .addGap(27, 27, 27))
        );
        PanelOrderCouponLayout.setVerticalGroup(
            PanelOrderCouponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOrderCouponLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(LblCoupon)
                .addContainerGap())
        );

        PanelPlaceOrderContainer.add(PanelOrderCoupon);

        PanelPlaceOrder.add(PanelPlaceOrderContainer, java.awt.BorderLayout.CENTER);

        PanelBottom2.setBackground(new java.awt.Color(51, 51, 51));
        PanelBottom2.setMaximumSize(new java.awt.Dimension(283, 80));
        PanelBottom2.setPreferredSize(new java.awt.Dimension(1366, 80));
        PanelBottom2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelBottom2MouseClicked(evt);
            }
        });
        PanelBottom2.setLayout(new javax.swing.BoxLayout(PanelBottom2, javax.swing.BoxLayout.LINE_AXIS));

        LblApplePay.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        LblApplePay.setForeground(new java.awt.Color(255, 255, 255));
        LblApplePay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblApplePay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/apple-icon-removebg-preview.png"))); // NOI18N
        LblApplePay.setText(bundle.getString("USER.LblApplePay.text")); // NOI18N
        LblApplePay.setPreferredSize(PanelBottom2.getPreferredSize());
        LblApplePay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblApplePayMouseClicked(evt);
            }
        });
        PanelBottom2.add(LblApplePay);

        PanelPlaceOrder.add(PanelBottom2, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(PanelPlaceOrder);
        PanelPlaceOrder.setBounds(0, 0, 1366, 768);

        PanelThanks.setBackground(new java.awt.Color(245, 255, 243));
        PanelThanks.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 100, 50, 100));
        PanelThanks.setEnabled(false);
        PanelThanks.setMaximumSize(new java.awt.Dimension(1366, 768));
        PanelThanks.setMinimumSize(new java.awt.Dimension(1366, 768));
        PanelThanks.setPreferredSize(new java.awt.Dimension(1366, 768));
        PanelThanks.setLayout(new java.awt.BorderLayout(50, 20));

        PanelPlaceOrderContainer1.setBackground(new java.awt.Color(230, 244, 226));
        PanelPlaceOrderContainer1.setOpaque(false);
        PanelPlaceOrderContainer1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nav_back7.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        nav_back7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        nav_back7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/next-removebg-preview.png"))); // NOI18N
        nav_back7.setText(bundle.getString("USER.nav_back7.text")); // NOI18N
        nav_back7.setAlignmentX(5.0F);
        nav_back7.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        nav_back7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_back7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_back7MouseClicked(evt);
            }
        });
        PanelPlaceOrderContainer1.add(nav_back7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, 120, 110));

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/smile-removebg-preview.png"))); // NOI18N
        PanelPlaceOrderContainer1.add(pictureBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 500, 360));

        LblOrderNumber2.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        LblOrderNumber2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblOrderNumber2.setText(bundle.getString("USER.LblOrderNumber2.text")); // NOI18N
        LblOrderNumber2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        LblOrderNumber2.setPreferredSize(PanelBottom2.getPreferredSize());
        LblOrderNumber2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblOrderNumber2MouseClicked(evt);
            }
        });
        PanelPlaceOrderContainer1.add(LblOrderNumber2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, 226, 56));

        LblOrderNumber1.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        LblOrderNumber1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblOrderNumber1.setText(bundle.getString("USER.LblOrderNumber1.text")); // NOI18N
        LblOrderNumber1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        LblOrderNumber1.setPreferredSize(PanelBottom2.getPreferredSize());
        LblOrderNumber1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblOrderNumber1MouseClicked(evt);
            }
        });
        PanelPlaceOrderContainer1.add(LblOrderNumber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, 101, 56));

        PanelThanks.add(PanelPlaceOrderContainer1, java.awt.BorderLayout.CENTER);

        PanelBottom3.setBackground(new java.awt.Color(255, 255, 255));
        PanelBottom3.setMaximumSize(new java.awt.Dimension(283, 80));
        PanelBottom3.setLayout(new javax.swing.BoxLayout(PanelBottom3, javax.swing.BoxLayout.LINE_AXIS));

        LblOrderNumber.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        LblOrderNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblOrderNumber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/correct-icon-removebg-preview.png"))); // NOI18N
        LblOrderNumber.setText(bundle.getString("USER.LblOrderNumber.text")); // NOI18N
        LblOrderNumber.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        LblOrderNumber.setPreferredSize(PanelBottom2.getPreferredSize());
        LblOrderNumber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblOrderNumberMouseClicked(evt);
            }
        });
        PanelBottom3.add(LblOrderNumber);

        PanelThanks.add(PanelBottom3, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(PanelThanks);
        PanelThanks.setBounds(0, 0, 1366, 768);

        PanelConsultant.setBackground(new java.awt.Color(237, 239, 230));
        PanelConsultant.setEnabled(false);
        PanelConsultant.setMaximumSize(new java.awt.Dimension(1366, 768));
        PanelConsultant.setMinimumSize(new java.awt.Dimension(1366, 768));
        PanelConsultant.setPreferredSize(new java.awt.Dimension(1366, 768));
        PanelConsultant.setLayout(new java.awt.BorderLayout());

        PanelConsultantHeader.setBackground(new java.awt.Color(203, 225, 196));
        PanelConsultantHeader.setPreferredSize(new java.awt.Dimension(1366, 50));
        PanelConsultantHeader.setLayout(new java.awt.BorderLayout());

        PanelTitle3.setBackground(new java.awt.Color(203, 225, 196));
        PanelTitle3.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        PanelTitle3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelTitle3.setText(bundle.getString("USER.PanelTitle3.text")); // NOI18N
        PanelConsultantHeader.add(PanelTitle3, java.awt.BorderLayout.CENTER);

        nav_back3.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        nav_back3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/back-icon-removebg-preview.png"))); // NOI18N
        nav_back3.setText(bundle.getString("USER.nav_back3.text")); // NOI18N
        nav_back3.setAlignmentX(0.5F);
        nav_back3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 20));
        nav_back3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_back3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        nav_back3.setMaximumSize(new java.awt.Dimension(122, 100));
        nav_back3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_back3MouseClicked(evt);
            }
        });
        PanelConsultantHeader.add(nav_back3, java.awt.BorderLayout.LINE_END);

        PanelConsultant.add(PanelConsultantHeader, java.awt.BorderLayout.PAGE_START);

        PanelConsultantionContainer.setBackground(new java.awt.Color(237, 239, 230));
        PanelConsultantionContainer.setPreferredSize(new java.awt.Dimension(1366, 588));
        PanelConsultantionContainer.setLayout(new java.awt.BorderLayout());

        PanelControllers1.setOpaque(false);
        PanelControllers1.setPreferredSize(new java.awt.Dimension(1366, 50));
        java.awt.FlowLayout flowLayout3 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5);
        flowLayout3.setAlignOnBaseline(true);
        PanelControllers1.setLayout(flowLayout3);

        LblConsultationTopic.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblConsultationTopic.setText(bundle.getString("USER.LblConsultationTopic.text")); // NOI18N
        PanelControllers1.add(LblConsultationTopic);

        TFConsultationTopic.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        TFConsultationTopic.setText(bundle.getString("USER.TFConsultationTopic.text")); // NOI18N
        TFConsultationTopic.setToolTipText(bundle.getString("USER.TFConsultationTopic.toolTipText")); // NOI18N
        TFConsultationTopic.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(33, 104, 73), 3, true));
        TFConsultationTopic.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        TFConsultationTopic.setEnabled(false);
        TFConsultationTopic.setMaximumSize(new java.awt.Dimension(100, 200));
        TFConsultationTopic.setPreferredSize(new java.awt.Dimension(600, 35));
        TFConsultationTopic.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TFConsultationTopicFocusGained(evt);
            }
        });
        PanelControllers1.add(TFConsultationTopic);

        BtnTopic.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        BtnTopic.setText(bundle.getString("USER.BtnTopic.text")); // NOI18N
        BtnTopic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTopicActionPerformed(evt);
            }
        });
        PanelControllers1.add(BtnTopic);

        PanelConsultantionContainer.add(PanelControllers1, java.awt.BorderLayout.NORTH);

        PanelChatBody.setMaximumSize(new java.awt.Dimension(32767, 500));
        PanelChatBody.setOpaque(false);
        PanelChatBody.setPreferredSize(new java.awt.Dimension(1366, 573));

        javax.swing.GroupLayout PanelChatBodyLayout = new javax.swing.GroupLayout(PanelChatBody);
        PanelChatBody.setLayout(PanelChatBodyLayout);
        PanelChatBodyLayout.setHorizontalGroup(
            PanelChatBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        PanelChatBodyLayout.setVerticalGroup(
            PanelChatBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );

        PanelConsultantionContainer.add(PanelChatBody, java.awt.BorderLayout.CENTER);

        PanelControllers.setOpaque(false);
        PanelControllers.setPreferredSize(new java.awt.Dimension(1366, 90));
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout();
        flowLayout2.setAlignOnBaseline(true);
        PanelControllers.setLayout(flowLayout2);

        TFMessage.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        TFMessage.setText(bundle.getString("USER.TFMessage.text")); // NOI18N
        TFMessage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(33, 104, 73), 3, true));
        TFMessage.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        TFMessage.setMaximumSize(new java.awt.Dimension(100, 200));
        TFMessage.setPreferredSize(new java.awt.Dimension(1200, 35));
        TFMessage.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TFMessageFocusGained(evt);
            }
        });
        PanelControllers.add(TFMessage);

        BtnMessageSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/icons/send-icon-removebg-preview.png"))); // NOI18N
        BtnMessageSend.setText(bundle.getString("USER.BtnMessageSend.text")); // NOI18N
        BtnMessageSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMessageSendActionPerformed(evt);
            }
        });
        PanelControllers.add(BtnMessageSend);

        PanelConsultantionContainer.add(PanelControllers, java.awt.BorderLayout.SOUTH);

        PanelConsultant.add(PanelConsultantionContainer, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanelConsultant);
        PanelConsultant.setBounds(0, 0, 1366, 730);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnDeleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteAccountActionPerformed
        // TODO add your handling code here:

        JOptionPane.showMessageDialog(this, "User Account Deleted", "User Account Settings", JOptionPane.ERROR_MESSAGE);

    }//GEN-LAST:event_BtnDeleteAccountActionPerformed

    private void nav_rateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_rateMouseClicked
        // TODO add your handling code here:

        MoveTo(PanelHome, PanelFeedback);

    }//GEN-LAST:event_nav_rateMouseClicked

    private void BtnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSendActionPerformed

        feedback = new Feedback();

        feedback.setFull_name(TFFullName.getText().trim());
        feedback.setEmail_address(TFEmailAddress.getText().trim());
        feedback.setPhone_number(TFPhone.getText().trim());
        feedback.setMessage(TAMessage.getText().trim());
        feedback.setCurrent_date(current_date);

        if (isFeedbackValid(feedback)) {

            if (user_controller.Feedback(feedback)) {

                // Anonymous instance of the rating component
                ratingComponent = new StarRating();
                DialogStarRating.add(ratingComponent, BorderLayout.CENTER);

                DialogStarRating.setVisible(true); // blocks until dialog is closed

            }

        } else {
            JOptionPane.showConfirmDialog(PanelContainer, "Failed to send");

        }

    }//GEN-LAST:event_BtnSendActionPerformed

    private void BtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBackActionPerformed
        // TODO add your handling code here:

        MoveTo(PanelFeedback, PanelHome);

    }//GEN-LAST:event_BtnBackActionPerformed

    private void BtnUserProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnUserProfileMouseClicked
        // TODO add your handling code here:

        user = user_controller.UserProfile(GLOBAL.user_id);

        LblUserName.setText("Hello " + user.getFull_name());
        UPTFFullName.setText(user.getFull_name());
        UPTFAddress.setText(user.getAddress());
        UPTFPhone.setText(user.getPhone_number());
        LblScore.setText("Scroe: " + user.getScore());

        MoveTo(PanelHome, PanelUserProfile);

    }//GEN-LAST:event_BtnUserProfileMouseClicked

    private void BtnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBack1ActionPerformed
        // TODO add your handling code here:

        MoveTo(PanelUserProfile, PanelHome);

    }//GEN-LAST:event_BtnBack1ActionPerformed

    private void BtnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBack2ActionPerformed
        // TODO add your handling code here:
        MoveTo(PanelPublicLocations, PanelHome);
    }//GEN-LAST:event_BtnBack2ActionPerformed

    private void BtnSend1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSend1ActionPerformed
        // TODO add your handling code here:

        area = new Area();
        attachements = new Attachements();

        area.setUser_id(GLOBAL.user_id);
        area.setRegion_name(TFRegionName.getText().trim());
        area.setDescription(TADescription.getText().trim());
        area.setAddress(TFAddress.getText().trim());
        area.setLand_area(TFLandArea.getText().trim());

        if (files != null) {
            if (area_controller.addArea(area)) {

                System.out.println("Area ID After Insert" + GLOBAL.area_id);

                area.setId(GLOBAL.area_id);

                attachements.setArea_id(GLOBAL.area_id);
                attachements.setFiles(files);

                if (attachements_controller.uploadAttachements(attachements)) {
                    if (JOptionPane.showConfirmDialog(PanelPublicLocations, "Send This Area as Request", "Confirmation", 2) == 0) {
                        request = new Request();
                        request.setArea_id(area.getId());
                        request.setUser_id(GLOBAL.user_id);
                        request.setStatus("Pending");

                        if (area_controller.sendRequest(request)) {
                            JOptionPane.showMessageDialog(PanelPublicLocations, "Area Sended as Request To Review form Ministry of Environment Water & Agriculture User");

                        }
                    }
                }
            }
            TFRegionName.setText("");
            TADescription.setText("");
            TFAddress.setText("");
            TFLandArea.setText("");
            file = null;
        } else {
            JOptionPane.showMessageDialog(PanelPublicLocations, "Images Not Found or Uploaded Successfully");
        }
    }//GEN-LAST:event_BtnSend1ActionPerformed

    private void nav_locationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_locationMouseClicked
        // TODO add your handling code here:

        MoveTo(PanelHome, PanelPublicLocations);

    }//GEN-LAST:event_nav_locationMouseClicked

    private void TFRegionNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFRegionNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFRegionNameActionPerformed

    private void nav_suggested_outdoorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_suggested_outdoorMouseClicked
        // TODO add your handling code here:

        LblSampleShopTitle.setText("Outdoor Suggested Samples");
        samplesShow("Outdoor");
        MoveTo(PanelSample, PanelSamplesShop);

    }//GEN-LAST:event_nav_suggested_outdoorMouseClicked

    private void nav_consultantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_consultantMouseClicked
        // TODO add your handling code here:

        MoveTo(PanelHome, PanelConsultant);

    }//GEN-LAST:event_nav_consultantMouseClicked

    private void nav_sampleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_sampleMouseClicked
        // TODO add your handling code here:

        MoveTo(PanelHome, PanelSample);

    }//GEN-LAST:event_nav_sampleMouseClicked

    private void BtnChooseImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnChooseImagesActionPerformed
        // TODO add your handling code here:

        this.files = chooseFiles();

    }//GEN-LAST:event_BtnChooseImagesActionPerformed

    private void BtnRateSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRateSubmitActionPerformed
        // TODO add your handling code here:

        // Use the result after dialog closes
        final int selectedRating = ratingComponent.getRating();

        evaluate = new Evaluate();

        evaluate.setUser_id(GLOBAL.user_id);
        evaluate.setRate(selectedRating);

        user_controller.Evaluate(evaluate);

        DialogStarRating.dispose(); // close dialog

        MoveTo(PanelFeedback, PanelHome);

    }//GEN-LAST:event_BtnRateSubmitActionPerformed

    private void BtnRateCancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRateCancleActionPerformed
        // TODO add your handling code here:
        DialogStarRating.dispose();
        MoveTo(PanelFeedback, PanelHome);

    }//GEN-LAST:event_BtnRateCancleActionPerformed

    private void nav_flowersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_flowersMouseClicked
        // TODO add your handling code here:

        sample_category = "Flowers";

        samplesShow(sample_category);

        MoveTo(PanelSamples, PanelSamplesShop);


    }//GEN-LAST:event_nav_flowersMouseClicked

    private void nav_fruits_vegetablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_fruits_vegetablesMouseClicked
        // TODO add your handling code here:

        sample_category = "Fruits & Vegetables";

        samplesShow(sample_category);

        MoveTo(PanelSamples, PanelSamplesShop);

    }//GEN-LAST:event_nav_fruits_vegetablesMouseClicked

    private void nav_treesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_treesMouseClicked
        // TODO add your handling code here:

        sample_category = "Trees";

        samplesShow(sample_category);

        MoveTo(PanelSamples, PanelSamplesShop);

    }//GEN-LAST:event_nav_treesMouseClicked

    private void nav_indoor_plantsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_indoor_plantsMouseClicked
        // TODO add your handling code here:

        sample_category = "Indoor Plants";

        samplesShow(sample_category);

        MoveTo(PanelSamples, PanelSamplesShop);

    }//GEN-LAST:event_nav_indoor_plantsMouseClicked

    private void nav_back2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_back2MouseClicked
        // TODO add your handling code here:

        
        MoveTo(PanelSamples, PanelSample);


    }//GEN-LAST:event_nav_back2MouseClicked

    private void nav_suggested_samplesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_suggested_samplesMouseClicked
        // TODO add your handling code here:

        MoveTo(PanelSample, PanelSamples);

    }//GEN-LAST:event_nav_suggested_samplesMouseClicked

    private void nav_back1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_back1MouseClicked
        // TODO add your handling code here:

        MoveTo(PanelSamplesShop, PanelSample);


    }//GEN-LAST:event_nav_back1MouseClicked

    private void TFMessageFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFMessageFocusGained
        // TODO add your handling code here:

        if (TFMessage.getText().equals("Write your message here")) {
            TFMessage.setText("");
        }

    }//GEN-LAST:event_TFMessageFocusGained

    private void BtnMessageSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMessageSendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnMessageSendActionPerformed

    private void nav_back3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_back3MouseClicked
        // TODO add your handling code here:

        TFConsultationTopic.disable();

        MoveTo(PanelConsultant, PanelHome);

    }//GEN-LAST:event_nav_back3MouseClicked

    private void TFConsultationTopicFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFConsultationTopicFocusGained
        // TODO add your handling code here:

        if (TFConsultationTopic.getText().equals("Write your topic here")) {
            TFConsultationTopic.setText("");
        }

    }//GEN-LAST:event_TFConsultationTopicFocusGained

    private void BtnTopicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTopicActionPerformed
        // TODO add your handling code here:
        if (GLOBAL.currentLocale.getLanguage().equals("en")) {

            if (BtnTopic.getText().equals("Save")) {

                TFConsultationTopic.disable();

                BtnTopic.setText("Change");
            } else {
                TFConsultationTopic.enable();

                TFConsultationTopic.setFocusable(true);

                BtnTopic.setText("Save");
            }

        } else {

            if (BtnTopic.getText().equals("حفظ")) {

                TFConsultationTopic.disable();

                BtnTopic.setText("تغيير");
            } else {
                TFConsultationTopic.enable();

                TFConsultationTopic.setFocusable(true);

                BtnTopic.setText("حفظ");

            }
        }

    }//GEN-LAST:event_BtnTopicActionPerformed

    private void nav_back4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_back4MouseClicked
        // TODO add your handling code here:

        MoveTo(PanelSample, PanelHome);

    }//GEN-LAST:event_nav_back4MouseClicked

    private void nav_responsesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_responsesMouseClicked
        // TODO add your handling code here:

        // Fetch responses directly, no need for redundant list initialization
        responses_list = area_controller.areaResponses();

        // Setup layout and background
        PanelResponsesItem.removeAll();
        PanelResponsesItem.setLayout(new WrapLayout(FlowLayout.LEFT, 15, 15));

        // Create and add item components using a more concise stream
        responses_list.stream()
                .map(ResponseArea::new) // Create ResponseArea for each response
                .peek(responseArea -> responseArea.setData(responses_list.get(responses_list.indexOf(responseArea.getResponse()))))
                .forEach(PanelResponsesItem::add);

        PanelResponsesItem.revalidate();
        PanelResponsesItem.repaint();

        MoveTo(PanelPublicLocations, PanelResponsesAreas);

    }//GEN-LAST:event_nav_responsesMouseClicked

    private void nav_back5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_back5MouseClicked
        // TODO add your handling code here:

        MoveTo(PanelResponsesAreas, PanelPublicLocations);

    }//GEN-LAST:event_nav_back5MouseClicked

    private void nav_cart1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_cart1MouseClicked
        // TODO add your handling code here:

        samples_items_list = new ArrayList<>();
        sample_item_panels = new ArrayList<>();

        samples_items_list = sample_controller.getSampleItems();

        // Setup layout and background
        PanelSamplesCartItem.removeAll();
        PanelSamplesCartItem.setLayout(new WrapLayout(FlowLayout.LEFT, 15, 15));

        // Create and add item components
        samples_items_list.stream().map((s) -> {
            try {
                if (s.getImageStream() != null) {
                    BufferedImage img = ImageIO.read(s.getImageStream());
                    s.setBufferedImage(img);
                    Image scaled = img.getScaledInstance(250, 200, Image.SCALE_SMOOTH);
                    s.setImageIcon(new ImageIcon(scaled));
                }
            } catch (IOException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            }
            return s;
        }).map((s) -> {
            CartItem cart_item = new CartItem();
            cart_item.setData(s);
            sample_item_panels.add(cart_item);
            return cart_item;
        }).forEachOrdered((item) -> {
            PanelSamplesCartItem.add(item);
        });

        PanelSamplesCartItem.revalidate();
        PanelSamplesCartItem.repaint();

        BtnPay.enable();

        MoveTo(PanelSamplesShop, PanelSamplesCart);

    }//GEN-LAST:event_nav_cart1MouseClicked

    private void nav_back6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_back6MouseClicked
        // TODO add your handling code here:

        MoveTo(PanelSamplesCart, PanelSamplesShop);

    }//GEN-LAST:event_nav_back6MouseClicked

    private void BtnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPayActionPerformed
        // TODO add your handling code here:

        updateSampleItemQuantities(sample_item_panels);

        selectedItems = getSelectedItems(sample_item_panels);
        if (selectedItems.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No items selected for order.");
            return;
        }

        buildOrder(selectedItems, GLOBAL.user_id);

        LblOrignalCost.setText("" + order.getTotal_amount());
        LblDiscountCost.setText("" + order.getTotal_amount());

        MoveTo(PanelSamplesCart, PanelPlaceOrder);

    }//GEN-LAST:event_BtnPayActionPerformed

    private void LblApplePayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblApplePayMouseClicked

        // Set payment method
        String payment_method = RBtnApplyPay.isSelected() ? "Apple Pay" : "Cash";
        order.setPayment_method(payment_method);

        // Insert order and get generated ID
        int orderId = user_controller.Order(order);
        if (orderId == -1) {
            JOptionPane.showMessageDialog(null, "Failed to create order.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Failed to insert order
        }

        // Build OrderItems and insert
        List<OrderItem> orderItems = new ArrayList<>();
        for (SampleItem item : selectedItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder_id(orderId);
            orderItem.setSample_item_id(item.getItem_id());
            orderItem.setOrder_number(orderNumber);
            orderItems.add(orderItem);
        }

        boolean orderItemsSuccess = user_controller.OrderItem(orderItems);
        if (!orderItemsSuccess) {
            JOptionPane.showMessageDialog(null, "Failed to add order items.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Failed to insert order items
        }

        // Insert financial transaction
        boolean transactionSuccess = user_controller.addFinancialTransaction(
                order.getUser_id(), // UserID
                orderId, // OrderID
                order.getTotal_amount(), // Amount
                new java.util.Date() // TransactionDate (current date/time)
        );

        if (!transactionSuccess) {
            JOptionPane.showMessageDialog(null, "Failed to record financial transaction.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Failed to insert financial transaction
        }

        // Update UI and navigate
        LblOrderNumber.setText("رقم الطلب " + order.getOrder_number());
        MoveTo(PanelPlaceOrder, PanelThanks);

    }//GEN-LAST:event_LblApplePayMouseClicked

    private void LblOrderNumberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblOrderNumberMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LblOrderNumberMouseClicked

    private void LblOrderNumber1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblOrderNumber1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LblOrderNumber1MouseClicked

    private void LblOrderNumber2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblOrderNumber2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LblOrderNumber2MouseClicked

    private void nav_back7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_back7MouseClicked
        // TODO add your handling code here:

        MoveTo(PanelThanks, PanelHome);

    }//GEN-LAST:event_nav_back7MouseClicked

    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
        // TODO add your handling code here:
        String newPassword = "";

        user = new User();

        try {
            if (validateInputs()) {
                user.setId(GLOBAL.user_id);
                user.setFull_name(UPTFFullName.getText().trim());
                user.setAddress(UPTFAddress.getText().trim());
                user.setPhone_number(UPTFPhone.getText().trim());
                user.setPassword(UPTFResetPassword.getText().trim());

                if (user_controller.updateUserProfile(user)) {
                    JOptionPane.showMessageDialog(null, "Profile updated successfully!");

                }

            }
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Error saving data: " + ex.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }

        System.out.println(user.getFull_name());
        System.out.println(user.getAddress());
        System.out.println(user.getPhone_number());
        System.out.println(newPassword);


    }//GEN-LAST:event_BtnSaveActionPerformed

    private void BtnSupportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSupportMouseClicked
        // TODO add your handling code here:

        DialogSupport.setVisible(true);

    }//GEN-LAST:event_BtnSupportMouseClicked

    private void TASupportMessageFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TASupportMessageFocusGained
        // TODO add your handling code here:

        if (TASupportMessage.getText().equals("Write your message here")) {
            TASupportMessage.setText("");
        }
    }//GEN-LAST:event_TASupportMessageFocusGained

    private void TFSupportTopicFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFSupportTopicFocusGained
        // TODO add your handling code here:

        if (TFSupportTopic.getText().equals("Enter Topic")) {
            TFSupportTopic.setText("");
        }
    }//GEN-LAST:event_TFSupportTopicFocusGained

    private void BtnSupportSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSupportSubmitActionPerformed
        // TODO add your handling code here:

        sendSupportMessage();

    }//GEN-LAST:event_BtnSupportSubmitActionPerformed

    private void BtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelActionPerformed
        // TODO add your handling code here:

        DialogSupport.dispose();

    }//GEN-LAST:event_BtnCancelActionPerformed

    private void PanelBottom2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelBottom2MouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_PanelBottom2MouseClicked

    private void BtnCartClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCartClearActionPerformed
        // TODO add your handling code here:

        if (sample_controller.removeAll()) {
            BtnPay.disable();
            MoveTo(PanelSamplesCart, PanelSamplesShop);
        } else {
            JOptionPane.showMessageDialog(null, "Fail");
        }

    }//GEN-LAST:event_BtnCartClearActionPerformed

    private void BtnCartRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCartRefreshActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_BtnCartRefreshActionPerformed

    private void BtnCartRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCartRefreshMouseClicked
        // TODO add your handling code here:
        nav_cart1MouseClicked(evt);

    }//GEN-LAST:event_BtnCartRefreshMouseClicked

    private void nav_back8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_back8MouseClicked
        // TODO add your handling code here:

        MoveTo(PanelSettings, PanelHome);

    }//GEN-LAST:event_nav_back8MouseClicked

    private void BtnSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSettingsMouseClicked
        // TODO add your handling code here:

        MoveTo(PanelHome, PanelSettings);

    }//GEN-LAST:event_BtnSettingsMouseClicked

    private void BtnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSignOutActionPerformed
        // TODO add your handling code here:
        user = null;
        this.dispose();
        app = new APP();
        app.setVisible(true);

    }//GEN-LAST:event_BtnSignOutActionPerformed

    private void nav_suggested_indoor1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_suggested_indoor1MouseClicked
        // TODO add your handling code here:

        LblSampleShopTitle.setText("Indoor Suggested Samples");
        samplesShow("Indoor");
        MoveTo(PanelSample, PanelSamplesShop);

    }//GEN-LAST:event_nav_suggested_indoor1MouseClicked

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
            java.util.logging.Logger.getLogger(USER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(USER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(USER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(USER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new USER().setVisible(true);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBack;
    private javax.swing.JButton BtnBack1;
    private javax.swing.JButton BtnBack2;
    private javax.swing.JButton BtnCancel;
    private javax.swing.JButton BtnCartClear;
    private javax.swing.JButton BtnCartRefresh;
    private javax.swing.JButton BtnChooseImages;
    private javax.swing.JButton BtnDeleteAccount;
    private green.ams.components.GButton BtnMessageSend;
    private javax.swing.JButton BtnPay;
    private javax.swing.JButton BtnRateCancle;
    private javax.swing.JButton BtnRateSubmit;
    private javax.swing.JButton BtnSave;
    private javax.swing.JButton BtnSend;
    private javax.swing.JButton BtnSend1;
    private javax.swing.JLabel BtnSettings;
    private javax.swing.JButton BtnSignOut;
    private javax.swing.JLabel BtnSupport;
    private javax.swing.JButton BtnSupportSubmit;
    private javax.swing.JButton BtnTopic;
    private javax.swing.JLabel BtnUserProfile;
    private javax.swing.JPanel ButtonsPanel;
    private javax.swing.JPanel CotainerBtnFile;
    private javax.swing.JDialog DialogStarRating;
    private javax.swing.JDialog DialogSupport;
    private javax.swing.JPanel FeedbackPanelHeader;
    private javax.swing.JPanel FormFeedback;
    private javax.swing.JPanel FormPublicLocation;
    private javax.swing.JPanel FormUserProfile;
    private javax.swing.ButtonGroup GBtnPaymentMethod;
    private javax.swing.JLabel LblAddress;
    private javax.swing.JLabel LblApplePay;
    private javax.swing.JLabel LblConsultationTopic;
    private javax.swing.JLabel LblCoupon;
    private javax.swing.JLabel LblDescription;
    private javax.swing.JLabel LblDiscountCost;
    private javax.swing.JLabel LblEmailAddress;
    private javax.swing.JLabel LblImages;
    private javax.swing.JLabel LblLandArea;
    private javax.swing.JLabel LblMessage;
    private javax.swing.JLabel LblName;
    private javax.swing.JLabel LblOrderNumber;
    private javax.swing.JLabel LblOrderNumber1;
    private javax.swing.JLabel LblOrderNumber2;
    private javax.swing.JLabel LblOrderTotalAmount;
    private javax.swing.JLabel LblOrderTotalAmount1;
    private javax.swing.JLabel LblOrignalCost;
    private javax.swing.JLabel LblPhone;
    private javax.swing.JLabel LblRegionName;
    private javax.swing.JLabel LblSampleShopTitle;
    private javax.swing.JLabel LblSampleShopTitle1;
    private javax.swing.JLabel LblSampleShopTitle2;
    private javax.swing.JLabel LblSamplesTitle;
    private javax.swing.JLabel LblScore;
    private javax.swing.JLabel LblSupport4;
    private javax.swing.JLabel LblTruckIcon;
    private javax.swing.JLabel LblUserName;
    private javax.swing.JPanel PanelBottom;
    private javax.swing.JPanel PanelBottom1;
    private javax.swing.JPanel PanelBottom2;
    private javax.swing.JPanel PanelBottom3;
    private javax.swing.JPanel PanelButtons;
    private javax.swing.JPanel PanelButtons1;
    private javax.swing.JPanel PanelButtons2;
    private javax.swing.JPanel PanelChatBody;
    private javax.swing.JPanel PanelConsultant;
    private javax.swing.JPanel PanelConsultantHeader;
    private javax.swing.JPanel PanelConsultantionContainer;
    private javax.swing.JPanel PanelContainer;
    private javax.swing.JPanel PanelContainer1;
    private javax.swing.JPanel PanelContainer2;
    private javax.swing.JPanel PanelControllers;
    private javax.swing.JPanel PanelControllers1;
    private javax.swing.JPanel PanelFeedback;
    private javax.swing.JPanel PanelHome;
    private javax.swing.JLabel PanelLeavesImage;
    private javax.swing.JPanel PanelLeft;
    private javax.swing.JPanel PanelLeft1;
    private javax.swing.JPanel PanelLeft2;
    private javax.swing.JPanel PanelNavContainer;
    private javax.swing.JPanel PanelNavHeader;
    private javax.swing.JPanel PanelOrderCoupon;
    private javax.swing.JPanel PanelOrderDetails;
    private javax.swing.JPanel PanelPaymentMethod;
    private javax.swing.JPanel PanelPlaceOrder;
    private javax.swing.JPanel PanelPlaceOrderContainer;
    private javax.swing.JPanel PanelPlaceOrderContainer1;
    private javax.swing.JPanel PanelPlaceOrderHeader;
    private javax.swing.JPanel PanelPublicLocationHeader;
    private javax.swing.JPanel PanelPublicLocations;
    private javax.swing.JPanel PanelResponsesAreas;
    private green.ams.components.PanelItem PanelResponsesItem;
    private javax.swing.JPanel PanelRight;
    private javax.swing.JPanel PanelRight1;
    private javax.swing.JPanel PanelRight2;
    private javax.swing.JPanel PanelSample;
    private javax.swing.JPanel PanelSamples;
    private javax.swing.JPanel PanelSamplesCart;
    private javax.swing.JPanel PanelSamplesCartContainer;
    private javax.swing.JPanel PanelSamplesCartHeader;
    private green.ams.components.PanelItem PanelSamplesCartItem;
    private javax.swing.JPanel PanelSamplesContainer;
    private javax.swing.JPanel PanelSamplesHeader;
    private green.ams.components.PanelItem PanelSamplesItem;
    private javax.swing.JPanel PanelSamplesShop;
    private javax.swing.JPanel PanelSamplesShopContainer;
    private javax.swing.JPanel PanelSamplesShopHeader;
    private javax.swing.JPanel PanelSamplesTitle;
    private javax.swing.JPanel PanelSeetingsBody;
    private javax.swing.JPanel PanelSettings;
    private javax.swing.JPanel PanelSettingsHeader;
    private javax.swing.JPanel PanelSupportButtons;
    private javax.swing.JPanel PanelSupportContaiiner4;
    private javax.swing.JPanel PanelSupportForm4;
    private javax.swing.JPanel PanelThanks;
    private javax.swing.JLabel PanelTitle;
    private javax.swing.JLabel PanelTitle1;
    private javax.swing.JLabel PanelTitle2;
    private javax.swing.JLabel PanelTitle3;
    private javax.swing.JLabel PanelTitle4;
    private javax.swing.JLabel PanelTitle5;
    private javax.swing.JPanel PanelUserProfile;
    private javax.swing.JRadioButton RBtnApplyPay;
    private javax.swing.JRadioButton RBtnCash;
    private javax.swing.JPanel ResponsesPanelHeader;
    private javax.swing.JPanel SamplesNavigation;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JScrollPane ScrollPane1;
    private javax.swing.JScrollPane ScrollResponsesPane;
    private javax.swing.JScrollPane ScrollSamplesPane;
    private javax.swing.JScrollPane ScrollSamplesPane1;
    private javax.swing.JTextArea TADescription;
    private javax.swing.JTextArea TAMessage;
    private javax.swing.JTextArea TASupportMessage;
    private javax.swing.JTextField TFAddress;
    private javax.swing.JTextField TFConsultationTopic;
    private javax.swing.JTextField TFEmailAddress;
    private javax.swing.JTextField TFFullName;
    private javax.swing.JTextField TFLandArea;
    private javax.swing.JTextField TFMessage;
    private javax.swing.JTextField TFPhone;
    private javax.swing.JTextField TFRegionName;
    private javax.swing.JTextField TFSupportTopic;
    private javax.swing.JLabel UPLblAddress;
    private javax.swing.JLabel UPLblFullName;
    private javax.swing.JLabel UPLblPhone;
    private javax.swing.JLabel UPLblResetPassword;
    private javax.swing.JTextField UPTFAddress;
    private javax.swing.JTextField UPTFFullName;
    private javax.swing.JTextField UPTFPhone;
    private javax.swing.JTextField UPTFResetPassword;
    private javax.swing.JPanel UserNavigation;
    private green.ams.components.CartItem cartItem;
    private javax.swing.JPanel contentPanel;
    private green.ams.components.Item item1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nav_back1;
    private javax.swing.JLabel nav_back2;
    private javax.swing.JLabel nav_back3;
    private javax.swing.JLabel nav_back4;
    private javax.swing.JLabel nav_back5;
    private javax.swing.JLabel nav_back6;
    private javax.swing.JLabel nav_back7;
    private javax.swing.JLabel nav_back8;
    private javax.swing.JLabel nav_cart1;
    private javax.swing.JLabel nav_consultant;
    private javax.swing.JLabel nav_flowers;
    private javax.swing.JLabel nav_fruits_vegetables;
    private javax.swing.JLabel nav_indoor_plants;
    private javax.swing.JLabel nav_location;
    private javax.swing.JLabel nav_rate;
    private javax.swing.JLabel nav_responses;
    private javax.swing.JLabel nav_sample;
    private javax.swing.JLabel nav_suggested_indoor1;
    private javax.swing.JLabel nav_suggested_outdoor;
    private javax.swing.JLabel nav_suggested_samples;
    private javax.swing.JLabel nav_trees;
    private green.ams.components.PictureBox pictureBox1;
    private green.ams.components.ResponseArea responseArea1;
    // End of variables declaration//GEN-END:variables

    private void Start() {

        PanelHome.setVisible(true);
        PanelFeedback.setVisible(false);
        PanelUserProfile.setVisible(false);
        PanelSettings.setVisible(false);
        PanelPublicLocations.setVisible(false);
        PanelResponsesAreas.setVisible(false);
        PanelSample.setVisible(false);
        PanelSamples.setVisible(false);
        PanelSamplesShop.setVisible(false);
        PanelSamplesCart.setVisible(false);
        PanelPlaceOrder.setVisible(false);
        PanelThanks.setVisible(false);
        PanelConsultant.setVisible(false);

    }

    private void CustomeEdits() {
        ScrollSamplesPane.getVerticalScrollBar().setUnitIncrement(16);

        ScrollResponsesPane.getVerticalScrollBar().setUnitIncrement(16);

        // Setup layout and background
        PanelSamplesItem.setLayout(new WrapLayout(FlowLayout.LEFT, 15, 15));

        ScrollSamplesPane1.getVerticalScrollBar().setUnitIncrement(16);

        // Setup layout and background
        PanelSamplesCartItem.setLayout(new WrapLayout(FlowLayout.LEFT, 15, 15));

    }

    private void MoveTo(JPanel o1, JPanel o2) {
        o1.setVisible(false);
        o2.setVisible(true);
    }

    private void switchLanguage() {

        // Reload ResourceBundle with correct package
        GLOBAL.bundle = ResourceBundle.getBundle("green.ams.Bundle", GLOBAL.currentLocale);

        // Update UI Components
        GLOBAL.updateTextFields(this, "USER", GLOBAL.bundle);
    }

    public static boolean isFeedbackValid(Feedback feedback) {
        return feedback.getFull_name() != null && !feedback.getFull_name().isEmpty()
                && feedback.getEmail_address() != null && !feedback.getEmail_address().isEmpty()
                && feedback.getPhone_number() != null && !feedback.getPhone_number().isEmpty()
                && feedback.getMessage() != null && !feedback.getMessage().isEmpty();
    }

    private boolean validateInputs() {
        // Full Name validation
        if (UPTFFullName.getText().trim().isEmpty()) {
            showError("Full name cannot be empty", UPTFFullName);
            return false;
        }

        // Address validation
        if (UPTFAddress.getText().trim().isEmpty()) {
            showError("Address cannot be empty", UPTFAddress);
            return false;
        }

        // Phone validation
        String phone = UPTFPhone.getText().trim();
        if (!PHONE_PATTERN.matcher(phone).matches()) {
            showError("Invalid phone number format", UPTFPhone);
            return false;
        }

        return true;
    }

    private void showError(String message, JComponent field) {
        JOptionPane.showMessageDialog(null, message, "Validation Error", JOptionPane.ERROR_MESSAGE);
        field.requestFocusInWindow();
    }

    private File[] chooseFiles() {

        fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int returnValue = fileChooser.showOpenDialog(this);
        File[] temp_files = null;
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            temp_files = fileChooser.getSelectedFiles();
        }
        return (temp_files != null) ? temp_files : null;
    }

    //  Samples Types
    private void samplesShow(String type) {

        PanelSamplesItem.removeAll();

        samples_list = new ArrayList<>();

        // Load samples
        samples_list = sample_controller.showSamples(type);

        if (samples_list != null) {
            // Create and add item components
            samples_list.stream().map((s) -> {
                try {
                    if (s.getImageStream() != null) {
                        BufferedImage img = ImageIO.read(s.getImageStream());
                        s.setBufferedImage(img);
                        Image scaled = img.getScaledInstance(250, 200, Image.SCALE_SMOOTH);
                        s.setImageIcon(new ImageIcon(scaled));
                    }
                } catch (IOException ex) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                }
                return s;
            }).map((s) -> {
                Item item = new Item();
                item.setData(s);
                return item;
            }).forEachOrdered((item) -> {
                PanelSamplesItem.add(item);
            });
        } else {
            JOptionPane.showMessageDialog(null, "The list is null");
        }

        PanelSamplesItem.revalidate();
        PanelSamplesItem.repaint();
    }

    public void updateSampleItemQuantities(List<CartItem> panels) {
        for (CartItem panel : panels) {
            int newQuantity = panel.getQuantity(); // e.g., from JTextField or Spinner
            sample_item = panel.getSampleItem();
            System.out.println("Sample Qty" + sample_item.getQuantity());
            sample_item.setQuantity(newQuantity);

            System.out.println("Panel Qty" + panel.getQuantity());
            System.out.println("New Quantity" + newQuantity);

        }
    }

    public List<SampleItem> getSelectedItems(List<CartItem> panels) {
        List<SampleItem> selectedItems = new ArrayList<>();
        for (CartItem panel : panels) {
            SampleItem item = panel.getSampleItem();
            if (item.getQuantity() > 0) {
                selectedItems.add(item);
            }
        }
        return selectedItems;
    }

    public void buildOrder(List<SampleItem> items, int userId) {

        // Generate a random order number
        orderNumber = (int) (100000000 * Math.random());
        double total = 0;

        // Calculate total amount
        for (SampleItem item : items) {
            total += item.getPrice() * item.getQuantity();
        }

        // Build and insert the Order
        order = new Order();
        order.setUser_id(userId);
        order.setOrder_number(orderNumber);
        order.setTotal_amount(total);
        order.setOrder_date(new java.sql.Date(System.currentTimeMillis()));

    }

    // Modified setupChat method
    private void setupChat() {
        messagesPanel = new JPanel();
        messagesPanel.setLayout(new BoxLayout(messagesPanel, BoxLayout.Y_AXIS));
        messagesPanel.setBackground(new Color(237, 239, 230));

        chatScrollPane = new JScrollPane(messagesPanel);
        chatScrollPane.setBorder(null);
        chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        chatScrollPane.getVerticalScrollBar().setUnitIncrement(16);


        PanelChatBody.setLayout(new BorderLayout());
        PanelChatBody.add(chatScrollPane, BorderLayout.CENTER);
        PanelChatBody.revalidate();
        PanelChatBody.repaint();

        // Load initial chat history
        loadChatHistory();

        // Add action listeners
        BtnMessageSend.addActionListener(e -> sendMessage());
        BtnTopic.addActionListener(e -> {
            String topic = TFConsultationTopic.getText().trim();
            if (!topic.isEmpty() && !topic.equals("Write your topic here")) {
                messagesPanel.removeAll();
                displayedMessageIds.clear();
                lastMessageId = -1;
                oldestMessageId = -1;
                loadChatHistory();
            }
        });

        // Start auto-refresh when panel is visible
        PanelConsultant.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent evt) {
                startAutoRefresh();
            }

            @Override
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                stopAutoRefresh();
            }
        });
    }

    // Updated loadChatHistory method with message limit
    private void loadChatHistory() {
        SwingUtilities.invokeLater(() -> {
            try {
                List<Consultation> history = user_controller.getChatHistory(GLOBAL.user_id);
                List<Consultation> limitedHistory = new ArrayList<>();
                int startIndex = Math.max(0, history.size() - MESSAGE_LIMIT);
                for (int i = startIndex; i < history.size(); i++) {
                    Consultation msg = history.get(i);
                    if (!displayedMessageIds.contains(msg.getId())) {
                        limitedHistory.add(msg);
                        displayedMessageIds.add(msg.getId());
                        lastMessageId = Math.max(lastMessageId, msg.getId());
                        if (oldestMessageId == -1 || msg.getId() < oldestMessageId) {
                            oldestMessageId = msg.getId();
                        }
                    }
                }

                for (Consultation msg : limitedHistory) {
                    addMessage(msg);
                }
                scrollToBottom();

                // Show "Load More" button if there are more messages to load
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error loading chat history: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    // New method to load more messages
    private void loadMoreMessages() {
       SwingUtilities.invokeLater(() -> {
            try {
                List<Consultation> history = user_controller.getChatHistory(GLOBAL.user_id);
                List<Consultation> olderMessages = new ArrayList<>();
                int count = 0;
                for (int i = history.size() - 1; i >= 0 && count < MESSAGE_LIMIT; i--) {
                    Consultation msg = history.get(i);
                    if (msg.getId() < oldestMessageId && !displayedMessageIds.contains(msg.getId())) {
                        olderMessages.add(0, msg); // Add in reverse order
                        displayedMessageIds.add(msg.getId());
                        count++;
                        if (msg.getId() < oldestMessageId) {
                            oldestMessageId = msg.getId();
                        }
                    }
                }

                for (Consultation msg : olderMessages) {
                    addMessageAtTop(msg);
                }

                // Update "Load More" button visibility
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error loading more messages: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
            }
        });
    }

// Modified startAutoRefresh method using javax.swing.Timer
    private void startAutoRefresh() {
        if (refreshTimer != null) {
            refreshTimer.stop();
        }
        refreshTimer = new Timer(10000, e -> {
            if (PanelConsultant.isVisible()) {
                fetchNewMessages();
            }
        });
        refreshTimer.setRepeats(true);
        refreshTimer.start();
    }

// Modified stopAutoRefresh method
    private void stopAutoRefresh() {
        if (refreshTimer != null) {
            refreshTimer.stop();
            refreshTimer = null;
        }
    }

    // Add this method to handle message sending
    private void sendSupportMessage() {
        if (TFSupportTopic.getText().trim().equals("") || TASupportMessage.getText().trim().equals("") || TFSupportTopic.getText().trim().equals("Enter Topic") || TASupportMessage.getText().trim().equals("Write your message here")) {            

            JOptionPane.showMessageDialog(this, "Write Messag Don't Leave It!");
            
        }else {
            consultation = new Consultation();
            
            consultation.setUser_id(GLOBAL.user_id);
            consultation.setReceived_id(0);
            consultation.setTopic(TFSupportTopic.getText().trim());
            consultation.setMessage(TAMessage.getText().trim());
            
            user_controller.Consultation(consultation);
           
            TFSupportTopic.setText("Enter Topic");
            TASupportMessage.setText("Write your message here");
            
            DialogSupport.dispose();
        }
    }

// Updated sendMessage method
    private void sendMessage() {
        String text = TFMessage.getText().trim();
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a message.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String topic = (!TFConsultationTopic.getText().isEmpty() && !TFConsultationTopic.getText().equals("Write your topic here"))
                ? TFConsultationTopic.getText()
                : "General Consultation";

        consultation = new Consultation();
        consultation.setUser_id(GLOBAL.user_id);
        consultation.setTopic(topic);
        consultation.setMessage(text);
        consultation.setSender_role("USER");
        consultation.setSended_date(new Timestamp(System.currentTimeMillis()));

        try {
            if (user_controller.Consultation(consultation)) {
                if (!displayedMessageIds.contains(consultation.getId())) {
                    addMessage(consultation);
                    displayedMessageIds.add(consultation.getId());
                    lastMessageId = Math.max(lastMessageId, consultation.getId());
                }
                TFMessage.setText("");
                scrollToBottom();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error sending message: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Updated fetchNewMessages method
    private void fetchNewMessages() {
        try {
            List<Consultation> newMessages = user_controller.getNewMessages(GLOBAL.user_id, lastMessageId);
            for (Consultation msg : newMessages) {
                if (!displayedMessageIds.contains(msg.getId())) {
                    addMessage(msg);
                    displayedMessageIds.add(msg.getId());
                    lastMessageId = Math.max(lastMessageId, msg.getId());
                }
            }
            scrollToBottom();
        } catch (Exception e) {
            // Silent fail to avoid interrupting user experience
            System.err.println("Error fetching new messages: " + e.getMessage());
        }
    }

// Updated addMessage method with alignment and timestamp
    private void addMessage(Consultation consultation) {
        JPanel wrapperPanel = new JPanel();
        wrapperPanel.setOpaque(false);
        wrapperPanel.setLayout(new BoxLayout(wrapperPanel, BoxLayout.Y_AXIS));

        // Add timestamp
        JLabel timestampLabel = new JLabel(consultation.getSended_date().toString());
        timestampLabel.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        timestampLabel.setForeground(Color.GRAY);
        timestampLabel.setAlignmentX("USER".equals(consultation.getSender_role()) ? Component.RIGHT_ALIGNMENT : Component.LEFT_ALIGNMENT);

        JPanel messageBubble = createResponsiveBubble(consultation.getMessage(), false);
        messageBubble.setAlignmentX("USER".equals(consultation.getSender_role()) ? Component.RIGHT_ALIGNMENT : Component.LEFT_ALIGNMENT);

        wrapperPanel.add(timestampLabel);
        wrapperPanel.add(messageBubble);
        wrapperPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        messagesPanel.add(wrapperPanel);
        messagesPanel.add(Box.createVerticalStrut(2));
        messagesPanel.revalidate();
        messagesPanel.repaint();
    }

// New method to add messages at the top (for "Load More")
    private void addMessageAtTop(Consultation consultation) {
        JPanel wrapperPanel = new JPanel();
        wrapperPanel.setOpaque(false);
        wrapperPanel.setLayout(new BoxLayout(wrapperPanel, BoxLayout.Y_AXIS));

        JLabel timestampLabel = new JLabel(consultation.getSended_date().toString());
        timestampLabel.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        timestampLabel.setForeground(Color.GRAY);
        timestampLabel.setAlignmentX("USER".equals(consultation.getSender_role()) ? Component.RIGHT_ALIGNMENT : Component.LEFT_ALIGNMENT);

        JPanel messageBubble = createResponsiveBubble(consultation.getMessage(), false);
        messageBubble.setAlignmentX("USER".equals(consultation.getSender_role()) ? Component.RIGHT_ALIGNMENT : Component.LEFT_ALIGNMENT);

        wrapperPanel.add(timestampLabel);
        wrapperPanel.add(messageBubble);
        wrapperPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        messagesPanel.add(wrapperPanel, 0);
        messagesPanel.add(Box.createVerticalStrut(8), 1);
        messagesPanel.revalidate();
        messagesPanel.repaint();
    }

// Updated createResponsiveBubble method
    private JPanel createResponsiveBubble(String text, boolean isUser) {
        JTextArea messageText = new JTextArea(text);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setEditable(false);
        messageText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        messageText.setBackground(isUser ? new Color(203, 225, 196) : Color.WHITE);
        messageText.setForeground(Color.DARK_GRAY);
        messageText.setBorder(BorderFactory.createEmptyBorder(10, 14, 10, 14));

        JLabel timeLabel = new JLabel(new SimpleDateFormat("HH:mm").format(new Timestamp(System.currentTimeMillis())),
                SwingConstants.RIGHT
        );
        timeLabel.setFont(new Font("Segoe UI", Font.ITALIC, 10));
        timeLabel.setForeground(Color.GRAY);

        JPanel bubble = new JPanel(new BorderLayout());
        bubble.setBackground(messageText.getBackground());
        bubble.add(messageText, BorderLayout.CENTER);
        bubble.add(timeLabel, BorderLayout.SOUTH);

        bubble.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(12),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));

        int maxWidth = (int) (chatScrollPane.getViewport().getWidth() * 0.1);
        messageText.setMaximumSize(new Dimension(maxWidth, Integer.MAX_VALUE));
        messageText.setPreferredSize(new Dimension(maxWidth, messageText.getPreferredSize().height));

        return bubble;
    }

// Helper method to scroll to bottom
    private void scrollToBottom() {
        SwingUtilities.invokeLater(() -> {
            JScrollBar vertical = chatScrollPane.getVerticalScrollBar();
            vertical.setValue(vertical.getMaximum());
        });
    }
}

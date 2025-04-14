/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams;

import green.ams.controllers.AuthController;
import green.ams.models.User;
import java.sql.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

import javax.swing.JPanel;

/**
 *
 * @author Adham
 */
public class APP extends javax.swing.JFrame {

    /**
     * Creates new form APP
     *
     * @param language
     */
    
    
    // User Model Intializaition
    boolean is_on = true;

    // Password Visible Intializaition
    private boolean password_visible = false;

    // User Frame Intializaition    
    USER user_frame;

    // User Authentication Intializaition
    AuthController auth = new AuthController();

    // User Model Intializaition
    User user = new User();

    // Current Date Intializaition
    Date current_date;

    public APP() {
        
        
        
        initComponents();

        Start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelSplash = new javax.swing.JPanel();
        BtnStart = new green.ams.components.GButton();
        Splash = new javax.swing.JLabel();
        PanelGate = new javax.swing.JPanel();
        BtnSignIn = new green.ams.components.GButton();
        BtnSignUp = new green.ams.components.GButton();
        BtnLanguage = new javax.swing.JButton();
        PanelSignIn = new javax.swing.JPanel();
        PanelTitle = new javax.swing.JLabel();
        LoginContainer = new javax.swing.JPanel();
        LblUsername = new javax.swing.JLabel();
        LTFUsername = new javax.swing.JTextField();
        LblPassword = new javax.swing.JLabel();
        LTFPassword = new javax.swing.JPasswordField();
        LblForgetPassword = new javax.swing.JLabel();
        LBtnSignIn = new javax.swing.JButton();
        LBtnBack = new javax.swing.JButton();
        PasswordVisibility = new javax.swing.JButton();
        Background = new javax.swing.JLabel();
        PanelSignUp = new javax.swing.JPanel();
        PanelTitle1 = new javax.swing.JLabel();
        RegisterContainer = new javax.swing.JPanel();
        LblName = new javax.swing.JLabel();
        RTFFullName = new javax.swing.JTextField();
        LblUsername1 = new javax.swing.JLabel();
        RTFUsername = new javax.swing.JTextField();
        LblPhone = new javax.swing.JLabel();
        RTFPhone = new javax.swing.JTextField();
        LblAdress = new javax.swing.JLabel();
        RTFAdress = new javax.swing.JTextField();
        LblPassword1 = new javax.swing.JLabel();
        RTFPassword = new javax.swing.JTextField();
        BtnSign1 = new javax.swing.JButton();
        BtnBack1 = new javax.swing.JButton();
        Background1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("green/ams/Bundle"); // NOI18N
        setTitle(bundle.getString("APP.title")); // NOI18N
        setBackground(new java.awt.Color(237, 233, 224));
        setForeground(new java.awt.Color(237, 233, 224));
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setName("AppJFrame"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        PanelSplash.setBackground(new java.awt.Color(248, 255, 245));
        PanelSplash.setPreferredSize(new java.awt.Dimension(1366, 768));
        PanelSplash.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnStart.setBackground(new java.awt.Color(248, 255, 245));
        BtnStart.setText(bundle.getString("APP.BtnStart.text")); // NOI18N
        BtnStart.setToolTipText(bundle.getString("APP.BtnStart.toolTipText")); // NOI18N
        BtnStart.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        BtnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnStartActionPerformed(evt);
            }
        });
        PanelSplash.add(BtnStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 660, 150, 40));

        Splash.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Splash.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Splash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/images/green.png"))); // NOI18N
        Splash.setLabelFor(this);
        Splash.setMinimumSize(new java.awt.Dimension(768, 560));
        Splash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SplashMousePressed(evt);
            }
        });
        PanelSplash.add(Splash, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(PanelSplash);
        PanelSplash.setBounds(0, 0, 1366, 770);

        PanelGate.setBackground(new java.awt.Color(248, 255, 245));
        PanelGate.setPreferredSize(new java.awt.Dimension(1366, 768));

        BtnSignIn.setBackground(new java.awt.Color(248, 255, 245));
        BtnSignIn.setText(bundle.getString("APP.BtnSignIn.text")); // NOI18N
        BtnSignIn.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        BtnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSignInActionPerformed(evt);
            }
        });

        BtnSignUp.setBackground(new java.awt.Color(248, 255, 245));
        BtnSignUp.setText(bundle.getString("APP.BtnSignUp.text")); // NOI18N
        BtnSignUp.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        BtnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSignUpActionPerformed(evt);
            }
        });

        BtnLanguage.setBackground(new java.awt.Color(204, 255, 204));
        BtnLanguage.setFont(new java.awt.Font("Traditional Arabic", 1, 12)); // NOI18N
        BtnLanguage.setText(bundle.getString("APP.BtnLanguage.text")); // NOI18N
        BtnLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLanguageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelGateLayout = new javax.swing.GroupLayout(PanelGate);
        PanelGate.setLayout(PanelGateLayout);
        PanelGateLayout.setHorizontalGroup(
            PanelGateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelGateLayout.createSequentialGroup()
                .addContainerGap(545, Short.MAX_VALUE)
                .addGroup(PanelGateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelGateLayout.createSequentialGroup()
                        .addComponent(BtnLanguage)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelGateLayout.createSequentialGroup()
                        .addGroup(PanelGateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(BtnSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                            .addComponent(BtnSignIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(542, 542, 542))))
        );
        PanelGateLayout.setVerticalGroup(
            PanelGateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGateLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(BtnLanguage)
                .addGap(264, 264, 264)
                .addComponent(BtnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(BtnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(315, Short.MAX_VALUE))
        );

        getContentPane().add(PanelGate);
        PanelGate.setBounds(0, 0, 1366, 730);

        PanelSignIn.setBackground(new java.awt.Color(246, 254, 246));
        PanelSignIn.setMaximumSize(new java.awt.Dimension(1366, 768));
        PanelSignIn.setMinimumSize(new java.awt.Dimension(1366, 768));
        PanelSignIn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelTitle.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        PanelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelTitle.setText(bundle.getString("APP.PanelTitle.text")); // NOI18N
        PanelSignIn.add(PanelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 257, 72));

        LoginContainer.setBackground(new java.awt.Color(243, 251, 241));
        LoginContainer.setLayout(new java.awt.GridLayout(5, 0, 0, 5));

        LblUsername.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblUsername.setText(bundle.getString("APP.LblUsername.text")); // NOI18N
        LoginContainer.add(LblUsername);

        LTFUsername.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        LTFUsername.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        LTFUsername.setAlignmentX(5.5F);
        LTFUsername.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(33, 104, 73), 3, true));
        LTFUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        LTFUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LTFUsernameActionPerformed(evt);
            }
        });
        LoginContainer.add(LTFUsername);

        LblPassword.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblPassword.setText(bundle.getString("APP.LblPassword.text")); // NOI18N
        LoginContainer.add(LblPassword);

        LTFPassword.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        LTFPassword.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        LTFPassword.setText(bundle.getString("APP.LTFPassword.text")); // NOI18N
        LTFPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(33, 104, 73), 3, true));
        LTFPassword.setPreferredSize(new java.awt.Dimension(6, 22));
        LTFPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                LTFPasswordFocusGained(evt);
            }
        });
        LTFPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LTFPasswordActionPerformed(evt);
            }
        });
        LoginContainer.add(LTFPassword);

        LblForgetPassword.setFont(new java.awt.Font("Traditional Arabic", 1, 12)); // NOI18N
        LblForgetPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblForgetPassword.setText(bundle.getString("APP.LblForgetPassword.text")); // NOI18N
        LblForgetPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginContainer.add(LblForgetPassword);

        PanelSignIn.add(LoginContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 280, 190));

        LBtnSignIn.setBackground(new java.awt.Color(33, 104, 73));
        LBtnSignIn.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LBtnSignIn.setForeground(new java.awt.Color(255, 255, 255));
        LBtnSignIn.setText(bundle.getString("APP.LBtnSignIn.text")); // NOI18N
        LBtnSignIn.setAlignmentY(0.0F);
        LBtnSignIn.setBorder(null);
        LBtnSignIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LBtnSignIn.setDefaultCapable(false);
        LBtnSignIn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LBtnSignIn.setMaximumSize(new java.awt.Dimension(80, 30));
        LBtnSignIn.setMinimumSize(new java.awt.Dimension(40, 15));
        LBtnSignIn.setPreferredSize(new java.awt.Dimension(100, 40));
        LBtnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LBtnSignInActionPerformed(evt);
            }
        });
        PanelSignIn.add(LBtnSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 480, 124, -1));

        LBtnBack.setBackground(new java.awt.Color(121, 110, 113));
        LBtnBack.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LBtnBack.setForeground(new java.awt.Color(255, 255, 255));
        LBtnBack.setText(bundle.getString("APP.LBtnBack.text")); // NOI18N
        LBtnBack.setAlignmentY(0.0F);
        LBtnBack.setBorder(null);
        LBtnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LBtnBack.setDefaultCapable(false);
        LBtnBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LBtnBack.setMaximumSize(new java.awt.Dimension(80, 30));
        LBtnBack.setMinimumSize(new java.awt.Dimension(40, 15));
        LBtnBack.setPreferredSize(new java.awt.Dimension(100, 40));
        LBtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LBtnBackActionPerformed(evt);
            }
        });
        PanelSignIn.add(LBtnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 480, -1, -1));

        PasswordVisibility.setBackground(new java.awt.Color(255, 255, 255));
        PasswordVisibility.setFont(new java.awt.Font("Traditional Arabic", 1, 12)); // NOI18N
        PasswordVisibility.setText(bundle.getString("APP.PasswordVisibility.text")); // NOI18N
        PasswordVisibility.setBorder(null);
        PasswordVisibility.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PasswordVisibility.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordVisibilityActionPerformed(evt);
            }
        });
        PanelSignIn.add(PasswordVisibility, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 50, 30));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/images/login.png"))); // NOI18N
        Background.setText(bundle.getString("APP.Background.text")); // NOI18N
        PanelSignIn.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 730));

        getContentPane().add(PanelSignIn);
        PanelSignIn.setBounds(0, 0, 1370, 730);

        PanelSignUp.setBackground(new java.awt.Color(237, 255, 230));
        PanelSignUp.setMaximumSize(new java.awt.Dimension(1366, 768));
        PanelSignUp.setMinimumSize(new java.awt.Dimension(1366, 768));
        PanelSignUp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelTitle1.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        PanelTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelTitle1.setText(bundle.getString("APP.PanelTitle1.text")); // NOI18N
        PanelSignUp.add(PanelTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 530, 72));

        RegisterContainer.setBackground(new java.awt.Color(243, 251, 241));
        RegisterContainer.setLayout(new java.awt.GridLayout(10, 0, 0, 5));

        LblName.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblName.setText(bundle.getString("APP.LblName.text")); // NOI18N
        RegisterContainer.add(LblName);
        LblName.getAccessibleContext().setAccessibleParent(RegisterContainer);

        RTFFullName.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        RTFFullName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        RTFFullName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(33, 104, 73), 3, true));
        RTFFullName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        RTFFullName.setMaximumSize(new java.awt.Dimension(100, 200));
        RegisterContainer.add(RTFFullName);
        RTFFullName.getAccessibleContext().setAccessibleParent(RegisterContainer);

        LblUsername1.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblUsername1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblUsername1.setText(bundle.getString("APP.LblUsername1.text")); // NOI18N
        RegisterContainer.add(LblUsername1);
        LblUsername1.getAccessibleContext().setAccessibleParent(RegisterContainer);

        RTFUsername.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        RTFUsername.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        RTFUsername.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(33, 104, 73), 3, true));
        RTFUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        RegisterContainer.add(RTFUsername);
        RTFUsername.getAccessibleContext().setAccessibleParent(RegisterContainer);

        LblPhone.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblPhone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblPhone.setText(bundle.getString("APP.LblPhone.text")); // NOI18N
        RegisterContainer.add(LblPhone);
        LblPhone.getAccessibleContext().setAccessibleParent(RegisterContainer);

        RTFPhone.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        RTFPhone.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        RTFPhone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(33, 104, 73), 3, true));
        RTFPhone.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        RegisterContainer.add(RTFPhone);
        RTFPhone.getAccessibleContext().setAccessibleParent(RegisterContainer);

        LblAdress.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblAdress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblAdress.setText(bundle.getString("APP.LblAdress.text")); // NOI18N
        RegisterContainer.add(LblAdress);
        LblAdress.getAccessibleContext().setAccessibleParent(RegisterContainer);

        RTFAdress.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        RTFAdress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        RTFAdress.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(33, 104, 73), 3, true));
        RTFAdress.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        RegisterContainer.add(RTFAdress);
        RTFAdress.getAccessibleContext().setAccessibleParent(RegisterContainer);

        LblPassword1.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        LblPassword1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblPassword1.setText(bundle.getString("APP.LblPassword1.text")); // NOI18N
        RegisterContainer.add(LblPassword1);
        LblPassword1.getAccessibleContext().setAccessibleParent(RegisterContainer);

        RTFPassword.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        RTFPassword.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        RTFPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(33, 104, 73), 3, true));
        RTFPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        RegisterContainer.add(RTFPassword);
        RTFPassword.getAccessibleContext().setAccessibleParent(RegisterContainer);

        PanelSignUp.add(RegisterContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 280, -1));

        BtnSign1.setBackground(new java.awt.Color(33, 104, 73));
        BtnSign1.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        BtnSign1.setForeground(new java.awt.Color(255, 255, 255));
        BtnSign1.setText(bundle.getString("APP.BtnSign1.text")); // NOI18N
        BtnSign1.setAlignmentY(0.0F);
        BtnSign1.setBorder(null);
        BtnSign1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSign1.setDefaultCapable(false);
        BtnSign1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnSign1.setMaximumSize(new java.awt.Dimension(80, 30));
        BtnSign1.setMinimumSize(new java.awt.Dimension(40, 15));
        BtnSign1.setPreferredSize(new java.awt.Dimension(100, 40));
        BtnSign1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSign1ActionPerformed(evt);
            }
        });
        PanelSignUp.add(BtnSign1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 610, 124, -1));

        BtnBack1.setBackground(new java.awt.Color(121, 110, 113));
        BtnBack1.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        BtnBack1.setForeground(new java.awt.Color(255, 255, 255));
        BtnBack1.setText(bundle.getString("APP.BtnBack1.text")); // NOI18N
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
        PanelSignUp.add(BtnBack1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 610, -1, -1));

        Background1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green/ams/assets/images/register.png"))); // NOI18N
        Background1.setText(bundle.getString("APP.Background1.text")); // NOI18N
        PanelSignUp.add(Background1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 730));

        getContentPane().add(PanelSignUp);
        PanelSignUp.setBounds(0, 0, 1370, 730);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void SplashMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SplashMousePressed
        // TODO add your handling code here:


    }//GEN-LAST:event_SplashMousePressed

    private void LBtnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LBtnSignInActionPerformed
        // TODO add your handling code here:

        user.setEmail(LTFUsername.getText().trim());
        user.setPassword(LTFPassword.getText().trim());

        user.getEmail();
        user.getPassword();

        if (auth.Login(user)) {

            user.setId(GLOBAL.user_id);
            System.out.println(user.getId());
            user_frame = new USER();

            user_frame.setVisible(true);

            this.dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "البريد الاكتروني او كلمة المرور خطاء", "تحذير", 2);

            int fb = JOptionPane.showConfirmDialog(rootPane, " اعادة المحاولة");

            switch (fb) {
                case 1:
                    System.exit(0);
                case 0:
                    MoveTo(PanelSignIn, PanelGate);
                    break;
                default:
                    System.out.println("999");
                    break;
            }
        }

    }//GEN-LAST:event_LBtnSignInActionPerformed

    private void LBtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LBtnBackActionPerformed
        // TODO add your handling code here:
        MoveTo(PanelSignIn, PanelGate);

    }//GEN-LAST:event_LBtnBackActionPerformed

    private void BtnSign1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSign1ActionPerformed

        // TODO add your handling code here:
        user.setFull_name(RTFFullName.getText().trim());
        user.setEmail(RTFUsername.getText().trim());
        user.setAddress(RTFAdress.getText().trim());
        user.setPhone_number(RTFPhone.getText().trim());
        user.setRole(RTFPassword.getText().trim());
        user.setPassword(RTFPassword.getText().trim());
        user.setCreated_date(current_date);

        if (isUserValid(user)) {

            // Proceed with the next steps
            if (auth.Register(user)) {
                user_frame = new USER();
                user_frame.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "خطاء في انشاء الحساب", "تحذير", 2);

                int fb = JOptionPane.showConfirmDialog(rootPane, " اعادة المحاولة");

                switch (fb) {
                    case 1:
                        System.exit(0);
                    case 0:
                        MoveTo(PanelSignUp, PanelGate);
                        break;
                    default:
                        System.out.println("999");
                        break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "تاكد ان جميع الخانات صحيحة");
        }

    }//GEN-LAST:event_BtnSign1ActionPerformed

    private void BtnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBack1ActionPerformed
        // TODO add your handling code here:

        MoveTo(PanelSignUp, PanelGate);

    }//GEN-LAST:event_BtnBack1ActionPerformed

    private void LTFUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LTFUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LTFUsernameActionPerformed

    private void LTFPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LTFPasswordFocusGained
        // TODO add your handling code here:

        LTFPassword.setText("");

    }//GEN-LAST:event_LTFPasswordFocusGained

    private void PasswordVisibilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordVisibilityActionPerformed
        // TODO add your handling code here:

        password_visible = !password_visible;

        if (password_visible) {
            LTFPassword.setEchoChar((char) 0); // Show password
            PasswordVisibility.setText((GLOBAL.currentLocale.getLanguage().equals("en")) ? "Hide" : "اخفاء");
        } else {
            PasswordVisibility.setText((GLOBAL.currentLocale.getLanguage().equals("en")) ? "Show" : "اظهار");
            LTFPassword.setEchoChar('•'); // Hide password
        }
        System.out.println(LTFPassword.getLocale());

    }//GEN-LAST:event_PasswordVisibilityActionPerformed

    private void LTFPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LTFPasswordActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_LTFPasswordActionPerformed

    private void BtnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSignInActionPerformed
        // TODO add your handling code here:

        MoveTo(PanelGate, PanelSignIn);

    }//GEN-LAST:event_BtnSignInActionPerformed

    private void BtnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSignUpActionPerformed
        // TODO add your handling code here:

        MoveTo(PanelGate, PanelSignUp);

    }//GEN-LAST:event_BtnSignUpActionPerformed

    private void BtnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnStartActionPerformed
        // TODO add your handling code here:

        MoveTo(PanelSplash, PanelGate);

    }//GEN-LAST:event_BtnStartActionPerformed

    private void BtnLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLanguageActionPerformed
        // TODO add your handling code here:

        switchLanguage();

    }//GEN-LAST:event_BtnLanguageActionPerformed

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
            java.util.logging.Logger.getLogger(APP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(APP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(APP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(APP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new APP().setVisible(true);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Background1;
    private javax.swing.JButton BtnBack1;
    private javax.swing.JButton BtnLanguage;
    private javax.swing.JButton BtnSign1;
    private green.ams.components.GButton BtnSignIn;
    private green.ams.components.GButton BtnSignUp;
    private green.ams.components.GButton BtnStart;
    private javax.swing.JButton LBtnBack;
    private javax.swing.JButton LBtnSignIn;
    private javax.swing.JPasswordField LTFPassword;
    private javax.swing.JTextField LTFUsername;
    private javax.swing.JLabel LblAdress;
    private javax.swing.JLabel LblForgetPassword;
    private javax.swing.JLabel LblName;
    private javax.swing.JLabel LblPassword;
    private javax.swing.JLabel LblPassword1;
    private javax.swing.JLabel LblPhone;
    private javax.swing.JLabel LblUsername;
    private javax.swing.JLabel LblUsername1;
    private javax.swing.JPanel LoginContainer;
    private javax.swing.JPanel PanelGate;
    private javax.swing.JPanel PanelSignIn;
    private javax.swing.JPanel PanelSignUp;
    private javax.swing.JPanel PanelSplash;
    private javax.swing.JLabel PanelTitle;
    private javax.swing.JLabel PanelTitle1;
    private javax.swing.JButton PasswordVisibility;
    private javax.swing.JTextField RTFAdress;
    private javax.swing.JTextField RTFFullName;
    private javax.swing.JTextField RTFPassword;
    private javax.swing.JTextField RTFPhone;
    private javax.swing.JTextField RTFUsername;
    private javax.swing.JPanel RegisterContainer;
    private javax.swing.JLabel Splash;
    // End of variables declaration//GEN-END:variables

    private void Start() {

        PanelSplash.setVisible(true);
        PanelGate.setVisible(false);
        PanelSignIn.setVisible(false);
        PanelSignUp.setVisible(false);

    }
    
    private void MoveTo(JPanel o1, JPanel o2) {
        o1.setVisible(false);
        o2.setVisible(true);
    }
    
    private void switchLanguage() {

        // Toggle between English and Arabic
        if (GLOBAL.currentLocale.getLanguage().equals("en")) {
            GLOBAL.currentLocale = new Locale("ar", "SA");
            System.out.println(GLOBAL.currentLocale.getLanguage());
        } else {
            GLOBAL.currentLocale = new Locale("en");
            System.out.println(GLOBAL.currentLocale.getLanguage());
        }

        // Reload ResourceBundle with correct package
        GLOBAL.bundle = ResourceBundle.getBundle("green.ams.Bundle", GLOBAL.currentLocale);

        // Update UI Components
        GLOBAL.updateTextFields(this, "APP", GLOBAL.bundle);
    }



    public static boolean isUserValid(User user) {
        return user.getEmail() != null && !user.getFull_name().isEmpty()
                && user.getEmail() != null && !user.getEmail().isEmpty()
                && user.getPhone_number() != null && !user.getPhone_number().isEmpty()
                && user.getAddress() != null && !user.getAddress().isEmpty()
                && user.getPassword() != null && !user.getPassword().isEmpty();
    }

}

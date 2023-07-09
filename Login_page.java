package fees_management_system;
import static fees_management_system.Detail_page.password;
import static fees_management_system.Detail_page.path;
import static fees_management_system.Detail_page.username;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


public class Login_page extends javax.swing.JFrame 
{
    public Login_page() 
    {
        initComponents();
    }

    String uname,ppassword;
    
    boolean validation()
    {   
        uname= TF1.getText();
        ppassword= PasswordField1.getText();
        
        if (uname.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please enter User Name ");
        }
        else if (ppassword.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please  enter Password ");
        }
        return true;
    }
    
    public void check_password()
    {   
        ppassword= PasswordField1.getText();
        
        if (ppassword.length()<8)
        {
            Label4_password_error.setText("Password should be of atleast 8 digit ");
        }
        else
        {
            Label4_password_error.setText("");
        }
    }
    
    public void userVerification(String UserName, String Password)
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con       = DriverManager.getConnection(path, username, password);
            String sql           = "select * from signup_page where UserName=? and Password=?";
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setString(1, UserName);
            st.setString(2, Password);
            ResultSet rs = st.executeQuery();
            
            if (rs.next())
            {
                Home_Page home = new Home_Page();
                home.show();
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Wrong UserName or Password");
            }
        } 
        catch (Exception e)
        {
             JOptionPane.showMessageDialog(this, "Error : "+e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel1 = new javax.swing.JPanel();
        Label1_login = new javax.swing.JLabel();
        Panel2 = new javax.swing.JPanel();
        label2_enter_uname = new javax.swing.JLabel();
        Label3_enter_password = new javax.swing.JLabel();
        TF1 = new javax.swing.JTextField();
        PasswordField1 = new javax.swing.JPasswordField();
        Button1_signup = new javax.swing.JButton();
        Button2_login = new javax.swing.JButton();
        Button3_exit = new javax.swing.JButton();
        Label4_password_error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Panel1.setBackground(new java.awt.Color(0, 93, 93));
        Panel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Label1_login.setBackground(new java.awt.Color(255, 255, 255));
        Label1_login.setFont(new java.awt.Font("Bodoni MT", 1, 48)); // NOI18N
        Label1_login.setForeground(new java.awt.Color(255, 255, 255));
        Label1_login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label1_login.setText("Log In");

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label1_login, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Label1_login)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        Panel2.setBackground(new java.awt.Color(0, 153, 153));
        Panel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label2_enter_uname.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        label2_enter_uname.setForeground(new java.awt.Color(255, 255, 255));
        label2_enter_uname.setText("Enter UserName :");
        label2_enter_uname.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Label3_enter_password.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        Label3_enter_password.setForeground(new java.awt.Color(255, 255, 255));
        Label3_enter_password.setText("Enter Password :");
        Label3_enter_password.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TF1.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        TF1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        PasswordField1.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        PasswordField1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PasswordField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PasswordField1KeyReleased(evt);
            }
        });

        Button1_signup.setBackground(new java.awt.Color(0, 93, 93));
        Button1_signup.setFont(new java.awt.Font("Bodoni MT", 1, 40)); // NOI18N
        Button1_signup.setForeground(new java.awt.Color(255, 255, 255));
        Button1_signup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/signup.png"))); // NOI18N
        Button1_signup.setText("SignUp");
        Button1_signup.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Button1_signup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Button1_signupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Button1_signupMouseExited(evt);
            }
        });
        Button1_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button1_signupActionPerformed(evt);
            }
        });

        Button2_login.setBackground(new java.awt.Color(0, 93, 93));
        Button2_login.setFont(new java.awt.Font("Bodoni MT", 1, 40)); // NOI18N
        Button2_login.setForeground(new java.awt.Color(255, 255, 255));
        Button2_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/login.png"))); // NOI18N
        Button2_login.setText("LogIn");
        Button2_login.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Button2_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Button2_loginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Button2_loginMouseExited(evt);
            }
        });
        Button2_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button2_loginActionPerformed(evt);
            }
        });

        Button3_exit.setBackground(new java.awt.Color(0, 93, 93));
        Button3_exit.setFont(new java.awt.Font("Bodoni MT", 1, 40)); // NOI18N
        Button3_exit.setForeground(new java.awt.Color(255, 255, 255));
        Button3_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/exit.png"))); // NOI18N
        Button3_exit.setText("Exit");
        Button3_exit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Button3_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Button3_exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Button3_exitMouseExited(evt);
            }
        });
        Button3_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button3_exitActionPerformed(evt);
            }
        });

        Label4_password_error.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        Label4_password_error.setForeground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout Panel2Layout = new javax.swing.GroupLayout(Panel2);
        Panel2.setLayout(Panel2Layout);
        Panel2Layout.setHorizontalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(Button1_signup, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                        .addGap(35, 35, 35)
                        .addComponent(Button2_login, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                        .addGap(41, 41, 41)
                        .addComponent(Button3_exit, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                    .addGroup(Panel2Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label2_enter_uname, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(Label3_enter_password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(47, 47, 47)
                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label4_password_error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TF1)
                            .addComponent(PasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
                        .addGap(39, 39, 39)))
                .addGap(106, 106, 106))
        );
        Panel2Layout.setVerticalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2_enter_uname, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(TF1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label3_enter_password, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(PasswordField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label4_password_error, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addGap(45, 45, 45)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button1_signup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Button2_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Button3_exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Button2_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button2_loginActionPerformed
       uname     = TF1.getText();
       ppassword = PasswordField1.getText();
      if (validation())
        try 
        {
            userVerification(uname, ppassword);
        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(this, "Error : "+ex.getMessage());
        }
    }//GEN-LAST:event_Button2_loginActionPerformed

    private void PasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordField1KeyPressed
       check_password();
    }//GEN-LAST:event_PasswordField1KeyPressed

    private void PasswordField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordField1KeyReleased
       check_password();
    }//GEN-LAST:event_PasswordField1KeyReleased

    private void Button1_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button1_signupActionPerformed
       Signup_page signup=new Signup_page();
       signup.show();
       this.dispose();
    }//GEN-LAST:event_Button1_signupActionPerformed

    private void Button3_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button3_exitActionPerformed
       System.exit(0);
    }//GEN-LAST:event_Button3_exitActionPerformed

    private void Button1_signupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button1_signupMouseEntered
       Color a = new Color(0,43,43);
       Button1_signup.setBackground(a);
    }//GEN-LAST:event_Button1_signupMouseEntered

    private void Button1_signupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button1_signupMouseExited
       Color a = new Color(0,93,93);
       Button1_signup.setBackground(a);
    }//GEN-LAST:event_Button1_signupMouseExited

    private void Button2_loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button2_loginMouseEntered
       Color a = new Color(0,43,43);
       Button2_login.setBackground(a);
    }//GEN-LAST:event_Button2_loginMouseEntered

    private void Button2_loginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button2_loginMouseExited
       Color a = new Color(0,93,93);
       Button2_login.setBackground(a);
    }//GEN-LAST:event_Button2_loginMouseExited

    private void Button3_exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button3_exitMouseEntered
       Color a = new Color(0,43,43);
       Button3_exit.setBackground(a);
    }//GEN-LAST:event_Button3_exitMouseEntered

    private void Button3_exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button3_exitMouseExited
       Color a = new Color(0,93,93);
       Button3_exit.setBackground(a);
    }//GEN-LAST:event_Button3_exitMouseExited

    
    public static void main(String args[]) 
    {
       
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try 
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if ("Nimbus".equals(info.getName())) 
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) 
        {
            java.util.logging.Logger.getLogger(Login_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Login_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (IllegalAccessException ex) 
        {
            java.util.logging.Logger.getLogger(Login_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (javax.swing.UnsupportedLookAndFeelException ex) 
        {
            java.util.logging.Logger.getLogger(Login_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                new Login_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button1_signup;
    private javax.swing.JButton Button2_login;
    private javax.swing.JButton Button3_exit;
    private javax.swing.JLabel Label1_login;
    private javax.swing.JLabel Label3_enter_password;
    private javax.swing.JLabel Label4_password_error;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JPasswordField PasswordField1;
    private javax.swing.JTextField TF1;
    private javax.swing.JLabel label2_enter_uname;
    // End of variables declaration//GEN-END:variables
}

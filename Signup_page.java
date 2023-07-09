package fees_management_system;
import static fees_management_system.Detail_page.password;
import java.sql.*;
import static fees_management_system.Detail_page.path;
import static fees_management_system.Detail_page.username;
import java.awt.Color;
import java.util.Date;
import javax.swing.JOptionPane;  
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class Signup_page extends javax.swing.JFrame 
{
    public Signup_page() 
    {
        initComponents();
    }
    
    String fname, lname, uname, ppassword, con_password, contact, mydob;
    Date dob;
    int id=0;
    
    public int getid()
    {
        ResultSet rs=null;
        try 
        {
            Connection conn = (Connection) DriverManager.getConnection(path, username, password);
            String sql      = "select max(id) from signup_page";
            Statement st    = conn.createStatement();
            rs= st.executeQuery(sql);
                   
                while (rs.next())
                {   
                    id=rs.getInt(1);
                    id++;
                }                      
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }     
        return id;
    }
    
    public boolean validation()
    {        
        if (fname.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please enter First Name ");
        }
        else if (lname.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please  enter Last Name ");
        }
        else if (uname.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please enter the UserName ");
        }
        
        else if (ppassword.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please  enter the Password ");
        }
        else if (con_password.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Plz Confirm the Password ");
        }
        else if (contact.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please enter the Contact Number ");
        }
        else if (dob.equals("null"))
        {
            JOptionPane.showMessageDialog(this, "Please enter the D.O.B ");
        }
        else if (!ppassword.equals(con_password))
        {
            JOptionPane.showMessageDialog(this, "Password not matched ");
        }
        return true;        
    }
    
    public void check_password()
    {   
        ppassword= PasswordField1.getText();
        if (ppassword.length()<8)
        {
            label_password_error.setText("Password should be of atleast 8 digit ");
        }
        else
        {
            label_password_error.setText("");
        }
    }
    
    public void check_con_password()
    {
        con_password= PasswordField_confirm.getText();
        if (con_password.length()<8)
        {
            label_password_error1.setText(" Password should be of atleast 8 digit ");
        }
        else
        {
            label_password_error1.setText("");
        }
    }
    
    public void check_contact()
    {
        contact= TF4.getText();
        if (contact.length()==10)
        {
            label_contact_length.setText("");
        }
        else
        {
            label_contact_length.setText("Contact should be of 10 digit");
        }
    }
    
   
    public void insert_SignUp_details()
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        mydob=format.format(dob);
        try 
        {
            Connection conn      = (Connection) DriverManager.getConnection(path, username, password);         
            String sql           = "insert into signup_page values(?,?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt   (1, getid());
            st.setString(2, fname);
            st.setString(3, lname);
            st.setString(4, uname);
            st.setString(5, ppassword);
            st.setString(6, con_password);
            st.setString(7, mydob);
            st.setString(8, contact);
            
            int rowcount=st.executeUpdate();
                if (rowcount==1)
                {
                    JOptionPane.showMessageDialog(this, "Record added successfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Record not added");
                }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
       
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        label_heading = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        label_fname = new javax.swing.JLabel();
        label_lname = new javax.swing.JLabel();
        label_username = new javax.swing.JLabel();
        label_password = new javax.swing.JLabel();
        label_con_password = new javax.swing.JLabel();
        label_dob = new javax.swing.JLabel();
        label_contactno = new javax.swing.JLabel();
        PasswordField_confirm = new javax.swing.JPasswordField();
        PasswordField1 = new javax.swing.JPasswordField();
        Button_signup = new javax.swing.JButton();
        Button_login = new javax.swing.JButton();
        TF2 = new javax.swing.JTextField();
        TF3 = new javax.swing.JTextField();
        TF4 = new javax.swing.JTextField();
        DC1 = new com.toedter.calendar.JDateChooser();
        TF1 = new javax.swing.JTextField();
        label_password_error = new javax.swing.JLabel();
        label_password_error1 = new javax.swing.JLabel();
        label_contact_length = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(0, 93, 93));
        panel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_heading.setFont(new java.awt.Font("Bodoni MT", 1, 60)); // NOI18N
        label_heading.setForeground(new java.awt.Color(255, 255, 255));
        label_heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_heading.setText("SignUp");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_heading, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
        );

        panel2.setBackground(new java.awt.Color(0, 153, 153));
        panel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_fname.setFont(new java.awt.Font("Bodoni MT", 1, 28)); // NOI18N
        label_fname.setForeground(new java.awt.Color(255, 255, 255));
        label_fname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_fname.setText("First Name :");
        label_fname.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label_fname.setPreferredSize(null);

        label_lname.setFont(new java.awt.Font("Bodoni MT", 1, 28)); // NOI18N
        label_lname.setForeground(new java.awt.Color(255, 255, 255));
        label_lname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_lname.setText("Last Name :");
        label_lname.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label_lname.setPreferredSize(null);

        label_username.setFont(new java.awt.Font("Bodoni MT", 1, 28)); // NOI18N
        label_username.setForeground(new java.awt.Color(255, 255, 255));
        label_username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_username.setText(" UserName :");
        label_username.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label_username.setPreferredSize(null);

        label_password.setFont(new java.awt.Font("Bodoni MT", 1, 28)); // NOI18N
        label_password.setForeground(new java.awt.Color(255, 255, 255));
        label_password.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_password.setText("Password :");
        label_password.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label_password.setPreferredSize(null);

        label_con_password.setFont(new java.awt.Font("Bodoni MT", 1, 28)); // NOI18N
        label_con_password.setForeground(new java.awt.Color(255, 255, 255));
        label_con_password.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_con_password.setText("Confirm Password :");
        label_con_password.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label_con_password.setPreferredSize(null);

        label_dob.setFont(new java.awt.Font("Bodoni MT", 1, 28)); // NOI18N
        label_dob.setForeground(new java.awt.Color(255, 255, 255));
        label_dob.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_dob.setText("D.O.B");
        label_dob.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label_dob.setPreferredSize(null);

        label_contactno.setFont(new java.awt.Font("Bodoni MT", 1, 28)); // NOI18N
        label_contactno.setForeground(new java.awt.Color(255, 255, 255));
        label_contactno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_contactno.setText("Contact Number :");
        label_contactno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label_contactno.setPreferredSize(null);

        PasswordField_confirm.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PasswordField_confirm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PasswordField_confirmKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PasswordField_confirmKeyReleased(evt);
            }
        });

        PasswordField1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PasswordField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PasswordField1KeyReleased(evt);
            }
        });

        Button_signup.setBackground(new java.awt.Color(0, 93, 93));
        Button_signup.setFont(new java.awt.Font("Bodoni MT", 1, 43)); // NOI18N
        Button_signup.setForeground(new java.awt.Color(255, 255, 255));
        Button_signup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/signup.png"))); // NOI18N
        Button_signup.setText(" SignUp");
        Button_signup.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Button_signup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Button_signupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Button_signupMouseExited(evt);
            }
        });
        Button_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_signupActionPerformed(evt);
            }
        });

        Button_login.setBackground(new java.awt.Color(0, 93, 93));
        Button_login.setFont(new java.awt.Font("Bodoni MT", 1, 43)); // NOI18N
        Button_login.setForeground(new java.awt.Color(255, 255, 255));
        Button_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/login.png"))); // NOI18N
        Button_login.setText(" LogIn");
        Button_login.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Button_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Button_loginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Button_loginMouseExited(evt);
            }
        });
        Button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_loginActionPerformed(evt);
            }
        });

        TF2.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        TF2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TF3.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        TF3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TF4.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        TF4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TF4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TF4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TF4KeyReleased(evt);
            }
        });

        DC1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DC1.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N

        TF1.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        TF1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        label_password_error.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        label_password_error.setForeground(new java.awt.Color(255, 255, 204));
        label_password_error.setText(" ");

        label_password_error1.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        label_password_error1.setForeground(new java.awt.Color(255, 255, 204));
        label_password_error1.setText(" ");

        label_contact_length.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        label_contact_length.setForeground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_username, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_con_password, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_password, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_fname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PasswordField_confirm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(Button_signup, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(Button_login, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label_dob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label_contactno, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
                                .addGap(54, 54, 54)
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TF4, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DC1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(45, 45, 45)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(label_password_error1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addComponent(label_password_error, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_contact_length, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TF1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, Short.MAX_VALUE)
                        .addComponent(label_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(TF2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, Short.MAX_VALUE)))
                .addGap(22, 22, 22)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_username, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_password, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(label_password_error, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_con_password, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(label_password_error1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PasswordField_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DC1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_contactno, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_contact_length, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_signup, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_login, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Button_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_signupActionPerformed
        fname = TF1.getText();
        lname = TF2.getText();
        uname = TF3.getText();
        ppassword    = PasswordField1.getText();
        con_password = PasswordField_confirm.getText();
        contact = TF4.getText();
        dob     = DC1.getDate();


    if (validation())
        try 
        {
            insert_SignUp_details();
            Login_page a = new Login_page();
            a.setVisible(true);
            this.dispose();
        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(this, "Error : "+ex.getMessage());
        }
    }//GEN-LAST:event_Button_signupActionPerformed

    private void PasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordField1KeyPressed
        check_password();
    }//GEN-LAST:event_PasswordField1KeyPressed

    private void PasswordField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordField1KeyReleased
        check_password();
    }//GEN-LAST:event_PasswordField1KeyReleased

    private void PasswordField_confirmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordField_confirmKeyPressed
        check_con_password();
    }//GEN-LAST:event_PasswordField_confirmKeyPressed

    private void PasswordField_confirmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordField_confirmKeyReleased
        check_con_password();
    }//GEN-LAST:event_PasswordField_confirmKeyReleased

    private void TF4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF4KeyPressed
        check_contact();        
    }//GEN-LAST:event_TF4KeyPressed

    private void TF4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF4KeyReleased
        check_contact();       
    }//GEN-LAST:event_TF4KeyReleased

    private void Button_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_loginActionPerformed
        Login_Page2 Login=new Login_Page2();
        Login.show();
        this.dispose();
    }//GEN-LAST:event_Button_loginActionPerformed

    private void Button_signupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_signupMouseEntered
        Color a = new Color(0,43,43);
        Button_signup.setBackground(a);
    }//GEN-LAST:event_Button_signupMouseEntered

    private void Button_signupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_signupMouseExited
        Color a = new Color(0,93,93);
        Button_signup.setBackground(a);
    }//GEN-LAST:event_Button_signupMouseExited

    private void Button_loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_loginMouseEntered
        Color a = new Color(0,43,43);
        Button_login.setBackground(a);
    }//GEN-LAST:event_Button_loginMouseEntered

    private void Button_loginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_loginMouseExited
        Color a = new Color(0,93,93);
        Button_login.setBackground(a);
    }//GEN-LAST:event_Button_loginMouseExited

    
    public static void main(String args[]) 
    {
      
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
            java.util.logging.Logger.getLogger(Signup_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                new Signup_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_login;
    private javax.swing.JButton Button_signup;
    private com.toedter.calendar.JDateChooser DC1;
    private javax.swing.JPasswordField PasswordField1;
    private javax.swing.JPasswordField PasswordField_confirm;
    private javax.swing.JTextField TF1;
    private javax.swing.JTextField TF2;
    private javax.swing.JTextField TF3;
    private javax.swing.JTextField TF4;
    private javax.swing.JLabel label_con_password;
    private javax.swing.JLabel label_contact_length;
    private javax.swing.JLabel label_contactno;
    private javax.swing.JLabel label_dob;
    private javax.swing.JLabel label_fname;
    private javax.swing.JLabel label_heading;
    private javax.swing.JLabel label_lname;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel label_password_error;
    private javax.swing.JLabel label_password_error1;
    private javax.swing.JLabel label_username;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    // End of variables declaration//GEN-END:variables
}

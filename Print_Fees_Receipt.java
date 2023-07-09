package fees_management_system;
import static fees_management_system.Detail_page.password;
import static fees_management_system.Detail_page.path;
import static fees_management_system.Detail_page.username;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.*;
import javax.swing.JFrame;

public class Print_Fees_Receipt extends javax.swing.JFrame 
{
    public Print_Fees_Receipt() 
    {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getRecords();
        Container c = getContentPane();
        c.setBackground(new Color(0,143,143));
    }
    
    public void getRecords() 
    {
        try 
        {
            Connection conn      = DriverManager.getConnection(path, username, password);
            PreparedStatement st = conn.prepareStatement("select * from add_fees_data order by Receipt_No desc limit 1 ");
            ResultSet rs         = st.executeQuery();
            rs.next();
            
            lbl_31.setText(rs.getString("Receipt_No"));
            lbl_32.setText(rs.getString("Payment_Mode"));
            
            String paymentmode= rs.getString("Payment_Mode");
            if (paymentmode.equals("Cash"))
            {
                lbl_6.setText ("Cheque No :");
                lbl_33.setText("-");
                lbl_34.setText("-");
            }
            else if (paymentmode.equals("Cheque"))
            {
                lbl_6.setText("Cheque No :");
                lbl_33.setText(rs.getString("DD_Cheque_Number"));
                lbl_34.setText(rs.getString("Bank_Name"));
            }
            else if (paymentmode.equals("Demand Draft (DD)"))
            {
                lbl_6.setText("Demand Draft(DD) No :");
                lbl_33.setText(rs.getString("DD_Cheque_Number"));
                lbl_34.setText(rs.getString("Bank_Name"));
            }
            else if (paymentmode.equals("Card"))
            {
                lbl_6.setText ("Cheque No :");
                lbl_33.setText("-");
                lbl_34.setText(rs.getString("Bank_Name"));
            }
            
            lbl_38.setText(rs.getString("Date"));
            lbl_35.setText(rs.getString("Student_Name"));
            lbl_36.setText(rs.getString("Course_Name"));
            lbl_37.setText(rs.getString("Year_Semester"));
            lbl_39.setText(rs.getString("GSTIN"));
            lbl_40.setText(rs.getString("Recieved_From"));
            lbl_41.setText(rs.getString("Roll_Number"));
            lbl_42.setText(rs.getString("Mobile_Number"));
            lbl_43.setText(rs.getString("Father_Name"));
            
            lbl_23.setText(rs.getString("Annual_Charge"));
            lbl_26.setText(rs.getString("Tuition_Fees"));
            lbl_28.setText(rs.getString("Hostel_Fees"));
            lbl_19.setText(rs.getString("Amount"));
            lbl_44.setText(rs.getString("Amount_In_Words"));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel1 = new javax.swing.JPanel();
        Panel2 = new javax.swing.JPanel();
        Label1_home = new javax.swing.JLabel();
        Panel3 = new javax.swing.JPanel();
        Label2_search_records = new javax.swing.JLabel();
        Panel4 = new javax.swing.JPanel();
        Label4_course_list = new javax.swing.JLabel();
        Panel5 = new javax.swing.JPanel();
        Label5_view_all_records = new javax.swing.JLabel();
        Panel6 = new javax.swing.JPanel();
        Label6_back = new javax.swing.JLabel();
        Panel7 = new javax.swing.JPanel();
        Label7_logout = new javax.swing.JLabel();
        Panel8 = new javax.swing.JPanel();
        Label8_print = new javax.swing.JLabel();
        Panel9 = new javax.swing.JPanel();
        Label10_edit = new javax.swing.JLabel();
        Panel10 = new javax.swing.JPanel();
        lbl_1 = new javax.swing.JLabel();
        lbl_2 = new javax.swing.JLabel();
        lbl_3 = new javax.swing.JLabel();
        lbl_4 = new javax.swing.JLabel();
        lbl_5 = new javax.swing.JLabel();
        lbl_6 = new javax.swing.JLabel();
        lbl_7 = new javax.swing.JLabel();
        lbl_8 = new javax.swing.JLabel();
        lbl_9 = new javax.swing.JLabel();
        lbl_10 = new javax.swing.JLabel();
        Panel11 = new javax.swing.JPanel();
        lbl_11 = new javax.swing.JLabel();
        lbl_12 = new javax.swing.JLabel();
        lbl_13 = new javax.swing.JLabel();
        lbl_14 = new javax.swing.JLabel();
        lbl_15 = new javax.swing.JLabel();
        lbl_16 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        lbl_17 = new javax.swing.JLabel();
        lbl_18 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        lbl_19 = new javax.swing.JLabel();
        lbl_20 = new javax.swing.JLabel();
        lbl_21 = new javax.swing.JLabel();
        lbl_22 = new javax.swing.JLabel();
        lbl_23 = new javax.swing.JLabel();
        lbl_24 = new javax.swing.JLabel();
        lbl_25 = new javax.swing.JLabel();
        lbl_26 = new javax.swing.JLabel();
        lbl_27 = new javax.swing.JLabel();
        lbl_28 = new javax.swing.JLabel();
        lbl_29 = new javax.swing.JLabel();
        lbl_30 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        lbl_31 = new javax.swing.JLabel();
        lbl_32 = new javax.swing.JLabel();
        lbl_33 = new javax.swing.JLabel();
        lbl_34 = new javax.swing.JLabel();
        lbl_35 = new javax.swing.JLabel();
        lbl_36 = new javax.swing.JLabel();
        lbl_37 = new javax.swing.JLabel();
        lbl_38 = new javax.swing.JLabel();
        lbl_39 = new javax.swing.JLabel();
        lbl_40 = new javax.swing.JLabel();
        lbl_41 = new javax.swing.JLabel();
        lbl_42 = new javax.swing.JLabel();
        lbl_43 = new javax.swing.JLabel();
        lbl_44 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel1.setBackground(new java.awt.Color(0, 93, 93));
        Panel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.darkGray, null, null));

        Panel2.setBackground(new java.awt.Color(0, 93, 93));
        Panel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        Label1_home.setFont(new java.awt.Font("Bodoni MT", 1, 48)); // NOI18N
        Label1_home.setForeground(new java.awt.Color(255, 255, 255));
        Label1_home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label1_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/home.png"))); // NOI18N
        Label1_home.setText(" Home");
        Label1_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label1_homeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Label1_homeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Label1_homeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Panel2Layout = new javax.swing.GroupLayout(Panel2);
        Panel2.setLayout(Panel2Layout);
        Panel2Layout.setHorizontalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label1_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel2Layout.setVerticalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label1_home, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        Panel3.setBackground(new java.awt.Color(0, 93, 93));
        Panel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        Label2_search_records.setFont(new java.awt.Font("Bodoni MT", 1, 36)); // NOI18N
        Label2_search_records.setForeground(new java.awt.Color(255, 255, 255));
        Label2_search_records.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label2_search_records.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/search2.png"))); // NOI18N
        Label2_search_records.setText("Search Records");
        Label2_search_records.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label2_search_recordsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Label2_search_recordsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Label2_search_recordsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Panel3Layout = new javax.swing.GroupLayout(Panel3);
        Panel3.setLayout(Panel3Layout);
        Panel3Layout.setHorizontalGroup(
            Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label2_search_records, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel3Layout.setVerticalGroup(
            Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label2_search_records, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        Panel4.setBackground(new java.awt.Color(0, 93, 93));
        Panel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        Label4_course_list.setFont(new java.awt.Font("Bodoni MT", 1, 36)); // NOI18N
        Label4_course_list.setForeground(new java.awt.Color(255, 255, 255));
        Label4_course_list.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label4_course_list.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/list_1.png"))); // NOI18N
        Label4_course_list.setText("View Reports");
        Label4_course_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label4_course_listMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Label4_course_listMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Label4_course_listMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Panel4Layout = new javax.swing.GroupLayout(Panel4);
        Panel4.setLayout(Panel4Layout);
        Panel4Layout.setHorizontalGroup(
            Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label4_course_list, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel4Layout.setVerticalGroup(
            Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label4_course_list, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        Panel5.setBackground(new java.awt.Color(0, 93, 93));
        Panel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        Label5_view_all_records.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        Label5_view_all_records.setForeground(new java.awt.Color(255, 255, 255));
        Label5_view_all_records.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label5_view_all_records.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/view all record.png"))); // NOI18N
        Label5_view_all_records.setText("View All Records");
        Label5_view_all_records.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label5_view_all_recordsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Label5_view_all_recordsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Label5_view_all_recordsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Panel5Layout = new javax.swing.GroupLayout(Panel5);
        Panel5.setLayout(Panel5Layout);
        Panel5Layout.setHorizontalGroup(
            Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label5_view_all_records, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel5Layout.setVerticalGroup(
            Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label5_view_all_records, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        Panel6.setBackground(new java.awt.Color(0, 93, 93));
        Panel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        Label6_back.setFont(new java.awt.Font("Bodoni MT", 1, 50)); // NOI18N
        Label6_back.setForeground(new java.awt.Color(255, 255, 255));
        Label6_back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label6_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/logout_1.png"))); // NOI18N
        Label6_back.setText(" Exit");
        Label6_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label6_backMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Label6_backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Label6_backMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Panel6Layout = new javax.swing.GroupLayout(Panel6);
        Panel6.setLayout(Panel6Layout);
        Panel6Layout.setHorizontalGroup(
            Panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label6_back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel6Layout.setVerticalGroup(
            Panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label6_back, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        Panel7.setBackground(new java.awt.Color(0, 93, 93));
        Panel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        Label7_logout.setFont(new java.awt.Font("Bodoni MT", 1, 48)); // NOI18N
        Label7_logout.setForeground(new java.awt.Color(255, 255, 255));
        Label7_logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label7_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/logout.png"))); // NOI18N
        Label7_logout.setText(" Logout");
        Label7_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label7_logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Label7_logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Label7_logoutMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Panel7Layout = new javax.swing.GroupLayout(Panel7);
        Panel7.setLayout(Panel7Layout);
        Panel7Layout.setHorizontalGroup(
            Panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label7_logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel7Layout.setVerticalGroup(
            Panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label7_logout, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        Panel8.setBackground(new java.awt.Color(0, 93, 93));
        Panel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        Label8_print.setFont(new java.awt.Font("Bodoni MT", 1, 48)); // NOI18N
        Label8_print.setForeground(new java.awt.Color(255, 255, 255));
        Label8_print.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label8_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/printer-.png"))); // NOI18N
        Label8_print.setText(" Print");
        Label8_print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label8_printMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Label8_printMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Label8_printMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Panel8Layout = new javax.swing.GroupLayout(Panel8);
        Panel8.setLayout(Panel8Layout);
        Panel8Layout.setHorizontalGroup(
            Panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label8_print, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel8Layout.setVerticalGroup(
            Panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label8_print, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        Panel9.setBackground(new java.awt.Color(0, 93, 93));
        Panel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        Label10_edit.setFont(new java.awt.Font("Bodoni MT", 0, 48)); // NOI18N
        Label10_edit.setForeground(new java.awt.Color(255, 255, 255));
        Label10_edit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label10_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/edit2.png"))); // NOI18N
        Label10_edit.setText("Edit");
        Label10_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label10_editMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Label10_editMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Label10_editMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Panel9Layout = new javax.swing.GroupLayout(Panel9);
        Panel9.setLayout(Panel9Layout);
        Panel9Layout.setHorizontalGroup(
            Panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label10_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel9Layout.setVerticalGroup(
            Panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label10_edit, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Panel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Panel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Panel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Panel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(Panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 780));

        Panel10.setBackground(new java.awt.Color(255, 255, 255));
        Panel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_1.setFont(new java.awt.Font("Bodoni MT", 1, 36)); // NOI18N
        lbl_1.setForeground(new java.awt.Color(51, 0, 102));
        lbl_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_1.setText("DAV  Institute  Of  Engineering  And  Technology");
        Panel10.add(lbl_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 7, 814, -1));

        lbl_2.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        lbl_2.setForeground(new java.awt.Color(51, 0, 102));
        lbl_2.setText("0181-2202004, 220126");
        Panel10.add(lbl_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, -1, -1));

        lbl_3.setFont(new java.awt.Font("Bodoni MT", 1, 22)); // NOI18N
        lbl_3.setForeground(new java.awt.Color(51, 0, 102));
        lbl_3.setText("Kabir Nagar, Jalandhar - 144 008");
        Panel10.add(lbl_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 63, -1, -1));

        lbl_4.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_4.setForeground(new java.awt.Color(51, 0, 102));
        lbl_4.setText("Reciept No :");
        Panel10.add(lbl_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 111, -1, -1));

        lbl_5.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_5.setForeground(new java.awt.Color(51, 0, 102));
        lbl_5.setText("Mode Of Payment :");
        Panel10.add(lbl_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 140, -1, -1));

        lbl_6.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_6.setForeground(new java.awt.Color(51, 0, 102));
        lbl_6.setText("DD/Cheque Number :");
        Panel10.add(lbl_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 169, -1, -1));

        lbl_7.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_7.setForeground(new java.awt.Color(51, 0, 102));
        lbl_7.setText("Bank Name :");
        Panel10.add(lbl_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 198, -1, -1));

        lbl_8.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_8.setForeground(new java.awt.Color(51, 0, 102));
        lbl_8.setText("Date :");
        Panel10.add(lbl_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, -1, -1));

        lbl_9.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_9.setForeground(new java.awt.Color(51, 0, 102));
        lbl_9.setText("GSTIN :");
        Panel10.add(lbl_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, -1, -1));

        lbl_10.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_10.setForeground(new java.awt.Color(51, 0, 102));
        lbl_10.setText("Recieved From :");
        Panel10.add(lbl_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, -1, -1));

        Panel11.setBackground(new java.awt.Color(51, 0, 102));

        javax.swing.GroupLayout Panel11Layout = new javax.swing.GroupLayout(Panel11);
        Panel11.setLayout(Panel11Layout);
        Panel11Layout.setHorizontalGroup(
            Panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 930, Short.MAX_VALUE)
        );
        Panel11Layout.setVerticalGroup(
            Panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        Panel10.add(Panel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 97, 930, -1));

        lbl_11.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_11.setForeground(new java.awt.Color(51, 0, 102));
        lbl_11.setText("Student Name :");
        Panel10.add(lbl_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 227, -1, -1));

        lbl_12.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_12.setForeground(new java.awt.Color(51, 0, 102));
        lbl_12.setText("Course :");
        Panel10.add(lbl_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 256, -1, -1));

        lbl_13.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_13.setForeground(new java.awt.Color(51, 0, 102));
        lbl_13.setText("Year/Semester :");
        Panel10.add(lbl_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 285, -1, -1));

        lbl_14.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_14.setForeground(new java.awt.Color(51, 0, 102));
        lbl_14.setText("Roll Number :");
        Panel10.add(lbl_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, -1, -1));

        lbl_15.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_15.setForeground(new java.awt.Color(51, 0, 102));
        lbl_15.setText("Mobile Number :");
        Panel10.add(lbl_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, -1, -1));

        lbl_16.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_16.setForeground(new java.awt.Color(51, 0, 102));
        lbl_16.setText("Father's Name :");
        Panel10.add(lbl_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(51, 0, 102));
        Panel10.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 326, 870, 10));

        jSeparator2.setForeground(new java.awt.Color(51, 0, 102));
        Panel10.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 870, 10));

        jLabel16.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 0, 102));
        jLabel16.setText("Sr No.");
        Panel10.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 341, -1, -1));

        lbl_17.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_17.setForeground(new java.awt.Color(51, 0, 102));
        lbl_17.setText("Particulars");
        Panel10.add(lbl_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 341, -1, -1));

        lbl_18.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_18.setForeground(new java.awt.Color(51, 0, 102));
        lbl_18.setText("Amount");
        Panel10.add(lbl_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 341, -1, -1));

        jSeparator3.setForeground(new java.awt.Color(51, 0, 102));
        Panel10.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 488, 870, 10));

        jSeparator4.setForeground(new java.awt.Color(51, 0, 102));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Panel10.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 386, 50, 96));

        jSeparator6.setForeground(new java.awt.Color(51, 0, 102));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Panel10.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 341, 22, 22));

        jSeparator7.setForeground(new java.awt.Color(51, 0, 102));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Panel10.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 386, 29, 96));

        jSeparator8.setForeground(new java.awt.Color(51, 0, 102));
        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Panel10.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 341, 50, 22));

        lbl_19.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_19.setForeground(new java.awt.Color(51, 0, 102));
        lbl_19.setText("Total");
        Panel10.add(lbl_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 510, -1, -1));

        lbl_20.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_20.setForeground(new java.awt.Color(51, 0, 102));
        lbl_20.setText("Amount In Words :");
        Panel10.add(lbl_20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, -1, -1));

        lbl_21.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_21.setForeground(new java.awt.Color(51, 0, 102));
        lbl_21.setText("Authorised Signatory :");
        Panel10.add(lbl_21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, -1, -1));

        lbl_22.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_22.setForeground(new java.awt.Color(51, 0, 102));
        lbl_22.setText("1.");
        Panel10.add(lbl_22, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 386, -1, -1));

        lbl_23.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_23.setForeground(new java.awt.Color(51, 0, 102));
        lbl_23.setText("jLabel22");
        Panel10.add(lbl_23, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 386, -1, -1));

        lbl_24.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_24.setForeground(new java.awt.Color(51, 0, 102));
        lbl_24.setText("Annual Charges");
        Panel10.add(lbl_24, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 386, -1, -1));

        lbl_25.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_25.setForeground(new java.awt.Color(51, 0, 102));
        lbl_25.setText("2.");
        Panel10.add(lbl_25, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 415, -1, -1));

        lbl_26.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_26.setForeground(new java.awt.Color(51, 0, 102));
        lbl_26.setText("jLabel22");
        Panel10.add(lbl_26, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 415, -1, -1));

        lbl_27.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_27.setForeground(new java.awt.Color(51, 0, 102));
        lbl_27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_27.setText("Tuition fees");
        Panel10.add(lbl_27, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 415, 120, -1));

        lbl_28.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_28.setForeground(new java.awt.Color(51, 0, 102));
        lbl_28.setText("jLabel22");
        Panel10.add(lbl_28, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 444, -1, -1));

        lbl_29.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_29.setForeground(new java.awt.Color(51, 0, 102));
        lbl_29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_29.setText("Hostel Fees");
        Panel10.add(lbl_29, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 444, 120, -1));

        lbl_30.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_30.setForeground(new java.awt.Color(51, 0, 102));
        lbl_30.setText("3.");
        Panel10.add(lbl_30, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 444, -1, -1));

        jSeparator5.setForeground(new java.awt.Color(51, 0, 102));
        Panel10.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 608, 148, 10));

        lbl_31.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_31.setForeground(new java.awt.Color(51, 0, 102));
        lbl_31.setText("jLabel31");
        Panel10.add(lbl_31, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 111, -1, -1));

        lbl_32.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_32.setForeground(new java.awt.Color(51, 0, 102));
        lbl_32.setText("jLabel32");
        Panel10.add(lbl_32, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 140, -1, -1));

        lbl_33.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_33.setForeground(new java.awt.Color(51, 0, 102));
        lbl_33.setText("jLabel33");
        Panel10.add(lbl_33, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 169, -1, -1));

        lbl_34.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_34.setForeground(new java.awt.Color(51, 0, 102));
        lbl_34.setText("jLabel34");
        Panel10.add(lbl_34, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 198, -1, -1));

        lbl_35.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_35.setForeground(new java.awt.Color(51, 0, 102));
        lbl_35.setText("jLabel35");
        Panel10.add(lbl_35, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 227, -1, -1));

        lbl_36.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_36.setForeground(new java.awt.Color(51, 0, 102));
        lbl_36.setText("jLabel36");
        Panel10.add(lbl_36, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 256, -1, -1));

        lbl_37.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_37.setForeground(new java.awt.Color(51, 0, 102));
        lbl_37.setText("jLabel37");
        Panel10.add(lbl_37, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 285, -1, -1));

        lbl_38.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_38.setForeground(new java.awt.Color(51, 0, 102));
        lbl_38.setText("jLabel38");
        Panel10.add(lbl_38, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, -1, -1));

        lbl_39.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_39.setForeground(new java.awt.Color(51, 0, 102));
        lbl_39.setText("jLabel39");
        Panel10.add(lbl_39, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, -1, -1));

        lbl_40.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_40.setForeground(new java.awt.Color(51, 0, 102));
        lbl_40.setText("jLabel40");
        Panel10.add(lbl_40, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, -1, -1));

        lbl_41.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_41.setForeground(new java.awt.Color(51, 0, 102));
        lbl_41.setText("jLabel41");
        Panel10.add(lbl_41, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 230, -1, -1));

        lbl_42.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_42.setForeground(new java.awt.Color(51, 0, 102));
        lbl_42.setText("jLabel42");
        Panel10.add(lbl_42, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 260, -1, -1));

        lbl_43.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_43.setForeground(new java.awt.Color(51, 0, 102));
        lbl_43.setText("jLabel43");
        Panel10.add(lbl_43, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, -1, -1));

        lbl_44.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        lbl_44.setForeground(new java.awt.Color(51, 0, 102));
        lbl_44.setText("jLabel44");
        Panel10.add(lbl_44, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 530, -1, -1));

        getContentPane().add(Panel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 59, 930, 700));

        jLabel1.setFont(new java.awt.Font("Bodoni MT", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Print Reciept");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, -3, 930, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Label1_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label1_homeMouseClicked
        Home_Page a = new Home_Page();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Label1_homeMouseClicked

    private void Label1_homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label1_homeMouseEntered
        Color a = new Color(0,143,143);
        Panel2.setBackground(a);
    }//GEN-LAST:event_Label1_homeMouseEntered

    private void Label1_homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label1_homeMouseExited
        Color a = new Color(0,93,93);
        Panel2.setBackground(a);
    }//GEN-LAST:event_Label1_homeMouseExited

    private void Label2_search_recordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label2_search_recordsMouseEntered
        Color a = new Color(0,143,143);
        Panel3.setBackground(a);
    }//GEN-LAST:event_Label2_search_recordsMouseEntered

    private void Label2_search_recordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label2_search_recordsMouseExited
        Color a = new Color(0,93,93);
        Panel3.setBackground(a);
    }//GEN-LAST:event_Label2_search_recordsMouseExited

    private void Label4_course_listMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label4_course_listMouseEntered
        Color a = new Color(0,143,143);
        Panel4.setBackground(a);
    }//GEN-LAST:event_Label4_course_listMouseEntered

    private void Label4_course_listMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label4_course_listMouseExited
        Color a = new Color(0,93,93);
        Panel4.setBackground(a);
    }//GEN-LAST:event_Label4_course_listMouseExited

    private void Label5_view_all_recordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label5_view_all_recordsMouseEntered
        Color a = new Color(0,143,143);
        Panel5.setBackground(a);
    }//GEN-LAST:event_Label5_view_all_recordsMouseEntered

    private void Label5_view_all_recordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label5_view_all_recordsMouseExited
        Color a = new Color(0,93,93);
        Panel5.setBackground(a);
    }//GEN-LAST:event_Label5_view_all_recordsMouseExited

    private void Label6_backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label6_backMouseEntered
        Color a = new Color(0,143,143);
        Panel6.setBackground(a);
    }//GEN-LAST:event_Label6_backMouseEntered

    private void Label6_backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label6_backMouseExited
        Color a = new Color(0,93,93);
        Panel6.setBackground(a);
    }//GEN-LAST:event_Label6_backMouseExited

    private void Label7_logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label7_logoutMouseEntered
        Color a = new Color(0,143,143);
        Panel7.setBackground(a);
    }//GEN-LAST:event_Label7_logoutMouseEntered

    private void Label7_logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label7_logoutMouseExited
        Color a = new Color(0,93,93);
        Panel7.setBackground(a);
    }//GEN-LAST:event_Label7_logoutMouseExited

    private void Label8_printMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label8_printMouseEntered
        Color a = new Color(0,143,143);
        Panel8.setBackground(a);
    }//GEN-LAST:event_Label8_printMouseEntered

    private void Label8_printMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label8_printMouseExited
        Color a = new Color(0,93,93);
        Panel8.setBackground(a);
    }//GEN-LAST:event_Label8_printMouseExited

    private void Label10_editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label10_editMouseEntered
        Color a = new Color(0,143,143);
        Panel9.setBackground(a);
    }//GEN-LAST:event_Label10_editMouseEntered

    private void Label10_editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label10_editMouseExited
        Color a = new Color(0,93,93);
        Panel9.setBackground(a);
    }//GEN-LAST:event_Label10_editMouseExited

    private void Label8_printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label8_printMouseClicked
       PrinterJob job = PrinterJob.getPrinterJob();
       job.setJobName("Print Data");
            
       job.setPrintable(new Printable()
       {
            public int print(Graphics pg,PageFormat pf, int pageNum)
            {
                pf.setOrientation(PageFormat.LANDSCAPE);
                if(pageNum > 0)
                {
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.6,0.7);
                
                Panel10.print(g2);
         
                return Printable.PAGE_EXISTS;
            }
        });
       
        boolean ok = job.printDialog();
        
        if(ok)
        {
            try
            {
                job.print();
            }
            catch (PrinterException ex)
            {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_Label8_printMouseClicked

    private void Label10_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label10_editMouseClicked
       Update_Fees_Details update =new Update_Fees_Details();
       update.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_Label10_editMouseClicked

    private void Label2_search_recordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label2_search_recordsMouseClicked
        Search_Record_Page2 a = new Search_Record_Page2();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Label2_search_recordsMouseClicked

    private void Label4_course_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label4_course_listMouseClicked
        View_Reports_Page a = new View_Reports_Page();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Label4_course_listMouseClicked

    private void Label5_view_all_recordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label5_view_all_recordsMouseClicked
        View_All_Records_Page a = new View_All_Records_Page();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Label5_view_all_recordsMouseClicked

    private void Label7_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label7_logoutMouseClicked
        Login_Page2 a = new Login_Page2();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Label7_logoutMouseClicked

    private void Label6_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label6_backMouseClicked
        System.exit(0);
    }//GEN-LAST:event_Label6_backMouseClicked

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
            java.util.logging.Logger.getLogger(Print_Fees_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Print_Fees_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Print_Fees_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Print_Fees_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new Print_Fees_Receipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label10_edit;
    private javax.swing.JLabel Label1_home;
    private javax.swing.JLabel Label2_search_records;
    private javax.swing.JLabel Label4_course_list;
    private javax.swing.JLabel Label5_view_all_records;
    private javax.swing.JLabel Label6_back;
    private javax.swing.JLabel Label7_logout;
    private javax.swing.JLabel Label8_print;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel10;
    private javax.swing.JPanel Panel11;
    private javax.swing.JPanel Panel2;
    private javax.swing.JPanel Panel3;
    private javax.swing.JPanel Panel4;
    private javax.swing.JPanel Panel5;
    private javax.swing.JPanel Panel6;
    private javax.swing.JPanel Panel7;
    private javax.swing.JPanel Panel8;
    private javax.swing.JPanel Panel9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lbl_1;
    private javax.swing.JLabel lbl_10;
    private javax.swing.JLabel lbl_11;
    private javax.swing.JLabel lbl_12;
    private javax.swing.JLabel lbl_13;
    private javax.swing.JLabel lbl_14;
    private javax.swing.JLabel lbl_15;
    private javax.swing.JLabel lbl_16;
    private javax.swing.JLabel lbl_17;
    private javax.swing.JLabel lbl_18;
    private javax.swing.JLabel lbl_19;
    private javax.swing.JLabel lbl_2;
    private javax.swing.JLabel lbl_20;
    private javax.swing.JLabel lbl_21;
    private javax.swing.JLabel lbl_22;
    private javax.swing.JLabel lbl_23;
    private javax.swing.JLabel lbl_24;
    private javax.swing.JLabel lbl_25;
    private javax.swing.JLabel lbl_26;
    private javax.swing.JLabel lbl_27;
    private javax.swing.JLabel lbl_28;
    private javax.swing.JLabel lbl_29;
    private javax.swing.JLabel lbl_3;
    private javax.swing.JLabel lbl_30;
    private javax.swing.JLabel lbl_31;
    private javax.swing.JLabel lbl_32;
    private javax.swing.JLabel lbl_33;
    private javax.swing.JLabel lbl_34;
    private javax.swing.JLabel lbl_35;
    private javax.swing.JLabel lbl_36;
    private javax.swing.JLabel lbl_37;
    private javax.swing.JLabel lbl_38;
    private javax.swing.JLabel lbl_39;
    private javax.swing.JLabel lbl_4;
    private javax.swing.JLabel lbl_40;
    private javax.swing.JLabel lbl_41;
    private javax.swing.JLabel lbl_42;
    private javax.swing.JLabel lbl_43;
    private javax.swing.JLabel lbl_44;
    private javax.swing.JLabel lbl_5;
    private javax.swing.JLabel lbl_6;
    private javax.swing.JLabel lbl_7;
    private javax.swing.JLabel lbl_8;
    private javax.swing.JLabel lbl_9;
    // End of variables declaration//GEN-END:variables
}

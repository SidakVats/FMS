package fees_management_system;

import static fees_management_system.Detail_page.password;
import static fees_management_system.Detail_page.path;
import static fees_management_system.Detail_page.username;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;

public class Add_Fees_Page extends javax.swing.JFrame    
{
    String courseData[][]=new String[100][3];
    public Add_Fees_Page() 
    {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        displayCashFirst();
        fillComboBox();
        int no = get__No();
        TF1.setText(Integer.toString(no));
    }
    
    public void displayCashFirst()
    {
        lbl_dd_cheque_no.setVisible(false);
        lbl_bank_name.setVisible(false);
        
        TF2.setVisible(false);
        TF3.setVisible(false);
    }
    
    public boolean validation()
    {        
        if (TF15.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please enter Recieved From ");
        }
        else if (DC1.getDate()== null)
        {
            JOptionPane.showMessageDialog(this, "Please Select a Date ");
        }
        else if (CB1.getSelectedItem().toString().equalsIgnoreCase("Cheque"))
        {
            if (TF2.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Please enter the Cheque Number ");
            }
            if (TF3.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Please enter the Bank Name ");
            }
        }
        else if (CB1.getSelectedItem().toString().equalsIgnoreCase("Demand Dragt(DD)"))
        {
            if (TF2.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Please enter the Demand Draft(DD) Number ");
            }
            if (TF3.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Please enter the Bank Name ");
            }
        }
        else if (CB1.getSelectedItem().toString().equalsIgnoreCase("Card"))
        {
            if (TF3.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Please enter the Bank Name ");
            }
        }
        else if (TF5.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please enter the Student Name ");
        }
        
        else if (TF6.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please  enter Year and Semester ");
        }
        else if (TF7.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please enter the Roll Number ");
        }
        else if (TF8.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please enter the Mobile Number ");
        }
        else if (TF14.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please enter Hostel Fees ");
        }
        else if (TF9.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please enter the Father's Name ");
        }
        
        return true;
    }
    
    public void fillComboBox()
    {   
        try 
        {
            Connection conn       = DriverManager.getConnection(path ,username, password);
            PreparedStatement pst = conn.prepareStatement("select * from edit_courses");
            ResultSet rs          = pst.executeQuery();
            int index=0;
            
            while (rs.next())
            {
                CB2.addItem(rs.getString("Course_Name"));
                courseData[index][0]=rs.getString("Course_Name");           
                courseData[index][1]=rs.getString("Annual_Charges");
                courseData[index][2]=rs.getString("Tuition_Fees");
                index++;
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public int get__No()
    {
        int no =0;
        try
        {
            Connection conn       =  DriverManager.getConnection(path ,username, password);
            PreparedStatement pst =  conn.prepareStatement("select max(Receipt_No) from add_fees_data");
            ResultSet rs          =  pst.executeQuery();
            
            if (rs.next()==true)
            {
                no = rs.getInt(1);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return no+1;
    }
    
    public void Insert_fees_details()
    {           
        int Receipt_No          = Integer.parseInt(TF1.getText());
        String Payment_Mode     = CB1.getSelectedItem().toString();
        String DD_Cheque_Number = TF2.getText();
        String Bank_Name        = TF3.getText();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String Date             = format.format(DC1.getDate());
        String GSTIN            = TF4.getText();
        String Recieved_From    = TF15.getText();
        String StudentName      = TF5.getText();
        String Course_Name      = CB2.getSelectedItem().toString();
        String Year_Semester    = TF6.getText();
        String Roll_No          = TF7.getText();
        String Mobile_Number    = TF8.getText();
        String Father_Name      = TF9.getText();
        float Amount            = Float.parseFloat(TF10.getText());
        float Annual_Charge     = Float.parseFloat(TF12.getText());
        float Tuition_Fees      = Float.parseFloat(TF13.getText());
        float Hostel_Fees       = Float.parseFloat(TF14.getText());
        String Amount_In_Words  = TF11.getText();
        
        try 
        {
           Connection conn= DriverManager.getConnection(path ,username, password);
           PreparedStatement st = conn.prepareStatement(" insert into add_fees_data values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt   (1,  Receipt_No );
            st.setString(2,  Payment_Mode);
            st.setString(3,  DD_Cheque_Number);
            st.setString(4,  Bank_Name);
            st.setString(5,  Date);
            st.setString(6,  GSTIN);
            st.setString(7,  Recieved_From);
            st.setString(8,  StudentName);
            st.setString(9,  Course_Name);
            st.setString(10, Year_Semester);
            st.setString(11, Roll_No);
            st.setString(12, Mobile_Number);
            st.setString(13, Father_Name);
            st.setFloat (14, Annual_Charge);
            st.setFloat (15, Tuition_Fees);
            st.setFloat (16, Hostel_Fees);
            st.setFloat (17, Amount);
            st.setString(18, Amount_In_Words);
            
            int rowcount=st.executeUpdate();
            if (rowcount==1)
                {
                    JOptionPane.showMessageDialog(this, " Record Added Successfully ");
                }
                else
                {
                    JOptionPane.showMessageDialog(this, " Record Not Added ");
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

        Panel1 = new javax.swing.JPanel();
        Panel3 = new javax.swing.JPanel();
        Label1_home = new javax.swing.JLabel();
        Panel4 = new javax.swing.JPanel();
        Label2_search_records = new javax.swing.JLabel();
        Panel5 = new javax.swing.JPanel();
        Label3_edit_courses = new javax.swing.JLabel();
        Panel6 = new javax.swing.JPanel();
        Label4_course_list = new javax.swing.JLabel();
        Panel7 = new javax.swing.JPanel();
        Label5_view_all_records = new javax.swing.JLabel();
        Panel8 = new javax.swing.JPanel();
        Label6_back = new javax.swing.JLabel();
        Panel9 = new javax.swing.JPanel();
        Label7_logout = new javax.swing.JLabel();
        Panel2_parent = new javax.swing.JPanel();
        lbl_recipt_no = new javax.swing.JLabel();
        lbl_mode = new javax.swing.JLabel();
        lbl_dd_cheque_no = new javax.swing.JLabel();
        lbl_bank_name = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        lbl_gst_no = new javax.swing.JLabel();
        TF1 = new javax.swing.JTextField();
        TF2 = new javax.swing.JTextField();
        TF3 = new javax.swing.JTextField();
        DC1 = new com.toedter.calendar.JDateChooser();
        TF4 = new javax.swing.JTextField();
        lbl_heading_1 = new javax.swing.JLabel();
        lbl_heading_2 = new javax.swing.JLabel();
        CB1 = new javax.swing.JComboBox<>();
        lbl_recieved = new javax.swing.JLabel();
        TF15 = new javax.swing.JTextField();
        Panel_child = new javax.swing.JPanel();
        lbl_student_name = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        lbl_year_sem = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_roll_no = new javax.swing.JLabel();
        lbl_mob_no = new javax.swing.JLabel();
        TF5 = new javax.swing.JTextField();
        TF6 = new javax.swing.JTextField();
        TF7 = new javax.swing.JTextField();
        TF8 = new javax.swing.JTextField();
        TF9 = new javax.swing.JTextField();
        lbl_sr_no = new javax.swing.JLabel();
        lbl_particulars = new javax.swing.JLabel();
        lbl_amount = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        lbl_sr_1 = new javax.swing.JLabel();
        lbl_annual_charge = new javax.swing.JLabel();
        lbl_sr_2 = new javax.swing.JLabel();
        lbl_tution_fees = new javax.swing.JLabel();
        TF10 = new javax.swing.JTextField();
        lbl_amout_words = new javax.swing.JLabel();
        TF11 = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        lbl_sr_3 = new javax.swing.JLabel();
        lbl_hostel_fees = new javax.swing.JLabel();
        CB2 = new javax.swing.JComboBox<>();
        lbl_aut_sign = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Button_print = new javax.swing.JButton();
        TF12 = new javax.swing.JTextField();
        TF13 = new javax.swing.JTextField();
        TF14 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Panel1.setBackground(new java.awt.Color(0, 93, 93));
        Panel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.darkGray, null, null));

        Panel3.setBackground(new java.awt.Color(0, 93, 93));
        Panel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        Label1_home.setFont(new java.awt.Font("Bodoni MT", 1, 36)); // NOI18N
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

        javax.swing.GroupLayout Panel3Layout = new javax.swing.GroupLayout(Panel3);
        Panel3.setLayout(Panel3Layout);
        Panel3Layout.setHorizontalGroup(
            Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label1_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel3Layout.setVerticalGroup(
            Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label1_home, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        Panel4.setBackground(new java.awt.Color(0, 93, 93));
        Panel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

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

        javax.swing.GroupLayout Panel4Layout = new javax.swing.GroupLayout(Panel4);
        Panel4.setLayout(Panel4Layout);
        Panel4Layout.setHorizontalGroup(
            Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label2_search_records, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
        );
        Panel4Layout.setVerticalGroup(
            Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label2_search_records, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        Panel5.setBackground(new java.awt.Color(0, 93, 93));
        Panel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        Label3_edit_courses.setFont(new java.awt.Font("Bodoni MT", 1, 36)); // NOI18N
        Label3_edit_courses.setForeground(new java.awt.Color(255, 255, 255));
        Label3_edit_courses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label3_edit_courses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/edit2.png"))); // NOI18N
        Label3_edit_courses.setText(" Edit Courses");
        Label3_edit_courses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label3_edit_coursesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Label3_edit_coursesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Label3_edit_coursesMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Panel5Layout = new javax.swing.GroupLayout(Panel5);
        Panel5.setLayout(Panel5Layout);
        Panel5Layout.setHorizontalGroup(
            Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label3_edit_courses, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
        );
        Panel5Layout.setVerticalGroup(
            Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label3_edit_courses, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        Panel6.setBackground(new java.awt.Color(0, 93, 93));
        Panel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        Label4_course_list.setFont(new java.awt.Font("Bodoni MT", 1, 36)); // NOI18N
        Label4_course_list.setForeground(new java.awt.Color(255, 255, 255));
        Label4_course_list.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label4_course_list.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/list_1.png"))); // NOI18N
        Label4_course_list.setText("View Report");
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

        javax.swing.GroupLayout Panel6Layout = new javax.swing.GroupLayout(Panel6);
        Panel6.setLayout(Panel6Layout);
        Panel6Layout.setHorizontalGroup(
            Panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label4_course_list, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
        );
        Panel6Layout.setVerticalGroup(
            Panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label4_course_list, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        Panel7.setBackground(new java.awt.Color(0, 93, 93));
        Panel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

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

        javax.swing.GroupLayout Panel7Layout = new javax.swing.GroupLayout(Panel7);
        Panel7.setLayout(Panel7Layout);
        Panel7Layout.setHorizontalGroup(
            Panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label5_view_all_records, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel7Layout.setVerticalGroup(
            Panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label5_view_all_records, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        Panel8.setBackground(new java.awt.Color(0, 93, 93));
        Panel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        Label6_back.setFont(new java.awt.Font("Bodoni MT", 1, 45)); // NOI18N
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

        javax.swing.GroupLayout Panel8Layout = new javax.swing.GroupLayout(Panel8);
        Panel8.setLayout(Panel8Layout);
        Panel8Layout.setHorizontalGroup(
            Panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label6_back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel8Layout.setVerticalGroup(
            Panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label6_back, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        Panel9.setBackground(new java.awt.Color(0, 93, 93));
        Panel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Panel9.setPreferredSize(new java.awt.Dimension(238, 76));

        Label7_logout.setFont(new java.awt.Font("Bodoni MT", 1, 36)); // NOI18N
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

        javax.swing.GroupLayout Panel9Layout = new javax.swing.GroupLayout(Panel9);
        Panel9.setLayout(Panel9Layout);
        Panel9Layout.setHorizontalGroup(
            Panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label7_logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel9Layout.setVerticalGroup(
            Panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label7_logout, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel9, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                    .addComponent(Panel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(Panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(Panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(Panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(Panel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(Panel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(Panel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Panel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        Panel2_parent.setBackground(new java.awt.Color(0, 143, 143));
        Panel2_parent.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.darkGray, null, null));

        lbl_recipt_no.setFont(new java.awt.Font("Bodoni MT", 0, 26)); // NOI18N
        lbl_recipt_no.setForeground(new java.awt.Color(255, 255, 255));
        lbl_recipt_no.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_recipt_no.setText("Receipt No :");
        lbl_recipt_no.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_mode.setFont(new java.awt.Font("Bodoni MT", 0, 26)); // NOI18N
        lbl_mode.setForeground(new java.awt.Color(255, 255, 255));
        lbl_mode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_mode.setText("Mode Of Payment :");
        lbl_mode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_dd_cheque_no.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        lbl_dd_cheque_no.setForeground(new java.awt.Color(255, 255, 255));
        lbl_dd_cheque_no.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dd_cheque_no.setText("DD/Cheque  Number :");
        lbl_dd_cheque_no.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_bank_name.setFont(new java.awt.Font("Bodoni MT", 0, 26)); // NOI18N
        lbl_bank_name.setForeground(new java.awt.Color(255, 255, 255));
        lbl_bank_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_bank_name.setText("Bank Name :");
        lbl_bank_name.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_date.setFont(new java.awt.Font("Bodoni MT", 0, 26)); // NOI18N
        lbl_date.setForeground(new java.awt.Color(255, 255, 255));
        lbl_date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_date.setText("Date :");
        lbl_date.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_gst_no.setFont(new java.awt.Font("Bodoni MT", 0, 26)); // NOI18N
        lbl_gst_no.setForeground(new java.awt.Color(255, 255, 255));
        lbl_gst_no.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_gst_no.setText("GSTIN :");
        lbl_gst_no.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbl_gst_no.setPreferredSize(new java.awt.Dimension(215, 36));

        TF1.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        TF1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TF1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TF2.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        TF2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TF2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TF2.setPreferredSize(new java.awt.Dimension(153, 36));

        TF3.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        TF3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        DC1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DC1.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N

        TF4.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        TF4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TF4.setText("27AAACT4058L1Z2");
        TF4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TF4.setPreferredSize(new java.awt.Dimension(215, 36));

        lbl_heading_1.setFont(new java.awt.Font("Bodoni MT", 1, 36)); // NOI18N
        lbl_heading_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_heading_1.setText("DAV  Institute  Of  Engineering  And  Technology");

        lbl_heading_2.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        lbl_heading_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_heading_2.setText("Kabir Nagar, Jalandhar-144 008");

        CB1.setFont(new java.awt.Font("Bodoni MT", 0, 20)); // NOI18N
        CB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Demand Draft (DD)", "Cheque", "Cash", "Card" }));
        CB1.setSelectedIndex(2);
        CB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB1ActionPerformed(evt);
            }
        });

        lbl_recieved.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        lbl_recieved.setForeground(new java.awt.Color(255, 255, 255));
        lbl_recieved.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_recieved.setText("Recieved From :");
        lbl_recieved.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        TF15.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        TF15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TF15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TF15.setPreferredSize(new java.awt.Dimension(170, 33));

        Panel_child.setBackground(new java.awt.Color(0, 143, 143));

        lbl_student_name.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        lbl_student_name.setForeground(new java.awt.Color(255, 255, 255));
        lbl_student_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_student_name.setText("Student Name :");
        lbl_student_name.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        lbl_course.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));
        lbl_course.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_course.setText("Course :");
        lbl_course.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        lbl_year_sem.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        lbl_year_sem.setForeground(new java.awt.Color(255, 255, 255));
        lbl_year_sem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_year_sem.setText("Year/Semester :");
        lbl_year_sem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        lbl_year_sem.setPreferredSize(new java.awt.Dimension(83, 33));

        jLabel11.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Father's Name :");
        jLabel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        lbl_roll_no.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        lbl_roll_no.setForeground(new java.awt.Color(255, 255, 255));
        lbl_roll_no.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_roll_no.setText("Roll Number :");
        lbl_roll_no.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        lbl_mob_no.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        lbl_mob_no.setForeground(new java.awt.Color(255, 255, 255));
        lbl_mob_no.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_mob_no.setText("Mobile Number :");
        lbl_mob_no.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        TF5.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        TF5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TF5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TF6.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        TF6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TF6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TF7.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        TF7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TF7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TF8.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        TF8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TF8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TF9.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        TF9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TF9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbl_sr_no.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        lbl_sr_no.setForeground(new java.awt.Color(255, 255, 255));
        lbl_sr_no.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_sr_no.setText("Sr No.");

        lbl_particulars.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        lbl_particulars.setForeground(new java.awt.Color(255, 255, 255));
        lbl_particulars.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_particulars.setText("Particulars");

        lbl_amount.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        lbl_amount.setForeground(new java.awt.Color(255, 255, 255));
        lbl_amount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_amount.setText("Amount");

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setPreferredSize(new java.awt.Dimension(50, 12));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));

        lbl_sr_1.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        lbl_sr_1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_sr_1.setText("1.");

        lbl_annual_charge.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        lbl_annual_charge.setForeground(new java.awt.Color(255, 255, 255));
        lbl_annual_charge.setText("Annual Charges");

        lbl_sr_2.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        lbl_sr_2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_sr_2.setText("2.");

        lbl_tution_fees.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        lbl_tution_fees.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tution_fees.setText("Tuition Fees");

        TF10.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        TF10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TF10.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, null));

        lbl_amout_words.setFont(new java.awt.Font("Bodoni MT", 1, 20)); // NOI18N
        lbl_amout_words.setForeground(new java.awt.Color(255, 255, 255));
        lbl_amout_words.setText("Amount In Words :");

        TF11.setFont(new java.awt.Font("Bodoni MT", 0, 16)); // NOI18N
        TF11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TF11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));

        lbl_sr_3.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        lbl_sr_3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_sr_3.setText("3.");

        lbl_hostel_fees.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        lbl_hostel_fees.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hostel_fees.setText("Hostel Fees");

        CB2.setFont(new java.awt.Font("Bodoni MT", 0, 21)); // NOI18N
        CB2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "        Choose Course" }));
        CB2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        CB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB2ActionPerformed(evt);
            }
        });

        lbl_aut_sign.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        lbl_aut_sign.setText("Authorised Signatory :");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        Button_print.setBackground(new java.awt.Color(0, 113, 113));
        Button_print.setFont(new java.awt.Font("Bodoni MT", 1, 36)); // NOI18N
        Button_print.setForeground(new java.awt.Color(255, 255, 255));
        Button_print.setText("Print");
        Button_print.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Button_print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Button_printMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Button_printMouseExited(evt);
            }
        });
        Button_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_printActionPerformed(evt);
            }
        });

        TF12.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        TF12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TF12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TF13.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        TF13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TF13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TF14.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        TF14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TF14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TF14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_childLayout = new javax.swing.GroupLayout(Panel_child);
        Panel_child.setLayout(Panel_childLayout);
        Panel_childLayout.setHorizontalGroup(
            Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_childLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_childLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_childLayout.createSequentialGroup()
                                .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Panel_childLayout.createSequentialGroup()
                                        .addComponent(lbl_student_name, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(TF5))
                                    .addGroup(Panel_childLayout.createSequentialGroup()
                                        .addComponent(lbl_course, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(CB2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(Panel_childLayout.createSequentialGroup()
                                        .addComponent(lbl_year_sem, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(TF6)))
                                .addGap(83, 83, 83)
                                .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_mob_no, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_roll_no, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(TF8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addComponent(TF7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TF9))
                                .addGap(54, 54, 54))
                            .addGroup(Panel_childLayout.createSequentialGroup()
                                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(77, Short.MAX_VALUE))))
                    .addGroup(Panel_childLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lbl_sr_no, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(lbl_particulars, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154))
                    .addGroup(Panel_childLayout.createSequentialGroup()
                        .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(Panel_childLayout.createSequentialGroup()
                                .addComponent(lbl_amout_words)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TF11, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_childLayout.createSequentialGroup()
                                .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Panel_childLayout.createSequentialGroup()
                                        .addComponent(lbl_aut_sign)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_childLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(61, 61, 61)))
                                .addComponent(Button_print, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addGap(36, 36, 36)
                        .addComponent(TF10, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(Panel_childLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
                    .addComponent(jSeparator7))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_childLayout.createSequentialGroup()
                .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_childLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(lbl_sr_1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_childLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_sr_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_sr_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(108, 108, 108)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_annual_charge, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_tution_fees, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_hostel_fees, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TF14, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF13, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF12, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(149, 149, 149))
        );
        Panel_childLayout.setVerticalGroup(
            Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_childLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TF7)
                    .addComponent(lbl_student_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_roll_no, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TF5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_course, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_mob_no, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TF8)
                    .addComponent(CB2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TF6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_year_sem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TF9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 29, Short.MAX_VALUE)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE)
                .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_particulars, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(lbl_amount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_sr_no, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_childLayout.createSequentialGroup()
                        .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_childLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Panel_childLayout.createSequentialGroup()
                                        .addComponent(lbl_annual_charge)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_tution_fees))
                                    .addGroup(Panel_childLayout.createSequentialGroup()
                                        .addComponent(lbl_sr_1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_sr_2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_hostel_fees)
                                            .addComponent(lbl_sr_3)))
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(Panel_childLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(TF12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TF13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TF14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_childLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panel_childLayout.createSequentialGroup()
                        .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TF11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_amout_words))
                        .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_childLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(Panel_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Button_print, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_aut_sign)))
                            .addGroup(Panel_childLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(TF10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout Panel2_parentLayout = new javax.swing.GroupLayout(Panel2_parent);
        Panel2_parent.setLayout(Panel2_parentLayout);
        Panel2_parentLayout.setHorizontalGroup(
            Panel2_parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_heading_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2_parentLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(Panel2_parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbl_dd_cheque_no, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(lbl_recipt_no, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_mode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_bank_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(Panel2_parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel2_parentLayout.createSequentialGroup()
                        .addGroup(Panel2_parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TF2, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                            .addComponent(TF1)
                            .addComponent(CB1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(Panel2_parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel2_parentLayout.createSequentialGroup()
                                .addComponent(lbl_recieved)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TF15, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel2_parentLayout.createSequentialGroup()
                                .addGroup(Panel2_parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_date, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                    .addComponent(lbl_gst_no, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(26, 26, 26)
                                .addGroup(Panel2_parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TF4, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                    .addComponent(DC1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(TF3, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
            .addComponent(lbl_heading_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Panel_child, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel2_parentLayout.setVerticalGroup(
            Panel2_parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2_parentLayout.createSequentialGroup()
                .addComponent(lbl_heading_1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_heading_2)
                .addGap(18, 18, 18)
                .addGroup(Panel2_parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_recipt_no, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DC1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TF1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel2_parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel2_parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbl_gst_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_mode, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(CB1))
                    .addComponent(TF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(Panel2_parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TF2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(lbl_dd_cheque_no, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TF15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_recieved, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel2_parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TF3)
                    .addComponent(lbl_bank_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Panel_child, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel2_parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Panel2_parent, javax.swing.GroupLayout.PREFERRED_SIZE, 754, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Label1_homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label1_homeMouseEntered
        Color a = new Color(0,143,143);
        Panel3.setBackground(a);
    }//GEN-LAST:event_Label1_homeMouseEntered

    private void Label1_homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label1_homeMouseExited
        Color a = new Color(0,93,93);
        Panel3.setBackground(a);
    }//GEN-LAST:event_Label1_homeMouseExited

    private void Label2_search_recordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label2_search_recordsMouseEntered
        Color a = new Color(0,143,143);
        Panel4.setBackground(a);
    }//GEN-LAST:event_Label2_search_recordsMouseEntered

    private void Label2_search_recordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label2_search_recordsMouseExited
        Color a = new Color(0,93,93);
        Panel4.setBackground(a);
    }//GEN-LAST:event_Label2_search_recordsMouseExited

    private void Label3_edit_coursesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label3_edit_coursesMouseEntered
        Color a = new Color(0,143,143);
        Panel5.setBackground(a);
    }//GEN-LAST:event_Label3_edit_coursesMouseEntered

    private void Label3_edit_coursesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label3_edit_coursesMouseExited
        Color a = new Color(0,93,93);
        Panel5.setBackground(a);
    }//GEN-LAST:event_Label3_edit_coursesMouseExited

    private void Label4_course_listMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label4_course_listMouseEntered
        Color a = new Color(0,143,143);
        Panel6.setBackground(a);
    }//GEN-LAST:event_Label4_course_listMouseEntered

    private void Label4_course_listMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label4_course_listMouseExited
        Color a = new Color(0,93,93);
        Panel6.setBackground(a);
    }//GEN-LAST:event_Label4_course_listMouseExited

    private void Label5_view_all_recordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label5_view_all_recordsMouseEntered
        Color a = new Color(0,143,143);
        Panel7.setBackground(a);
    }//GEN-LAST:event_Label5_view_all_recordsMouseEntered

    private void Label5_view_all_recordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label5_view_all_recordsMouseExited
        Color a = new Color(0,93,93);
        Panel7.setBackground(a);
    }//GEN-LAST:event_Label5_view_all_recordsMouseExited

    private void Label6_backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label6_backMouseEntered
        Color a = new Color(0,143,143);
        Panel8.setBackground(a);
    }//GEN-LAST:event_Label6_backMouseEntered

    private void Label6_backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label6_backMouseExited
        Color a = new Color(0,93,93);
        Panel8.setBackground(a);
    }//GEN-LAST:event_Label6_backMouseExited

    private void Label7_logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label7_logoutMouseEntered
        Color a = new Color(0,143,143);
        Panel9.setBackground(a);
    }//GEN-LAST:event_Label7_logoutMouseEntered

    private void Label7_logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label7_logoutMouseExited
        Color a = new Color(0,93,93);
        Panel9.setBackground(a);
    }//GEN-LAST:event_Label7_logoutMouseExited

    private void Label1_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label1_homeMouseClicked
        Home_Page a = new Home_Page();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Label1_homeMouseClicked

    private void CB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB1ActionPerformed
        if (CB1.getSelectedIndex()==2)
        {
            lbl_dd_cheque_no.setVisible(false);
            lbl_bank_name.setVisible   (false);

            TF2.setVisible(false);
            TF3.setVisible(false);
        }
        else if (CB1.getSelectedIndex()==1)
        {
            lbl_dd_cheque_no.setText   ("Cheque No :");
            lbl_dd_cheque_no.setVisible(true);
            lbl_bank_name.setVisible   (true);
            
            TF2.setVisible(true);
            TF3.setVisible(true);
        }
        else if (CB1.getSelectedIndex()==0)
        {
            lbl_dd_cheque_no.setText   ("Demand Draft(DD) No:");
            lbl_dd_cheque_no.setVisible(true);
            lbl_bank_name.setVisible   (true);
            
            TF2.setVisible(true);
            TF3.setVisible(true);
        }
        else if (CB1.getSelectedIndex()==3)
        {
            lbl_dd_cheque_no.setVisible(false);
            lbl_bank_name.setVisible   (true);

            TF2.setVisible(false);
            TF3.setVisible(true);
        }

    }//GEN-LAST:event_CB1ActionPerformed

    private void Label2_search_recordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label2_search_recordsMouseClicked
        Search_Record_Page2 a = new Search_Record_Page2();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Label2_search_recordsMouseClicked

    private void Label3_edit_coursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label3_edit_coursesMouseClicked
        Edit_Courses_Page a = new Edit_Courses_Page();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Label3_edit_coursesMouseClicked

    private void Label5_view_all_recordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label5_view_all_recordsMouseClicked
        View_All_Records_Page a = new View_All_Records_Page();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Label5_view_all_recordsMouseClicked

    private void Label4_course_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label4_course_listMouseClicked
        View_Reports_Page a = new View_Reports_Page();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Label4_course_listMouseClicked

    private void Label7_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label7_logoutMouseClicked
        Login_Page2 a = new Login_Page2();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Label7_logoutMouseClicked

    private void CB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB2ActionPerformed
        for(int i=0;i<courseData.length;i++)
        {
            if(CB2.getSelectedItem().equals(courseData[i][0]))
            {
                TF12.setText(courseData[i][1]);
                TF13.setText(courseData[i][2]);
                break;
            }
        }

        //        if (CB2.getSelectedIndex()==0)
        //        {
            //            TF12.setText("");
            //            TF13.setText("");
            //        }
        //        if (CB2.getSelectedIndex()==1)
        //        {
            //            TF12.setText("500");
            //            TF13.setText("9500");
            //        }
        //
        //        if (CB2.getSelectedIndex()==2)
        //        {
            //            TF12.setText("500");
            //            TF13.setText("6999");
            //        }
        //
        //        if (CB2.getSelectedIndex()==3)
        //        {
            //            TF12.setText("500");
            //            TF13.setText("7999");
            //        }
        //        if (CB2.getSelectedIndex()==4)
        //        {2
            //            TF12.setText("500");
            //            TF13.setText("6499");
            //        }
        //        if (CB2.getSelectedIndex()==5)
        //        {
            //            TF12.setText("500");
            //            TF13.setText("7999 ");
            //        }
    }//GEN-LAST:event_CB2ActionPerformed

    private void Button_printMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_printMouseEntered
        Color a = new Color(0,73,73);
        Button_print.setBackground(a);
    }//GEN-LAST:event_Button_printMouseEntered

    private void Button_printMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_printMouseExited
        Color a = new Color(0,113,113);
        Button_print.setBackground(a);
    }//GEN-LAST:event_Button_printMouseExited

    private void Button_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_printActionPerformed
        if (validation()==true)
        {
            Insert_fees_details();
            Print_Fees_Receipt a = new Print_Fees_Receipt();
            a.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_Button_printActionPerformed

    private void TF14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF14ActionPerformed
        int a = Integer.parseInt(TF12.getText());
        int b = Integer.parseInt(TF13.getText());
        int c = Integer.parseInt(TF14.getText());
        int d = a+b+c;
        String st=String.valueOf(d);
        TF10.setText(st);

        TF11.setText(NumberToWordsConverter.convert((int)d)  + " only");
    }//GEN-LAST:event_TF14ActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException ex) 
        {
            java.util.logging.Logger.getLogger(Add_Fees_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) 
        {
            java.util.logging.Logger.getLogger(Add_Fees_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Add_Fees_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) 
        {
            java.util.logging.Logger.getLogger(Add_Fees_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new Add_Fees_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_print;
    private javax.swing.JComboBox<String> CB1;
    private javax.swing.JComboBox<String> CB2;
    private com.toedter.calendar.JDateChooser DC1;
    private javax.swing.JLabel Label1_home;
    private javax.swing.JLabel Label2_search_records;
    private javax.swing.JLabel Label3_edit_courses;
    private javax.swing.JLabel Label4_course_list;
    private javax.swing.JLabel Label5_view_all_records;
    private javax.swing.JLabel Label6_back;
    private javax.swing.JLabel Label7_logout;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2_parent;
    private javax.swing.JPanel Panel3;
    private javax.swing.JPanel Panel4;
    private javax.swing.JPanel Panel5;
    private javax.swing.JPanel Panel6;
    private javax.swing.JPanel Panel7;
    private javax.swing.JPanel Panel8;
    private javax.swing.JPanel Panel9;
    private javax.swing.JPanel Panel_child;
    private javax.swing.JTextField TF1;
    private javax.swing.JTextField TF10;
    private javax.swing.JTextField TF11;
    private javax.swing.JTextField TF12;
    private javax.swing.JTextField TF13;
    private javax.swing.JTextField TF14;
    private javax.swing.JTextField TF15;
    private javax.swing.JTextField TF2;
    private javax.swing.JTextField TF3;
    private javax.swing.JTextField TF4;
    private javax.swing.JTextField TF5;
    private javax.swing.JTextField TF6;
    private javax.swing.JTextField TF7;
    private javax.swing.JTextField TF8;
    private javax.swing.JTextField TF9;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lbl_amount;
    private javax.swing.JLabel lbl_amout_words;
    private javax.swing.JLabel lbl_annual_charge;
    private javax.swing.JLabel lbl_aut_sign;
    private javax.swing.JLabel lbl_bank_name;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_dd_cheque_no;
    private javax.swing.JLabel lbl_gst_no;
    private javax.swing.JLabel lbl_heading_1;
    private javax.swing.JLabel lbl_heading_2;
    private javax.swing.JLabel lbl_hostel_fees;
    private javax.swing.JLabel lbl_mob_no;
    private javax.swing.JLabel lbl_mode;
    private javax.swing.JLabel lbl_particulars;
    private javax.swing.JLabel lbl_recieved;
    private javax.swing.JLabel lbl_recipt_no;
    private javax.swing.JLabel lbl_roll_no;
    private javax.swing.JLabel lbl_sr_1;
    private javax.swing.JLabel lbl_sr_2;
    private javax.swing.JLabel lbl_sr_3;
    private javax.swing.JLabel lbl_sr_no;
    private javax.swing.JLabel lbl_student_name;
    private javax.swing.JLabel lbl_tution_fees;
    private javax.swing.JLabel lbl_year_sem;
    // End of variables declaration//GEN-END:variables
}

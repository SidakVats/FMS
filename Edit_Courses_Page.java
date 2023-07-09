package fees_management_system;

import static fees_management_system.Detail_page.password;
import static fees_management_system.Detail_page.path;
import static fees_management_system.Detail_page.username;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Edit_Courses_Page extends javax.swing.JFrame 
{
    DefaultTableModel model=null;

    public Edit_Courses_Page() 
    {        
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setRecordToTable();
    }

    public void setRecordToTable()
    {
        try
        {
            Connection conn      = DriverManager.getConnection(path, username, password);
            PreparedStatement st = conn.prepareStatement("select * from edit_courses");
            ResultSet rs         = st.executeQuery();
            while (rs.next())
            {   
                String Course_ID       =  rs.getString("Course_ID");
                String Course_Name     =  rs.getString("Course_Name");
                String Annual_Charges  =  rs.getString("Annual_Charges");
                String Tuition_Fees    =  rs.getString("Tuition_Fees");
                
                Object[] obj= {Course_ID ,Course_Name, Annual_Charges, Tuition_Fees};
                model = (DefaultTableModel) Table1.getModel();
                model.addRow(obj);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void addCourse()
    {
        int    ID               = Integer.parseInt(TF1.getText());
        String CourseName       = TF3.getText();
        String AnnualCharges    = TF2.getText();
        String TuitionFees      = TF4.getText();
        try 
        {
            Connection conn      = DriverManager.getConnection(path, username, password);
            PreparedStatement st = conn.prepareStatement("insert into edit_courses values(?,?,?,?)");
            st.setInt   (1, ID);
            st.setString(2, CourseName);
            st.setString(3, AnnualCharges);
            st.setString(4, TuitionFees);
            
            int Rowcount = st.executeUpdate(); 
            if (Rowcount==1) 
            {
                JOptionPane.showMessageDialog(this, "Course Added Succesfully");
                clearTable();
                setRecordToTable();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Course Insertion Failed");
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(this, "Course Insertion Failed");
            e.printStackTrace();
        }
    }
    
    public void clearTable()
    {
        DefaultTableModel model = (DefaultTableModel)Table1.getModel();
        model.setRowCount(0);
    }
    
    public void update()
    {
        int    ID               = Integer.parseInt(TF1.getText());
        String CourseName       = TF3.getText();
        String AnnualCharges    = TF2.getText();
        String TuitionFees      = TF4.getText();
        try 
        {
            Connection conn      = DriverManager.getConnection(path, username, password);
            PreparedStatement st = conn.prepareStatement("update edit_courses set Course_ID = ?, Annual_Charges = ?,"
                    + "Tuition_Fees = ? where Course_Name = ?");
            st.setInt   (1, ID);
            st.setString(2, AnnualCharges);
            st.setString(3, TuitionFees);
            st.setString(4, CourseName);
            
            int Rowcount = st.executeUpdate(); 
            if (Rowcount==1) 
            {
                JOptionPane.showMessageDialog(this, "Course Updated Succesfully");
                clearTable();
                setRecordToTable();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Course Updation Failed");
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(this, "Course Updation Failed");
            e.printStackTrace();
        }
    }
    public void Delete()
    {
        String CourseName = TF3.getText();
        
        try 
        {
            Connection conn      = DriverManager.getConnection(path, username, password);
            PreparedStatement st = conn.prepareStatement("delete from edit_courses where Course_Name = ?");
            
            st.setString(1, CourseName);
            
            int Rowcount = st.executeUpdate(); 
            if (Rowcount==1) 
            {
                JOptionPane.showMessageDialog(this, "Course Deleted Succesfully");
                clearTable();
                setRecordToTable();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Course Deletion Failed");
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(this, "Course Deletion Failed");
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TF1 = new javax.swing.JTextField();
        TF3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TF2 = new javax.swing.JTextField();
        TF4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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

        Label2_search_records.setFont(new java.awt.Font("Bodoni MT", 1, 48)); // NOI18N
        Label2_search_records.setForeground(new java.awt.Color(255, 255, 255));
        Label2_search_records.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label2_search_records.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/add2.png"))); // NOI18N
        Label2_search_records.setText("  Add Fees");
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

        Label3_edit_courses.setFont(new java.awt.Font("Bodoni MT", 1, 33)); // NOI18N
        Label3_edit_courses.setForeground(new java.awt.Color(255, 255, 255));
        Label3_edit_courses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label3_edit_courses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/search2.png"))); // NOI18N
        Label3_edit_courses.setText("Search Records");
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

        Label6_back.setFont(new java.awt.Font("Bodoni MT", 1, 48)); // NOI18N
        Label6_back.setForeground(new java.awt.Color(255, 255, 255));
        Label6_back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label6_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/logout_1.png"))); // NOI18N
        Label6_back.setText("Exit");
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
            .addComponent(Label7_logout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel9Layout.setVerticalGroup(
            Panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label7_logout, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
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
                    .addComponent(Panel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(Panel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addComponent(Panel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jPanel1.setBackground(new java.awt.Color(0, 143, 143));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.darkGray, null, null));

        Table1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Table1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course ID", "Course Name", "Annual Charges", "Tuition Fees"
            }
        ));
        Table1.setRowHeight(25);
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table1);

        jLabel1.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Course ID :");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        jLabel2.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Course Name :");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        TF1.setFont(new java.awt.Font("Bodoni MT", 0, 20)); // NOI18N
        TF1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TF1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TF3.setFont(new java.awt.Font("Bodoni MT", 0, 20)); // NOI18N
        TF3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TF3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Annual Charges :");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        jLabel4.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tuition Fees :");
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        TF2.setFont(new java.awt.Font("Bodoni MT", 0, 20)); // NOI18N
        TF2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TF2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TF4.setFont(new java.awt.Font("Bodoni MT", 0, 20)); // NOI18N
        TF4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TF4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Bodoni MT", 1, 55)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Update Courses");

        jButton1.setBackground(new java.awt.Color(0, 93, 93));
        jButton1.setFont(new java.awt.Font("Bodoni MT", 1, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/update.png"))); // NOI18N
        jButton1.setText(" Update");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 93, 93));
        jButton2.setFont(new java.awt.Font("Bodoni MT", 1, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/add2.png"))); // NOI18N
        jButton2.setText("Add");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 93, 93));
        jButton3.setFont(new java.awt.Font("Bodoni MT", 1, 36)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/delete.png"))); // NOI18N
        jButton3.setText(" Delete");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TF1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TF2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(88, 88, 88)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TF3)
                                .addComponent(TF4, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TF1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TF3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(TF2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TF4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Label1_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label1_homeMouseClicked
        Home_Page a = new Home_Page();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Label1_homeMouseClicked

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

    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
        int  rowNo       = Table1.getSelectedRow();
        TableModel model = Table1.getModel();
        
        TF1.setText(model.getValueAt(rowNo, 0).toString());
        TF3.setText(model.getValueAt(rowNo, 1).toString());
        TF2.setText(model.getValueAt(rowNo, 2).toString());
        TF4.setText(model.getValueAt(rowNo, 3).toString());
    }//GEN-LAST:event_Table1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        addCourse();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        update();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Delete();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void Label2_search_recordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label2_search_recordsMouseClicked
        Add_Fees_Page a = new Add_Fees_Page();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Label2_search_recordsMouseClicked

    private void Label3_edit_coursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label3_edit_coursesMouseClicked
        Search_Record_Page2 a = new Search_Record_Page2();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Label3_edit_coursesMouseClicked

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
            java.util.logging.Logger.getLogger(Edit_Courses_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit_Courses_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit_Courses_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit_Courses_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new Edit_Courses_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label1_home;
    private javax.swing.JLabel Label2_search_records;
    private javax.swing.JLabel Label3_edit_courses;
    private javax.swing.JLabel Label4_course_list;
    private javax.swing.JLabel Label5_view_all_records;
    private javax.swing.JLabel Label6_back;
    private javax.swing.JLabel Label7_logout;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel3;
    private javax.swing.JPanel Panel4;
    private javax.swing.JPanel Panel5;
    private javax.swing.JPanel Panel6;
    private javax.swing.JPanel Panel7;
    private javax.swing.JPanel Panel8;
    private javax.swing.JPanel Panel9;
    private javax.swing.JTextField TF1;
    private javax.swing.JTextField TF2;
    private javax.swing.JTextField TF3;
    private javax.swing.JTextField TF4;
    private javax.swing.JTable Table1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

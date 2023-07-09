package fees_management_system;

import static fees_management_system.Detail_page.password;
import static fees_management_system.Detail_page.path;
import static fees_management_system.Detail_page.username;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class View_Reports_Page extends javax.swing.JFrame
{
    DefaultTableModel model = null;
    public View_Reports_Page() 
    {   
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        fillComboBox1();
    }

    public void fillComboBox1()
    {   
        try 
        {
            Connection conn       = DriverManager.getConnection(path ,username, password);
            PreparedStatement st  = conn.prepareStatement("select Course_Name from edit_courses");
            ResultSet rs          = st.executeQuery();           
            while (rs.next())
            {
                CB1.addItem(rs.getString("Course_Name"));
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void getRecordToTable2()
    {
        String  Course_Name     = CB1.getSelectedItem().toString();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        String fromDate = format.format(DC1.getDate());
        String toDate   = format.format(DC2.getDate());
        Float TotalAmount = 0.0f;
        try
        {
            Connection conn      = DriverManager.getConnection(path, username, password);
            PreparedStatement st = conn.prepareStatement("select * from add_fees_data where Date between ? and ? and Course_Name = ?");
            
            st.setString(1, fromDate);
            st.setString(2, toDate);
            st.setString(3, Course_Name);
            
            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                String Receipt_No    = rs.getString("Receipt_No");
                String Payment_Mode  = rs.getString("Payment_Mode");
                String CourseName    = rs.getString("Course_Name");
                String Student_Name  = rs.getString("Student_Name");
                String Roll_Number   = rs.getString("Roll_Number");
                String Amount        = rs.getString("Amount");
                
                TotalAmount = TotalAmount + Float.parseFloat(Amount);
                
                Object[] obj = {Receipt_No, Payment_Mode, Student_Name, CourseName, Roll_Number, Amount};
                model = (DefaultTableModel) Table1.getModel();
                model.addRow(obj);
            }
            
            Label8.setText(TotalAmount.toString());
            Label6.setText(Course_Name);
            Label10.setText(NumberToWordsConverter.convert(TotalAmount.intValue()));            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void clearTable1()
    {
        DefaultTableModel model = (DefaultTableModel)Table1.getModel();
        model.setRowCount(1);
    }
       
    public void exportToExcle()
    {
       XSSFWorkbook wb = new XSSFWorkbook(); 
       XSSFSheet ws = wb.createSheet();
       DefaultTableModel model = (DefaultTableModel)Table1.getModel();
       
       TreeMap<String,Object[]> map = new TreeMap<>();
       
       map.put("0", new Object[]{model.getColumnName(0), model.getColumnName(1), model.getColumnName(2), 
       model.getColumnName(3), model.getColumnName(4), model.getColumnName(5)});
       
        for (int i = 1; i < model.getRowCount(); i++) 
        {
            map.put(Integer.toString(i), new Object[]{model.getValueAt(i,0), model.getValueAt(i,1), model.getValueAt(i,2)
            ,model.getValueAt(i,3), model.getValueAt(i,4), model.getValueAt(i,5)});
        }
        Set<String> id = map.keySet();
        XSSFRow fRow;
        
        int rowID = 0;
        
        for(String key : id)
        {
            fRow =ws.createRow(rowID++);
            Object[] value = map.get(key);
            int cellId = 0;
            for (Object object : value) 
            {               
                XSSFCell cell = fRow.createCell(cellId++);
                cell.setCellValue(object.toString());
            }
        }
        
        try (FileOutputStream fos = new FileOutputStream(new File(TF1.getText())))
        {
            wb.write(fos);
            JOptionPane.showMessageDialog(this, "File Exported Succesfully"+TF1.getText());
            
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
        Panel2 = new javax.swing.JPanel();
        Label1 = new javax.swing.JLabel();
        Label2 = new javax.swing.JLabel();
        Label3 = new javax.swing.JLabel();
        CB1 = new javax.swing.JComboBox<>();
        Label4 = new javax.swing.JLabel();
        DC1 = new com.toedter.calendar.JDateChooser();
        DC2 = new com.toedter.calendar.JDateChooser();
        Panel2_child = new javax.swing.JPanel();
        Label5 = new javax.swing.JLabel();
        Label6 = new javax.swing.JLabel();
        Label7 = new javax.swing.JLabel();
        Label9 = new javax.swing.JLabel();
        Label8 = new javax.swing.JLabel();
        Label10 = new javax.swing.JLabel();
        Button1 = new javax.swing.JButton();
        Button2 = new javax.swing.JButton();
        TF1 = new javax.swing.JTextField();
        Button3 = new javax.swing.JButton();
        Button4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        Label11_Heading = new javax.swing.JLabel();

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
            .addComponent(Label3_edit_courses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel5Layout.setVerticalGroup(
            Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label3_edit_courses, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        Panel6.setBackground(new java.awt.Color(0, 93, 93));
        Panel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        Label4_course_list.setFont(new java.awt.Font("Bodoni MT", 1, 48)); // NOI18N
        Label4_course_list.setForeground(new java.awt.Color(255, 255, 255));
        Label4_course_list.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label4_course_list.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/add2.png"))); // NOI18N
        Label4_course_list.setText(" Add Fees");
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
            .addComponent(Label4_course_list, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        Label6_back.setFont(new java.awt.Font("Bodoni MT", 1, 55)); // NOI18N
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
                .addGap(18, 18, 18)
                .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(Panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Panel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Panel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Panel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 27, Short.MAX_VALUE)
                .addComponent(Panel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        Panel2.setBackground(new java.awt.Color(0, 143, 143));
        Panel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.darkGray, null, null));

        Label1.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        Label1.setForeground(new java.awt.Color(255, 255, 255));
        Label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label1.setText("Select Course :");
        Label1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        Label2.setFont(new java.awt.Font("Bodoni MT", 1, 28)); // NOI18N
        Label2.setForeground(new java.awt.Color(255, 255, 255));
        Label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label2.setText("Select Date:");
        Label2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        Label3.setFont(new java.awt.Font("Bodoni MT", 1, 20)); // NOI18N
        Label3.setForeground(new java.awt.Color(255, 255, 255));
        Label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label3.setText("From:");
        Label3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        CB1.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        CB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "        Choose Course" }));
        CB1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Label4.setFont(new java.awt.Font("Bodoni MT", 1, 20)); // NOI18N
        Label4.setForeground(new java.awt.Color(255, 255, 255));
        Label4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label4.setText("To:");
        Label4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        DC1.setFont(new java.awt.Font("Bodoni MT", 0, 16)); // NOI18N

        DC2.setFont(new java.awt.Font("Bodoni MT", 0, 16)); // NOI18N

        Panel2_child.setBackground(new java.awt.Color(0, 143, 143));
        Panel2_child.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        Label5.setFont(new java.awt.Font("Bodoni MT", 0, 22)); // NOI18N
        Label5.setForeground(new java.awt.Color(255, 255, 255));
        Label5.setText("Course Selected :");

        Label6.setFont(new java.awt.Font("Bodoni MT", 0, 22)); // NOI18N
        Label6.setForeground(new java.awt.Color(255, 255, 255));

        Label7.setFont(new java.awt.Font("Bodoni MT", 0, 22)); // NOI18N
        Label7.setForeground(new java.awt.Color(255, 255, 255));
        Label7.setText("Total Amount Collected :");

        Label9.setFont(new java.awt.Font("Bodoni MT", 0, 22)); // NOI18N
        Label9.setForeground(new java.awt.Color(255, 255, 255));
        Label9.setText("Total Amount In Words :");

        Label8.setFont(new java.awt.Font("Bodoni MT", 0, 22)); // NOI18N
        Label8.setForeground(new java.awt.Color(255, 255, 255));
        Label8.setPreferredSize(new java.awt.Dimension(37, 28));

        Label10.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        Label10.setForeground(new java.awt.Color(255, 255, 255));
        Label10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout Panel2_childLayout = new javax.swing.GroupLayout(Panel2_child);
        Panel2_child.setLayout(Panel2_childLayout);
        Panel2_childLayout.setHorizontalGroup(
            Panel2_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2_childLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel2_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel2_childLayout.createSequentialGroup()
                        .addComponent(Label7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Label8, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                    .addComponent(Label10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Panel2_childLayout.createSequentialGroup()
                        .addComponent(Label9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(Panel2_childLayout.createSequentialGroup()
                        .addComponent(Label5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Label6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Panel2_childLayout.setVerticalGroup(
            Panel2_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2_childLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel2_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Label5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(Panel2_childLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label7)
                    .addComponent(Label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Label9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        Button1.setBackground(new java.awt.Color(0, 93, 93));
        Button1.setFont(new java.awt.Font("Bodoni MT", 1, 36)); // NOI18N
        Button1.setForeground(new java.awt.Color(255, 255, 255));
        Button1.setText("Fetch");
        Button1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button1ActionPerformed(evt);
            }
        });

        Button2.setBackground(new java.awt.Color(0, 93, 93));
        Button2.setFont(new java.awt.Font("Bodoni MT", 1, 36)); // NOI18N
        Button2.setForeground(new java.awt.Color(255, 255, 255));
        Button2.setText("Print");
        Button2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button2ActionPerformed(evt);
            }
        });

        TF1.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        TF1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF1ActionPerformed(evt);
            }
        });

        Button3.setBackground(new java.awt.Color(0, 93, 93));
        Button3.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        Button3.setForeground(new java.awt.Color(255, 255, 255));
        Button3.setText("Browse");
        Button3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button3ActionPerformed(evt);
            }
        });

        Button4.setBackground(new java.awt.Color(0, 93, 93));
        Button4.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        Button4.setForeground(new java.awt.Color(255, 255, 255));
        Button4.setText("Export To Excel");
        Button4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button4ActionPerformed(evt);
            }
        });

        Table1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Table1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Receipt No", "Payment Mode", "Student Name", "Course Name", "Roll Number", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table1.setRowHeight(25);
        jScrollPane1.setViewportView(Table1);

        Label11_Heading.setFont(new java.awt.Font("Bodoni MT", 1, 48)); // NOI18N
        Label11_Heading.setForeground(new java.awt.Color(255, 255, 255));
        Label11_Heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label11_Heading.setText("View Report");
        Label11_Heading.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        javax.swing.GroupLayout Panel2Layout = new javax.swing.GroupLayout(Panel2);
        Panel2.setLayout(Panel2Layout);
        Panel2Layout.setHorizontalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label11_Heading, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel2Layout.createSequentialGroup()
                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Button1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel2Layout.createSequentialGroup()
                                .addComponent(Label2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Label3)))
                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Button2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addGroup(Panel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DC1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Label4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DC2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)))
                        .addComponent(Panel2_child, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel2Layout.createSequentialGroup()
                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel2Layout.createSequentialGroup()
                                .addComponent(TF1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(Button3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(Button4, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel2Layout.createSequentialGroup()
                                .addComponent(Label1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CB1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        Panel2Layout.setVerticalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addComponent(Label11_Heading, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Panel2Layout.createSequentialGroup()
                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CB1)
                            .addComponent(Label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Label2)
                                .addComponent(Label3)
                                .addComponent(Label4))
                            .addComponent(DC1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DC2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(Panel2_child, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Button4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TF1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void Label2_search_recordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label2_search_recordsMouseClicked
        Search_Record_Page2 a = new Search_Record_Page2();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Label2_search_recordsMouseClicked

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

    private void Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button1ActionPerformed
        clearTable1();
        getRecordToTable2();
    }//GEN-LAST:event_Button1ActionPerformed

    private void Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button2ActionPerformed
   
        SimpleDateFormat Date_Format = new SimpleDateFormat("YYYY-MM-dd"); 
        String datefrom =  Date_Format.format(DC1.getDate());
        String dateto   =  Date_Format.format(DC2.getDate());
       
        MessageFormat header=new MessageFormat("Report From "+datefrom+" To " +dateto);
        MessageFormat footer=new MessageFormat("page{0,number,integer}");
        try 
        {
            Table1.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            
        } catch (Exception e) 
        {
            e.getMessage();
        } 

    }//GEN-LAST:event_Button2ActionPerformed

    private void Button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button3ActionPerformed
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(this);
        SimpleDateFormat Date_Format = new SimpleDateFormat("YYYY-MM-dd"); 
        String  date                 = Date_Format.format(new Date());
        
        try 
        {
            File f = file.getSelectedFile();
            String path = f.getAbsolutePath();
            path = path+"_"+date+".xlsx";
            TF1.setText(path);
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_Button3ActionPerformed

    private void Button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button4ActionPerformed
        exportToExcle();
    }//GEN-LAST:event_Button4ActionPerformed

    private void Label3_edit_coursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label3_edit_coursesMouseClicked
        Edit_Courses_Page a = new Edit_Courses_Page();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Label3_edit_coursesMouseClicked

    private void Label4_course_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label4_course_listMouseClicked
        Add_Fees_Page a = new Add_Fees_Page();
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

    private void TF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF1ActionPerformed

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
            java.util.logging.Logger.getLogger(View_Reports_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Reports_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Reports_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Reports_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                new View_Reports_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button1;
    private javax.swing.JButton Button2;
    private javax.swing.JButton Button3;
    private javax.swing.JButton Button4;
    private javax.swing.JComboBox<String> CB1;
    private com.toedter.calendar.JDateChooser DC1;
    private com.toedter.calendar.JDateChooser DC2;
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label10;
    private javax.swing.JLabel Label11_Heading;
    private javax.swing.JLabel Label1_home;
    private javax.swing.JLabel Label2;
    private javax.swing.JLabel Label2_search_records;
    private javax.swing.JLabel Label3;
    private javax.swing.JLabel Label3_edit_courses;
    private javax.swing.JLabel Label4;
    private javax.swing.JLabel Label4_course_list;
    private javax.swing.JLabel Label5;
    private javax.swing.JLabel Label5_view_all_records;
    private javax.swing.JLabel Label6;
    private javax.swing.JLabel Label6_back;
    private javax.swing.JLabel Label7;
    private javax.swing.JLabel Label7_logout;
    private javax.swing.JLabel Label8;
    private javax.swing.JLabel Label9;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JPanel Panel2_child;
    private javax.swing.JPanel Panel3;
    private javax.swing.JPanel Panel4;
    private javax.swing.JPanel Panel5;
    private javax.swing.JPanel Panel6;
    private javax.swing.JPanel Panel7;
    private javax.swing.JPanel Panel8;
    private javax.swing.JPanel Panel9;
    private javax.swing.JTextField TF1;
    private javax.swing.JTable Table1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

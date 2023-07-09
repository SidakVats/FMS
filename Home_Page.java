package fees_management_system;
import java.awt.Color;
import javax.swing.JFrame;

public class Home_Page extends javax.swing.JFrame 
{
    public Home_Page() 
    {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Panel2 = new javax.swing.JPanel();
        Panel3 = new javax.swing.JPanel();
        Label1_addFees = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Panel4 = new javax.swing.JPanel();
        Label2_searchRecords = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Panel5 = new javax.swing.JPanel();
        Label3 = new javax.swing.JLabel();
        Label4 = new javax.swing.JLabel();
        Label5 = new javax.swing.JLabel();
        Panel6 = new javax.swing.JPanel();
        Label6_editCourses = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Panel8 = new javax.swing.JPanel();
        Label8_viewReport = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Panel9 = new javax.swing.JPanel();
        Label9_logOut = new javax.swing.JLabel();
        Panel10 = new javax.swing.JPanel();
        Label10_About = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Label2_newUser = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Label2_newUser1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel1.setBackground(new java.awt.Color(0, 63, 63));
        Panel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Panel1.setPreferredSize(new java.awt.Dimension(221, 168));

        jLabel6.setFont(new java.awt.Font("Bodoni MT", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Dayanand Anglo-Vedic Institute Of");

        jLabel7.setFont(new java.awt.Font("Bodoni MT", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Engineering And Technology ");

        jLabel8.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("KABIR NAGAR, JALANDHAR - 144 008");

        jLabel3.setFont(new java.awt.Font("Bodoni MT", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("( DAVIET )");

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1414, Short.MAX_VALUE)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addGap(376, 376, 376)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        Panel2.setBackground(new java.awt.Color(0, 153, 153));
        Panel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Panel3.setBackground(new java.awt.Color(0, 113, 113));
        Panel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));
        Panel3.setPreferredSize(new java.awt.Dimension(370, 180));
        Panel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Panel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel3MouseExited(evt);
            }
        });

        Label1_addFees.setFont(new java.awt.Font("Bodoni MT", 1, 45)); // NOI18N
        Label1_addFees.setForeground(new java.awt.Color(255, 255, 255));
        Label1_addFees.setText(" Add Fees");
        Label1_addFees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label1_addFeesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Label1_addFeesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Label1_addFeesMouseExited(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/plus.png"))); // NOI18N

        javax.swing.GroupLayout Panel3Layout = new javax.swing.GroupLayout(Panel3);
        Panel3.setLayout(Panel3Layout);
        Panel3Layout.setHorizontalGroup(
            Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Label1_addFees, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Panel3Layout.setVerticalGroup(
            Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label1_addFees, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Panel4.setBackground(new java.awt.Color(0, 113, 113));
        Panel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));
        Panel4.setPreferredSize(new java.awt.Dimension(370, 180));
        Panel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Panel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel4MouseExited(evt);
            }
        });

        Label2_searchRecords.setFont(new java.awt.Font("Bodoni MT", 1, 35)); // NOI18N
        Label2_searchRecords.setForeground(new java.awt.Color(255, 255, 255));
        Label2_searchRecords.setText("Search Records");
        Label2_searchRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label2_searchRecordsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Label2_searchRecordsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Label2_searchRecordsMouseExited(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/search-document.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Panel4Layout = new javax.swing.GroupLayout(Panel4);
        Panel4.setLayout(Panel4Layout);
        Panel4Layout.setHorizontalGroup(
            Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Label2_searchRecords, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Panel4Layout.setVerticalGroup(
            Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label2_searchRecords, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
            .addGroup(Panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Panel5.setBackground(new java.awt.Color(0, 113, 113));
        Panel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));
        Panel5.setPreferredSize(new java.awt.Dimension(370, 180));
        Panel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Panel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel5MouseExited(evt);
            }
        });

        Label3.setFont(new java.awt.Font("Bodoni MT", 1, 40)); // NOI18N
        Label3.setForeground(new java.awt.Color(255, 255, 255));
        Label3.setText("View All");

        Label4.setFont(new java.awt.Font("Bodoni MT", 1, 40)); // NOI18N
        Label4.setForeground(new java.awt.Color(255, 255, 255));
        Label4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label4.setText("Records");

        Label5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Label5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/text-book-opened-from-top-view.png"))); // NOI18N

        javax.swing.GroupLayout Panel5Layout = new javax.swing.GroupLayout(Panel5);
        Panel5.setLayout(Panel5Layout);
        Panel5Layout.setHorizontalGroup(
            Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel5Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(Label5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label3)
                    .addComponent(Label4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
        Panel5Layout.setVerticalGroup(
            Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel5Layout.createSequentialGroup()
                .addGroup(Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(Label3)
                        .addGap(18, 18, 18)
                        .addComponent(Label4))
                    .addGroup(Panel5Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(Label5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        Panel6.setBackground(new java.awt.Color(0, 113, 113));
        Panel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));
        Panel6.setPreferredSize(new java.awt.Dimension(370, 180));
        Panel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Panel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel6MouseExited(evt);
            }
        });

        Label6_editCourses.setFont(new java.awt.Font("Bodoni MT", 1, 40)); // NOI18N
        Label6_editCourses.setForeground(new java.awt.Color(255, 255, 255));
        Label6_editCourses.setText("Edit Courses");
        Label6_editCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label6_editCoursesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Label6_editCoursesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Label6_editCoursesMouseExited(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/edit.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout Panel6Layout = new javax.swing.GroupLayout(Panel6);
        Panel6.setLayout(Panel6Layout);
        Panel6Layout.setHorizontalGroup(
            Panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Label6_editCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Panel6Layout.setVerticalGroup(
            Panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label6_editCourses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Panel6Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        Panel8.setBackground(new java.awt.Color(0, 113, 113));
        Panel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));
        Panel8.setPreferredSize(new java.awt.Dimension(370, 180));
        Panel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Panel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel8MouseExited(evt);
            }
        });

        Label8_viewReport.setFont(new java.awt.Font("Bodoni MT", 1, 40)); // NOI18N
        Label8_viewReport.setForeground(new java.awt.Color(255, 255, 255));
        Label8_viewReport.setText("View Report");
        Label8_viewReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label8_viewReportMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Label8_viewReportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Label8_viewReportMouseExited(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/view report.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout Panel8Layout = new javax.swing.GroupLayout(Panel8);
        Panel8.setLayout(Panel8Layout);
        Panel8Layout.setHorizontalGroup(
            Panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel8Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Label8_viewReport, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
        );
        Panel8Layout.setVerticalGroup(
            Panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label8_viewReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Panel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Panel9.setBackground(new java.awt.Color(0, 113, 113));
        Panel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Panel9.setPreferredSize(new java.awt.Dimension(210, 80));

        Label9_logOut.setFont(new java.awt.Font("Bodoni MT", 1, 44)); // NOI18N
        Label9_logOut.setForeground(new java.awt.Color(255, 255, 255));
        Label9_logOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/about.png"))); // NOI18N
        Label9_logOut.setText(" About");
        Label9_logOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label9_logOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Label9_logOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Label9_logOutMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Panel9Layout = new javax.swing.GroupLayout(Panel9);
        Panel9.setLayout(Panel9Layout);
        Panel9Layout.setHorizontalGroup(
            Panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label9_logOut, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
        );
        Panel9Layout.setVerticalGroup(
            Panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label9_logOut, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );

        Panel10.setBackground(new java.awt.Color(0, 113, 113));
        Panel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Panel10.setPreferredSize(new java.awt.Dimension(210, 80));

        Label10_About.setFont(new java.awt.Font("Bodoni MT", 1, 40)); // NOI18N
        Label10_About.setForeground(new java.awt.Color(255, 255, 255));
        Label10_About.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/logout.png"))); // NOI18N
        Label10_About.setText(" LogOut");
        Label10_About.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label10_AboutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Label10_AboutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Label10_AboutMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Panel10Layout = new javax.swing.GroupLayout(Panel10);
        Panel10.setLayout(Panel10Layout);
        Panel10Layout.setHorizontalGroup(
            Panel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label10_About, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
        );
        Panel10Layout.setVerticalGroup(
            Panel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label10_About, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(0, 113, 113));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
        });

        Label2_newUser.setFont(new java.awt.Font("Bodoni MT", 1, 48)); // NOI18N
        Label2_newUser.setForeground(new java.awt.Color(255, 255, 255));
        Label2_newUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label2_newUser.setText("New User");
        Label2_newUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label2_newUserMouseClicked(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project_images/add-user.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });

        Label2_newUser1.setFont(new java.awt.Font("Bodoni MT", 1, 48)); // NOI18N
        Label2_newUser1.setForeground(new java.awt.Color(255, 255, 255));
        Label2_newUser1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label2_newUser1.setText("Signup");
        Label2_newUser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label2_newUser1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label2_newUser1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(Label2_newUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(Label2_newUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Label2_newUser1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout Panel2Layout = new javax.swing.GroupLayout(Panel2);
        Panel2.setLayout(Panel2Layout);
        Panel2Layout.setHorizontalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addComponent(Panel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Panel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(Panel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Panel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel4, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Panel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Panel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45))
        );
        Panel2Layout.setVerticalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Panel6, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(Panel8, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Panel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1418, Short.MAX_VALUE)
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

    private void Label1_addFeesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label1_addFeesMouseEntered
        Color a = new Color(0,83,83);
        Panel3.setBackground(a);
    }//GEN-LAST:event_Label1_addFeesMouseEntered

    private void Label1_addFeesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label1_addFeesMouseExited
        Color a = new Color(0,123,123);
        Panel3.setBackground(a);
    }//GEN-LAST:event_Label1_addFeesMouseExited

    private void Label2_searchRecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label2_searchRecordsMouseEntered
        Color a = new Color(0,83,83);
        Panel4.setBackground(a);
    }//GEN-LAST:event_Label2_searchRecordsMouseEntered

    private void Label2_searchRecordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label2_searchRecordsMouseExited
        Color a = new Color(0,123,123);
        Panel4.setBackground(a);
    }//GEN-LAST:event_Label2_searchRecordsMouseExited

    private void Panel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel5MouseEntered
        Color a = new Color(0,83,83);
        Panel5.setBackground(a);
    }//GEN-LAST:event_Panel5MouseEntered

    private void Panel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel5MouseExited
        Color a = new Color(0,123,123);
        Panel5.setBackground(a);
    }//GEN-LAST:event_Panel5MouseExited

    private void Label6_editCoursesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label6_editCoursesMouseEntered
        Color a = new Color(0,83,83);
        Panel6.setBackground(a);
    }//GEN-LAST:event_Label6_editCoursesMouseEntered

    private void Label6_editCoursesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label6_editCoursesMouseExited
        Color a = new Color(0,123,123);
        Panel6.setBackground(a);
    }//GEN-LAST:event_Label6_editCoursesMouseExited

    private void Label8_viewReportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label8_viewReportMouseEntered
        Color a = new Color(0,83,83);
        Panel8.setBackground(a);
    }//GEN-LAST:event_Label8_viewReportMouseEntered

    private void Label8_viewReportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label8_viewReportMouseExited
        Color a = new Color(0,123,123);
        Panel8.setBackground(a);
    }//GEN-LAST:event_Label8_viewReportMouseExited

    private void Label10_AboutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label10_AboutMouseEntered
        Color a = new Color(0,83,83);
        Panel10.setBackground(a);
    }//GEN-LAST:event_Label10_AboutMouseEntered

    private void Label10_AboutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label10_AboutMouseExited
        Color a = new Color(0,123,123);
        Panel10.setBackground(a);
    }//GEN-LAST:event_Label10_AboutMouseExited

    private void Label9_logOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label9_logOutMouseEntered
        Color a = new Color(0,83,83);
        Panel9.setBackground(a);
    }//GEN-LAST:event_Label9_logOutMouseEntered

    private void Label9_logOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label9_logOutMouseExited
        Color a = new Color(0,123,123);
        Panel9.setBackground(a);
    }//GEN-LAST:event_Label9_logOutMouseExited

    private void Label1_addFeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label1_addFeesMouseClicked
        Add_Fees_Page a = new Add_Fees_Page();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Label1_addFeesMouseClicked

    private void Panel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel3MouseEntered
        Color a = new Color(0,83,83);
        Panel3.setBackground(a);
    }//GEN-LAST:event_Panel3MouseEntered

    private void Panel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel3MouseExited
        Color a = new Color(0,123,123);
        Panel3.setBackground(a);
    }//GEN-LAST:event_Panel3MouseExited

    private void Panel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel4MouseEntered
        Color a = new Color(0,83,83);
        Panel4.setBackground(a);
    }//GEN-LAST:event_Panel4MouseEntered

    private void Panel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel4MouseExited
        Color a = new Color(0,123,123);
        Panel4.setBackground(a);
    }//GEN-LAST:event_Panel4MouseExited

    private void Panel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel6MouseEntered
        Color a = new Color(0,83,83);
        Panel6.setBackground(a);
    }//GEN-LAST:event_Panel6MouseEntered

    private void Panel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel6MouseExited
        Color a = new Color(0,123,123);
        Panel6.setBackground(a);
    }//GEN-LAST:event_Panel6MouseExited

    private void Panel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel8MouseEntered
        Color a = new Color(0,83,83);
        Panel8.setBackground(a);
    }//GEN-LAST:event_Panel8MouseEntered

    private void Panel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel8MouseExited
        Color a = new Color(0,123,123);
        Panel8.setBackground(a);
    }//GEN-LAST:event_Panel8MouseExited

    private void Label2_searchRecordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label2_searchRecordsMouseClicked
        Search_Record_Page2 a = new Search_Record_Page2();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Label2_searchRecordsMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Search_Record_Page2 a = new Search_Record_Page2();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void Label6_editCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label6_editCoursesMouseClicked
        Edit_Courses_Page a = new Edit_Courses_Page();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Label6_editCoursesMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        Edit_Courses_Page a = new Edit_Courses_Page();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void Panel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel5MouseClicked
        View_All_Records_Page a = new View_All_Records_Page();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Panel5MouseClicked

    private void Label8_viewReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label8_viewReportMouseClicked
        View_Reports_Page a = new View_Reports_Page();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Label8_viewReportMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        View_Reports_Page a = new View_Reports_Page();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void Label9_logOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label9_logOutMouseClicked
        Copyright_Page a = new Copyright_Page();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Label9_logOutMouseClicked

    private void Label10_AboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label10_AboutMouseClicked
        Login_Page2 a = new Login_Page2();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Label10_AboutMouseClicked

    private void Label2_newUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label2_newUserMouseClicked
       Signup_Page2 a = new Signup_Page2();
       a.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_Label2_newUserMouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
       Signup_Page2 a = new Signup_Page2();
       a.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void Label2_newUser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label2_newUser1MouseClicked
       Signup_Page2 a = new Signup_Page2();
       a.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_Label2_newUser1MouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
       Signup_Page2 a = new Signup_Page2();
       a.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
       Color b = new Color(0,83,83);
       jLabel4.setBackground(b);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
       Color a = new Color(0,123,123);
       jLabel4.setBackground(a);
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
       Color a = new Color(0,83,83);
       jLabel5.setBackground(a);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
       Color a = new Color(0,123,123);
       jLabel5.setBackground(a);
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
       Color a = new Color(0,83,83);
       jLabel9.setBackground(a);
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
       Color a = new Color(0,123,123);
       jLabel9.setBackground(a);
    }//GEN-LAST:event_jLabel9MouseExited

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
       Color a = new Color(0,123,123);
       jPanel1.setBackground(a);
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
       Color a = new Color(0,123,123);
       jPanel1.setBackground(a);
    }//GEN-LAST:event_jPanel1MouseExited

    
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
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new Home_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label10_About;
    private javax.swing.JLabel Label1_addFees;
    private javax.swing.JLabel Label2_newUser;
    private javax.swing.JLabel Label2_newUser1;
    private javax.swing.JLabel Label2_searchRecords;
    private javax.swing.JLabel Label3;
    private javax.swing.JLabel Label4;
    private javax.swing.JLabel Label5;
    private javax.swing.JLabel Label6_editCourses;
    private javax.swing.JLabel Label8_viewReport;
    private javax.swing.JLabel Label9_logOut;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel10;
    private javax.swing.JPanel Panel2;
    private javax.swing.JPanel Panel3;
    private javax.swing.JPanel Panel4;
    private javax.swing.JPanel Panel5;
    private javax.swing.JPanel Panel6;
    private javax.swing.JPanel Panel8;
    private javax.swing.JPanel Panel9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

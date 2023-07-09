package fees_management_system;

import static fees_management_system.Detail_page.password;
import static fees_management_system.Detail_page.path;
import static fees_management_system.Detail_page.username;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Fees_Management_System 
{
    public static void main(String[] args) 
    {
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
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try 
        {
            Connection con       = DriverManager.getConnection(path, username, password);
            String sql           = "select * from signup_page";
            PreparedStatement st = con.prepareStatement(sql);
            
            ResultSet rs = st.executeQuery();
            
            if (rs.next())
            {
                Login_Page2 a = new Login_Page2();
                a.show();             
            }
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }        
}

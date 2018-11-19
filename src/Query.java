
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Query {

    static ResultSet rs = null;
    Connection con = null;
    Statement st = null;


    public Query() {


        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Texture", "root", "");
            st = con.createStatement();
            

        } catch (Exception ex) {




        }


    }

    public void slecting(String query) {

        try {
           
            rs = st.executeQuery(query);


        } catch (SQLException e) {

            System.out.println("a aw");
        }

    }

    public void updating(String query) {

        try {
            st.executeUpdate(query);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
package java_msacessdb_using_ucanacess_byankur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ankur-Agg
 */
public class Java_MSAcessDB_using_UcanAcess_byAnkur {

    public static Connection connection;

    public static void main(String[] args) {
        // STEP1: Add all the necessary library of UcanAcess to project libraries folder

        // STEP2: Create a Microsoft Acess database
        // STEP3: create a DB url with the below pattern where f://Demo.accdb is the location and file name.
        // replace with your file location and file name.
        String databaseURL = "jdbc:ucanaccess://f://Demo.accdb";

        // STEP4: try to connect to the DB
        try {
            connection = DriverManager.getConnection(databaseURL);
            //String sql = "INSERT INTO Contacts (Full_Name, Email, Phone) VALUES (?, ?, ?)";
            //PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setString(1, "Jim Rohn");
            //preparedStatement.setString(2, "rohnj@herbalife.com");
            //preparedStatement.setString(3, "0919989998");
            //int row = preparedStatement.executeUpdate();
            //if (row > 0) {
            //    System.out.println("A row has been inserted successfully.");
            //}
            // STEP5: create a simple query string to access all the detail in dummy table of DEMO database.
            String sql = "SELECT * FROM dummy";

            // STEP6: create a simple statement
            Statement statement = connection.createStatement();

            // STEP7: execute the querystring using executeQuery function and save the responese in ResultSet object
            ResultSet result = statement.executeQuery(sql);

            // STEP8:  process the ResultSet object using while and next() function
            while (result.next()) {
                // STEP9: Get columnwise information using index number starting form position 1
                //System.out.println(result.getInt(1) + ", " + result.getString(2) + ", " + result.getString(3) + ", " + result.getString(4));
                
                // OR u can use the column name
                System.out.println(result.getInt("ID") + ", " + result.getString("Fname") + ", " + result.getString("Lname") + ", " + result.getString("Phoneno") + ", " + result.getString("EmailId"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}

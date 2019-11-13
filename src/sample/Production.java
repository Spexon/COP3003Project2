/**
 * @Author Vladimir Hardy
 * @TODO Display available products to record
 */
package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.*;
import java.util.Scanner;
import java.time.LocalDate;

public class Production implements Item {

    /**
     * @param name
     * @brief constructor that sets name equal to what comes in
     */


    /**
     * @brief Allows the user to select an item to produce however many times they desire (will change to GUI later)
     */
    public void produce(String itemsToProduce,int numItemsToProduce) {

        final String DB_URL = "jdbc:h2:C:/Users/Windows/OneDrive - Florida Gulf Coast University/COP 3003/COP3003Project/res";
        //  Database credentials
        final String USER = "";
        final String PASS = "";

        DBConnection db = new DBConnection();
        Connection conn;
        PreparedStatement pstmt;

        try {
            conn =  DriverManager.getConnection(DB_URL, USER, PASS);

            String SQL = "INSERT INTO PRODUCTIONRECORD VALUES (?,?,?,?)";
            pstmt = conn.prepareStatement(SQL);
            for(int i = 0; i<numItemsToProduce;i++) {
                pstmt.setString(1, itemsToProduce);
            }

            pstmt.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @brief creates a new item with the information passed and saves to a database table called PRODUCTION
     * @param prodName Name of the product
     * @param manufact Manufacturer's name
     * @param type Product type (Audio, Visual, Audio Mobile, Visual Mobile)
     */
    public void createNewItem(String prodName, String manufact, String type) {

        try {
            final String JDBC_DRIVER = "org.h2.Driver";
            final String DB_URL = "jdbc:h2:C:/Users/Windows/OneDrive - Florida Gulf Coast University/COP 3003/COP3003Project/res";
            //  Database credentials
            final String USER = "";
            final String PASS = "";

            Connection conn;
            PreparedStatement pstmt; //Use prepared statement to allow variables to work in insert statements
            DBConnection db = new DBConnection();
            Statement stmt = db.stmt();

            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            String SQL = "INSERT INTO PRODUCTION VALUES (?,?,?,?)";
            String SQL2 = "SELECT id FROM PRODUCTION ORDER BY ID DESC LIMIT 1"; //Gets the last id
            String SQL3 = "DELETE * FROM PRODUCTION WHERE TYPE = null";
            ResultSet rs = stmt.executeQuery(SQL2);
            int id = 1;
            while(rs.next()) {
                id = rs.getInt("id") + 1; //Increments the last id by 1
            }

            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, id);
            pstmt.setString(2,prodName);
            pstmt.setString(3,manufact);
            pstmt.setString(4,type);

            pstmt.executeUpdate();
            /* if(!type.equals("null")) { // <-- this is the error
                System.out.println("Data successfully inserted");
            }
            else {
                System.out.println("Error occurred while inserting data");
                //stmt.executeQuery(SQL3);
            }*/

            // STEP 4: Clean-up environment
            pstmt.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Implemented getters and setters
     */
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setManufacturer(String manufacturer) {

    }

    @Override
    public String getManufacturer() {
        return null;
    }
}

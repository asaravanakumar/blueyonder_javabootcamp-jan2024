package com.labs.java.jdbc;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class JdbcDemo {

     // jdbc:postgresql://host:port/database
    private static String JDBC_URL = "jdbc:postgresql://localhost:5432/fsd_training";
    private static String USER_NAME = "postgres";
    private static String PASSWORD = "postgres";

    public static void main(String[] args)  {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        // PRE-REQ: Download Postgres driver and place into lib folder and add as dependency
        // STEP #1: Load Data Driver class / Registering Driver (Optional)
//        try {
//            Class.forName("org.postgresql.Driver");
//            System.out.println("Driver registered successfully");
//        } catch (ClassNotFoundException e) {
//            System.out.println("ERROR: Unable to load / register the class. " + e.getMessage());
//            e.printStackTrace();
//            return;
//        }

        // STEP #2: Create Connection
        try {
            conn = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
            System.out.println("Connected to DB Server successfully!!!");


            // STEP #3: Create Satement
            stmt = conn.createStatement();

            // STEP #4a: Execute (INSERT) Query
            int count = stmt.executeUpdate("INSERT INTO PRODUCT (pname, price) VALUES ('Dell Inspiron', 55000.0)");
            System.out.println("No of records inserted - " + count);

            // STEP #4b: Execute (SELECT) Query
            // STEP 5: Obtain ResultSet
            rs = stmt.executeQuery("SELECT * FROM PRODUCT");

            // STEP 6: Iterate through and display the contents of ResultSEt
            while(rs.next()) {
                System.out.format("%d %s %f", rs.getInt("pid"), rs.getString("pname"), rs.getDouble("price"));
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // STEP 7: Close the resources
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

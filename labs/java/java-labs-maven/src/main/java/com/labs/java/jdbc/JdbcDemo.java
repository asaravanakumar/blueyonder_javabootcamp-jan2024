package com.labs.java.jdbc;

import java.sql.*;

public class JdbcDemo {

     // jdbc:postgresql://host:port/database
    private static String JDBC_URL = "jdbc:postgresql://localhost:5432/fsd_training";
    private static String USER_NAME = "postgres";
    private static String PASSWORD = "postgres";

    public static void main(String[] args)  {

        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
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
//            conn.setAutoCommit(false); // enabling transaction


            // STEP #3: Create Satement
            stmt = conn.createStatement();

            // STEP #4a: Execute (INSERT) Query
            int count = stmt.executeUpdate("INSERT INTO PRODUCT (pname, price) VALUES ('Dell Inspiron', 55000.0)");
            System.out.println("No of records inserted - " + count);

            // INSERT with Prepared Statement
//            String query = "INSERT INTO PRODUCT (pname, price) VALUES (?, ?)";
//            pstmt = conn.prepareStatement(query);
//
//            pstmt.setString(1, "Samsung OLED TV");
//            pstmt.setDouble(2, 110000);
//            pstmt.addBatch();
//
//            pstmt.setString(1, "LG OLED TV");
//            pstmt.setDouble(2, 120000);
//            pstmt.addBatch();
//
//            pstmt.setString(1, "Sony OLED TV");
//            pstmt.setDouble(2, 130000);
//            pstmt.addBatch();

//            int count = pstmt.executeUpdate();
//            System.out.println(count + " product(s) inserted");

//            int count[] = pstmt.executeBatch();
//            System.out.println(count.length + " product(s) inserted");


            // UPDATE with Prepared Statement
//            query = "UPDATE PRODUCT SET price = ? WHERE PID = ?";
//            pstmt = conn.prepareStatement(query);
//            pstmt.setDouble(1, 50000.0);
//            pstmt.setInt(2, 1);
//            int uCount = pstmt.executeUpdate();
//            System.out.println(uCount + " product(s) updated");


            // DELETE with Prepared Statement
//            query = "DELETE FROM PRODUCT WHERE PID > ?";
//            pstmt = conn.prepareStatement(query);
//            pstmt.setInt(1, 5);
//            count = pstmt.executeUpdate();
//            System.out.println(count + " product(s) deleted");

//            CallableStatement cstmt = conn.prepareCall("CALL transfer(?,?,?)");
//            cstmt.setInt(1, 3);
//            cstmt.setInt(2, 4);
//            cstmt.setInt(3, 2000);
//            cstmt.execute();
//
//            System.out.println("Stored Procedure executed successfully");

//            conn.commit(); // commit transaction


            // STEP #4b: Execute (SELECT) Query
//             STEP 5: Obtain ResultSet
            rs = stmt.executeQuery("SELECT * FROM PRODUCT");

            // STEP 6: Iterate through and display the contents of ResultSEt
            while(rs.next()) {
                System.out.format("%d %s %f", rs.getInt("pid"), rs.getString("pname"), rs.getDouble("price"));
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                System.out.println("Error while rolling back. " + ex.getMessage());
            }
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // STEP 7: Close the resources
            try {
                if(rs != null) {
                    rs.close();
                }
                if(pstmt != null) {
                    pstmt.close();
                }
                if(stmt != null) {
                    stmt.close();
                }
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

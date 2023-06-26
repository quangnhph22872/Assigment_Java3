/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.ass.responsitory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author DELL
 */
public class DBcontext {
//     private static String USERNAME = "sa";
//    private static String PASSWORD ="soluong";
//    private static String URL = "jdbc:sqlserver://localhost:1433;databaseName=FPL_DaoTao;user=sa;password=123;encrypt=true;trustServerCertificate=true";
//            public static Connection getConnection(){
//        Connection cn = null;
//        try {
//            cn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        } catch (SQLException ex) {
//            Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return cn;
//    }
//    
//    
//    
//    public static void main(String[] args) throws SQLException {
//        
//        Connection cn = null;
//        cn = DriverManager.getConnection(URL);
//        
//        if (cn != null) {
//
//            System.out.println("ket noi thanh cong");
//String sql = "Select * from Users";
//            try (Statement stm = cn.createStatement()) {
//                ResultSet rs = stm.executeQuery(sql);
//                System.out.println(rs);
//                while (rs.next()) {
//                    //Retrieve by column name
//                    
//                    String username = rs.getString("USERNAME");
//                    String pas = rs.getString("PASSWORD");
//                    String role = rs.getString("ROLE");
//                    
//                    //String gg = rs.getString(1);//1: là cột thứ nhất trong bảng sql=> có thể đặt là tên cột
//                    
//                    
//                    
//                    
//                    //Display values
//                    System.out.print("\n Mã ngành: " + username);
//                    System.out.print("\n Tên ngành: " + pas);
//                    System.out.print("\n Tên ngành: " + role);
//                    
//                    //System.out.println(gg);
//                    
//                    
//                    
//                }
//                rs.close();
//            }
//            cn.close();
//        } else {
//            System.out.println("ket noi that bai");
//        }
//    }
}

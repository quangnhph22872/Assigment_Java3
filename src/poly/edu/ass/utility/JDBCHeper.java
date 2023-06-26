
package poly.edu.ass.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import poly.edu.ass.responsitory.DBcontext;


public class JDBCHeper {
//    public static ResultSet excuteQuery (String sql, Object ...args) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet= null;
//        
//        connection = DBcontext.getConnection();
//        try {
//            preparedStatement = connection.prepareStatement(sql);
//            
//            for (int i = 0; i < args.length; i++) {
//                preparedStatement.setObject(i+1, args[i]);
//                
//            }
//            resultSet = preparedStatement.executeQuery();
//        } catch (SQLException ex) {
//            Logger.getLogger(JDBCHeper.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return resultSet;
//    }
//    public static Integer excuteUpdate (String sql, Object ...args) {
//        Connection connection = null;
//        Integer row = 0;
//        PreparedStatement preparedStatement = null;
//        
//        connection = DBcontext.getConnection();
//        try {
//            preparedStatement = connection.prepareStatement(sql);
//            
//            for (int i = 0; i < args.length; i++) {
//                preparedStatement.setObject(i+1, args[i]);
//                
//            }
//            row = preparedStatement.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(JDBCHeper.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return row;
//    }
}

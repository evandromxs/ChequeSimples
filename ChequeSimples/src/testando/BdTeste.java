package testando;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BdTeste {
public static void main(String[] args) {
    try {
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/chequesimplesbdr", "root", "root");
        String consultaSql = "select * from bancos";
        Statement stmt = conn.createStatement();
        
        ResultSet resultSet = stmt.executeQuery(consultaSql);
        
        while(resultSet.next()){
            System.out.println(resultSet.getString("nome"));
        }
        
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
}
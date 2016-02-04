/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtest.Prueba2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jeisonOS
 */
public class DB_Controller {

    public ArrayList <String> getConsultaPalabras(String consulta) throws ClassNotFoundException, SQLException{
        
        
        
        ArrayList <String> palabras = new ArrayList<>();
        String db_URL = "jdbc:mysql://localhost/jarvixs";

        Connection conn = null;
        Statement stmt = null;

        Class.forName("com.mysql.jdbc.Driver");

        conn = DriverManager.getConnection(db_URL, "root", "root");

        stmt = conn.createStatement();
        String sql;
        sql = consulta;
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            
            palabras.add(rs.getString(1));
        }
        rs.close();
        stmt.close();
        conn.close();
        
        return palabras;
    }
    
}

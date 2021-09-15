package daointer;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDAO  {
    public static Connection connection() throws Exception {
//        Class.forName("com.mysql.cj.jdbc.Driver");
        //com.mysql.cj.jdbc.Driver s;

        String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";
        String password = "123456";
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }
}

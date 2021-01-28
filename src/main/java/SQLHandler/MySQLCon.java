package SQLHandler;

import java.sql.Connection;
import java.sql.DriverManager;


public class MySQLCon {

    static final String USER = "root";
    static final String PASS = "Hofweier1#";
    static String myUrl = "jdbc:mysql://localhost/mike";

    public static Connection con;

    public MySQLCon() {

        try {
            con = DriverManager.getConnection(myUrl, USER, PASS);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

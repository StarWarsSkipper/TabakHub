package SQLHandler;

import java.sql.Connection;
import java.sql.DriverManager;


public class MySQLCon {

    static final String USER = "root";
    static final String PASS = "$BV6WMWÜq(<tz!=zHgbvQQ~m"; //Jens Passwort: "Hofweier1#", Maxi Passwort: "$BV6WMWÜq(<tz!=zHgbvQQ~m"
    static String myUrl = "jdbc:mysql://localhost/mike";
    public String myUrl2 = "jdbc:mysql://localhost/mike?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=CET";

    public static Connection con;

    public void establishConnection() {

        try {
            con = DriverManager.getConnection(myUrl2, USER, PASS);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}

package SQLHandler;

import GuiHeader.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccsesData {


    static String myDriver = "org.gjt.mm.mysql.Driver";
    static Connection con = MySQLCon.con;
    static MySQLCon mysqlHandler = new MySQLCon();
    static JTable activeList;

    public String sqlDataTable = "tabak";

    public void readData(String suche, String bedingung) {

        try {
            //con = mysqlHandler.establishConnection();
            Statement stmt = con.createStatement();
            System.out.println("select " + suche + " from " + sqlDataTable + " " + bedingung);

            ResultSet rs = stmt.executeQuery("select " + suche + " from " + sqlDataTable + " " + bedingung);
            while (rs.next()) {


                System.out.println(rs.getInt(1) + " " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));

            }

        } catch (Exception e) {// Hallo Jens Müller, du stinkst!
            e.printStackTrace();
        }


    }

    public int addObj(String m, String n, String g, String r, String b) {
        int succsess = 1;
        String query = "insert into `mike`.`" + sqlDataTable + "` (`Marke`, `Name`, `Geschmack`, `Bewertung`, `Bestand`) VALUES ( ?, ?, ?, ?, ?)";

        try {
            //con = mysqlHandler.establishConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, m);
            ps.setString(2, n);
            ps.setString(3, g);
            ps.setString(4, r);
            ps.setString(5, b);
            succsess = ps.executeUpdate();


        } catch (Exception e) {
            System.out.println(e);
        }

        return succsess;
    }

    public void updateList(GUI g) {

        try {
            activeList = ((JTable) (((JScrollPane) GUI.tabbedPane1.getSelectedComponent()).getViewport()).getView());
            DefaultTableModel model = (DefaultTableModel) activeList.getModel();
            //con = mysqlHandler.establishConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from " + sqlDataTable);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void updateTable(int idValue, String m, String n, String g, String bw, String bs) {

        String query = "UPDATE `mike`.`" + sqlDataTable + "` SET `Marke` = " + m + " `Name` = " + n + "`Geschmack` = " + g + " `Bewertung` = " + bw + " `Bestand` = " + bs + " WHERE `idtabak` = " + idValue;

        try {
            //con = mysqlHandler.establishConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, m);
            ps.setString(2, n);
            ps.setString(3, g);
            ps.setString(4, bw);
            ps.setString(5, bs);
            ps.executeUpdate();


        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public int addObj(String t1, String t2, String t3, String t4, int v1, int v2, int v3, int v4, String etc, int bw) {
        int succsess = 1;
        String query = "insert into `mike`.`mix` (`Tabak 1`, `Tabak 2`, `Tabak 3`, `Tabak 4`, `Verhätnis 1`,`Verhältnis 2`, `Verhältnis 3`, `Verhältnis 4`, `Sonstiges`, `Bewertung`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        try {
            //con = mysqlHandler.establishConnection();
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println("1");
            ps.setString(1, t1);
            System.out.println("2");
            ps.setString(2, t2);
            System.out.println("3");
            ps.setString(3, t3);
            System.out.println("4");
            ps.setString(4, t4);
            System.out.println("5");
            ps.setInt(5, v1);
            System.out.println("6");
            ps.setInt(6, v2);
            System.out.println("7");
            ps.setInt(7, v3);
            System.out.println("8");
            ps.setInt(8, v4);
            System.out.println("9");
            ps.setString(9, etc);
            System.out.println("10");
            ps.setInt(10, bw);
            System.out.println("Finished");

            succsess = ps.executeUpdate();


        } catch (Exception e) {
            System.out.println(e);
        }

        return succsess;

    }
}




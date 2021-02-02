package SQLHandler;

import GuiHeader.GUI;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccsesData {


    static String myDriver = "org.gjt.mm.mysql.Driver";
    static Connection con = MySQLCon.con;

    public String sqlDataTable = "test";

    public void readData(String suche, String bedingung) {

        try {
            con = MySQLCon.con;
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
            con = MySQLCon.con;
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
            DefaultTableModel model = (DefaultTableModel) g.tabakTable.getModel();
            con = MySQLCon.con;
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
            con = MySQLCon.con;
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

}




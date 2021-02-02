
import GuiHeader.GUI;
import SQLHandler.AccsesData;
import SQLHandler.MySQLCon;

import javax.swing.*;


public class Main {

    public static String[] items = new String[3];
    public static String[] namen = {"Marke", "Name", "Geschmak"};
    public static int ratingItem = 0;
    public static int bestandItem;

    public static JTable table;

    public static void main(String[] args) {


        AccsesData ad = new AccsesData();

        MySQLCon con = new MySQLCon();

        GUI gRef = new GUI();

        gRef.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gRef.pack(); // <=========== PACK
        gRef.setVisible(true);


        







    }
}





















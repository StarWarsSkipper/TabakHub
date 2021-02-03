
import GuiHeader.GUI;
import MixGui.MixPopUp;
import SQLHandler.AccsesData;
import SQLHandler.MySQLCon;
import TabakGui.TabakPopUp;

import javax.swing.*;


public class Main {

    public static JTable table;

    public static AccsesData ad;
    public static MySQLCon msqlHandler;

    public static void main(String[] args) {


        new MySQLCon().establishConnection();

        ad = new AccsesData();


        GUI gRef = new GUI();

        gRef.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gRef.pack(); // <=========== PACK
        gRef.setVisible(true);

        //+ad.updateList(gRef);


    }
}





















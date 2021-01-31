/*
 * Created by JFormDesigner on Wed Jan 27 18:06:26 CET 2021
 */

package GuiHeader;

import GuiPopUp.PopUp;
import SQLHandler.AccsesData;
import SQLHandler.MySQLCon;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;

/**
 * @author Jens Bott
 */
public class GUI extends JFrame {

    static Connection con = MySQLCon.con;
    public AccsesData ad = new AccsesData();
    public String sqlDataTable = ad.sqlDataTable;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jens Bott
    public JScrollPane scrollPane1;
    public JTable objTable;
    public JTextField searchbar;
    public JButton searchButton;
    public JButton updateButton;
    public JButton addObjButton;

    //Verdammte scheiß Git
    {

    }

    {

    }

    public GUI() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jens Bott
        scrollPane1 = new JScrollPane();
        objTable = new JTable();
        searchbar = new JTextField();
        searchButton = new JButton();
        updateButton = new JButton();
        addObjButton = new JButton();

        DefaultTableModel model = (DefaultTableModel) objTable.getModel();
        model.addColumn("idTabak");
        model.addColumn("Marke");
        model.addColumn("Name");
        model.addColumn("Geschmack");
        model.addColumn("Bewertung");
        model.addColumn("Bestand");

        //======== this ========
        setResizable(false);
        setTitle("TabakHub");
        var contentPane = getContentPane();

        //======== searchBar ========
        searchbar.setToolTipText("Filter: `/Spalte Stichwort`");
        searchbar.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                textCommands(searchbar.getText());
            }
        });

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(objTable);
        }

        //---- searchButton ----
        searchButton.setText("L\u00f6schen");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEntry(searchbar.getText());
            }
        });

        //---- updateButton ----
        updateButton.setText("Aktualisieren");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                updateList("*", "");

            }
        });

        //---- addObjButton ----
        addObjButton.setText("Neu");
        addObjButton.setText("Neuer Tabak?");
        addObjButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PopUp pu = new PopUp();
                pu.pack(); // <=========== PACK
                pu.setVisible(true);
                updateList("*", "");

            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(updateButton)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(addObjButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(searchbar))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 627, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(searchbar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(searchButton)
                                                        .addComponent(updateButton))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(addObjButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(5, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void textCommands(String command) {

        if (command.contains(String.format("/id "))) {
            String keyword = command.substring(4);
            if (keyword.matches("[0-9]+") && "/id " != command.substring(3, 4)) {
                updateList("*", "where idtabak = " + keyword);
            }


        } else if (command.contains(String.format("/m "))) {

            String keyword = command.substring(3);
            if ("/m " != command.substring(2, 3)) {
                updateList("*", "where Marke like " + "'%" + keyword + "%'");
            }


        } else if (command.contains(String.format("/n "))) {

            String keyword = command.substring(3);
            if ("/n " != command.substring(2, 3)) {
                updateList("*", "where Name like " + "'%" + keyword + "%'");
            }

        } else if (command.contains(String.format("/g "))) {

            String keyword = command.substring(3);
            if ("/g " != command.substring(2, 3)) {
                updateList("*", "where Geschmack like " + "'%" + keyword + "%'");
            }

        } else if (command.contains(String.format("/bw "))) {

            String keyword = command.substring(4);
            if ("/bw " != command.substring(3, 4)) {
                updateList("*", "where Bewertung like " + "'%" + keyword + "%'");
            }

        } else if (command.contains(String.format("/be "))) {

            String keyword = command.substring(4);
            if ("/be " != command.substring(3, 4)) {
                updateList("*", "where Bestand like " + "'%" + keyword + "%'");
            }


      /*  } else if (command.contains(String.format("/delete"))) {
            String keyword = command.substring(9);
            if (keyword.matches("[0-9]+") && "/delete "  != command.substring(8,9)){
                deleteEntry(keyword);
            }*/



        } else if ("/" != command.substring(0, 1)) {
            updateList("*", "where name like '%" + command + "%' or Geschmack like '%" + command + "%'or Marke like'%" + command + "%' or Bewertung like '%" + command + "%' or Bestand like '%" + command + "%'");
        }
    }


    private void updateList(String suche, String bedignung) {
        try {

            DefaultTableModel model = (DefaultTableModel) objTable.getModel();
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }

            con = MySQLCon.con;
            Statement stmt = con.createStatement();
            //System.out.println("select " + suche + " from " + sqlDataTable + " " + bedignung);
            ResultSet rs = stmt.executeQuery("select " + suche + " from " + sqlDataTable + " " + bedignung);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public JTable resetTable(JTable jt) {
        return jt = new JTable();
    }

    private void deleteEntry(String idtabak){
        int succsess =1;
        String query = "DELETE from `mike`.`"+ sqlDataTable +"` where idtabak = "  + idtabak;
        try {
            con = MySQLCon.con;
            Statement stmt = con.createStatement();
            System.out.println(query);
            PreparedStatement ps = con.prepareStatement(query);
            succsess = ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
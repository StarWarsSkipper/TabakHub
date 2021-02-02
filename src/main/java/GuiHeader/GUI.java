/*
 * Created by JFormDesigner on Tue Feb 02 20:54:10 CET 2021
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
import java.util.Arrays;

/**
 * @author Jens Bott
 */
public class GUI extends JFrame {

    static Connection con = MySQLCon.con;
    static AccsesData ad = new AccsesData();
    static String sqlDataTable = ad.sqlDataTable;


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jens Bott
    public JMenuBar menuBar;
    public JMenu fileMenu;
    public JMenuItem exitItem;
    public JTextField searchbar;
    public JButton updateButton;
    public JButton deleteButton;
    public JButton saveButton;
    public JButton newObjButton;
    public JTabbedPane tabbedPane1;
    public JScrollPane mixPane;
    public JTable mixTable;
    public JScrollPane tabakPane;
    public JTable tabakTable;

    public GUI() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jens Bott
        menuBar = new JMenuBar();
        fileMenu = new JMenu();
        exitItem = new JMenuItem();
        searchbar = new JTextField();
        updateButton = new JButton();
        deleteButton = new JButton();
        saveButton = new JButton();
        newObjButton = new JButton();
        tabbedPane1 = new JTabbedPane();
        mixPane = new JScrollPane();
        mixTable = new JTable();
        tabakPane = new JScrollPane();
        tabakTable = new JTable();

        DefaultTableModel model = (DefaultTableModel) tabakTable.getModel();
        model.addColumn("idTabak");
        model.addColumn("Marke");
        model.addColumn("Name");
        model.addColumn("Geschmack");
        model.addColumn("Bewertung");
        model.addColumn("Bestand");

        //======== this ========
        var contentPane = getContentPane();
        setResizable(false);
        setTitle("TabakHub");

        //======== menuBar ========
        {

            //======== fileMenu ========
            {
                fileMenu.setText("Datei");

                //---- exitItem ----
                exitItem.setText("Beenden");
                exitItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
                fileMenu.add(exitItem);
            }
            menuBar.add(fileMenu);
        }
        setJMenuBar(menuBar);

        //---- searchbar ----
        searchbar.setToolTipText("/command {Stichwort})");
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

        //---- updateButton ----
        updateButton.setText("Aktualisieren");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                refreshList("*", "");
            }
        });

        //---- deleteButton ----
        deleteButton.setText("L\u00f6schen");
        deleteButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                int n = JOptionPane.showConfirmDialog(null, "Den Tabak mit der ID " + searchbar.getText() + " löschen ?", "Warnung", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                System.out.println(n);
                if (n == 0) {
                    deleteEntry(searchbar.getText());
                    refreshList("*", "");

                }

            }
        });

        //---- saveButton ----
        saveButton.setText("Speichern");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTable();

            }
        });


        //---- newObjButton ----
        newObjButton.setText("Hinzuf\u00fcgen");
        newObjButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PopUp pu = new PopUp();
                pu.pack(); // <=========== PACK
                pu.setVisible(true);
                refreshList("*", "");

            }
        });

        //======== tabbedPane1 ========
        {


            //======== tabakPane ========
            {
                tabakPane.setViewportView(tabakTable);
            }
            tabbedPane1.addTab("Tabak", tabakPane);

            //======== mixPane ========
            {
                mixPane.setViewportView(mixTable);
            }
            tabbedPane1.addTab("Mix", mixPane);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(searchbar, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                        .addComponent(updateButton, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(deleteButton, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(newObjButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 746, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(searchbar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(updateButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(deleteButton)
                                                        .addComponent(saveButton))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
                                                .addComponent(newObjButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void textCommands(String command) {

        if (command.contains(String.format("/id "))) {
            String keyword = command.substring(4);
            if (keyword.matches("[0-9]+") && "/id " != command.substring(3, 4)) {
                refreshList("*", "where idtabak = " + keyword);
            }


        } else if (command.contains(String.format("/m "))) {

            String keyword = command.substring(3);
            if ("/m " != command.substring(2, 3)) {
                refreshList("*", "where Marke like " + "'%" + keyword + "%'");
            }


        } else if (command.contains(String.format("/n "))) {

            String keyword = command.substring(3);
            if ("/n " != command.substring(2, 3)) {
                refreshList("*", "where Name like " + "'%" + keyword + "%'");
            }

        } else if (command.contains(String.format("/g "))) {

            String keyword = command.substring(3);
            if ("/g " != command.substring(2, 3)) {
                refreshList("*", "where Geschmack like " + "'%" + keyword + "%'");
            }

        } else if (command.contains(String.format("/bw "))) {

            String keyword = command.substring(4);
            if ("/bw " != command.substring(3, 4)) {
                refreshList("*", "where Bewertung like " + "'%" + keyword + "%'");
            }

        } else if (command.contains(String.format("/be "))) {

            String keyword = command.substring(4);
            if ("/be " != command.substring(3, 4)) {
                refreshList("*", "where Bestand like " + "'%" + keyword + "%'");
            }

        } else if ("/" != command.substring(0, 1)) {
            refreshList("*", "where name like '%" + command + "%' or Geschmack like '%" + command + "%'or Marke like'%" + command + "%' or Bewertung like '%" + command + "%' or Bestand like '%" + command + "%'");
        }
    }

    private void refreshList(String suche, String bedignung) {
            try {

                DefaultTableModel model = (DefaultTableModel) tabakTable.getModel();
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


        public void saveTable() {

            DefaultTableModel model = (DefaultTableModel) tabakTable.getModel();

            for (int y = 0; y < model.getRowCount(); y++) {
                String[] cache = new String[5];
                int id = -1;
                int laufvar = 0;
                for (int x = 1; x <= 5; x++) {
                    cache[x-1] = (String) model.getValueAt(y, x);
                   id = (int) model.getValueAt(y, 0);
                   laufvar++;
                }
                System.out.println(Arrays.toString(cache));
                updateSqlTable(id,cache);


            }

        }

        public void updateSqlTable(int id, String [] cache) {

            String query = "UPDATE `mike`.`test` SET `Marke` = ?, `Name` = ?, `Geschmack` = ?, `Bewertung` = ?, `Bestand` = ? WHERE `idtabak` = " + id;

            try {
                con = MySQLCon.con;
                PreparedStatement ps = con.prepareStatement(query);

                ps.setString(1, cache[0]);
                ps.setString(2, cache[1]);
                ps.setString(3, cache[2]);
                ps.setString(4, cache[3]);
                ps.setString(5, cache[4]);
                ps.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    private void deleteEntry(String idtabak) {

        String query = "DELETE from `mike`.` " + sqlDataTable + "` where idtabak = " + idtabak;
        try {
            con = MySQLCon.con;
            Statement stmt = con.createStatement();
            System.out.println(query);
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



        // JFormDesigner - End of variables declaration  //GEN-END:variables


}
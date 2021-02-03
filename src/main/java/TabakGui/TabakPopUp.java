/*
 * Created by JFormDesigner on Wed Jan 27 15:07:46 CET 2021
 */

package TabakGui;

import SQLHandler.AccsesData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Jens Bott
 */
public class TabakPopUp extends JFrame {
    static AccsesData ad = new AccsesData();
    public String sqlDataTable = ad.sqlDataTable;


    public TabakPopUp() {
        initComponents();
    }

    private void initComponents() {// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jens Bott
        scrollPane1 = new JScrollPane();
        newObjTable = new JTable();
        cancelButton = new JButton();
        addButton = new JButton();

        DefaultTableModel model = (DefaultTableModel) newObjTable.getModel();
        model.addColumn("Marke");
        model.addColumn("Name");
        model.addColumn("Geschmak");
        model.addColumn("Bewertung");
        model.addColumn("Bestand");

        model.addRow(new Object[]{" ", " ", " ", " ", " "});

        //======== this ========
        setResizable(false);
        var contentPane = getContentPane();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //setUndecorated(true);
        setAlwaysOnTop(true);
        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(newObjTable);
        }

        //---- cancelButton ----
        
        cancelButton.setText("Abbrechen");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TabakPopUp.super.dispose();
            }
        });

        //---- addButton ----
        addButton.setText("Hinzuf\u00fcgen");
        addButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                TabakPopUp.super.dispose();
            }
        });


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Write new data
                String[] valuesString = new String[5];
                for (int i = 0; i < 5; i++) {
                    valuesString[i] = (String) newObjTable.getModel().getValueAt(0, i);
                }
                int succsessful;
                succsessful = ad.addObj(valuesString[0], valuesString[1], valuesString[2], valuesString[3], valuesString[4]);
                TabakPopUp.super.dispose();
            }
        });


        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap(358, Short.MAX_VALUE)
                                .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addGap(357, 357, 357))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1)
                                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(addButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cancelButton)))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    
        
    // JFormDesigner - End of variables declaration  //GEN-END:variables
        // Generated using JFormDesigner Evaluation license - Jens Bott
        public JScrollPane scrollPane1;
        public JTable newObjTable;
        public JButton cancelButton;
        public JButton addButton;
}

/*
 * Created by JFormDesigner on Wed Feb 03 15:29:19 CET 2021
 */

package MixGui;

import SQLHandler.AccsesData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Maximilian Meier
 */
public class MixPopUp extends JFrame {
    static AccsesData ad = new AccsesData();
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Maximilian Meier
    private JScrollPane scrollPane1;
    private JTable newMixObj;
    private JButton cancleButton;
    private JButton addButton;

    public MixPopUp() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Maximilian Meier
        scrollPane1 = new JScrollPane();
        newMixObj = new JTable();
        cancleButton = new JButton();
        addButton = new JButton();


        DefaultTableModel model = (DefaultTableModel) newMixObj.getModel();
        model.addColumn("Tabak 1");
        model.addColumn("Tabak 2");
        model.addColumn("Tabak 3");
        model.addColumn("Tabak 4");
        model.addColumn("Verhältnis 1");
        model.addColumn("Verhältnis 2");
        model.addColumn("Verhältnis 3");
        model.addColumn("Verhältnis 4");
        model.addColumn("Sonstiges");
        model.addColumn("Bewertung");


        model.addRow(new Object[]{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "});

        //======== this ========
        setResizable(false);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(newMixObj);
        }

        //---- cancleButton ----
        cancleButton.setText("Abbrechen");
        cancleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MixPopUp.super.dispose();
            }
        });

        //---- addButton ----
        addButton.setText("Hinzuf\u00fcgen");
        addButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                MixPopUp.super.dispose();
            }
        });


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Write new data

                String[] valuesString = new String[10];
                int[] valuesInt = new int[4];

                String etcValue = "";
                int bwValue = 0;


                for (int i = 0; i <= 9; i++) {
                    valuesString[i] = (String) newMixObj.getModel().getValueAt(0, i);

                    System.out.println("a: '" + valuesString[i] + "'");

                }
                for (int i = 4; i <= 7; i++) {
                    valuesInt[i - 4] = Integer.parseInt(valuesString[i]);
                    System.out.println("b: " + valuesInt);
                }
                System.out.println(8);
                etcValue = valuesString[8];
                System.out.println(etcValue);
                bwValue = Integer.parseInt(valuesString[9]);
                System.out.println(bwValue);

                System.out.println("'" + valuesString[0] + "'");
                System.out.println("'" + valuesString[1] + "'");
                System.out.println("'" + valuesString[2] + "'");
                System.out.println("'" + valuesString[3] + "'");

                System.out.println("'" + valuesInt[0] + "'");
                System.out.println("'" + valuesInt[1] + "'");
                System.out.println("'" + valuesInt[2] + "'");
                System.out.println("'" + valuesInt[3] + "'");

                System.out.println("'" + etcValue + "'");
                System.out.println("'" + bwValue + "'");

                int succsessful;
                succsessful = ad.addObj(valuesString[0], valuesString[1], valuesString[2], valuesString[3], valuesInt[0], valuesInt[1], valuesInt[2], valuesInt[3], etcValue, bwValue);
                System.out.println("finished v.2");
                MixPopUp.super.dispose();


            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 1281, Short.MAX_VALUE)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(510, 510, 510)
                                                .addComponent(cancleButton, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(addButton, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 512, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancleButton)
                                        .addComponent(addButton))
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

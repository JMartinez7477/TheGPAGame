/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author S531745
 */
package gpagame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author s531745
 */
class GenderSet {
    static JFrame show;
    private JTextArea report = new JTextArea(8, 10);
    JCheckBoxMenuItem male = new JCheckBoxMenuItem("Male");
    JCheckBoxMenuItem female = new JCheckBoxMenuItem("Female");
    JCheckBoxMenuItem other = new JCheckBoxMenuItem("Other");
    ArrayList<ItemListener> listens = new ArrayList<ItemListener>();
    ArrayList<JCheckBoxMenuItem> boxes = new ArrayList<JCheckBoxMenuItem>();
    JPanel display = new JPanel();
    boolean good=false;
    boolean complete=false;
    boolean isMale;


    public GenderSet() {
        boxes.add(male);
        boxes.add(female);
        boxes.add(other);
        show = new JFrame();
        show.setTitle("Select Gender");
        show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        show.setVisible(true);
        show.setBackground(Color.LIGHT_GRAY);
        setGender();
        show.getContentPane().add(display, BorderLayout.NORTH);
        show.getContentPane().add(new JScrollPane(report), BorderLayout.CENTER);
        show.setBackground(Color.LIGHT_GRAY);
        report.setEditable(false);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton(new AbstractAction("Submit") {
            public void actionPerformed(ActionEvent e) {
                submitGender();
            }
        }));
        show.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        show.setSize(300, 250);
    }

    public void submitGender(){
        if(good) {
            boolean choseMale = boxes.get(0).getState();
            boolean choseFemale = boxes.get(1).getState();
            if(choseMale) {
                isMale = true;
            } else if (choseFemale) {
                isMale = false;
            }
            show.setVisible(false);
            complete=true;
        }
    }

    public void setGender() {
        for (int i = 0; i < boxes.size(); i++) {
            listens.add(new ItemListener() { public void itemStateChanged(ItemEvent e) {
                   check();
                }
            });
            boxes.get(i).addItemListener(listens.get(i));
            display.add(boxes.get(i));
        }
    }

    public void check () {
        boolean choseOther = boxes.get(2).getState();
        int numOfTotals = 0;
        for (int i = 0; i < 3; i++) {
            if(boxes.get(i).getState()) {
                numOfTotals++;
            }
        }

        if(numOfTotals>1) {
            report.setText("You can not be more than one gender");
            good=false;
        } else if(choseOther) {
            female.setState(true);
            other.setState(false);
            report.setText("You were set to female for being a pussy");
            good = true;
        } else {
            report.setText("Good to go");
            good = true;
        }

    }


}
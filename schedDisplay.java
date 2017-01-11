/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
class schedDisplay {
    static JFrame show;
    private JTextArea report = new JTextArea(8, 10);
    JCheckBoxMenuItem no = new JCheckBoxMenuItem("None");
    ArrayList<ItemListener> listens = new ArrayList<ItemListener>();
    ArrayList<JCheckBoxMenuItem> boxes = new ArrayList<JCheckBoxMenuItem>();
    JPanel display = new JPanel();
    boolean good=false;
    int index = -1;
    boolean complete=false;
    boolean extra=false;

    
    public schedDisplay() {
        for (int i = 0; i < Game.availableExtraCurricular.size(); i++) {
            boxes.add(new JCheckBoxMenuItem(Game.availableExtraCurricular.get(i).getName()));
        }
        boxes.add(no);
        show = new JFrame();
        show.setTitle("Select Extra Curriculars");
        show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        show.setVisible(true); 
        show.setBackground(Color.LIGHT_GRAY);
        setExtras();
        show.getContentPane().add(display, BorderLayout.NORTH);
        show.getContentPane().add(new JScrollPane(report), BorderLayout.CENTER);
        show.setBackground(Color.LIGHT_GRAY);
        report.setEditable(false);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton(new AbstractAction("Submit") {
            public void actionPerformed(ActionEvent e) {
                submitSched();
            }
        }));
        show.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        show.pack();      
    }

    public void submitSched(){
        if(good) {
            if(extra) {
                complete=true;
                System.out.println("\nYou have added " + Game.availableExtraCurricular.get(index).getName());
                show.setVisible(false);
            } else {
                complete=true;
                System.out.println("You did not take any extra curriculars");
                show.setVisible(false);
                index=-1;
            }
               
        }
    }

    public void setExtras() {
        for (int i = 0; i < boxes.size(); i++) {
            listens.add(new ItemListener() { public void itemStateChanged(ItemEvent e) {
                   check();
                }
            });
            boxes.get(i).addItemListener(listens.get(i));
            display.add(boxes.get(i));
        }
    }

    public boolean meetsRequirements(int index) {
        boolean ggood = true;
        if (Game.user.getIntelligence() < Game.availableExtraCurricular.get(index).getRequiredIntelligence()) {
            report.setText("Too low intelligence");
            ggood = false;
        } else if (Game.user.getSocialSkills() < Game.availableExtraCurricular.get(index).getRequiredSocialSkills()) {
            report.setText("Too low social skills");
            ggood = false;
        } else if (Game.user.getAthleticism() < Game.availableExtraCurricular.get(index).getRequiredAthleticism()) {
            report.setText("Too low athleticism");
            ggood = false;
        }
        return ggood;
    }

    public void check () {
        int length = boxes.size()-1;
        boolean[] array = new boolean[length];
        int numOfTotals = 0;
        for (int i = 0; i < length; i++) {
            array[i] = boxes.get(i).getState();
        }
        for (int i = 0; i < length; i++) {
            if(array[i]) {
                numOfTotals++;
                extra=true;
            }
        }
        if(boxes.get(length).getState()) {
            extra=false;
        }
        if(numOfTotals>1) {
            report.setText("Too many extra cirruculars");
            good=false;
        } else if (numOfTotals==1) {
            for (int i = 0; i < boxes.size(); i++) {
                boolean temp = boxes.get(i).getState();
                if(temp) {
                    index=i;
                }
            }
            if(extra) {
               boolean meet = meetsRequirements(index);
            if(!meet) {
                report.append("\nYou do not meet the requirements");
                good=false;
            } else {
                report.setText("Good to go ");
                good=true;
            }
            } else {
            report.setText("You are not taking any extra curriculars");
            good=true;
        }
            }   else {
            report.setText("You are not taking any extra curriculars");
            good=true;
        }
            

    }

}
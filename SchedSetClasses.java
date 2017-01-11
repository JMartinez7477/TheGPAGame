/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gpagame;

/**
 *
 * @author S531745
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
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
class SchedSetClasses {
    static JFrame show;
    private JTextArea report = new JTextArea(8, 10);
    ArrayList<ItemListener> listens = new ArrayList<ItemListener>();
    ArrayList<JCheckBoxMenuItem> boxes = new ArrayList<JCheckBoxMenuItem>();
    JPanel display = new JPanel();
    boolean good=false;
    boolean complete=false;
    int classesReq;
    int[] classNums;

    public SchedSetClasses(int num) {
        classesReq=num;
        classNums = new int[num];
        System.out.println("You need to take " + classesReq + " classes");
        for (int i = 0; i < Game.availableClasses.size(); i++) {
            boxes.add(new JCheckBoxMenuItem(Game.availableClasses.get(i).getName()));
        }
        show = new JFrame();
        show.setTitle("Select Classes");
        show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        show.setVisible(true);
        show.setBackground(Color.LIGHT_GRAY);
        setClasses();
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
            int numOfClasses = 0;
            int length = boxes.size();
            boolean[] array = new boolean[length];
            for (int i = 0; i < length; i++) {
            array[i] = boxes.get(i).getState();
                if(array[i]) {
                    classNums[numOfClasses++] = i;
                }
            }

          complete=true;
          show.setVisible(false);
        }
    }

    public void setClasses() {
        display.setLayout(new BoxLayout(display, BoxLayout.Y_AXIS));
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
        int length = boxes.size();
        boolean[] array = new boolean[length];
        int numOfTotals = 0;
        for (int i = 0; i < length; i++) {
            array[i] = boxes.get(i).getState();
        }
        for (int i = 0; i < length; i++) {
            if(array[i]) {
                numOfTotals++;
            }
        }
        
        if(numOfTotals>classesReq) {
            report.setText("Too many classes");
            good=false;
        } else if (numOfTotals==classesReq) {
            report.setText("Good to go ");
            good=true;
            
        } else {
            report.setText("You are not taking\nenough classes");
            good=false;
        }

    }

}
package gpagame;
//@author s531745

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

class Display{
    JFrame show = new JFrame();
    private JTextField iField = new JTextField("50", 3);
    private JTextField aField = new JTextField("50", 3);
    private JTextField sField = new JTextField("50", 3);
    private Document aText = aField.getDocument();
    private Document sText = sField.getDocument();
    private Document iText = iField.getDocument();
    private JTextArea report = new JTextArea(8, 10);
    boolean good = false;
    boolean complete=false;
    int intel = 0;
    int ath = 0;
    int soc = 0;

    public void showAttribs(boolean set) {
        try {
            int aAmount = Integer.parseInt(
                    aText.getText(0, aText.getLength()));
            int sAmount = Integer.parseInt(
                    sText.getText(0, sText.getLength()));
            int iAmount = Integer.parseInt(
                    iText.getText(0, iText.getLength()));
            int sum = aAmount + sAmount + iAmount;
            report.setText("Total is " + sum + ", you can go up to 150");
            if (sum > 150) {
                report.append("\nSum cannot exceed 150");
                good=false;
            } else if (aAmount > 100) {
                report.append("\nAthletic ability is too high. Max is 100");
                good=false;
            } else if (sAmount > 100) {
                report.append("\nSocial skills is too high. Max is 100");
                good=false;
            } else if (iAmount > 100) {
                report.append("\nIntelligence is too high. Max is 100");
                good=false;
            } else if (iAmount < 0 || sAmount < 0 || aAmount < 0) {
                report.append("\nAttributes can not be negative");
                good=false;
            } else {
                report.append("\nGood to go");
                good=true;
            }
            if(set&&good) {
                this.intel = iAmount;
                this.soc = sAmount;
                this.ath = aAmount;
                complete=true;
                show.setVisible(false);
            }
        } catch (NumberFormatException e) {
            report.setText("Not an integer or out of range");
            good=false;
        } catch (Exception e) {
            report.setText(e.toString());
            good=false;
        }
    }

    public Display() {
        show.setTitle("Attributes");
        //show.pack();
        show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        show.setVisible(true);
        JPanel display = new JPanel();
        //setting display
        display.add(new JLabel("Intelligence:"));
        display.add(iField);
        display.add(new JLabel("Athletic Ability:"));
        display.add(aField);
        display.add(new JLabel("Social Skills:"));
        display.add(sField);
        show.getContentPane().add(display, BorderLayout.NORTH);
        show.getContentPane().add(new JScrollPane(report), BorderLayout.CENTER);
        //show.pack();

        //color
        show.setBackground(Color.LIGHT_GRAY);
        report.setEditable(false);
        //listeners
        aText.addDocumentListener(new DocumentListener() {

            public void changedUpdate(DocumentEvent e) {
                showAttribs(false);
            }

            public void insertUpdate(DocumentEvent e) {
                showAttribs(false);
            }

            public void removeUpdate(DocumentEvent e) {
                showAttribs(false);
            }
        });
        sText.addDocumentListener(new DocumentListener() {

            public void changedUpdate(DocumentEvent e) {
                showAttribs(false);
            }

            public void insertUpdate(DocumentEvent e) {
                showAttribs(false);
            }

            public void removeUpdate(DocumentEvent e) {
                showAttribs(false);
            }
        });
        iText.addDocumentListener(new DocumentListener() {

            public void changedUpdate(DocumentEvent e) {
                showAttribs(false);
            }

            public void insertUpdate(DocumentEvent e) {
                showAttribs(false);
            }

            public void removeUpdate(DocumentEvent e) {
                showAttribs(false);
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton(new AbstractAction("Complete") {

            public void actionPerformed(ActionEvent e) {
                showAttribs(true);
            }
        }));
        show.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        show.pack();
    }
}
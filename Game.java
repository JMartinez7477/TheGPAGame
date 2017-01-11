/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gpagame;

import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author s531749
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<AvailableClass> availableClasses = new ArrayList<AvailableClass>();
    public static ArrayList<AvailableExtraCurricular> availableExtraCurricular = new ArrayList<AvailableExtraCurricular>();
    public static User user;

    public static void main(String[] args) {
        // TODO code application logic here
        goodIntro();
        createClasses();
        createExtraCurricular();
        System.out.println("Welcome to High School");
        doSemesters();
    }

    public static void doSemesters() {
        Semester one = new Semester();
        user.semseters.add(one);
        one.startSemester();
    }

    public static void goodIntro() {
        JFrame frame = new JFrame("Input Name");
        String fname = JOptionPane.showInputDialog(frame, "What's your first name?");
        String lname = JOptionPane.showInputDialog(frame, "What's your last name?");
        GenderSet gendisp = new GenderSet();
        boolean gengood = gendisp.complete;
        while(!gengood) {
        gengood = gendisp.complete;
        }
        boolean isMale = gendisp.isMale;
        Display aframe = new Display();
        boolean complete =aframe.complete;
        while (!complete){
            complete = aframe.complete;
        }
        int ath = aframe.ath;
        int intel = aframe.intel;
        int soc = aframe.soc;
        Game.user = new User(isMale, fname, lname);
        Game.user.setIntelligence(intel);
        Game.user.setSocialSkills(soc);
        Game.user.setAthleticism(ath);
    }



    public static void createClasses() {
        //first is class name, number is dificulty out of 5
        availableClasses.add(new AvailableClass("Math", 3));
        availableClasses.add(new AvailableClass("Advanced Math", 5));
        availableClasses.add(new AvailableClass("Science", 3));
        availableClasses.add(new AvailableClass("Advanced Science", 5));
        availableClasses.add(new AvailableClass("History", 3));
        availableClasses.add(new AvailableClass("Advanced History", 5));
        availableClasses.add(new AvailableClass("English", 3));
        availableClasses.add(new AvailableClass("Advanced English", 5));

        availableClasses.add(new AvailableClass("Health", 1));
        availableClasses.add(new AvailableClass("Computer Science", 4));
        availableClasses.add(new AvailableClass("AP Human Geography", 4));
        availableClasses.add(new AvailableClass("Floral Design", 1));

        availableClasses.add(new AvailableClass("Spanish 1", 3));
        availableClasses.add(new AvailableClass("Spanish 2", 3));
        

        
    }

    public static void createExtraCurricular() {
        //name, intelligence required, social skills required, athleticism required, class dificulty
        availableExtraCurricular.add(new AvailableExtraCurricular("Football", 1, 10, 1, 0));
        availableExtraCurricular.add(new AvailableExtraCurricular("Cross Country", 1, 10, 25, 0));
        availableExtraCurricular.add(new AvailableExtraCurricular("Band", 30, 15, 25, 4));
        availableExtraCurricular.add(new AvailableExtraCurricular("Choir", 60, 25, 0, 3));
    }
}

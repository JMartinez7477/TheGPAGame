/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gpagame;

import java.util.*;

/**
 *
 * @author s531749
 */
public class Semester {

    public static Scanner in = new Scanner(System.in);
    private int semesterGPA;
    private int weekNum;
    ArrayList<Class> classes = new ArrayList<Class>();
    boolean hasExtraCurricular;
    private int extraCurricularIndexNumber;
    ArrayList<SixWeeks> sixWeeks = new ArrayList<SixWeeks>();

    public Semester() {
    }

    public void startSemester() {
        schedDisplay disp = new schedDisplay();
        boolean comp = disp.complete;
        while(!comp) {
            comp=disp.complete;
        }
        int num=disp.index;
        hasExtraCurricular= disp.extra;
        if(hasExtraCurricular) {
            extraCurricularIndexNumber=num;
            createClasses(6);
        } else {
            createClasses(7);
            classes.add(null);
        }


    }

    public void createClasses(int numberOfClasses) {
        SchedSetClasses clas = new SchedSetClasses(numberOfClasses);
        boolean good = clas.complete;
        while(!good) {
            good=clas.complete;
        }
        int[] classNums = clas.classNums;
        for (int i = 0; i < numberOfClasses; i++) {
            int temp = classNums[i];
           // System.out.println("You took " + Game.availableClasses.get(temp).getName());
            classes.add(new Class(i+1, Game.availableClasses.get(temp).getName(), Game.availableClasses.get(temp).getDifficulty(), temp));
        }
        if(hasExtraCurricular) {
            int temp = extraCurricularIndexNumber;
            classes.add(new Class(7, Game.availableExtraCurricular.get(temp).getName(), Game.availableExtraCurricular.get(temp).getClassDificulty(), temp));
        }
        printSchedule();
        SixWeeks one = new SixWeeks(sixWeeks.size());
        sixWeeks.add(one);
        one.run();
    }


    public void printSchedule() {
        System.out.println("\nYour schedule: ");
        for (int i = 0; i < this.classes.size(); i++) {
            System.out.println(this.classes.get(i).getPeriod() + ": " + this.classes.get(i).getClassName());
        }
    }

    public int getSemesterGPA() {
        return semesterGPA;
    }

    public void setSemesterGPA(int semesterGPA) {
        this.semesterGPA = semesterGPA;
    }

    public int getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(int weekNum) {
        this.weekNum = weekNum;
    }
}

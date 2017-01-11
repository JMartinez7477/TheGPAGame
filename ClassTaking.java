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
public class ClassTaking {
    private String className;
    private int period;
    private int difficulty;
    private int classIndex;
    private int currentAverage;
    ArrayList<MinorGrade> minors = new ArrayList<MinorGrade>();
    ArrayList<TwoWeek> twoWeeks = new ArrayList<TwoWeek>();
    private int assignedMinor;
    private int completedMinor;
    private int sixWeekIndex;
    private int twoWeekIndex = 0;

    public ClassTaking (int period, String className, int difficulty, int classIndex, int sixWeekIndex) {
        this.period = period;
        this.className = className;
        this.difficulty = difficulty;
        this.classIndex = classIndex;
        this.sixWeekIndex =  sixWeekIndex;
    }

    public void createTwoWeek(){
        TwoWeek one = new TwoWeek(sixWeekIndex, twoWeekIndex, 0, this.difficulty);
        twoWeeks.add(one);
    }



     public int calculateMinorGrade(){
         this.assignedMinor = 0;
         this.completedMinor = 0;
         for (int i = 0; i < minors.size(); i++) {
             this.assignedMinor++;
             if(minors.get(i).isCompleted()){
                this.completedMinor++;
             }

         }
        return 0;
    }

    public int getClassIndex() {
        return classIndex;
    }

    public void setClassIndex(int classIndex) {
        this.classIndex = classIndex;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getCurrentAverage() {
        return currentAverage;
    }

    public void setCurrentAverage(int currentAverage) {
        this.currentAverage = currentAverage;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

     




}

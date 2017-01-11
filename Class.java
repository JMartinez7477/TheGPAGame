/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gpagame;

/**
 *
 * @author s531749
 */
public class Class {

    private int difficulty;
    private int classGPA;
    private String className;
    private int period;
    private int classIndex;
    
    public Class(int period, String className, int difficulty, int classIndex) {
        this.period = period;
        this.className = className;
        this.difficulty = difficulty;
        this.classIndex = classIndex;
        
    }


    public int getClassGPA() {
        return classGPA;
    }

    public void setClassGPA(int classGPA) {
        this.classGPA = classGPA;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getClassIndex() {
        return classIndex;
    }

    public void setClassIndex(int classIndex) {
        this.classIndex = classIndex;
    }


    
}
